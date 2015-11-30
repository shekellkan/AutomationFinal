package ui;

import common.Utils;
import framework.DriverManager;
import org.openqa.selenium.WebDriver;
import ui.pages.HomePage;
import ui.pages.LoginPage;


/**
 * Created by silvia valencia on 4/14/2015.
 */
public class PageTransporter {
    private WebDriver driver = DriverManager.getInstance().getWebDriver();
    private String baseLoginURL = Utils.getProperty("baseLoginURL");
    private String baseHomeURL = Utils.getProperty("baseHomeURL");

    private static PageTransporter instance;

    protected PageTransporter() {
        initialize();
    }

    public static PageTransporter getInstance() {
        if(instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void initialize() {
//        log.info("Initialize the page transporter");
    }

    private void goToURL(String url) {
        driver.navigate().to(url);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public LoginPage navigateToLoginPage() {
        goToURL(baseLoginURL);
        return new LoginPage();
    }

    public HomePage navigateToHomePage() {
        goToURL(baseHomeURL);
        return new HomePage();
    }
}
