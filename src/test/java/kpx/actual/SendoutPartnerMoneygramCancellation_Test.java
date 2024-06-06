package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class SendoutPartnerMoneygramCancellation_Test extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Verify Sendout Cancelation")
    public void  verifySendoutCancelation()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.sendoutPartnerMoneygramSteps.PS_TC_08();
            this.sendoutPartnerMoneygramCancellationSteps.PSOC_TC_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Verify Cancel Sendout with Non-existing KPTN")
    public void cancelSendoutWithNonExistingKPTN()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.sendoutPartnerMoneygramCancellationSteps.PSOC_TC_02();

        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "Verify Cancel Sendout with already cancelled KPTN")
    public void cancelSendoutWithAlreadyCancelledKPTN()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.sendoutPartnerMoneygramCancellationSteps.PSOC_TC_03();

        }
    }
}
