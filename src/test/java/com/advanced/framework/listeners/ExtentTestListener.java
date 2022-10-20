package com.advanced.framework.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

/**
 * The listener interface for receiving extentTest events. The class that is
 * interested in processing a extentTest event implements this interface, and
 * the object created with that class is registered with a component using the
 * component's <code>addExtentTestListener</code> method. When the extentTest
 * event occurs, that object's appropriate method is invoked.
 *
 * @author Priyesh.Shrivastava
 */
public class ExtentTestListener implements ITestListener {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(ExtentTestListener.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
	 */
	@Override
	public void onTestStart(ITestResult result) {
		log.info(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<");
		log.info(">>>>>Test Case Started : {}<<<<<", getTestMethodName(result));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		log.info(">>>>>Test Case Completed [PASS] : {}<<<<<", getTestMethodName(result));
		System.out.println("Test Passed");
		// assignCategory(result);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailure(ITestResult result) {
//		try {
//			String screenshotPath = ExtentManager.capture();
//			ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
//		} catch (IOException e) {
//			log.error("Unable to attached screenshot : {}", e.getMessage());
//		}
		log.info(">>>>>Test Case Completed [FAIL] : {}<<<<<", getTestMethodName(result));
		System.out.println("Test Failed !");
		/*
		 * if(result.getMethod().getRetryAnalyzer() != null) {
		 * 
		 * RetryAnalyzer retry = (RetryAnalyzer)result.getMethod().getRetryAnalyzer();
		 * if(!retry.isLastTry()) ExtentTestManager.removeTest();
		 */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		log.info(">>>>>Test Case Completed [SKIP] : {}<<<<<", getTestMethodName(result));
		System.out.println(result.getThrowable());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.
	 * ITestResult)
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
	 */
	@Override
	public void onStart(ITestContext context) {
		log.info("============================================");
		log.info("TEST SUITE STARTED");
//		String logPath = System.getProperty("user.dir") + "\\src\\test\\resources\\logDeletion\\deleteLog.bat";
//		log.info("logPath : "+logPath);
//		try {
//			Process p = Runtime.getRuntime().exec(logPath);
//			Thread.sleep(2000);
//			p.destroy();
//		} catch (IOException | InterruptedException e) {
//			log.info("No existing log file");
//		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
	 */
	@Override
	public void onFinish(ITestContext context) {
//		ExtentManager.getInstance().flush();
		/*
		 * Set<ITestResult> failedTests = context.getFailedTests().getAllResults(); for
		 * (ITestResult temp : failedTests) { ITestNGMethod method = temp.getMethod();
		 * if (context.getFailedTests().getResults(method).size() > 1) {
		 * failedTests.remove(temp); log.info("Removed duplicate failed test : {}",
		 * temp.getTestClass()); } else { if
		 * (!context.getPassedTests().getResults(method).isEmpty()) {
		 * failedTests.remove(temp); log.info("Removed duplicate failed test : {}",
		 * temp.getTestClass()); } } }
		 */
		log.info("TEST SUITE ENDED");
	}

	/**
	 * Gets the test method name.
	 *
	 * @param result the result
	 * @return the test method name
	 */
	private String getTestMethodName(ITestResult result) {
		String testName = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName();
		if (!testName.isEmpty()) {
			return testName;
		} else {
			return result.getMethod().getConstructorOrMethod().getName();
		}
	}
	/*
	 * private void assignCategory(ITestResult result) {
	 * if(result.getInstanceName().contains(Module.SEARCH.getName().toLowerCase()))
	 * { ExtentTestManager.assignCategory(Module.SEARCH.getName()); } else
	 * if(result.getInstanceName().contains(Module.USER.getName().toLowerCase())) {
	 * ExtentTestManager.assignCategory(Module.USER.getName()); } else
	 * if(result.getInstanceName().contains(Module.COURSE.getName().toLowerCase()))
	 * { ExtentTestManager.assignCategory(Module.COURSE.getName()); } else
	 * if(result.getInstanceName().contains(Module.STRUCTURE.getName().toLowerCase()
	 * )) { ExtentTestManager.assignCategory(Module.STRUCTURE.getName()); } else
	 * if(result.getInstanceName().contains(Module.ILP.getName().toLowerCase())) {
	 * ExtentTestManager.assignCategory(Module.ILP.getName()); } else
	 * if(result.getInstanceName().contains(Module.STUDENT_GROUP.getName().
	 * replaceAll(" ", "").toLowerCase())) {
	 * ExtentTestManager.assignCategory(Module.STUDENT_GROUP.getName()); } else
	 * if(result.getInstanceName().contains(Module.TUTOR_GROUP.getName().
	 * replaceAll(" ", "").toLowerCase())) {
	 * ExtentTestManager.assignCategory(Module.TUTOR_GROUP.getName()); } else {
	 * ExtentTestManager.assignCategory("Home"); } }
	 */
}
