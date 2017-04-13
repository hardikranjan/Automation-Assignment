package Utils;

import org.testng.*;

public class Listener implements ITestListener{

	public void onTestStart(ITestResult Result) {
		 Reporter.log(Result.getName()+" test case started",true);
	}

	public void onTestSuccess(ITestResult Result) {
		Reporter.log("The name of the testcase passed is :"+Result.getName(),true);
	}

	public void onTestFailure(ITestResult Result) {
		Reporter.log("The name of the testcase failed is :"+Result.getName(),true);
	}

	public void onTestSkipped(ITestResult Result) {
		Reporter.log("The name of the testcase Skipped is :"+Result.getName(),true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {}

	public void onStart(ITestContext context) {
		Reporter.log("[Info] Tests to start \n",true);
	}

	public void onFinish(ITestContext context) {
		Reporter.log("[Info] Tests has finished \n",true);
	}

}
