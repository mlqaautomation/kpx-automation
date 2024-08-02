package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayEIGHTCHAMP_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   E I G H T CH A M P  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in EIGHTCHAMP DISTRIBUTION - BUTUAN Partner")
    public void BPSendout_EIGHTCHAMP_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayEIGHTCHAMPSteps.navigatePayoutPage();
            this.billsPayEIGHTCHAMPSteps.BPSendout_EIGHTCHAMP_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in EIGHTCHAMP DISTRIBUTION - BUTUAN Partner")
    public void BPSendout_EIGHTCHAMP_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayEIGHTCHAMPSteps.navigatePayoutPage();
            this.billsPayEIGHTCHAMPSteps.BPSendout_EIGHTCHAMP_02();
        }
    }
    // B I L L S  P A Y  E I G H T CH A M P  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in EIGHTCHAMP DISTRIBUTION - BUTUAN Partner")
    public void BPChangeDetails_EIGHTCHAMP_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayEIGHTCHAMPSteps.navigatePayoutPage();
            this.billsPayEIGHTCHAMPSteps.BPChangeDetails_EIGHTCHAMP_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in EIGHTCHAMP DISTRIBUTION - BUTUAN Partner")
    public void BPChangeDetails_EIGHTCHAMP_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayEIGHTCHAMPSteps.navigatePayoutPage();
            this.billsPayEIGHTCHAMPSteps.BPChangeDetails_EIGHTCHAMP_02();
        }
    }

    // B I L L S  P A Y   E I G H T CH A M P  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in EIGHTCHAMP DISTRIBUTION - BUTUAN Partner")
    public void BPCancellation_EIGHTCHAMP_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayEIGHTCHAMPSteps.navigatePayoutPage();
            this.billsPayEIGHTCHAMPSteps.BPSendout_EIGHTCHAMP_01();
            this.billsPayEIGHTCHAMPSteps.BPCancellation_EIGHTCHAMP_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in EIGHTCHAMP DISTRIBUTION - BUTUAN Partner")
    public void BPCancellation_EIGHTCHAMP_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayEIGHTCHAMPSteps.navigatePayoutPage();
            this.billsPayEIGHTCHAMPSteps.BPSendout_EIGHTCHAMP_02();
            this.billsPayEIGHTCHAMPSteps.BPCancellation_EIGHTCHAMP_02();
        }
    }

    // B I L L S  P A Y   E I G H T CH A M P   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in EIGHTCHAMP DISTRIBUTION - BUTUAN Partner")
    public void BPReprinting_EIGHTCHAMP_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayEIGHTCHAMPSteps.navigatePayoutPage();
            this.billsPayEIGHTCHAMPSteps.BPReprinting_EIGHTCHAMP_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in EIGHTCHAMP DISTRIBUTION - BUTUAN Partner")
    public void BPReprinting_EIGHTCHAMP_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayEIGHTCHAMPSteps.navigatePayoutPage();
            this.billsPayEIGHTCHAMPSteps.BPReprinting_EIGHTCHAMP_02();
        }
    }




}
