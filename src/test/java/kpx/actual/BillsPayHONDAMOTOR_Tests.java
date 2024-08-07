package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayHONDAMOTOR_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  H O N D A  M O T O R  W O R L D  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in HONDA MOTOR WORLD, INC. Partner")
    public void BPSendout_HONDAMOTOR_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHONDAMOTORSteps.navigatePayoutPage();
            this.billsPayHONDAMOTORSteps.BPSendout_HONDAMOTOR_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in HONDA MOTOR WORLD, INC. Partner")
    public void BPSendout_HONDAMOTOR_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHONDAMOTORSteps.navigatePayoutPage();
            this.billsPayHONDAMOTORSteps.BPSendout_HONDAMOTOR_02();
        }
    }
    // B I L L S  P A Y  H O N D A  M O T O R  W O R L D  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in HONDA MOTOR WORLD, INC. Partner")
    public void BPChangeDetails_HONDAMOTOR_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHONDAMOTORSteps.navigatePayoutPage();
            this.billsPayHONDAMOTORSteps.BPChangeDetails_HONDAMOTOR_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in HONDA MOTOR WORLD, INC. Partner")
    public void BPChangeDetails_HONDAMOTOR_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHONDAMOTORSteps.navigatePayoutPage();
            this.billsPayHONDAMOTORSteps.BPChangeDetails_HONDAMOTOR_02();
        }
    }

    // B I L L S  P A Y   H O N D A  M O T O R  W O R L D  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in HONDA MOTOR WORLD, INC. Partner")
    public void BPCancellation_HONDAMOTOR_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHONDAMOTORSteps.navigatePayoutPage();
            this.billsPayHONDAMOTORSteps.BPSendout_HONDAMOTOR_01();
            this.billsPayHONDAMOTORSteps.BPCancellation_HONDAMOTOR_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in HONDA MOTOR WORLD, INC. Partner")
    public void BPCancellation_HONDAMOTOR_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHONDAMOTORSteps.navigatePayoutPage();
            this.billsPayHONDAMOTORSteps.BPSendout_HONDAMOTOR_02();
            this.billsPayHONDAMOTORSteps.BPCancellation_HONDAMOTOR_02();
        }
    }
    // B I L L S  P A Y   H O N D A  M O T O R  W O R L D   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in HONDA MOTOR WORLD, INC. Partner")
    public void BPReprinting_HONDAMOTOR_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHONDAMOTORSteps.navigatePayoutPage();
            this.billsPayHONDAMOTORSteps.BPReprinting_HONDAMOTOR_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in HONDA MOTOR WORLD, INC. Partner")
    public void BPReprinting_HONDAMOTOR_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayHONDAMOTORSteps.navigatePayoutPage();
            this.billsPayHONDAMOTORSteps.BPReprinting_HONDAMOTOR_02();
        }
    }




}
