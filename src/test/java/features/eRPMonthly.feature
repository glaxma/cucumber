Feature: Enroll a policy through eRP Application Source
  policy should be successfully enrolled

  @eRPAMIGEnrollmentTest  @RegressionTest
    @eRP_CC_Enrollments_TC_01
  Scenario Outline: Policy enrollment with Payment Frequency as monthly payment method as CC for AMIG
    Given Launched the eRP url
    When I entered the "<Zipcode>"
    And I clicked on Get a Free Quote
    And I clicked on first property
    And I entered resident  "<Email>"
    And I clicked on Continue button
    And switched to frames and I clicked on Enter your unit serach box
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
    And I Click on Question one
    And I Click on Question two
    And I click on questions Next
    And I entered the "<PrimaryResidentDOB>" "<PrimaryResidentPhone>"
    And I Selected Text Updates Checkbox
    And I Selected Paperless Billing Checkbox
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I Entered "<NameOnCard>" "<CardNumber>" "<CVV>"
    And I Entered "<Address>" "<Address2>" "<City>"  "<PostalCode>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I click on Pay
    Then Monthly Policy Enrolled Successfully

    #for Quarterly policy change (term=Quarterly:, Semi Annually term=SemiAnnually: , Annually term=Annually:)

#41051,03102
    Examples:
      | Zipcode | Email      | PrimaryResidentDOB | PrimaryResidentPhone | term    | NameOnCard | CardNumber       | CVV | Address             | Address2 | City           | PostalCode | Package | Deductible |
      | 03038   | test@t.com | 10251991           | 5647438901           | Monthly | test       | 4111111111111111 | 432 | 10 Wainwright Cir W |          | South Portland | 04106      | $10,000 | $250       |
#      | 03038   | test@t.com | 10251991           | 5647438901           | Quarterly    | test       | 4111111111111111 | 455 | 10 Wainwright Cir W |          | South Portland | 04106      | $20,000 | $250       |
#      | 03038   | test@t.com | 10251991           | 5647438901           | SemiAnnually | test       | 4111111111111111 | 455 | 10 Wainwright Cir W |          | South Portland | 04106      | $30,000 | $500       |
#      | 03038   | test@t.com | 10251991           | 5647438901           | Annually     | test       | 4111111111111111 | 455 | 10 Wainwright Cir W |          | South Portland | 04106      | $40,000 | $1,000     |
#      | 03038   | test@t.com | 10251991           | 5647438901           | Monthly      | test       | 4111111111111111 | 432 | 10 Wainwright Cir W |          | South Portland | 04106      | $50,000 | $500       |
#      | 03038   | Test      | test     | test@t.com | 10251991           | 5647438901           | Quarterly    | test       | 4111111111111111 | 455 | 10 Wainwright Cir W |          | South Portland | 04106      |
#      | 03038   | Test      | test     | test@t.com | 10251991           | 5647438901           | SemiAnnually | test       | 4111111111111111 | 455 | 10 Wainwright Cir W |          | South Portland | 04106      |
#      | 03038   | Test      | test     | test@t.com | 10251991           | 5647438901           | Annually     | test       | 4111111111111111 | 455 | 10 Wainwright Cir W |          | South Portland | 04106      |

  @eRPAMIGEnrollmentTest  @RegressionTest
    @eRPACH_Enrollments_TC_02

  Scenario Outline: Policy enrollment payment method as ACH for AMIG
    Given Launched the eRP url
    When I entered the "<Zipcode>"
    And I clicked on Get a Free Quote
    And I clicked on first property
    And I entered resident  "<Email>"
    And I clicked on Continue button
    And switched to frames and I clicked on Enter your unit serach box
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
    And I Click on Question one
    And I Click on Question two
    And I click on questions Next
    And I entered the "<PrimaryResidentDOB>" "<PrimaryResidentPhone>"
    And I Selected Text Updates Checkbox
    And I Selected Paperless Billing Checkbox
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on BankAccount
    And I Entered NameOnAccount "<RoutingNumber>" "<AccountNumber>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I click on Pay
    Then Monthly Policy Enrolled Successfully

