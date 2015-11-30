@Tasks
  Feature:Tasks
    create task, delete task, complete task

    Background:
      Given I navigate to login page of Trello.com
        And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

    Scenario: create task into user storie
      Given I go to create Project page "Project_Board_UserStories_Task"
        And I create a board "BackLog"
        And I create a User Stories "User_Stories_Task" into board "BackLog"
        And I navigate to UserStories "User_Stories_Task" page
      When I create a checkList "check_1" with a task "task_1"
        Then The task "check_1" is added into the user stories "User_Stories_Task"

    Scenario: create task, add comment, add deadline
      Given I go to create Project page "Project_UserStories_Personalized"
        And I create a board "BackLog"
        And I create a User Stories "User_Stories_Task" into board "BackLog"
        And I navigate to UserStories "User_Stories_Task" page
      When I create a checkList "check_1" with a task "task_1"
        And I add a comment "this a comment for the user stories" into the user stories
        And I add deadline for the user stories
        Then The user stories "User_Stories_Task" have a task "check_1"
        And The user stories "User_Stories_Task" have a comment "this a comment for the user stories"
        And The user stories "User_Stories_Task" have a deadline