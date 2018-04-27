package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    protected ThreadLocal<RemoteWebDriver> driver;
    protected WebDriverWait wait;

    public PageObject(ThreadLocal<RemoteWebDriver> mDriver) {
        this.driver = mDriver;
        wait = new WebDriverWait(getDriver(), 5);
        PageFactory.initElements(getDriver(), this);
    }

    protected RemoteWebDriver getDriver() {
        return driver.get();
    }

}
