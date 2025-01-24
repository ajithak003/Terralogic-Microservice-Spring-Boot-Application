# Terralogic-Microservice-Spring-Boot-Application

## Discovery Service 
* Using to register microservice applications.

## Authentication Service
* Using Spring Security JWT(Json Web Token) to authenticate user credentials.
* Provide login feature to generate JWT Token.
* Login Sample Json 
*  {
    "username":"Ajith123",
    "password":"Ajith@123"
    }
* URL : http://localhost:8080/auth/login   -- Get Mapping.

## API Gateway
* Routing variours service request and authenticate / validate JWT token.

## User Service
* Provide User Register, User details update and get all user details features.
* URL - http://localhost:8080/api/user/users - Get Maapping - Bearer Token Required.
* URL - http://localhost:8080/api/user/saveorupdate -- Post Mapping.
* sample Save Or Update JSON
 * {
    "username": "Ajith123",
    "firstname": "Ajith",
    "middlename": "",
    "lastname": "Kumar",
    "password": "Ajith@123",
    "email": "ajith@gmail.com",
    "contact": 9876543210,
    "expirationDate": "2025-01-24 15:30:45.123",
    "description": "A sample user description",
    "timeout": 30,
    "datetimeFormat": "2025-01-24 15:30:45.123",
    "roles": "USER",
    "scopes": "read,write",
    "primaryGroupName": "GroupA",
    "secondaryGroupName": "GroupB",
    "language": "English",
    "organization": "Terralogic",
    "timeZone": "UTC",
    "memo": "This is a sample memo for the user."
    }
