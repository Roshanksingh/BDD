package com.urbanFindr.stepDefinitions.storeAdmin;

import com.urbanFindr.commons.driver.ScenarioContext;
import com.urbanFindr.pageObjects.storeAdminPages.StoreLoginPage;
import com.urbanFindr.stepDefinitions.CommonSteps;
import com.urbanFindr.stepDefinitions.StepDefinitionsBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginWindowSteps extends StepDefinitionsBase {

    public StoreLoginPage storeLoginPage;

    public LoginWindowSteps(ScenarioContext context) throws Throwable {
        super(context);
        storeLoginPage = new StoreLoginPage(context.driver);
    }

    @When("user logged in with valid credentials")
    public void userLoggedInWithValidCredentials() {
        storeLoginPage.loginWithStoreAdmin();
    }
}
