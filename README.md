# Project overview

Simple notebook back-end application created for training purposes.  
It is still under develop as i'm planning to connect it with dedicated front-end app build on React in the future.  

## To run app

Before we can start notebook app, we need to be connected with DB.  
I recommend using Docker.  
To start your local mysql db write this "docker run -p 0.0.0.0:3307:3306 --name mysql-notesdb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=notesdb -d mysql"  
in command line.  
Next you need to configure connection to this db.  
Ex. in IntelliJ [configuration] (https://gyazo.com/31132aea48e0ccbb547b0383a0c2b370)  
Now we can run this app :)  

## Technologies

- Java
- Javascript
- Freemarker
- AJAX
- Spring boot
- Spring security
- Hibernate
- Docker
- Junit + AssertJ
