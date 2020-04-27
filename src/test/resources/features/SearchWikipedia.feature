Feature: Search Wikipedia


  @SearchApple
  Scenario: Search on wikipedia using keyword "apple"
    Given User open wikipedia homepage
    When User input keyword "Apple" on wikipedia homepage
    And User click button search on wikipedia homepage
    Then User see title "Apple" on wikipedia article page