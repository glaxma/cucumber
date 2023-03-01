Feature: Enroll a policy through LD application

  Background:
    Given validate the browser
    When Browser is Triggered
    Then Browser launched

  @LD_PolicyEnrollmentTest
    @LD_CC_Enrollments
  Scenario Outline: user login with valid and invalid details
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered ANICO "<PropertyName>"
#    Then I Entered "<ZipCode>"
    And I click on Search
    And I Click on Save
    And I Click on Insurance Questions
    And I click on btn Save
    And I Click on Current Date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I Selected the "<Endorsement>" and " <JW2500_5000> "
    And I click on Additional Coverages Next
#    And I Click on Question one
#    And I Click on Question two
#    And I click on questions Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I Entered "<NameOnCard>" "<CardNumber>"
    And I Entered "<Address>" "<Address2>" "<City>"  "<PostalCode>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully

   #HurricaneDeductibleReduction ,
    Examples:
      | username                |  | Password | Email      | Birth Date | PropertyName           | term         | NameOnCard | CardNumber       | Address             | Address2 | City           | PostalCode | Package | Deductible | Endorsement       | JW2500_5000                        |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 508 and 510 Apartments | Monthly      | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 05045      | $10,000 | $250       | Jewelry Theft     | Increased Jewelry Sublimits-$2,500 |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 508 and 510 Apartments | Quarterly    | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 05045      | $20,000 | $500       | Jewelry Theft     | Increased Jewelry Sublimits-$5,000 |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 508 and 510 Apartments | SemiAnnually | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 05045      | $30,000 | $1,000     | Pet Damage        |                                    |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 5 Central              | Annually     | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 05045      | $40,000 | $1,000     | Water Backup      |                                    |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 5 Central              | Annually     | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 05045      | $50,000 | $1,000     | Identity Recovery |                                    |

  @LD_PolicyEnrollmentTest
    @LD_ACH_Enrollments

  Scenario Outline: Policy enrollment payment method as ACH for AMIG
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered "<ZipCode>"
    And I click on Search
    And I Click on Save
    And I Click on Insurance Questions
    And I click on btn Save
    And I Click on Current Date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
#    And I Click on Question one
#    And I Click on Question two
#    And I click on questions Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on BankAccount
    And I Entered NameOnAccount "<RoutingNumber>" "<AccountNumber>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully

#40241 03102
    Examples:
      | username                | Password | Email      | Birth Date | ZipCode | term         | RoutingNumber | AccountNumber     | Package | Deductible |
      | ldadmin@leasingdesk.com | 1234567  | laxmareddy369@gmail.com | 04241990   | 92881   | Monthly      | 121000358     | 41111111111111111 | $20,000 | $250       |
      | ldadmin@leasingdesk.com | 1234567  | laxmareddy369@gmail.com  | 04241990   | 95051   | Quarterly    | 121000358     | 41111111111111111 | $30,000 | $250       |
      | ldadmin@leasingdesk.com | 1234567  | laxmareddy369@gmail.com | 04241990   | 95051   | SemiAnnually | 121000358     | 41111111111111111 | $40,000 | $500       |
      | ldadmin@leasingdesk.com | 1234567  | laxmareddy369@gmail.com  | 04241990   | 94109   | Annually     | 121000358     | 41111111111111111 | $50,000 | $1,000     |
#      | ldadmin@leasingdesk.com | 1234567  | test@b.com | 04241990   | 03102   | SemiAnnually | 121000358     | 41111111111111111 | $10,000 | $500       |

  @LD_PolicyEnrollmentTest
    @LD_CHK_Enrollments

  Scenario Outline: Policy enrollment payment method as ACH for AMIG
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered "<ZipCode>"
    And I click on Search
    And I Click on Save
    And I Click on Insurance Questions
    And I click on btn Save
    And I Click on Current Date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
#    And I Click on Question one
#    And I Click on Question two
#    And I click on questions Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on Invoice
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully

#40241 03102
    Examples:
      | username                |  | Password | Email      | Birth Date | ZipCode | term         | Package | Deductible |
