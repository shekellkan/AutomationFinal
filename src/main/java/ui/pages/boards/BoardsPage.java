package ui.pages.boards;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.Projects;
import ui.BasePageObject;
import ui.pages.projects.ProjectsPage;
import ui.pages.userStories.UserStoriesPage;

/**
 * Created by amateur on 22/11/2015.
 */
public class BoardsPage extends BasePageObject {
    Actions builder = new Actions(driver);

    /**
     * declare webelements
     */
    @FindBy(xpath = "//div[contains(@class,'list-header')]/h2[contains(@class,'list-header-name')]")
    WebElement titleBoard;
    @FindBy(xpath = "//textarea[contains(@class,'js-card-title')]")
    WebElement textAreaName;
    @FindBy(xpath = "//input[contains(@class,'confirm') and contains(@value,'Add')]")
    WebElement addStoriesBtn;

    WebElement addCardBtn;
    WebElement userStoriesPresent;
    WebElement userStoriesEditBtn;
    WebElement userStoriesBtn;

    /**
     * construct of BoardPage
     */
    public BoardsPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleBoard));
    }

    /************ ADD CARD ************/
    /**
     * click in the button Add Card
     * @return the same instance of BoardPage
     */
    public BoardsPage clickAddCard(String nameBoard){
        System.out.println("antes de la busqueda del botton **********" + buildPathBoard(nameBoard));
        addCardBtn = driver.findElement(By.xpath(buildPathBoard(nameBoard)));
        System.out.println(buildPathBoard(nameBoard) + " --------");
        addCardBtn.click();
        return this;
    }

    /**
     * set the value of Name in the text area of the form for to create a Board
     * @param nameUserStories
     * @return the same instance of BoardsPage
     */
    public BoardsPage setTextAreaField(String nameUserStories){
        textAreaName.clear();
        textAreaName.sendKeys(nameUserStories);
        return this;
    }

    /**
     * click in the button Add Stories
     * @return the same instance of ProjectsPage
     */
    public ProjectsPage clickAddStories(){
        addStoriesBtn.click();
        return new ProjectsPage();
    }

    /**
     * method for to create a UserStorie
     * @param nameUserStories
     * @return the same instance of ProjectsPage
     */
    public ProjectsPage createUserStories(String nameUserStories, String nameBoard){
        clickAddCard(nameBoard);
        setTextAreaField(nameUserStories);
        return clickAddStories();
    }

    /**
     * this method constructed a path for the search of the button add user storie
     * @param nameBoard
     * @return path
     */
    public String buildPathBoard(String nameBoard){
        return "//div[contains(@class,'list-header')]/h2[contains(text(),'"+nameBoard+"')]/../.." +
                "//a[contains(text(),'Add a card')]";
    }

    /**
     * this method builds a path for the search of a UserStories in a board
     * @param nameBoard
     * @param userStories
     * @return path
     */
    public String buildPathUserStoriesInBoard(String nameBoard, String userStories){
        return "//div[contains(@class,'list-header')]/h2[contains(text(),'"+nameBoard+"')]/../.." +
                "//div[contains(@class,'js-list-cards')]/div/div[contains(@class,'list-card-details')]/a[contains(text(),'"+userStories+"')]";
    }

    /**
     * this method builds a path for the search of the button edit of a userStories
     * @param nameBoard
     * @param userStories
     * @return path
     */
    public String buildPathUserStorieEditBtn(String nameBoard, String userStories){
        return "//div[contains(@class,'list-header')]/h2[contains(text(),'"+nameBoard+"')]/../.." +
                "//div[contains(@class,'js-list-cards')]/div/div[contains(@class,'list-card-details')]/a[contains(text(),'"+userStories+"')]/../.." +
                "//span[contains(@class,'icon-edit')]";
    }

    public String buildPathUserStories(String userStories){
        return "//div[contains(@class,'list-header')]/h2[contains(@class,'list-header-name')]/../.." +
                "//div[contains(@class,'js-list-cards')]/div/div[contains(@class,'list-card-details')]/a[contains(text(),'"+userStories+"')]";
    }

    /**
     * this method verify that a userStories is present in a determine board
     * @param nameBoard
     * @param nameUserStories
     * @return name of the userStories
     */
    public String isUserStoriesPresent(String nameBoard, String nameUserStories) {
        userStoriesPresent = driver.findElement(By.xpath(buildPathUserStoriesInBoard(nameBoard, nameUserStories)));
        return userStoriesPresent.getText();
    }

    /**
     * click in the icon Edit of a UserStories
     * @param nameBoard
     * @param nameUserStories
     * @returnnew instance of MenuActionsUserStories
     */
    public MenuActionsUserStories clickEditUserStories(String nameBoard, String nameUserStories){
        userStoriesEditBtn = driver.findElement(By.xpath(buildPathUserStorieEditBtn(nameBoard, nameUserStories)));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", userStoriesEditBtn);
        return new MenuActionsUserStories();
    }

    /**
     * this method make click in a UserStories
     * @param nameUserStories
     * @return new instance of UserStoriesPage
     */
    public UserStoriesPage clickInUserStories(String nameUserStories){
        userStoriesBtn = driver.findElement(By.xpath(buildPathUserStories(nameUserStories)));
        userStoriesBtn.click();
        return new UserStoriesPage();
    }
}
