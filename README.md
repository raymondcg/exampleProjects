# exampleProjects #
These projects are proof of concepts and meant to be used as references for future projects.

## Local development environment setup instructions ##

### System Requirements ###
* Maven 3
* JDK 1.8
* JBoss EAP 6.4 or JBoss AS 7
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

## Project Descriptions ##
### Eclipse Resources ###
This includes any imports or setup details needed to get Eclipse setup to work correctly.

### maven template ###
This is a basic project that can be copied over to start a new maven project. This really should be a maven archetype. It has a basic structure and setup for JBoss deployments, and SLF4j logging.

### Jax RS ###
A basic rest service project.

### Drools Sample ###
Example using BRMS as externalized rules.

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
1. Start JBoss Server
```
For Linux: 		JBoss_Home/bin/standalone.sh -c standalone-full.xml
For Windows: 	JBOSS_HOME\bin\standalone.bat -c standalone-full.xml
```
2. Open a command line and navigate to the root directory of the project.
3. Deploy the archive
```
mvn clean package jboss-as:deploy
```
4. This will deploy _target/???.war_ to the running instance of the server.
5. Undeploy the archive
```
mvn clean package jboss-as:undeploy
```