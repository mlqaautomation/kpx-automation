package mlkpx.testSteps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class PayoutCancellation_Steps extends Base_Steps{

    //P A Y O U T    C A N C E L L A T I O N
    public void navigatePayoutPage()throws Exception{
        try{
            click(payoutPageObjects.payout_link(), "Payout");
            if(isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))){
                LoggingUtils.info("Navigated to Payout Page");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Payout Page "+ e);
        }
    }
    public void validateSuccessfulPayoutCancellation()throws Exception{
        //Must need to cancel before/within five minutes.
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        reader.refreshTestData();
        waitSleep(3000);
        String payoutKPTN = reader.getPayoutKPTN(); // Call the getPayoutKPTN function
        type(payoutPageObjects.CancelKTPN(), "KTPN Number",payoutKPTN);
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "KTPN Number", "2111111111212");
            type(payoutPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(payoutPageObjects.CancelButton(), "Cancel Payout");
//            click(payoutPageObjects.YesCancelButton(), "Yes, Cancel Button");
//            assertEqual(getText(payoutPageObjects.SuccessfulCancelPay()), "Payout Cancelled");
//            if (getText(payoutPageObjects.SuccessfulCancelPay()).equals("Payout Cancelled")) {
//                List<String> payoutKPTNList = Collections.singletonList(payoutKPTN);
//                // Write the payout KPTN data to the YAML file
//                reader.writeKptnData(payoutKPTNList);
//                waitSleep(5000);
//                click(payoutPageObjects.OKay(), "OK");
//            }

            try{
                click(payoutPageObjects.YesCancelButton(), "Yes, Cancel Button");
                if (getText(payoutPageObjects.SuccessfulCancelPay()).equals("Payout Cancelled")) {
                    assertEqual(getText(payoutPageObjects.SuccessfulCancelPay()), "Payout Cancelled");
                    List<String> payoutKPTNList = Collections.singletonList(payoutKPTN);
                    reader.writeKptnData(payoutKPTNList);
                    waitSleep(2000);
                    click(payoutPageObjects.OKay(), "OK");

                }

            }catch (Exception e){
                LoggingUtils.info("Payout Cancellation Unsuccessful");
                List<String> kptnValues = Collections.singletonList(payoutKPTN);
                reader.writeKptnData(kptnValues);
                waitSleep(2000);
            }
        }
    }
    public void validateRemoteSuccessfulPayoutCancellation()throws Exception{

        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        reader.refreshTestData();
        waitSleep(3000);
        String remotePayoutKPTN = reader.getRemotePayoutKPTN(); // Call the getRemotePayoutKPTN function
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", remotePayoutKPTN);
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "KTPN Number", "2111111111113");
            type(payoutPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(payoutPageObjects.CancelButton(), "Cancel Payout");
//            click(payoutPageObjects.YesCancelButton(), "Yes, Cancel Button");
//            if (getText(payoutPageObjects.SuccessfulCancelPay()).equals("Payout Cancelled")) {
//                List<String> payoutremoteKPTNList = Collections.singletonList(remotePayoutKPTN);
//                // Write the payout remote KPTN data to the YAML file
//                reader.writeRemoteKptnData(payoutremoteKPTNList);
//                waitSleep(5000);
//                click(payoutPageObjects.OKay(), "OK");
//            }

            try{
                click(payoutPageObjects.YesCancelButton(), "Yes, Cancel Button");
                if (getText(payoutPageObjects.SuccessfulCancelPay()).equals("Payout Cancelled")) {
                    assertEqual(getText(payoutPageObjects.SuccessfulCancelPay()), "Payout Cancelled");
                    List<String> payoutremoteKPTNList = Collections.singletonList(remotePayoutKPTN);
                    // Write the payout remote KPTN data to the YAML file
                    reader.writeRemoteKptnData(payoutremoteKPTNList);
                    waitSleep(2000);
                    click(payoutPageObjects.OKay(), "OK");

                }

            }catch (Exception e){
                LoggingUtils.info("Payout Remote Cancellation Unsuccessful");
                List<String> payoutremoteKPTNList = Collections.singletonList(remotePayoutKPTN);
                // Write the payout remote KPTN data to the YAML file
                reader.writeRemoteKptnData(payoutremoteKPTNList);
                waitSleep(2000);
            }

        }
    }
    public void validateInvalidKTPNPayoutCancellation()throws Exception{

        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");
        }
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", "KPNKHPRGHKJK");
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.NoTransactionFound(), getText(payoutPageObjects.NoTransactionFound()))) {
            assertEqual(getText(payoutPageObjects.NoTransactionFound()), "No Transaction Found");

        }


    }
    public void validateAlreadyBeenCancelledTransaction()throws Exception{

        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");
        }
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", "KPNRCHYTSSW");
        click(payoutPageObjects.SearchButton(), "Search Button");

        assertEqual(getText(payoutPageObjects.AlreadyBeenCancelled()), "Payout transaction has already been cancelled.");

    }
    public void validatePayoutCancellationWithNoKPTN()throws Exception{

        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");
        }
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", "");
        click(payoutPageObjects.SearchButton(), "Search Button");
        assertEqual(getText(payoutPageObjects.CKTPNRequired()), "KPTN is required");

    }
    public void validateNoIRNumberProvided()throws Exception{

        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", "KPNJUGPIVZI");
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "IR Number", "");
            click(payoutPageObjects.CancelButton(), "Cancel Payout");

            assertEqual(getText(payoutPageObjects.IRNumRequired()), "IR Number is required");


        }
    }
    public void validateRemoteNoIRNumberProvided()throws Exception{

        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", propertyReader.getproperty("RUnclaimKTPNnum"));
        click(payoutPageObjects.SearchButton(), "Search Button");
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));

        type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R33A180912");
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(15));

        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", "2023639709");
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "KTPN Number", "");
            click(payoutPageObjects.CancelButton(), "Cancel Payout");

            assertEqual(getText(payoutPageObjects.IRNumRequired()), "IR Number is required");


        }
    }
    public void validateNoReasonProvided()throws Exception{

        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", propertyReader.getproperty("RUnclaimKTPNnum"));
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "KTPN Number", propertyReader.getproperty("IrNO"));
            type(payoutPageObjects.ReasonCancel(), "Reason for Cancellation ", "");
            click(payoutPageObjects.CancelButton(), "Cancel Payout");

            assertEqual(getText(payoutPageObjects.ReasonRequired()), "Reason for Cancellation is required");
        }
    }
    public void validateRemoteNoReasonProvided()throws Exception{

        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", propertyReader.getproperty("RUnclaimKTPNnum"));
        click(payoutPageObjects.SearchButton(), "Search Button");
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));

        type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R33A180912");
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(15));

        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", "2023639709");
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "KTPN Number", propertyReader.getproperty("IrNO"));
            type(payoutPageObjects.ReasonCancel(), "Reason for Cancellation ", "");
            click(payoutPageObjects.CancelButton(), "Cancel Payout");

            assertEqual(getText(payoutPageObjects.ReasonRequired()), "Reason for Cancellation is required");
        }
    }
    public void validateRemoteInvalidBranchCodeProvided()throws Exception{

        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", propertyReader.getproperty("RUnclaimKTPNnum"));
        click(payoutPageObjects.SearchButton(), "Search Button");
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));

        type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R33A1840912");

        assertEqual(getText(payoutPageObjects.BranchNotFound()), "Branch not found");
    }
    public void validateRemoteInvalidOperatorIDProvided()throws Exception{

        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", propertyReader.getproperty("RUnclaimKTPNnum"));
        click(payoutPageObjects.SearchButton(), "Search Button");
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));

        type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R33A180912");
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(15));

        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", "20236379709");
        assertEqual(getText(payoutPageObjects.OperatorNotFound()), "Operator not found");
    }
    public void validateCannotCancelPayout()throws Exception{
        //Must need to cancel before/within five minutes.
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", propertyReader.getproperty("RUnclaimKTPNnum"));
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "KTPN Number", propertyReader.getproperty("IrNO"));
            type(payoutPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(payoutPageObjects.CancelButton(), "Cancel Payout");
            click(payoutPageObjects.YesCancelButton(), "Yes, Cancel Button");

            assertEqual(getText(payoutPageObjects.CannotCancel()), "Cannot Cancel Payout");
        }
    }
    public void validateKeepTheTransaction()throws Exception{

        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", propertyReader.getproperty("RUnclaimKTPNnum"));
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "KTPN Number", propertyReader.getproperty("IrNO"));
            type(payoutPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(payoutPageObjects.KeepTransaction(), "Keep Transaction");
            click(payoutPageObjects.YesKeepTransaction(), "Yes, Keep Transaction");

            assertEqual(getText(payoutPageObjects.PayoutCancellationAmountInfo()), "Payout Cancellation");
        }
    }
    public void validateKeepTheTransactionAfterFiveMinutes()throws Exception{

        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.PayoutCancellation(), getText(payoutPageObjects.PayoutCancellation()))){
            click(payoutPageObjects.PayoutCancellation(), "Payout Cancellation Page");
            LoggingUtils.info("Navigated the Payout Cancellation page");

        }
        type(payoutPageObjects.CancelKTPN(), "KTPN Number", "KPNKTNZQEQM");
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "KTPN Number", propertyReader.getproperty("IrNO"));
            type(payoutPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(payoutPageObjects.CancelButton(), "Cancel Payout");
            click(payoutPageObjects.YesCancelButton(), "Yes, Cancel Button");
            assertEqual(getText(payoutPageObjects.FailedCancel()), "Cancel Payout Failed");


        }
    }
}
