package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class PartnersPayoutCancella_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "Successful Cancel partner payout transaction")
    public void Partner_CancelPayout_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnersSteps.PS_TC_01();
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validateSuccessfulPartnerPayout();
            this.payoutCancellePartnerSteps.navigatePayoutPage();
            this.payoutCancellePartnerSteps.validateSuccessfulPartnerPayoutCancellation();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "Validate Partner Payout Cancel Invalid Reference")
    public void Partner_CancelPayout_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutCancellePartnerSteps.navigatePayoutPage();
            this.payoutCancellePartnerSteps.validatePartnerPayoutCancelInvalidReference();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "Validate Partner Payout Cancel Already Cancelled")
    public void Partner_CancelPayout_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutCancellePartnerSteps.navigatePayoutPage();
            this.payoutCancellePartnerSteps.validatePartnerPayoutCancelAlreadyCancel();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "Validate Partner Payout Cancel Empty Reference")
    public void Partner_CancelPayout_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutCancellePartnerSteps.navigatePayoutPage();
            this.payoutCancellePartnerSteps.validatePartnerPayoutCancelEmptyRef();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "Validate Partner Payout Cancel Empty Partner")
    public void Partner_CancelPayout_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutCancellePartnerSteps.navigatePayoutPage();
            this.payoutCancellePartnerSteps.validatePartnerPayoutCancelEmptyPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "Validate Partner Payout Cancel NO IR")
    public void Partner_CancelPayout_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutCancellePartnerSteps.navigatePayoutPage();
            this.payoutCancellePartnerSteps.validateSuccessfulPartnerPayoutNoIR();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "Validate Partner Payout Cancel No Reason")
    public void Partner_CancelPayout_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutCancellePartnerSteps.navigatePayoutPage();
            this.payoutCancellePartnerSteps.validateSuccessfulPartnerPayoutNoReason();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "Validate Partner Payout Cancel Invalid Code")
    public void Partner_CancelPayout_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutCancellePartnerSteps.navigatePayoutPage();
            this.payoutCancellePartnerSteps.validateRemotePartnerPayoutInvalidCode();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "Validate Partner Payout Cancel Invalid Operator")
    public void Partner_CancelPayout_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutCancellePartnerSteps.navigatePayoutPage();
            this.payoutCancellePartnerSteps.validateRemotePartnerPayoutInvalidOperator();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "Validate Partner Payout Cancel No reason")
    public void Partner_CancelPayout_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutCancellePartnerSteps.navigatePayoutPage();
            this.payoutCancellePartnerSteps.validateRemotePartnerPayoutNoReason();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "Validate Partner Payout Cancel Invalid Reference")
    public void Partner_CancelPayout_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutCancellePartnerSteps.navigatePayoutPage();
            this.payoutCancellePartnerSteps.validatePartnerPayoutCancelKeepTransaction();

        }
    }

}
