package mlkpx.testSteps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class PayoutCancelle_Partner_Steps extends Base_Steps{
    //P A Y O U T  P A R T N E R S  C A N C E L L A T I O N
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

    public void validateSuccessfulPartnerPayoutCancellation()throws Exception{
        //Must need to cancel before/within five minutes.
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.payoutPartnerCancel(), getText(payoutPageObjects.payoutPartnerCancel()))){
            click(payoutPageObjects.payoutPartnerCancel(), "Payout Partner Cancellation Page");
            LoggingUtils.info("Navigated the Payout Partner Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        String payoutRef = reader.getPayoutReference();
        type(payoutPageObjects.CancelReference(), "Reference Number",payoutRef);
        click(payoutPageObjects.SelectPartners(), "Select Partner");
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(10000);
        waitSleep(2000);
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "IR Number", "2111111711212");
            click(payoutPageObjects.ReasonOfCan(), "Reason for Cancellation");
            click(payoutPageObjects.CancelButton(), "Cancel Payout");

            try{
                click(payoutPageObjects.YesCancelTran(), "Yes, Cancel Transaction");
                waitUntilLoadingGone(10000);
                waitSleep(5000);
                if (getText(payoutPageObjects.SuccessfulCancelPartners()).equals("Payout Reversed")) {
                    assertEqual(getText(payoutPageObjects.SuccessfulCancelPartners()), "Payout Reversed");
                    List<String> payoutKPTNList = Collections.singletonList(payoutRef);
                    reader.writeReferenceNumData(payoutKPTNList);
                    waitSleep(2000);
                    click(payoutPageObjects.OKay(), "OK");

                }

            }catch (Exception e){
                LoggingUtils.info("Payout Cancellation Unsuccessful");
                List<String> kptnValues = Collections.singletonList(payoutRef);
                reader.writeReferenceNumData(kptnValues);
                waitSleep(2000);
            }
        }
    }
    public void validatePartnerPayoutCancelInvalidReference()throws Exception{
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.payoutPartnerCancel(), getText(payoutPageObjects.payoutPartnerCancel()))){
            click(payoutPageObjects.payoutPartnerCancel(), "Payout Partner Cancellation Page");
            LoggingUtils.info("Navigated the Payout Partner Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.CancelReference(), "Reference Number","345345");
        click(payoutPageObjects.SelectPartners(), "Select Partner");
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.InvalidKTPN(), getText(payoutPageObjects.InvalidKTPN()))){
            assertEqual(getText(payoutPageObjects.InvalidKTPN()), "No Transaction Found");
            LoggingUtils.info("Partner transfer transaction could not be found. Please check the reference no. and try again. ");
        }
        click(payoutPageObjects.OKInvalidKTPN(), "OK");
    }
    public void validatePartnerPayoutCancelAlreadyCancel()throws Exception{
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.payoutPartnerCancel(), getText(payoutPageObjects.payoutPartnerCancel()))){
            click(payoutPageObjects.payoutPartnerCancel(), "Payout Partner Cancellation Page");
            LoggingUtils.info("Navigated the Payout Partner Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.CancelReference(), "Reference Number","6080596293");
        click(payoutPageObjects.SelectPartners(), "Select Partner");
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.InvalidKTPN(), getText(payoutPageObjects.InvalidKTPN()))){
            assertEqual(getText(payoutPageObjects.InvalidKTPN()), "No Transaction Found");
            LoggingUtils.info("This transaction has already been cancelled. (version: 8a17104) (version: 8a17104)");
        }
        click(payoutPageObjects.OKInvalidKTPN(), "OK");
    }
    public void validatePartnerPayoutCancelEmptyRef()throws Exception{
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.payoutPartnerCancel(), getText(payoutPageObjects.payoutPartnerCancel()))){
            click(payoutPageObjects.payoutPartnerCancel(), "Payout Partner Cancellation Page");
            LoggingUtils.info("Navigated the Payout Partner Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.CancelReference(), "Reference Number","");
        click(payoutPageObjects.SelectPartners(), "Select Partner");
        click(payoutPageObjects.SearchButton(), "Search Button");
        LoggingUtils.info("Please fill out this field.");


    }
    public void validatePartnerPayoutCancelEmptyPartner()throws Exception{
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.payoutPartnerCancel(), getText(payoutPageObjects.payoutPartnerCancel()))){
            click(payoutPageObjects.payoutPartnerCancel(), "Payout Partner Cancellation Page");
            LoggingUtils.info("Navigated the Payout Partner Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.CancelReference(), "Reference Number","6080596293");
        click(payoutPageObjects.SearchButton(), "Search Button");
        LoggingUtils.info("Please select in the item list.");

    }
    public void validateSuccessfulPartnerPayoutNoIR()throws Exception{
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.payoutPartnerCancel(), getText(payoutPageObjects.payoutPartnerCancel()))){
            click(payoutPageObjects.payoutPartnerCancel(), "Payout Partner Cancellation Page");
            LoggingUtils.info("Navigated the Payout Partner Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.CancelReference(), "Reference Number","1702130317");
        click(payoutPageObjects.SelectPartners(), "Select Partner");
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(10000);
        waitSleep(2000);
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "IR Number", "");
            click(payoutPageObjects.ReasonOfCan(), "Reason for Cancellation");
            click(payoutPageObjects.CancelButton(), "Cancel Payout");
            assertEqual(getText(payoutPageObjects.IRNumRequired()), "IR Number is required");
        }
    }
    public void validateSuccessfulPartnerPayoutNoReason()throws Exception{
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.payoutPartnerCancel(), getText(payoutPageObjects.payoutPartnerCancel()))){
            click(payoutPageObjects.payoutPartnerCancel(), "Payout Partner Cancellation Page");
            LoggingUtils.info("Navigated the Payout Partner Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.CancelReference(), "Reference Number","1702130317");
        click(payoutPageObjects.SelectPartners(), "Select Partner");
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(10000);
        waitSleep(2000);
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "IR Number", "4322222222222");
            click(payoutPageObjects.CancelButton(), "Cancel Payout");
            assertEqual(getText(payoutPageObjects.ReasonRequired()), "Reason for Cancellation is required");
        }
    }
    public void validateRemotePartnerPayoutInvalidCode()throws Exception{
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.payoutPartnerCancel(), getText(payoutPageObjects.payoutPartnerCancel()))){
            click(payoutPageObjects.payoutPartnerCancel(), "Payout Partner Cancellation Page");
            LoggingUtils.info("Navigated the Payout Partner Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.CancelReference(), "Reference Number","6182293584");
        click(payoutPageObjects.SelectPartners(), "Select Partner");
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(10000);
        waitSleep(2000);
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", "6456456");
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            click(payoutPageObjects.CancelButton(), "Cancel Payout");
            assertEqual(getText(payoutPageObjects.BranchRequired()), "Branch not found");

        }
    }
    public void validateRemotePartnerPayoutInvalidOperator()throws Exception{
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.payoutPartnerCancel(), getText(payoutPageObjects.payoutPartnerCancel()))){
            click(payoutPageObjects.payoutPartnerCancel(), "Payout Partner Cancellation Page");
            LoggingUtils.info("Navigated the Payout Partner Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.CancelReference(), "Reference Number","6182293584");
        click(payoutPageObjects.SelectPartners(), "Select Partner");
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(10000);
        waitSleep(2000);
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", "456464");
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            click(payoutPageObjects.CancelButton(), "Cancel Payout");
            assertEqual(getText(payoutPageObjects.OperatorRequired()), "Operator not found");

        }
    }
    public void validateRemotePartnerPayoutNoReason()throws Exception{
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.payoutPartnerCancel(), getText(payoutPageObjects.payoutPartnerCancel()))){
            click(payoutPageObjects.payoutPartnerCancel(), "Payout Partner Cancellation Page");
            LoggingUtils.info("Navigated the Payout Partner Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.CancelReference(), "Reference Number","6182293584");
        waitSleep(3000);
        click(payoutPageObjects.SelectPartners(), "Select Partner");
        waitSleep(3000);
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(10000);
        waitSleep(2000);
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "");
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            click(payoutPageObjects.CancelButton(), "Cancel Payout");
            assertEqual(getText(payoutPageObjects.ReasonsRequired()), "Reason is required.");

        }
    }
    public void validatePartnerPayoutCancelKeepTransaction()throws Exception{
        //Must need to cancel before/within five minutes.
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.payoutCanPage(), "Payout Cancellation");
        if(isVisible(payoutPageObjects.payoutPartnerCancel(), getText(payoutPageObjects.payoutPartnerCancel()))){
            click(payoutPageObjects.payoutPartnerCancel(), "Payout Partner Cancellation Page");
            LoggingUtils.info("Navigated the Payout Partner Cancellation page");

        }
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        String payoutRef = reader.getPayoutReference();
        type(payoutPageObjects.CancelReference(), "Reference Number",payoutRef);
        click(payoutPageObjects.SelectPartners(), "Select Partner");
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(10000);
        waitSleep(2000);
        if(isVisible(payoutPageObjects.PayoutCancellationAmountInfo(), getText(payoutPageObjects.PayoutCancellationAmountInfo()))){
            type(payoutPageObjects.IRNum(), "IR Number", "2111111711212");
            click(payoutPageObjects.ReasonOfCan(), "Reason for Cancellation");
            click(payoutPageObjects.KeepTransaction(), "Keep Transaction");
            click(payoutPageObjects.YesKeepTransaction(), "Yes, Keep Transaction");


        }
    }
}

