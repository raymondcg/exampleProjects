# Spring Boot Proof of Concept #
* Author: Raymond Gillett
* Level: Basic
* Technologies:
* Summary: This is a basic spring boot project.
* Target Product / Container: Spring Boot

## Future Enhancements ##
* Guides
	* Spring MVC UI app https://github.com/bkielczewski/example-spring-boot-mvc
	* Spring MVC UI app https://github.com/bkielczewski/example-spring-boot-rest
	* https://spring.io/guides/gs/spring-boot
	* Spring MVC http://www.mkyong.com/spring-mvc/gradle-spring-4-mvc-hello-world-example-annotation/
* Play with monitoring
* Make basic web app work in spring boot, including jsp page and rest end points
* Add in multiple dispatchers so that the web pages, rest, actuator, and metrics end points all work.

## Setup ##

### System Requirements ###
* Maven 3
* JDK 1.8
* Git

### Eclipse ###
_TBD_
* Plugins
	* 
* Code Formatter
	* Save Actions

### Java ###
_TBD_

### Maven ###
* Download binaries version of your choice.
* Unzip to location on your computer.
* Add MAVEN_HOME environment variable to that unziped location.
* Add Maven_HOME/bin to the path environment variable.
* If you have not yet done so, you must [Configure Maven](https://github.com/jboss-eap/quickstart/blob/master-eap6/README.md#mavenconfiguration) before testing these projects.

### Git ###
* Install Git
* Setup SSH
	* [github ssh ](https://help.github.com/articles/generating-an-ssh-key/)
	* [TortoiseGit SSH](http://stackoverflow.com/questions/13516119/tortoisegit-with-openssh-key-not-authenticating-using-ssh-agent/33328628#33328628)
	
### Container ###
_TBD_

### Validate Versions ###
```bash
java -version
javac -version
mvn --version
git --version
TBD - Container
```

## Build / Deploy Instructions ##
### Build ###
#### Build / Test ####
1. Build
```bash
mvn clean install
```
2. Local Testing
```bash
java -jar spring-boot-module/target/spring-boot-module-1.0-SNAPSHOT.jar
```

#### Deploy ####
1. Copy jar to destination
2. Setup properties in environment
	1. _TBD_
3. Start Jar
```bash
java -jar spring-boot-module/target/spring-boot-module-1.0-SNAPSHOT.jar
```