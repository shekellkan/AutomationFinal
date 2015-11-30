package ui.pages.userStories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.userStories.MenuUserStories.AddCheckListPage;
import ui.pages.userStories.MenuUserStories.DueDatePage;

/**
 * Created by amateur on 29/11/2015.
 */
public class MenuUserStoriesPage extends BasePageObject {
    @FindBy(xpath = "//div[contains(@class,'window-sidebar')]/div[contains(@class,'window-module')]/h3[contains(text(),'Add')]")
    WebElement AddLbl;
    /**
     * Items Menu ADD
     */
    @FindBy(xpath = "//div[contains(@class,'u-clearfix')]/a[contains(@class,'js-change-card-members')]")
    WebElement membersMenu;
    @FindBy(xpath = "//div[contains(@class,'u-clearfix')]/a[contains(@class,'js-edit-labels')]")
    WebElement labelsMenu;
    @FindBy(xpath = "//div[contains(@class,'u-clearfix')]/a[contains(@class,'js-add-checklist-menu')]")
    WebElement addCheckListMenu;
    @FindBy(xpath = "//div[contains(@class,'u-clearfix')]/a[contains(@class,'js-add-due-date')]")
    WebElement dueDateMenu;
    @FindBy(xpath = "//div[contains(@class,'u-clearfix')]/a[contains(@class,'js-attach')]")
    WebElement attachmentMenu;
    /**
     * Items Menu Actions
     */
    @FindBy(xpath = "//div[contains(@class,'other-actions')]/div[contains(@class,'u-clearfix')]/a[contains(@class,'js-move-card')]")
    WebElement moveCardMenu;
    @FindBy(xpath = "//div[contains(@class,'other-actions')]/div[contains(@class,'u-clearfix')]/a[contains(@class,'js-copy-card')]")
    WebElement copyMenu;
    @FindBy(xpath = "//div[contains(@class,'other-actions')]/div[contains(@class,'u-clearfix')]/div[contains(@class,'js-subscribe-sidebar-button')]/a[contains(@class,'js-subscribe')]")
    WebElement suscribeMenu;
    @FindBy(xpath = "//div[contains(@class,'other-actions')]/div[contains(@class,'u-clearfix')]/a[contains(@class,'js-archive-card')]")
    WebElement archiveMenu;


    /**
     * construct of MenuActionsUserStories class
     */
    public MenuUserStoriesPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(AddLbl));
    }

    /**
     * click in the item menu Add CheckList
     * @return new instance of AddCheckListPage
     */
    public AddCheckListPage clickAddCheckList(){
        addCheckListMenu.click();
        return new AddCheckListPage();
    }

    public DueDatePage clickDueDate(){
        dueDateMenu.click();
        return new DueDatePage();
    }
}
