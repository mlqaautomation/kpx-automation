package mlkpx.testSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class BillsPayGENTRADE_Steps extends Base_Steps{
    public void navigatePayoutPage()throws Exception{
        try{
            click(billsPayPageObjects.billsPay_link(), "Bills Pay");
            waitSleep(5000);
            if(isVisible(billsPayPageObjects.billsPay_h2(), getText(billsPayPageObjects.billsPay_h2()))){
                LoggingUtils.info("Navigated to Bills Pay Page");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Bills Pay Page "+ e);
        }
    }
    //B I L L S  P A Y   G E N T R A D E  I N T E R N A T I O N A L   S E N D O U T
    public void BPSendout_GENTRADE_01()throws Exception {
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(5000);
        click(billsPayPageObjects.ClickOption(), "Option");
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),3500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionGentrade(), "GENTRADE INTERNATIONAL PHILS. INC. Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP GENTRADE Account Number", "53300000000");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Siarot ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Enrique");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "Alferez");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "SIAROTTEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ENRIQUETEST");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "ALFEREZTESTING");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
            String AmountBillsPayKPTN = reader.getBillsPayAmount();
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", AmountBillsPayKPTN);
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(15000);
        }
        waitSleep(10000);
        if(isVisible(billsPayPageObjects.billsPay_ConfiInfo(), getText(billsPayPageObjects.billsPay_ConfiInfo()))) {
            LoggingUtils.info("Bills Pay Confirmation");
            click(billsPayPageObjects.ReviewBillsPay(), "Reviewed Bills Payment Input");
            waitSleep(2000);
            click(billsPayPageObjects.ConfirmSubmitBillsPay(), "Confirm Payment");
            waitSleep(10000);
            assertEqual(getText(billsPayPageObjects.SuccessfulBillsPay()), "Bills Pay Successful");
            String kptnText = getText(billsPayPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeBillsPayGentradeKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
        }
    }
//    public void BPTransaction_GENTRADE_01()throws Exception {
//        waitSleep(5000);
//        click(billsPayPageObjects.CustomerServices(), "Customer Service");
//        click(billsPayPageObjects.BPTransactions(), "BP Partners Transactions");
//        waitSleep(3000);
//        reader.refreshTestData();
//        waitSleep(3000);
//        String BillsPayKPTN = reader.getBillsPayGentradeKPTN();
//        type(billsPayPageObjects.BPreferenceNumber(), "BP Partners Transactions Reference No",BillsPayKPTN);
//        click(billsPayPageObjects.SearchTransactions(), "Search Transactions");
//        waitSleep(5000);
//        LoggingUtils.info("The Bills Pay Partners Transactions will display.");
//    }

    public void BPSendout_GENTRADE_02()throws Exception {
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        scrollToElement(payoutPageObjects.ClickOption());
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitSleep(5000);
        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),3500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionGentrade(), "GENTRADE INTERNATIONAL PHILS. INC. Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP GENTRADE Account Number", "53300000000");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Siarot ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Enrique");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "Alferez");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "SIAROTTEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ENRIQUETEST");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "ALFEREZTESTING");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
            String AmountBillsPayKPTN = reader.getBillsPayAmount();
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", AmountBillsPayKPTN);
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(15000);
        }
        waitSleep(5000);
        if(isVisible(billsPayPageObjects.billsPay_ConfiInfo(), getText(billsPayPageObjects.billsPay_ConfiInfo()))) {
            LoggingUtils.info("Bills Pay Confirmation");
            click(billsPayPageObjects.ReviewBillsPay(), "Reviewed Bills Payment Input");
            waitSleep(2000);
            click(billsPayPageObjects.ConfirmSubmitBillsPay(), "Confirm Payment");
            waitSleep(10000);
            assertEqual(getText(billsPayPageObjects.SuccessfulBillsPay()), "Bills Pay Successful");
            String kptnText = getText(billsPayPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeBillsPayRemoteGentradeKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
            waitSleep(3000);
        }
    }
