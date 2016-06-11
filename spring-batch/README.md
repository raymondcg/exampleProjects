# Project Description #
This is a project to demonstrate the utilization of spring batch to process in a horizontally and vertically scalable solution. As well as how to deploy that project.

## Future Enhancements ##
* spring-batch-war 
	* Convert context, web.xml, and spring-mvc-servlet.xml to java configuration files.
	* Add test class that starts up app, and ideally does a basic test in arquillian to validate application context.
* spring-batch-jar
	* Spring boot deployable example.
* Add way to configure properties.
* Enhance so that out of the box the example can be configured to run on multiple nodes.
	* Add way to configure MQ connections.
	* Add configurable database for job repository.
* Document 
	* All the High Availability and Fault tolerance gaps.
	* All of the benefits
	* How to take example and scale out both vertically and horizontally
* Add fault tolerance
	* Database
		* Spring Batch Admin 
		* Spring batch job during processing
	* MQ
	* Node failure
		* When processing steps either as a master or as a worker.

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
See instructions in: https://github.com/jboss-developer/jboss-brms-quickstarts/tree/6.2.x/helloworld-brms

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
```bash
mvn clean install
```

### Deploy ###

### Executable Jar ###
1. Run Jar
```bash
java -jar spring-batch-jar\target\spring-batch-node.jar
```


#### Container ###
1. Start server
```bash
jboss_HOME\bin\standalone.bat
```
2. Deploy
```bash
mvn jboss-as:deploy
```
3. Stop Server
```bash

```
4. UnDeploy
```bash
mvn jboss-as:undeploy
```
