package ui.pages.boards;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ui.BasePageObject;
import ui.pages.projects.ProjectsPage;

/**
 * Created by amateur on 29/11/2015.
 */
public class MoveUserStories extends BasePageObject {
    @FindBy(xpath = "//div[contains(@class, 'pop-over-header')]/span[contains(text(),'Move Card')]")
    WebElement titleMoveCard;
    @FindBy(xpath = "//div[contains(@class,'form-grid-child-threequarters')]/select[contains(@class, 'js-select-list')]")
    WebElement selectList;
    Select listBoards = new Select(selectList);
    @FindBy(xpath = "//div[contains(@class,'pop-over-content')]/div/input[contains(@value,'Move')]")
    WebElement moveBtn;

    /**
     * construct of MoveUserStories class
     */
    public MoveUserStories(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleMoveCard));
    }

    /**
     * this method selected of the list of board a board in specific
     * @param nameBoard
     * @return item selected
     */
    public MoveUserStories selectBoardToMove(String nameBoard){
        listBoards.selectByVisibleText(nameBoard);
        return this;
    }

    /**
     * click in the button Move of the from Move Card
     * @return new instance of ProjectsPage
     */
    public ProjectsPage clickMoveBtn(){
        moveBtn.click();
        return new ProjectsPage();
    }

    public ProjectsPage moveUserStorieToBoard(String nameBoardDestiny){
        selectBoardToMove(nameBoardDestiny);
        return clickMoveBtn();
    }
}
