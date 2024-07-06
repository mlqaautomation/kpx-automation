package mlkpx.testSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class BillsPayFlashpay_Steps extends Base_Steps{
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
    //B I L L S  P A Y   F L A S H P A Y   S E N D O U T
    public void validateSuccessfulBillsPayNORDECO()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionNordeco(), "NORTHERN DAVAO ELECTRIC COOPERATIVE (NORDECO) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "P691575261");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);


        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "SIAROT");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ENRIQUE");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "ALFEREZ");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
            String AmountBillsPayKPTN = reader.getBillsPayAmount();
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", AmountBillsPayKPTN);
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "For Bills");
            waitSleep(10000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            waitSleep(5000);
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(5000);
        }
        waitSleep(5000);
        if(isVisible(billsPayPageObjects.billsPay_ConfiInfo(), getText(billsPayPageObjects.billsPay_ConfiInfo()))) {
            LoggingUtils.info("Bills Pay Confirmation");
            click(billsPayPageObjects.ReviewBillsPay(), "Reviewed Bills Payment Input");
            waitSleep(2000);
            click(billsPayPageObjects.ConfirmSubmitBillsPay(), "Confirm Payment");
            waitSleep(15000);
            waitUntilLoadingGone(20000);
            assertEqual(getText(billsPayPageObjects.SuccessfulBillsPay()), "Bills Pay Successful");
            String kptnText = getText(billsPayPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeBillsPayNordecoKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
            waitSleep(3000);
        }
    }
    public void validateSuccessfulRemoteBillsPayNORDECO()throws Exception {
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
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        click(billsPayPageObjects.ChooseOptionNordeco(), "NORTHERN DAVAO ELECTRIC COOPERATIVE (NORDECO) Partner");
        waitUntilLoadingGone(10000);

        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "P691575261");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
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
            waitSleep(15000);
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
            waitSleep(15000);
            waitUntilLoadingGone(10000);
            assertEqual(getText(billsPayPageObjects.SuccessfulBillsPay()), "Bills Pay Successful");
            String kptnText = getText(billsPayPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeBillsPayRemoteNordecoKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
            waitSleep(3000);
        }
    }
    public void validateBillsPayNORDECONoPartner()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        click(billsPayPageObjects.ClickOption(), "Option");
        click(billsPayPageObjects.PayorLastName(), "Option");
        assertEqual(getText(billsPayPageObjects.SelectPartners()), "Please select the partner that will receive the payment.");
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "P691575261");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
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
            waitSleep(15000);
            LoggingUtils.info("Incorrect Payment Details\n" +"Cannot read properties of undefined (reading 'partnerId') (version: 140c9bc)");

        }
    }
    public void validateBillsPayNORDECONoAccNumLnameFname()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionNordeco(), "NORTHERN DAVAO ELECTRIC COOPERATIVE (NORDECO) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        assertEqual(getText(billsPayPageObjects.EmptyAccount()), "Account number is a required field");

        waitSleep(3000);
        billsPayPageObjects.BPAccNum().clear();
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "P691575261");
        billsPayPageObjects.BPLastName().clear();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "");
        billsPayPageObjects.BPFirstName().clear();
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        billsPayPageObjects.BPMiddleName().clear();
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        billsPayPageObjects.BPOwnContactNum().clear();
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitSleep(2000);
        assertEqual(getText(billsPayPageObjects.EmptyLastname()), "Account last name is a required field");

        waitSleep(3000);
        billsPayPageObjects.BPAccNum().clear();
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "P691575261");
        billsPayPageObjects.BPLastName().clear();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        billsPayPageObjects.BPFirstName().clear();
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "");
        billsPayPageObjects.BPMiddleName().clear();
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        billsPayPageObjects.BPOwnContactNum().clear();
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        assertEqual(getText(billsPayPageObjects.EmptyFirstname()), "Account first name is a required field");


    }
    public void validateBillsPayNORDECOEmptyPayorLname()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionNordeco(), "NORTHERN DAVAO ELECTRIC COOPERATIVE (NORDECO) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "P691575261");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "test");
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyLPayor()), "Payor last name is a required field");
        }
    }
    public void validateBillsPayNORDECOEmptyPayorFname()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionNordeco(), "NORTHERN DAVAO ELECTRIC COOPERATIVE (NORDECO) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "P691575261");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "cebu");
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyFPayor()), "Payor first name is a required field");

        }
    }
    public void validateBillsPayNORDECOEmptyPayorAddress()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionNordeco(), "NORTHERN DAVAO ELECTRIC COOPERATIVE (NORDECO) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "P691575261");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09657865477");
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyAddress()), "Payor address is a required field");
        }
    }
    public void validateBillsPayNORDECOEmptyPayorContact()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionNordeco(), "NORTHERN DAVAO ELECTRIC COOPERATIVE (NORDECO) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "P691575261");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "90");
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyContact()), "Payor contact number is a required field");

        }
    }
    public void validateBillsPayNORDECOZeroAndEmptyAmount()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionNordeco(), "NORTHERN DAVAO ELECTRIC COOPERATIVE (NORDECO) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "P691575261");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", " ");
            click(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number");
            assertEqual(getText(billsPayPageObjects.EmptyAmount()), "Payment amount must have a valid value");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "0");
            click(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number");
            assertEqual(getText(billsPayPageObjects.ZeroAmount()), "Minimum amount is 1");
        }

    }
    public void validateBillsPayNORDECOInvalidAccNum()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionNordeco(), "NORTHERN DAVAO ELECTRIC COOPERATIVE (NORDECO) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "P6915752661");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

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
            assertEqual(getText(billsPayPageObjects.IncorrectPayment()), "Incorrect Payment Details");
            LoggingUtils.info("Incorrect Payment Details\n" + "Invalid customer account number (code 1154) (version: 140c9bc)");
        }
    }
    public void validateBillsPayNORDECOFourDigAccNum()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionNordeco(), "NORTHERN DAVAO ELECTRIC COOPERATIVE (NORDECO) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "P691575261566");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

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
            assertEqual(getText(billsPayPageObjects.IncorrectPayment()), "Incorrect Payment Details");
            LoggingUtils.info("Incorrect Payment Details\n" +"Invalid customer account number (code 1154) (version: 140c9bc)");
        }
    }
    public void validateBillsPayNORDECOInvalidContactNum()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(10000);
        click(billsPayPageObjects.ChooseOptionNordeco(), "NORTHERN DAVAO ELECTRIC COOPERATIVE (NORDECO) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "P691575261");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "08635129781");
            waitSleep(2000);
            click(billsPayPageObjects.PaymentAmount(), "Payment Amount");
            assertEqual(getText(billsPayPageObjects.InvalidContact()), "Must start with 639|09|9 followed by 9 digits.");
            LoggingUtils.info("Must start with 639|09|9 followed by 9 digits.");
        }
    }
    public void validateBillsPayNORDECOMaxAmountNum()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionNordeco(), "NORTHERN DAVAO ELECTRIC COOPERATIVE (NORDECO) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "P691575261");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "LAPASA ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "VENANCIO");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

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



    public void validateBillsPayFLASHPAYNegativeTestAlreadyPaid()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionFlashpay(), "(FLASHPAY) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "240690628590");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09274067010");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "QA TEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "TESTING");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "A");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "5566.77");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Negative testing in Flashpay");
            waitSleep(5000);
            assertEqual(getText(billsPayPageObjects.IncorrectPayment()), "Incorrect Payment Details");
            LoggingUtils.info("Incorrect Payment Details, Payment has already been paid. (code 1199) (version: N/A)");

        }
    }
    public void validateBillsPayFLASHPAYSecondNegativeTestAlreadyPaid()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionFlashpay(), "(FLASHPAY) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "240639719899");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09274067010");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "QA TEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "TESTING");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "A");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");

            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "8971.23");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Negative testing in Flashpay");
            waitSleep(5000);
            assertEqual(getText(billsPayPageObjects.IncorrectPayment()), "Incorrect Payment Details");
            LoggingUtils.info("Incorrect Payment Details, Payment has already been paid. (code 1199) (version: N/A)");

        }
    }
    public void validateBillsPayFLASHPAYNegativeTestWithoutPhoneNumber()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionFlashpay(), "(FLASHPAY) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP NORDECO Account Number", "240691903481");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "SIAROT ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "ENRIQUE");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "QA TEST");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "TESTING");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "A");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");

            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "66778.81");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Negative testing in Flashpay");
            waitSleep(5000);
//            assertEqual(getText(billsPayPageObjects.MaxAmount()), "Maximum allowed amount is PHP 50,000.00. (version: N/A)");
            LoggingUtils.info("Maximum allowed amount is PHP 50,000.00. (version: N/A)");
            waitSleep(20000);
        }
    }

}
