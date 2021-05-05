package com.urbanFindr.stepDefinitions;

import com.urbanFindr.commons.configuration.Configuration;
import com.urbanFindr.commons.driver.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.urbanFindr.utils.WebDriverManager;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CommonSteps extends StepDefinitionsBase {

    public CommonSteps(ScenarioContext context) throws Throwable {
        super(context);
    }

    @Given("user is present on {string} site")
    public void userIsPresentOnSite(String envName) {
        EventFiringWebDriver driver = scenarioContext.getWebDriverManager().getDriver();
        String baseURL = "";
        if (envName.toLowerCase().contains("store")) {
            baseURL = Configuration.environment.store_url;
        } else if (envName.toLowerCase().contains("fm")) {
            baseURL = Configuration.environment.fm_admin_url;
        } else if (envName.toLowerCase().contains("customer")) {
            baseURL = Configuration.environment.customer_url;
        } else {
            throw new RuntimeException("You must specify either Store Admin OR FM Admin OR customer");
        }

        driver.get(baseURL);
    }

    @And("User go to {string} site")
    public void userGoToSite(String envName) {

        EventFiringWebDriver driver = scenarioContext.getWebDriverManager().getDriver();
        String baseURL = "";
        if (envName.toLowerCase().contains("store")) {
            baseURL = Configuration.environment.store_url;
        } else if (envName.toLowerCase().contains("fm")) {
            baseURL = Configuration.environment.fm_admin_url;
        } else if (envName.toLowerCase().contains("customer")) {
            baseURL = Configuration.environment.customer_url;
        } else {
            throw new RuntimeException("You must specify either Store Admin OR FM Admin OR customer");
        }

        driver.get(baseURL);
    }
}