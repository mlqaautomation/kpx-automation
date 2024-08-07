package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPaySANTAPHARMA_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   S A N T A P H A R M A  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in SANTAPHARMA Partner")
    public void BPSendout_SANTAPHARMA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySANTAPHARMASteps.navigatePayoutPage();
            this.billsPaySANTAPHARMASteps.BPSendout_SANTAPHARMA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in SANTAPHARMA Partner")
    public void BPSendout_SANTAPHARMA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySANTAPHARMASteps.navigatePayoutPage();
            this.billsPaySANTAPHARMASteps.BPSendout_SANTAPHARMA_02();
        }
    }
    // B I L L S  P A Y  S A N T A P H A R M A  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in SANTAPHARMA Partner")
    public void BPChangeDetails_SANTAPHARMA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySANTAPHARMASteps.navigatePayoutPage();
            this.billsPaySANTAPHARMASteps.BPChangeDetails_SANTAPHARMA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in SANTAPHARMA Partner")
    public void BPChangeDetails_SANTAPHARMA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySANTAPHARMASteps.navigatePayoutPage();
            this.billsPaySANTAPHARMASteps.BPChangeDetails_SANTAPHARMA_02();
        }
    }

    // B I L L S  P A Y   S A N T A P H A R M A  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in SANTAPHARMA Partner")
    public void BPCancellation_SANTAPHARMA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySANTAPHARMASteps.navigatePayoutPage();
            this.billsPaySANTAPHARMASteps.BPSendout_SANTAPHARMA_01();
            this.billsPaySANTAPHARMASteps.BPCancellation_SANTAPHARMA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in SANTAPHARMA Partner")
    public void BPCancellation_SANTAPHARMA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySANTAPHARMASteps.navigatePayoutPage();
            this.billsPaySANTAPHARMASteps.BPSendout_SANTAPHARMA_02();
            this.billsPaySANTAPHARMASteps.BPCancellation_SANTAPHARMA_02();
        }
    }
    // B I L L S  P A Y   S A N T A P H A R M A   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in SANTAPHARMA Partner")
    public void BPReprinting_SANTAPHARMA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySANTAPHARMASteps.navigatePayoutPage();
            this.billsPaySANTAPHARMASteps.BPReprinting_SANTAPHARMA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in SANTAPHARMA Partner")
    public void BPReprinting_SANTAPHARMA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySANTAPHARMASteps.navigatePayoutPage();
            this.billsPaySANTAPHARMASteps.BPReprinting_SANTAPHARMA_02();
        }
    }




}
