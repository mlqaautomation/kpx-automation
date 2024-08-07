package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayCENTROESCOLAR_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  C E N T R O   E S C O L A R  U N I  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in CENTRO ESCOLAR UNIVERSITY-MANILA Partner")
    public void BPSendout_CENTROESCOLAR_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCENTROESCOLARSteps.navigatePayoutPage();
            this.billsPayCENTROESCOLARSteps.BPSendout_CENTROESCOLAR_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in CENTRO ESCOLAR UNIVERSITY-MANILA Partner")
    public void BPSendout_CENTROESCOLAR_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCENTROESCOLARSteps.navigatePayoutPage();
            this.billsPayCENTROESCOLARSteps.BPSendout_CENTROESCOLAR_02();
        }
    }
    // B I L L S  P A Y  C E N T R O   E S C O L A R  U N I  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in CENTRO ESCOLAR UNIVERSITY-MANILA Partner")
    public void BPChangeDetails_CENTROESCOLAR_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCENTROESCOLARSteps.navigatePayoutPage();
            this.billsPayCENTROESCOLARSteps.BPChangeDetails_CENTROESCOLAR_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in CENTRO ESCOLAR UNIVERSITY-MANILA Partner")
    public void BPChangeDetails_CENTROESCOLAR_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCENTROESCOLARSteps.navigatePayoutPage();
            this.billsPayCENTROESCOLARSteps.BPChangeDetails_CENTROESCOLAR_02();
        }
    }

    // B I L L S  P A Y   C E N T R O   E S C O L A R  U N I  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in CENTRO ESCOLAR UNIVERSITY-MANILA Partner")
    public void BPCancellation_CENTROESCOLAR_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCENTROESCOLARSteps.navigatePayoutPage();
            this.billsPayCENTROESCOLARSteps.BPSendout_CENTROESCOLAR_01();
            this.billsPayCENTROESCOLARSteps.BPCancellation_CENTROESCOLAR_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in CENTRO ESCOLAR UNIVERSITY-MANILA Partner")
    public void BPCancellation_CENTROESCOLAR_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCENTROESCOLARSteps.navigatePayoutPage();
            this.billsPayCENTROESCOLARSteps.BPSendout_CENTROESCOLAR_02();
            this.billsPayCENTROESCOLARSteps.BPCancellation_CENTROESCOLAR_02();
        }
    }
    // B I L L S  P A Y   C E N T R O   E S C O L A R  U N I   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in CENTRO ESCOLAR UNIVERSITY-MANILA Partner")
    public void BPReprinting_CENTROESCOLAR_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCENTROESCOLARSteps.navigatePayoutPage();
            this.billsPayCENTROESCOLARSteps.BPReprinting_CENTROESCOLAR_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in CENTRO ESCOLAR UNIVERSITY-MANILA Partner")
    public void BPReprinting_CENTROESCOLAR_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCENTROESCOLARSteps.navigatePayoutPage();
            this.billsPayCENTROESCOLARSteps.BPReprinting_CENTROESCOLAR_02();
        }
    }




}
