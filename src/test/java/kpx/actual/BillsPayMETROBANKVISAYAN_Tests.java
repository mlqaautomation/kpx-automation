package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayMETROBANKVISAYAN_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   M E T R O B A N K  V I S A Y A N  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in METROBANK VISAYAN KHARIS Partner")
    public void BPSendout_METROBANKVISAYAN_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROBANKVISAYANSteps.navigatePayoutPage();
            this.billsPayMETROBANKVISAYANSteps.BPSendout_METROBANKVISAYAN_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in METROBANK VISAYAN KHARIS Partner")
    public void BPSendout_METROBANKVISAYAN_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROBANKVISAYANSteps.navigatePayoutPage();
            this.billsPayMETROBANKVISAYANSteps.BPSendout_METROBANKVISAYAN_02();
        }
    }
    // B I L L S  P A Y  M E T R O B A N K  V I S A Y A N  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in METROBANK VISAYAN KHARIS Partner")
    public void BPChangeDetails_METROBANKVISAYAN_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROBANKVISAYANSteps.navigatePayoutPage();
            this.billsPayMETROBANKVISAYANSteps.BPChangeDetails_METROBANKVISAYAN_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in METROBANK VISAYAN KHARIS Partner")
    public void BPChangeDetails_METROBANKVISAYAN_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROBANKVISAYANSteps.navigatePayoutPage();
            this.billsPayMETROBANKVISAYANSteps.BPChangeDetails_METROBANKVISAYAN_02();
        }
    }

    // B I L L S  P A Y   M E T R O B A N K  V I S A Y A N  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in METROBANK VISAYAN KHARIS Partner")
    public void BPCancellation_METROBANKVISAYAN_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROBANKVISAYANSteps.navigatePayoutPage();
            this.billsPayMETROBANKVISAYANSteps.BPSendout_METROBANKVISAYAN_01();
            this.billsPayMETROBANKVISAYANSteps.BPCancellation_METROBANKVISAYAN_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in METROBANK VISAYAN KHARIS Partner")
    public void BPCancellation_METROBANKVISAYAN_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROBANKVISAYANSteps.navigatePayoutPage();
            this.billsPayMETROBANKVISAYANSteps.BPSendout_METROBANKVISAYAN_02();
            this.billsPayMETROBANKVISAYANSteps.BPCancellation_METROBANKVISAYAN_02();
        }
    }
    // B I L L S  P A Y   M E T R O B A N K  V I S A Y A N  R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in METROBANK VISAYAN KHARIS Partner")
    public void BPReprinting_METROBANKVISAYAN_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROBANKVISAYANSteps.navigatePayoutPage();
            this.billsPayMETROBANKVISAYANSteps.BPReprinting_METROBANKVISAYAN_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in METROBANK VISAYAN KHARIS Partner")
    public void BPReprinting_METROBANKVISAYAN_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMETROBANKVISAYANSteps.navigatePayoutPage();
            this.billsPayMETROBANKVISAYANSteps.BPReprinting_METROBANKVISAYAN_02();
        }
    }




}
