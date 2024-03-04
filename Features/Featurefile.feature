#Author: your.email@your.domain.com
#Keywords Summary :
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
Feature: Identifying Courses
Scenario: search Web Development Courses
 Given user navigates to coursera
 When searches for Web Development Courses
 And level is selected as beginner
 And language is selected as English
 Then get first course details
 And get second course details
Scenario: search Language Learning
 Given searches for Language Learning
 When search bar is clicked
 And count of levels available is taken
 And count of languages available is taken
Scenario: fill ready to transform form
 Given user navigates back to the home page
 And clicks for enterprise
 When solution is selected
 And clicks coursera for campus
 Then fills ready to transform form
 And clicks submit button
 And captures error message

 
 

 
