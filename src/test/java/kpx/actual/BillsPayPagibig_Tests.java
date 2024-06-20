package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class  BillsPayPagibig_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  P A G I B I G  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in Pagibig Partner")
    public void PagibigBP_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulBillsPayPagibig();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in Pagibig Partner")
    public void PagibigBP_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulRemoteBillsPayPagibig();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate bills payment transaction in Pagibig with no partner")
    public void PagibigBP_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateBillsPayPagibigNoPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate bills payment transaction in Pagibig with no Acc num, lname and fname")
    public void PagibigBP_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateBillsPayPagibigNoAccNumLnameFname();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate bills payment transaction in Pagibig with no transaction type")
    public void PagibigBP_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateBillsPayPagibigEmptyTransactionType();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate bills payment transaction in Pagibig with empty lname")
    public void PagibigBP_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateBillsPayPagibigEmptyPayorLname();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate bills payment transaction in Pagibig with empty fname")
    public void PagibigBP_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateBillsPayPagibigEmptyPayorFname();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate bills payment transaction in Pagibig with empty address")
    public void PagibigBP_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateBillsPayPagibigEmptyPayorAddress();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate bills payment transaction in Pagibig with Empty Payor Contact")
    public void PagibigBP_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateBillsPayPagibigEmptyPayorContact();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate bills payment transaction in Pagibig with Xero and Empty Amount")
    public void PagibigBP_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateBillsPayCignalZeroAndEmptyAmount();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate bills payment transaction in Pagibig with Invalid Account Number")
    public void PagibigBP_TC_14()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateBillsPayPagibigInvalidAccNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate bills payment transaction in Pagibig Four Digits Account Num")
    public void PagibigBP_TC_15()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateBillsPayPagibigFourDigAccNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate bills payment transaction in Pagibig with Invalid Contact Number")
    public void PagibigBP_TC_17()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateBillsPayPagibigInvalidContactNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 14, description = "To validate bills payment transaction in Pagibig Max Amount Number")
    public void PagibigBP_TC_18()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateBillsPayPagibigMaxAmountNum();

        }
    }


}
