FROM python:3-alpine 
WORKDIR /src
RUN apk add --no-cache g++ && \
    pip install --no-cache-dir numpy
COPY ./ .
CMD python /src/aoc.py
