package cloudapi;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class abhi {

    WebDriver driver;

    // BrowserStack credentials
    public static final String USERNAME = "abhinavkumar_g68tmz";
    public static final String AUTOMATE_KEY = "ESsn5nimXH22cBk9KhDk";
    public static final String HUB_URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeTest
    public void setUp() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            Map<String, Object> bstackOptions = new HashMap<>();
            bstackOptions.put("projectName", "Cognixia Cloud Project");
            bstackOptions.put("buildName", "Cognixia Cloud Test Build");
            bstackOptions.put("sessionName", "OrangeHRM Test");
            bstackOptions.put("deviceName", "iPhone 12 Pro");
            bstackOptions.put("osVersion", "14");

            caps.setCapability("browserName", "safari");
            caps.setCapability("bstack:options", bstackOptions);

            driver = new RemoteWebDriver(new URL(HUB_URL), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void openOrangeHRM() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Page Title: " + driver.getTitle());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
