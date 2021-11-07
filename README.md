# Appline - Project Back End Development

Appline is a back-end application made using [Spring Boot](https://spring.io/). Both the Spring application and the PostgreSQL database can be ran in a Dockerized container.

<br>

## Cloud Deployment
The Spring Boot application is ran in a Dockerized environment using Heroku's free hosting services, which can be accessed with the following link:
https://prbed-team-dit-app.herokuapp.com/

## Documentation

All documentation can be found on the [Wiki](https://github.com/huict/prbed-2122-v2c-teamdit/wiki).

Swagger-link: http://localhost:8080/swagger-ui/#/

## Tests

Appline is being tested using [Postman](https://www.postman.com/).  
Tests can be found in [here](../development/postman).

<br>

## Project Setup
1. Clone the project using your prefered git tool.  
<br>
2. Copy `example.env` and paste it as `.env`. Do not delete example.env, this is required for deployment.  
<br>
3. In your IDE's run configurations, point the environment variables to the `.env` file or if necessary, insert the variables into your run config manually.  
<br>
4. Run maven package  
![image](https://i.imgur.com/2pTRQnp.png)  
<br>
5. Run the application with `docker-compose up` to deploy the application
   1. Add `db` or `api` at the end of the line to only compose one of these services  
<br>
6. Tip: Run `docker-compose up db`, and then run the Spring Boot application through Intellij during development for faster and easier testing