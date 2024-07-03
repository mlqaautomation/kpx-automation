package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayReprinting_Maynilad_Tests extends BaseTest {

    //B I L L S  P A Y    R E P R I N T I N G
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate BillsPay Successful Payment Reprint")
    public void BPMaynilad_RP_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingSteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulBillsPayTransaction();
            this.billsPayReprintingSteps.validateSuccessfulBillsPayReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate BillsPay Successful Remote Payment Reprint")
    public void BPMaynilad_RP_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingSteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulRemoteBillsPayTransaction();
            this.billsPayReprintingSteps.validateSuccessfulRemoteBillsPayReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate BillsPay Reprint With Invalid Ref Number")
    public void BPMaynilad_RP_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingSteps.navigatePayoutPage();
            this.billsPayReprintingSteps.validateInvalidKTPNBillsPayReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate BillsPay Reprint with No Ref NUmber")
    public void BPMaynilad_RP_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingSteps.navigatePayoutPage();
            this.billsPayReprintingSteps.validateEmptyRefBillsPayReprinting();

        }

    }    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate BillsPay Reprint with No Reason")
    public void BPMaynilad_RP_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingSteps.navigatePayoutPage();
            this.billsPayReprintingSteps.validateEmptyReasonBillsPayReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate BillsPay Number Not Allowed")
    public void BPMaynilad_RP_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingSteps.navigatePayoutPage();
            this.billsPayReprintingSteps.validateOnlyLettersBillsPayReprinting();

        }

    }
}
