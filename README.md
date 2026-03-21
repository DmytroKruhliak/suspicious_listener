!# Suspicious Listener

A simple Spring Boot REST application built with Java 17 and Maven.

## Overview
`suspicious-listener` is a minimal web application that exposes a few mock "suspicious" REST endpoints. It utilizes Spring Web MVC and Lombok to deliver JSON responses.

## Endpoints

- `GET /suspicious`
  Returns a base suspicious response message.
  
- `GET /suspicious/info`
  Returns additional suspicious information.

## Tech Stack
- **Java:** 17
- **Framework:** Spring Boot 4.0.x
- **Build Tool:** Maven
- **Libraries:** Lombok, Spring Web MVC

## Getting Started

### Prerequisites
- JDK 17 or higher

### Running the Application

To run the application locally, you can use the provided Maven Wrapper:

**Linux / macOS:**
```bash
./mvnw spring-boot:run
```

**Windows:**
```cmd
mvnw.cmd spring-boot:run
```

### Building the Project

To build the executable JAR file in the `target/` directory:

**Linux / macOS:**
```bash
./mvnw clean package
```

**Windows:**
```cmd
mvnw.cmd clean package
```
