@Projects
Feature: Projects
  create new projects, add members, change background, delete project

    Background:
      Given I navigate to login page of Trello.com
        And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

  Scenario: Add a new project
    Given I go to create Project page
    When I add a new project "New_Project"
      Then the new project "New_Project" is created

  Scenario: Add a new project with team
    Given I go to create Project page  with a team
      And I create a team "Project_Team" with description "this team it belongs a project"
      Then I navigate to main page
    When I add a new project "Project_With_Team" by selecting the team "Project_Team"
      Then the new project "Project_With_Team" is created with the team "Project_Team"

  Scenario: Invited a new member a project
    Given I go to create Project page "Project_Invited_Member"
      And I navigate to menu add member
    When I added a "Ivan Morales" with the email "ivan.morales@fundacion-jala.org"
      And I invited a "Mike Power" with the email "mikeZ803730@gmail.com"
    When I navigate to profile of the new member "Ivan Morales"
      Then The member "Ivan Morales" is added to project