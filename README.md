MASTERCARD CODE CHALLENGE
==============================
A Spring Boot App exposes one endpoint:
http://localhost:8080/connected?origin=city1&destination=city2

It should respond with ‘yes’ if city1 is connected to city2, ’no’ if city1 is not connected to city2. Any unexpected input should result in a ’no’ response.


Assumptions:
==============================
1. Security is not required for accessing the REST APIend point for the work 
2. The project completed is considered pure POC and is not production ready.

Building the Project
====================
To build run the command: `mvn clean package` in the root directory where pom.xml resides


Running the Project
====================
run the command: `mvn spring-boot:run` in the root directory where pom.xml resides


Running Tests
=============
The command `mvn clean install` from the root directory will run the unit tests, integration test.

The implementation of Cucumber Automation testing is not complete at this moment, because the feature and StepDefintion are not fully implemented.


API Documentation
====================
To see the documentation of API when the project runs
http://localhost:8080/swagger-ui.html
http://localhost:8080/cityconnect-api


Test Cases 
====================

http://localhost:8080/connected?origin=Boston&destination=Newark
Should return yes

http://localhost:8080/connected?origin=Boston&destination=Philadelphia
Should return yes
http://localhost:8080/connected?origin=Philadelphia&destination=Albany
Should return no

"# MA-codechallenge-cityconnect" 
