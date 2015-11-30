package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import ui.pages.*;
import ui.pages.projects.*;
import ui.pages.teams.AddTeamPage;
import ui.pages.teams.MenuTeams.MembersMenuPage;
import ui.pages.teams.TeamsPage;

/**
 * Created by amateur on 15/11/2015.
 */
public class Projects {
    private MainPage mainPage = new MainPage();
    private AddTeamPage addTeam;
    private TeamsPage teamPage;
    private TopMenuPage topMenuPage;
    private ProjectsPage projectPage;
    private ProjectMenuPage projectMenuPage;// = new ProjectMenuPage();
    private InfoMemberPage infoMemberPage;
    private MembersMenuPage membersMenuPage;
    private CloseProjectPage closeProject;
    private AddProjectPage addProject;
    /********** CREATE NEW PROJECT **********/
    @Given("^I go to create Project page$")
    public void Create_A_New_Project(){
        addProject = mainPage.clickNewProject();
    }

    @And("^I add a new project \"([^\"]*)\"$")
    public void Add_A_New_Project(String title){
        projectPage = addProject.createNewProjects(title);
    }

    @Then("^the new project \"([^\"]*)\" is created$")
    public void theNewProjectIsCreated(String title){
        assertTrue(projectPage.isNameProjectDisplayed());
        assertEquals(title, projectPage.titleProject().getText());
    }

    /********** CREATE NEW PROJECT WITH A TEAM *************/
    @Given("^I go to create Project page  with a team$")
    public void createProjectWithTeam(){
        addTeam = mainPage.clickNewTeam();
    }

    @And("^I create a team \"([^\"]*)\" with description \"([^\"]*)\"$")
    public void iCreateATeamWithDescription(String nameTeam, String description){
        teamPage = addTeam.createNewTeams(nameTeam, description);
    }

    @Then("^I navigate to main page$")
    public void iNavigateToMainPage(){
        topMenuPage = new TopMenuPage();
        mainPage = topMenuPage.goToMainPage();
    }

    @When("^I add a new project \"([^\"]*)\" by selecting the team \"([^\"]*)\"$")
    public void iAddANewProjectBySelectingTheTeam(String nameProject, String nameTeam){
        addProject = mainPage.clickNewProject();
        projectPage = addProject.createNewProjectWithTeam(nameTeam, nameProject);
    }

    @Then("^the new project \"([^\"]*)\" is created with the team \"([^\"]*)\"$")
    public void theNewProjectIsCreatedWithTheTeam(String nameProject, String nameTeam){
        assertEquals(nameProject, projectPage.nameOfProject());
        assertEquals(nameTeam, projectPage.nameOfTeamInProject());
    }

    /******************** DELETE A PROJECT **********************/

    @Given("^I create a project \"([^\"]*)\"$")
    public void iCreateAProject(String nameProject){
        addProject = mainPage.clickNewProject();
        projectPage = addProject.createNewProjects(nameProject);
    }

    @And("^I deleted the project$")
    public void deletedProject(){
        closeProject = projectPage.deleteProject();
    }

    @Then("^the project \"([^\"]*)\" is deleted$")
    public void theProjectIsDeleted(String nameProjectDeleted){
        assertTrue(closeProject.isCloseProject());
        //Assert.assertFalse(mainPage.isProjectPresent(nameProjectDeleted));
    }

    /************ CREATE PROJECT, INVITED MEMBER AND ADD MEMBER *********/
    @Given("^I go to create Project page \"([^\"]*)\"$")
    public void iGoToCreateProjectPage(String nameProject){
        addProject = mainPage.clickNewProject();
        projectPage = addProject.createNewProjects(nameProject);
    }

    @And("^I navigate to menu add member$")
    public void iNavigateToMenuAddMember(){
        projectMenuPage = new ProjectMenuPage();
        membersMenuPage = projectMenuPage.clickAddMember();
    }

    @When("^I added a \"([^\"]*)\" with the email \"([^\"]*)\"$")
    public void iAddedAWithTheEmail(String nameMember, String email){
        projectMenuPage = membersMenuPage.addMemberProject(email);
    }

    @And("^I invited a \"([^\"]*)\" with the email \"([^\"]*)\"$")
    public void invited_member_at_project(String nameMember, String email){
        projectMenuPage = membersMenuPage.inviteMemberProject(nameMember, email);
    }

    @When("^I navigate to profile of the new member \"([^\"]*)\"$")
    public void navigate_to_profile(String nameInfoProfile){
        infoMemberPage = projectMenuPage.clickInfoMember(nameInfoProfile);
    }

    @Then("^The member \"([^\"]*)\" is added to project$")
    public void theMemberIsAddedToProject(String nameInvited){
        assertEquals(nameInvited, infoMemberPage.getTextTitleProfile());
        infoMemberPage.closeInfoMember();
    }

    /**************** AFTER ********************/
    @After(value = "@Projects", order = 999)
    public void afterTeamScenario() {
        projectPage.deleteProject();
    }
}
