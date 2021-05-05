package com.urbanFindr.commons.configuration;

import com.urbanFindr.commons.configuration.enums.BrowserType;
import com.urbanFindr.commons.configuration.enums.OperatingSystem;
import com.urbanFindr.commons.configuration.sections.DriverDetails;
import com.urbanFindr.commons.configuration.sections.Environment;
import com.urbanFindr.commons.configuration.sections.Timeout;
import com.urbanFindr.commons.utils.PropertiesFileReader;
import org.testng.Reporter;
import org.testng.xml.XmlTest;

public class Configuration {
    public static DriverDetails driver;
    public static Timeout timeout;
    public static Environment environment;

    private static final String CONFIG_FILE_NAME = "config.file";
    private static final String PAGE_TIMEOUT = "timeout.page";
    private static final String IMPLICIT_TIMEOUT = "timeout.implicit";
    private static final String EXPLICIT_TIMEOUT = "timeout.explicit";
    private static final String POOLING_INTERVAL_TIMEOUT = "timeout.poolingInterval";
    private static final String SHOULD_HIGHLIGHT_ELEMENT = "driverDetails.shouldHighlightElement";
    private static final String HIGHLIGHT_COLOR = "driverDetails.highlightColor";
    private static final String IS_HEADLESS = "driverDetails.isHeadless";
    private static final String DRIVER_TYPE = "driverDetails.browserType";
    private static final String DRIVER_OS = "driverDetails.os";
    private static final String VERBOSE = "driverDetails.verbose";
    private static final String IS_INCOGNITO = "driverDetails.isIncognito";
    private static final String ENVIRONMENT_NAME = "environment.name";
    private static final String CUSTOMER_URL = "environment.customer.url";
    private static final String STORE_URL = "environment.store.url";
    private static final String FM_ADMIN_URL = "environment.fm.url";
    private static final String FM_ADMIN_USERNAME = "environment.fm.username";
    private static final String STORE_ADMIN_USERNAME = "environment.store.username";
    private static final String CUSTOMER_USERNAME = "environment.customer.username";
    private static final String FM_ADMIN_PASSWORD = "environment.fm.password";
    private static final String STORE_ADMIN_PASSWORD = "environment.store.password";
    private static final String CUSTOMER_PASSWORD = "environment.customer.password";

    static {
        loadEnvironmentConfiguration();
    }

    private static void loadEnvironmentConfiguration() {
        var reader = new PropertiesFileReader();
        var properties = reader.readPropertyFile(getConfigurationFilePath());

        timeout.page = Integer.parseInt(properties.getProperty(PAGE_TIMEOUT));
        timeout.implicit = Integer.parseInt(properties.getProperty(IMPLICIT_TIMEOUT));
        timeout.explicit = Integer.parseInt(properties.getProperty(EXPLICIT_TIMEOUT));
        timeout.poolingInterval = Integer.parseInt(properties.getProperty(POOLING_INTERVAL_TIMEOUT));
        driver.shouldHighlightElement = Boolean.parseBoolean(properties.getProperty(SHOULD_HIGHLIGHT_ELEMENT));
        driver.highlightColor = properties.getProperty(HIGHLIGHT_COLOR);
        driver.isHeadless = Boolean.parseBoolean(properties.getProperty(IS_HEADLESS));
        driver.browserType = BrowserType.valueOf(properties.getProperty(DRIVER_TYPE).toUpperCase());
        driver.os = OperatingSystem.valueOf(properties.getProperty(DRIVER_OS).toUpperCase());
        driver.isIncognito = Boolean.parseBoolean(properties.getProperty(IS_INCOGNITO));
        driver.verbose = Boolean.parseBoolean(properties.getProperty(VERBOSE));
        environment.name = properties.getProperty(ENVIRONMENT_NAME);
        environment.customer_url = properties.getProperty(CUSTOMER_URL);
        environment.store_url = properties.getProperty(STORE_URL);
        environment.fm_admin_url = properties.getProperty(FM_ADMIN_URL);
        environment.customerUsername = properties.getProperty(CUSTOMER_USERNAME);
        environment.fmAdminUsername = properties.getProperty(FM_ADMIN_USERNAME);
        environment.storeAdminUsername = properties.getProperty(STORE_ADMIN_USERNAME);
        environment.customerPassword = properties.getProperty(CUSTOMER_PASSWORD);
        environment.fmAdminPassword = properties.getProperty(FM_ADMIN_PASSWORD);
        environment.storeAdminPassword = properties.getProperty(STORE_ADMIN_PASSWORD);
    }

    private static String getConfigurationFilePath() {
        var suite = getNgConfiguration();
        return suite.getParameter(CONFIG_FILE_NAME);
    }

    private static XmlTest getNgConfiguration() {
        return Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
    }
}
