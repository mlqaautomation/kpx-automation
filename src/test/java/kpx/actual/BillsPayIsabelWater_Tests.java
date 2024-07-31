package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayIsabelWater_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   I S A B E L  W A T E R  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in ISABEL WATER DISTRICT Partner")
    public void BPSendout_ISABEL_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayISABELWATERSteps.navigatePayoutPage();
            this.billsPayISABELWATERSteps.BPSendout_ISABEL_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in ISABEL WATER DISTRICT Partner")
    public void BPSendout_ISABEL_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayISABELWATERSteps.navigatePayoutPage();
            this.billsPayISABELWATERSteps.BPSendout_ISABEL_02();
        }
    }

    // B I L L S  P A Y   I S A B E L  W A T E R  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in ISABEL WATER DISTRICT Partner")
    public void BPChangeDetails_ISABEL_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayISABELWATERSteps.navigatePayoutPage();
            this.billsPayISABELWATERSteps.BPChangeDetails_ISABEL_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Details in ISABEL WATER DISTRICT Partner")
    public void BPChangeDetails_ISABEL_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayISABELWATERSteps.navigatePayoutPage();
            this.billsPayISABELWATERSteps.BPChangeDetails_ISABEL_02();
        }
    }

    // B I L L S  P A Y   I S A B E L  W A T E R  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in ISABEL WATER DISTRICT Partner")
    public void BPCancellation_ISABEL_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayISABELWATERSteps.navigatePayoutPage();
            this.billsPayISABELWATERSteps.BPSendout_ISABEL_01();
            this.billsPayISABELWATERSteps.BPCancellation_ISABEL_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in ISABEL WATER DISTRICT Partner")
    public void BPCancellation_ISABEL_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayISABELWATERSteps.navigatePayoutPage();
            this.billsPayISABELWATERSteps.BPSendout_ISABEL_02();
            this.billsPayISABELWATERSteps.BPCancellation_ISABEL_02();
        }
    }

    // B I L L S  P A Y   I S A B E L  W A T E R   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in ISABEL WATER DISTRICT Partner")
    public void BPReprinting_ISABEL_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayISABELWATERSteps.navigatePayoutPage();
            this.billsPayISABELWATERSteps.BPReprinting_ISABEL_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in ISABEL WATER DISTRICT Partner")
    public void BPReprinting_ISABEL_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayISABELWATERSteps.navigatePayoutPage();
            this.billsPayISABELWATERSteps.BPReprinting_ISABEL_02();
        }
    }




}
