package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class Payout_Partners_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "Successful partner payout transaction")
//    public void Partner_Payout_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendoutPartnersSteps.PS_TC_01();
//            this.payoutPartnersSteps.navigatePayoutPage();
//            this.payoutPartnersSteps.validateSuccessfulPartnerPayout();
//
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "Successful remote partner payout transaction")
//    public void Partner_Payout_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.payoutPartnersSteps.navigatePayoutPage();
//            this.payoutPartnersSteps.validateRemoteSuccessfulPartnerPayout();
//
//        }
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "Partner payout transaction invalid ref")
    public void Partner_Payout_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validatePartnerPayoutInvalidRef();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "Remote partner payout transaction invalid ref")
    public void Partner_Payout_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validateRemotePartnerPayoutInvalidRef();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "Partner payout transaction wrong partner")
    public void Partner_Payout_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validatePartnerPayoutWrongPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "Remote partner payout transaction Wrong Partner")
    public void Partner_Payout_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validateRemotePartnerPayoutWrongPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "Partner payout transaction already claimed ref")
    public void Partner_Payout_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validatePartnerPayoutClaimedRef();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "Partner payout transaction empty ref")
    public void Partner_Payout_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validatePartnerPayoutEmptyRef();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "Partner payout transaction empty ref")
    public void Partner_Payout_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validateRemotePartnerPayoutEmptyRef();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "Partner payout transaction empty partner")
    public void Partner_Payout_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validatePartnerPayoutEmptyPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "Remote Partner payout transaction empty partner")
    public void Partner_Payout_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validateRemotePartnerPayoutEmptyPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "Partner payout transaction empty purpose")
    public void Partner_Payout_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validatePartnerPayoutEmptyPurpose();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "Partner payout transaction empty relation")
    public void Partner_Payout_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validatePartnerPayoutEmptyRelation();

        }
    }

}
