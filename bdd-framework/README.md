# Project Description #
This is demonstrating how a bdd framework would wrap around and test an application. It will be useful in unit tests, integrated tests, and acceptance tests.

## Future Enhancements ##
* [ ] Simplify
	* [ ] Add sprint boot
	* [ ] Set spring profile in maven profile
	* [ ] Use application-${profile}.yml to configure the differences between unit, int, and acceptance tests. (Reduce to one set of runners rather than three)
* [ ] Add Spring MVC - 'when' tests through service.
* [ ] Acceptance tests run against running spring boot jar
* [ ] Add in memory database
* [ ] Finish up liquibase setup in sample app
	* [ ] Make it so that liquibase only runs when 'wanted'
	* [ ] Make 'unit' test phase use in memory DB and liquibase to set it up
	* [ ] Make 'integration' test phase use 'physical' DB and use liquibase to set it up/update it.
* [ ] Configure deployables.zip
	
## Local development environment setup instructions ##
Follow parent readme.md instructions.

## Build / Deploy Instructions ##

### Deploy / Start ###
1. Download from binary storage location.
	1. For local developer testing just copy from target or local .m2 repository
2. Move Jar to execution folder (set permissions, etc)
3. Download deployables.zip from binary storage location.
	1. For local developer testing just copy from target or local .m2 repository
4. Unzip deployables.zip and copy application.yml and log4j2.xml to execution folder (set permissions, etc)
5. Start jar with default logging arguments included in jar.
```
java --jar ${artifactName}
```
6. Start jar with log4j configuration file
```
java -Dlog4j.file.location=./log4j2.xml -jar ${artifactName}
```
7. Start jar with other arguments (GC logging, memory configuration, etc)
```
__TBD__
```

### Build / Test ###
#### Unit Test ####
* Unit  Testing
```
mvn clean install
```

#### Integration Test ####
* Int Testing
```
mvn clean install -Pintegration
```

#### Acceptance Test ####
* Acceptance Testing
```
mvn clean install -Pacceptance
```