package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class PayoutCancellation_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }

    // P A Y O U T    C A N C E L L A T I O N

//    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "Validate successful payout cancellation")
//    public void Payout_TC_Cancellation_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.payoutCancellationSteps.navigatePayoutPage();
//            this.payoutCancellationSteps.validateSuccessfulPayoutCancellation();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "Validate remote successful payout cancellation")
//    public void Payout_TC_Cancellation_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.payoutCancellationSteps.navigatePayoutPage();
//            this.payoutCancellationSteps.validateRemoteSuccessfulPayoutCancellation();
//
//        }
//    }
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "Validate payout cancellation with invalid KPTN")
//    public void Payout_TC_Cancellation_03()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.payoutCancellationSteps.navigatePayoutPage();
//            this.payoutCancellationSteps.validateInvalidKTPNPayoutCancellation();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "Validate payout already been cancelled transaction")
//    public void Payout_TC_Cancellation_04()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.payoutCancellationSteps.navigatePayoutPage();
//            this.payoutCancellationSteps.validateAlreadyBeenCancelledTransaction();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate payout cancellation with no KPTN provided")
//    public void Payout_TC_Cancellation_05()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.payoutCancellationSteps.navigatePayoutPage();
//            this.payoutCancellationSteps.validatePayoutCancellationWithNoKPTN();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate payout cancellation with no IR number provided")
//    public void Payout_TC_Cancellation_06()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.payoutCancellationSteps.navigatePayoutPage();
//            this.payoutCancellationSteps.validateNoIRNumberProvided();
//
//        }
//
//    }
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate payout cancellation with no Reason provided")
//    public void Payout_TC_Cancellation_08()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.payoutCancellationSteps.navigatePayoutPage();
//            this.payoutCancellationSteps.validateNoReasonProvided();
//
//        }
//
//    }
//
//
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate Keep the transaction In cancellation process")
//    public void Payout_TC_Cancellation_12()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.payoutCancellationSteps.navigatePayoutPage();
//            this.payoutCancellationSteps.validateKeepTheTransaction();
//
//        }
//
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate Cancel Payout after 5 minutes of transaction")
    public void Payout_TC_Cancellation_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutCancellationSteps.navigatePayoutPage();
            this.payoutCancellationSteps.validateKeepTheTransactionAfterFiveMinutes();

        }

    }
}
