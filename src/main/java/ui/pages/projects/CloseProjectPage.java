package ui.pages.projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.MainPage;
import ui.pages.TopMenuPage;

/**
 * Created by amateur on 22/11/2015.
 */
public class CloseProjectPage extends BasePageObject {
    //declare instance of class
    private TopMenuPage topMenuPage;
    //declare webelements
    @FindBy(xpath = "//div[contains(@class,'big-message')]/h1")
    WebElement titleCloseProject;

    /**
     * construct of CloseProjectPage
     */
    public CloseProjectPage(){
        topMenuPage = new TopMenuPage();
        waitUntilPageObjectIsLoaded();
        gotoMainPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleCloseProject));
    }

    /**
     * this method navigate to MainPage
     * @return new instance of MainPage
     */
    public MainPage gotoMainPage(){
        return topMenuPage.goToMainPage();
    }

    /**
     * this method verify for the title of the project
     * @return true or false
     */
    public boolean isCloseProject(){
        return titleCloseProject.isDisplayed();
    }


}
