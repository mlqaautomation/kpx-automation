package kpx.actual;

import kpx.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

import static utilities.Driver.DriverManager.getDriver;

public class WS_KwartaPadalaPayOut_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "Validate To validate successful Wallet Services Kwarta Padala Payout")
    public void successfulWalletServicesKwartaPadalaPayout() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsKwartaPadalaPayOutSteps.KPP_TC_01();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "Validate To validate successful remote Wallet Services Kwarta Padala Payout")
    public void remoteSuccessfulWalletServicesKwartaPadalaPayout() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsKwartaPadalaPayOutSteps.KPP_TC_02();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "Validate kwarta padala payout without Reference No")
    public void kwartaPadalaPayoutWithoutReferenceNo() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsKwartaPadalaPayOutSteps.KPP_TC_03();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "Validate kwarta padala payout invalid Reference No.")
    public void kwartaPadalaPayoutInvalidReferenceNo() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsKwartaPadalaPayOutSteps.KPP_TC_04();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "Validate kwarta padala payout invalid amount.")
    public void kwartaPadalaPayoutInvalidAmount() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsKwartaPadalaPayOutSteps.KPP_TC_05();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "Validate kwarta padala payout without inputting amount")
    public void kwartaPadalaPayoutWithoutInputtingAmount() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsKwartaPadalaPayOutSteps.KPP_TC_06();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "Validate claimed transaction")
    public void validateClaimedTransaction() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsKwartaPadalaPayOutSteps.KPP_TC_07();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "Validate Search Kyc in Wallet Services Kwarta Padala Payout")
    public void searchKycInWalletServicesKwartaPadalaPayout() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsKwartaPadalaPayOutSteps.KPP_TC_08();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "Validate again the cash in transaction if its being processed or not")
    public void validateAgainTheCashInTransaction() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsKwartaPadalaPayOutSteps.KPP_TC_09();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "Validate Cancel sendout transaction")
    public void validateCancelSendoutTransaction() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsKwartaPadalaPayOutSteps.KPP_TC_10();

        }

    }
}