//    public void BPTransaction_GENTRADE_02()throws Exception {
//        waitSleep(5000);
//        click(billsPayPageObjects.CustomerServices(), "Customer Service");
//        click(billsPayPageObjects.BPTransactions(), "BP Partners Transactions");
//        waitSleep(3000);
//        reader.refreshTestData();
//        waitSleep(3000);
//        String RemoteBillsPayKPTN = reader.getRemoteBillsPayGentradeKPTN();
//        type(billsPayPageObjects.BPreferenceNumber(), "BP Partners Transactions Reference No",RemoteBillsPayKPTN);
//        click(billsPayPageObjects.SearchTransactions(), "Search Transactions");
//        waitSleep(5000);
//        LoggingUtils.info("The Bills Pay Partners Transactions will display.");
//    }


//B I L L S  P A Y   G E N T R A D E   C H A N G E  D E T A I L S

    public void BPChangeDetails_GENTRADE_01()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPChangeDetails());
        click(billsPayPageObjects.BPChangeDetails(), "GENTRADE Partner Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String BillsPayKPTN = reader.getBillsPayGentrade1KPTN();
            type(billsPayPageObjects.RefNum(), "GENTRADE Partner KTPN Number",BillsPayKPTN);
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))){
            //Payor Information
            scrollToElement(billsPayPageObjects.ChangePayorLastName());
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TESTSs");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629355");
            type(billsPayPageObjects.IRNum(), "IR Number", "2111114441262");
            type(billsPayPageObjects.ReasonChange(), "Reason for Change ", "TestingTest");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            click(billsPayPageObjects.YesSaveChanges(), "Yes, Save Changes");
            assertEqual(getText(billsPayPageObjects.SuccessChanges()), "Bills Pay Details Updated");
            LoggingUtils.info("Bills Pay Details Updated" +
                    "Details have been successfully updated.");
            click(billsPayPageObjects.OKTransaction(), "OK");

        }
    }
    public void BPChangeDetails_GENTRADE_02()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPChangeDetails());
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        waitSleep(5000);
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String RemoteBillsPayKPTN = reader.getRemoteBillsPayGentrade1KPTN();
            type(billsPayPageObjects.RefNum(), "KTPN Number",RemoteBillsPayKPTN);
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.PayInformation(), getText(billsPayPageObjects.PayInformation()))){
            click(billsPayPageObjects.RemoteTransaction(), "Remote Transaction");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(billsPayPageObjects.BranchCode()));

            type(billsPayPageObjects.BranchCode(), "Search Branch Code",  propertyReader.getproperty("BranchCode"));
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));

            waits.until(ExpectedConditions.elementToBeClickable(billsPayPageObjects.OperatorID()));
            type(billsPayPageObjects.OperatorID(), "Search Operator ID",  propertyReader.getproperty("OperatorID"));
            type(billsPayPageObjects.ReasonRemote(), "Reason", "Testing");
            //Payor Information

            scrollDown(100);
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TEST TEST");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING TEST");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL TEST");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629345");

            type(billsPayPageObjects.IRNum(), "IR Number", "2122214441262");
            type(billsPayPageObjects.ReasonChange(), "Reason for Change ", "TestingTest");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            click(billsPayPageObjects.YesSaveChanges(), "Yes, Save Changes");
            assertEqual(getText(billsPayPageObjects.SuccessChanges()), "Bills Pay Details Updated");
            LoggingUtils.info("Bills Pay Details Updated" +
                    "Details have been successfully updated.");
            click(billsPayPageObjects.OKTransaction(), "OK");

        }
    }

    //B I L L S  P A Y   G E N T R A D E   C A N C E L L A T I O N

    public void BPCancellation_GENTRADE_01()throws Exception{
        //Must need to cancel before/within five minutes.
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String BillsPayKPTN = reader.getBillsPayGentradeKPTN();
            type(billsPayPageObjects.RefNum(), "GENTRADE Partner KTPN Number",BillsPayKPTN);
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
            waitSleep(15000);
            assertEqual(getText(billsPayPageObjects.SuccessCancelled()), "Bills Pay Cancelled");
            LoggingUtils.info("Bills Pay Cancelled" +
                    "Payment has been successfully cancelled.");

        }

    }

    public void BPCancellation_GENTRADE_02()throws Exception{
        //Must need to cancel before/within five minutes.
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String BillsPayRemoteKPTN = reader.getRemoteBillsPayGentradeKPTN();
            type(billsPayPageObjects.RefNum(), "GENTRADE Partner KTPN Number",BillsPayRemoteKPTN);
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }

        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            click(billsPayPageObjects.RemoteTransaction(), "Remote Transaction");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(billsPayPageObjects.BranchCode()));

            type(billsPayPageObjects.BranchCode(), "Search Branch Code",  propertyReader.getproperty("BranchCode"));
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));

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
            waitSleep(15000);
            assertEqual(getText(billsPayPageObjects.SuccessCancelled()), "Bills Pay Cancelled");
            LoggingUtils.info("Bills Pay Cancelled" +
                    "Payment has been successfully cancelled.");
        }
    }


    //B I L L S  P A Y   G E N T R A D E  R E P R I N T I N G
    public void BPReprinting_GENTRADE_01()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        waitSleep(3000);
        reader.refreshTestData();
        waitSleep(3000);
        String BillsPayKPTN = reader.getBillsPayGentrade1KPTN();
        type(billsPayPageObjects.RefNum(), "Reference Number",BillsPayKPTN);
        type(billsPayPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testings");
        click(billsPayPageObjects.Reprint(), "Search Button");
        if(isVisible(billsPayPageObjects.ReprintBillsReceipt(), getText(billsPayPageObjects.ReprintBillsReceipt()))){
            LoggingUtils.info("Navigated the Bills Pay Reprint Receipt page");
            click(billsPayPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing BillsPay Receipt");

        }
    }
    public void BPReprinting_GENTRADE_02()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        waitSleep(3000);
        reader.refreshTestData();
        waitSleep(3000);
        String RemoteBillsPayKPTN = reader.getRemoteBillsPayGentrade1KPTN();
        type(billsPayPageObjects.RefNum(), "Reference Number",RemoteBillsPayKPTN);
        type(billsPayPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testings");
        click(billsPayPageObjects.Reprint(), "Search Button");
        if(isVisible(billsPayPageObjects.ReprintBillsReceipt(), getText(billsPayPageObjects.ReprintBillsReceipt()))){
            LoggingUtils.info("Navigated the Bills Pay Reprint Receipt page");
            click(billsPayPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing Remote BillsPay Receipt");

        }
    }

























    public void validateBillsPayCignalNoPartner()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        click(billsPayPageObjects.ClickOption(), "Option");
        click(billsPayPageObjects.PayorLastName(), "Option");
        assertEqual(getText(billsPayPageObjects.SelectPartners()), "Please select the partner that will receive the payment.");
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006567444");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "AGUILARTEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ANGELYTEST");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "TESTING");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "100");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            waitSleep(2000);
            LoggingUtils.info("Incorrect Payment Details, Cannot read properties of undefined (reading 'partnerId') (version: 140c9bc)");

        }
    }
    public void validateBillsPayCignalNoAccNum()throws Exception {
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        assertEqual(getText(billsPayPageObjects.EmptyAccount()), "Account number is a required field");

    }
    public void validateBillsPayCignalEmptyLName()throws Exception {
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyLastname()), "Account last name is a required field");
        }

    }
    public void validateBillsPayCignalEmptyFName()throws Exception {
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "TESTING");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyFirstname()), "Account first name is a required field");
        }

    }
    public void validateBillsPayCignalNoEntity()throws Exception {
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006567444");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "SIAROTTEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ENRIQUETEST");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "ALFEREZTESTING");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
            String AmountBillsPayKPTN = reader.getBillsPayAmount();
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", AmountBillsPayKPTN);
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            waitSleep(5000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(15000);
            assertEqual(getText(billsPayPageObjects.InvalidAccountNum()), "Incorrect Payment Details");
            LoggingUtils.info("Incorrect Payment Details\n" +
                    "Please provide the external entity name. (version: ee39e51)");
        }
    }
    public void validateBillsPayCignalNoOtherInfo()throws Exception {
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006567444");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
        type(billsPayPageObjects.BPOtherLname(), "Last Name", "");
        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "SIAROTTEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ENRIQUETEST");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "ALFEREZTESTING");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
            String AmountBillsPayKPTN = reader.getBillsPayAmount();
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", AmountBillsPayKPTN);
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(2000);
            LoggingUtils.info("Please Fill out this fields Empty lastname");
            billsPayPageObjects.BPOtherLname().clear();
            type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
            billsPayPageObjects.BPOtherFname().clear();
            type(billsPayPageObjects.BPOtherFname(), "First Name", "");
            type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");
            waitSleep(2000);
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            LoggingUtils.info("Please Fill out this fields Empty firstname");
            type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
            billsPayPageObjects.BPOtherFname().clear();
            type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
            billsPayPageObjects.BPOtherMInitial().clear();
            type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "");
            waitSleep(2000);
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            LoggingUtils.info("Please Fill out this fields Empty Initial name");
        }
    }
    public void validateBillsPayCignalEmptyPayorLname()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006567444");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
        type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "enrique");
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyLPayor()), "Payor last name is a required field");
        }
    }
    public void validateBillsPayCignalEmptyPayorFname()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006567444");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
        type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "cebu");
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyFPayor()), "Payor first name is a required field");
        }
    }
    public void validateBillsPayCignalEmptyPayorAddress()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006567444");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
        type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09657865477");
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyAddress()), "Payor address is a required field");
        }
    }
    public void validateBillsPayCignalEmptyPayorContact()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(2000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006567444");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
        type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "90");
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyContact()), "Payor contact number is a required field");
        }
    }
    public void validateBillsPayCignalZeroAndEmptyAmount()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(6000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006567444");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
        type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", " ");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            assertEqual(getText(billsPayPageObjects.EmptyAmount()), "Payment amount must have a valid value");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "0");
            assertEqual(getText(billsPayPageObjects.ZeroAmount()), "Minimum amount is 1");
        }

    }
    public void validateBillsPayCignalInvalidAccNum()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(6000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "900656744456");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
        type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "AGUILARTEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ANGELYTEST");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "TESTING");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "100");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            waitSleep(5000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(15000);
            assertEqual(getText(billsPayPageObjects.InvalidAccountNum()), "Incorrect Payment Details");
            LoggingUtils.info("Incorrect Payment Details\n" +
                    "The account number must be 10 digits. (version: 140c9bc)");
        }
    }
    public void validateBillsPayCignalFourDigAccNum()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(8000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
        type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "AGUILARTEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ANGELYTEST");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "TESTING");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "100");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            waitSleep(5000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(15000);
            assertEqual(getText(billsPayPageObjects.IncorrectPayment()), "Incorrect Payment Details");
            LoggingUtils.info("Incorrect Payment Details\n" +
                    "The account number must be 10 digits. (version: 140c9bc)");
        }
    }
    public void validateBillsPayCignalInvalidAmount()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(2000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006567444");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
        type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "AGUILARTEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ANGELYTEST");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "TESTING");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "19");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(5000);
            assertEqual(getText(billsPayPageObjects.InvalidAccountNum()), "Incorrect Payment Details");
            LoggingUtils.info("The minimum amount for payments must be at least Php20.00. Please enter a higher amount.");
        }
    }
    public void validateBillsPayCignalInvalidContactNum()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(6000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006567444");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
        type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "08635129781");
            waitSleep(2000);
            click(billsPayPageObjects.PaymentAmount(), "Payment Amount");
            assertEqual(getText(billsPayPageObjects.InvalidContact()), "Must start with 639|09|9 followed by 9 digits.");
            LoggingUtils.info("Must start with 639|09|9 followed by 9 digits.");
        }
    }
    public void validateBillsPayCignalMaxAmountNum()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(6000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006567444");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
        type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "AGUILARTEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ANGELYTEST");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "TESTING");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "500000");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            waitSleep(5000);
            LoggingUtils.info("Maximum allowed amount is PHP 50,000.00. (version: aa833cf)");
        }
    }

}
