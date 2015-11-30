package ui.pages.projects;

import org.apache.velocity.runtime.directive.Scope;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by MiguelTerceros on 11/27/2015.
 */
public class InfoMemberPage extends BasePageObject {
    @FindBy(xpath = "//h3[contains(@class,'mini-profile-info-title')]/a[contains(@class,'mini-profile-info-title-link')]")
    WebElement titleProfile;
    @FindBy(xpath = "//div[contains(@class,'js-pop-over-header')]/a[contains(@class,'icon-close')]")
    WebElement iconCloseBtn;

    /**
     * construct of InfoMemberPage
     */
    public InfoMemberPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleProfile));
    }

    /**
     * this method verify that the title of the info page is present
     * @return true or false
     */
    public boolean isTitleProfilePresent(){
        return titleProfile.isDisplayed();
    }

    /**
     * this method get the text of the title profile
     * @return title of profile
     */
    public String getTextTitleProfile(){
        return titleProfile.getText();
    }

    public ProjectMenuPage closeInfoMember() {
        iconCloseBtn.click();
        return new ProjectMenuPage();
    }
}
