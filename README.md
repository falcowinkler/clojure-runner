## clojure-runner

Container image for clojure used by CodeRunner.

### Usage

Build:

```bash
docker build -t codewars-clojure-runner .
```

Run:

```bash
./bin/run.sh <example-name>
```

### Examples

- `multiply`: Correct implementation with fixed tests.
- `multiply-failing`: Correct implementation with failing tests.
- `syntax-error`: Solution with a syntax error.
