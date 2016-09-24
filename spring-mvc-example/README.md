# Project Description #
This project demonstrates a simple Spring MVC rest services project utilizing Spring's java configuration.

## Local development environment setup instructions ##
Follow parent readme.md instructions.

## Build / Deploy Instructions ##
### Build ###
1. Build + Unit Testing
```
mvn clean install
```

### Deploy ###
1. Copy war in target folder to the container of your choice.
2. For Tomcat - To load application.properties, or logging configuration at run time
	1. Update catalina.properties
	```
	shared.loader=/folderLocation/,/folderlocation2/
	```