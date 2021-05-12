Feature: Check application status

@Test
Scenario: Application status endpoint

Given the application is running
When I check the application status
Then the API should return 200