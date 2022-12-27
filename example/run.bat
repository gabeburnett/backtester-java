docker build -t algo-example .
docker run --rm -i algo-example:latest ws://host.docker.internal:%1 %2
docker image rm algo-example