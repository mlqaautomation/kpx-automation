package mlkpx.testSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class BillsPayCEBECOIII_Steps extends Base_Steps{
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
    //B I L L S  P A Y   C E B E C O  III   S E N D O U T
    public void validateSuccessfulBillsPayCEBECOIII()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionCebeco(), "CEBU III ELECTRIC COOPERATIVE (CEBECO III) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A000600P");
        String[] randomName = reader.getRandomName();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", randomName[1]);
        type(billsPayPageObjects.BPFirstName(), "BP First Name", randomName[0]);
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);


        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "Sample");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "Test");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "W");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
//            String AmountBillsPayKPTN = reader.getBillsPayAmount();
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "26303.86");
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
            waitUntilLoadingGone(10000);
            assertEqual(getText(billsPayPageObjects.SuccessfulBillsPay()), "Bills Pay Successful");
            String kptnText = getText(billsPayPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeBillsPayCEBECOKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
            waitSleep(3000);
        }
    }
    public void validateSuccessfulRemoteBillsPayCEBECOIII()throws Exception {
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
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionCebeco(), "CEBU III ELECTRIC COOPERATIVE (CEBECO III) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A009789C");
        String[] randomName = reader.getRandomName();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", randomName[1]);
        type(billsPayPageObjects.BPFirstName(), "BP First Name", randomName[0]);
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);


        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "Sample");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "Test");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "W");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
