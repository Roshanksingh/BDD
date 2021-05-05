package com.urbanFindr.pageObjects;

import com.urbanFindr.commons.configuration.Configuration;
import com.urbanFindr.helper.ExplicitWait;
import com.urbanFindr.helper.JavaScriptHelper;
import com.urbanFindr.commons.driver.ScenarioContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.NoSuchElementException;

public class BasePage {

    public static Logger log = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;
    protected ExplicitWait wait;
    protected JavaScriptHelper js;
    protected Actions action;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new ExplicitWait(driver);
        this.js = new JavaScriptHelper(driver);
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement webElement) {
        click(webElement, Configuration.timeout.explicit);
    }

    public void click(WebElement webElement, int timeOutInSeconds) {
        log.debug("Wait and click:" + webElement);
        wait.forElementToBeClickable(webElement, timeOutInSeconds, Configuration.timeout.poolingInterval);
        js.highlightElement(webElement);
        js.clickElement(webElement);
    }

    public void click(By locator) {
        click(locator, Configuration.timeout.explicit);
    }

    public void click(By locator, int timeoutInSeconds) {
        log.debug("Wait and click: " + locator);
        wait.forElementToBeClickable(locator, timeoutInSeconds);
        js.highlightElement(locator);
        js.clickElement(driver.findElement(locator));
    }

    public Actions clickByAction(WebElement element) {
        log.debug("Click by action: " + element);
        wait.forElementToBeVisible(element);
        js.highlightElement(element);
        action.click(element).perform();
        return action;
    }

    public Actions doubleClick(WebElement element) {
        log.debug("Double click on: " + element);
        wait.forElementToBeVisible(element);
        js.highlightElement(element);
        action.moveToElement(element);
        action.doubleClick().perform();
        return action;
    }

    public void selectByVisibleIndex(WebElement element, int value) {
        log.debug("Select value with index " + value + " from element: " + element);
        wait.forElementToBeVisible(element);
        js.highlightElement(element);
        Select select = new Select(element);
        select.selectByIndex(value);
    }

    public void selectByValue(WebElement element, String value) {
        log.debug("Select value " + value + " from element: " + element);
        Select select = new Select(element);
        js.highlightElement(element);
        select.selectByValue(value);
    }

    public void selectByVisibleText(WebElement element, String value) {
        log.debug("Select value by visible text: " + value + " from element: " + element);
        Select select = new Select(element);
        js.highlightElement(element);
        select.selectByVisibleText(value);
    }

    public void sendKeys(WebElement webElement, String value, int timeOutInSeconds) {
        log.debug("Send keys: " + value + " to element: " + webElement);
        click(webElement, timeOutInSeconds);
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void sendKeys(WebElement webElement, String value) {
        sendKeys(webElement, value, Configuration.timeout.explicit);
    }

    public void sendKeysByAction(WebElement webElement, String value) {
        log.debug("Send keys by action: " + value + " to element: " + webElement);
        webElement.click();
        action.sendKeys(value).perform();
    }

    public void arrowDown(WebElement element, int ArrowDownCount) {
        element.click();
        for (int i = 0; i < ArrowDownCount; i++) {
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
        }
    }

    public Actions hoverOn(WebElement element) {
        log.debug("Hover on: " + element);
        wait.forElementToBeVisible(element);
        js.highlightElement(element);
        action.moveToElement(element).perform();
        return action;
    }

    public void switchOutOfIframe() {
        driver.switchTo().defaultContent();
    }

    public void switchToIframe(WebElement iframeElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        try {
            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
        } catch (TimeoutException ex) {
            log.debug("Exception occurred during switch to iframe");
        }
    }

    public void executeJavascript(String string) {
        js.executeScript(string);
    }

    public void executeJavascript(String string, WebElement element) {
        js.executeScript(string, element);
    }

    public void scrollToElement(WebElement element) {
        js.scrollToElemet(element);
    }

    public String getText(WebElement element) {
        return (String) js.executeScript("return arguments[0].textContent", element);
    }

    public void pressArrowDownAndEnter(int ArrowDownCount) throws InterruptedException {
        action = new Actions(driver);
        for (int i = 0; i < ArrowDownCount; i++) {
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        action.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(11);
    }

    public void pressEnter() {
        action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
    }
}
