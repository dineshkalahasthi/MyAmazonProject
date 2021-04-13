package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int count = 0;
	int retryLimit = 1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (count < retryLimit) {
			count++;
			return true;
		}
		return false;

	}

	public String getTestStatusName(int status) {
		String resultName = null;
		if (status == 1) {
			resultName = "SUCCESS";
		} else if (status == 2) {
			resultName = "Failed";
		} else if (status == 3) {
			resultName = "SKIPPED";
		}
		return resultName;
	}
}
