package common;

import ui.PageTransporter;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.pages.TopMenuPage;

/**
 * Created by Miguel Terceros on 24/11/2015.
 */

public class CommonMethods {
    /**
     * declare instance of pages
     */
    private static PageTransporter pageTransporter = PageTransporter.getInstance();
    private static TopMenuPage topMenuPage;
    private static LoginPage loginPage;
    private static MainPage mainPage;

    /**
     * declare variables
     */
    public static boolean isLogin = false;
    public static boolean isLogout = false;

    /**
     * this method is logout of the web page trello.com
     */
    public static void logOut() {
        topMenuPage = new TopMenuPage();
        topMenuPage.logout();
        isLogout = true;
    }

    /**
     * this method it make in the web page trello.com
     */
    public static void logIn() {
        loginPage = pageTransporter.navigateToLoginPage();
        loginPage.loginSuccessful("miguel.terceros@fundacion-jala.org", "morfeo3730");
        isLogin = true;
    }
}
