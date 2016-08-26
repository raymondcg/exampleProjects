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
Follow parent readme.md instructions.

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