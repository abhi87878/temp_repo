package cloudapi;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class cloud {

    WebDriver driver;

    // ✅ BrowserStack credentials
    public static final String USERNAME = "abhinavkumar_g68tmz";
    public static final String AUTOMATE_KEY = "ESsn5nimXH22cBk9KhDk";
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeMethod
    public void setUp() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            Map<String, Object> bstackOptions = new HashMap<>();
            bstackOptions.put("deviceName", "iPhone 12 Pro");
            bstackOptions.put("osVersion", "14");
            bstackOptions.put("projectName", "Cognixia Cloud Project");
            bstackOptions.put("buildName", "Cognixia Cloud Test Build");
            bstackOptions.put("sessionName", "OrangeHRM Login Test on BrowserStack");

            caps.setCapability("browserName", "safari");
            caps.setCapability("bstack:options", bstackOptions);

            driver = new RemoteWebDriver(new URL(URL), caps);

            // ✅ Open OrangeHRM site via BrowserStack
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        } catch (Exception e) {
            e.printStackTrace(); // 🔴 Prints error if connection/setup fails
        }
    }

    @Test
    public void testcaseCloud() {
        System.out.println("✅ Connected to BrowserStack successfully and launched OrangeHRM!");
        System.out.println("Page Title: " + driver.getTitle());
    }

    @AfterTest
    public void closeSession() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
