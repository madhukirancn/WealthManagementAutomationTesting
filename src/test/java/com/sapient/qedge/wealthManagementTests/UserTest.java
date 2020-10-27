package com.sapient.qedge.wealthManagementTests;

import com.sapient.qedge.BaseTest;
import com.sapient.qedge.pages.WealthManagementPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class UserTest extends BaseTest {

    WealthManagementPage wmPage;

    @BeforeTest
    public void openWealthManagement() {
        driver.get("http://localhost:3000/");
        wmPage = new WealthManagementPage(driver);

    }

    @Test(description = "Test to verify Add User Link", dataProvider = "User Data")
    public void verifyAddUserLink(List<String> ls) {
        wmPage.clickAddUser();
        wmPage.setFirstName(ls.get(0));
        wmPage.setLastName(ls.get(1));
        wmPage.setAge(ls.get(2));
        wmPage.setIncome(ls.get(3));
        wmPage.setExpenses(ls.get(4));
        wmPage.setSavings(ls.get(5));
        wmPage.clickSubmit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(wmPage.verifyExistingInvestorHeading(), true);
    }

    @DataProvider(name = "User Data")
    private Object[][] getUserData() {
        List<String> list = Arrays.asList("FirstABC", "LastXYZ", "20", "1000", "800", "200");
        List<String> list1 = Arrays.asList("TestABC", "TempXYZ", "23", "100", "80", "10");
        return new Object[][]{
                {list},
                {list1}
        };
    }

    @Test(description = "Test to Verify DashBoard Link")
    public void verifyDashboardLink() {
        wmPage.clickDashBoard();
        Assert.assertEquals(wmPage.verifyExistingInvestorHeading(), true);
    }

}
