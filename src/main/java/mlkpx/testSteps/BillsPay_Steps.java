package mlkpx.testSteps;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import utilities.Logger.LoggingUtils;

import static utilities.Driver.DriverManager.getDriver;


public class BillsPay_Steps extends Base_Steps{
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

    //B I L L S  P A Y    S E N D O U T
    public void validateSuccessfulBillsPayTransaction()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");
        waitSleep(8000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(billsPayPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Account Number", "62725870");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "AGUILARTEST");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ANGELYTEST");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "TESTING");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "AGUILARTEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ANGELYTEST");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "TESTING");
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
            reader.writeBillsPayKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
        }
    }
    public void validateDuplicateBillsPayTransaction()throws Exception {
        //(Note: the duplicate transaction in 90 seconds)
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");
        waitSleep(8000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(billsPayPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Account Number", "62725870");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "AGUILARTEST");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ANGELYTEST");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "TESTING");

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
        }
        if(isVisible(billsPayPageObjects.billsPay_ConfiInfo(), getText(billsPayPageObjects.billsPay_ConfiInfo()))) {
            LoggingUtils.info("Bills Pay Confirmation");
            click(billsPayPageObjects.ReviewBillsPay(), "Reviewed Bills Payment Input");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.ConfirmSubmitBillsPay());
            click(billsPayPageObjects.ConfirmSubmitBillsPay(), "Confirm Payment");
            waitSleep(5000);
            assertEqual(getText(billsPayPageObjects.DuplicateBillsPay()), "Duplicate Bills Payment");
            click(billsPayPageObjects.OKCom(), "Click OK");
        }
    }
    public void validateSuccessfulRemoteBillsPayTransaction()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.RemoteTransaction(), "Remote Transaction");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(billsPayPageObjects.BranchCode()));
        //todo
        type(billsPayPageObjects.BranchCode(), "Search Branch Code",  propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

        waits.until(ExpectedConditions.elementToBeClickable(billsPayPageObjects.OperatorID()));
        type(billsPayPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(billsPayPageObjects.ReasonRemote(), "Reason", "Testing");
        waitSleep(8000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(billsPayPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Account Number", "62725870");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "AGUILARTEST");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ANGELYTEST");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "TESTING");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "AGUILARTEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ANGELYTEST");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "TESTING");
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
        waitSleep(15000);
        if(isVisible(billsPayPageObjects.billsPay_ConfiInfo(), getText(billsPayPageObjects.billsPay_ConfiInfo()))) {
            LoggingUtils.info("Bills Pay Confirmation");
            click(billsPayPageObjects.ReviewBillsPay(), "Reviewed Bills Payment Input");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.ConfirmSubmitBillsPay());
            click(billsPayPageObjects.ConfirmSubmitBillsPay(), "Confirm Payment");
            waitSleep(15000);
            assertEqual(getText(billsPayPageObjects.SuccessfulBillsPay()), "Bills Pay Successful");
            String kptnText = getText(billsPayPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeRemoteBillsPayKptnData(kptnValues);
            LoggingUtils.info("Remote Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");

        }
    }
    public void validateEmptyPartnerBillsPay()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");

        type(billsPayPageObjects.BPAccNum(), "BP Account Number", "62725870");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "AGUILARTEST");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ANGELYTEST");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "TESTING");

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
    public void validateEmptyAccountNumBillsPay()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");
        waitSleep(5000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(billsPayPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Account Number", "");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "AGUILARTEST");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ANGELYTEST");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "TESTING");

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
    public void validateEmptyLastnameBillsPay()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "");
        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            assertEqual(getText(billsPayPageObjects.EmptyLastname()), "Account last name is a required field");
        }

    }
    public void validateEmptyFirstnameBillsPay()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");
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
    public void validateEmptyLastnamePayor()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            assertEqual(getText(billsPayPageObjects.EmptyLPayor()), "Payor last name is a required field");
        }

    }
    public void validateEmptyFirstnamePayor()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");

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
    public void validateEmptyAddressPayor()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            assertEqual(getText(billsPayPageObjects.EmptyAddress()), "Payor address is a required field");
        }

    }
    public void validateEmptyContactPayor()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            assertEqual(getText(billsPayPageObjects.EmptyContact()), "Payor contact number is a required field");
        }

    }
    public void validateInvalidAmount()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){

            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", " ");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            assertEqual(getText(billsPayPageObjects.EmptyAmount()), "Payment amount must have a valid value");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "0");
            assertEqual(getText(billsPayPageObjects.ZeroAmount()), "Minimum amount is 1");
        }
    }
    public void validateInvalidAccountNumTransaction()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");
        waitSleep(5000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(billsPayPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Account Number", "62725812");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "AGUILARTEST");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ANGELYTEST");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "TESTING");

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
                    "The account number provided is invalid. Please try entering this again. (version: f6ec269)");
        }
    }
    public void validateInvalidFourNumTransaction()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");
        waitSleep(5000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(billsPayPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Account Number", "6272");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "AGUILARTEST");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ANGELYTEST");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "TESTING");

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
    public void validateBelow20AmountTransaction()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");
        waitSleep(5000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(billsPayPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Account Number", "62725870");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "AGUILARTEST");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ANGELYTEST");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "TESTING");

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
    public void validateInvalidContactBillsPay()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");

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
    public void validateMaxAmountTransaction()throws Exception {
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPSendout());
        click(billsPayPageObjects.BPSendout(), "Bills Pay Sendout Transaction");
        click(billsPayPageObjects.NoRemoteTransaction(), "No remote Transaction");
        waitSleep(5000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(billsPayPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Account Number", "62725870");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "AGUILARTEST");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ANGELYTEST");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "TESTING");

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
