Feature: API to check if two cities are connected  
  Scenario: client makes call to GET /connected
    Given the client calls /connected
    When the client receives status code of 200
    Then the client receives response