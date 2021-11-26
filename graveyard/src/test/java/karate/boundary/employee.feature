Feature: EmployeeEndpoint

  Background:
    * url baseUrl

  Scenario: Add new Employee
    Given path 'employee'
    And request {firstname: Günther, lastname: Jörg, address: Schieberstraße 87, Graveyard: {id: 1, name: Friedhof St.Gallen, address: Feldlistrasse 18}}
    When method POST
    Then status 200
    And match $ contains {id:"#notnull")

    Scenario: Delete Employee
      Given path 'employee'
      And request {firstname: Günther, lastname: Jörg, address: Schieberstraße 87, Graveyard: {id: 1, name: Friedhof St.Gallen, address: Feldlistrasse 18}}
      When method Delete
      Then status 200
      And match $ contains {id:"#notnull")
