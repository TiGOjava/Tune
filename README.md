# Projct-MusicApp-Spring-Boot
## MUSICAPP By Rafal Pukalo 
[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)  
 
 [Spring Boot](http://projects.spring.io/spring-boot/) Music App.     
    
## Requirements 
     
For building and running the application you need:    
  
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 
- [Maven 3](https://maven.apache.org)

## Running the application locally

To run a Spring Boot application on your local machine you need to execute the `main` method in the `com.ToDoList.Application` class from your IDE.
```shell
com.ToDoList.Application
```

## Interface

If you want to add task you need to put Task data in field in the rubric `Task`. If you want add task to task list press `Save` Button:

![alt text](https://i.imgur.com/GGtXpGL.png)

If you want to edit task you need to put new Task data in field in the rubric `Edit task`. If you want to update task press `Save` Button:

![alt text](https://i.imgur.com/RC9bW0N.png)

## Endpoints

Get all tasks `Get` Endpoint `/tasks`
```shell
http://localhost:8080/tasks
```

Get One Task `Get` Endpoint `/getTask/{id}`
```shell
http://localhost:8080/getTask/{id}
```

Add Task `Post` Endpoint `/tasks`
```shell
http://localhost:8080/tasks
```

Task Edit Form `Post` Endpoint `/editTask/{id}`
```shell
http://localhost:8080/editTask/{id}
```

Update Tasks `Put` Endpoint `/updateTask/{id}`
```shell
http://localhost:8080/updateTask/{id}
```

Delete Task `Delete` Endpoint `/updateTask/{id}`
```shell
http://localhost:8080/tasks/{id}
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
