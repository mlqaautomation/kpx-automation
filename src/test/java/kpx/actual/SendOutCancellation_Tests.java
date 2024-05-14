package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class SendOutCancellation_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Verify Navigation of SendOut Cancellation and Cancellation of Transaction")
    public void navigatingSendOutCancellationPage()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.sendOutCancellationSteps.SOC_TC_01();
        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Verify Cancel Sendout with Non-exisitng KPTN")
    public void SOC_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.sendOutCancellationSteps.SOC_TC_02();

        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "Verify Cancel Sendout with already cancelled KPTN")
    public void SOC_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.sendOutCancellationSteps.SOC_TC_03();

        }

    }

}
