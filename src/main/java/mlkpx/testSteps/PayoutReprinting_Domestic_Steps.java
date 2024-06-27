package mlkpx.testSteps;

import utilities.Logger.LoggingUtils;

public class PayoutReprinting_Domestic_Steps extends Base_Steps{
    //P A Y O U T  R E P R I N T
    public void navigatePayoutPage()throws Exception{
        try{
            click(payoutCancellationPageObjects.payout_link(), "Payout");
            if(isVisible(payoutCancellationPageObjects.payoutPage_h2(), getText(payoutCancellationPageObjects.payoutPage_h2()))){
                LoggingUtils.info("Navigated to Payout Page");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Payout Page "+ e);
        }
    }
    public void validateSuccessfulPayoutReprinting()throws Exception{
        click(payoutCancellationPageObjects.payoutRepPage(), "Payout Reprint");
        if(isVisible(payoutCancellationPageObjects.payoutRepPage(), getText(payoutCancellationPageObjects.payoutRepPage()))){
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(10000);
        String payoutKPTN = reader.getPayoutKPTN();
        type(payoutCancellationPageObjects.RepKTPN(), "KTPN Number",payoutKPTN);
        type(payoutCancellationPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testing");
        click(payoutCancellationPageObjects.Reprint(), "Search Button");
        waitSleep(5000);
        if(isVisible(payoutCancellationPageObjects.ReprintPayoutPartnerReceipt(), getText(payoutCancellationPageObjects.ReprintPayoutPartnerReceipt()))){
            LoggingUtils.info("Navigated the Payout Partner Reprint Receipt page");
            click(payoutCancellationPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing payout receipt");

        }
    }
    public void validateSuccessfulRemotePayoutReprinting()throws Exception{
        click(payoutCancellationPageObjects.payoutRepPage(), "Payout Reprint");
        if(isVisible(payoutCancellationPageObjects.payoutRepPage(), getText(payoutCancellationPageObjects.payoutRepPage()))){
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(10000);
        String remotepayoutKPTN = reader.getSuccessRemotePayoutKPTN();
        type(payoutCancellationPageObjects.RepKTPN(), "KTPN Number",remotepayoutKPTN);
        type(payoutCancellationPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testing");
        click(payoutCancellationPageObjects.Reprint(), "Search Button");
        waitSleep(5000);
        if(isVisible(payoutCancellationPageObjects.ReprintPayoutPartnerReceipt(), getText(payoutCancellationPageObjects.ReprintPayoutPartnerReceipt()))){
            LoggingUtils.info("Navigated the Payout Partner Reprint Receipt page");
            click(payoutCancellationPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing payout receipt");

        }
    }
    public void validateInvalidKTPNPayoutReprinting()throws Exception{
        click(payoutCancellationPageObjects.payoutRepPage(), "Payout Reprint");
        if(isVisible(payoutCancellationPageObjects.payoutRepPage(), getText(payoutCancellationPageObjects.payoutRepPage()))){
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        type(payoutCancellationPageObjects.RepKTPN(), "KTPN Number","KPNKKTNZQEQM");
        type(payoutCancellationPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testing");
        click(payoutCancellationPageObjects.Reprint(), "Search Button");
        assertEqual(getText(payoutCancellationPageObjects.NoTransactionFound()), "No Transaction Found");

    }
    public void validateEmptyReasonPayoutReprinting()throws Exception{
        click(payoutCancellationPageObjects.payoutRepPage(), "Payout Reprint");
        if(isVisible(payoutCancellationPageObjects.payoutRepPage(), getText(payoutCancellationPageObjects.payoutRepPage()))){
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        type(payoutCancellationPageObjects.RepKTPN(), "KTPN Number","KPNKTNZQEQM");
        type(payoutCancellationPageObjects.ReasonReprinting(), "Reason for Reprinting ", "");
        click(payoutCancellationPageObjects.Reprint(), "Search Button");
        assertEqual(getText(payoutCancellationPageObjects.ReReasonRequired()), "Reason is required");

    }
}
