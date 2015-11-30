@Teams
Feature: Teams
  create a team, edit perfil, add members and invited members

  Background:
    Given I navigate to login page of Trello.com
      And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

  Scenario Outline: create a new team with description
    Given I go to Create Team page
    When I have to create a new team "<Name Team>" with description "<Description>"
      Then The new team "<Name Team>" is created.

    Examples:
    |     Name Team       |         Description               |
    |New_Team             |                                   |
    |Team_Description     |This is a new Team with description|

  Scenario: add members existent in a team
    Given I go to create a team "Team_Members" with description "added members in this team"
      And I navigate until to menu Members
    When I add to member "Ivan Morales" with the email "ivan.morales@fundacion-jala.org"
      And I invite a "Diego Olivera" with the email "diego823730@gmail.com"
     Then The  member "Ivan Morales" is added in the team

  Scenario: add the projects "Project_In_Team" to team "Teams_Projects"
    Given I navigate to team page "Teams_Projects"
      And I navigate to projects menu in team
    When I create a project "Project_In_Team" for the team
      Then The project "Project_In_Team" is added in the team "Teams_Projects"