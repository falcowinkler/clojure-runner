FROM clojure:latest

RUN set -ex; \
    useradd -m codewarrior; \
    mkdir -p /workspace/src/codewars; \
    mkdir -p /workspace/test/codewars; \
    chown -R codewarrior: /workspace;

COPY workspace /workspace

WORKDIR /workspace

RUN lein deps
