package mlkpx.testSteps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;

import java.time.Duration;

public class BillsPayCancellation_CEBECO_Steps extends Base_Steps{
    //B I L L S  P A Y  C E B E C O  III  C A N C E L L A T I O N
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
    public void validateSuccessfulBillsPayCancellationCEBECOPartner()throws Exception{
        //Must need to cancel before/within five minutes.
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "CEBECO III Partner Bills Pay Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String BillsPayKPTN = reader.getBillsPayCEBECOKPTN();
            type(billsPayPageObjects.RefNum(), "KTPN Number",BillsPayKPTN);
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "KTPN Number", "2111111111262");
            type(billsPayPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.CancelPayment());
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            click(billsPayPageObjects.YesCancelPayment(), "Yes, Cancel Payment");
            waitSleep(10000);
            LoggingUtils.info("Bills Pay Cancelled" +
                    "Payment has been successfully cancelled.");

        }

    }
    public void validateSuccessfulRemoteBillsPayCancellationCEBECOPartner()throws Exception{
        //Must need to cancel before/within five minutes.
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "CEBECO III Partner  Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String BillsPayRemoteKPTN = reader.getRemoteBillsPayCEBECOKPTN();
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
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.CancelPayment());
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            click(billsPayPageObjects.YesCancelPayment(), "Yes, Cancel Payment");
            LoggingUtils.info("Bills Pay Cancelled" +
                    "Payment has been successfully cancelled.");
        }
    }
    public void validateEmptyRefBillsPayCancellationCEBECOPartner()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "CEBECO III Partner Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","");
            click(billsPayPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(billsPayPageObjects.EmptyRef()), "Reference Number is required");
        }
    }
    public void validateInvalidRefBillsPayCancellationCEBECOPartner()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "CEBECO III Partner Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPGQTGFERGFCVKWTN");
            click(billsPayPageObjects.SearchButton(), "Search Button");

            if(isVisible(billsPayPageObjects.InvalidKTPN(), getText(billsPayPageObjects.Page_h5()))){
                assertEqual(getText(billsPayPageObjects.Page_h5()), "No Transaction Found");
            }
            click(billsPayPageObjects.OKButton(), "OK");
        }
    }
    public void validateCancelledBillsPayRefNumCEBECOPartner()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "CEBECO III Partner Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPIAOTZTHZ");
            click(billsPayPageObjects.SearchButton(), "Search Button");

            if(isVisible(billsPayPageObjects.CancelledRefNum(), getText(billsPayPageObjects.CancelledRefNum()))){
                assertEqual(getText(billsPayPageObjects.CancelledRefNum()), "Bills Payment Cancelled");
            }
            click(billsPayPageObjects.OKButton(), "OK");
        }
    }
    public void validateCancelledBillsPayInvalidIRNumberCEBECOPartner()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "CEBECO III Partner Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPFRVDQZNG");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "KTPN Number", "2111566262");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.CancelPayment());
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            assertEqual(getText(billsPayPageObjects.InvalidIR()), "Please enter valid IR No.");
        }
    }
    public void validateCancelledBillsPayNoReasonCEBECOPartner()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "CEBECO III Partner Bills Pay Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPFRVDQZNG");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "KTPN Number", "2111123111262");
            type(billsPayPageObjects.ReasonCancel(), "Reason for Cancellation ", "");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.CancelPayment());
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            assertEqual(getText(billsPayPageObjects.NoReason()), "Reason for Cancellation is required");


        }
    }
    public void validateCancelledBillsPayNoIRNumberCEBECOPartner()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "CEBECO III Partner Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPFRVDQZNG");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "IR Number", "");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.CancelPayment());
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            assertEqual(getText(billsPayPageObjects.NoIRNum()), "IR Number is required");
        }
    }
    public void validateCancelledBillsPayNoInitiatedByCEBECOPartner()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "CEBECO III Partner Bills Pay Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPFRVDQZNG");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "KTPN Number", "2111111111262");
            type(billsPayPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(billsPayPageObjects.NoInitiatedBy(), "Initiated By");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.CancelPayment());
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            LoggingUtils.info("Please select an item in the list display and you can't proceed to cancellations");

        }
    }
    public void validateCancelledBillsPayKeepTransactionCEBECOPartner()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "CEBECO III Partner Bills Pay Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPFRVDQZNG");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "KTPN Number", "2111111111262");
            type(billsPayPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.KeepTransaction());
            click(billsPayPageObjects.KeepTransaction(), "Keep Transaction");
            click(billsPayPageObjects.YesKeepTransaction(), "Yes, Keep Transaction");
            LoggingUtils.info("You will return to Bills Pay Cancellation" +
                    "Search Transaction");

        }
    }
    public void validateCancelledBillsPayStayInPageCEBECOPartner()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "CEBECO III Partner Bills Pay Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPFRVDQZNG");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "KTPN Number", "2111111111262");
            type(billsPayPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.CancelPayment());
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            click(billsPayPageObjects.NoCancelPayment(), "No, Keep Transaction");
            LoggingUtils.info("You will stay in the Bills Pay Cancellation" +
                    "Transaction Details");

        }
    }

}
