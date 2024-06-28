package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayChangeD_Nordeco_Tests extends BaseTest {
    //B I L L S  P A Y   N O R D E C O   C H A N G E  D E T A I L S
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful BillsPay Change Details Nordeco Partner")
//    public void BPNordeco_ChangeDetails_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCignalSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulBillsPayCignal();
//            this.billsPayChangeDNordecoSteps.validateSuccessfulBillsPayNORDECOChangeDetails();
//        }
//
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote BillsPay Change Details Nordeco Partner")
    public void BPNordeco_ChangeDetails_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateSuccessfulRemoteBillsPayCignal();
            this.billsPayChangeDNordecoSteps.validateSuccessfulBillsPayRemoteNORDECOChangeDetails();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate BillsPay Change Details No Reference Provided Nordeco Partner")
    public void BPNordeco_ChangeDetails_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDNordecoSteps.navigatePayoutPage();
            this.billsPayChangeDNordecoSteps.validateBillsPayChangeDetailsNORDECONoRef();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate BillsPay Change Details Invalid Reference Provided Nordeco Partner")
    public void BPNordeco_ChangeDetails_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDNordecoSteps.navigatePayoutPage();
            this.billsPayChangeDNordecoSteps.validateBillsPayChangeDetailsNORDECOInvalidRef();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate BillsPay Change Details No IR Provided Nordeco Partner")
    public void BPNordeco_ChangeDetails_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDNordecoSteps.navigatePayoutPage();
            this.billsPayChangeDNordecoSteps.validateBillsPayChangeDetailsNORDECONoIR();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate BillsPay Change Details Invalid IR Provided Nordeco Partner")
    public void BPNordeco_ChangeDetails_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDNordecoSteps.navigatePayoutPage();
            this.billsPayChangeDNordecoSteps.validateBillsPayChangeDetailsNORDECOInvalidIR();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate BillsPay Change Details No Reason Provided Nordeco Partner")
    public void BPNordeco_ChangeDetails_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDNordecoSteps.navigatePayoutPage();
            this.billsPayChangeDNordecoSteps.validateBillsPayChangeDetailsNORDECONoReason();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Remote BillsPay Change Details No Reason Provided Nordeco Partner")
    public void BPNordeco_ChangeDetails_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDNordecoSteps.navigatePayoutPage();
            this.billsPayChangeDNordecoSteps.validateBillsPayRemoteChangeDetailsNORDECONoReason();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate BillsPay Change Details Not Selecting Initiated Provided Nordeco Partner")
    public void BPNordeco_ChangeDetails_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDNordecoSteps.navigatePayoutPage();
            this.billsPayChangeDNordecoSteps.validateBillsPayChangeDetailsNORDECONoInitiated();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate Keep transaction BillsPay Change Details Nordeco Partner ")
    public void BPNordeco_ChangeDetails_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDNordecoSteps.navigatePayoutPage();
            this.billsPayChangeDNordecoSteps.validateKeepTransactionBillsPayChangeDetailsNORDECO();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate Stay In Page BillsPay Change Details Nordeco Partner ")
    public void BPNordeco_ChangeDetails_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDNordecoSteps.navigatePayoutPage();
            this.billsPayChangeDNordecoSteps.validateStayPageBillsPayChangeDetailsNORDECO();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate BillsPay Change Details No Changes Nordeco Partner")
    public void BPNordeco_ChangeDetails_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDNordecoSteps.navigatePayoutPage();
            this.billsPayChangeDNordecoSteps.validateStayPageBillsPayNoChangeDetailsNORDECO();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate BillsPay Change Details No Letters Allowed Nordeco Partner")
    public void BPNordeco_ChangeDetails_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDNordecoSteps.navigatePayoutPage();
            this.billsPayChangeDNordecoSteps.validateStayPageBillsPayNORDECOOnlyLetters();

        }

    }

}
