# spring-boot-event-sourcing
AXON server를 이용한 event sourcing sample 입니다. 상품 정보를 등록/수정 및 조회하는 api를 Axon framework와 Spring boot로 구현하였습니다.

## Main dependency
- axon-spring-boot-starter
- spring-boot-starter-actuator
- spring-boot-starter-data-jpa
- spring-boot-starter-webflux

## Before start
### Docker container start
```
$ docker-compose up -d

Creating mysql      ... done
Creating axonserver ... done
```

## Axon
- http://localhost:8024

## Swagger
- http://localhost:8080/swagger-ui/index.html

## Project structure
```
├── aggregates
├── commands
├── configs
├── domain
├── events
├── exceptions
├── handlers
├── queries
├── rest
└── services
```
