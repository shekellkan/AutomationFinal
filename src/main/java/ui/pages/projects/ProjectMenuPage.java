package ui.pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.projects.ProjectsPage;
import ui.pages.projects.CloseProjectPage;
import ui.pages.teams.MenuTeams.MembersMenuPage;

/**
 * Created by amateur on 15/11/2015.
 */
public class ProjectMenuPage extends BasePageObject {

    @FindBy(xpath = "//h3[contains(text(),'Menu')]")
    WebElement title;
    /********* MORE MENU *********/
    @FindBy(xpath = "//li/a[@class='board-menu-navigation-item-link js-open-more' and contains(text(),'More')]")
    WebElement ItemMenuMore;
    @FindBy(xpath = "//h3[contains(@class,'js-board-menu-title-text') and contains(text(),'More')]")
    WebElement menuMore;
    @FindBy(xpath = "//a[contains(@class,'js-close-board') and contains(text(),'Close Board…')]")
    WebElement closeBoard;
    @FindBy(xpath = "//span[contains(@class,'js-fill-pop-over-title') and contains(text(),'Close Board?')]")
    WebElement confirmCloseBoard;
    @FindBy(xpath = "//input[contains(@class,'js-confirm') and contains(@value,'Close')]")
    WebElement closeBtn;
    /*********** ADD MEMBER MENU ***********/
    @FindBy(xpath = "//a[contains(@class,'button-link') and contains(text(),'Add Members…')]")
    WebElement addMemberMenu;
    @FindBy(xpath = "//div[contains(@class,'pop-over-header')]/span[contains(@class, 'js-fill-pop-over-title') and contains(text(),'Members')]")
    WebElement membersFormLbl;
    @FindBy(xpath = "//h3[contains(@class,'mini-profile-info-title')]/a[contains(@class,'mini-profile-info-title-link')]")
    WebElement titleProfile;
    /********* INFO MEMBER ************/
    WebElement infoMemberBtn;

    /**
     * construct of ProjectMenuPage
     */
    public ProjectMenuPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    /**
     * click in the item menu More
     * @return to same instance ProjectMenuPage
     */
    public ProjectMenuPage clickMenuMore(){
        ItemMenuMore.click();
        wait.until(ExpectedConditions.visibilityOf(menuMore));
        return this;
    }

    /**
     * click in the item menu Close board
     * @return to same instance ProjectMenuPage
     */
    public ProjectMenuPage clickCloseBoard(){
        closeBoard.click();
        wait.until(ExpectedConditions.visibilityOf(confirmCloseBoard));
        return this;
    }

    /**
     * click in the item menu confirm close board
     * @return new instance of CloseProjectPage
     */
    public CloseProjectPage clickConfirmCloseBoard(){
        closeBtn.click();
        return new CloseProjectPage();
    }

    /**
     * this method close the project
     * @return new instance of CloseProjectPage
     */
    public CloseProjectPage closeProject() {
        clickMenuMore();
        clickCloseBoard();
        return clickConfirmCloseBoard();
    }

    /**
     * click in the item menu Add Member
     * @return new instance of MembersMenuPage
     */
    public MembersMenuPage clickAddMember() {
        addMemberMenu.click();
        wait.until(ExpectedConditions.visibilityOf(membersFormLbl));
        return new MembersMenuPage();
    }

    /**
     * this method build the path for the search of a member
     * @param nameMember
     * @return path
     */
    public String buildPathInfoMember(String nameMember){
        return "//div[contains(@class,'js-list-board-members')]/div[contains(@class,'member')]/span[contains(@class,'member-initials') and contains(@title, '"+nameMember+"')]";
    }

    /**
     * click in a member that is added in the project
     * @param nameMember
     * @return new instance of InfoMemberPage
     */
    public InfoMemberPage clickInfoMember(String nameMember){
        infoMemberBtn = driver.findElement(By.xpath(buildPathInfoMember(nameMember)));
        waitUntilPageObjectIsLoaded();
        infoMemberBtn.click();
        wait.until(ExpectedConditions.visibilityOf(titleProfile));
        return new InfoMemberPage();
    }
}
