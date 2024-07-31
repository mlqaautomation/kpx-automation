package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayPOWERCYCLE_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   P O W E R C Y C L E  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in POWERCYCLE INC. Partner")
    public void BPSendout_POWERCYCLE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPOWERCYCLESteps.navigatePayoutPage();
            this.billsPayPOWERCYCLESteps.BPSendout_POWERCYCLE_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in POWERCYCLE INC. Partner")
    public void BPSendout_POWERCYCLE_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPOWERCYCLESteps.navigatePayoutPage();
            this.billsPayPOWERCYCLESteps.BPSendout_POWERCYCLE_02();
        }
    }
    // B I L L S  P A Y   P O W E R C Y C L E  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in POWERCYCLE INC. Partner")
    public void BPChangeDetails_POWERCYCLE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPOWERCYCLESteps.navigatePayoutPage();
            this.billsPayPOWERCYCLESteps.BPChangeDetails_POWERCYCLE_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Details in POWERCYCLE INC. Partner")
    public void BPChangeDetails_POWERCYCLE_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPOWERCYCLESteps.navigatePayoutPage();
            this.billsPayPOWERCYCLESteps.BPChangeDetails_POWERCYCLE_02();
        }
    }

    // B I L L S  P A Y   P O W E R C Y C L E  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in POWERCYCLE INC. Partner")
    public void BPCancellation_POWERCYCLE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPOWERCYCLESteps.navigatePayoutPage();
            this.billsPayPOWERCYCLESteps.BPSendout_POWERCYCLE_01();
            this.billsPayPOWERCYCLESteps.BPCancellation_POWERCYCLE_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in POWERCYCLE INC. Partner")
    public void BPCancellation_POWERCYCLE_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPOWERCYCLESteps.navigatePayoutPage();
            this.billsPayPOWERCYCLESteps.BPSendout_POWERCYCLE_02();
            this.billsPayPOWERCYCLESteps.BPCancellation_POWERCYCLE_02();
        }
    }

    // B I L L S  P A Y   P O W E R C Y C L E   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in POWERCYCLE INC. Partner")
    public void BPReprinting_POWERCYCLE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPOWERCYCLESteps.navigatePayoutPage();
            this.billsPayPOWERCYCLESteps.BPReprinting_POWERCYCLE_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in POWERCYCLE INC. Partner")
    public void BPReprinting_POWERCYCLE_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPOWERCYCLESteps.navigatePayoutPage();
            this.billsPayPOWERCYCLESteps.BPReprinting_POWERCYCLE_02();
        }
    }




}
