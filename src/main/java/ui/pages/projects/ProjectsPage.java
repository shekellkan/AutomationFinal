package ui.pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.Projects;
import ui.BasePageObject;
import ui.pages.boards.AddBoardPage;
import ui.pages.TopMenuPage;
import ui.pages.boards.BoardsPage;
import ui.pages.boards.MenuActionsUserStories;
import ui.pages.projects.CloseProjectPage;
import ui.pages.userStories.UserStoriesPage;

/**
 * Created by amateur on 15/11/2015.
 */
public class ProjectsPage extends BasePageObject {
    //declare variable of class
    private TopMenuPage topMenu;
    private ProjectMenuPage projectMenu;
    private BoardsPage boardsPage;
    /**
     * declare WebElements
     */
    @FindBy(xpath = "//a[contains(@class,'js-rename-board')]/span[@class='board-header-btn-text']")
    WebElement nameProject;
    @FindBy(xpath = "//a[contains(@class,'js-open-org-menu')]/span[@class='board-header-btn-text']")
    WebElement nameTeam;
    @FindBy(xpath = "//div[contains(@class,'js-add-list')]/form/span")
    WebElement addBoardBtn;
    @FindBy(xpath = "//div[contains(@class,'edit-controls')]/a[contains(@class,'icon-close')]")
    WebElement iconCloseBoardBtn;

    WebElement boardSearch;

    /**
     * construct of ProjectPage
     */
    public ProjectsPage(){
        waitUntilPageObjectIsLoaded();
        topMenu = new TopMenuPage();
        projectMenu = new ProjectMenuPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameProject));
    }

    /**
     * this method verify that the name of the project is displayed
     * @return true or false
     */
    public boolean isNameProjectDisplayed() {
        return nameProject.isDisplayed();
    }

    /**
     * this method get the WebElement title of the project
     * @return name webelement
     */
    public WebElement titleProject(){
        return nameProject;
    }

    /**
     * this method delete the project, call to method of the ProjectMenu
     * @return new instance of CloseProjectPage
     */
    public CloseProjectPage deleteProject(){
        return projectMenu.closeProject();
    }

    /**
     * this method get the name of project
     * @return the name of the project
     */
    public String nameOfProject(){
        return nameProject.getText();
    }

    /**
     * this method get the name of the team it belongs of the project
     * @return name of the team
     */
    public String nameOfTeamInProject(){
        return nameTeam.getText();
    }

    /**
     * click in the button add board
     * @return new instance of AddBoardPage
     */
    public AddBoardPage clickAddBoardList(){
        addBoardBtn.click();
        return new AddBoardPage();
    }

    public boolean isAddBoardBtnPresent(){
        return addBoardBtn.isDisplayed();
    }

    /**
     * this method get the name of the board that is present in the project
     * @param nameBoardSearch
     * @return name of the board
     */
    public String isBoardPresent(String nameBoardSearch){
        boardSearch = driver.findElement(By.xpath("//h2[contains(@class,'list-header-name') and contains(text(),'"+nameBoardSearch+"')]"));
        return boardSearch.getText();
    }

    /**
     * this method create a new User Stories in the respective board
     * @param userStories
     * @param nameBoard
     * @return new instance of ProjectsPage
     */
    public ProjectsPage createUserStoriesInBoard(String userStories, String nameBoard){
        boardsPage  = new BoardsPage();
        return boardsPage.createUserStories(userStories, nameBoard);
    }

    /**
     * click in the Icon close in form of create new board
     * @return
     */
    public ProjectsPage closeFormNewBoard() {
        iconCloseBoardBtn.click();
        return this;
    }

    /**
     * this method verify that a UserStories is present in a board
     * @param nameBoard
     * @param nameUserStories
     * @return
     */
    public String isUserStoriesPresentInBoard(String nameBoard, String nameUserStories) {
        boardsPage = new BoardsPage();
        return boardsPage.isUserStoriesPresent(nameBoard, nameUserStories);
    }

    /**
     * click in the button hidden of edit a user stories
     * @param nameBoard
     * @param nameUserStories
     * @return new instance of MenuActionsUSerStories
     */
    public MenuActionsUserStories clickUserStoriesEditBtn(String nameBoard, String nameUserStories){
        boardsPage = new BoardsPage();
        return boardsPage.clickEditUserStories(nameBoard, nameUserStories);
    }

    public UserStoriesPage clickInUserStories(String nameUserStories){
        boardsPage = new BoardsPage();
        return boardsPage.clickInUserStories(nameUserStories);
    }
}
