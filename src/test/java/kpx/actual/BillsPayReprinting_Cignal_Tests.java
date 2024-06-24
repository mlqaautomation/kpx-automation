package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayReprinting_Cignal_Tests extends BaseTest {

    //B I L L S  P A Y  C I G N A L  R E P R I N T I N G
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate BillsPay Successful Payment Reprint")
    public void BPCignal_RP_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateSuccessfulBillsPayCignal();
            this.billsPayReprintingCignalSteps.validateSuccessfulBillsPayCIGNALReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate BillsPay Successful Remote Payment Reprint")
    public void BPCignal_RP_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateSuccessfulRemoteBillsPayCignal();
            this.billsPayReprintingCignalSteps.validateSuccessfulRemoteBillsPayCIGNALReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate BillsPay Reprint With Invalid Ref Number")
    public void BPCignal_RP_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingCignalSteps.navigatePayoutPage();
            this.billsPayReprintingCignalSteps.validateInvalidKTPNBillsPayCIGNALReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate BillsPay Reprint with No Ref NUmber")
    public void BPCignal_RP_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingCignalSteps.navigatePayoutPage();
            this.billsPayReprintingCignalSteps.validateEmptyRefBillsPayCIGNALReprinting();

        }

    }    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate BillsPay Reprint with No Reason")
    public void BPCignal_RP_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingCignalSteps.navigatePayoutPage();
            this.billsPayReprintingCignalSteps.validateEmptyReasonBillsPayCIGNALReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate BillsPay Number Not Allowed")
    public void BPCignal_RP_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingCignalSteps.navigatePayoutPage();
            this.billsPayReprintingCignalSteps.validateOnlyLettersBillsPayCIGNALReprinting();

        }

    }
}
