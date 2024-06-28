package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayCEBECOIII_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   C E B E C O III  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in CEBECOIII Partner")
    public void CebecoIIIBP_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulBillsPayCEBECOIII();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in CEBECOIII Partner")
    public void CebecoIIIBP_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulRemoteBillsPayCEBECOIII();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate bills payment transaction in CEBECOIII with no partner")
    public void CebecoIIIBP_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateBillsPayCEBECOIIINoPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate bills payment transaction in CEBECOIII with no Acc num, lname and fname")
    public void CebecoIIIBP_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateBillsPayCEBECOIIINoAccNumLnameFname();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate bills payment transaction in CEBECOIII with empty lname")
    public void CebecoIIIBP_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateBillsPayCEBECOIIIEmptyPayorLname();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate bills payment transaction in CEBECOIII with empty fname")
    public void CebecoIIIBP_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateBillsPayCEBECOIIIEmptyPayorFname();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate bills payment transaction in CEBECOIII with empty address")
    public void CebecoIIIBP_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateBillsPayCEBECOIIIEmptyPayorAddress();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate bills payment transaction in CEBECOIII with Empty Payor Contact")
    public void CebecoIIIBP_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateBillsPayCEBECOIIIEmptyPayorContact();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate bills payment transaction in CEBECOIII with Xero and Empty Amount")
    public void CebecoIIIBP_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateBillsPayCEBECOIIIZeroAndEmptyAmount();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate bills payment transaction in CEBECOIII with Invalid Account Number")
    public void CebecoIIIBP_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateBillsPayCEBECOIIIInvalidAccNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate bills payment transaction in CEBECOIII Four Digits Account Num")
    public void CebecoIIIBP_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateBillsPayCEBECOIIIFourDigAccNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate bills payment transaction in CEBECOIII with Invalid Contact Number")
    public void CebecoIIIBP_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateBillsPayCEBECOIIIInvalidContactNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate bills payment transaction in CEBECOIII Max Amount Number")
    public void CebecoIIIBP_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateBillsPayCEBECOIIIMaxAmountNum();

        }
    }
}