//            String AmountBillsPayKPTN = reader.getBillsPayAmount();
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "4223.07");
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
            waitUntilLoadingGone(10000);
            assertEqual(getText(billsPayPageObjects.SuccessfulBillsPay()), "Bills Pay Successful");
            String kptnText = getText(billsPayPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeBillsPayRemoteCEBECOKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
            waitSleep(3000);
        }
    }
    public void validateBillsPayCEBECOIIINoPartner()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A000600P");
        String[] randomName = reader.getRandomName();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", randomName[1]);
        type(billsPayPageObjects.BPFirstName(), "BP First Name", randomName[0]);
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
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
            assertEqual(getText(billsPayPageObjects.SelectPartners()), "Please select the partner that will receive the payment.");
        }
    }
    public void validateBillsPayCEBECOIIINoAccNumLnameFname()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionCebeco(), "CEBU III ELECTRIC COOPERATIVE (CEBECO III) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Monte");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Sarah");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        waitSleep(2000);
        scrollToElement(billsPayPageObjects.SubmitBillsPay());
        click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
        assertEqual(getText(billsPayPageObjects.EmptyAccount()), "Account number is a required field");

        waitSleep(3000);
        billsPayPageObjects.BPAccNum().clear();
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A000600P");
        billsPayPageObjects.BPLastName().clear();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "");
        billsPayPageObjects.BPFirstName().clear();
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Sarah");
        billsPayPageObjects.BPMiddleName().clear();
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        billsPayPageObjects.BPOwnContactNum().clear();
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        waitSleep(2000);
        scrollToElement(billsPayPageObjects.SubmitBillsPay());
        click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
        assertEqual(getText(billsPayPageObjects.EmptyLastname()), "Account last name is a required field");

        waitSleep(3000);
        billsPayPageObjects.BPAccNum().clear();
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A000600P");
        billsPayPageObjects.BPLastName().clear();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Monte");
        billsPayPageObjects.BPFirstName().clear();
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "");
        billsPayPageObjects.BPMiddleName().clear();
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        billsPayPageObjects.BPOwnContactNum().clear();
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        //Payor Information
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.SubmitBillsPay());
        click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
        assertEqual(getText(billsPayPageObjects.EmptyFirstname()), "Account first name is a required field");


    }
    public void validateBillsPayCEBECOIIIEmptyPayorLname()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionCebeco(), "CEBU III ELECTRIC COOPERATIVE (CEBECO III) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A000600P");
        String[] randomName = reader.getRandomName();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", randomName[1]);
        type(billsPayPageObjects.BPFirstName(), "BP First Name", randomName[0]);
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            assertEqual(getText(billsPayPageObjects.EmptyLPayor()), "Payor last name is a required field");
        }
    }
    public void validateBillsPayCEBECOIIIEmptyPayorFname()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionCebeco(), "CEBU III ELECTRIC COOPERATIVE (CEBECO III) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A000600P");
        String[] randomName = reader.getRandomName();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", randomName[1]);
        type(billsPayPageObjects.BPFirstName(), "BP First Name", randomName[0]);
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            assertEqual(getText(billsPayPageObjects.EmptyFPayor()), "Payor first name is a required field");
        }
    }
    public void validateBillsPayCEBECOIIIEmptyPayorAddress()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionCebeco(), "CEBU III ELECTRIC COOPERATIVE (CEBECO III) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A000600P");
        String[] randomName = reader.getRandomName();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", randomName[1]);
        type(billsPayPageObjects.BPFirstName(), "BP First Name", randomName[0]);
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            assertEqual(getText(billsPayPageObjects.EmptyAddress()), "Payor address is a required field");
        }
    }
    public void validateBillsPayCEBECOIIIEmptyPayorContact()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionCebeco(), "CEBU III ELECTRIC COOPERATIVE (CEBECO III) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A000600P");
        String[] randomName = reader.getRandomName();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", randomName[1]);
        type(billsPayPageObjects.BPFirstName(), "BP First Name", randomName[0]);
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "");
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            assertEqual(getText(billsPayPageObjects.EmptyContact()), "Payor contact number is a required field");
        }
    }
    public void validateBillsPayCEBECOIIIZeroAndEmptyAmount()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionCebeco(), "CEBU III ELECTRIC COOPERATIVE (CEBECO III) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A000600P");
        String[] randomName = reader.getRandomName();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", randomName[1]);
        type(billsPayPageObjects.BPFirstName(), "BP First Name", randomName[0]);
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", " ");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            assertEqual(getText(billsPayPageObjects.EmptyAmount()), "Payment amount must have a valid value");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "0");
            assertEqual(getText(billsPayPageObjects.ZeroAmount()), "Minimum amount is 1");
        }

    }
    public void validateBillsPayCEBECOIIIInvalidAccNum()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionCebeco(), "CEBU III ELECTRIC COOPERATIVE (CEBECO III) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A000600P464");
        String[] randomName = reader.getRandomName();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", randomName[1]);
        type(billsPayPageObjects.BPFirstName(), "BP First Name", randomName[0]);
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
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
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(10000);
            LoggingUtils.info("Bills Pay Confirmation");
            click(billsPayPageObjects.ReviewBillsPay(), "Reviewed Bills Payment Input");
            waitSleep(2000);
            click(billsPayPageObjects.ConfirmSubmitBillsPay(), "Confirm Payment");
            waitSleep(15000);
            assertEqual(getText(billsPayPageObjects.InvalidAccountNumNordeco()), "Payment Failed");
            LoggingUtils.info("Payment Failed\n" +
                    "Invalid customer account number (code 1154) (version: aa833cf)");
        }
    }
    public void validateBillsPayCEBECOIIIFourDigAccNum()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionCebeco(), "CEBU III ELECTRIC COOPERATIVE (CEBECO III) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A000600657547567P");
        String[] randomName = reader.getRandomName();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", randomName[1]);
        type(billsPayPageObjects.BPFirstName(), "BP First Name", randomName[0]);
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
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
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(10000);
            LoggingUtils.info("Bills Pay Confirmation");
            click(billsPayPageObjects.ReviewBillsPay(), "Reviewed Bills Payment Input");
            waitSleep(2000);
            click(billsPayPageObjects.ConfirmSubmitBillsPay(), "Confirm Payment");
            waitSleep(5000);
            assertEqual(getText(billsPayPageObjects.InvalidAccountNumNordeco()), "Payment Failed");
            LoggingUtils.info("Payment Failed\n" +
                    "Invalid customer account number (code 1154) (version: aa833cf)");
        }
    }
    public void validateBillsPayCEBECOIIIInvalidContactNum()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(10000);
        click(billsPayPageObjects.ChooseOptionCebeco(), "CEBU III ELECTRIC COOPERATIVE (CEBECO III) Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP (CEBECO III) Account Number", "A000600P");
        String[] randomName = reader.getRandomName();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", randomName[1]);
        type(billsPayPageObjects.BPFirstName(), "BP First Name", randomName[0]);
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "A");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);

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
    public void validateBillsPayCEBECOIIIMaxAmountNum()throws Exception {
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
}
