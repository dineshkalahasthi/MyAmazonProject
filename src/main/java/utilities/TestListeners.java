package utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

import reporting.LogConfig;

public class TestListeners implements ITestListener {
	Logger log = LogConfig.getLogger(this.getClass());
	List<ITestNGMethod> passedTests = new ArrayList<>();
	List<ITestNGMethod> failedTests = new ArrayList<>();
	List<ITestNGMethod> skippedTests = new ArrayList<>();
	BaseDriver base;

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// ITestListener.super.onFinish(context);
		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		for (ITestResult result : failedTests) {
			ITestNGMethod method = result.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1)
				failedTests.remove(method);
			else if (context.getPassedTests().getResults(method).size() > 0)
				passedTests.remove(method);
		}
		Set<ITestResult> skippedTests = context.getSkippedTests().getAllResults();
		for (ITestResult result : skippedTests) {
			ITestNGMethod method = result.getMethod();
			if (context.getSkippedTests().getResults(method).size() > 1)
				failedTests.remove(method);
			else if (context.getPassedTests().getResults(method).size() > 0)
				passedTests.remove(method);
		}
		if(skippedTests.size()>0) {
			skippedTests.forEach(iTestResult ->log.info("TestCase-{}: with Method Name[{}] - inside[{}]",iTestResult.getMethod().getTestClass().getName()+"."+iTestResult.getMethod().getMethodName(),
					iTestResult.getName()));
		}
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==1) {
			passedTests.add(result.getMethod());}
	}
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==2) {
			failedTests.add(result.getMethod());
			log.error(result.getMethod().getMethodName()+":: FAILED");
			File ss=((TakesScreenshot)base.driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(ss,new File("Screenshots/FailedStepScreenshots"+result.getMethod().getMethodName().substring(4)+new Date().getTime()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==3) {
			skippedTests.add(result.getMethod());
		}
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

}
