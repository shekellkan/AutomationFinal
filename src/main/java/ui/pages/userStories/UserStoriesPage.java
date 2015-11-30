package ui.pages.userStories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.projects.ProjectsPage;
import ui.pages.userStories.MenuUserStories.AddCheckListPage;
import ui.pages.userStories.MenuUserStories.DueDatePage;

/**
 * Created by amateur on 29/11/2015.
 */
public class UserStoriesPage extends BasePageObject {
    private MenuUserStoriesPage menuUserStories;
    private AddCheckListPage addCheckListPage;
    private DueDatePage dueDatePage;

    @FindBy(xpath = "//div[contains(@class,'card-detail-title')]/h2[contains(@class,'js-card-title')]")
    WebElement titleUserStories;
    @FindBy(xpath = "//div[contains(@class,'js-tab-parent')]/a[contains(@class,'icon-close')]")
    WebElement iconClose;
    @FindBy(xpath = "//div[contains(@class,'comment-box')]/textarea")
    WebElement commentTextArea;
    @FindBy(xpath = "//div[contains(@class,'add-controls')]/input[contains(@class,'js-add-comment')]")
    WebElement addCommentBtn;
    @FindBy(xpath = "//div[contains(@class,'action-comment')]/div[contains(@class,'current-comment')]/p")
    WebElement currentComment;
    @FindBy(xpath = "//div[contains(@class,'js-card-detail-due-date')]/h3")
    WebElement dueDate;


    WebElement subTaskTextArea;
    WebElement addSubTaskBtn;
    WebElement titleTaskInUserStories;

    /**
     * construct of MenuActionsUserStories class
     */
    public UserStoriesPage(){
        menuUserStories = new MenuUserStoriesPage();
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleUserStories));
    }

    public String getNameUserStories(){
        return titleUserStories.getText();
    }

    /**
     * click in the item menu Add CheckList
     * @return new instance of AddCheckList
     */
    public AddCheckListPage clickCheckList(){
        return menuUserStories.clickAddCheckList();
    }

    /**
     * create a new task for the user stories
     * @param newTask
     * @return
     */
    public UserStoriesPage createTask(String newTask){
        addCheckListPage = clickCheckList();
        return addCheckListPage.createCheckList(newTask);
    }

    /**
     * click in the Icon close of the Page UserStories
     * @return new instance of ProjectsPage
     */
    public ProjectsPage outOfUserStories(){
        iconClose.click();
        return new ProjectsPage();
    }

    /**
     * this method builds a path for the search of a task in the user storie
     * @param titleTask
     * @return path
     */
    public String buildPathTaskTitle(String titleTask){
        return "//div[contains(@class,'checklist-title')]/h3[contains(text(),'"+titleTask+"')]";
    }

    /**
     * this method build a path root for a task
     * @param nameTask
     * @return path
     */
    public String buildPathTask(String nameTask){
        return "//div[contains(@class,'checklist')]/div/div/h3[contains(text(),'"+nameTask+"')]/../../..";
    }

    /**
     * this method build a path for the textarea of a task
     * @param nameTask
     * @return path
     */
    public String buildPathTextAreaNewTask(String nameTask){
        return buildPathTask(nameTask) + "//div[contains(@class,'checklist-new-item')]/textarea";
    }

    /**
     * this method build a path for the button Add of a task
     * @param nameTask
     * @return
     */
    public String buildPathAddBtn(String nameTask){
        return buildPathTask(nameTask) + "//div[contains(@class,'checklist-new-item')]/div/input[contains(@class,'js-add-checklist-item')]";
    }

    /**
     * this method verify that a task is present in the UserStories
     * @param titleTask
     * @return true or false
     */
    public boolean isTaskPresent(String titleTask){
        titleTaskInUserStories = driver.findElement(By.xpath(buildPathTaskTitle(titleTask)));
        return titleTaskInUserStories.isDisplayed();
    }

    /**
     * set the value in the textarea for to create a new subtask
     * @param nameTask
     * @param titleSubTask
     * @return the same instance of UserStoriesPage
     */
    public UserStoriesPage setNameSubTask(String nameTask, String titleSubTask){
        subTaskTextArea = driver.findElement(By.xpath(buildPathTextAreaNewTask(nameTask)));
        subTaskTextArea.clear();
        subTaskTextArea.sendKeys(titleSubTask);
        return this;
    }

    /**
     * click in the button Add in the form to create a subTask
     * @param nameTask
     * @return the same instance of UserStoriesPage
     */
    public UserStoriesPage clickAddBtn(String nameTask){
        addSubTaskBtn = driver.findElement(By.xpath(buildPathAddBtn(nameTask)));
        addSubTaskBtn.click();
        return this;
    }

    /**
     * this method create a new SubTask into a Task
     * @param nameTask
     * @param nameSubTask
     * @return the same instance of UserStoriesPage
     */
    public UserStoriesPage createSubTaskIntoTask(String nameTask, String nameSubTask){
        createTask(nameTask);
        setNameSubTask(nameTask, nameSubTask);
        return clickAddBtn(nameTask);
    }

    /**
     * set the value of the textarea for add a comment in the UserStories
     * @param comment
     * @return the same instance of UserStoriesPage
     */
    public UserStoriesPage serCommentTextArea(String comment){
        commentTextArea.clear();
        commentTextArea.sendKeys(comment);
        return this;
    }

    /**
     * click in the button Add comment
     * @return the same instance of UserStoriesPage
     */
    public UserStoriesPage clickAddComment(){
        addCommentBtn.click();
        return this;
    }

    /**
     * add a new comment in the UserStories
     * @param comment
     * @return the same instance of UserStoriesPage
     */
    public UserStoriesPage addCommentInUserStories(String comment){
        serCommentTextArea(comment);
        return clickAddComment();
    }

    /**
     * add a deadline for the userStories
     * @return the same instance of UserStories
     */
    public UserStoriesPage clickAddDueDate(){
        dueDatePage = menuUserStories.clickDueDate();
        return dueDatePage.clickSaveCalendarBtn();
    }

    /**
     * get the current comment entered in the UserStories
     * @return comment
     */
    public String getCurrentComment(){
        return currentComment.getText();
    }

    public boolean isDueDatePresent(){
        return dueDate.isDisplayed();
    }
}
