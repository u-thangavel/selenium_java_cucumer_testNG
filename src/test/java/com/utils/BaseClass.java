package com.utils;

import com.Pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Google googleWeb;
    public static Actions actions;
    protected static SoftAssert softAssert = new SoftAssert();


    @BeforeSuite
    public void cleanUP(){
        deleteFolder("allure-results");
        deleteFolder("screenshots");
    }
    @Before
    public static void launch() {
        if (driver.get() == null) {
            driver.set(WebDriverManager.getDriver("chrome"));
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get().manage().window().maximize();
            googleWeb = new Google(driver);
        }
    }

    @After
    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();  // Remove a driver from thread-local storage
        }
    }


    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElement(WebElement ele) {
        waitForElement(ele);
        ele.click();
    }

    public static String getProp(String propName) {
        Properties properties = PropertyReader.getProperties();
        return properties.getProperty(propName);
    }

    public static void waitFor(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getText(WebElement ele){
        return ele.getText();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static @Nullable String getTitle(){
       return driver.get().getTitle();
    }

    public static void deleteFolder(String folderName) {
        Path folder = Paths.get(folderName);
        try {
            if (Files.exists(folder)) {
                Files.walk(folder)
                        .sorted((a, b) -> b.compareTo(a)) // delete children first
                        .forEach(path -> {
                            try {
                                Files.delete(path);
                            } catch (IOException e) {
                                System.err.println("Failed to delete: " + path + " " + e.getMessage());
                            }
                        });
                System.out.println("Deleted folder: " + folderName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}