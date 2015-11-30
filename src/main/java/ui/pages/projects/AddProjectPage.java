package ui.pages.projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ui.BasePageObject;

/**
 * Created by amateur on 22/11/2015.
 */
public class AddProjectPage extends BasePageObject {
    //declare webelements
    @FindBy(xpath = "//span[contains(@class,'js-fill-pop-over-title') and contains(text(),'Create Board')]")
    WebElement createTitle;
    /******** Projects *********/
    @FindBy(xpath = "//input[@id='boardNewTitle']")
    WebElement projectTitle;
    @FindBy(xpath = "//input[@value='Create']")
    WebElement createProjectBtn;
    @FindBy(xpath = "//select[contains(@name,'org-id')]")
    WebElement selectField;
    Select selectTeam = new Select(selectField);

    /**
     * method construct of AddProjectPage
     */
    public AddProjectPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(createTitle));
    }

    /**
     * set the values of the field Title
     * @param title
     * @return the same instance AddProjectPage
     */
    public  AddProjectPage setProjectTitle(String title){
        projectTitle.clear();
        projectTitle.sendKeys(title);
        return this;
    }

    /**
     * click in the button Create New Project
     * @return new instance of ProjectPage
     */
    public ProjectsPage clickCreateNewProject(){
        createProjectBtn.click();
        return new ProjectsPage();
    }

    /**
     * this method selected a team for the project in the form for to create project
     * @param nameTeam
     * @return the same instance of AddProjectPage
     */
    public AddProjectPage selectTeamProject(String nameTeam){
        selectTeam.selectByVisibleText(nameTeam);
        return this;
    }

    /**
     * this method create a new project
     * @param title
     * @return new instance of ProjectPage
     */
    public ProjectsPage createNewProjects(String title){
        setProjectTitle(title);
        return clickCreateNewProject();
    }

    /**
     * this method create a project with a team
     * @param nameTeam
     * @param titleProject
     * @return new instance of ProjectPage
     */
    public ProjectsPage createNewProjectWithTeam(String nameTeam, String titleProject){
        setProjectTitle(titleProject);
        selectTeamProject(nameTeam);
        return clickCreateNewProject();
    }
}
