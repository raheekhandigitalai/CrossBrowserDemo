package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TrialSignupPage extends PageObject {

    public TrialSignupPage(ThreadLocal<RemoteWebDriver> mDriver) {
        super(mDriver);
    }

    @FindBy(id = "fname")
    WebElement firstNameField;

    @FindBy(id = "lname")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "country")
    WebElement countrySelect;

    @FindBy(id = "phone")
    WebElement phoneField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//span[text()='First name is required.']")
    WebElement invalidFirstNameMessage;

    @FindBy(xpath = "//span[text()='Last name is required.']")
    WebElement invalidLastNameMessage;

    @FindBy(xpath = "//span[text()='Please enter valid company email.']")
    WebElement invalidEmailMessage;

    @FindBy(xpath = "//span[text()='Country is required.']")
    WebElement invalidCountryMessage;

    @FindBy(xpath = "//span[text()='Phone is required.']")
    WebElement invalidPhoneMessage;

    @FindBy(className = "error-msg")
    WebElement invalidPasswordMessage;

    public TrialSignupPage navigateToTrialPage() {
        getDriver().navigate().to("https://experitest.com/free-trial");
        return this;
    }

    public TrialSignupPage enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys(firstName);
        return this;
    }

    public TrialSignupPage enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        lastNameField.sendKeys(lastName);
        return this;
    }

    public TrialSignupPage enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
        return this;
    }

    public TrialSignupPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        return this;
    }

    public TrialSignupPage enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneField));
        phoneField.sendKeys(phone);
        return this;
    }

    public TrialSignupPage enterCountry(String country) {
        wait.until(ExpectedConditions.visibilityOf(countrySelect));
        Select countryList = new Select(countrySelect);
        countryList.selectByValue(country);
        return this;
    }

    public TrialSignupPage clickSubmit() {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
        return this;
    }

    public boolean invalidFirstName() {
        wait.until(ExpectedConditions.visibilityOf(invalidFirstNameMessage));
        return invalidFirstNameMessage.isDisplayed();
    }

    public boolean invalidLastName() {
        wait.until(ExpectedConditions.visibilityOf(invalidLastNameMessage));
        return invalidLastNameMessage.isDisplayed();
    }

    public boolean invalidEmail() {
        wait.until(ExpectedConditions.visibilityOf(invalidEmailMessage));
        return invalidEmailMessage.isDisplayed();
    }

    public boolean invalidCountry() {
        wait.until(ExpectedConditions.visibilityOf(invalidCountryMessage));
        return invalidCountryMessage.isDisplayed();
    }

    public boolean invalidPhone() {
        wait.until(ExpectedConditions.visibilityOf(invalidPhoneMessage));
        return invalidPhoneMessage.isDisplayed();
    }

    public boolean invalidPassword() {
        wait.until(ExpectedConditions.visibilityOf(invalidPasswordMessage));
        return invalidPasswordMessage.isDisplayed();
    }

}
