package mlkpx.testSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class BillsPayCENTROESCOLAR_Steps extends Base_Steps{
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
    //B I L L S  P A Y   C E N T R O  E S C O L A R  U N I   S E N D O U T
    public void BPSendout_CENTROESCOLAR_01()throws Exception {
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(5000);
        click(billsPayPageObjects.ClickOption(), "Option");
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),3500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionZCWATERDISTRICT(), "CENTRO ESCOLAR UNIVERSITY-MANILA Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP CENTRO ESCOLAR UNIVERSITY-MANILA Account Number", "2170406");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "TEST");
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
            reader.writeBillsPayCENTROESCOLARKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
        }
    }


    public void BPSendout_CENTROESCOLAR_02()throws Exception {
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
        click(billsPayPageObjects.ChooseOptionZCWATERDISTRICT(), "CENTRO ESCOLAR UNIVERSITY-MANILA Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP CENTRO ESCOLAR UNIVERSITY-MANILA Account Number", "2170406");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "TEST");
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
            reader.writeBillsPayRemoteCENTROESCOLARKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
            waitSleep(3000);
        }
    }



//B I L L S  P A Y    C E N T R O  E S C O L A R  U N I   C H A N G E  D E T A I L S

    public void BPChangeDetails_CENTROESCOLAR_01()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPChangeDetails());
        click(billsPayPageObjects.BPChangeDetails(), "CENTRO ESCOLAR UNIVERSITY-MANILA Partner Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String BillsPayKPTN = reader.getBillsPayCENTROESCOLAR1KPTN();
            type(billsPayPageObjects.RefNum(), "CENTRO ESCOLAR UNIVERSITY-MANILA Partner KTPN Number",BillsPayKPTN);
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
    public void BPChangeDetails_CENTROESCOLAR_02()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPChangeDetails());
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay CENTRO ESCOLAR UNIVERSITY-MANILA Change Details");
        waitSleep(5000);
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String RemoteBillsPayKPTN = reader.getRemoteBillsPayCENTROESCOLAR1KPTN();
            type(billsPayPageObjects.RefNum(), "CENTRO ESCOLAR UNIVERSITY-MANILA KTPN Number",RemoteBillsPayKPTN);
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

    //B I L L S  P A Y   C E N T R O  E S C O L A R  U N I   C A N C E L L A T I O N

    public void BPCancellation_CENTROESCOLAR_01()throws Exception{
        //Must need to cancel before/within five minutes.
        waitSleep(20000);
        scrollToElement(billsPayPageObjects.BPCancellation());
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String BillsPayKPTN = reader.getBillsPayCENTROESCOLARKPTN();
            type(billsPayPageObjects.RefNum(), "CENTRO ESCOLAR UNIVERSITY-MANILA Partner KTPN Number",BillsPayKPTN);
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))){
            type(billsPayPageObjects.IRNum(), "CENTRO ESCOLAR UNIVERSITY-MANILA KTPN Number", "2111111111262");
            type(billsPayPageObjects.ReasonCancel(), "Reason for Cancellation ", "Testing");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.CancelPayment());
            click(billsPayPageObjects.CancelPayment(), "Cancel Payment");
            click(billsPayPageObjects.YesCancelPayment(), "Yes, Cancel Payment");
            assertEqual(getText(billsPayPageObjects.SuccessCancelled()), "Bills Pay Cancelled");
            LoggingUtils.info("Bills Pay Cancelled" +
                    "Payment has been successfully cancelled.");
            waitSleep(8000);

        }
    }

    public void BPCancellation_CENTROESCOLAR_02()throws Exception{
        //Must need to cancel before/within five minutes.
        waitSleep(20000);
        click(billsPayPageObjects.BPCancellation(), "Bills Pay Remote Cancellation Transaction");
        if(isVisible(billsPayPageObjects.BillsPayText(), getText(billsPayPageObjects.BillsPayText()))) {
            LoggingUtils.info("Navigated the BillsPay Cancellation page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String BillsPayRemoteKPTN = reader.getRemoteBillsPayCENTROESCOLARKPTN();
            type(billsPayPageObjects.RefNum(), "CENTRO ESCOLAR UNIVERSITY-MANILA Partner KTPN Number",BillsPayRemoteKPTN);
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
            assertEqual(getText(billsPayPageObjects.SuccessCancelled()), "Bills Pay Cancelled");
            LoggingUtils.info("Bills Pay Cancelled" +
                    "Payment has been successfully cancelled.");
            waitSleep(8000);
        }
    }


    //B I L L S  P A Y   C E N T R O  E S C O L A R  U N I   R E P R I N T I N G
    public void BPReprinting_CENTROESCOLAR_01()throws Exception{
        waitSleep(10000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        waitSleep(3000);
        reader.refreshTestData();
        waitSleep(3000);
        String BillsPayKPTN = reader.getBillsPayCENTROESCOLAR1KPTN();
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
    public void BPReprinting_CENTROESCOLAR_02()throws Exception{
        waitSleep(10000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        waitSleep(3000);
        reader.refreshTestData();
        waitSleep(3000);
        String RemoteBillsPayKPTN = reader.getRemoteBillsPayCENTROESCOLAR1KPTN();
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

}
