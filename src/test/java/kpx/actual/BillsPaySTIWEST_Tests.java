package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPaySTIWEST_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  S T I  W E S T  N E G R O S  I N C .  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in STI WEST NEGROS UNIVERSITY INC. Partner")
    public void BPSendout_STIWEST_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySTIWESTSteps.navigatePayoutPage();
            this.billsPaySTIWESTSteps.BPSendout_STIWEST_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in STI WEST NEGROS UNIVERSITY INC. Partner")
    public void BPSendout_STIWEST_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySTIWESTSteps.navigatePayoutPage();
            this.billsPaySTIWESTSteps.BPSendout_STIWEST_02();
        }
    }
    // B I L L S  P A Y  S T I  W E S T  N E G R O S  I N C .  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in STI WEST NEGROS UNIVERSITY INC. Partner")
    public void BPChangeDetails_STIWEST_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySTIWESTSteps.navigatePayoutPage();
            this.billsPaySTIWESTSteps.BPChangeDetails_STIWEST_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in STI WEST NEGROS UNIVERSITY INC. Partner")
    public void BPChangeDetails_STIWEST_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySTIWESTSteps.navigatePayoutPage();
            this.billsPaySTIWESTSteps.BPChangeDetails_STIWEST_02();
        }
    }

    // B I L L S  P A Y   S T I  W E S T  N E G R O S  I N C .  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in STI WEST NEGROS UNIVERSITY INC. Partner")
    public void BPCancellation_STIWEST_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySTIWESTSteps.navigatePayoutPage();
            this.billsPaySTIWESTSteps.BPSendout_STIWEST_01();
            this.billsPaySTIWESTSteps.BPCancellation_STIWEST_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in STI WEST NEGROS UNIVERSITY INC. Partner")
    public void BPCancellation_STIWEST_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySTIWESTSteps.navigatePayoutPage();
            this.billsPaySTIWESTSteps.BPSendout_STIWEST_02();
            this.billsPaySTIWESTSteps.BPCancellation_STIWEST_02();
        }
    }
    // B I L L S  P A Y   S T I  W E S T  N E G R O S  I N C .   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in STI WEST NEGROS UNIVERSITY INC. Partner")
    public void BPReprinting_STIWEST_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySTIWESTSteps.navigatePayoutPage();
            this.billsPaySTIWESTSteps.BPReprinting_STIWEST_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in STI WEST NEGROS UNIVERSITY INC. Partner")
    public void BPReprinting_STIWEST_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySTIWESTSteps.navigatePayoutPage();
            this.billsPaySTIWESTSteps.BPReprinting_STIWEST_02();
        }
    }




}
