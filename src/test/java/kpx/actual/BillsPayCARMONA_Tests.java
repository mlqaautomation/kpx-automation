package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayCARMONA_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   C A R M O N A  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in CARMONA Partner")
    public void BPSendout_CARMONA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCARMONASteps.navigatePayoutPage();
            this.billsPayCARMONASteps.BPSendout_CARMONA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in CARMONA Partner")
    public void BPSendout_CARMONA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCARMONASteps.navigatePayoutPage();
            this.billsPayCARMONASteps.BPSendout_CARMONA_02();
        }
    }
    // B I L L S  P A Y  C A R M O N A  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in CARMONA Partner")
    public void BPChangeDetails_CARMONA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCARMONASteps.navigatePayoutPage();
            this.billsPayCARMONASteps.BPChangeDetails_CARMONA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in CARMONA Partner")
    public void BPChangeDetails_CARMONA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCARMONASteps.navigatePayoutPage();
            this.billsPayCARMONASteps.BPChangeDetails_CARMONA_02();
        }
    }

    // B I L L S  P A Y   C A R M O N A  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in CARMONA Partner")
    public void BPCancellation_CARMONA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCARMONASteps.navigatePayoutPage();
            this.billsPayCARMONASteps.BPSendout_CARMONA_01();
            this.billsPayCARMONASteps.BPCancellation_CARMONA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in CARMONA Partner")
    public void BPCancellation_CARMONA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCARMONASteps.navigatePayoutPage();
            this.billsPayCARMONASteps.BPSendout_CARMONA_02();
            this.billsPayCARMONASteps.BPCancellation_CARMONA_02();
        }
    }
    // B I L L S  P A Y   C A R M O N A   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in CARMONA Partner")
    public void BPReprinting_CARMONA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCARMONASteps.navigatePayoutPage();
            this.billsPayCARMONASteps.BPReprinting_CARMONA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in CARMONA Partner")
    public void BPReprinting_CARMONA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCARMONASteps.navigatePayoutPage();
            this.billsPayCARMONASteps.BPReprinting_CARMONA_02();
        }
    }




}
