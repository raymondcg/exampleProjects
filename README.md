# exampleProjects #
These projects are proof of concepts and meant to be used as references for future projects.

## Project Descriptions ##

### Drools Sample ###
Example using BRMS as externalized rules.

### JBoss example ###
A basic rest service project using Jax-rs deployable to a Jboss container

### maven template ###
This is a basic project that can be copied over to start a new maven project. This really should be a maven archetype. It has a basic structure and setup for JBoss deployments, and SLF4j logging.

### mdb example ###
A project to show message driven beans.

### Spring Batch ###
A basic example showing spring batch parallel processing and limitations/constraints.

### Spring Boot ###
Spring boot example, showing all the fun stuff to get Spring MVC working with annotations in a spring boot container with spring boot monitoring.

## Future Projects ##
* Massively Parallel event processing engine. Kafka?
* OSGI
* BDD example - Connect in with Hibernate/Javalite/Spring Data example

## Setup instructions ##

### System Requirements ###
* Maven 3
* JDK 1.8
* Git

### Eclipse ###
* Plugins
	* _TBD_
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

	### Validate Versions ###
```
java -version
javac -version
mvn --version
git --version
```
