# catalogue

Helidon MP application that uses JPA with an in-memory H2 database.

## Build and run

With JDK21

```bash
mvn package
java -jar target/catalogue.jar
```

## Exercise the application

TODO

## Building the Docker Image

```bash
docker build -t catalogue .
```

## Running the Docker Image

```bash
docker run --rm -p 8080:8080 catalogue:latest
```

Exercise the application as described above.
