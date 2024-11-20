package org.example.stepDefs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.stepDefs.Hooks.driver;
public class test {
    WebDriver driver;
    @BeforeTest

    public void beforeTest() {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/checkout-step-one.html");

    }
    @Test
    public void stepOne() {
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("samah");

    }

}
