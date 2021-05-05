package com.urbanFindr.stepDefinitions;

import com.urbanFindr.commons.driver.ScenarioContext;
import com.urbanFindr.utils.PageObjectManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StepDefinitionsBase {

    protected ScenarioContext scenarioContext;
    protected static Logger logger;

    public StepDefinitionsBase(ScenarioContext context) throws Throwable {
        scenarioContext = context;
        logger = LogManager.getLogger(this);
        logger.info("Initialised");
    }

    protected PageObjectManager Pages() {
        return scenarioContext.getPageObjectManager();
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}

