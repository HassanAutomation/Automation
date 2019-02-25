Feature: Demonstrate some Selenium WD capabilities in BDD

  Scenario: (1) Hobsons home page renders as expected.
    Given I am at Hobsons home page
    Then I verify that Hobsons Home Page is rendered properly

  Scenario: (2) When user hover over the menu items the list drops down as expected with the sub-menu items in them.
      (Solutions, Services, Resources, About & Blog).

    Given I am at Hobsons home page
    Then I verify that Hobsons Home Page is rendered properly
    When I hover over "Solutions" Menu
    Then I should see the following dropdown list
      | Solutions                    |
      | COLLEGE AND CAREER READINESS |
      | California                   |
      | Michigan                     |
      | Texas                        |
      | Pennsylvania                 |
      | MATCH AND FIT                |
      | STUDENT SUCCESS AND ADVISING |
    When I hover over "Services" Menu
    Then I should see the following dropdown list
      | Services              |
      | PROFESSIONAL SERVICES |
      | OUTSOURCED SERVICES   |
    When I hover over "Resources" Menu
    Then I should see the following dropdown list
      | Resources      |
      | WEBINARS       |
      | EVENTS         |
      | CASE STUDIES   |
      | WHITE PAPERS   |
      | BLOGS          |
      | PRESS RELEASES |
      | PRESS COVERAGE |
      | VIDEOS         |
    When I hover over "About" Menu
    Then I should see the following dropdown list
      | About        |
      | PARTNERSHIPS |
      | CAREERS      |
      | MEDIA KIT    |
      | CONTACT US   |
    When I hover over "Blog" Menu
    Then I should not see any dropdown list for menu item "Blog"

  Scenario: (3) There are left & right scroll features on the homepage.
    Clicking left should scroll the contents appropriately & the same applies to when clicking right.

    Given I am at Hobsons home page
    Then I verify that Hobsons Home Page is rendered properly
    When I click on the Left scroll arrow
    Then contents are Left scrolled appropriately
    When I click on the Right scroll arrow
    Then contents are Right scrolled appropriately

  Scenario: (4) At the bottom of the homepage there is a link to Careers.
    Clicking on that will render careers page on which at the bottom we have Hobosns locations. Please assert the location address is correct.

    Given I am at Hobsons home page
    Then I verify that Hobsons Home Page is rendered properly
    When I click on Careers at the bottom of home page
    Then I verify that I am taken to the careers page
    And I verify that "Cincinnati, OH" address is:
      """
      	 400 E-Business Way, Suite 400
      		Cincinnati, OH 45241
      	+1.513.891.5444
      """
    And I verify that "Arlington, VA" address is:
      """
      3033 Wilson Boulevard, Suite 500 Arlington, VA 22201
      +1.703.234.5910
      """

  Scenario: (5)When you are at the locations on Careers page,
    clicking on a location should open google maps in a new tab with the location pinned.

    Given I am at Hobsons home page
    Then I verify that Hobsons Home Page is rendered properly
    When I click on Careers at the bottom of home page
    Then I verify that I am taken to the careers page
    When I click on "Cincinnati, OH" address
    Then I verify that I am taken to google maps page
    And the location at google maps is:
      """
      400 E-Business Way, Suite 400Cincinnati, OH 45241
      """
