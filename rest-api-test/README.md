# rest-api-test
CityBikes API BDD test project

## Setup
* Java 1.8
* Maven
* Cucumber and Gherkin plugin
* Serenity BDD Reports
* Rest Assured

## Test Scenarios Considered

There are 2 scenarios designed as below:
1. Feature file name- apistatus.feature
   description - To check the Api Status of the Endpoint URL

2. Feature file name - validate_city.feature
   description - To validate the City Frankfurt belongs to the Country IE or Germany and retrieve the Longitude and Latitude coordinates

## How to execute the project
1. Open the Project in Eclipse or IntelliJ IDE
2. Execute the project from the command line, navigate to the path where the Pom.xml is situated. Then execute the command below.
	mvn clean install
3. Monitor the execution in the console for logs and Test Results
4. Launch the Serenity Cucumber Report in the project folder path: 'rest-api-test/target/site/serenity/index.html' to view the test reports in the browser.



