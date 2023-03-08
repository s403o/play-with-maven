package anonfile_reg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * TestNG for registration at anonfile
 */
public class registration_Test {
    WebDriver s403o; // interface

    @Test
    public void registration_Test_Cases() {
        try {
            // Register
            s403o.findElement(By.xpath("//*[@id='footer']/div[2]/div/a[2]")).click(); // Click Reg btn
            s403o.findElement(By.xpath("//*[@id='site-wrapper']/div[4]/div[2]/form/div[1]/input")).sendKeys("testing@s403o"); // Username
            s403o.findElement(By.xpath("//*[@id='site-wrapper']/div[4]/div[2]/form/div[2]/input")).sendKeys("testing@s403o");; // Password
            s403o.findElement(By.xpath("//*[@id='site-wrapper']/div[4]/div[2]/form/div[3]/input")).sendKeys("testing@s403o");; // confirm Password
            WebElement create_btn = s403o.findElement(By.xpath("//*[@id='site-wrapper']/div[4]/div[2]/form/input[2]")); // looking for Create Account button
            JavascriptExecutor java = (JavascriptExecutor)s403o; // casting the Jsexe to be a Webdriver
            java.executeScript("scroll(0, 250)");
            create_btn.click();
            WebElement username = s403o.findElement(By.xpath("//*[@id='navbar']/ul/li/ul/li[1]"));
            Assert.assertEquals(username, "Username: testing@s403o"); // Account Exist!
            
            
        } catch (Exception e) {
            // Login
            JavascriptExecutor java = (JavascriptExecutor)s403o;
            java.executeScript("scroll(0, 250)"); // Scroll
            WebElement login_btn = s403o.findElement(By.xpath("//*[@id='footer']/div[2]/div/a[1]"));
            login_btn.click();
            s403o.findElement(By.xpath("//*[@id='site-wrapper']/div[4]/div[2]/form/div[1]/input")).sendKeys("testing@s403o"); // username
            s403o.findElement(By.xpath("//*[@id='site-wrapper']/div[4]/div[2]/form/div[2]/input")).sendKeys("testing@s403o"); // Password
            s403o.findElement(By.xpath("//*[@id='site-wrapper']/div[4]/div[2]/form/input[2]")).click();  // Click Login Btn
        }
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
        WebElement wait = new WebDriverWait(s403o, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='account-bytes-left-readable']")));
        System.out.println(wait.getText());
        s403o.close();
    }
}
