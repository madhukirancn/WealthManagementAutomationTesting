package com.sapient.qedge.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class DriverFactory {
    public static final int DEFAULT_ID = 2;
    public static WebDriver driver = null;

    public static WebDriver getDriver() {

        if (driver == null) {
            initializeDriver(DEFAULT_ID);
        }

        return driver;
    }

    private static void initializeDriver(int browserId) {

        switch (browserId) {
            case 1:
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "src\\main\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case 2:
                ChromeOptions options = new ChromeOptions();
                options.addExtensions(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\extension_2_17_0_0.crx"));
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver(capabilities);
                break;
            default:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
    }
}
