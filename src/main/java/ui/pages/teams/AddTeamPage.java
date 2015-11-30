package ui.pages.teams;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by amateur on 22/11/2015.
 */
public class AddTeamPage extends BasePageObject {
    @FindBy(xpath = "//span[contains(@class,'js-fill-pop-over-title') and contains(text(),'Create Team')]")
    WebElement createTitle;
    /******** teams **********/
    @FindBy(xpath = "//input[@id='org-display-name']")
    WebElement teamTitle;
    @FindBy(xpath = "//textarea[@id='org-desc']")
    WebElement teamDescription;
    @FindBy(xpath = "//input[@value='Create']")
    WebElement createTeamsBtn;

    /**
     * construct of AddTeamPage
     */
    public AddTeamPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(createTitle));
    }

    /**
     * change the value of the field title of teams
     * @param title
     * @return the same instance of AddTeamPage
     */
    public  AddTeamPage setTeamsTitle(String title){
        teamTitle.clear();
        teamTitle.sendKeys(title);
        return this;
    }

    /**
     * entered a new value o change the value of the field description
     * @param description
     * @return the same instance AddTeamPage
     */
    public  AddTeamPage setTeamsDescription(String description){
        teamDescription.clear();
        teamDescription.sendKeys(description);
        return this;
    }

    /**
     * click in the button create
     * @return new instance of TeamsPage
     */
    public TeamsPage clickCreateNewTeam(){
        createTeamsBtn.click();
        return new TeamsPage();
    }

    /**
     * this method create new Teams, set the values name and description for the new team
     * @param name
     * @param description
     * @return new instance of TeamsPAge
     */
    public TeamsPage createNewTeams(String name, String description){
        setTeamsTitle(name);
        if(description != null && !description.isEmpty()){
            setTeamsDescription(description);
        }
        return clickCreateNewTeam();
    }

    /**
     * this method create new team only with a name
     * @param nameTeam
     * @return new instance of TeamsPage
     */
    public TeamsPage createTeam(String nameTeam) {
        setTeamsTitle(nameTeam);
        return clickCreateNewTeam();
    }
}
