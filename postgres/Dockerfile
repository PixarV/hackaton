FROM postgres:9.6
 
RUN mkdir -p "$PGDATA" && chmod 700 "$PGDATA"
COPY docker-entrypoint-initdb.d/* /docker-entrypoint-initdb.d/
