package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayMetroWater_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  M E T R O  W A T E R  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in METRO ILOILO WATER DISTRICT Partner")
    public void BPSendout_METROWATER_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROWATERSteps.navigatePayoutPage();
            this.billsPayMETROWATERSteps.BPSendout_METROWATER_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in METRO ILOILO WATER DISTRICT Partner")
    public void BPSendout_METROWATER_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROWATERSteps.navigatePayoutPage();
            this.billsPayMETROWATERSteps.BPSendout_METROWATER_02();
        }
    }
    // B I L L S  P A Y  M E T R O  W A T E R  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in METRO ILOILO WATER DISTRICT Partner")
    public void BPChangeDetails_METROWATER_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROWATERSteps.navigatePayoutPage();
            this.billsPayMETROWATERSteps.BPChangeDetails_METROWATER_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in METRO ILOILO WATER DISTRICT Partner")
    public void BPChangeDetails_METROWATER_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROWATERSteps.navigatePayoutPage();
            this.billsPayMETROWATERSteps.BPChangeDetails_METROWATER_02();
        }
    }

    // B I L L S  P A Y   M E T R O  W A T E R  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in METRO ILOILO WATER DISTRICT Partner")
    public void BPCancellation_METROWATER_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROWATERSteps.navigatePayoutPage();
            this.billsPayMETROWATERSteps.BPSendout_METROWATER_01();
            this.billsPayMETROWATERSteps.BPCancellation_METROWATER_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in METRO ILOILO WATER DISTRICT Partner")
    public void BPCancellation_METROWATER_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROWATERSteps.navigatePayoutPage();
            this.billsPayMETROWATERSteps.BPSendout_METROWATER_02();
            this.billsPayMETROWATERSteps.BPCancellation_METROWATER_02();
        }
    }
    // B I L L S  P A Y   M E T R O  W A T E R   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in METRO ILOILO WATER DISTRICT Partner")
    public void BPReprinting_METROWATER_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROWATERSteps.navigatePayoutPage();
            this.billsPayMETROWATERSteps.BPReprinting_METROWATER_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in METRO ILOILO WATER DISTRICT Partner")
    public void BPReprinting_METROWATER_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROWATERSteps.navigatePayoutPage();
            this.billsPayMETROWATERSteps.BPReprinting_METROWATER_02();
        }
    }




}
