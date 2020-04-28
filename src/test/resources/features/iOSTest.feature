@iOS
Feature: iOS Test


  @Register
  Scenario: Regiser User
    Given User is on Dana register page
    When User input name "Hendri"
    And User input email "antomyh@gmail.com"
    And User input address "Depok"
    And User click button submit
    Then User see message
    """
Name :  Hendri
Email :  antomyh@gmail.com
Address :  Depok
Glad to see you here learning iOS Automation!
    """