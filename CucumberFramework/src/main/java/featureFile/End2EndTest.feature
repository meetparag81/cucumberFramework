Feature: Automated End2EndTests 
Scenario: Customer Placed an order by purchasing an item through search
Given user is already on login page
When user search for "apple"
And choose to buy first item
And moves to checkout from mini cart
And personal details on checkout page
And select same delivery adress
And select payment Method as "cheque" payment
And place the order




