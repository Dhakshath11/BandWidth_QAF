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
@Headers
Feature: Sample Test Run in BDD - Headers
  As a user, check example domain

  @Domains
  Scenario: Navigate and Click on Header Domain
    Given I want to navigate to website
    And website is loaded
    When I Click on "Domains"
    Then "Domain Name Services" is to be visible

  @Protocols
  Scenario: Navigate and Click on Header Protocols
    Given I want to navigate to website
    And website is loaded
    When I Click on "Protocols"
    Then "Protocol Registries" is to be visible

  @Numbers
  Scenario: Navigate and Click on Header Numbers
    Given I want to navigate to website
    And website is loaded
    When I Click on "Numbers"
    Then "Number Resources" is to be visible

  @About
  Scenario: Navigate and Click on Header About
    Given I want to navigate to website
    And website is loaded
    When I Click on "About"
    Then "About us" is to be visible
