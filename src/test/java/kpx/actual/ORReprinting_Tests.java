package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class ORReprinting_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Validate OR Reprinting")
    public void navigatingORReprintingPage()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.orReprintingSteps.OR_TC_01();

        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = " Validate OR Reprinting with Non-Existing KPTN")
    public void nonExistingKPTNOR_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.orReprintingSteps.OR_TC_02();

        }

    }

}
