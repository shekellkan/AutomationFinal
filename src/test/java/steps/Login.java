package steps;

//import cucumber.api.PendingException;
import common.CommonMethods;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

import ui.PageTransporter;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.pages.TopMenuPage;


/**
 * Created by MiguelTerceros on 11/9/2015.
 */
public class Login {
    private PageTransporter page = PageTransporter.getInstance();
    private TopMenuPage topMenu;
    private LoginPage loginPage;// = new LoginPage();
    private LoginPage loginError;
    private MainPage mainPage = new MainPage();
    /********* LOGIN SUCCESSFULL ****************/
    @Given("^I navigate to login page of Trello.com$")
    public void navigateLoginPage(){
        if(!mainPage.isMyBoardsMainDisplayed()){
            loginPage = page.navigateToLoginPage();
        }
    }

    @When("^I login in Trello.com as \"(.*?)\" with password \"(.*?)\"$")
    public void I_login_as_with_password(String userName, String userPassword){
        if(!mainPage.isMyBoardsMainDisplayed()){
            loginPage = page.navigateToLoginPage();
            mainPage = loginPage.loginSuccessful(userName, userPassword);
        }
    }

    @Then("^I should login to Trello.com successfully$")
    public void verifyMainTrelloIsDisplayed(){
        assertTrue(mainPage.isMyBoardsMainDisplayed(), "the main project is displayed");
    }

    /***************** LOGIN FAIL *****************/
    @When("^I login using wrong credentials in Trello.com as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void iLoginUsingWrongCredentialsInTrelloComAsWithPassword(String userName, String userPassword){
        loginError = loginPage.loginFailed(userName, userPassword);
    }

    @Then("^I not should login to Trello.com$")
    public void verifyMainTrelloIsNotDisplayed(){
        assertTrue(loginError.getErrorMessage());
    }

//    /**************** AFTER ****************/
//    @After(value = "@Login", order = 999)
//    public void afterTeamScenario() {
//        if(mainPage != null){
//            topMenu = new TopMenuPage();
//            topMenu.logout();
//            //DriverManager.getInstance().quitDriver();
//        }
//    }
}
