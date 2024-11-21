# Task Management Application

## Overview
This is a Task Management application built using Spring Boot. It provides APIs to manage tasks efficiently.

## Features
- User management
- Task creation, update, and deletion
- Task assignment to users
- Task status tracking

## Technologies Used
- Java
- Spring Boot
- Maven
- Jakarta Servlet
- Jackson for JSON processing

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6.0 or higher

### Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/fab-ryan/task-management.git
    ```
2. Navigate to the project directory:
    ```sh
    cd task-management
    ```
3. Build the project using Maven:
    ```sh
    mvn clean install
    ```

### Running the Application
1. Run the Spring Boot application:
    ```sh
    mvn spring-boot:run
    ```
2. The application will start on `http://localhost:5500/api/v1`.
****
## API Endpoints

### User Endpoints
- **GET /user**: Welcome message for the user.

### Example Request
```sh
curl -X GET http://localhost:5500/api/v1/user
{
  "message": "Welcome to Task Management Application",
  "data": "User Fetched well",
  "status": true,
  "httpStatus": "OK",
  "date": "2023-10-01T12:00:00",
  "url": "http://localhost:5500/api/v1/user"
}
```
### Contributing
Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

