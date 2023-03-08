package anonfile_reg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * TestNG for registration at anonfile
 */
public class registration_Test {
    WebDriver s403o; // interface
    @Test
    public void registration_Test_Case() {

    }

    @BeforeClass
    public void open_browser() {
        System.setProperty("webdriver.chrome.driver",
                "/usr/bin/chromedriver");
        s403o = new ChromeDriver(); // implment interface
        s403o.get("https://anonfiles.com/");
    }
    @AfterClass
    public void close_browser() {
        s403o.close();
    }
}
