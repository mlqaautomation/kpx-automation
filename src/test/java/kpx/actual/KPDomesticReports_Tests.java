package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class KPDomesticReports_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if (this.homeSteps.isInHomePage()) {
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Verify Navigation of SendOut Domestic")
    public void navigationForKPDomesticReportsBranchTransaction()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Verify Transaction Type and TimeFrame Dropdown Options")
    public void transactionTypeandTimeFrameDropdownOptions()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_02();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "Verify Transaction Type Dropdown Options Sendout - Monthly")
    public void transactionTypeDropdownOptionsSendoutMonthly()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_03();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 4, description = "Verify Transaction Type Dropdown Options Payout - Monthly")
    public void transactionTypeDropdownOptionsPayoutMonthly()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_04();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 5, description = "Verify Transaction Type Dropdown Options Sendout Cancellation - Monthly")
    public void transactionTypeDropdownOptionsSendoutCancellationMonthly()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_05();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 6, description = "Verify Transaction Type Dropdown Options Return to Sender - Monthly")
    public void transactionTypeDropdownOptionsReturnToSenderMonthly()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_06();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 7, description = "Verify Transaction Type Dropdown Options Request for Change - Monthly")
    public void transactionTypeDropdownOptionsRequestForChangeMonthly()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_07();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 8, description = "Verify Transaction Type Dropdown Options Payout Cancellation - Monthly")
    public void transactionTypeDropdownOptionsPayoutCancellationMonthly()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_08();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 9, description = "Verify Transaction Type Dropdown Options Sendout - Date Range")
    public void transactionTypeDropdownOptionsSendoutDateRange()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_09();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 10, description = "Verify Transaction Type Dropdown Options Payout - Date Range")
    public void transactionTypeDropdownOptionsPayoutDateRange()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_10();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 11, description = "Verify Transaction Type Dropdown Options Sendout Cancellation - Date Range")
    public void transactionTypeDropdownOptionsSendoutCancellationDateRange()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_11();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 12, description = "Verify Transaction Type Dropdown Options Return to Sender - Date Range")
    public void transactionTypeDropdownOptionsReturntoSender()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_12();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 13, description = "Verify Transaction Type Dropdown Options Request for Change - Date Range")
    public void transactionTypeDropdownOptionsRequestForChangeDateRange()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_13();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 14, description = "Verify Transaction Type Dropdown Options Payout Cancellation - Date Range")
    public void transactionTypeDropdownOptionsPayoutCancellationDateRange()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_14();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 15, description = "Verify Transaction Type Dropdown Options Sendout - Daily")
    public void transactionTypeDropdownOptionsSendoutDaily()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_15();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 16, description = "Verify Transaction Type Dropdown Options Payout - Daily")
    public void transactionTypeDropdownOptionsPayoutDaily()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_16();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 17, description = "Verify Transaction Type Dropdown Options Sendout Cancellation - Daily")
    public void transactionTypeDropdownOptionsSendoutCancellationDaily()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_17();
        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 18, description = "Verify Transaction Type Dropdown Options Return to Sender - Daily")
    public void transactionTypeDropdownOptionsReturnToSenderDaily()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_18();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 19, description = "Verify Transaction Type Dropdown Options Request for Change - Daily")
    public void transactionTypeDropdownOptionsRequestForChangeDaily()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_19();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 20, description = "Verify Transaction Type Dropdown Options Payout Cancellation - Daily")
    public void transactionTypeDropdownOptionsPayoutCancellationDaily()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_20();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 21, description = "Verify Clear Button")
    public void clearButton()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_21();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 22, description = "Verify Invalid Date")
    public void invalidDate()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_22();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 23, description = "Verify No Reports Generated")
    public void noReportsGenerated()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kpDomesticReportsSteps.KP_BTR_TC_23();
        }

    }



}
