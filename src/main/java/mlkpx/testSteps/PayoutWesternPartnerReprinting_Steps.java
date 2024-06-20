package mlkpx.testSteps;

import utilities.Logger.LoggingUtils;

public class PayoutWesternPartnerReprinting_Steps extends Base_Steps{
    //P A Y O U T  W E S T E R N  P A R T N E R  R E P R I N T
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
    public void validateSuccessfulWesternPayoutReprinting()throws Exception{
        click(payoutCancellationPageObjects.payoutRepPage(), "Payout Reprint");
        if(isVisible(payoutCancellationPageObjects.payoutRepPage(), getText(payoutCancellationPageObjects.payoutRepPage()))){
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        String payoutWesternKPTN = reader.getSuccessPayoutWesternKPTN();
        type(payoutCancellationPageObjects.RepKTPN(), "KTPN Number",payoutWesternKPTN);
        type(payoutCancellationPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testing");
        click(payoutCancellationPageObjects.Reprint(), "Search Button");
        if(isVisible(payoutCancellationPageObjects.ReprintPayoutReceipt(), getText(payoutCancellationPageObjects.ReprintPayoutReceipt()))){
            LoggingUtils.info("Navigated the Payout Reprint Receipt page");
            click(payoutCancellationPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing payout receipt");

        }
    }
    public void validateSuccessfulWesternRemotePayoutReprinting()throws Exception{
        click(payoutCancellationPageObjects.payoutRepPage(), "Payout Reprint");
        if(isVisible(payoutCancellationPageObjects.payoutRepPage(), getText(payoutCancellationPageObjects.payoutRepPage()))){
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        String remoteWesternpayoutKPTN = reader.getSuccessPayoutRemoteWesternKPTN();
        type(payoutCancellationPageObjects.RepKTPN(), "KTPN Number",remoteWesternpayoutKPTN);
        type(payoutCancellationPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testing");
        click(payoutCancellationPageObjects.Reprint(), "Search Button");
        if(isVisible(payoutCancellationPageObjects.ReprintPayoutReceipt(), getText(payoutCancellationPageObjects.ReprintPayoutReceipt()))){
            LoggingUtils.info("Navigated the Payout Reprint Receipt page");
            click(payoutCancellationPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing payout receipt");

        }
    }
    public void validateInvalidKTPNWesternPayoutReprinting()throws Exception{
        click(payoutCancellationPageObjects.payoutRepPage(), "Payout Reprint");
        if(isVisible(payoutCancellationPageObjects.payoutRepPage(), getText(payoutCancellationPageObjects.payoutRepPage()))){
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        type(payoutCancellationPageObjects.RepKTPN(), "KTPN Number","KPNKKTNZQEQM");
        type(payoutCancellationPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testing");
        click(payoutCancellationPageObjects.Reprint(), "Search Button");
        assertEqual(getText(payoutCancellationPageObjects.NoTransactionFound()), "No Transaction Found");

    }
    public void validateEmptyReasonWesternPayoutReprinting()throws Exception{
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
