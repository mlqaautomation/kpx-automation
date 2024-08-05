package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayRMGCorp_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  R M G  M A N A G E M E N T  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in RMG MANAGEMENT CORPORATION Partner")
    public void BPSendout_RMGCORP_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayRMGCORPSteps.navigatePayoutPage();
            this.billsPayRMGCORPSteps.BPSendout_RMGCORP_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in RMG MANAGEMENT CORPORATION Partner")
    public void BPSendout_RMGCORP_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayRMGCORPSteps.navigatePayoutPage();
            this.billsPayRMGCORPSteps.BPSendout_RMGCORP_02();
        }
    }
    // B I L L S  P A Y  M I S A M I S  E L E C T R I C  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in RMG MANAGEMENT CORPORATION Partner")
    public void BPChangeDetails_RMGCORP_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayRMGCORPSteps.navigatePayoutPage();
            this.billsPayRMGCORPSteps.BPChangeDetails_RMGCORP_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in RMG MANAGEMENT CORPORATION Partner")
    public void BPChangeDetails_RMGCORP_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayRMGCORPSteps.navigatePayoutPage();
            this.billsPayRMGCORPSteps.BPChangeDetails_RMGCORP_02();
        }
    }

    // B I L L S  P A Y   M I S A M I S  E L E C T R I C  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in RMG MANAGEMENT CORPORATION Partner")
    public void BPCancellation_RMGCORP_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayRMGCORPSteps.navigatePayoutPage();
            this.billsPayRMGCORPSteps.BPSendout_RMGCORP_01();
            this.billsPayRMGCORPSteps.BPCancellation_RMGCORP_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in RMG MANAGEMENT CORPORATION Partner")
    public void BPCancellation_RMGCORPI_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayRMGCORPSteps.navigatePayoutPage();
            this.billsPayRMGCORPSteps.BPSendout_RMGCORP_02();
            this.billsPayRMGCORPSteps.BPCancellation_RMGCORP_02();
        }
    }

    // B I L L S  P A Y   M I S A M I S  E L E C T R I C   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in RMG MANAGEMENT CORPORATION Partner")
    public void BPReprinting_RMGCORP_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayRMGCORPSteps.navigatePayoutPage();
            this.billsPayRMGCORPSteps.BPReprinting_RMGCORP_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in RMG MANAGEMENT CORPORATION Partner")
    public void BPReprinting_RMGCORP_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayRMGCORPSteps.navigatePayoutPage();
            this.billsPayRMGCORPSteps.BPReprinting_RMGCORP_02();
        }
    }




}
