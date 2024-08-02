package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayGOLDENBRIA_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   G O L D E N  B R I A  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in GOLDEN BRIA HOLDINGS INC Partner")
    public void BPSendout_GOLDENBRIA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGOLDENBRIASteps.navigatePayoutPage();
            this.billsPayGOLDENBRIASteps.BPSendout_GOLDENBRIA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in GOLDEN BRIA HOLDINGS INC Partner")
    public void BPSendout_GOLDENBRIA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGOLDENBRIASteps.navigatePayoutPage();
            this.billsPayGOLDENBRIASteps.BPSendout_GOLDENBRIA_02();
        }
    }
    // B I L L S  P A Y  G O L D E N  B R I A  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in GOLDEN BRIA HOLDINGS INC Partner")
    public void BPChangeDetails_GOLDENBRIA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGOLDENBRIASteps.navigatePayoutPage();
            this.billsPayGOLDENBRIASteps.BPChangeDetails_GOLDENBRIA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in GOLDEN BRIA HOLDINGS INC Partner")
    public void BPChangeDetails_GOLDENBRIA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGOLDENBRIASteps.navigatePayoutPage();
            this.billsPayGOLDENBRIASteps.BPChangeDetails_GOLDENBRIA_02();
        }
    }

    // B I L L S  P A Y   G O L D E N  B R I A  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in GOLDEN BRIA HOLDINGS INC Partner")
    public void BPCancellation_GOLDENBRIA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGOLDENBRIASteps.navigatePayoutPage();
            this.billsPayGOLDENBRIASteps.BPSendout_GOLDENBRIA_01();
            this.billsPayGOLDENBRIASteps.BPCancellation_GOLDENBRIA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in GOLDEN BRIA HOLDINGS INC Partner")
    public void BPCancellation_GOLDENBRIA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGOLDENBRIASteps.navigatePayoutPage();
            this.billsPayGOLDENBRIASteps.BPSendout_GOLDENBRIA_02();
            this.billsPayGOLDENBRIASteps.BPCancellation_GOLDENBRIA_02();
        }
    }

    // B I L L S  P A Y   G O L D E N  B R I A   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in GOLDEN BRIA HOLDINGS INC Partner")
    public void BPReprinting_GOLDENBRIA_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGOLDENBRIASteps.navigatePayoutPage();
            this.billsPayGOLDENBRIASteps.BPReprinting_GOLDENBRIA_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in GOLDEN BRIA HOLDINGS INC Partner")
    public void BPReprinting_GOLDENBRIA_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayGOLDENBRIASteps.navigatePayoutPage();
            this.billsPayGOLDENBRIASteps.BPReprinting_GOLDENBRIA_02();
        }
    }




}
