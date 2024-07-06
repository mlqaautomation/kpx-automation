package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayNordeco_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   N O R D E C O  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in NORDECO Partner")
    public void NordecoBP_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateSuccessfulBillsPayNORDECO();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in NORDECO Partner")
    public void NordecoBP_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateSuccessfulRemoteBillsPayNORDECO();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate bills payment transaction in NORDECO with no partner")
    public void NordecoBP_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateBillsPayNORDECONoPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate bills payment transaction in NORDECO with no Acc num, lname and fname")
    public void NordecoBP_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateBillsPayNORDECONoAccNumLnameFname();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate bills payment transaction in NORDECO with empty lname")
    public void NordecoBP_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateBillsPayNORDECOEmptyPayorLname();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate bills payment transaction in NORDECO with empty fname")
    public void NordecoBP_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateBillsPayNORDECOEmptyPayorFname();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate bills payment transaction in NORDECO with empty address")
    public void NordecoBP_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateBillsPayNORDECOEmptyPayorAddress();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate bills payment transaction in NORDECO with Empty Payor Contact")
    public void NordecoBP_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateBillsPayNORDECOEmptyPayorContact();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate bills payment transaction in NORDECO with Xero and Empty Amount")
    public void NordecoBP_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateBillsPayNORDECOZeroAndEmptyAmount();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate bills payment transaction in NORDECO with Invalid Account Number")
    public void NordecoBP_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateBillsPayNORDECOInvalidAccNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate bills payment transaction in NORDECO Four Digits Account Num")
    public void NordecoBP_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateBillsPayNORDECOFourDigAccNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate bills payment transaction in NORDECO with Invalid Contact Number")
    public void NordecoBP_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateBillsPayNORDECOInvalidContactNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate bills payment transaction in NORDECO Max Amount Number")
    public void NordecoBP_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateBillsPayNORDECOMaxAmountNum();

        }
    }
}
