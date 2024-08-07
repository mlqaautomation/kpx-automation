package mlkpx.testSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class BillsPayPagbig_Steps extends Base_Steps{
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
    //B I L L S  P A Y   P A G - I B I G   S E N D O U T
    public void validateSuccessfulBillsPayPagibig()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "721282F35988");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay ");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(billsPayPageObjects.Click2Option(), "Click Transaction Type");
        click(billsPayPageObjects.TransactionType(), "Transaction Type");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "SIAROT");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ENRIQUE");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "ALFEREZ");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
//            String AmountBillsPayKPTN = reader.getBillsPayAmount();
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "1000");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "For Bills");
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            waitSleep(10000);
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(10000);
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
            reader.writeBillsPayPagibigKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
            waitSleep(3000);
        }
    }
    public void validateSuccessfulRemoteBillsPayPagibig()throws Exception {
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
        click(billsPayPageObjects.ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "721282F35987");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Marjorie");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Santacera");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(billsPayPageObjects.Click2Option(), "Click Transaction Type");
        click(billsPayPageObjects.TransactionType(), "Transaction Type");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "SIAROT");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "ENRIQUE");
            type(billsPayPageObjects.PayorMiddleName(), "Payor Middle Name", "ALFEREZ");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09635129781");
//            String AmountBillsPayKPTN = reader.getBillsPayAmount();
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "1000");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "For Bills");
            scrollToElement(billsPayPageObjects.SubmitBillsPay());
            waitSleep(10000);
            click(billsPayPageObjects.SubmitBillsPay(), "Submit Bills Pay Button");
            waitSleep(10000);
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
            reader.writeBillsPayRemotePagibigKptnData(kptnValues);
            LoggingUtils.info("Bills Pay Successful" +
                    "The payment was successfully created." +
                    "Please prepare printer to print document.");
            click(billsPayPageObjects.proceedToPrinting(), "Proceed to Printing");
            waitSleep(2000);
            click(billsPayPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
            waitSleep(3000);
        }
    }
    public void validateBillsPayPagibigNoPartner()throws Exception {
        waitSleep(2000);
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "721282F35988");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");

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
            LoggingUtils.info("Incorrect Payment Details\n" +"Cannot read properties of undefined (reading 'partnerId') (version: 140c9bc)");
 }
    }
    public void validateBillsPayPagibigNoAccNumLnameFname()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitSleep(2000);
        assertEqual(getText(billsPayPageObjects.EmptyAccount()), "Account number is a required field");

        waitSleep(3000);
        billsPayPageObjects.BPAccNum().clear();
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "721282F35988");
        billsPayPageObjects.BPLastName().clear();
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "");
        billsPayPageObjects.BPFirstName().clear();
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        billsPayPageObjects.BPMiddleName().clear();
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        billsPayPageObjects.BPOwnContactNum().clear();
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        assertEqual(getText(billsPayPageObjects.EmptyLastname()), "Account last name is a required field");

        waitSleep(3000);
        billsPayPageObjects.BPAccNum().clear();
        type(billsPayPageObjects.BPAccNum(), "BP Cignal Account Number", "721282F35988");
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
    public void validateBillsPayPagibigEmptyTransactionType()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "721282F35988");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);

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
            assertEqual(getText(billsPayPageObjects.IncorrectPayment()), "Incorrect Payment Details");
            LoggingUtils.info("Incorrect Payment Details\n" +"Loan Type is required. (code 6031) (version: 7bc15b5)");

        }

    }
    public void validateBillsPayPagibigEmptyPayorLname()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects. ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "721282F35988");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(billsPayPageObjects.Click2Option(), "Click Transaction Type");
        click(billsPayPageObjects.TransactionType(), "Transaction Type");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "Enrique");
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyLPayor()), "Payor last name is a required field");
        }
    }
    public void validateBillsPayPagibigEmptyPayorFname()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "721282F35988");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(billsPayPageObjects.Click2Option(), "Click Transaction Type");
        click(billsPayPageObjects.TransactionType(), "Transaction Type");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "Siarot");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");

            assertEqual(getText(billsPayPageObjects.EmptyFPayor()), "Payor first name is a required field");
        }
    }
    public void validateBillsPayPagibigEmptyPayorAddress()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "721282F35988");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(billsPayPageObjects.Click2Option(), "Click Transaction Type");
        click(billsPayPageObjects.TransactionType(), "Transaction Type");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "Siarot");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "Enrique");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09653241566");
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyAddress()), "Payor address is a required field");
        }
    }
    public void validateBillsPayPagibigEmptyPayorContact()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "721282F35988");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(billsPayPageObjects.Click2Option(), "Click Transaction Type");
        click(billsPayPageObjects.TransactionType(), "Transaction Type");
        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "Siarot");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "Enrique");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "10");
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.EmptyContact()), "Payor contact number is a required field");
        }
    }
    public void validateBillsPayPagibigZeroAndEmptyAmount()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "721282F35988");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(billsPayPageObjects.Click2Option(), "Click Transaction Type");
        click(billsPayPageObjects.TransactionType(), "Transaction Type");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorLastName(), "Payor Last Name", "Siarot");
            type(billsPayPageObjects.PayorFirstName(), "Payor First Name", "Enrique");
            type(billsPayPageObjects.PayorAddress(), "Payor Address", "Cebu City");
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "09653214566");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", " ");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "Testing Testing");
            assertEqual(getText(billsPayPageObjects.EmptyAmount()), "Payment amount must have a valid value");
            type(billsPayPageObjects.PaymentAmount(), "Payment Amount", "0");
            assertEqual(getText(billsPayPageObjects.ZeroAmount()), "Minimum amount is 1");
        }

    }
    public void validateBillsPayPagibigInvalidAccNum()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "721282F3598");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(billsPayPageObjects.Click2Option(), "Click Transaction Type");
        click(billsPayPageObjects.TransactionType(), "Transaction Type");

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
            assertEqual(getText(billsPayPageObjects.InvalidAccountNum()), "Incorrect Payment Details");
            LoggingUtils.info("Incorrect Payment Details\n" + "Invalid customer account number (code 1154) (version: 7bc15b5)");
        }
    }
    public void validateBillsPayPagibigFourDigAccNum()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "7212");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(billsPayPageObjects.Click2Option(), "Click Transaction Type");
        click(billsPayPageObjects.TransactionType(), "Transaction Type");

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
            assertEqual(getText(billsPayPageObjects.InvalidAccountNum()), "Incorrect Payment Details");
            LoggingUtils.info("Incorrect Payment Details\n" + "Invalid customer account number (code 1154) (version: 7bc15b5)");

        }
    }
    public void validateBillsPayPagibigInvalidContactNum()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "721282F35988");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(billsPayPageObjects.Click2Option(), "Click Transaction Type");
        click(billsPayPageObjects.TransactionType(), "Transaction Type");

        //Payor Information
        if(isVisible(billsPayPageObjects.billsPay_PayInfo(), getText(billsPayPageObjects.billsPay_PayInfo()))){
            type(billsPayPageObjects.PayorContact(), "Payor Contact", "08635129781");
            type(billsPayPageObjects.PaymentDetails(), "Payment Details", "");
            waitSleep(2000);
            assertEqual(getText(billsPayPageObjects.InvalidContact()), "Must start with 639|09|9 followed by 9 digits.");
            LoggingUtils.info("Must start with 639|09|9 followed by 9 digits.");
        }
    }
    public void validateBillsPayPagibigMaxAmountNum()throws Exception {
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        scrollToElement(billsPayPageObjects.ClickOption());
        waitSleep(10000);
        click(billsPayPageObjects.ClickOption(), "Option");
        waitSleep(3000);
        scrollVertically(By.cssSelector("[class=' css-11unzgr']"),2500);
        waitSleep(5000);
        click(billsPayPageObjects.ChooseOptionpagibig(), "Pag-ibig Partner");
        waitUntilLoadingGone(10000);
        type(billsPayPageObjects.BPAccNum(), "BP Pagibig Account Number", "721282F35988");
        type(billsPayPageObjects.BPLastName(), "BP Last Name", "Salingbay");
        type(billsPayPageObjects.BPFirstName(), "BP First Name", "Mary ann");
        type(billsPayPageObjects.BPMiddleName(), "BP Middle Name", "ALFEREZ");
        type(billsPayPageObjects.BPOwnContactNum(), "BP Account Owner Contact Number", "09203447377");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(billsPayPageObjects.Click2Option(), "Click Transaction Type");
        click(billsPayPageObjects.TransactionType(), "Transaction Type");

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
            LoggingUtils.info("Maximum allowed amount is PHP 25,000.00. (version: 7bc15b5)");
        }
    }

}
