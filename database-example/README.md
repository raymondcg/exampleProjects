# Project Description #
This is demonstrating how to use Liquibase with an in memory database in a JUnit test. If you wish you 'can' deploy the liquibase database to a real database and test the JUnit test against that real database rather than an in memory database.

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