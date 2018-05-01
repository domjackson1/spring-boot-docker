Feature: Testing the Greeting endpoints
  Users should be able to submit GET requests to /greeting

  Scenario: Get Hello World greeting
    When I ask for a greeting
    Then I get a status of OK
    And I should be told "Hello, World!"

  Scenario: Get my name greeting
    When I ask for a greeting giving "Dave"
    Then I get a status of OK
    And I should be told "Hello, Dave!"