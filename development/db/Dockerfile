FROM postgres:12-alpine

# Environment variables
#ARG POSTGRES_URL
#ARG POSTGRES_DATABASE
#ARG POSTGRES_USER
#ARG POSTGRES_PASSWORD

COPY ./create_users.sh   /docker-entrypoint-initdb.d/10-create_users.sh
COPY ./create_dbs.sh     /docker-entrypoint-initdb.d/20-create_dbs.sh

RUN sed -i -e 's/\r$//' /docker-entrypoint-initdb.d/10-create_users.sh && \
    sed -i -e 's/\r$//' /docker-entrypoint-initdb.d/20-create_dbs.sh
