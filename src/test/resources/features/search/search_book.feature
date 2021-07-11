Feature: Searching book

  Scenario: Searching for a book 
  	Given He checks link available 
  	When He checks a <bookId> in list
  	Then The status code should be return 200
  Examples:
  | bookId |
  | 198    |
  | 200    |
  | 50     |
  	
  Scenario: Getting a book by name
  	Given A link to get book <code>
  	When Validate a book by "<bookTitle>"
  	Then The status code shoud be return 200
   
		Examples:
  	| code | bookTitle |
  	| 198  | Book 198  |
  	| 200  | Book 200  |
  	| 500  | Book 500  |
    
    Scenario: Get book total
    Given A link to verify
    When I get the total of book
    Then The total of book should be 200
    
    
  	

