package ui.pages.teams;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.MainPage;
import ui.pages.TopMenuPage;
import ui.pages.teams.MenuTeams.BoardsMenuPage;
import ui.pages.teams.MenuTeams.BusinessClassMenuPage;
import ui.pages.teams.MenuTeams.MembersMenuPage;
import ui.pages.teams.MenuTeams.SettingsMenuPage;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/17/15
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeamsPage extends BasePageObject {
    private TopMenuPage topMenuPage;
    private SettingsMenuPage settingsMenuPage;
    private BoardsMenuPage boardsMenuPage;

    @FindBy(xpath = "//h1[@class='u-inline']")
    WebElement titleTeam;
    /******** MENU Btn *************/
    @FindBy(xpath = "//a[contains(text(),'Settings')]")
    WebElement menuSettings;
    @FindBy(xpath = "//a[contains(text(),'Boards')]")
    WebElement menuBoards;
    @FindBy(xpath = "//a[contains(text(),'Members')]")
    WebElement menuMembers;
    @FindBy(xpath = "//a[contains(text(),'Business Class')]")
    WebElement menuBusiness;

    /**
     * construct of TeamsPage, instance the class TopMenuPagen and BoardMenuPage
     */
    public TeamsPage(){
        topMenuPage = new TopMenuPage();
        boardsMenuPage = new BoardsMenuPage();
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleTeam));
    }

    /**
     * this method verify the presence of the Title of the Team
     * @return true or false
     */
    public boolean isNameTeamsDisplayed() {
        return titleTeam.isDisplayed();
    }

    /**
     * this method obtains the name of the Team
     * @return name of the team
     */
    public String nameTeam(){
        return titleTeam.getText();
    }

    /******************** MENUS TEAMS ***********************/
    /**
     * this method is make click in the Setting menu of the TeamPage
     * @return new instance of SettingsMenuPage
     */
    public SettingsMenuPage clickMenuSetting(){
        menuSettings.click();
        return new SettingsMenuPage();
    }

    /**
     * this method is make click in the Boards menu of the TeamPage
     * @return new instance of BoardsMenuPage
     */
    public BoardsMenuPage clickMenuBoards(){
        if(!boardsMenuPage.isCreateBoardBtnDisplayed()){
            menuBoards.click();
        }
        return new BoardsMenuPage();
    }

    /**
     * this method is make click in the Members menu of the TeamPage
     * @return new instance of MembersMenuPage
     */
    public MembersMenuPage clickMenuMembers(){
        menuMembers.click();
        return new MembersMenuPage();
    }

    /**
     * this method is make click in the BusinessClass menu of the TeamPage
     * @return new instance of BusinessClassMenuPage
     */
    public BusinessClassMenuPage clickMenuBusiness(){
        menuBusiness.click();
        return new BusinessClassMenuPage();
    }

    /************ HOME **********/
    /**
     * this method navigate until the MainPage
     * @return new instance of MainPage
     */
    public MainPage goToMainPage(){
        return topMenuPage.goToMainPage();
    }

    /**
     * this method call to method deleteTeam of SettingsMenuPage for delete a team
     * @return new instance of MainPAge
     */
    public MainPage deleteTeam(){
        settingsMenuPage = clickMenuSetting();
        return settingsMenuPage.deleteTeam();
    }
}
