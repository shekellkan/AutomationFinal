package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import cucumber.api.java.en.When;
import ui.pages.MainPage;
import ui.pages.projects.AddProjectPage;
import ui.pages.projects.ProjectsPage;
import ui.pages.teams.MenuTeams.BoardsMenuPage;
import ui.pages.teams.MenuTeams.MembersMenuPage;
import ui.pages.teams.MenuTeams.SettingsMenuPage;
import ui.pages.teams.TeamsPage;
import ui.pages.TopMenuPage;
import ui.pages.teams.AddTeamPage;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/17/15
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Teams {
    private TopMenuPage topMenu;
    private MainPage mainPage = new MainPage();
    private TeamsPage teamPage;
    private AddTeamPage addNewTeam;
    private MembersMenuPage membersMenuPage;
    private BoardsMenuPage boardsMenuPage;
    private AddProjectPage addProjectPage;
    private ProjectsPage projectsPage;
    private SettingsMenuPage settingsMenuPage;
    public String newMember;
    public String inviteMember;

    /*********** CREATE TEAM ************/
    @Given("^I go to Create Team page$")
    public void new_Team(){
        addNewTeam = mainPage.clickNewTeam();
    }

    @When("^I have to create a new team \"([^\"]*)\" with description \"([^\"]*)\"$")
    public void create_Teams_Description(String nameTeam, String description){
        teamPage = addNewTeam.createNewTeams(nameTeam, description);
    }

    @Then("^The new team \"([^\"]*)\" is created.$")
    public void new_Team_Created(String name){
        assertTrue(teamPage.isNameTeamsDisplayed());
        assertEquals(name, teamPage.nameTeam());
    }

    /**************** DELETE *************/


    /**************** ADD MEMBERS ****************/
    @Given("^I go to create a team \"([^\"]*)\" with description \"([^\"]*)\"$")
    public void new_members_team(String nameTeam, String description){
        addNewTeam = mainPage.clickNewTeam();
        teamPage = addNewTeam.createNewTeams(nameTeam, description);
    }

    @And("^I navigate until to menu Members$")
    public void navigate_menu_members(){
        membersMenuPage = teamPage.clickMenuMembers();
    }

    @When("^I add to member \"([^\"]*)\" with the email \"([^\"]*)\"$")
    public void add_new_member(String nameMember, String email){
        membersMenuPage.addMemberInTeam(email);
    }

    @And("^I invite a \"([^\"]*)\" with the email \"([^\"]*)\"$")
    public void invite_to_member(String nameInvite, String email){
        membersMenuPage.invitedMemberInTeam(nameInvite, email);
    }

    @Then("^The  member \"([^\"]*)\" is added in the team$")
    public void new_member_is_added(String nameMember){
        newMember = membersMenuPage.isNewMemberTeamDisplayed(nameMember);
        assertEquals(nameMember, newMember);
    }

    @And("^The member invited \"([^\"]*)\" is added in the team$")
    public void invited_member_is_added(String nameMember){
        inviteMember = membersMenuPage.isNewMemberTeamDisplayed(nameMember);
        assertEquals(nameMember, inviteMember);
    }

    /************* CREATE PROJECT INTO TEAM **************/
    @Given("^I navigate to team page \"([^\"]*)\"$")
    public void navigate_to_teamPage(String nameTeam){
        addNewTeam = mainPage.clickNewTeam();
        teamPage = addNewTeam.createTeam(nameTeam);
    }

    @And("^I navigate to projects menu in team$")
    public void navigate_to_boardPage(){
        boardsMenuPage =  teamPage.clickMenuBoards();
    }

    @When("^I create a project \"([^\"]*)\" for the team$")
    public void create_project_team(String nameProject){
        addProjectPage = boardsMenuPage.clickCreateNewBoard();
        projectsPage = addProjectPage.createNewProjects(nameProject);
    }

    @Then("^The project \"([^\"]*)\" is added in the team \"([^\"]*)\"$")
    public void project_in_team(String nameProject, String nameTeam){
        assertEquals(nameProject, projectsPage.nameOfProject());
        assertEquals(nameTeam, projectsPage.nameOfTeamInProject());
    }

    /**************** AFTER ********************/
    @After(value = "@Teams", order = 999)
    public void afterTeamScenario() {
        teamPage.deleteTeam();
    }
}
