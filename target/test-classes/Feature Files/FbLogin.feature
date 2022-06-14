Feature: To validate login functionality.
 Background: 
Given user should launch the chrome browser and load the url


@smoke
Scenario: To validate the login functionality with valid username and invalid password.

When user should type valid username and invalid password
|Greens@123|Udinesh|
And user shiuld check login buttons
Then user should navigate to incorrect credential page  


Scenario: To validate the login functionality with invalid username and valid password.

When user should type invalid username and valid password
And user shiuld check login buttons
Then user should navigate to incorrect credential page  