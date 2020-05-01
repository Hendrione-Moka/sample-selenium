@Android @AddToDo
Feature: Add To Do

  Scenario: Add Task Then Check The List
    Given User is on to do list page
    When User click button add on to do list page
    And user input title "Sleep" on add to do page
    And User input description "sleep is good" on add to do page
    And User click submit button on add to do page
    Then User see task "Sleep" on to do list page
