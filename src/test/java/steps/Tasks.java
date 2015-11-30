package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.pages.projects.ProjectsPage;
import ui.pages.userStories.UserStoriesPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

/**
 * Created by amateur on 29/11/2015.
 */
public class Tasks {
    private ProjectsPage projectsPage = new ProjectsPage();
    private UserStoriesPage userStoriesPage;

    @And("^I navigate to UserStories \"([^\"]*)\" page$")
    public void navigate_to_userStories(String nameUserStorie){
        userStoriesPage = projectsPage.clickInUserStories(nameUserStorie);
    }

    @When("^I create a checkList \"([^\"]*)\" with a task \"([^\"]*)\"$")
    public void iCreateATask(String newCheckList, String newSubTask){
        userStoriesPage.createSubTaskIntoTask(newCheckList, newSubTask);
    }

    @Then("^The task \"([^\"]*)\" is added into the user stories \"([^\"]*)\"$")
    public void theTaskIsAddedIntoTheUserStories(String nameTask, String nameUserStories){
        assertTrue(userStoriesPage.isTaskPresent(nameTask));
        assertEquals(nameUserStories, userStoriesPage.getNameUserStories());
    }

    @And("^I add a comment \"([^\"]*)\" into the user stories$")
    public void iAddACommentIntoTheUserStories(String comment){
        userStoriesPage.addCommentInUserStories(comment);
    }

    @And("^I add deadline for the user stories$")
    public void iAddDeadlineForTheUserStories(){
        userStoriesPage.clickAddDueDate();
    }

    @Then("^The user stories \"([^\"]*)\" have a task \"([^\"]*)\"$")
    public void theUserStoriesHaveATask(String nameUserStories, String nameTask){
        assertTrue(userStoriesPage.isTaskPresent(nameTask));
        assertEquals(nameUserStories, userStoriesPage.getNameUserStories());
    }

    @And("^The user stories \"([^\"]*)\" have a comment \"([^\"]*)\"$")
    public void theUserStoriesHaveAComment(String nameUserStories, String comment){
        assertEquals(nameUserStories, userStoriesPage.getNameUserStories());
        assertEquals(comment, userStoriesPage.getCurrentComment());
    }

    @And("^The user stories \"([^\"]*)\" have a deadline$")
    public void theUserStoriesHaveADeadline(String nameUserStories){
        assertEquals(nameUserStories, userStoriesPage.getNameUserStories());
        assertTrue(userStoriesPage.isDueDatePresent());
    }

    /**************** AFTER ********************/
    @After(value = "@Tasks", order = 999)
    public void afterTeamScenario() {
        userStoriesPage.outOfUserStories();
        projectsPage.deleteProject();
    }
}