#      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 94109   | SemiAnnually | $50,000 | $1,000     |
#      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 95051   | SemiAnnually | $20,000 | $500       |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 40241   | SemiAnnually | $50,000 | $1,000     |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 92881   | SemiAnnually | $20,000 | $500       |
#      | 03038    | test@t.com | 10251991           | 5647438901           | Quarterly    | 121000358     | 41111111111111111 |  | $30,000 | $250 |
#      | 40241    | test@t.com | 10251991           | 5647438901           | SemiAnnually | 121000358     | 41111111111111111 |  | $40,000 | $500 |
#      | 03102    | test@t.com | 10251991           | 5647438901           | Annually     | 121000358     | 41111111111111111 |  | $50,000 |  $1,000  |

  @LD_PolicyEnrollmentTest
    @LD_CHK_With_CC_Enrollments
  Scenario Outline: user login with valid and invalid details
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered "<ZipCode>"
    And I click on Search
    And I Click on Save
    And I Click on Insurance Questions
    And I click on btn Save
    And I Click on Current Date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
#    And I Click on Question one
#    And I Click on Question two
#    And I click on questions Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on Invoice
    And I click on Invoice wit CC
    And I Entered "<NameOnCard>" "<CardNumber>"
    And I Entered "<Address>" "<Address2>" "<City>"  "<PostalCode>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully


    Examples:
      | username                |  | Password | Email      | Birth Date | ZipCode | term         | NameOnCard | CardNumber       | Address             | Address2 | City           | PostalCode | Package | Deductible |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 03102   | SemiAnnually | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $20,000 | $250       |


  @LD_PolicyEnrollmentTest
    @LD_CC_With_Two_Installments_Enrollments
  Scenario Outline: user login with valid and invalid details
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered "<ZipCode>"
    And I click on Search
    And I Click on Save
    And I Click on Insurance Questions
    And I click on btn Save
    And I Click on Current Date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
#    And I Click on Question one
#    And I Click on Question two
#    And I click on questions Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on CC with Two Initial Installments CheckBox
    And I Entered "<NameOnCard>" "<CardNumber>"
    And I Entered "<Address>" "<Address2>" "<City>"  "<PostalCode>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully


    Examples:
      | username                |  | Password | Email      | Birth Date | ZipCode | term    | NameOnCard | CardNumber       | Address             | Address2 | City           | PostalCode | Package | Deductible |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 03102   | Monthly | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $20,000 | $1000      |

  @LD_Zero_Liability
  Scenario Outline: Policy enrollment payment method as ACH for AMIG
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered "<ZipCode>"
    And I click on Search
    And I Click on Save
    And I Click on Insurance Questions
    And I click on btn Save
    And I Click on Current Date
    And Selected " <Package> "
    And I click on Decline Personal Property Coverage OK button
    And I click on Next
#    And I click on Additional Coverages Next
#    And I Click on Question one
#    And I Click on Question two
#    And I click on questions Next
    And I clicked on Primary Resident Details button Next
    And I click on SemiAnnually and Annually Payment Frequency "<term>" for Zero Liability
    And I click on Next
    And I click on BankAccount
    And I Entered NameOnAccount "<RoutingNumber>" "<AccountNumber>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully

#40241 03102
    Examples:
      | username                | Password | Email      | Birth Date | ZipCode | term         | RoutingNumber | AccountNumber     | Package |
      | ldadmin@leasingdesk.com | 1234567  | test@b.com | 04241990   | 05609   | SemiAnnually | 121000358     | 41111111111111111 | $0      |
      | ldadmin@leasingdesk.com | 1234567  | test@b.com | 04241990   | 05609   | Annually     | 121000358     | 41111111111111111 | $0      |

  @LD_PolicyEnrollmentTest
    @LD_ANICO_CC_Enrollments
  Scenario Outline: user login with valid and invalid details
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered ANICO "<PropertyName>"
    And I Click on Property Radio button
    And I click on Search
    And I Click on Save
    And I click on btn Save
    And I Click on Current Date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I Entered "<NameOnCard>" "<CardNumber>"
    And I Entered "<Address>" "<Address2>" "<City>"  "<PostalCode>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on ANICO T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully


    Examples:
      | username                |  | Password | Email      | Birth Date | PropertyName    | term         | NameOnCard | CardNumber       | Address             | Address2 | City           | PostalCode | Package | Deductible |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Oasis Townhomes | Monthly      | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $50,000 | $250       |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Waikele Towers  | Quarterly    | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $40,000 | $500       |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Oasis Townhomes | SemiAnnually | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $30,000 | $1,000     |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Waikele Towers  | Annually     | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $20,000 | $250       |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Waikele Towers  | Annually     | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $20,000 | $500       |


