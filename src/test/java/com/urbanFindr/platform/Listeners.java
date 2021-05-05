package com.urbanFindr.platform;

import com.urbanFindr.commons.driver.ScenarioContext;
import com.urbanFindr.utils.Retry;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners implements ITestListener, IAnnotationTransformer {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {

		try {
 			var cucumberTestContext = new ScenarioContext();
 			var webDriverManager = cucumberTestContext.getWebDriverManager();

			var contextPart = result.getMethod().getMethodName();
			var filenamePart = " failed ";

			if (webDriverManager != null) webDriverManager.takeScreenshot(contextPart, filenamePart);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
	}



	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
		iTestAnnotation.setRetryAnalyzer(Retry.class);
	}
}
