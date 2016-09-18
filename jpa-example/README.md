# Archetype / Template #

## Instructions ##
Create Archetype from root directory and install locally.
```bash
mvn archetype:create-from-project
cd target/generated-sources/archetype/
mvn install
```

## Archetype Future Enhancements ##
* Figure out a way to get the below read me into the template separately. 

------------------------------------

# Project Description #
This is a basic maven project layout ready for coding.

## Future Enhancements ##
TBD

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