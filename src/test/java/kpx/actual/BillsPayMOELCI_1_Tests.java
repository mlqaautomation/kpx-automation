package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayMOELCI_1_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  M I S A M I S  E L E C T R I C  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in MISAMIS OCCIDENTAL ELECTRIC COOPERATIVE 1 (MOELCI-1) Partner")
    public void BPSendout_MOELCI_I_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMOELCI1Steps.navigatePayoutPage();
            this.billsPayMOELCI1Steps.BPSendout_MOELCI_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in MISAMIS OCCIDENTAL ELECTRIC COOPERATIVE 1 (MOELCI-1) Partner")
    public void BPSendout_MOELCI_I_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMOELCI1Steps.navigatePayoutPage();
            this.billsPayMOELCI1Steps.BPSendout_MOELCI_02();
        }
    }
    // B I L L S  P A Y  M I S A M I S  E L E C T R I C  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in MISAMIS OCCIDENTAL ELECTRIC COOPERATIVE 1 (MOELCI-1) Partner")
    public void BPChangeDetails_MOELCI_I_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMOELCI1Steps.navigatePayoutPage();
            this.billsPayMOELCI1Steps.BPChangeDetails_MOELCI_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in MISAMIS OCCIDENTAL ELECTRIC COOPERATIVE 1 (MOELCI-1) Partner")
    public void BPChangeDetails_MOELCI_I_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMOELCI1Steps.navigatePayoutPage();
            this.billsPayMOELCI1Steps.BPChangeDetails_MOELCI_02();
        }
    }

    // B I L L S  P A Y   M I S A M I S  E L E C T R I C  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in MISAMIS OCCIDENTAL ELECTRIC COOPERATIVE 1 (MOELCI-1) Partner")
    public void BPCancellation_MOELCI_I_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMOELCI1Steps.navigatePayoutPage();
            this.billsPayMOELCI1Steps.BPSendout_MOELCI_01();
            this.billsPayMOELCI1Steps.BPCancellation_MOELCI_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in MISAMIS OCCIDENTAL ELECTRIC COOPERATIVE 1 (MOELCI-1) Partner")
    public void BPCancellation_MOELCI_I_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMOELCI1Steps.navigatePayoutPage();
            this.billsPayMOELCI1Steps.BPSendout_MOELCI_02();
            this.billsPayMOELCI1Steps.BPCancellation_MOELCI_02();
        }
    }

    // B I L L S  P A Y   M I S A M I S  E L E C T R I C   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in MISAMIS OCCIDENTAL ELECTRIC COOPERATIVE 1 (MOELCI-1) Partner")
    public void BPReprinting_MOELCI_I_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMOELCI1Steps.navigatePayoutPage();
            this.billsPayMOELCI1Steps.BPReprinting_MOELCI_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in MISAMIS OCCIDENTAL ELECTRIC COOPERATIVE 1 (MOELCI-1) Partner")
    public void BPReprinting_MOELCI_I_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayMOELCI1Steps.navigatePayoutPage();
            this.billsPayMOELCI1Steps.BPReprinting_MOELCI_02();
        }
    }




}
