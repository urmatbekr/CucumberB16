@outlineregression

Feature: Testing Order Creation Functionality

  Scenario Outline: Creating order with Scenario Outline
    When User enters username and password and click login Button
    And User navigates to Order section from Bar
    And User chooses the '<product>' and fills the '<quantity>'
    And User fills '<customerName>', '<street>', '<city>', '<state>' and '<zip>'
    And User chooses the '<paymentType>' and fills '<cardNumber>', '<expiredDate>' and click Process Button
    Then User validates the given 'New order has been successfully added.'
    Then User validates the order info from View All Orders
    Examples:
      | product     | quantity | customerName | street     | city    | state | zip   | paymentType      | cardNumber       | expiredDate |
      | MyMoney     | 3        | John         | Main       | NY      | NY    | 10010 | Visa             | 4200120034005400 | 12/25       |
      | FamilyAlbum | 4        | Sally        | Washington | LA      | CA    | 10010 | MasterCard       | 4200120034005400 | 12/27       |
      | ScreenSaver | 12       | Maria        | Michigan   | Chicago | IL    | 60340 | American Express | 4200120034005400 | 12/23       |

  Scenario: Validation Creating order with DataTable
    Given User provides username, password for SmartBear login
    When Clicks OrderButton and provides the product and quantity for product information
      | product  | MyMoney |
      | quantity | 4       |
    And User provides customerName, street, city, state, zipcode for address information
      | customerName | Ahmet        |
      | street       | 123 Main Str |
      | city         | Chicago      |
      | state        | IL           |
      | zipCode      | 60010        |
    And User provides cardType, CardNumber, expireDate for payment information
      | cardType   | Visa           |
      | cardNumber | 42001230123120 |
      | expireDate | 05/23          |
    And User clicks process button and validate message
      | New oder has been successfully added. |

