#!/bin/bash

CONTAINER_NAME=android-builder
IMAGE_NAME=android-jdk21

docker run --rm -d \
  --name $CONTAINER_NAME \
  -v "$(pwd):/project" \
  -w /project \
  $IMAGE_NAME \
  sleep infinity

docker exec $CONTAINER_NAME sh -c "
echo 'sdk.dir=/opt/android-sdk' > local.properties &&
sed -i 's/\r$//' gradlew &&
chmod +x gradlew &&
./gradlew app:clean --no-daemon
"

docker stop $CONTAINER_NAME