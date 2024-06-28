package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayChangeD_CEBECO_Tests extends BaseTest {
    //B I L L S  P A Y   C E B E C O III   C H A N G E  D E T A I L S
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful BillsPay Change Details CEBECO Partner")
    public void BPCEBECO_ChangeDetails_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulBillsPayCEBECOIII();
            this.billsPayChangeCEBECOIIISteps.validateSuccessfulBillsPayCEBECOChangeDetails();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote BillsPay Change Details Nordeco Partner")
    public void BPCEBECO_ChangeDetails_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulRemoteBillsPayCEBECOIII();
            this.billsPayChangeCEBECOIIISteps.validateSuccessfulBillsPayRemoteCEBECOChangeDetails();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate BillsPay Change Details No Reference Provided Nordeco Partner")
    public void BPCEBECO_ChangeDetails_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayChangeCEBECOIIISteps.validateBillsPayChangeDetailsCEBECONoRef();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate BillsPay Change Details Invalid Reference Provided Nordeco Partner")
    public void BPCEBECO_ChangeDetails_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayChangeCEBECOIIISteps.validateBillsPayChangeDetailsCEBECOInvalidRef();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate BillsPay Change Details No IR Provided Nordeco Partner")
    public void BPCEBECO_ChangeDetails_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayChangeCEBECOIIISteps.validateBillsPayChangeDetailsCEBECONoIR();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate BillsPay Change Details Invalid IR Provided Nordeco Partner")
    public void BPCEBECO_ChangeDetails_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayChangeCEBECOIIISteps.validateBillsPayChangeDetailsCEBECOInvalidIR();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate BillsPay Change Details No Reason Provided Nordeco Partner")
    public void BPCEBECO_ChangeDetails_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayChangeCEBECOIIISteps.validateBillsPayChangeDetailsCEBECONoReason();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Remote BillsPay Change Details No Reason Provided Nordeco Partner")
    public void BPCEBECO_ChangeDetails_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayChangeCEBECOIIISteps.validateBillsPayRemoteChangeDetailsCEBECONoReason();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate BillsPay Change Details Not Selecting Initiated Provided Nordeco Partner")
    public void BPCEBECO_ChangeDetails_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayChangeCEBECOIIISteps.validateBillsPayChangeDetailsCEBECONoInitiated();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate Keep transaction BillsPay Change Details Nordeco Partner ")
    public void BPCEBECO_ChangeDetails_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayChangeCEBECOIIISteps.validateKeepTransactionBillsPayChangeDetailsCEBECO();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate Stay In Page BillsPay Change Details Nordeco Partner ")
    public void BPCEBECO_ChangeDetails_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayChangeCEBECOIIISteps.validateStayPageBillsPayChangeDetailsCEBECO();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate BillsPay Change Details No Changes Nordeco Partner")
    public void BPCEBECO_ChangeDetails_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayChangeCEBECOIIISteps.validateStayPageBillsPayNoChangeDetailsCEBECO();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate BillsPay Change Details No Letters Allowed Nordeco Partner")
    public void BPCEBECO_ChangeDetails_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayChangeCEBECOIIISteps.validateStayPageBillsPayCEBECOOnlyLetters();

        }

    }

}
