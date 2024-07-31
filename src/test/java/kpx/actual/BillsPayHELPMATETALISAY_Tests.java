package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayHELPMATETALISAY_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   H E L P M A T E  T A L I S A Y  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in HELPMATE INC. - TALISAY Partner")
    public void BPSendout_HELPMATETALISAY_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHELPMATETALISAYSteps.navigatePayoutPage();
            this.billsPayHELPMATETALISAYSteps.BPSendout_HELPMATETALISAY_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in HELPMATE INC. - TALISAY Partner")
    public void BPSendout_HELPMATETALISAY_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHELPMATETALISAYSteps.navigatePayoutPage();
            this.billsPayHELPMATETALISAYSteps.BPSendout_HELPMATETALISAY_02();
        }
    }
    // B I L L S  P A Y   H E L P M A T E  T A L I S A Y  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in HELPMATE INC. - TALISAY Partner")
    public void BPChangeDetails_HELPMATETALISAY_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHELPMATETALISAYSteps.navigatePayoutPage();
            this.billsPayHELPMATETALISAYSteps.BPChangeDetails_HELPMATETALISAY_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in HELPMATE INC. - TALISAY Partner")
    public void BPChangeDetails_HELPMATETALISAYU_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHELPMATETALISAYSteps.navigatePayoutPage();
            this.billsPayHELPMATETALISAYSteps.BPChangeDetails_HELPMATETALISAY_02();
        }
    }

    // B I L L S  P A Y   H E L P M A T E  T A L I S A Y  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in HELPMATE INC. - TALISAY Partner")
    public void BPCancellation_HELPMATETALISAY_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHELPMATETALISAYSteps.navigatePayoutPage();
            this.billsPayHELPMATETALISAYSteps.BPSendout_HELPMATETALISAY_01();
            this.billsPayHELPMATETALISAYSteps.BPCancellation_HELPMATETALISAY_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in HELPMATE INC. - TALISAY Partner")
    public void BPCancellation_HELPMATETALISAY_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHELPMATETALISAYSteps.navigatePayoutPage();
            this.billsPayHELPMATETALISAYSteps.BPSendout_HELPMATETALISAY_02();
            this.billsPayHELPMATETALISAYSteps.BPCancellation_HELPMATETALISAY_02();
        }
    }

    // B I L L S  P A Y   H E L P M A T E  T A L I S A Y   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in HELPMATE INC. - TALISAY Partner")
    public void BPReprinting_HELPMATETALISAY_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHELPMATETALISAYSteps.navigatePayoutPage();
            this.billsPayHELPMATETALISAYSteps.BPReprinting_HELPMATETALISAY_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in HELPMATE INC. - TALISAY Partner")
    public void BPReprinting_HELPMATETALISAY_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHELPMATETALISAYSteps.navigatePayoutPage();
            this.billsPayHELPMATETALISAYSteps.BPReprinting_HELPMATETALISAY_02();
        }
    }




}
