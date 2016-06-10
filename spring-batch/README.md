# Project Description #
This is a project to demonstrate the utilization of spring batch to process in a horizontally and vertically scalable solution. As well as how to deploy that project.

## Future Enhancements ##
* Add spring boot example for deployments in additions to wars.
* Add way to configure properties.
* Enhance so that out of the box the example can be configured to run on multiple nodes.
	* Add way to configure MQ connections.
	* Add configurable database for job repository.
* Document 
	* All the High Availability and Fault tolerance gaps.
	* All of the benefits
	* How to take example and scale out both vertically and horizontally

## Local development environment setup instructions ##

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
```
java -version
javac -version
mvn --version
git --version
TBD - Container
```

## Build / Deploy Instructions ##
### Build ###
#### Build / Test ####
1. Unit / Acceptance Testing
```
mvn clean install
```
2. System Integrated Test
```
mvn clean install -Pintegrated
```

#### Deploy ####
_TBD_