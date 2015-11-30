package ui.pages.teams.MenuTeams;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;


/**
 * Created by MiguelTerceros on 11/24/2015.
 */
public class BusinessClassMenuPage extends BasePageObject{
    @FindBy(xpath = "//div[contains(@class,'window-module-title')]/h3/span[contains(text(),'Billing')]")
    WebElement BillingLbl;

    /**
     * Construct of BusinessClass
     */
    public BusinessClassMenuPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(BillingLbl));
    }
}
