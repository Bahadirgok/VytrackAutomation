package com.vytrack.tests.smoke_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class MenuOptionsTest {

    WebDriver driver;
    String userNameLocator = "prependedInput";
    String passWordLocator = "prependedInput2";

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com");

    }

    @Test
    public void driverMenuOptions() throws Exception {
        driver.findElement(By.id(userNameLocator)).sendKeys("user174");
        driver.findElement(By.id(passWordLocator)).sendKeys("UserUser123", Keys.ENTER);
        Thread.sleep(2000);
        WebElement fleetLocator = driver.findElement(By.cssSelector("#main-menu > ul > li:nth-child(1) > a > span"));
        Actions action = new Actions(driver);
        action.moveToElement(fleetLocator).build().perform();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#main-menu > ul > li:nth-child(1) > div > div > ul > li.dropdown-menu-single-item.first > a > span")).click();
        Thread.sleep(5000);





    }
    @AfterMethod
    public void close(){
        driver.quit();
    }

}
