package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class Payout_Partners_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "Successful partner payout transaction")
    public void Partner_Payout_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnersSteps.PS_TC_01();
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validateSuccessfulPartnerPayout();

        }
    }
}
