#!/usr/bin/env bash

set -e

# Build the project and docker images
#./gradlew bootJar

ip=$(ip route get 8.8.4.4 | head -1 | awk '{print $7}')
export HOST_IP=${ip}

# Remove existing containers
docker-compose stop
docker-compose rm -f

docker-compose build --no-cache

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

# Start the other containers
docker-compose up -d
