package ui.pages.boards;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.boards.BoardsPage;
import ui.pages.projects.ProjectsPage;

/**
 * Created by amateur on 23/11/2015.
 */
public class AddBoardPage extends BasePageObject {
    /**
     * declare webelements
     */
    @FindBy(xpath = "//div[contains(@class,'mod-add')]/form/input[contains(@placeholder,'Add a list…')]")
    WebElement nameBoardField;
    @FindBy(xpath = "//input[contains(@class,'js-save-edit') and contains(@value,'Save')]")
    WebElement saveBtn;

    /**
     * construct of AddBoardPage
     */
    public AddBoardPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameBoardField));
    }

    /**
     * set the value of Name in the form for to create a board
     * @param nameBoard
     * @return the same instance of AddBoardPage
     */
    public AddBoardPage setNameBoard(String nameBoard){
        nameBoardField.clear();
        nameBoardField.sendKeys(nameBoard);
        return this;
    }

    /**
     * click in the save button
     * @return new instance of ProjectPage
     */
    public ProjectsPage clickSaveBtn(){
        saveBtn.click();
        return new ProjectsPage();
    }

    /**
     * this method create a new Board in the project
     * @param nameBoard
     * @return new instance of ProjectPage
     */
    public ProjectsPage createNewBoard(String nameBoard){
        setNameBoard(nameBoard);
        return clickSaveBtn();
    }
}
