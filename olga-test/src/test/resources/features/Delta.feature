Feature: Delta app

  @web
  Scenario: Delta app
#    Maven command to run tests -  mvn clean verify  -Denvironment="delta" -Dcucumber.options="--tags @delta"
    Given User is on Web homepage
    Then User search for a flight
    |origin|destination|tripType|
    |ATL   |JFK        |ONE_WAY|


  @delta
  Scenario: Delta app
#    Maven command to run tests -  mvn clean verify  -Denvironment="delta" -Dcucumber.options="--tags @delta"
    Given User accept splash screen
    Then User continue as a guest
    And User start booking
    Then User search for a flight
      |origin|destination|tripType|
      |ATL   |JFK        |ONE_WAY|







   
  
