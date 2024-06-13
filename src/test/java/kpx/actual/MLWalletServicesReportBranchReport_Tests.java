package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class MLWalletServicesReportBranchReport_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if (this.homeSteps.isInHomePage()) {
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "Verify Navigation of ML Wallet Services Report Branch Report")
    public void navigationForMLWalletServicesReportBranchReport() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_01();
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Verify Transaction Type and TimeFrame Dropdown Options")
    public void transactionTypeAndTimeFrameDropdownOptions()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_02();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "Verify Transaction Type Dropdown Options Send Money - Kwarta Padala - Monthly")
    public void sendMoneyKwartaPadalaMonthly()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_03();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 4, description = "verify Transaction Type Dropdown Options Options Cash Out via Branch - Monthly")
    public void cashInviaBranchMonthly()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_04();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 5, description = "Verify Transaction Type and TimeFrame Dropdown Options")
    public void cashOutviaBranchMonthly()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_05();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 6, description = "verify Transaction Type Dropdown Options Send Money - Kwarta Padala - Date Range")
    public void sendMoneyKwartaPadalaDateRange()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_06();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 7, description = " verify Transaction Type Dropdown Options Cash In via Branch - Date Range")
    public void cashInviaBranchDateRange()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_07();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 8, description = "verify Transaction Type Dropdown Options Cash Out via Branch - Date Range")
    public void cashOutviaBranchDateRange()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_08();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 9, description = "verify Transaction Type Dropdown Options Send Money - Kwarta Padala - Daily")
    public void sendMoneyKwartaPadalaDaily()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_09();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 10, description = "verify Transaction Type Dropdown Options Cash In via Branch - Daily")
    public void cashInviaBranchDaily()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_10();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 11, description = "verify Transaction Type Dropdown Options Cash Out via Branch - Daily")
    public void cashOutviaBranchDaily()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_11();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 12, description = "verify Clear Button")
    public void clearButton()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_12();
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 13, description = "verify No Reports Generated")
    public void noReportsGenerated()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.mlWalletServicesReportBranchReportSteps.MLWBR_TC_14();
        }
    }




}
