#!/usr/bin/env bash

docker run \
-it \
--rm \
-m512M \
--cpus 2 \
-p 8080:8080 \
-e GOODREADS_API_KEY \
-e GOODREADS_USER_ID \
-e GOOGLEBOOKS_API_KEY \
-e DATABASE_USER \
-e DATABASE_PASSWORD \
stasbar-app
