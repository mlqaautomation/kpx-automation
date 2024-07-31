package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayGentrade_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   G E N T R A D E  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in GENTRADE INTERNATIONAL PHILS. INC. Partner")
    public void BPSendout_GENTRADE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGENTRADESteps.navigatePayoutPage();
            this.billsPayGENTRADESteps.BPSendout_GENTRADE_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in GENTRADE INTERNATIONAL PHILS. INC. Partner")
    public void BPSendout_GENTRADE_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGENTRADESteps.navigatePayoutPage();
            this.billsPayGENTRADESteps.BPSendout_GENTRADE_02();
        }
    }

    // B I L L S  P A Y   G E N T R A D E  C H A N G E   D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in GENTRADE INTERNATIONAL PHILS. INC. Partner")
    public void BPChangeDetails_GENTRADE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGENTRADESteps.navigatePayoutPage();
            this.billsPayGENTRADESteps.BPChangeDetails_GENTRADE_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Details in GENTRADE INTERNATIONAL PHILS. INC. Partner")
    public void BPChangeDetails_GENTRADE_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGENTRADESteps.navigatePayoutPage();
            this.billsPayGENTRADESteps.BPChangeDetails_GENTRADE_02();
        }
    }


    // B I L L S  P A Y   G E N T R A D E  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in GENTRADE INTERNATIONAL PHILS. INC. Partner")
    public void BPCancellation_GENTRADE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGENTRADESteps.navigatePayoutPage();
            this.billsPayGENTRADESteps.BPSendout_GENTRADE_01();
            this.billsPayGENTRADESteps.BPCancellation_GENTRADE_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in GENTRADE INTERNATIONAL PHILS. INC. Partner")
    public void BPCancellation_GENTRADE_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGENTRADESteps.navigatePayoutPage();
            this.billsPayGENTRADESteps.BPSendout_GENTRADE_02();
            this.billsPayGENTRADESteps.BPCancellation_GENTRADE_02();
        }
    }


    // B I L L S  P A Y   G E N T R A D E  R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in GENTRADE INTERNATIONAL PHILS. INC. Partner")
    public void BPReprinting_GENTRADE_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGENTRADESteps.navigatePayoutPage();
            this.billsPayGENTRADESteps.BPReprinting_GENTRADE_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in GENTRADE INTERNATIONAL PHILS. INC. Partner")
    public void BPReprinting_GENTRADE_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGENTRADESteps.navigatePayoutPage();
            this.billsPayGENTRADESteps.BPReprinting_GENTRADE_02();
        }
    }



}
