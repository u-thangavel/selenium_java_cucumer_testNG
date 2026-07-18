package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class WebDriverManager {
    static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();
    public static WebDriver getDriver(String browser) {
        if (localDriver.get() == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    localDriver.set(new ChromeDriver());
                    break;
                case "edge":
                    localDriver.set(new EdgeDriver());
                    break;
                default:
                    System.out.println("Unsupported browser type or Browser is null so " + browser + ". Defaulting to Chrome.");
                    localDriver.set(new ChromeDriver());
                    break;
            }
            localDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            localDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            localDriver.get().manage().window().maximize();
        }
        return localDriver.get();
    }

    public static void quitDriver() {
        if (localDriver.get() != null) {
            localDriver.get().quit();
            localDriver.remove();  // Remove driver from thread-local storage
        }
    }

}