package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class SOReprintingPartner_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Validate SO Reprinting Moneygram")
    public void validateSOReprintingMoneygram()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.soReprintingPartnerSteps.SOR_TC_01();

        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Validate SO Reprinting Western Union")
    public void validateSOReprintingWesternUnion()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.soReprintingPartnerSteps.SOR_TC_02();

        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = " Validate SO Reprinting with Non-Existing KPTN")
    public void nonExistingKPTNSOR_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.soReprintingPartnerSteps.SOR_TC_03();

        }

    }
}
