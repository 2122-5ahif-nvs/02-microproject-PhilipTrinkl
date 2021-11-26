Feature: GravestoneEndpoint

  Background:
    * url baseUrl

  Scenario: Add a new Gravestone
    Given path 'gravestone'
    And request {name: Detlef Schuhmacher, dateofdeath: 31-05-1987 , inscription: Hier ruht in Frieden: Detlef Schuhmacher, Grave:{ id: 1  section: Nord, rented: true, beginrent: 31-05-1987, endrent: 31-12-2077}}
    When method POST
    Then status 200
    And match $ contains {id:"#notnull")

