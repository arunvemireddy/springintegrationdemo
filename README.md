# springintegrationdemo

This project demonstrates the use of Spring Integration in a simple order processing application. It showcases how to use Spring's messaging and event-driven architecture to handle business logic in a modular and decoupled way.

## Features
- REST API for order creation and management
- Gateway pattern for message routing
- Service layer for business logic
- Model classes for domain representation

## Structure
- `controller/OrderController.java`: Handles HTTP requests for orders
- `gateway/OrderGateway.java`: Defines messaging gateway for order events
- `model/Order.java`: Represents the order entity
- `service/OrderService.java`: Contains business logic and event publishing
- `resources/application.properties`: Application configuration

## How it works
1. A client sends an order request to the REST API.
2. The controller delegates to the service layer.
3. The service processes the order and publishes an event.
4. Event listeners react to the published event and perform further actions.

## Technologies Used
- Spring Boot
- Spring Integration
- Maven

## Getting Started
1. Build the project: `./mvnw clean install`
2. Run the application: `./mvnw spring-boot:run`
3. Access the API at `http://localhost:8080`

## Purpose

This demo is intended for learning and experimenting with Spring Integration concepts, event-driven design, and modular application architecture.
