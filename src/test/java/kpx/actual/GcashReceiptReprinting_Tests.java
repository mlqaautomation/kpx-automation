package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class GcashReceiptReprinting_Tests extends BaseTest {



    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if (this.homeSteps.isInHomePage()) {
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "verify Navigation for Gcash Receipt Reprinting")
    public void verifyNavigationForGcashReceiptReprinting() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashReceiptReprintingSteps.GRR_TC_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "verify Success Gcash Receipt Reprinting")
    public void verifySuccessGcashReceiptReprinting() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashReceiptReprintingSteps.GRR_TC_02();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "verify Invalid Reference Number")
    public void verifyInvalidReferenceNo() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashReceiptReprintingSteps.GRR_TC_03();
        }
    }



}
