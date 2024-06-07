package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayCignal_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  C I G N A L    S E N D O U T
//    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in Cignal Partner")
//    public void CignalBP_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCignalSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulBillsPayCignal();
//
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in Cignal Partner")
//    public void CignalBP_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCignalSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulRemoteBillsPayCignal();
//
//        }
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate bills payment transaction in Cignal with no partner")
    public void CignalBP_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalNoPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate bills payment transaction in Cignal with no Acc num")
    public void CignalBP_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalNoAccNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate bills payment transaction in Cignal with no Lname")
    public void CignalBP_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalEmptyLName();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate bills payment transaction in Cignal with no FName")
    public void CignalBP_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalEmptyFName();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate bills payment transaction in Cignal with no Entity")
    public void CignalBP_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalNoEntity();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate bills payment transaction in Cignal with No Other Info")
    public void CignalBP_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalNoOtherInfo();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate bills payment transaction in Cignal with empty lname")
    public void CignalBP_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalEmptyPayorLname();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate bills payment transaction in Cignal with empty fname")
    public void CignalBP_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalEmptyPayorFname();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate bills payment transaction in Cignal with empty address")
    public void CignalBP_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalEmptyPayorAddress();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate bills payment transaction in Cignal with Empty Payor Contact")
    public void CignalBP_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalEmptyPayorContact();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate bills payment transaction in Cignal with Xero and Empty Amount")
    public void CignalBP_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalZeroAndEmptyAmount();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 14, description = "To validate bills payment transaction in Cignal with Invalid Account Number")
    public void CignalBP_TC_14()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalInvalidAccNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 15, description = "To validate bills payment transaction in Cignal Four Digits Account Num")
    public void CignalBP_TC_15()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalFourDigAccNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 17, description = "To validate bills payment transaction in Cignal with Invalid Contact Number")
    public void CignalBP_TC_17()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalInvalidContactNum();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 18, description = "To validate bills payment transaction in Cignal Max Amount Number")
    public void CignalBP_TC_18()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateBillsPayCignalMaxAmountNum();

        }
    }


}
