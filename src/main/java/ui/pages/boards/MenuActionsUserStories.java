package ui.pages.boards;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by amateur on 29/11/2015.
 */
public class MenuActionsUserStories extends BasePageObject {
    /**
     * declare of menu items
     */
    @FindBy(xpath = "//div[contains(@class, 'quick-card-editor-buttons')]/a[contains(@class, 'js-edit-labels')]")
    WebElement menuEditLabels;
    @FindBy(xpath = "//div[contains(@class, 'quick-card-editor-buttons')]/a[contains(@class, 'js-edit-members')]")
    WebElement menuEditMembers;
    @FindBy(xpath = "//div[contains(@class, 'quick-card-editor-buttons')]/a[contains(@class, 'js-move-card')]")
    WebElement menuMoveCard;
    @FindBy(xpath = "//div[contains(@class, 'quick-card-editor-buttons')]/a[contains(@class, 'js-copy-card')]")
    WebElement menuCopyCard;
    @FindBy(xpath = "//div[contains(@class, 'quick-card-editor-buttons')]/a[contains(@class, 'js-edit-due-date')]")
    WebElement menuEditDueDate;
    @FindBy(xpath = "//div[contains(@class, 'quick-card-editor-buttons')]/a[contains(@class, 'js-archive')]")
    WebElement menuArchive;

    /**
     * construct of MenuActionsUserStories class
     */
    public MenuActionsUserStories(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(menuMoveCard));
    }

    /**
     * click in the item menu Move Card
     * @return new instance of MoveUserStories
     */
    public MoveUserStories clickMenuMoveCard(){
        menuMoveCard.click();
        return new MoveUserStories();
    }
}
