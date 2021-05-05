package com.urbanFindr.pageObjects.storeAdminPages;

import com.urbanFindr.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.sidebar_menu")
    public WebElement sidebarMenu;

    public boolean verifyStoreAdminSideBarMenuIsVisible() {
        wait.forPage();
        return sidebarMenu.isDisplayed();
    }
}
