package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayBAVI_CTG_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   B A V I - C T G  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in BAVI-CTG Partner")
    public void BPSendout_BAVI_CTG_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBAVICtgSteps.navigatePayoutPage();
            this.billsPayBAVICtgSteps.BPSendout_BAVI_CTG_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in BAVI-CTG Partner")
    public void BPSendout_BAVI_CTG_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBAVICtgSteps.navigatePayoutPage();
            this.billsPayBAVICtgSteps.BPSendout_BAVI_CTG_02();
        }
    }
    // B I L L S  P A Y   B A V I - C T G  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in BAVI-CTG Partner")
    public void BPChangeDetails_BAVI_CTG_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBAVICtgSteps.navigatePayoutPage();
            this.billsPayBAVICtgSteps.BPChangeDetails_BAVI_CTG_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in BAVI-CTG Partner")
    public void BPChangeDetails_BAVI_CTG_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBAVICtgSteps.navigatePayoutPage();
            this.billsPayBAVICtgSteps.BPChangeDetails_BAVI_CTG_02();
        }
    }

    // B I L L S  P A Y   B A V I - C T G  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in BAVI-CTG Partner")
    public void BPCancellation_BAVI_CTG_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBAVICtgSteps.navigatePayoutPage();
            this.billsPayBAVICtgSteps.BPSendout_BAVI_CTG_01();
            this.billsPayBAVICtgSteps.BPCancellation_BAVI_CTG_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in BAVI-CTG Partner")
    public void BPCancellation_BAVI_CTG_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBAVICtgSteps.navigatePayoutPage();
            this.billsPayBAVICtgSteps.BPSendout_BAVI_CTG_02();
            this.billsPayBAVICtgSteps.BPCancellation_BAVI_CTG_02();
        }
    }

    // B I L L S  P A Y   B A V I - C T G   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in BAVI-CTG. Partner")
    public void BPReprinting_BAVI_CTGE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBAVICtgSteps.navigatePayoutPage();
            this.billsPayBAVICtgSteps.BPReprinting_BAVI_CTG_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in BAVI-CTG Partner")
    public void BPReprinting_BAVI_CTG_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBAVICtgSteps.navigatePayoutPage();
            this.billsPayBAVICtgSteps.BPReprinting_BAVI_CTG_02();
        }
    }




}