#  Las Palmas Apartment Homes
#  Cambridge Towers Hopkins Apartments
#  OptOutNewRules
#  Cortland World Gateway
#
#  Northgreen at Carrollwood
#  The Braxton
#  Treasures on the Bay
#  1801 Metrowest
#  Argyle Lake at Oakleaf Town Center

  @LD_ANICO_ACH_Enrollments
  Scenario Outline: ANICO ACH enrollments
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered ANICO "<PropertyName>"
    And I Click on Property Radio button
    And I click on Search
    And I Click on Save
    And I click on btn Save
    And I Click on Current Date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on BankAccount
    And I Entered NameOnAccount "<RoutingNumber>" "<AccountNumber>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on ANICO T&C OK button
    And I click on Terms of service checkbox
    And I Click on ANICO T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully


    Examples:
      | username                |  | Password | Email      | Birth Date | PropertyName | term         | RoutingNumber | AccountNumber     | Package | Deductible |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Ulric Street | Monthly      | 121000358     | 4111111111111111  | $10,000 | $250       |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Ulric Street | Quarterly    | 121000358     | 41111111111111111 | $20,000 | $500       |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Ulric Street | SemiAnnually | 121000358     | 41111111111111111 | $30,000 | $1,000     |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Ulric Street | Annually     | 121000358     | 41111111111111111 | $40,000 | $250       |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Ulric Street | Monthly      | 121000358     | 4111111111111111  | $50,000 | $500       |

  @LD_ANICO_CHK_Enrollments
  Scenario Outline: ANICO CHK enrollment
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered ANICO "<PropertyName>"
    And I Click on Property Radio button
    And I click on Search
    And I Click on Save
    And I click on btn Save
    And I Click on Current Date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on Invoice
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on ANICO T&C OK button
    And I click on Terms of service checkbox
    And I Click on ANICO T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully

#40241 03102
    Examples:
      | username                |  | Password | Email      | Birth Date | PropertyName              | term         | Package | Deductible |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Northgreen at Carrollwood | SemiAnnually | $50,000 | $250       |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | The Braxton               | Annually     | $20,000 | $250       |

  @LD_Zero_Liability
  Scenario Outline: Policy enrollment payment method as ACH for AMIG
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
#    Then I Entered "<ZipCode>"
    Then I Entered ANICO "<PropertyName>"
    And I Click on Property Radio button
    And I click on Search
    And I Click on Save
#    And I Click on Insurance Questions
    And I click on btn Save
    And I Click on Current Date
    And Selected " <Package> "
    And I click on Decline Personal Property Coverage OK button
    And I click on Next
#    And I click on Additional Coverages Next
#    And I Click on Question one
#    And I Click on Question two
#    And I click on questions Next
    And I clicked on Primary Resident Details button Next
    And I click on SemiAnnually and Annually Payment Frequency "<term>" for Zero Liability
    And I click on Next
    And I click on BankAccount
    And I Entered NameOnAccount "<RoutingNumber>" "<AccountNumber>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully

#40241 03102
    Examples:
      | username                | Password | Email      | Birth Date | PropertyName   | term         | RoutingNumber | AccountNumber     | Package |
      | ldadmin@leasingdesk.com | 1234567  | test@b.com | 04241990   | Waikele Towers | SemiAnnually | 121000358     | 41111111111111111 | $0      |
      | ldadmin@leasingdesk.com | 1234567  | test@b.com | 04241990   | Waikele Towers | Annually     | 121000358     | 41111111111111111 | $0      |


  @LD_CCBackDate_Enrollments
  Scenario Outline: LD CC enrollments with back date
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered "<ZipCode>"
    And I click on Search
    And I Click on Save
    And I Click on Insurance Questions
    And I click on btn Save
#    And I Click on Current Date
    And I entered on Back Date "<BackDate>"
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I Selected the "<Endorsement>" and " <JW2500_5000> "
    And I click on Additional Coverages Next
