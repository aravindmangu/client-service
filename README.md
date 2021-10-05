# Read Me
Client Service Application to handle client related data.

This is a springboot application.

Scenario:
Client-Service to perform Password Update

Approach:
I have adopted Open API 3 specifications based Contract-First approach to provide the required APIs.
APIs can be accessed through Swagger-UI in any web-browser.

Docker
# build docker image
docker build --tag=client-service:1 .

# run docker
docker run -d --name client-service -p 8080:8090 client-service:1

# Access Swagger-UI
http://localhost:8080/swagger-ui/index.html
