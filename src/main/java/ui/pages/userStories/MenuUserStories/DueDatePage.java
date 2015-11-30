package ui.pages.userStories.MenuUserStories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.userStories.UserStoriesPage;

/**
 * Created by amateur on 29/11/2015.
 */
public class DueDatePage extends BasePageObject {
    @FindBy(xpath = "//div[contains(@class,'js-pop-over-header')]/span[contains(text(),'Change Due Date')]")
    WebElement titleCalendar;
    @FindBy(xpath = "//form[contains(@class,'dpicker-widget')]/div[contains(@class,'datepicker-confirm-btns')]/input")
    WebElement saveCalendarBtn;

    /**
     * construct of DueDatePage
     */
    public DueDatePage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleCalendar));
    }

    /**
     * click in the button Save for the confirm the deadline
     * @return new instance of UserStoriesPage
     */
    public UserStoriesPage clickSaveCalendarBtn(){
        saveCalendarBtn.click();
        return new UserStoriesPage();
    }
}
