package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayReprinting_Pagibig_Tests extends BaseTest {

    //B I L L S  P A Y   P A G - I B I G  R E P R I N T I N G
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate BillsPay Successful Payment Reprint Pagibig Partner")
    public void BPPagibig_RP_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulBillsPayPagibig();
            this.billsPayReprintingPagibigSteps.validateSuccessfulBillsPayPagibigReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate BillsPay Successful Remote Payment Reprint Pagibig Partner")
    public void BPPagibig_RP_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulRemoteBillsPayPagibig();
            this.billsPayReprintingPagibigSteps.validateSuccessfulRemoteBillsPayPagibigReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate BillsPay Reprint With Invalid Ref Number Pagibig Partner")
    public void BPPagibig_RP_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingPagibigSteps.navigatePayoutPage();
            this.billsPayReprintingPagibigSteps.validateInvalidKTPNBillsPayPagibigReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate BillsPay Reprint with No Ref NUmber Pagibig Partner")
    public void BPPagibig_RP_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingPagibigSteps.navigatePayoutPage();
            this.billsPayReprintingPagibigSteps.validateEmptyRefBillsPayPagibigReprinting();

        }

    }    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate BillsPay Reprint with No Reason Pagibig Partner")
    public void BPPagibig_RP_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingPagibigSteps.navigatePayoutPage();
            this.billsPayReprintingPagibigSteps.validateEmptyReasonBillsPayPagibigReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate BillsPay Number Not Allowed Pagibig Partner")
    public void BPPagibig_RP_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingPagibigSteps.navigatePayoutPage();
            this.billsPayReprintingPagibigSteps.validateOnlyLettersBillsPayPagibigReprinting();

        }

    }
}
