Feature: To Test The Go Rest API Resources for Create, Update and Delete User
  As a user, I want to verify whether Create, Update and Delete User End points works successful


  Scenario Outline: Validate Create user Endpoint for valid resources
  Given I want to add user having "<name>" , "<gender>" , "<email>" , "<status>"
  When I do a POST request for "<endPoint>"
  Then I validate the response with status code <expectedStatus>

  Examples:
  |Test Case              | name      | gender | email  | status     | expectedStatus | endPoint                             |
  |Valid HTTPS Request    | name1     | Male   | name1  | Active     | 200            |https://gorest.co.in/public-api/users |
  |Valid HTTPS Request    | name2     | Male   | name2  | Active     | 200            |https://gorest.co.in/public-api/users |


  Scenario Outline: Validate Create user Endpoint for existing user
    Given I want to add existing user having "<name>" , "<gender>" , "<email>" , "<status>"
    When I do a POST request for "<endPoint>"
    Then I validate the response with status code <expectedStatus>

    Examples:
      |Test Case              | name      | gender | email                       | status     | expectedStatus| endPoint                             |
      |duplicate HTTPS Request| Jala Jala | Male   | jala.jala1234567@gmail.com  | Active     | 200           | https://gorest.co.in/public-api/users|
      |duplicate HTTPS Request| ping pom  | Male   | ping.pom@gmail.com          | Active     | 200           | https://gorest.co.in/public-api/users|


  Scenario Outline: Validate Update user Endpoint
    Given I want to add user having "<name>" , "<gender>" , "<email>" , "<status>"
    When I do a POST request for "<endPoint>"
    And I want to update user having "<name>" , "<gender>" , "<email>" , "<status>"
    When I do a PUT request for "<endPoint>"
    Then I validate the response with status code <expectedStatus>

    Examples:
      |Test Case              | name         | gender | email             | status     | expectedStatus | endPoint                                 |
      |Valid HTTPS Request    | ping pom     | Male   | pin               | Active     | 200            |https://gorest.co.in/public-api/users/|
      |Valid HTTPS Request    | Its me       | Male   | atoz              | Active     | 200            |https://gorest.co.in/public-api/users/|


  Scenario Outline: Validate remove user resource
    Given I want to add user having "<name>" , "<gender>" , "<email>" , "<status>"
    When I do a POST request for "<endPoint>"
    And I do a DELETE request for "<endPoint>"
    Then I validate the response with status code <expectedStatus>

    Examples:
      |Test Case              | name         | gender | email      | status     | expectedStatus | endPoint                             |
      |Valid HTTPS Request    | JetOne       | Male   | ThisOne    | Active     | 200            |https://gorest.co.in/public-api/users/|
      |Valid HTTPS Request    | All in       | Male   | otherOne   | Active     | 200            |https://gorest.co.in/public-api/users/|