FROM clojure:latest

RUN set -ex; \
    useradd -m codewarrior; \
    mkdir /workspace; \
    chown -R codewarrior: /workspace;

COPY workspace /workspace

WORKDIR /workspace

RUN lein deps
