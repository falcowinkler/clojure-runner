#!/bin/bash
set -eu

if [ -z "${CONTAINER_ENGINE:+x}" ]; then
    CONTAINER_ENGINE=docker
fi

if [ -z "${IMAGE_TAG:+x}" ]; then
    IMAGE_TAG=ghcr.io/codewars/riscv:latest
fi

W=/workspace

FILES="solution.clj solution_tests.clj codewars_reporter.clj tests.clj"

C=$($CONTAINER_ENGINE container create --rm $IMAGE_TAG sh -c "gcc $CFLAGS $FILES $LIBS -o tests && ./tests")

