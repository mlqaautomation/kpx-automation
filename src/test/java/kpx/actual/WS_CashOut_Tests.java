package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class WS_CashOut_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "Validate Cash Out")
    public void CashOut_TC_01() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsCashOutSteps.CO_TC_01();

        }

    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "Validate Cash Out using scan QR Code")
//    public void CashOut_TC_02() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.wsCashOutSteps.CO_TC_02();
//
//        }
//
//    }

    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "Validate verify transaction receipt")
    public void CashOut_TC_03() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsCashOutSteps.CO_TC_03();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "Validate invalid reference no")
    public void CashOut_TC_04() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsCashOutSteps.CO_TC_04();

        }

    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "Validate QR Code")
//    public void CashOut_TC_05() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.wsCashOutSteps.CO_TC_05();
//
//        }
//
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "Validate claimed reference")
    public void CashOut_TC_06() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsCashOutSteps.CO_TC_06();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "Validate Cash Out with No Reference Number")
    public void CashOut_TC_07() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsCashOutSteps.CO_TC_07();

        }

    }

    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "Validate verify remote Cash Out")
    public void CashOut_TC_08() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsCashOutSteps.CO_TC_08();

        }

    }


}
