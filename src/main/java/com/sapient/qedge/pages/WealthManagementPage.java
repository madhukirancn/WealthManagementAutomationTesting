package com.sapient.qedge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WealthManagementPage {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Dashboard')]")
    WebElement dashboardLink;

    @FindBy(xpath = "//a[contains(text(),'Add User')]")
    WebElement addUser;

    @FindBy(xpath = "//h1[contains(text(),'Existing Investor')]")
    WebElement existinInvestorDetailsHeading;

    @FindBy(name = "fName")
    WebElement fName;

    @FindBy(name = "lName")
    WebElement lname;

    @FindBy(name = "age")
    WebElement age;

    @FindBy(name = "income")
    WebElement income;

    @FindBy(name = "expenses")
    WebElement expenses;

    @FindBy(name = "savings")
    WebElement savings;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submit;

    public WealthManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddUser() {
        addUser.click();
    }

    public void clickDashBoard() {
        dashboardLink.click();
    }

    public boolean verifyExistingInvestorHeading() {
        return existinInvestorDetailsHeading.isDisplayed();
    }

    public void setFirstName(String strFN) {
        fName.sendKeys(strFN);
    }

    public void setLastName(String strLN) {
        lname.sendKeys(strLN);
    }

    public void setAge(String strAge) {
        age.sendKeys(strAge);
    }

    public void setIncome(String strIncome) {
        income.sendKeys(strIncome);
    }

    public void setExpenses(String strExpense) {
        expenses.sendKeys(strExpense);
    }

    public void setSavings(String strSavings) {
        savings.sendKeys(strSavings);
    }

    public void clickSubmit() {
        submit.click();
    }


}
