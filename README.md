# RepoDeWS

A simple Web Service (SOAP) developed using Spring Boot.

[:construction:]

The tool uses an in-memory (runtime) temporary H2 database to store sample data for demos. The H2 console is accessible from [`https://localhost:8443/h2-console`](https://localhost:8443/h2-console) and use `admin` as password. 

> **NOTE: All defined service operations are fronted by Basic Authentication.** Please refer [Operations section](#operations)

## Web Service

### Models

This sample WS contains the following models and supports CRUD operations on them

* Developer
  * addDeveloper
  * getDeveloper
  * deleteDeveloper
* Repo
  * getRepo

### WSDL

Access WSDL definition by navigating to the following link

```http
https://localhost:8443/ws/developers.wsdl
```

### Operations

The operations are fronted by a Basic Authentication. Use the following credentials when working with the listed dev-service (web service) operations

* username: `hydrogen`
* password: `pandaAsthma`

#### Developer

##### Add Developer

```xml
<addDeveloper>
    <username>johndoe</username>
    <name>John Doe</name>
    <email>john@doe.com</email>
</addDeveloper>
```

##### Get Developer

```xml
<getDeveloper>
    <username>johndoe</username>
</getDeveloper>
```

##### Delete Developer

```xml
<deleteDeveloper>
    <username>johndoe</username>
</deleteDeveloper>
```

#### Repo

##### Get Repo

```xml
<getRepo>
    <username>johndoe</username>
</getRepo>
```

[:construction:]

## Build & Run

Execute the following command from the root folder to fire up the web service (spring-boot)

> If you dont have maven installed, use the second listed command

```shell
mvn spring-boot:run
```

Use the following command if you dont have maven installed

```shell
.\mvnw spring-boot:run
```
