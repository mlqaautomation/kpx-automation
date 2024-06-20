package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class CorporatePartnerReport_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if (this.homeSteps.isInHomePage()) {
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Verify Navigation for Corporate Partner Reports")
    public void navigationForCorporatePartnerReports()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.corporatePartnerReportSteps.CPRBTR_TC_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Verify Transaction Type ")
    public void verifyTransactionType()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.corporatePartnerReportSteps.CPRBTR_TC_02();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "Verify Currency ")
    public void verifyCurrency()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.corporatePartnerReportSteps.CPRBTR_TC_03();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 4, description = "Verify Transaction Type Dropdown Options (Sendout) Currency (All Currencies)")
    public void verifySendoutCurrencyAllCurrencies()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.corporatePartnerReportSteps.CPRBTR_TC_04();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 5, description = "Verify Transaction Type Dropdown Options (Payout) Currency (All Currencies)")
    public void verifyTransactionTypeDropdownOptionsPayoutCurrencyAllCurrencies()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.corporatePartnerReportSteps.CPRBTR_TC_05();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 6, description = "Verify Transaction Type Dropdown Options (Sendout) Currency (PHP)")
    public void verifyTransactionTypeDropdownOptionsSendoutCurrencyPHP()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.corporatePartnerReportSteps.CPRBTR_TC_06();
        }
    }

    //NO USD
//    @Test(dependsOnMethods = "loginGoogle" , priority = 7, description = "Verify Transaction Type Dropdown Options (Sendout) Currency (USD)")
//    public void verifyTransactionTypeDropdownOptionsSendoutCurrencyUSD()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.corporatePartnerReportSteps.CPRBTR_TC_07();
//        }
//    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 7, description = "Verify Transaction Type Dropdown Options (Payout) Currency (PHP)")
    public void verifyTransactionTypeDropdownOptionsPayoutCurrencyPHP()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.corporatePartnerReportSteps.CPRBTR_TC_08();
        }
    }

    //NO USD
//    @Test(dependsOnMethods = "loginGoogle" , priority = 9, description = "Verify Transaction Type Dropdown Options (Payout) Currency (USD)")
//    public void verifyTransactionTypeDropdownOptionsPayoutCurrencyUSD()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.corporatePartnerReportSteps.CPRBTR_TC_09();
//        }
//    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 8, description = "verify Clear Button")
    public void verifyClearButton()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.corporatePartnerReportSteps.CPRBTR_TC_10();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 9, description = "verify Invalid Date")
    public void verifyInvalidDate()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.corporatePartnerReportSteps.CPRBTR_TC_11();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 10, description = "Verify No Reports Generated")
    public void verifyNoReportsGenerated()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.corporatePartnerReportSteps.CPRBTR_TC_12();
        }
    }

}
