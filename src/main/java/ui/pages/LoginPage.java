package ui.pages;

import common.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ui.BasePageObject;

import javax.swing.*;
import java.util.NoSuchElementException;

/**
 * Created by amateur.
 */
public class LoginPage extends BasePageObject {

    @FindBy(name = "user")
    @CacheLookup
    WebElement userNameInput;

    @FindBy(name = "password")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(id = "login")
    WebElement loginBtn;

    @FindBy(className = "error-message")
    WebElement error;

    /**
     * contruct of LoginPage
     */
    public LoginPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        //wait.until(ExpectedConditions.visibilityOf(loginBtn));
    }

    /**
     * change and entered a value in the field UserName in the form of login
     * @param userName
     * @return the same instance of LoginPage
     */
    public LoginPage setUserNameInput(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        return this;
    }

    /**
     * change and entered a value in the field Password in the form of login
     * @param password
     * @return the same instance of LoginPage
     */
    public LoginPage setPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    /**
     * method that is make click in the button login when the login is successful
     * @return new instance of MainPage
     */
    public MainPage clickLoginBtnSuccessful() {
        loginBtn.click();
        return new MainPage();
    }

    /**
     * method that is make in the button login when the login fail
     * @return the same instance of the LoginPage
     */
    public LoginPage clickLoginBtnFailed() {
        loginBtn.click();
        return this;
    }

    /**
     * set the value in the fields Username and Password in the form login
     * @param userName
     * @param password
     */
    public void login(String userName, String password) {
        setUserNameInput(userName);
        setPasswordInput(password);
    }

    /**
     * method that call the method login() for the change the values of the field
     * UserName and Password and late make click for the login is successful
     * @param userName
     * @param password
     * @return new instance of MainPage
     */
    public MainPage loginSuccessful(String userName, String password) {
        login(userName, password);
        return clickLoginBtnSuccessful();
    }

    /**
     * this method is called when the login is fail, entered values in the fields
     * UserName and Password invalids
     * @param userName
     * @param password
     * @return the same instance of LoginPage
     */
    public LoginPage loginFailed(String userName, String password) {
        login(userName, password);
        return clickLoginBtnFailed();
    }

    /**
     * this method obtain a error message when the login is fail
     * @return
     */
    public boolean getErrorMessage(){
        return Utils.isElementPresent(By.xpath("//div[@id='error']//p[@class='error-message']"));
    }
}
