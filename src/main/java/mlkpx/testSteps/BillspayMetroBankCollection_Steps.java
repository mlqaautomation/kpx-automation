package mlkpx.testSteps;

import org.openqa.selenium.By;
import utilities.Logger.LoggingUtils;

import java.util.Collections;
import java.util.List;

public class BillspayMetroBankCollection_Steps extends Base_Steps{

    public void validateSuccessfulBillspayMetroBankCollection()throws Exception {
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
}
