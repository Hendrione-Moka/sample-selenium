@Android @MoreOptions
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
    And User click filter button
    And User select filter "All"

  Scenario: refresh
    When User click more options button
    And User select more options menu "Refresh"
    Then User see task "Sleep" on to do list page
    And User see task "Play Dota" on to do list page

  Scenario: clear completed
    When User click more options button
    And User select more options menu "Clear completed"
    Then User see task "Sleep" on to do list page
    And User didn't see task "Play Dota" on to do list page