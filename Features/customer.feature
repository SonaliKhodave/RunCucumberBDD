Feature:   customer
  @regression
  Scenario: Add new customer
    Given user launch the chrome browser
    When user opens the url "https://admin-demo.nopcommerce.com/login"
    And  user enters the email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then  user can see Dashboard page
    When user clicks on Customers menu
    And click on Customer menu item
    And click on Add new  button
    Then user can view add new customer page
    When user enter the customer info
    And click on save button
    Then user see a confirmation message As The new customer has been added successfully
    And user close the browser
@sanity
  Scenario:  Search customer by Email ID
    Given user launch the chrome browser
    When user opens the url "https://admin-demo.nopcommerce.com/login"
    And  user enters the email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then  user can see Dashboard page
    When user clicks on Customers menu
    And click on Customer menu item
    And enter email to search customer by email
    When click on search button
    Then user found email in the search table
    And user close the browser

    Scenario: Search customer by Name
      Given user launch the chrome browser
      When user opens the url "https://admin-demo.nopcommerce.com/login"
      And  user enters the email as "admin@yourstore.com" and password as "admin"
      And click on login
      Then  user can see Dashboard page
      When user clicks on Customers menu
      And click on Customer menu item
      And Enter customer firstname
      And Enter customer Lastname
      When click on search button
      Then user found name in the search table
      And user close the browser



