package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPaySAMELCO1_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  S A M E L C O  1  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in SAMELCO 1 Partner")
    public void BPSendout_SAMELCO1_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySAMELCO1Steps.navigatePayoutPage();
            this.billsPaySAMELCO1Steps.BPSendout_SAMELCO1_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in SAMELCO 1 Partner")
    public void BPSendout_SAMELCO1_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySAMELCO1Steps.navigatePayoutPage();
            this.billsPaySAMELCO1Steps.BPSendout_SAMELCO1_02();
        }
    }
    // B I L L S  P A Y  S A M E L C O  1  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in SAMELCO 1 Partner")
    public void BPChangeDetails_SAMELCO1_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySAMELCO1Steps.navigatePayoutPage();
            this.billsPaySAMELCO1Steps.BPChangeDetails_SAMELCO1_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in SAMELCO 1 Partner")
    public void BPChangeDetails_SAMELCO1_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySAMELCO1Steps.navigatePayoutPage();
            this.billsPaySAMELCO1Steps.BPChangeDetails_SAMELCO1_02();
        }
    }

    // B I L L S  P A Y   S A M E L C O  1  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in SAMELCO 1 Partner")
    public void BPCancellation_SAMELCO1_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySAMELCO1Steps.navigatePayoutPage();
            this.billsPaySAMELCO1Steps.BPSendout_SAMELCO1_01();
            this.billsPaySAMELCO1Steps.BPCancellation_SAMELCO1_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in SAMELCO 1 Partner")
    public void BPCancellation_SAMELCO1_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySAMELCO1Steps.navigatePayoutPage();
            this.billsPaySAMELCO1Steps.BPSendout_SAMELCO1_02();
            this.billsPaySAMELCO1Steps.BPCancellation_SAMELCO1_02();
        }
    }

    // B I L L S  P A Y   S A M E L C O  1   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in SAMELCO 1 Partner")
    public void BPReprinting_SAMELCO1_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySAMELCO1Steps.navigatePayoutPage();
            this.billsPaySAMELCO1Steps.BPReprinting_SAMELCO1_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in SAMELCO 1 Partner")
    public void BPReprinting_SAMELCO1_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySAMELCO1Steps.navigatePayoutPage();
            this.billsPaySAMELCO1Steps.BPReprinting_SAMELCO1_02();
        }
    }




}
