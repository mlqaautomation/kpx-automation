package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayVECO_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  V E C O  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in VECO Partner")
    public void BPSendout_VECO_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayVECOSteps.navigatePayoutPage();
            this.billsPayVECOSteps.BPSendout_VECO_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in VECO Partner")
    public void BPSendout_VECO_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayVECOSteps.navigatePayoutPage();
            this.billsPayVECOSteps.BPSendout_VECO_02();
        }
    }
    // B I L L S  P A Y  V E C O  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in VECO Partner")
    public void BPChangeDetails_VECO_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayVECOSteps.navigatePayoutPage();
            this.billsPayVECOSteps.BPChangeDetails_VECO_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in VECO Partner")
    public void BPChangeDetails_VECO_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayVECOSteps.navigatePayoutPage();
            this.billsPayVECOSteps.BPChangeDetails_VECO_02();
        }
    }

    // B I L L S  P A Y   V E C O  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in VECO Partner")
    public void BPCancellation_VECO_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayVECOSteps.navigatePayoutPage();
            this.billsPayVECOSteps.BPSendout_VECO_01();
            this.billsPayVECOSteps.BPCancellation_VECO_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in VECO Partner")
    public void BPCancellation_VECO_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayVECOSteps.navigatePayoutPage();
            this.billsPayVECOSteps.BPSendout_VECO_02();
            this.billsPayVECOSteps.BPCancellation_VECO_02();
        }
    }
    // B I L L S  P A Y   V E C O   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in VECO Partner")
    public void BPReprinting_VECO_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayVECOSteps.navigatePayoutPage();
            this.billsPayVECOSteps.BPReprinting_VECO_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in VECO Partner")
    public void BPReprinting_VECO_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayVECOSteps.navigatePayoutPage();
            this.billsPayVECOSteps.BPReprinting_VECO_02();
        }
    }




}
