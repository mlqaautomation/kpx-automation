package mlkpx.testSteps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class BillsPayCancellation_Steps extends Base_Steps{
    //B I L L S  P A Y    C A N C E L L A T I O N
    public void navigatePayoutPage()throws Exception{
        try{
            click(billsPayPageObjects.billsPay_link(), "Bills Pay");
            if(isVisible(billsPayPageObjects.billsPay_h2(), getText(billsPayPageObjects.billsPay_h2()))){
                LoggingUtils.info("Navigated to Bills Pay Page");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Bills Pay Page "+ e);
        }
    }
    public void validateSuccessfulBillsPayCancellation()throws Exception{
        //Must need to cancel before/within five minutes.
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String BillsPayKPTN = reader.getBillsPayKPTN();
            type(billsPayPageObjects.RefNum(), "KTPN Number",BillsPayKPTN);
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "KTPN Number", "2111111111262");
            type(billsPayPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            click(billsPayPageObjects.YesCancelPayment(), "Yes, Cancel Payment");
            LoggingUtils.info("Bills Pay Cancelled" +
                    "Payment has been successfully cancelled.");

        }

    }
    public void validateSuccessfulRemoteBillsPayCancellation()throws Exception{
        //Must need to cancel before/within five minutes.
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String BillsPayRemoteKPTN = reader.getRemoteBillsPayKPTN();
            type(billsPayPageObjects.RefNum(), "KTPN Number",BillsPayRemoteKPTN);
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            click(billsPayPageObjects.RemoteTransaction(), "Remote Transaction");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(billsPayPageObjects.BranchCode()));

            type(billsPayPageObjects.BranchCode(), "Search Branch Code",  propertyReader.getproperty("BranchCode"));
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(13));

            waits.until(ExpectedConditions.elementToBeClickable(billsPayPageObjects.OperatorID()));
            type(billsPayPageObjects.OperatorID(), "Search Operator ID",  propertyReader.getproperty("OperatorID"));
            type(billsPayPageObjects.ReasonRemote(), "Reason", "Testing");

            type(billsPayPageObjects.IRNum(), "KTPN Number", "2111111113262");
            type(billsPayPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            click(billsPayPageObjects.YesCancelPayment(), "Yes, Cancel Payment");
            LoggingUtils.info("Bills Pay Cancelled" +
                    "Payment has been successfully cancelled.");
        }
    }
    public void validateEmptyRefBillsPayCancellation()throws Exception{
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","");
            click(billsPayPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(billsPayPageObjects.EmptyRef()), "Reference Number is required");
        }
    }
    public void validateInvalidRefBillsPayCancellation()throws Exception{
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPGQTCVKWTN");
            click(billsPayPageObjects.SearchButton(), "Search Button");

            if(isVisible(billsPayPageObjects.InvalidKTPN(), getText(billsPayPageObjects.Page_h5()))){
                assertEqual(getText(billsPayPageObjects.Page_h5()), "No Transaction Found");
            }
            click(billsPayPageObjects.OKButton(), "OK");
        }
    }
    public void validateCancelledBillsPayRefNum()throws Exception{
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPGQTCVWTN");
            click(billsPayPageObjects.SearchButton(), "Search Button");

            if(isVisible(billsPayPageObjects.CancelledRefNum(), getText(billsPayPageObjects.CancelledRefNum()))){
                assertEqual(getText(billsPayPageObjects.CancelledRefNum()), "Bills Payment Cancelled");
            }
            click(billsPayPageObjects.OKButton(), "OK");
        }
    }
    public void validateCancelledBillsPayInvalidIRNumber()throws Exception{
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
            type(billsPayPageObjects.IRNum(), "KTPN Number", "343453453453");
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");


        if(isVisible(billsPayPageObjects.InvalidIRNum(), getText(billsPayPageObjects.InvalidIRNum()))){
            ExtentReporter.logPass("validate Cancelled BillsPay Invalid IR Number", "Successfully validate Cancelled BillsPay Invalid IR Number");
        }else{
            ExtentReporter.logFail("validate Cancelled BillsPay Invalid IR Number", "validate Cancelled BillsPay Invalid IR Number");
            Assert.fail("validate Cancelled BillsPay Invalid IR Number");

            assertEqual(getText(billsPayPageObjects.InvalidIR()), "Please enter valid IR No.");

        }
    }
    public void validateCancelledBillsPayNoReason()throws Exception{
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "KTPN Number", "2111111111262");
            type(billsPayPageObjects.ReasonCancel(), "Reason for Cancellation ", "");
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            assertEqual(getText(billsPayPageObjects.NoReason()), "Reason for Cancellation is required");


        }
    }
    public void validateCancelledBillsPayNoIRNumber()throws Exception{
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "IR Number", "");
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            assertEqual(getText(billsPayPageObjects.NoIRNum()), "IR Number is required");
        }
    }
    public void validateCancelledBillsPayNoInitiatedBy()throws Exception{
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "KTPN Number", "2111111111262");
            type(billsPayPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(billsPayPageObjects.NoInitiatedBy(), "Initiated By");
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            LoggingUtils.info("Please select an item in the list display and you can't proceed to cancellations");

        }
    }
    public void validateCancelledBillsPayKeepTransaction()throws Exception{
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "KTPN Number", "2111111111262");
            type(billsPayPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            click(billsPayPageObjects.KeepTransaction(), "Keep Transaction");
            click(billsPayPageObjects.YesKeepTransaction(), "Yes, Keep Transaction");
            LoggingUtils.info("You will return to Bills Pay Cancellation" +
                    "Search Transaction");

        }
    }
    public void validateCancelledBillsPayStayInPage()throws Exception{
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "KTPN Number", "2111111111262");
            type(billsPayPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            click(billsPayPageObjects.NoCancelPayment(), "No, Keep Transaction");
            LoggingUtils.info("You will stay in the Bills Pay Cancellation" +
                    "Transaction Details");

        }
    }

}
