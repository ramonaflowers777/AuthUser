Feature: User authentication

  Scenario Outline: Authenticating user with valid credentials
    Given User log in api is available
    When I send a POST request with "<username>" and "<password>"
    Then The response status code is 200
    When I send a GET request with gained token
    Then The response returns correct user info

    Examples:
      | username | password   |
      | emilys   | emilyspass |
