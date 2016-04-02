### Future Upgrades
* Configure to be able to release to maven nexus
	* Attach source.
* Javadoc every where
* Address TODOs
* Address Warnings
* Update runner to spit out time for each rule flow group when logging to debug. (See agenda listeners)
* Add tests to the rules runner project to test the different components inside of that project.
	* Test with multiple sessions supplied to different builders. 
	* Clean up POM file once all tests pass
* Abstract the interface to build using the correct builder
	* Consume property to select which builder to use, and/or which path/version to grab
* Implement Other Kie Container Builders
	* Pulls from remote nexus
	* Pulls from local
	* Builds from KJar on classpath - Either provided packaged with application, or added to classpath at runtime

### Project Overview
* This project is a standardized rules runner that provides implementations to run provided KJars from a variety of sources. Can be run run in the same JVM as the invoking application. While abstracting all drools dependencies from the client application. The Client application defines a bean to configure a component using specific beans.
* [Drools Examples](https://github.com/droolsjbpm/drools/tree/master/)

### Client Implementation Instructions
TBD

### Pre-requisites
* Maven
* jdk 1.8
* plugin??

### Build Details
```bash
mvn clean install
```

### Maven Release details
In order to release this jar to Nexus the following steps must be taken.
* Update the version of the parent POMS
```bash
mvn versions:set "-DnewVersion=1.0-SNAPSHOT"
```
