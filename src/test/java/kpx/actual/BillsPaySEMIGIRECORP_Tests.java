package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPaySEMIGIRECORP_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  S E M I G I R E  C O R P O R A T I O N  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in SEMIGIRE CORPORATION-ORIENTAL Partner")
    public void BPSendout_SEMIGIRECORP_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySEMIGIRECORPSteps.navigatePayoutPage();
            this.billsPaySEMIGIRECORPSteps.BPSendout_SEMIGIRECORP_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in SEMIGIRE CORPORATION-ORIENTAL Partner")
    public void BPSendout_SEMIGIRECORP_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySEMIGIRECORPSteps.navigatePayoutPage();
            this.billsPaySEMIGIRECORPSteps.BPSendout_SEMIGIRECORP_02();
        }
    }
    // B I L L S  P A Y  S E M I G I R E  C O R P O R A T I O N  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in SEMIGIRE CORPORATION-ORIENTAL Partner")
    public void BPChangeDetails_SEMIGIRECORP_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySEMIGIRECORPSteps.navigatePayoutPage();
            this.billsPaySEMIGIRECORPSteps.BPChangeDetails_SEMIGIRECORP_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in SEMIGIRE CORPORATION-ORIENTAL Partner")
    public void BPChangeDetails_SEMIGIRECORP_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySEMIGIRECORPSteps.navigatePayoutPage();
            this.billsPaySEMIGIRECORPSteps.BPChangeDetails_SEMIGIRECORP_02();
        }
    }

    // B I L L S  P A Y   S E M I G I R E  C O R P O R A T I O N  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in SEMIGIRE CORPORATION-ORIENTAL Partner")
    public void BPCancellation_SEMIGIRECORP_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySEMIGIRECORPSteps.navigatePayoutPage();
            this.billsPaySEMIGIRECORPSteps.BPSendout_SEMIGIRECORP_01();
            this.billsPaySEMIGIRECORPSteps.BPCancellation_SEMIGIRECORP_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in SEMIGIRE CORPORATION-ORIENTAL Partner")
    public void BPCancellation_SEMIGIRECORP_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySEMIGIRECORPSteps.navigatePayoutPage();
            this.billsPaySEMIGIRECORPSteps.BPSendout_SEMIGIRECORP_02();
            this.billsPaySEMIGIRECORPSteps.BPCancellation_SEMIGIRECORP_02();
        }
    }
    // B I L L S  P A Y   S E M I G I R E  C O R P O R A T I O N   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in SEMIGIRE CORPORATION-ORIENTAL Partner")
    public void BPReprinting_SEMIGIRECORP_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySEMIGIRECORPSteps.navigatePayoutPage();
            this.billsPaySEMIGIRECORPSteps.BPReprinting_SEMIGIRECORP_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in SEMIGIRE CORPORATION-ORIENTAL Partner")
    public void BPReprinting_SEMIGIRECORP_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySEMIGIRECORPSteps.navigatePayoutPage();
            this.billsPaySEMIGIRECORPSteps.BPReprinting_SEMIGIRECORP_02();
        }
    }




}
