package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillspayMetroBankCollection_Tests extends BaseTest {


    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y   C E B E C O III  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in MetroBank Collection Partner")
    public void billspayMetroBankCollection()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billspayMetroBankCollectionSteps.validateSuccessfulBillspayMetroBankCollection();

        }
    }
}
