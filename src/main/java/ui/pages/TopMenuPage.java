package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.PageTransporter;

/**
 * Created by amateur on 15/11/2015.
 */
public class TopMenuPage extends BasePageObject {
    PageTransporter page = PageTransporter.getInstance();

    @FindBy(xpath = "//a[@aria-label='Trello Home']")
    WebElement logo;

    @FindBy(xpath = "//a[contains(@aria-label,'Open Member Menu')]")
    WebElement user;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    WebElement logoutBtn;

    /**
     * contruct of TopMemuPage
     */
    public TopMenuPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(logo));
    }

    /**
     * method for verify if the logo of trello is present
     * @return true o false
     */
    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    /**
     * method for logout of trello, navigate to HomePage
     */
    public void logout() {
        user.click();
        logoutBtn.click();
        page.navigateToHomePage();
    }

    /**
     * navigate to MainPage
     * @return a new instance of MainPage
     */
    public MainPage goToMainPage() {
        logo.click();
        return new MainPage();
    }
}
