package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayBREADANDMORE_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction Partner")
    public void BPSendout_BREADANDMORE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBREADANDMORESteps.navigatePayoutPage();
            this.billsPayBREADANDMORESteps.BPSendout_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction Partner")
    public void BPSendout_BREADANDMORE_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBREADANDMORESteps.navigatePayoutPage();
            this.billsPayBREADANDMORESteps.BPSendoutRemote_02();
        }
    }
    // B I L L S  P A Y   D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details Partner")
    public void BPChangeDetails_BREADANDMORE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBREADANDMORESteps.navigatePayoutPage();
            this.billsPayBREADANDMORESteps.BPChangeDetails_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Remote Change Details in Partner")
    public void BPChangeDetails_BREADANDMORE_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBREADANDMORESteps.navigatePayoutPage();
            this.billsPayBREADANDMORESteps.BPChangeDetailsRemote_02();
        }
    }

    // B I L L S  P A Y    C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation Partner")
    public void BPCancellation_BREADANDMORE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBREADANDMORESteps.navigatePayoutPage();
            this.billsPayBREADANDMORESteps.BPSendout_01();
            this.billsPayBREADANDMORESteps.BPCancellation_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Remote Cancellation Partner")
    public void BPCancellation_BREADANDMORE_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBREADANDMORESteps.navigatePayoutPage();
            this.billsPayBREADANDMORESteps.BPSendoutRemote_02();
            this.billsPayBREADANDMORESteps.BPCancellationRemote_02();
        }
    }
    // B I L L S  P A Y   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting Partner")
    public void BPReprinting_BREADANDMORE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBREADANDMORESteps.navigatePayoutPage();
            this.billsPayBREADANDMORESteps.BPReprinting_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Remote Reprinting Partner")
    public void BPReprinting_BREADANDMORE_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayBREADANDMORESteps.navigatePayoutPage();
            this.billsPayBREADANDMORESteps.BPReprintingRemote_02();
        }
    }




}
