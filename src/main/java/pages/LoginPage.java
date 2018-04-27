package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends PageObject {

    public LoginPage(ThreadLocal<RemoteWebDriver> mDriver) {
        super(mDriver);
    }

    @FindAll({
            @FindBy(className = "login-btn"),
            @FindBy(xpath = "//a[text()='Login']")
    })
    List<WebElement> loginButtonMainPage;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//div[text()='Please enter your email address']")
    WebElement invalidEmailMessage;

    @FindBy(xpath = "//div[text()='Please enter your password']")
    WebElement invalidPasswordMessage;

    @FindBy(xpath = "//div[text()='Password is too short']")
    WebElement shortPasswordMessage;

    public LoginPage navigateToLoginPage() {
        getDriver().navigate().to("https://seetest.io/login?source=experitest");
        return this;
    }

    public LoginPage clickOnLoginButtonMainPage() {
        for (WebElement loginButton : loginButtonMainPage) {
            loginButton.click();
            wait.until(ExpectedConditions.visibilityOf(emailField));
            if (emailField.isDisplayed()) {
                break;
            }
        }
        return this;
    }

    public LoginPage enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickOnLogin() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
        return this;
    }

    public boolean invalidEmail() {
        wait.until(ExpectedConditions.visibilityOf(invalidEmailMessage));
        return invalidEmailMessage.isDisplayed();
    }

    public boolean invalidPassword() {
        wait.until(ExpectedConditions.visibilityOf(invalidPasswordMessage));
        return invalidPasswordMessage.isDisplayed();
    }

    public boolean shortPassword() {
        wait.until(ExpectedConditions.visibilityOf(shortPasswordMessage));
        return shortPasswordMessage.isDisplayed();
    }
}
