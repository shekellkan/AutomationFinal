package common;

import framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/17/15
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    /**
     * declare webelement
     */
    public static WebElement memberFound;
    public static WebDriver driver = DriverManager.getInstance().getWebDriver();
    private static Logger log = Logger.getLogger("RunCukesTest");

    /**
     * this method find a WebElement in the page
     * @param byElement
     * @return true or false
     */
    public static boolean isElementPresent(By byElement) {
        try {
            driver.findElement(byElement);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * this method find a WebElement in the page
     * @param byElement
     * @return true or false
     */
    public static boolean isElementPresentV2(By byElement) {
        try{
            return driver.findElement(byElement)!= null;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * this method search for a WemElement remove of the page
     * @param isTeamDeleted
     * @return
     */
    public static boolean waitElementIsRemoved(By isTeamDeleted){
        boolean result = true;
        int count = 0;
        int MaxCount = 10;
        try {
            while (result && count <= MaxCount){
                Thread.sleep(50);
                result = isElementPresent(isTeamDeleted);
                count++;
            }
        } catch (InterruptedException e){
            log.error("Exception Found Element is not Present");
        }
        return result;
    }

    /**
     * this method find a webelement for a path
     * @param member
     * @return webelement
     */
    public static WebElement findMember(By member){
        memberFound = driver.findElement(member);
        return memberFound;
    }

    /**
     * this method find webelement that has removed of the page
     * @param by
     * @return webelement
     */
    public static WebElement getStaleElem(By by) {
        try {
            return driver.findElement(by);
        } catch (StaleElementReferenceException e) {
            return getStaleElem(by);
        } catch (NoSuchElementException ele) {
            return getStaleElem(by);
        }
    }
}
