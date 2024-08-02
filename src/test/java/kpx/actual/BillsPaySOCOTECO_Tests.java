package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPaySOCOTECO_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  S O C O T E C O  I I  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in SOCOTECO II Partner")
    public void BPSendout_SOCOTECOII_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySOCOTECOSteps.navigatePayoutPage();
            this.billsPaySOCOTECOSteps.BPSendout_SOCOTECOII_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in SOCOTECO II Partner")
    public void BPSendout_SOCOTECOII_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySOCOTECOSteps.navigatePayoutPage();
            this.billsPaySOCOTECOSteps.BPSendout_SOCOTECOII_02();
        }
    }
    // B I L L S  P A Y  S O C O T E C O  I I  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in SOCOTECO II Partner")
    public void BPChangeDetails_SOCOTECOII_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySOCOTECOSteps.navigatePayoutPage();
            this.billsPaySOCOTECOSteps.BPChangeDetails_SOCOTECOII_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in SOCOTECO II Partner")
    public void BPChangeDetails_SOCOTECOII_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySOCOTECOSteps.navigatePayoutPage();
            this.billsPaySOCOTECOSteps.BPChangeDetails_SOCOTECOII_02();
        }
    }

    // B I L L S  P A Y   S O C O T E C O  I I  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in SOCOTECO II Partner")
    public void BPCancellation_SOCOTECOII_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySOCOTECOSteps.navigatePayoutPage();
            this.billsPaySOCOTECOSteps.BPSendout_SOCOTECOII_01();
            this.billsPaySOCOTECOSteps.BPCancellation_SOCOTECOII_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in SOCOTECO II Partner")
    public void BPCancellation_SOCOTECOII_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySOCOTECOSteps.navigatePayoutPage();
            this.billsPaySOCOTECOSteps.BPSendout_SOCOTECOII_02();
            this.billsPaySOCOTECOSteps.BPCancellation_SOCOTECOII_02();
        }
    }

    // B I L L S  P A Y   S O C O T E C O  I I   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in SOCOTECO II Partner")
    public void BPReprinting_SOCOTECOII_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySOCOTECOSteps.navigatePayoutPage();
            this.billsPaySOCOTECOSteps.BPReprinting_SOCOTECOII_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in SOCOTECO II Partner")
    public void BPReprinting_SOCOTECOII_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySOCOTECOSteps.navigatePayoutPage();
            this.billsPaySOCOTECOSteps.BPReprinting_SOCOTECOII_02();
        }
    }




}
