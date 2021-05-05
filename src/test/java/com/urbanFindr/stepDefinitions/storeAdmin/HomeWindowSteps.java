package com.urbanFindr.stepDefinitions.storeAdmin;

import com.urbanFindr.commons.driver.ScenarioContext;
import com.urbanFindr.pageObjects.storeAdminPages.HomePage;
import com.urbanFindr.stepDefinitions.StepDefinitionsBase;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomeWindowSteps extends StepDefinitionsBase {

    public HomePage homePage;

    public HomeWindowSteps(ScenarioContext context) throws Throwable {
        super(context);
        homePage = new HomePage(context.driver);
    }

    @Then("User will see menu page")
    public void userWillSeeMenuPage() {
//        Assert.assertTrue(homePage.sidebarMenu.isDisplayed());
    }
}
