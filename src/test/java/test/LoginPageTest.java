package test;

import base.BaseUtil;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginPageTest extends BaseUtil {

    @Test
    public void loginUsingInvalidEmail() {
        LoginPage user = new LoginPage(driver);
        user.navigateToLoginPage();

        user
                .enterPassword("12345678");

        user.clickOnLogin();
        assertTrue(user.invalidEmail());
    }

    @Test
    public void loginUsingInvalidPassword() {
        LoginPage user = new LoginPage(driver);
        user.navigateToLoginPage();

        user
                .enterEmail("test@experitest.com");

        user.clickOnLogin();
        assertTrue(user.invalidPassword());
    }

    @Test
    public void loginUsingEmptyCredentials() {
        LoginPage user = new LoginPage(driver);
        user.navigateToLoginPage();

        user.clickOnLogin();
        assertTrue(user.invalidEmail());
        assertTrue(user.invalidPassword());
    }

    @Test
    public void loginUsingShortPassword() {
        LoginPage user = new LoginPage(driver);
        user.navigateToLoginPage();

        user
                .enterEmail("test@experitest.com")
                .enterPassword("123456");

        user.clickOnLogin();
        assertTrue(user.shortPassword());
    }

}
