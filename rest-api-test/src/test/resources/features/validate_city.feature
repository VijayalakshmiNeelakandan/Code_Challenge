Feature: Validate Respone for Frankfurt coordinates

@Test
Scenario: As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude

Given the application is running
When the city is frankfurt
Then Validate if the country is Germany
Then Retreive the latitude and longitude of Frankfurt