#40241 03102
    Examples:
      | Zipcode | Email      | PrimaryResidentDOB | PrimaryResidentPhone | term         | RoutingNumber | AccountNumber     |  | Package | Deductible |
      | 55025   | test@t.com | 10251991           | 5647438901           | Monthly      | 121000358     | 41111111111111111 |  | $20,000 | $250       |
      | 55311   | test@t.com | 10251991           | 5647438901           | Quarterly    | 121000358     | 41111111111111111 |  | $30,000 | $250       |
      | 55426   | test@t.com | 10251991           | 5647438901           | SemiAnnually | 121000358     | 41111111111111111 |  | $40,000 | $500       |
      | 55405   | test@t.com | 10251991           | 5647438901           | Annually     | 121000358     | 41111111111111111 |  | $50,000 | $1,000     |
      | 55025   | test@t.com | 10251991           | 5647438901           | Monthly      | 121000358     | 41111111111111111 |  | $50,000 | $1,000     |

  @eRPANICOEnrollmentTest
    @eRP_ACH_ANICOEnrollments_TC03
  Scenario Outline: Policy enrollment payment method as ACH for ANICO
    Given Launched the eRP url
    When I entered the "<Zipcode>"
    And I clicked on Get a Free Quote
    And I selected on ANICO Property "<PropertyName>"
    And I entered resident  "<Email>"
    And I clicked on Continue button
    And switched to frames and I clicked on Enter your unit serach box
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
    And I entered the "<PrimaryResidentDOB>" "<PrimaryResidentPhone>"
    And I Selected Text Updates Checkbox
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on BankAccount
    And I Entered NameOnAccount "<RoutingNumber>" "<AccountNumber>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I click on Pay
    Then Monthly Policy Enrolled Successfully

    Examples:
      | Zipcode | Email      | PrimaryResidentDOB | PrimaryResidentPhone | term         | RoutingNumber | AccountNumber     | Package | Deductible | PropertyName    |
      | 96797   | test@t.com | 10251991           | 5647438901           | Monthly      | 121000358     | 41111111111111111 | $10,000 | $250       | Waikele Towers  |
      | 96797   | test@t.com | 10251991           | 5647438901           | Quarterly    | 121000358     | 41111111111111111 | $20,000 | $250       | Oasis Townhomes |
      | 96797   | test@t.com | 10251991           | 5647438901           | SemiAnnually | 121000358     | 41111111111111111 | $30,000 | $250       | Waikele Towers  |
      | 96797   | test@t.com | 10251991           | 5647438901           | Annually     | 121000358     | 41111111111111111 | $40,000 | $250       | Oasis Townhomes |
      | 96797   | test@t.com | 10251991           | 5647438901           | Monthly      | 121000358     | 41111111111111111 | $50,000 | $250       | Oasis Townhomes |

  @eRPAMIGEnrollmentTest
    @FutureDate_enrollment
  Scenario Outline: Policy enrollment payment method as ACH for AMIG
    Given Launched the eRP url
    When I entered the "<Zipcode>"
    And I clicked on Get a Free Quote
    And I clicked on first property
    And I entered resident  "<Email>"
    And Selected the Future date
#    And I Click on Coverage Start Date
    And I clicked on Continue button
    And switched to frames and I clicked on Enter your unit serach box
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
    And I Click on Question one
    And I Click on Question two
    And I click on questions Next
    And I entered the "<PrimaryResidentDOB>" "<PrimaryResidentPhone>"
    And I Selected Text Updates Checkbox
    And I Selected Paperless Billing Checkbox
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on BankAccount
    And I Entered NameOnAccount "<RoutingNumber>" "<AccountNumber>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I click on Pay
    Then Monthly Policy Enrolled Successfully

    Examples:
      | Zipcode | Email      | PrimaryResidentDOB | PrimaryResidentPhone | term    | RoutingNumber | AccountNumber     |  | Package | Deductible |
