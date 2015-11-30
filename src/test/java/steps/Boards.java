package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import ui.pages.*;
import ui.pages.boards.AddBoardPage;
import ui.pages.boards.BoardsPage;
import ui.pages.boards.MenuActionsUserStories;
import ui.pages.boards.MoveUserStories;
import ui.pages.projects.ProjectsPage;

/**
 * Created by amateur on 22/11/2015.
 */
public class Boards{
    //private MainPage mainPage;
    private ProjectsPage projectPage;
    private BoardsPage boardsPage;
    private AddBoardPage addBoardPage = new AddBoardPage();
    private TopMenuPage topMenu;
    private MenuActionsUserStories menuActionsUserStories;
    private MoveUserStories moveUserStories;

    /**************** CREATE BOARD BACKLOG ****************/
    @When("^I create a board \"([^\"]*)\"$")
    public void create_a_board(String nameBoard){
        projectPage = addBoardPage.createNewBoard(nameBoard);
    }

    @When("^I create a User Stories \"([^\"]*)\" into board \"([^\"]*)\"$")
    public void iCreateAUserStories(String nameUserStories, String nameBoard){
        projectPage.closeFormNewBoard();
        projectPage.createUserStoriesInBoard(nameUserStories, nameBoard);
    }

    @Then("^The board \"([^\"]*)\" is created with a user stories \"([^\"]*)\"$")
    public void theBoardIsCreatedInTheProjectWithAUserStories(String nameBoard, String nameUserStories){
        assertEquals(nameBoard, projectPage.isBoardPresent(nameBoard));
        assertEquals(nameUserStories, projectPage.isUserStoriesPresentInBoard(nameBoard, nameUserStories));
    }

    /*************** MOVE USER HISTORIE AROUND BOARDS **************/
    @And("^I move to User Storie \"([^\"]*)\" from \"([^\"]*)\" to \"([^\"]*)\" board$")
    public void iMoveToUserStorieFromToBoard(String userStorie, String boardOrigin, String boardDestini){
        menuActionsUserStories = projectPage.clickUserStoriesEditBtn(boardOrigin, userStorie);
        moveUserStories = menuActionsUserStories.clickMenuMoveCard();
        projectPage = moveUserStories.moveUserStorieToBoard(boardDestini);
    }

    @Then("^The \"([^\"]*)\" to be in \"([^\"]*)\" board$")
    public void theToBeInBoard(String userStories, String nameBoard){
        assertEquals(userStories, projectPage.isUserStoriesPresentInBoard(nameBoard , userStories));
    }


    /**************** AFTER ********************/
    @After(value = "@Boards", order = 999)
    public void afterTeamScenario() {
        projectPage.deleteProject();
    }
}
