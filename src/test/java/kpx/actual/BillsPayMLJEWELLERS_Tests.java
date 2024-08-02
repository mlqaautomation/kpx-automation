package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayMLJEWELLERS_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   M L J E W E L L E R ' S  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in ML JEWELLER'S LIVE SELLING Partner")
    public void BPSendout_MLJEWELLERS_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMLJEWELLERSSteps   .navigatePayoutPage();
            this.billsPayMLJEWELLERSSteps.BPSendout_MLJEWELLERS_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in ML JEWELLER'S LIVE SELLING Partner")
    public void BPSendout_MLJEWELLERS_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMLJEWELLERSSteps.navigatePayoutPage();
            this.billsPayMLJEWELLERSSteps.BPSendout_MLJEWELLERS_02();
        }
    }
    // B I L L S  P A Y  M L J E W E L L E R ' S  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in ML JEWELLER'S LIVE SELLING Partner")
    public void BPChangeDetails_MLJEWELLERS_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMLJEWELLERSSteps.navigatePayoutPage();
            this.billsPayMLJEWELLERSSteps.BPChangeDetails_MLJEWELLERS_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in ML JEWELLER'S LIVE SELLING Partner")
    public void BPChangeDetails_MLJEWELLERS_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMLJEWELLERSSteps.navigatePayoutPage();
            this.billsPayMLJEWELLERSSteps.BPChangeDetails_MLJEWELLERS_02();
        }
    }

    // B I L L S  P A Y   M L J E W E L L E R ' S  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in ML JEWELLER'S LIVE SELLING Partner")
    public void BPCancellation_MLJEWELLERS_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMLJEWELLERSSteps.navigatePayoutPage();
            this.billsPayMLJEWELLERSSteps.BPSendout_MLJEWELLERS_01();
            this.billsPayMLJEWELLERSSteps.BPCancellation_MLJEWELLERS_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in ML JEWELLER'S LIVE SELLING Partner")
    public void BPCancellation_MLJEWELLERS_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMLJEWELLERSSteps.navigatePayoutPage();
            this.billsPayMLJEWELLERSSteps.BPSendout_MLJEWELLERS_02();
            this.billsPayMLJEWELLERSSteps.BPCancellation_MLJEWELLERS_02();
        }
    }

    // B I L L S  P A Y   M L J E W E L L E R ' S   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in ML JEWELLER'S LIVE SELLING Partner")
    public void BPReprinting_MLJEWELLERS_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMLJEWELLERSSteps.navigatePayoutPage();
            this.billsPayMLJEWELLERSSteps.BPReprinting_MLJEWELLERS_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in ML JEWELLER'S LIVE SELLING Partner")
    public void BPReprinting_MLJEWELLERS_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMLJEWELLERSSteps.navigatePayoutPage();
            this.billsPayMLJEWELLERSSteps.BPReprinting_MLJEWELLERS_02();
        }
    }




}