#      | 32202   | test@t.com | 10251991           | 5647438901           | Monthly      | 121000358     | 41111111111111111 || $30,000 | $250       |
#      | 32202   | test@t.com | 10251991           | 5647438901           | Quarterly    | 121000358     | 41111111111111111 |  | $30,000 | $250       |
#      | 40241   | test@t.com | 10251991           | 5647438901           | SemiAnnually | 121000358     | 41111111111111111 |  | $30,000 | $250       |
      | 40241   | test@t.com | 10251991           | 5647438901           | Monthly | 121000358     | 41111111111111111 |  | $30,000 | $1,000     |


  @eRPACH_ZeroLiability
  Scenario Outline: Policy enrollment payment method as ACH for AMIG with Zero Liability
    Given Launched the eRP url
    When I entered the "<Zipcode>"
    And I clicked on Get a Free Quote
    And I clicked on first property
    And I entered resident  "<Email>"
    And I clicked on Continue button
    And switched to frames and I clicked on Enter your unit serach box
    And Selected " <Package> "
    And I Clicked on Custom Radio Button
    And I click on Decline Personal Property Coverage OK button
    And I click on Next
    And I click on Additional Coverages Next
    And I Click on Question one
    And I Click on Question two
    And I click on questions Next
    And I entered the "<PrimaryResidentDOB>" "<PrimaryResidentPhone>"
    And I Selected Text Updates Checkbox
    And I Selected Paperless Billing Checkbox
    And I clicked on Primary Resident Details button Next
    And I click on SemiAnnually and Annually Payment Frequency "<term>" for Zero Liability
    And I click on Next
    And I click on BankAccount
    And I Entered NameOnAccount "<RoutingNumber>" "<AccountNumber>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I click on Pay
    Then Monthly Policy Enrolled Successfully

#40241 03102
    Examples:
      | Zipcode | Email      | PrimaryResidentDOB | PrimaryResidentPhone | term         | RoutingNumber | AccountNumber     |  | Package |
      | 94109   | test@t.com | 10251991           | 5647438901           | SemiAnnually | 121000358     | 41111111111111111 |  | $0      |
      | 40218   | test@t.com | 10251991           | 5647438901           | Annually     | 121000358     | 41111111111111111 |  | $0      |

  @eRP_CC_ZeroLiability
  Scenario Outline: Zero Liability Policy enrollment for payment method as CC for AMIG
    Given Launched the eRP url
    When I entered the "<Zipcode>"
    And I clicked on Get a Free Quote
    And I clicked on first property
    And I entered resident  "<Email>"
    And I clicked on Continue button
    And switched to frames and I clicked on Enter your unit serach box
    And Selected " <Package> "
    And I Clicked on Custom Radio Button
    And I click on Decline Personal Property Coverage OK button
    And I click on Next
    And I click on Additional Coverages Next
    And I Click on Question one
    And I Click on Question two
    And I click on questions Next
    And I entered the "<PrimaryResidentDOB>" "<PrimaryResidentPhone>"
    And I Selected Text Updates Checkbox
    And I Selected Paperless Billing Checkbox
    And I clicked on Primary Resident Details button Next
    And I click on SemiAnnually and Annually Payment Frequency "<term>" for Zero Liability
    And I click on Next
    And I Entered "<NameOnCard>" "<CardNumber>" "<CVV>"
    And I Entered "<Address>" "<Address2>" "<City>"  "<PostalCode>"
#    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I click on Pay
    Then Monthly Policy Enrolled Successfully

    #for Quarterly policy change (term=Quarterly:, Semi Annually term=SemiAnnually: , Annually term=Annually:)

#41051,03102
    Examples:
      | Zipcode | Email      | PrimaryResidentDOB | PrimaryResidentPhone | term     | NameOnCard | CardNumber       | CVV | Address             | Address2 | City           | PostalCode | Package |
#      | 40218   | test@t.com | 10251991           | 5647438901           | SemiAnnually | test       | 4111111111111111 | 432 | 10 Wainwright Cir W |          | South Portland | 04106      | $0      |
      | 40218   | test@t.com | 10251991           | 5647438901           | Annually | test       | 4111111111111111 | 432 | 10 Wainwright Cir W |          | South Portland | 04106      | $0      |