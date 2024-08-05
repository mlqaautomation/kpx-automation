package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayCEBUINSTITUTETECH_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  C E B U  I N S T I T U T E  O F  T E C H  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in CEBU INSTITUTE OF TECHNOLOGY Partner")
    public void BPSendout_CEBIINSTITUTETECH_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBUINSTITUTETECHSteps.navigatePayoutPage();
            this.billsPayCEBUINSTITUTETECHSteps.BPSendout_CEBUINSTITUTETECH_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in CEBU INSTITUTE OF TECHNOLOGY Partner")
    public void BPSendout_CEBIINSTITUTETECH_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBUINSTITUTETECHSteps.navigatePayoutPage();
            this.billsPayCEBUINSTITUTETECHSteps.BPSendout_CEBUINSTITUTETECH_02();
        }
    }
    // B I L L S  P A Y  C E B U  I N S T I T U T E  O F  T E C H  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in CEBU INSTITUTE OF TECHNOLOGY Partner")
    public void BPChangeDetails_CEBIINSTITUTETECH_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBUINSTITUTETECHSteps.navigatePayoutPage();
            this.billsPayCEBUINSTITUTETECHSteps.BPChangeDetails_CEBUINSTITUTETECH_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in CEBU INSTITUTE OF TECHNOLOGY Partner")
    public void BPChangeDetails_CEBIINSTITUTETECH_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBUINSTITUTETECHSteps.navigatePayoutPage();
            this.billsPayCEBUINSTITUTETECHSteps.BPChangeDetails_CEBUINSTITUTETECH_02();
        }
    }

    // B I L L S  P A Y   C E B U  I N S T I T U T E  O F  T E C H  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in CEBU INSTITUTE OF TECHNOLOGY Partner")
    public void BPCancellation_CEBIINSTITUTETECH_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBUINSTITUTETECHSteps.navigatePayoutPage();
            this.billsPayCEBUINSTITUTETECHSteps.BPSendout_CEBUINSTITUTETECH_01();
            this.billsPayCEBUINSTITUTETECHSteps.BPCancellation_CEBUINSTITUTETECH_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in CEBU INSTITUTE OF TECHNOLOGY Partner")
    public void BPCancellation_CEBIINSTITUTETECH_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBUINSTITUTETECHSteps.navigatePayoutPage();
            this.billsPayCEBUINSTITUTETECHSteps.BPSendout_CEBUINSTITUTETECH_02();
            this.billsPayCEBUINSTITUTETECHSteps.BPCancellation_CEBUINSTITUTETECH_02();
        }
    }
    // B I L L S  P A Y   C E B U  I N S T I T U T E  O F  T E C H   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in CEBU INSTITUTE OF TECHNOLOGY Partner")
    public void BPReprinting_CEBIINSTITUTETECH_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBUINSTITUTETECHSteps.navigatePayoutPage();
            this.billsPayCEBUINSTITUTETECHSteps.BPReprinting_CEBUINSTITUTETECH_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in CEBU INSTITUTE OF TECHNOLOGY Partner")
    public void BPReprinting_CEBIINSTITUTETECH_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBUINSTITUTETECHSteps.navigatePayoutPage();
            this.billsPayCEBUINSTITUTETECHSteps.BPReprinting_CEBUINSTITUTETECH_02();
        }
    }




}
