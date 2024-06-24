package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayReprinting_Nordeco_Tests extends BaseTest {

    //B I L L S  P A Y   N O R D E C O  R E P R I N T I N G
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate BillsPay Successful Payment Reprint Nordeco Partner")
    public void BPNordeco_RP_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateSuccessfulBillsPayNORDECO();
            this.billsPayReprintingNordecoSteps.validateSuccessfulBillsPayNORDECOReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate BillsPay Successful Remote Payment Reprint Nordeco Partner")
    public void BPNordeco_RP_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateSuccessfulRemoteBillsPayNORDECO();
            this.billsPayReprintingNordecoSteps.validateSuccessfulRemoteBillsPayNORDECOReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate BillsPay Reprint With Invalid Ref Number Nordeco Partner")
    public void BPNordeco_RP_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingNordecoSteps.navigatePayoutPage();
            this.billsPayReprintingNordecoSteps.validateInvalidKTPNBillsPayNORDECOReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate BillsPay Reprint with No Ref NUmber Nordeco Partner")
    public void BPNordeco_RP_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingNordecoSteps.navigatePayoutPage();
            this.billsPayReprintingNordecoSteps.validateEmptyRefBillsPayNORDECOReprinting();

        }

    }    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate BillsPay Reprint with No Reason Nordeco Partner")
    public void BPNordeco_RP_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingNordecoSteps.navigatePayoutPage();
            this.billsPayReprintingNordecoSteps.validateEmptyReasonBillsPayNORDECOReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate BillsPay Number Not Allowed Nordeco Partner")
    public void BPNordeco_RP_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingNordecoSteps.navigatePayoutPage();
            this.billsPayReprintingNordecoSteps.validateOnlyLettersBillsPayNORDECOReprinting();

        }

    }
}
