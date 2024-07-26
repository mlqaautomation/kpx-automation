package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class GcashCashIn_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if (this.homeSteps.isInHomePage()) {
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "verify Gcash Landing Page")
    public void verifyGcashLandingPage() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "verify Gcash Cash In Page")
    public void verifyGcashCashInPage() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_02();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "verify Gcash Cash In Successful Transaction")
    public void verifyGcashCashInSuccessfulTransaction() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_03();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "verify Receiver Invalid Phone Number")
    public void verifyReceiverInvalidPhoneNumber() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_04();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "verify Sender Invalid Phone Number")
    public void verifySenderInvalidPhoneNumber() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_05();
        }
    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "verify Watchlisted gcash number Receiver")
//    public void verifyWatchlistedgcashnumberReceiver() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.gcashCashInSteps.GCI_TC_06();
//        }
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "verify Empty Receivers Mobile number")
    public void verifyEmptyReceiversMobileNumber() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_07();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "verify Empty Senders Mobile number")
    public void verifyEmptySendersMobileNumber() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_08();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "verify No Firstname Provided")
    public void verifyNoFirstnameProvided() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_09();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "verify No Middlename Provided")
    public void verifyNoMiddlenameProvided() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_10();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "verify No Lastname Provided")
    public void verifyNoLastnameProvided() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_11();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "verify No Birthdate Provided")
    public void verifyNoBirthdateProvided() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_12();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "verify Future Birthdate Provided")
    public void verifyFutureBirthdateProvided() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_13();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "verify Empty Amount Provided")
    public void verifyEmptyAmountProvided() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_14();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 14, description = "verify Zero Amount Provided")
    public void verifyZeroAmountProvided() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_15();
        }
    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 15, description = "verify Pending Status")
//    public void verifyPendingStatus() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.gcashCashInSteps.GCI_TC_16();
//        }
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 16, description = "verify Wallet Capacity exceeded")
    public void verifyWalletCapacityExceeded() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashCashInSteps.GCI_TC_17();
        }
    }







}
