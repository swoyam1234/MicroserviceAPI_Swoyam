
# MicroserviceAPI_Swoyam”

This is a Restful Microservice API Project for company and teams based on java 17, spring MVC, Spring Boot, JPA, Hibernate etc. This API also have the JWT authentication implemented. Make sure you have Java 17 and MySQL server installed.


## prerequisite

- Java 17
- MySQL 8 DB
- Java supported IDE
- In order to test Api install applications like postman,Insomnia etc


## Project Setup for Run

- MySQL server should be up and running.

- Create three schema named "company_service", "team_service", "user_service".

- Open the file "application.properties" in all microservices.

- Edit your MySQL credentials in the fields "spring.datasource.username" and "spring.datasource.password" in order to connect to MySQL DB.

- Then run the project.

- In authentication the ADMIN role given to the username is "SwoyamSekharSahoo" and the password is "Swoyam1234"
## API Reference

#### Save a company

```http
  POST /company/
```
#### Get company by Id

```http
  Get /company/id/{id}
```
#### Get company by Name

```http
  Get /company/name/{name}
```
#### Save a Team

```http
  POST /team/
```
#### Get all teams with there company

```http
  Get /team/allteam
```
#### Resister your username and password to generate token

```http
  POST /resister
```
#### Generate token

```http
  POST /generate-token
```

#### JSON Format for save a compay

{
    "companyName":"Google",
    "companyCEO":"Shibu Ballav",
    "companyAddress":"Odisha",
    "inceptionDate":"1999-12-29"
}

#### JSON Format for save a team

{
    "companyId":5,
    "teamLeadName":"Vishal Tigga"
}

#### JSON Format for resister a username

{
    "userName":"rahul",
    "password":"rahul1234"
}

#### JSON Format for generate a token

{
    "userName":"SwoyamSekharSahoo",
    "password":"Swoyam1234"
}





