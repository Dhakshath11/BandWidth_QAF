#Author: dhakshath.amin@gmail.com
#Keywords Summary : Sample Test Run
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Contents
Feature: Sample Test Run in BDD - Content
  As a user, check example domain

  @LoadWebsite
  Scenario: Load Website Check
    Given I want to navigate to website
    And website is loaded

  @MoreInformation
  Scenario: Navigate and Click on More Information
    Given I want to navigate to website
    And website is loaded
    When I Click on "More information"
    Then "Further Reading" is to be visible

  @ReservedDomains
  Scenario: Navigate and Click on Reserved Domains
    Given I want to navigate to website
    And website is loaded
    When I Click on "More information"
    Then "Reserved Domains" is to be visible
    When I Click on "Reserved Domains"
    Then "Reserved Domains" is to be visible

  @RFCDomains
  Scenario Outline: Navigate and Click on RFCs
    Given I want to navigate to website
    And website is loaded
    When I Click on "More information"
    Then "<RFC>" is to be visible
    When I Click on "<RFC>"
    Then "<DOMAINS>" is to be visible
    Examples:
      | RFC      | DOMAINS            |
      | RFC 2606 | Top Level DNS      |
      | RFC 6761 | Special-Use Domain |
