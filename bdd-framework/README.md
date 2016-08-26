# Project Description #
This is demonstrating how a bdd framework would wrap around and test an application. It will be useful in unit tests, integrated tests, and acceptance tests.

## Future Enhancements ##
* [ ] Finish up liquibase setup in sample app
	* [ ] Make it so that liquibase only runs when 'wanted'
	* [ ] Make 'unit' test phase use in memory DB and liquibase to set it up
	* [ ] Make 'integration' test phase use 'physical' DB and use liquibase to set it up/update it.
* [ ] Write sample App
	* [ ] Spring boot deployable for batch job.
	* [ ] Spring boot / mvc war deployable for basic services.
	* [ ] Make dao and domain model.
	* [ ] Make very trivial process step.
* [ ] Flesh out bdd-framework-test-harness to show basic concepts.

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