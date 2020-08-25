# spring-boot-event-sourcing
> AXON server를 이용한 event sourcing sample 입니다. 상품 정보를 등록/수정 및 질의하는 api를 axon 과 spring-boot로 구현하였습니다.

## Main dependency
- axon-spring-boot-starter
- spring-boot-starter-actuator
- spring-boot-starter-data-jpa
- spring-boot-starter-webflux

## Before start
### 1. Docker container start
```
$ docker-compose up -d

Creating mysql      ... done
Creating axonserver ... done
```

### 2. Create tables
```
create table product (
    product_id int(10) unsigned not null primary key auto_increment,
    sale_price decimal(20,4) unsigned not null,
    consumer_price decimal(20,4) unsigned not null
) DEFAULT CHARSET=utf8;

create table token_entry (
    processor_name varchar(255) not null,
    segment int(10) unsigned not null,
    owner varchar(255) default null,
    timestamp varchar(255) not null,
    token blob default null,
    token_type varchar(255) default null,
    PRIMARY KEY (processor_name, segment)
) DEFAULT CHARSET=utf8;

create table saga_entry (
    saga_id varchar(255) primary key not null,
    revision varchar(255) default null,
    saga_type varchar(255) default null,
    serialized_saga blob default null
) DEFAULT CHARSET=utf8;
```

## Swagger
- http://localhost:8080/swagger-ui/index.html
