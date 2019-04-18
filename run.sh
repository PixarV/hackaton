#!/usr/bin/env bash

set -e

# Build the project and docker images
./gradlew bootJar

ip=$(ip route get 8.8.4.4 | head -1 | awk '{print $7}')
export HOST_IP=${ip}

# Remove existing containers
docker-compose stop
docker-compose rm -f

docker-compose build --no-cache

# Start the config service first and wait for it to become available
docker-compose up -d config_service

while [[ -z ${CONFIG_SERVICE_READY} ]]; do
  echo "Waiting for config service..."
  if [[ "$(curl ${HOST_IP}:8081/actuator/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]]; then
    CONFIG_SERVICE_READY=true;
    echo "config service ready"
  fi
  sleep 5
done

# Start the discovery service next and wait
docker-compose up -d discovery_service

while [[ -z ${DISCOVERY_SERVICE_READY} ]]; do
  echo "Waiting for discovery service..."
  if [[ "$(curl ${HOST_IP}:8082/actuator/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]]; then
    DISCOVERY_SERVICE_READY=true;
    echo "discovery service ready"
  fi
  sleep 5
done

# Start the gateway service next and wait
docker-compose up -d gateway_service

while [[ -z ${GATEWAY_SERVICE_READY} ]]; do
  echo "Waiting for gateway service..."

  attempts=0
  while [[ "$attempts" -lt 5 ]]; do
    if [[ "$(curl ${HOST_IP}:8080/actuator/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]]; then
      GATEWAY_SERVICE_READY=true;
      echo "gateway service ready"
      break
    else
      attempts=$((attempts + 1))
      sleep 5
    fi
  done

  if [[ -z ${GATEWAY_SERVICE_READY} ]]; then
    echo "restart gateway_service"
    docker-compose stop gateway_service
    docker-compose rm -f gateway_service
    docker-compose up -d gateway_service
  fi
  sleep 5
done

# Start the other containers
docker-compose up -d
