package anonfile_reg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void registration_Test_Case_1() {
        s403o.findElement(By.xpath("//*[@id='footer']/div[2]/div/a[2]")).click(); // Click Reg btn
        s403o.findElement(By.xpath("//*[@id='site-wrapper']/div[4]/div[2]/form/div[1]/input")).sendKeys("testing@s403o"); // Username
        s403o.findElement(By.xpath("//*[@id='site-wrapper']/div[4]/div[2]/form/div[2]/input")).sendKeys("testing@s403o");; // Password
        s403o.findElement(By.xpath("//*[@id='site-wrapper']/div[4]/div[2]/form/div[3]/input")).sendKeys("testing@s403o");; // confirm Password
        WebElement create_btn = s403o.findElement(By.xpath("//*[@id='site-wrapper']/div[4]/div[2]/form/input[2]")); // looking for Create Account button
        JavascriptExecutor java = (JavascriptExecutor)s403o; // casting the Jsexe to be a Webdriver
        java.executeScript("scroll(0, 250)");
        create_btn.click();


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
