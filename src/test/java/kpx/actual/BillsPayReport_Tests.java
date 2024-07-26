package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayReport_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if (this.homeSteps.isInHomePage()) {
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Verify navigation For Billspay Cancellation Report")
    public void navigationForBillspayBranchTransactionReport()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.navigationForBillspayBranchTransactionReport();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "To verify success in generating Bills Pay Branch Transaction Report")
    public void generatingBillsPayBranchTransactionReport()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_BTR_TC_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "To verify generating Bills Pay Branch Transaction Report with no date provided ")
    public void generatingBillsPayBranchTransactionReportwithnodateProvided ()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_BTR_TC_02();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 4, description = "To verify generating Bills Pay Branch Transaction Report with future date ")
    public void generatingBillsPayBranchTransactionReportwithfuturedate()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_BTR_TC_03();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 5, description = "To verify generating Bills Pay Branch Transaction Report with no reports generated")
    public void generatingBillsPayBranchTransactionReportwithnoreportsgenerated()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_BTR_TC_04();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 6, description = "To verify Clear Button")
    public void clearButton()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_BTR_TC_05();
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 7, description = "To verify navigation For Billspay Cancellation Report")
    public void navigationForBillspayCancellationReport()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.navigationForBillspayCancellationReport();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 8, description = "To verify success in generating Bills pay Cancellation Report (Daily)")
    public void  successInGeneratingBillspayCancellationReportDaily()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_CR_TC_02();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 9, description = "To verify success in generating Bills pay Change Details Report (Daily)")
    public void  successInGeneratingBillspayChangeDetailsReportDaily()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_CR_TC_03();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 10, description = "To verify success in generating Bills pay Cancellation Report (Monthly)")
    public void  successInGeneratingBillspayCancellationReportMonthly()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_CR_TC_04();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 11, description = "To verify success in generating Bills pay Change Details Report (Monthly)")
    public void  successInGeneratingBillspayChangeDetailsReportMonthly()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_CR_TC_05();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 12, description = "To verify success in generating Bills pay Change Details Report (Date Range)")
    public void  successInGeneratingBillspayCancellationReportDateRange()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_CR_TC_06();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 13, description = "To verify success in generating Bills pay Change Details Report (Date Range)")
    public void  successInGeneratingBillspayChangeDetailsReportDateRange()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_CR_TC_07();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 14, description = "To verify generating Report with no date provided ")
    public void  generatingReportwithnodateprovided()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_CR_TC_08();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 15, description = "To verify generating Report with future date ")
    public void  generatingReportwithfuturedate()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_CR_TC_09();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 16, description = "To verify Clear Button")
    public void  clearButtonInCancellation()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReportSteps.BP_CR_TC_10();
        }
    }




}

