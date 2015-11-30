package ui.pages.teams.MenuTeams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.projects.ProjectMenuPage;

/**
 * Created by MiguelTerceros on 11/24/2015.
 */
public class MembersMenuPage extends BasePageObject {
    @FindBy(xpath = "//a[contains(text(), 'Add Members')]")
    WebElement addMemberBtn;
    /******** ADD elements *********/
    @FindBy(xpath = "//a[contains(text(), 'Add Members')]")
    WebElement addMembersBtn;
    @FindBy(xpath = "//div[@class='search-with-spinner']/input")
    WebElement emailField;

    @FindBy(xpath = "//input[contains(@class,'js-full-name')]")
    WebElement fullNameInvited;

    @FindBy(xpath = "//a[contains(@class,'icon-close' )]")
    WebElement iconClose;
    @FindBy(xpath = "//div[contains(@class,'js-search-results')]/ul/div/li/a")
    WebElement membersOption;
    @FindBy(xpath = "//form[contains(@class,'js-email-data')]/label[contains(text(), 'Full Name')]")
    WebElement fullNameForm;
    @FindBy(xpath = "//form[contains(@class,'js-email-data')]/input[contains(@class,'js-send-email-invite') and contains(@value,'Send')]")
    WebElement sendInvitedBtn;

    By memberInTeam;

    /**
     * construct of the class MembersMenuPage
     */
    public MembersMenuPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(addMemberBtn));
    }

    /*************** ADD MEMBER **************/
    /**
     * click in the button Add Members
     * @return the same instance of MembersMenuPage
     */
    public MembersMenuPage clickAddMembersBtn(){
        addMembersBtn.click();
        return this;
    }

    /**
     * entered values in the field email
     * @param email
     * @return the same instance of MembersMenuPage
     */
    public MembersMenuPage setEmailMembers(String email){
        emailField.clear();
        emailField.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(membersOption));
        return this;
    }

    /**
     * entered values in the field email
     * @param email
     * @return the same instance of MembersMenuPage
     */
    public MembersMenuPage setEmailInvite(String email){
        emailField.clear();
        emailField.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(fullNameForm));
        return this;
    }

    /**
     * entered values in the field full name
     * @param fullName
     * @return the same instance of MembersMenuPage
     */
    public MembersMenuPage setNameInvite(String fullName){
        fullNameInvited.clear();
        fullNameInvited.sendKeys(fullName);
        return this;
    }

    /**
     * click in the link of options of members
     * @return the same instance of MembersMenuPage
     */
    public MembersMenuPage clickMemberOptions(){
        membersOption.click();
        return this;
    }

    /**
     * click in the icon close in the form of add member
     * @return the same instance of MembersMenuPage
     */
    public MembersMenuPage clickIconClose(){
        iconClose.click();
        return this;
    }

    /**
     * click in the button Send for invited a new member
     * @return the same instance of MembersMenuPage
     */
    public MembersMenuPage clickSendInvitedMember(){
        sendInvitedBtn.click();
        return this;
    }

    /**
     * this method get the name of the specific member team
     * @param fullName
     * @return the name of an member
     */
    public String isNewMemberTeamDisplayed(String fullName){
        return driver.findElement(By.xpath(buildPathMemberTeam(fullName))).getText();
    }

    /**
     * this method construct a path for the search of a member
     * @param nameMember
     * @return Path for the search
     */
    public String buildPathMemberTeam(String nameMember){
        return "//span[contains(@class, 'full-name') and contains(text(),'"+ nameMember +"')]";
    }

    /**
     * this method invite a new member to team
     * @param nameMember
     * @param email
     * @return the same instance of MembersMenuPage
     */
    public MembersMenuPage invitedMemberInTeam(String nameMember, String email){
        clickAddMembersBtn();
        setEmailInvite(email);
        setNameInvite(nameMember);
        clickSendInvitedMember();
        waitUntilPageObjectIsLoaded();
        return this;
    }

    /**
     * this method add a new member in the team
     * @param email
     * @return the same instance of MemberMenuPage
     */
    public MembersMenuPage addMemberInTeam(String email){
        clickAddMembersBtn();
        setEmailMembers(email);
        clickMemberOptions();
        clickIconClose();
        waitUntilPageObjectIsLoaded();
        return this;
    }

    /**
     * this method add a new member in a project
     * @param email
     * @return new instance of ProjectMenuPage
     */
    public ProjectMenuPage addMemberProject(String email){
        setEmailMembers(email);
        clickMemberOptions();
        //clickIconClose();
        return new ProjectMenuPage();
    }

    /**
     * this methos invite a new member to project
     * @param nameInvited
     * @param email
     * @return new instance of ProjectMenuPage
     */
    public ProjectMenuPage inviteMemberProject(String nameInvited, String email){
        setEmailInvite(email);
        setNameInvite(nameInvited);
        clickSendInvitedMember();
        return new ProjectMenuPage();
    }
}
