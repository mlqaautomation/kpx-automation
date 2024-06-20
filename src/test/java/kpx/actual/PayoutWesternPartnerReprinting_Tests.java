package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class PayoutWesternPartnerReprinting_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }

    //P A Y O U T  R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful payout reprinting transaction")
    public void Payout_Western_TC_Reprinting_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_13();
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validateSuccessfulPartnerPayout();
            this.payoutReprintingSteps.navigatePayoutPage();
            this.payoutReprintingSteps.validateSuccessfulPayoutReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote payout reprinting transaction")
    public void Payout_Western_TC_Reprinting_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_14();
            this.payoutPartnersSteps.navigatePayoutPage();
            this.payoutPartnersSteps.validateRemoteSuccessfulPartnerPayout();
            this.payoutReprintingSteps.navigatePayoutPage();
            this.payoutReprintingSteps.validateSuccessfulRemotePayoutReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate payout reprinting with invalid KPTN transaction")
    public void Payout_Western_TC_Reprinting_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutReprintingSteps.navigatePayoutPage();
            this.payoutReprintingSteps.validateInvalidKTPNPayoutReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate payout reprinting with no Reason provided")
    public void Payout_Western_TC_Reprinting_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutReprintingSteps.navigatePayoutPage();
            this.payoutReprintingSteps.validateEmptyReasonPayoutReprinting();

        }

    }

}
