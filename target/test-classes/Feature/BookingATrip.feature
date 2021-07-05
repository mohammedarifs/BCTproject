Feature: Booking a trip on BCT application

  
  Scenario: Successful Booking a trip with BCT application
  
    Given I launch the "Booking page on BCT application" on browser
    When I Select the "today" date for trip on calendar
    When I enter "FullName" as "SamSon" in the field
    And I enter "Email" as "Samson@gmail.com" in the field
    And I enter "Phone" as "42422422442" in the field
    When I click on "Continue" button
    Then I Verify the user navigate to "Checkout" page
    When I enter "Cardnumber" as "4242424242424242" in the field
    When I enter "Code" as "456" in the field
    When I Select the "Jan" from the "Expirymonth" dropdown
    When I Select the "2022" from the "Expiryear" dropdown
    When I enter "ZipCode" as "567568" in the field
    When I click on "PAY" button
    Then I Verify the message "YOUR BOOKING HAS BEEN PLACED" in "Orders"
    
    
    
  Scenario: Booking a trip with invalid credit card details on BCT application
  
    Given I launch the "Booking page on BCT application" on browser
    When I Select the "today" date for trip on calendar
    When I enter "FullName" as "SamSon" in the field
    And I enter "Email" as "Samson@gmail.com" in the field
    And I enter "Phone" as "42422422442" in the field
    When I click on "Continue" button
    Then I Verify the user navigate to "Checkout" page
    When I enter "Cardnumber" as "42424242423" in the field
    When I enter "Code" as "456" in the field
    When I Select the "Jan" from the "Expirymonth" dropdown
    When I Select the "2022" from the "Expiryear" dropdown
    When I enter "ZipCode" as "567568" in the field
    When I click on "PAY" button
    Then I Verify the message "Card number is invalid" in "CardDetails"
    
    
    
    