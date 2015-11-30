package ui.pages.teams;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by MiguelTerceros on 11/24/2015.
 */
public class EditTeamsPage extends BasePageObject {
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/label[contains(text(),'Name')]")
    WebElement nameFormLbl;
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/input[contains(@name,'displayName')]")
    WebElement nameTeamInput;
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/input[contains(@name,'name')]")
    WebElement shortNameTeamInput;
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/input[contains(@name,'website')]")
    WebElement websiteInput;
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/textarea[contains(@name,'desc')]")
    WebElement descriptionTextArea;
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/input[contains(@value,'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/input[contains(@value,'Cancel')]")
    WebElement cancelBtn;

    /**
     * construct of the EditTeamsPage
     */
    public EditTeamsPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameFormLbl));
    }

    /**
     * entered new values in the field Name of the Team
     * @param nameTeam
     * @return the same instance of EditTeamsPage
     */
    public EditTeamsPage setNameTeam(String nameTeam){
        nameTeamInput.clear();
        nameTeamInput.sendKeys(nameTeam);
        return this;
    }

    /**
     * entered new value for the field ShortName of the team
     * @param shortNameTeam
     * @return the same instance of EditTeamsPage
     */
    public EditTeamsPage setShortNameTeam(String shortNameTeam){
        shortNameTeamInput.clear();
        shortNameTeamInput.sendKeys(shortNameTeam);
        return this;
    }

    /**
     * entered new values or change the value of the field WebSite
     * @param website
     * @return the same instance of EditTeamsPage
     */
    public EditTeamsPage setWebsite(String website){
        websiteInput.clear();
        websiteInput.sendKeys(website);
        return this;
    }

    /**
     * entered new values or change the value of the field Description
     * @param description
     * @return the same instance of EditTeamsPage
     */
    public EditTeamsPage setDesciptionTeam(String description){
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys(description);
        return this;
    }

    /**
     * click in the button Save
     * @return new instance of TeamsPage
     */
    public TeamsPage clickSaveBtn(){
        saveBtn.click();
        return new TeamsPage();
    }

    /**
     * click in the button cancel
     * @return new instance of TeamsPage
     */
    public TeamsPage clickCancelBtn(){
        cancelBtn.click();
        return new TeamsPage();
    }

    /**
     * change the values of the fields name and website
     * @param newName
     * @param newWebSite
     * @return new instance of TeamsPage
     */
    public TeamsPage changeNameAndWebSite(String newName, String newWebSite){
        setNameTeam(newName);
        setWebsite(newWebSite);
        return clickSaveBtn();
    }

    /**
     * change the values of the fields name and description of the team
     * @param newName
     * @param newDescription
     * @return new instance of TeamsPage
     */
    public TeamsPage changeNameAndDrecription(String newName, String newDescription){
        setNameTeam(newName);
        setDesciptionTeam(newDescription);
        return clickSaveBtn();
    }

    /**
     * change the values of description and website of the team
     * @param newDescription
     * @param newwebSite
     * @return new instance of TeamsPage
     */
    public TeamsPage changeDescriptionAndWebSite(String newDescription, String newwebSite){
        setDesciptionTeam(newDescription);
        setWebsite(newwebSite);
        return clickSaveBtn();
    }

    /**
     * change the values of name, description and website of the team
     * @param newName
     * @param newDescription
     * @param newWebSite
     * @return new instance of TeamsPage
     */
    public TeamsPage changeNameDescriptionWebSite(String newName, String newDescription, String newWebSite){
        setNameTeam(newName);
        setDesciptionTeam(newDescription);
        setWebsite(newWebSite);
        return clickSaveBtn();
    }
}
