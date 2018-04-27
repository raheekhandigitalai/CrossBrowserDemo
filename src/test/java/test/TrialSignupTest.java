package test;

import base.BaseUtil;
import org.testng.annotations.Test;
import pages.TrialSignupPage;

import static org.testng.Assert.assertTrue;

public class TrialSignupTest extends BaseUtil {

    @Test
    public void registerWithInvalidFirstName() {
        TrialSignupPage user = new TrialSignupPage(driver);
        user.navigateToTrialPage();

        user
                .enterLastName("User")
                .enterEmail("valid@experitest.com")
                .enterCountry("United States - East Coast")
                .enterPhone("3470000000")
                .enterPassword("Abcdef123");

        user.clickSubmit();
        assertTrue(user.invalidFirstName());
    }

    @Test
    public void registerWithInvalidLastName() {
        TrialSignupPage user = new TrialSignupPage(driver);
        user.navigateToTrialPage();

        user
                .enterFirstName("Test")
                .enterEmail("valid@experitest.com")
                .enterCountry("United States - East Coast")
                .enterPhone("3470000000")
                .enterPassword("Abcdef123");

        user.clickSubmit();
        assertTrue(user.invalidLastName());
    }

    @Test
    public void registerUsingInvalidEmail() {
        TrialSignupPage user = new TrialSignupPage(driver);
        user.navigateToTrialPage();

        user
                .enterFirstName("test")
                .enterLastName("user")
                .enterEmail("invalid@gmail.com")
                .enterCountry("United States - East Coast")
                .enterPhone("3470000000")
                .enterPassword("Abcdef123");

        user.clickSubmit();
        assertTrue(user.invalidEmail());
    }

    @Test
    public void registerUsingInvalidCountry() {
        TrialSignupPage user = new TrialSignupPage(driver);
        user.navigateToTrialPage();

        user
                .enterFirstName("test")
                .enterLastName("user")
                .enterEmail("valid@experitest.com")
                .enterPhone("3470000000")
                .enterPassword("Abcdef123");

        user.clickSubmit();
        assertTrue(user.invalidCountry());
    }

    @Test
    public void registerUsingInvalidPhone() {
        TrialSignupPage user = new TrialSignupPage(driver);
        user.navigateToTrialPage();

        user
                .enterFirstName("test")
                .enterLastName("user")
                .enterEmail("valid@experitest.com")
                .enterCountry("United States - East Coast")
                .enterPassword("Abcdef123");

        user.clickSubmit();
        assertTrue(user.invalidPhone());
    }

    @Test
    public void registerUsingInvalidPassword() {
        TrialSignupPage user = new TrialSignupPage(driver);
        user.navigateToTrialPage();

        user
                .enterFirstName("test")
                .enterLastName("user")
                .enterEmail("valid@experitest.com")
                .enterCountry("United States - East Coast")
                .enterPhone("3470000000");

        user.clickSubmit();
        assertTrue(user.invalidPassword());
    }

}
