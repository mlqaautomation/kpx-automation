package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayCOTELCO_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   C O T E L C O  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in COTELCO Partner")
    public void BPSendout_COTELCO_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCOTELCOSteps.navigatePayoutPage();
            this.billsPayCOTELCOSteps.BPSendout_COTELCO_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in COTELCO Partner")
    public void BPSendout_COTELCO_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCOTELCOSteps.navigatePayoutPage();
            this.billsPayCOTELCOSteps.BPSendout_COTELCO_02();
        }
    }
    // B I L L S  P A Y   C O T E L C O  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in COTELCO Partner")
    public void BPChangeDetails_COTELCO_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCOTELCOSteps.navigatePayoutPage();
            this.billsPayCOTELCOSteps.BPChangeDetails_COTELCO_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in COTELCO Partner")
    public void BPChangeDetails_COTELCO_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCOTELCOSteps.navigatePayoutPage();
            this.billsPayCOTELCOSteps.BPChangeDetails_COTELCO_02();
        }
    }

    // B I L L S  P A Y   C O T E L C O  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in COTELCO Partner")
    public void BPCancellation_COTELCO_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCOTELCOSteps.navigatePayoutPage();
            this.billsPayCOTELCOSteps.BPSendout_COTELCO_01();
            this.billsPayCOTELCOSteps.BPCancellation_COTELCO_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in COTELCO Partner")
    public void BPCancellation_COTELCO_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCOTELCOSteps.navigatePayoutPage();
            this.billsPayCOTELCOSteps.BPSendout_COTELCO_02();
            this.billsPayCOTELCOSteps.BPCancellation_COTELCO_02();
        }
    }

    // B I L L S  P A Y   C O T E L C O   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in COTELCO Partner")
    public void BPReprinting_COTELCO_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCOTELCOSteps.navigatePayoutPage();
            this.billsPayCOTELCOSteps.BPReprinting_COTELCO_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in COTELCO Partner")
    public void BPReprinting_COTELCO_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCOTELCOSteps.navigatePayoutPage();
            this.billsPayCOTELCOSteps.BPReprinting_COTELCO_02();
        }
    }




}
