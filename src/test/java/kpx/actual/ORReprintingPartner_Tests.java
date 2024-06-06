package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class ORReprintingPartner_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Validate OR Reprinting Moneygram")
    public void validateORReprintingMoneygram()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.orReprintingPartnerSteps.OR_TC_01();

        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Validate OR Reprinting Western Union")
    public void validateORReprintingWesternUnion()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.orReprintingPartnerSteps.OR_TC_02();

        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = " Validate OR Reprinting with Non-Existing KPTN")
    public void nonExistingKPTNOR_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.orReprintingPartnerSteps.OR_TC_03();

        }

    }
}
