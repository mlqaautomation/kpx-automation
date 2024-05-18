package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class  BillsPay_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }

   // B I L L S  P A Y    S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction")
    public void BillsPay_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulBillsPayTransaction();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate successful remote bills payment transaction")
    public void BillsPay_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulRemoteBillsPayTransaction();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate bills payment with no partner selected")
    public void BillsPay_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateEmptyPartnerBillsPay();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate bills payment with no Account Number provided")
    public void BillsPay_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateEmptyAccountNumBillsPay();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate bills payment with no Account Last Name provided")
    public void BillsPay_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateEmptyLastnameBillsPay();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate bills payment with no Account First Name provided")
    public void BillsPay_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateEmptyFirstnameBillsPay();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate bills payment with no Payor's Last Name provided")
    public void BillsPay_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateEmptyLastnamePayor();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate bills payment with no Payor's First Name provided")
    public void BillsPay_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateEmptyFirstnamePayor();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate bills payment with no Payor's Address provided")
    public void BillsPay_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateEmptyAddressPayor();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate bills payment with no contact number provided")
    public void BillsPay_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateEmptyContactPayor();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate bills payment with no Payment Amount provided")
    public void BillsPay_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateInvalidAmount();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate bills payment with invalid Account Number provided")
    public void BillsPay_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateInvalidAccountNumTransaction();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 14, description = "To validate bills payment account with four digit or more than 8 digits provided")
    public void BillsPay_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateInvalidFourNumTransaction();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 15, description = "To validate bills payment with 20 below amount provided")
    public void BillsPay_TC_14()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateBelow20AmountTransaction();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 16, description = "To validate bills payment with invalid Contact Number provided")
    public void BillsPay_TC_15()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateInvalidContactBillsPay();

        }

    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate bills payment with duplicate transaction with in 90 seconds")
//    public void BillsPay_TC_16()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPaySteps.navigatePayoutPage();
//            this.billsPaySteps.validateDuplicateBillsPayTransaction();
//
//        }
//
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 17, description = "To validate bills payment with max amount inputted")
    public void BillsPay_TC_17()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateMaxAmountTransaction();

        }

    }

}
