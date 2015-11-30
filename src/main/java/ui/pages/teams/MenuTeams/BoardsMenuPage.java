package ui.pages.teams.MenuTeams;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.boards.AddBoardPage;
import ui.pages.projects.AddProjectPage;

/**
 * Created by MiguelTerceros on 11/24/2015.
 */
public class BoardsMenuPage extends BasePageObject {
    @FindBy(xpath = "//a[contains(@class,'board-tile')]/span[contains(text(),'Create new board…')]")
    WebElement createBoardBtn;

    /**
     * construct BoardsMenuPage
     */
    public BoardsMenuPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(createBoardBtn));
    }

    /**
     * click in the button Create New Board
     * @return new instance of AddProjectPage
     */
    public AddProjectPage clickCreateNewBoard(){
        createBoardBtn.click();
        return new AddProjectPage();
    }

    /**
     * this method verify that the button is displayed in the page
     * @return true or false
     */
    public boolean isCreateBoardBtnDisplayed(){
        return createBoardBtn.isDisplayed();
    }
}
