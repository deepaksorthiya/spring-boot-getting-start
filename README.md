<h1 style="text-align: center;">Spring Boot Starter Project</h1>

<p style="text-align: center;">
  <a href="https://github.com/deepaksorthiya/spring-boot-getting-start/actions/workflows/maven-jvm-non-native-build.yml">
    <img src="https://img.shields.io/github/actions/workflow/status/deepaksorthiya/spring-boot-getting-start/maven-jvm-non-native-build.yml?style=for-the-badge&label=JVM%20Maven%20Build" alt="JVM Maven Build"/>
  </a>  
  <a href="https://github.com/deepaksorthiya/spring-boot-getting-start/actions/workflows/maven-graalvm-native-build.yml">
    <img src="https://img.shields.io/github/actions/workflow/status/deepaksorthiya/spring-boot-getting-start/maven-graalvm-native-build.yml?style=for-the-badge&label=GraalVM%20Maven%20Build" alt="GraalVM Maven Build"/>
  </a>
  <a href="https://hub.docker.com/r/deepaksorthiya/spring-boot-getting-start">
    <img src="https://img.shields.io/docker/pulls/deepaksorthiya/spring-boot-getting-start?style=for-the-badge" alt="Docker"/>
  </a>
  <a href="https://spring.io/projects/spring-boot">
    <img src="https://img.shields.io/badge/spring--boot-3.5.16-brightgreen?logo=springboot&style=for-the-badge" alt="Spring Boot"/>
  </a>
</p>

## Live Demo

TBD

---

## 📑 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Requirements](#-requirements)
- [Getting Started](#-getting-started)
    - [Clone the Repository](#1-clone-the-repository)
    - [Start Docker](#2-start-docker)
    - [Build the Project](#3-build-the-project)
    - [Run Project Locally](#4-run-the-project)
    - [Build Docker Image](#5-optional-build-docker-image-docker-should-be-running)
    - [Run Docker Image](#6-optional-running-on-docker)
    - [Deploy on Kubernetes with Helm](#7-optionalrun-on-local-minikube-kubernetes-using-helm-chart)
- [Testing](#-testing)
- [Clean Up](#-cleanup)
- [Reference Documentation](#-reference-documentation)

---

## 🚀 Overview

A modern **Spring Boot** starter project with REST API, JPA, Actuator, Docker, and Kubernetes Helm support.

---

## 🚀 Features

- RESTful API with CRUD endpoints
- Spring Data JPA (H2 in-memory DB)
- Actuator endpoints enabled
- Docker & multi-stage build
- Kubernetes manifests & Helm chart
- GitHub Actions CI/CD

---

## 📦 Requirements

- Git `2.51+`
- Java `25`
- Maven `3.10+`
- Spring Boot `3.5.16`
- (Optional)Docker Desktop (tested on `4.50+`)
- (Optional) Minikube/Helm for Kubernetes

---

## 🛠️ Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/deepaksorthiya/spring-boot-getting-start.git
cd spring-boot-getting-start
```

### 2. Start Docker

* this command will start all required services to start application

```bash
docker compose up
```

### 3. Build the Project

```bash
./mvnw clean package -DskipTests
```

* OR for native build run

```bash
./mvnw clean native:compile -Pnative
```

### 4. Run the Project

```bash
./mvnw spring-boot:run
```

* OR Jar file

```bash
java -jar .\target\spring-boot-getting-start-0.0.1-SNAPSHOT.jar
```

* OR Run native image directly

```bash
target/spring-boot-getting-start
```

### 5. (Optional) Build Docker Image (docker should be running)

```bash
./mvnw clean spring-boot:build-image -DskipTests
```

* OR To create the native container image, run the following goal:

```bash
./mvnw clean spring-boot:build-image -Pnative -DskipTests
```

* OR using dockerfile

```bash
docker build --progress=plain --no-cache -f <dockerfile> -t deepaksorthiya/spring-boot-getting-start .
```

* OR Build Using Local Fat Jar In Path ``target/spring-boot-getting-start-0.0.1-SNAPSHOT.jar``

```bash
docker build --build-arg JAR_FILE=target/spring-boot-getting-start-0.0.1-SNAPSHOT.jar -f Dockerfile.jvm --no-cache --progress=plain -t deepaksorthiya/spring-boot-getting-start .
```

* OR if above not work try below command

***you should be in jar file path to work build args***

```bash
cd target
docker build --build-arg JAR_FILE=spring-boot-getting-start-0.0.1-SNAPSHOT.jar -f ./../Dockerfile.jvm --no-cache --progress=plain -t deepaksorthiya/spring-boot-getting-start .
```

| Dockerfile Name                                    |                         Description                          |
|----------------------------------------------------|:------------------------------------------------------------:|    
| [Dockerfile](Dockerfile)                           | multi stage docker file with Spring AOT and JDK24+ AOT Cache |
| [Dockerfile.native-multi](Dockerfile.native-multi) |   multi stage using graalvm native image micro linux image   |

### 6. (Optional) Running On Docker

```bash
docker run -p 8080:8080 --name spring-boot-getting-start deepaksorthiya/spring-boot-getting-start:latest
```

### 7. (Optional)Run on Local minikube Kubernetes using Helm Chart

```bash
cd helm
helm create spring-boot-getting-start
helm lint spring-boot-getting-start
helm install spring-boot-getting-start --values=spring-boot-getting-start/values.yaml spring-boot-getting-start
helm install spring-boot-getting-start spring-boot-getting-start
helm uninstall spring-boot-getting-start
```

---

## 🧪 Testing

- Access the API: [http://localhost:8080](http://localhost:8080)
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

### Postman API Collection

TBD

### Rest API Endpoints

TBD

### Run Unit-Integration Test Cases

```bash
./mvnw clean test
```

To run your existing tests in a native image, run the following goal:

```bash
./mvnw test -PnativeTest
```

---

## 🧹 Cleanup

```bash
docker compose down -v
```

---

## 📚 Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/maven-plugin)
- [Create an OCI image](https://docs.spring.io/spring-boot/maven-plugin/build-image.html)
- [Spring Boot Actuator](https://docs.spring.io/spring-boot/reference/actuator/index.html)
- [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)
- [Spring Data JPA](https://docs.spring.io/spring-boot/reference/data/sql.html#data.sql.jpa-and-spring-data)
- [Validation](https://docs.spring.io/spring-boot//io/validation.html)
- [Flyway Migration](https://docs.spring.io/spring-boot/how-to/data-initialization.html#howto.data-initialization.migration-tool.flyway)

---

<p style="text-align: center;">
  <b>Happy Coding!</b> 🚀
</p>
