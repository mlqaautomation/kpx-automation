package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayReprinting_CEBECO_Tests extends BaseTest {

    //B I L L S  P A Y   C E B E C O III  R E P R I N T I N G
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate BillsPay Successful Payment Reprint CEBECO III Partner")
    public void BPCEBECO_RP_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulBillsPayCEBECOIII();
            this.billsPayReprintingCebecoSteps.validateSuccessfulBillsPayCEBECOReprinting();
        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate BillsPay Successful Remote Payment Reprint CEBECO III Partner")
    public void BPCEBECO_RP_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulRemoteBillsPayCEBECOIII();
            this.billsPayReprintingCebecoSteps.validateSuccessfulRemoteBillsPayCEBECOReprinting();

        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate BillsPay Reprint With Invalid Ref Number CEBECO III Partner")
    public void BPCEBECO_RP_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingCebecoSteps.navigatePayoutPage();
            this.billsPayReprintingCebecoSteps.validateInvalidKTPNBillsPayCEBECOReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate BillsPay Reprint with No Ref NUmber CEBECO III Partner")
    public void BPCEBECO_RP_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingCebecoSteps.navigatePayoutPage();
            this.billsPayReprintingCebecoSteps.validateEmptyRefBillsPayCEBECOReprinting();

        }

    }    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate BillsPay Reprint with No Reason CEBECO III Partner")
    public void BPCEBECO_RP_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingCebecoSteps.navigatePayoutPage();
            this.billsPayReprintingCebecoSteps.validateEmptyReasonBillsPayCEBECOReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate BillsPay Number Not Allowed CEBECO III Partner")
    public void BPCEBECO_RP_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingCebecoSteps.navigatePayoutPage();
            this.billsPayReprintingCebecoSteps.validateOnlyLettersBillsPayCEBECOReprinting();

        }

    }
}
