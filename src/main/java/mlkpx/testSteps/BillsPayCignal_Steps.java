package mlkpx.testSteps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class BillsPayCignal_Steps extends Base_Steps{
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
    //B I L L S  P A Y   C I G N A L   S E N D O U T
    public void validateSuccessfulBillsPayCignal()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(8000);
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
        waitSleep(20000);
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
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
            reader.writeBillsPayCignalKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
        }
    }
    public void validateSuccessfulRemoteBillsPayCignal()throws Exception {
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        // scrollToElement(billsPayPageObjects.BPSendout());
//        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
//        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");
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
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(2000);
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
        waitSleep(20000);
        scrollToElement(billsPayPageObjects.Click2Option());
        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
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
            reader.writeBillsPayRemoteCignalKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
            waitSleep(3000);
        }
    }
    public void validateBillsPayCignalNoPartner()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(5000);
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
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            assertEqual(getText(billsPayPageObjects.SelectPartners()), "Please select the partner that will receive the payment.");
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
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            assertEqual(getText(billsPayPageObjects.EmptyAccount()), "Account number is a required field");
        }
    }
    public void validateBillsPayCignalEmptyLName()throws Exception {
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "");
        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
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
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
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
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(5000);
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
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
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
//            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "AGUILARTEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
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
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
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
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
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
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "90067444");
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
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(10000);
            assertEqual(getText(billsPayPageObjects.InvalidAccountNum()), "Incorrect Payment Details");
            LoggingUtils.info("Incorrect Payment Details" +
                    "The account number provided is invalid. Please try entering this again. (version: f6ec269)");
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
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(5000);
            assertEqual(getText(billsPayPageObjects.InvalidAccountNum()), "Incorrect Payment Details");
            LoggingUtils.info("Incorrect Payment Details" +
                    "The account number must be 8 digits. (version: f6ec269)");
        }
    }
//    public void validateBillsPayCignalInvalidAmount()throws Exception {
//        waitSleep(2000);
//        waitUntilLoadingGone(10000);
//        waitSleep(6000);
//        waitUntilLoadingGone(10000);
//        scrollToElement(billsPayPageObjects.ClickOption());
//        waitSleep(2000);
//        click(billsPayPageObjects.ClickOption(), "Option");
//        waitSleep(3000);
//        waitUntilLoadingGone(10000);
//        scrollToElement(billsPayPageObjects.ChooseOptionCignal());
//        click(billsPayPageObjects.ChooseOptionCignal(), "Cignal Partner");
//        waitUntilLoadingGone(10000);
//        waitSleep(5000);
//        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "9006567444");
//        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT");
//        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
//        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
//        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
//        waitUntilLoadingGone(10000);
//        click(billsPayPageObjects.Click2Option(), "Select Entity Code ");
//        click(billsPayPageObjects.ChooseEntityCode(), "Entity Code ");
//        type(billsPayPageObjects.BPOtherLname(), "Last Name", "SIAROT");
//        type(billsPayPageObjects.BPOtherFname(), "First Name", "Enrique");
//        type(billsPayPageObjects.BPOtherMInitial(), "Middle Initial", "A");
//
//        //Payor Information
//        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
//            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "AGUILARTEST");
//            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ANGELYTEST");
//            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "TESTING");
//            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
//            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
//            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "19");
//            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
//            waitSleep(2000);
//            scrollToElement(billsPayPageObjects.SubmitBillsPay());
//            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
//            waitSleep(5000);
//            assertEqual(getText(billsPayPageObjects.InvalidAccountNum()), "Incorrect Payment Details");
//            LoggingUtils.info("The minimum amount for payments must be at least Php20.00. Please enter a higher amount.");
//        }
//    }
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
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
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
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(5000);
            assertEqual(getText(billsPayPageObjects.InvalidAccountNum()), "Incorrect Payment Details");
            LoggingUtils.info("The maximum amount for payments is Php100,000.00. Please enter a lower amount.");
        }
    }

}
