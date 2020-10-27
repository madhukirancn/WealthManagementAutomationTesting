package com.sapient.qedge;

import com.sapient.qedge.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    public WebDriver driver = null;


    @BeforeSuite
    public void initialLoggerSetUp() {
        System.out.println("In Base Test Suite");
        this.driver = DriverFactory.getDriver();

    }

    @AfterSuite
    public void teardown() {
        driver.close();

    }

}
