@Android @UncompleteToDo
Feature: Complete To Do

  Scenario: uncheck complete task
    Given User is on to do list page
    When User click button add on to do list page
    And user input title "Sleep" on add to do page
    And User input description "sleep is good" on add to do page
    And User click submit button on add to do page
    And User "check" task "Sleep"
    And User "uncheck" task "Sleep"
    Then User see task "Sleep" is "unchecked"
