package com.urbanFindr.pageObjects.storeAdminPages;


import com.urbanFindr.commons.configuration.Configuration;
import com.urbanFindr.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoreLoginPage extends BasePage {

    public StoreLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name=user_login]")
    WebElement userName;

    @FindBy(css = "input[type=password]")
    WebElement passwordInput;

    @FindBy(css = "button[type=submit]")
    WebElement loginButton;

    public void setUsername(String username) {
        wait.forPage();
        userName.clear();
        userName.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void loginWithStoreAdmin() {
        String username = Configuration.environment.storeAdminUsername;
        String password = Configuration.environment.storeAdminPassword;
        login(username, password);
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        loginButton.click();
    }
}
