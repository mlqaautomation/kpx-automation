package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayMACROCEBU_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   M A C R O C E B U  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in MACRO DISTRIBUTORS INC. - CEBU Partner")
    public void BPSendout_MACROCEBU_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMACROCEBUSteps.navigatePayoutPage();
            this.billsPayMACROCEBUSteps.BPSendout_MACROCEBU_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in MACRO DISTRIBUTORS INC. - CEBU Partner")
    public void BPSendout_MACROCEBU_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMACROCEBUSteps.navigatePayoutPage();
            this.billsPayMACROCEBUSteps.BPSendout_MACROCEBU_02();
        }
    }
    // B I L L S  P A Y   M A C R O C E B U  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in MACRO DISTRIBUTORS INC. - CEBU Partner")
    public void BPChangeDetails_MACROCEBU_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMACROCEBUSteps.navigatePayoutPage();
            this.billsPayMACROCEBUSteps.BPChangeDetails_MACROCEBU_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in MACRO DISTRIBUTORS INC. - CEBU Partner")
    public void BPChangeDetails_MACROCEBU_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMACROCEBUSteps.navigatePayoutPage();
            this.billsPayMACROCEBUSteps.BPChangeDetails_MACROCEBU_02();
        }
    }

    // B I L L S  P A Y   M A C R O C E B U  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in MACRO DISTRIBUTORS INC. - CEBU Partner")
    public void BPCancellation_MACROCEBU_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMACROCEBUSteps.navigatePayoutPage();
            this.billsPayMACROCEBUSteps.BPSendout_MACROCEBU_01();
            this.billsPayMACROCEBUSteps.BPCancellation_MACROCEBU_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in MACRO DISTRIBUTORS INC. - CEBU Partner")
    public void BPCancellation_MACROCEBU_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMACROCEBUSteps.navigatePayoutPage();
            this.billsPayMACROCEBUSteps.BPSendout_MACROCEBU_02();
            this.billsPayMACROCEBUSteps.BPCancellation_MACROCEBU_02();
        }
    }

    // B I L L S  P A Y   M A C R O C E B U   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in MACRO DISTRIBUTORS INC. - CEBU Partner")
    public void BPReprinting_MACROCEBU_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMACROCEBUSteps.navigatePayoutPage();
            this.billsPayMACROCEBUSteps.BPReprinting_MACROCEBU_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in MACRO DISTRIBUTORS INC. - CEBU Partner")
    public void BPReprinting_MACROCEBU_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMACROCEBUSteps.navigatePayoutPage();
            this.billsPayMACROCEBUSteps.BPReprinting_MACROCEBU_02();
        }
    }




}
