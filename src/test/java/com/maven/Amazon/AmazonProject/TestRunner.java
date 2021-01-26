package com.maven.Amazon.AmazonProject;

import org.testng.TestNG;

import com.relevantcodes.extentreports.ExtentReports;

import amazonTestCases.SignInTest;

public class TestRunner {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//ReportNGUtils report=new ReportNGUtils();
		ExtentReports ext=new ExtentReports("/test-output/ExtentReport");
		// TODO Auto-generated method stub
TestNG testng=new TestNG();
testng.setTestClasses(new Class[] {SignInTest.class});
testng.addListener(ext);
		testng.run();
	}

}