#    And I Click on Question one
#    And I Click on Question two
#    And I click on questions Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I Entered "<NameOnCard>" "<CardNumber>"
    And I Entered "<Address>" "<Address2>" "<City>"  "<PostalCode>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully


    Examples:
      | username                |  | Password | Email      | Birth Date | ZipCode | term         | NameOnCard | CardNumber       | Address             | Address2 | City           | PostalCode | Package | Deductible | Endorsement       | JW2500_5000                        | BackDate   |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 05609   | Monthly      | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $10,000 | $250       | Jewelry Theft     | Increased Jewelry Sublimits-$2,500 | 10/02/2022 |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 05609   | Quarterly    | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $20,000 | $500       | Jewelry Theft     | Increased Jewelry Sublimits-$5,000 | 10/02/2022 |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 05609   | SemiAnnually | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $30,000 | $1,000     | Pet Damage        |                                    | 10/02/2022 |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 05609   | Annually     | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $40,000 | $1,000     | Water Backup      |                                    | 10/02/2022 |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 05609   | Annually     | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $50,000 | $1,000     | Identity Recovery |                                    | 10/02/2022 |


  @LD_PolicyEnrollmentTest
    @LD_MAIC_CC_Enrollments
  Scenario Outline: user login with valid and invalid details
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered ANICO "<PropertyName>"
    And I Click on Property Radio button
    And I click on Search
    And I Click on Save
    And I click on btn Save
    And I Click on Current Date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
    And I clicked on Primary Resident Details button Next
#    And I click on Monthly Payment Frequency "<term>"
    And I click on MAIC Monthly Payment Frequency "<term>"
    And I click on Next
    And I Entered "<NameOnCard>" "<CardNumber>"
    And I Entered "<Address>" "<Address2>" "<City>"  "<PostalCode>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on ANICO T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully


    Examples:
      | username                |  | Password | Email      | Birth Date | PropertyName | term    | NameOnCard | CardNumber       | Address             | Address2 | City           | PostalCode | Package | Deductible |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Makai        | Monthly | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $10,000 | $250       |
#      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Ashley Manor II Ltd      | Monthly | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $40,000 | $250       |
#      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Steeple Crest            | Monthly | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $30,000 | $250       |
#      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | The Crossings of Opelika | Monthly | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 04106      | $20,000 | $250       |

  @LD_MAIC_ACH_Enrollments
  Scenario Outline: ANICO ACH enrollments
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered ANICO "<PropertyName>"
    And I Click on Property Radio button
    And I click on Search
    And I Click on Save
    And I click on btn Save
    And I Click on Current Date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
    And I clicked on Primary Resident Details button Next
    And I click on MAIC Monthly Payment Frequency "<term>"
#    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on BankAccount
    And I Entered NameOnAccount "<RoutingNumber>" "<AccountNumber>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on ANICO T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully


    Examples:
      | username                |  | Password | Email      | Birth Date | PropertyName | RoutingNumber | AccountNumber    | Package | Deductible |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Hawaii Kai   | 121000358     | 4111111111111111 | $10,000 | $250       |
#      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Kalama Heights | 121000358     | 41111111111111111 | $20,000 | $250       |
#      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Kapilina Beach | 121000358     | 41111111111111111 | $30,000 | $250       |
#      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | Kapolei Lofts  | 121000358     | 41111111111111111 | $40,000 | $250       |

  @LD_PolicyEnrollmentTest
    @LD_ACH_Future_Enrollments

  Scenario Outline: Policy enrollment payment method as ACH for AMIG
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered "<ZipCode>"
    And I click on Search
    And I Click on Save
    And I Click on Insurance Questions
    And I click on btn Save
#    And I Click on Current Date
    And I select the future date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
#    And I Click on Question one
#    And I Click on Question two
#    And I click on questions Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on BankAccount
    And I Entered NameOnAccount "<RoutingNumber>" "<AccountNumber>"
#    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully


    Examples:
      | username                | Password | Email      | Birth Date | ZipCode | term    | RoutingNumber | AccountNumber     | Package | Deductible |
      | ldadmin@leasingdesk.com | 1234567  | test@b.com | 04241990   | 92881   | Monthly | 121000358     | 41111111111111111 | $20,000 | $250       |

  @LD_PolicyEnrollmentTest
    @LD_ACH_BackDate_Enrollments

  Scenario Outline: Policy enrollment payment method as ACH for AMIG
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered "<ZipCode>"
    And I click on Search
    And I Click on Save
    And I Click on Insurance Questions
    And I click on btn Save
#    And I Click on Current Date
    And I select the Back date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
