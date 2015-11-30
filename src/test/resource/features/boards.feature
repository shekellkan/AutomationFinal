@Boards
  Feature: Boards
    create a new board,delete a board, add user stories, move user storie around boards

    Background:
      Given I navigate to login page of Trello.com
        And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

  Scenario: create a new board with user stories
    Given I go to create Project page "Project_With_Board"
    When I create a board "BackLog"
      And I create a board "Current"
      And I create a board "Done"
    When I create a User Stories "Stories_1" into board "BackLog"
      Then The board "BackLog" is created with a user stories "Stories_1"

  Scenario: create board BackLog, Current, Done and move the User Storie
    Given I go to create Project page "Project_with_3_boards"
    When I create a board "BackLog"
      And I create a board "Current"
      And I create a board "Done"
    When I create a User Stories "User_Storie_1" into board "BackLog"
      And I move to User Storie "User_Storie_1" from "BackLog" to "Current" board
      And I move to User Storie "User_Storie_1" from "Current" to "Done" board
      Then The "User_Storie_1" to be in "Done" board
