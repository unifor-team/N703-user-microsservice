# N703 - User microsservice

## Installation

Make the repository clone on your workspace

```
$ git clone https://github.com/unifor-team/N703-user-microsservice.git
```
Then

```
$ cd N703-user-microsservice
```

## Microsservice User Application Structure 
```
.
|────src/
| |────main/
| | |────java/
| | | |────com.user.ms_user/
| | | | |────configs/
| | | | |────controller/
| | | | |────dto/
| | | | |────models/
| | | | |────producers/
| | | | |────repository/
| | | | |────service
| | | | |────UserApplication
| | |────resources/
| | | |────application.properties
| |────test/
|──────.gitignore
|──────Dockerfile
|──────mvnw
|──────mvnw.cmd
|──────pom.xml
```


## Run app local

#### Example

```
mvn spring-boot:run
```

# Endpoins

## users

### Request
         /users (GET)
         /users (POST)
### Response
### GET
    [{
        "userId": string,
        "name": string,
        "email": string
    }]
### POST
     [{
        "name": string,
        "email": string
    }]

# Production URL
```
https://n703-user-microsservice.onrender.com
```
