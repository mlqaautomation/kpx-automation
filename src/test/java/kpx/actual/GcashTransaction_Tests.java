package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class GcashTransaction_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if (this.homeSteps.isInHomePage()) {
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "verify Navigation for Gcash Transaction")
    public void verifyNavigationForGcashTransaction() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "verify Search Type(any) Status(any)")
    public void verifySearchTypeAnyStatusAny() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_02();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "verify Search Type(CASH IN) Status(any)")
    public void verifySearchTypeCASHINStatusany() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_03();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "verify Search Type(CASH OUT) Status(any)")
    public void verifySearchTypeCASHOUTStatusany() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_04();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "verify Search Type(CASH IN) Status(PENDING)")
    public void verifySearchTypeCASHINStatusPENDING() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_05();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "verify Search Type(CASH IN) Status(COMPLETED)")
    public void verifySearchTypeCASHINStatusCOMPLETED() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_06();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "verify Search Type(CASH IN) Status(FAILED)")
    public void verifySearchTypeCASHINStatusFAILED() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_07();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "verify Search Type(CASH IN) Status(MAX ATTEMPTS)")
    public void verifySearchTypeCASHINStatusMAXATTEMPTS() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_08();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "verify Search Type(CASH OUT) Status(PENDING)")
    public void verifySearchTypeCASHOUTStatusPENDING() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_09();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "verify Search Type(CASH OUT) Status(COMPLETED)")
    public void verifySearchTypeCASHOUTStatusCOMPLETED() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_10();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "verify Search Type(CASH OUT) Status(FAILED)")
    public void verifySearchTypeCASHOUTStatusFAILED() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_11();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "verify Search valid KPTN(KGIPMWPPOHP)")
    public void verifySearchValidKPTN() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_12();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "verify Search invalid KPTN(KGDAEESPOHP)")
    public void verifySearchInvalidKPTN() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_13();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 14, description = "verify Search Firstname")
    public void verifySearchFirstname() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_14();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 15, description = "verify Search Lastname")
    public void verifySearchLastname() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_15();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 16, description = "verify Search Transaction that has no Result Found")
    public void verifySearchTransactionThatHasNoResultFound() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_16();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 17, description = "verify Clear Button")
    public void verifyClearButton() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.gcashTransactionSteps.GT_TC_17();
        }
    }


}
