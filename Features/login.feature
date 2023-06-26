# sample.feature
Feature: Login functionality
  @sanity
  Scenario: Successful login with valid credentials
    Given user launch the chrome browser
    When user opens the url "https://admin-demo.nopcommerce.com/login"
    Then user enters the email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on log out link
    Then page title should be "Your store. Login"
    And user close the browser

@regression
  Scenario Outline:  Successful login with valid credentials

    Given user launch the chrome browser
    When user opens the url "https://admin-demo.nopcommerce.com/login"
    Then user enters the email as "<email>" and password as "<password>"
    And click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on log out link
    Then page title should be "Your store. Login"
    And user close the browser
    Examples:
      |email                    |password   |
      |  admin@yourstore.com   |   admin    |
      |  Test@yourstore1.com   |   Test     |