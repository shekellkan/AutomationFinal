package ui.pages;

import common.Utils;
import org.apache.log4j.chainsaw.Main;
import org.jboss.netty.channel.ExceptionEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.PageTransporter;
import ui.pages.projects.AddProjectPage;
import ui.pages.teams.AddTeamPage;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/11/15
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */


public class MainPage extends BasePageObject{
    TopMenuPage topMenuPage;
    //declare WebElements
    @FindBy(xpath = "//h3[contains(text(), 'My Boards')]")
    WebElement myBoardsMain;
    /***** projects ************/
    @FindBy(xpath = "//li/a[contains(text(),'Create new board…')]")
    WebElement newProjectBtn;
    /******** teams **********/
    @FindBy(xpath = "//a[contains(text(),'Create a new team…')]")
    WebElement newTeamBtn;

    By isTeamDeleted;

    /**
     * contruct of MainPage
     */
    public MainPage(){
        topMenuPage = new TopMenuPage();
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(myBoardsMain));
    }

    /**
     * method for verify if is found in the MainPage
     * @return true or false
     */
    public boolean isMyBoardsMainDisplayed() {
        return myBoardsMain.isDisplayed();
    }

    /******************** PROJECTS *****************/
    /**
     * Method for enable a form for to create a new project
     * @return new instance of AddProjectPage
     */
    public AddProjectPage clickNewProject(){
        newProjectBtn.click();
        return new AddProjectPage();
    }

    /**
     * method for verify that a project is present in the MainPage
     * @param nameProject
     * @return true or false
     */
    public boolean isProjectPresent(String nameProject){
        By isProjectDeleted = By.xpath("//span[@class='details']/span[contains(text(),'"+nameProject+"')]");
        return Utils.isElementPresent(isProjectDeleted);
    }

    /******************** TEAMS *******************/
    /**
     * method for enable form for to create a new team
     * @return new instance of AddTeamPage
     */
    public AddTeamPage clickNewTeam(){
        newTeamBtn.click();
        return new AddTeamPage();
    }

    /**
     * method for verify that a team is present in the MainPage
     * @param nameTeam
     * @return true or false
     */
    public boolean isTeamPresent(String nameTeam){
        boolean res;
        try{
            isTeamDeleted = By.xpath("//h3[contains(text(),'"+nameTeam+"')]");
            res = Utils.isElementPresent(isTeamDeleted);
        }catch (Exception e){
            res = false;
        }
        return res;
    }
}
