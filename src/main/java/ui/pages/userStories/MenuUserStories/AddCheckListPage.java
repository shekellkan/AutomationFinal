package ui.pages.userStories.MenuUserStories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.userStories.UserStoriesPage;

/**
 * Created by amateur on 29/11/2015.
 */
public class AddCheckListPage extends BasePageObject {
    @FindBy(xpath = "//div[contains(@class,'js-pop-over-header')]/span[contains(@class,'js-fill-pop-over-title')]")
    WebElement addCheckList;
    @FindBy(xpath = "//form/input[contains(@id,'id-checklist')]")
    WebElement titleCheckList;
    @FindBy(xpath = "//form/input[contains(@class,'js-add-checklist')]")
    WebElement addBtn;

    /**
     * construct of AddCheckListPage
     */
    public AddCheckListPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(addCheckList));
    }

    /**
     * set the value in the field title of the form Add Checklist
     * @param titleTask
     * @return the same instance of AddCheckListPage
     */
    public AddCheckListPage setTitleCheckList(String titleTask){
        titleCheckList.clear();
        titleCheckList.sendKeys(titleTask);
        return this;
    }

    /**
     * click in the button Add
     * @return new instance of UserStoriesPage
     */
    public UserStoriesPage clickAddBtn(){
        addBtn.click();
        return new UserStoriesPage();
    }

    /**
     * this method create a checklist for the user stories
     * @param titleTask
     * @return new instance of UserStoriesPage
     */
    public UserStoriesPage createCheckList(String titleTask){
        setTitleCheckList(titleTask);
        return clickAddBtn();
    }
}
