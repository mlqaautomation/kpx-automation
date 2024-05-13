package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class WS_Reprinting_Tests extends BaseTest {
    // WALLET SERVICES / RECEIPT REPRINTING / Cash In To Own Account



    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful WS-Reprint Cash In to Own Account Receipt Reprinting")
    public void WS_RR_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateSuccessfulCashInOwnReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate WS-Reprint Cash In to Own Account Receipt Reprinting with Incomplete Invalid Reference Number")
    public void WS_RR_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateCashInOwnInvalidRefNumReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate WS-Reprint Cash In to Own Account Receipt Reprinting with Empty Reference Number")
    public void WS_RR_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateCashInOwnEmptyRefNumReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate WS-Reprint Cash In to Own Account Receipt Reprinting with Complete Invalid Reference Number")
    public void WS_RR_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateCashInOwnCompleteInvalidRefNumReprinting();

        }

    }


    // WALLET SERVICES / RECEIPT REPRINTING / Cash In To Another Account
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate successful WS-Reprint Cash In to Another Account Receipt Reprinting")
    public void WS_RR_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateSuccessfulCashInAnotherAccReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate WS-Reprint Cash In to Another Account Receipt Reprinting with Incomplete Invalid Reference Number")
    public void WS_RR_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateCashInAnotherAccInvalidRefNumReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate WS-Reprint Cash In to Another Account Receipt Reprinting with Empty Reference Number")
    public void WS_RR_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateCashInAnotherAccEmptyRefNumReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate WS-Reprint Cash In to Another Account Receipt Reprinting with Complete Invalid Reference Number")
    public void WS_RR_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateCashInAnotherAccCompleteInvalidRefNumReprinting();

        }

    }
    // WALLET SERVICES / RECEIPT REPRINTING / Cash Out
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate successful WS-ReprintCash Out Receipt Reprinting")
    public void WS_RR_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateSuccessfulCashOutReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate WS-Reprint Cash Out Receipt Reprinting with Incomplete Invalid Reference Number")
    public void WS_RR_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateCashOutInvalidRefNumReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate WS-Reprint Cash Out Receipt Reprinting with Empty Reference Number")
    public void WS_RR_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateCashOutEmptyRefNumReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate WS-Reprint Cash Out Receipt Reprinting with Complete Invalid Reference Number")
    public void WS_RR_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateCashOutCompleteInvalidRefNumReprinting();

        }

    }

    // WALLET SERVICES / RECEIPT REPRINTING / Kwarta Padala Payout Receipt
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate successful WS-Reprint Kwarta Padala Payout Receipt Reprinting")
    public void WS_RR_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateSuccessfulKPPayoutReprinting();


        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 14, description = "To validate WS-Reprint Kwarta Padala Payout Receipt Reprinting with Incomplete Invalid Reference Number")
    public void WS_RR_TC_14()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateKPPayoutInvalidRefNumReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 15, description = "To validate WS-Reprint Kwarta Padala Payout Receipt Reprinting with Empty Reference Number")
    public void WS_RR_TC_15()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateKPPayoutCompleteInvalidRefNumReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 16, description = "To validate WS-Reprint Kwarta Padala Payout Receipt Reprinting with Complete Invalid Reference Number")
    public void WS_RR_TC_16()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateKPPayoutEmptyRefNumReprinting();

        }

    }
}
