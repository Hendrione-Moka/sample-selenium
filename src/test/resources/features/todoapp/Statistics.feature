@Android @Statistics
Feature: Statistics

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

  Scenario: get statistics info
    When User click hamburger button
    And User select menu "Statistics"
    Then User see statistics Active 1 Complete 1