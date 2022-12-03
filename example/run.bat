docker build -t algo-example .
docker run --rm -it algo-example:latest %1 %2
docker image rm algo-example