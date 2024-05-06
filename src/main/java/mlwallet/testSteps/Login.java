package mlwallet.testSteps;

import mlwallet.testSteps.Base_Steps;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Login extends Base_Steps {
    public void loginWallet(){
        mobileGeneralMethod.waitSleep(4000);
        mobileGeneralMethod.type(loginPageObjects.mobileNum_editText(), "Mobile Field", "9999999998");
        mobileGeneralMethod.tap(loginPageObjects.login_btn(),"Login Button");
        mobileGeneralMethod.waitSleep(10000);
        enterOTP();
        enterPin();
        if((loginPageObjects.usableBalance_Text().isDisplayed())){
            ExtentReporter.logPass("loginWallet", "Successfully Logged in");
            LoggingUtils.info("You are now Logged in");
        }else{
            ExtentReporter.logFail("loginWallet", "Failed to logged in");
            LoggingUtils.error("Failed to logged in");
            throw new AssertionError("Failed to logged in");
        }
    }
    public void enterOTP(){
        LoggingUtils.info("Entering OTP........");
        for (int i=0; i < 6; i++){
            mobileGeneralMethod.type(loginPageObjects.otp_editText(i),"OTP field" , "1");
        }
        mobileGeneralMethod.waitSleep(10000);
    }
    public void enterPin(){
        LoggingUtils.info("Entering Wallet Pin........");
        for (int i=1; i < 5; i++){
            mobileGeneralMethod.tap(loginPageObjects.walletPin_btn(1),"Pin field");
        }
        mobileGeneralMethod.waitSleep(10000);
    }
}