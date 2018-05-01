# spring-boot-docker

Really simple Spring Boot RESTful web service with a Dockerfile and accompanying Cucumber tests.

https://hub.docker.com/r/domjackson1/spring-boot-docker

## Run Locally
### Build
```sh
$ ./gradlew build
```

## Run application
```sh
$ ./gradlew bootRun
```

## Run Cucumber tests
```sh
$ ./gradlew cucumber
```


## Build Docker image
```sh
$ ./gradlew build docker
```
