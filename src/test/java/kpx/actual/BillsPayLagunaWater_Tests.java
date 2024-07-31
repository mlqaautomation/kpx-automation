package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayLagunaWater_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   L A G U N A  W A T E R  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in LAGUNA WATER CORPORATION Partner")
    public void BPSendout_LAGUNA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayLAGUNAWATERSteps.navigatePayoutPage();
            this.billsPayLAGUNAWATERSteps.BPSendout_LAGUNA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in LAGUNA WATER CORPORATION Partner")
    public void BPSendout_LAGUNA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayLAGUNAWATERSteps.navigatePayoutPage();
            this.billsPayLAGUNAWATERSteps.BPSendout_LAGUNA_02();
        }
    }
    // B I L L S  P A Y   L A G U N A  W A T E R  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in LAGUNA WATER CORPORATION Partner")
    public void BPChangeDetails_LAGUNA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayLAGUNAWATERSteps.navigatePayoutPage();
            this.billsPayLAGUNAWATERSteps.BPChangeDetails_LAGUNA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Details in LAGUNA WATER CORPORATION Partner")
    public void BPChangeDetails_LAGUNA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayLAGUNAWATERSteps.navigatePayoutPage();
            this.billsPayLAGUNAWATERSteps.BPChangeDetails_LAGUNA_02();
        }
    }

    // B I L L S  P A Y   L A G U N A  W A T E R  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in LAGUNA WATER CORPORATION Partner")
    public void BPCancellation_LAGUNA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayLAGUNAWATERSteps.navigatePayoutPage();
            this.billsPayLAGUNAWATERSteps.BPSendout_LAGUNA_01();
            this.billsPayLAGUNAWATERSteps.BPCancellation_LAGUNA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in LAGUNA WATER CORPORATION Partner")
    public void BPCancellation_LAGUNA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayLAGUNAWATERSteps.navigatePayoutPage();
            this.billsPayLAGUNAWATERSteps.BPSendout_LAGUNA_02();
            this.billsPayLAGUNAWATERSteps.BPCancellation_LAGUNA_02();
        }
    }

    // B I L L S  P A Y   L A G U N A  W A T E R   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in LAGUNA WATER CORPORATION Partner")
    public void BPReprinting_LAGUNA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayLAGUNAWATERSteps.navigatePayoutPage();
            this.billsPayLAGUNAWATERSteps.BPReprinting_LAGUNA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in LAGUNA WATER CORPORATION Partner")
    public void BPReprinting_LAGUNA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayLAGUNAWATERSteps.navigatePayoutPage();
            this.billsPayLAGUNAWATERSteps.BPReprinting_LAGUNA_02();
        }
    }




}