#    And I Click on Question one
#    And I Click on Question two
#    And I click on questions Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on BankAccount
    And I Entered NameOnAccount "<RoutingNumber>" "<AccountNumber>"
    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully


    Examples:
      | username                | Password | Email      | Birth Date | ZipCode | term    | RoutingNumber | AccountNumber     | Package | Deductible |
      | ldadmin@leasingdesk.com | 1234567  | test@b.com | 04241990   | 92881   | Monthly | 121000358     | 41111111111111111 | $20,000 | $250       |

  @LD_CC_Future_Enrollments
  Scenario Outline: user login with valid and invalid details
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered ANICO "<PropertyName>"
#    Then I Entered "<ZipCode>"
    And I click on Search
    And I Click on Save
    And I Click on Insurance Questions
    And I click on btn Save
    And I Click on Future Date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I Selected the "<Endorsement>" and " <JW2500_5000> "
    And I click on Additional Coverages Next
#    And I Click on Question one
#    And I Click on Question two
#    And I click on questions Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I Entered "<NameOnCard>" "<CardNumber>"
    And I Entered "<Address>" "<Address2>" "<City>"  "<PostalCode>"
#    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully

   #HurricaneDeductibleReduction ,
    Examples:
      | username                |  | Password | Email      | Birth Date | PropertyName        | term         | NameOnCard | CardNumber       | Address             | Address2 | City           | PostalCode | Package | Deductible | Endorsement       | JW2500_5000                        |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 9 on Canal          | Monthly      | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 05045      | $10,000 | $250       | Jewelry Theft     | Increased Jewelry Sublimits-$2,500 |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 9 on Canal          | Quarterly    | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 05045      | $20,000 | $500       | Jewelry Theft     | Increased Jewelry Sublimits-$5,000 |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | A 62                | SemiAnnually | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 05045      | $30,000 | $1,000     | Pet Damage        |                                    |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 20 East Apartments  | Annually     | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 05045      | $40,000 | $1,000     | Water Backup      |                                    |
      | ldadmin@leasingdesk.com |  | 1234567  | test@b.com | 04241990   | 333 Penn Apartments | Annually     | test       | 4111111111111111 | 10 Wainwright Cir W |          | South Portland | 05045      | $50,000 | $1,000     | Identity Recovery |                                    |

  @LD_ACH_Future_Enrollments

  Scenario Outline: Policy enrollment payment method as ACH for AMIG
#    Given Launch the url
    When I entered the valid "<username>" and "<Password>"
    Then Login is Successful
    And I click on Add Erp Policy
    And I Entered "<Email>","<Birth Date>"
    Then I Entered ANICO "<PropertyName>"
#    Then I Entered "<ZipCode>"
    And I click on Search
    And I Click on Save
    And I Click on Insurance Questions
    And I click on btn Save
    And I Click on Future Date
#    And I Click on Current Date
    And Selected " <Package> " and " <Deductible> "
    And I click on Next
    And I click on Additional Coverages Next
#    And I Click on Question one
#    And I Click on Question two
#    And I click on questions Next
    And I clicked on Primary Resident Details button Next
    And I click on Monthly Payment Frequency "<term>"
    And I click on Next
    And I click on BankAccount
    And I Entered NameOnAccount "<RoutingNumber>" "<AccountNumber>"
#    And I click on I certify checkbox
    And I click on Terms of service checkbox
    And I Click on T&C OK button
#    And I click on Terms of service checkbox
#    And I Click on T&C OK button
    And I click on Pay
    Then Monthly Policy Enrolled from LD Successfully

#40241 03102
    Examples:
      | username                | Password | Email      | Birth Date | PropertyName        | term         | RoutingNumber | AccountNumber     | Package | Deductible |
      | ldadmin@leasingdesk.com | 1234567  | test@b.com | 04241990   | 9 on Canal          | Monthly      | 121000358     | 41111111111111111 | $20,000 | $250       |
      | ldadmin@leasingdesk.com | 1234567  | test@b.com | 04241990   | 9 on Canal          | Quarterly    | 121000358     | 41111111111111111 | $30,000 | $250       |
      | ldadmin@leasingdesk.com | 1234567  | test@b.com | 04241990   | A 62                | SemiAnnually | 121000358     | 41111111111111111 | $40,000 | $500       |
      | ldadmin@leasingdesk.com | 1234567  | test@b.com | 04241990   | 20 East Apartments  | Annually     | 121000358     | 41111111111111111 | $50,000 | $1,000     |
      | ldadmin@leasingdesk.com | 1234567  | test@b.com | 04241990   | 333 Penn Apartments | SemiAnnually | 121000358     | 41111111111111111 | $10,000 | $500       |

