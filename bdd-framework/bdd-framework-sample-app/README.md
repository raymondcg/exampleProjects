# Project Description #
This is a fully functional sample application. It will be used by the test framework to exercise unit, integrated, and acceptance test phases.

## Local development environment setup instructions ##
Same as bdd-framework.

## Build / Deploy Instructions ##
### Build ###
1. Unit / Acceptance Testing
```
mvn clean install
```
2. System Integrated Test
```
mvn clean install -Pintegrated
```

### Deploy ###

1. Database
```
mvn clean liquibase:update -Ddb.env=??? 
```
2. Code
_TBD_
