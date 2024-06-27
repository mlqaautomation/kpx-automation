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
}
