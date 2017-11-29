Feature: Delta app

  @delta
  Scenario: Delta app
#    Maven command to run tests -  mvn clean verify  -Denvironment="delta" -Dcucumber.options="--tags @delta"
    Given User is on Web homepage
    Then User search for a flight
    |origin|destination|tripType|
    |ATL   |JFK        |ONE_WAY|










   
  
