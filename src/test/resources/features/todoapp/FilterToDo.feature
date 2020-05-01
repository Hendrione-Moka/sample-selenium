@Android @FilterToDo
Feature: Complete To Do

  Background:
    Given User is on to do list page
    And User click button add on to do list page
    And user input title "Sleep" on add to do page
    And User input description "sleep is good" on add to do page
    And User click submit button on add to do page
    And User click button add on to do list page
    And user input title "Play Dota" on add to do page
    And User input description "Dota for lyfe" on add to do page
    And User click submit button on add to do page
    And User "check" task "Play Dota"

  Scenario: filter to do active
    When User click filter button
    And User select filter "Active"
    Then User see list label "Active TO-DOs"
    And User see task "Sleep" on to do list page
    And User didn't see task "Play Dota" on to do list page

  Scenario: filter to do completed
    When User click filter button
    And User select filter "Completed"
    Then User see list label "Completed TO-DOs"
    And User see task "Play Dota" on to do list page
    And User didn't see task "Sleep" on to do list page

  Scenario: filter to do All
    When User click filter button
    And User select filter "All"
    Then User see list label "All TO-DOs"
    And User see task "Sleep" on to do list page
    And User see task "Play Dota" on to do list page
