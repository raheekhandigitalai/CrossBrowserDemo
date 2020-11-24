package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseUtil {

    private String accessKey = "eyJ4cC51IjoxMzUxODU5LCJ4cC5wIjoyLCJ4cC5tIjoiTVRVNE9ERXdNelkwTnpjMU5RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE5MDM0NjM2NDgsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.FMNRq2VCTgESYzVauY7amjtxD5JWhsimmdGMX0wMaXk";
    private String cloudURL = "https://usbank.experitest.com/wd/hub";

    public ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public RemoteWebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    @Parameters({"browserName", "browserVersion", "platform"})
    public void setUp(@Optional(BrowserType.CHROME) String browserName, @Optional("Any") String browserVersion,
                      String platform, @Optional Method method) throws MalformedURLException {
        startBrowser(browserName, browserVersion, platform, method);

        maximizeWindow();
    }

    private void startBrowser(String browserName, String browserVersion, String platform, Method method) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("testName", method.getName());

        if (platform.equalsIgnoreCase("Windows")) {

            dc.setCapability(CapabilityType.PLATFORM, Platform.WIN10);
            dc.setCapability(CapabilityType.VERSION, browserVersion);

            if (browserName.equalsIgnoreCase("Chrome")) {
                startChrome(dc);
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                startFirefox(dc);
            } else if (browserName.equalsIgnoreCase("IE")) {
                startIE(dc);
            }
        } else if (platform.equalsIgnoreCase("Mac")) {

            dc.setCapability(CapabilityType.PLATFORM, Platform.MAC);
            dc.setCapability(CapabilityType.VERSION, browserVersion);

            if (browserName.equalsIgnoreCase("Chrome")) {
                startChrome(dc);
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                startFirefox(dc);
            } else if (browserName.equalsIgnoreCase("IE")) {
                startIE(dc);
            }
        }
    }

    private void startChrome(DesiredCapabilities dc) throws MalformedURLException {
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        driver.set(new RemoteWebDriver(new URL(cloudURL), dc));
    }

    private void startFirefox(DesiredCapabilities dc) throws MalformedURLException {
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        driver.set(new RemoteWebDriver(new URL(cloudURL), dc));
    }

    private void startIE(DesiredCapabilities dc) throws MalformedURLException {
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.IE);
        driver.set(new RemoteWebDriver(new URL(cloudURL), dc));
    }

    private void startSafari(DesiredCapabilities dc) throws MalformedURLException {
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.SAFARI);
        driver.set(new RemoteWebDriver(new URL(cloudURL), dc));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }

    private void maximizeWindow() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int width = (int) toolkit.getScreenSize().getWidth();
        int height = (int) toolkit.getScreenSize().getHeight();
        getDriver().manage().window().setSize(new Dimension(width, height));
    }
}
