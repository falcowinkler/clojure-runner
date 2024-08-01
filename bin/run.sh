#!/bin/bash
set -eux

if [ -z "${CONTAINER_ENGINE:+x}" ]; then
    CONTAINER_ENGINE=docker
fi

if [ -z "${IMAGE_TAG:+x}" ]; then
    IMAGE_TAG=codewars-clojure-runner:latest
fi

W=/workspace

C=$($CONTAINER_ENGINE container create --rm $IMAGE_TAG sh -c "lein run -m main")

$CONTAINER_ENGINE container cp examples/${1:-multiply}/solution.clj $C:$W/src/codewars/
$CONTAINER_ENGINE container cp examples/${1:-multiply}/solution_test.clj $C:$W/test/codewars/

# Run tests
$CONTAINER_ENGINE container start --attach $C
