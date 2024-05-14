package mlkpx.testSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.util.Collections;
import java.util.List;

public class WS_CashInToOwnAccount_Steps extends Base_Steps{
    public void navigationWalletServices()throws Exception{
        click(wsCashInToOwnAccountPageObjects.walletServicesLink(), "Wallet Services Page ");
        if(isVisible(wsCashInToOwnAccountPageObjects.walletServicesText(), getText(wsCashInToOwnAccountPageObjects.walletServicesText()))){
            ExtentReporter.logPass("Wallet Services navigation", "Successfully Validated Wallet Services Page");
        }else{
            ExtentReporter.logFail("Wallet Services navigation", "Failed to Validate Wallet Services Page");
            Assert.fail("Failed to Validate Wallet Services Page");
        }
    }
    public void CIOA_TC_01()throws Exception {
        navigationWalletServices();
        String randomReferenceNum = reader.getRandomWriteCashIn_Kptn();
        type(wsCashInToOwnAccountPageObjects.referenceNumField(), "Reference Number Field", randomReferenceNum);
        click(wsCashInToOwnAccountPageObjects.searchButton(), "Search Button");
        waitSleep(3000);
        String totalAmountText = getText(wsCashInToOwnAccountPageObjects.totalAmount());
        List<String> totalAmountValues = Collections.singletonList(totalAmountText);
        totalAmountText = totalAmountText.replaceAll("[^\\d.]", "").replace(",", ".");
        double totalAmount = Double.parseDouble(totalAmountText);
        reader.writeTotalAmountData(totalAmountValues);

        String tenderAmount = propertyReader.getproperty("tenderAmount");
        List<String> updatedTenderAmountValues = Collections.singletonList(tenderAmount);
        tenderAmount = tenderAmount.replaceAll("[^\\d.]", "").replace(",", ".");
        double tenderAmountValue = Double.parseDouble(tenderAmount);
//        double updatedTenderAmount = tenderAmountValue + Double.parseDouble(totalAmountText);
        double updatedTenderAmount = tenderAmountValue + totalAmount;

        String updatedTenderAmountText = String.valueOf(updatedTenderAmount);
        type(wsCashInToOwnAccountPageObjects.tenderAmountField(), "Tender Amount Field", updatedTenderAmountText);
        updatedTenderAmountValues = Collections.singletonList(updatedTenderAmountText);
        reader.writeTenderAmountData(updatedTenderAmountValues);
        click(wsCashInToOwnAccountPageObjects.cancelButton(), "Cancel Button");
        click(wsCashInToOwnAccountPageObjects.noStayOnThisPageButton(), "No, Stay On This Page Button");
        click(wsCashInToOwnAccountPageObjects.proceedButton(), "Proceed Button");
        click(wsCashInToOwnAccountPageObjects.cancelInProceedButton(), "Cancel Button");
        click(wsCashInToOwnAccountPageObjects.proceedButton(), "Proceed Button");
        click(wsCashInToOwnAccountPageObjects.confirmCashInButton(), "Confirm Cash In Button");
        waitSleep(2000);
        if (isVisible(wsCashInToOwnAccountPageObjects.cashInSuccessfulText(), getText(wsCashInToOwnAccountPageObjects.cashInSuccessfulText()))) {
            ExtentReporter.logPass("CIOA_TC_01", "Successfully Cash In");
        } else {
            ExtentReporter.logFail("CIOA_TC_01", "Failed to Cash In");
            Assert.fail("Failed to Cash In");
        }
        click(wsCashInToOwnAccountPageObjects.proceedToPrintingButton(), "Proceed To Printing Button");
        waitSleep(3000);
        click(wsCashInToOwnAccountPageObjects.cancelReceiptButton(), "Cancel Button");

    }
    //    public void CIOA_TC_02()throws Exception{
//        QRCODE
//    }
    public void CIOA_TC_03()throws Exception{
        navigationWalletServices();
        String randomReferenceNum = reader.getRandomWriteCashIn_Kptn();
        type(wsCashInToOwnAccountPageObjects.referenceNumField(), "Reference Number Field", randomReferenceNum);
        click(wsCashInToOwnAccountPageObjects.searchButton(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsCashInToOwnAccountPageObjects.cashInText(), getText(wsCashInToOwnAccountPageObjects.cashInText()))){
            ExtentReporter.logPass("CIOA_TC_01", "Successfully Redirected to Cash In Transaction Information");
        }else{
            ExtentReporter.logFail("CIOA_TC_01", "Failed to Redirected to Cash In Transaction Information");
            Assert.fail("Failed to Redirected to Cash In Transaction Information");
        }
        String totalAmountText = getText(wsCashInToOwnAccountPageObjects.totalAmount());
        List<String> totalAmountValues = Collections.singletonList(totalAmountText);
        totalAmountText = totalAmountText.replaceAll("[^\\d.]", "").replace(",", ".");
        double totalAmount = Double.parseDouble(totalAmountText);
        reader.writeTotalAmountData(totalAmountValues);

        String tenderAmount = propertyReader.getproperty("tenderAmount");
        List<String> updatedTenderAmountValues = Collections.singletonList(tenderAmount);
        tenderAmount = tenderAmount.replaceAll("[^\\d.]", "").replace(",", ".");
        double tenderAmountValue = Double.parseDouble(tenderAmount);
//        double updatedTenderAmount = tenderAmountValue + Double.parseDouble(totalAmountText);
        double updatedTenderAmount = tenderAmountValue + totalAmount;

        String updatedTenderAmountText = String.valueOf(updatedTenderAmount);
        type(wsCashInToOwnAccountPageObjects.tenderAmountField(), "Tender Amount Field", updatedTenderAmountText);
        updatedTenderAmountValues = Collections.singletonList(updatedTenderAmountText);
        reader.writeTenderAmountData(updatedTenderAmountValues);
        click(wsCashInToOwnAccountPageObjects.cancelButton(), "Cancel Button");
        click(wsCashInToOwnAccountPageObjects.noStayOnThisPageButton(), "No, Stay On This Page Button");
        click(wsCashInToOwnAccountPageObjects.proceedButton(), "Proceed Button");
        click(wsCashInToOwnAccountPageObjects.cancelInProceedButton(), "Cancel Button");
        click(wsCashInToOwnAccountPageObjects.proceedButton(), "Proceed Button");
        click(wsCashInToOwnAccountPageObjects.confirmCashInButton(), "Confirm Cash In Button");
        waitSleep(4000);
        click(wsCashInToOwnAccountPageObjects.proceedToPrintingButton(), "Proceed To Printing Button");
        if(isVisible(wsCashInToOwnAccountPageObjects.detailsReceipt(), getText(wsCashInToOwnAccountPageObjects.detailsReceipt()))){
            ExtentReporter.logPass("CIOA_TC_03", "Successfully Cash In Verify Receipt");
        }else{
            ExtentReporter.logFail("CIOA_TC_03", "Failed to Cash In Verify Receipt");
            Assert.fail("Failed to Cash In Verify Receipt");
        }
        click(wsCashInToOwnAccountPageObjects.cancelReceiptButton(), "Cancel Button");

    }

    public void CIOA_TC_04()throws Exception{
        navigationWalletServices();
        type(wsCashInToOwnAccountPageObjects.referenceNumField(), "Reference Number", propertyReader.getproperty("invalidReferenceNum"));
        click(wsCashInToOwnAccountPageObjects.searchButton(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsCashInToOwnAccountPageObjects.invalidReferenceNumberText(), getText(wsCashInToOwnAccountPageObjects.invalidReferenceNumberText()))){
            ExtentReporter.logPass("CIOA_TC_04", "Successfully validate invalid reference number");
        }else{
            ExtentReporter.logFail("CIOA_TC_04", "Failed to  validate invalid reference number");
            Assert.fail("Failed to validate invalid reference number");
        }
        click(wsCashInToOwnAccountPageObjects.okButton(), "OK Button");
    }

    public void CIOA_TC_05()throws Exception{
        navigationWalletServices();
        click(wsCashInToOwnAccountPageObjects.mobileNum(), "Mobile Number");
        waitSleep(2000);
        click(wsCashInToOwnAccountPageObjects.mobileNumField(), "Mobile Number Field");
        type(wsCashInToOwnAccountPageObjects.mobileNumField(), "Mobile Number", propertyReader.getproperty("invalidMobileNumber"));
        click(wsCashInToOwnAccountPageObjects.searchButton(), "Search Button");
        if(isVisible(wsCashInToOwnAccountPageObjects.invalidMobileNumberText(), getText(wsCashInToOwnAccountPageObjects.invalidMobileNumberText()))){
            ExtentReporter.logPass("CIOA_TC_05", "Successfully validate invalid mobile number");
        }else{
            ExtentReporter.logFail("CIOA_TC_05", "Failed to  validate invalid mobile number");
            Assert.fail("Failed to  validate invalid mobile number");
        }
    }
    //    public void CIOA_TC_06()throws Exception{
//      QRCODE
//    }
    public void CIOA_TC_07()throws Exception {
        navigationWalletServices();
        type(wsCashInToOwnAccountPageObjects.referenceNumField(), "Reference Number Field", propertyReader.getproperty("transactionNumberClaimed"));
        click(wsCashInToOwnAccountPageObjects.searchButton(), "Search Button");
        if(isVisible(wsCashInToOwnAccountPageObjects.transactionClaimedText(), getText(wsCashInToOwnAccountPageObjects.transactionClaimedText()))){
            ExtentReporter.logPass("CIOA_TC_07", "Successfully validate already claimed transaction");
        }else{
            ExtentReporter.logFail("CIOA_TC_07", "Failed to  validate already claimed transaction");
            Assert.fail("Failed to  validate already claimed transaction");
        }
        click(wsCashInToOwnAccountPageObjects.okButton(), "OK Button");
    }
    public void CIOA_TC_08()throws Exception{
        navigationWalletServices();
        type(wsCashInToOwnAccountPageObjects.referenceNumField(), "Reference Number Field", propertyReader.getproperty("expireReferenceNum"));
        click(wsCashInToOwnAccountPageObjects.searchButton(), "Search Button");
        if(isVisible(wsCashInToOwnAccountPageObjects.expiredReferenceNumberText(), getText(wsCashInToOwnAccountPageObjects.expiredReferenceNumberText()))){
            ExtentReporter.logPass("CIOA_TC_08", "Successfully validate already expired transaction");
        }else{
            ExtentReporter.logFail("CIOA_TC_08", "Failed to  validate already expired transaction");
            Assert.fail("Failed to  validate already expired transaction");
        }
        click(wsCashInToOwnAccountPageObjects.okButton(), "OK Button");
    }
    public void CIOA_TC_09()throws Exception {
        navigationWalletServices();
//        String randomReferenceNum = reader.getRandomWriteCashIn_Kptn();
        type(wsCashInToOwnAccountPageObjects.referenceNumField(), "Reference Number Field", "ACIFDVERLXF");
        click(wsCashInToOwnAccountPageObjects.searchButton(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsCashInToOwnAccountPageObjects.cashInText(), getText(wsCashInToOwnAccountPageObjects.cashInText()))){
            ExtentReporter.logPass("CIOA_TC_09", "Successfully Redirected to Cash In Transaction Information");
        }else{
            ExtentReporter.logFail("CIOA_TC_09", "Failed to Redirected to Cash In Transaction Information");
            Assert.fail("Failed to Redirected to Cash In Transaction Information");
        }
        String totalAmountText = getText(wsCashInToOwnAccountPageObjects.totalAmount());
        List<String> totalAmountValues = Collections.singletonList(totalAmountText);
        totalAmountText = totalAmountText.replaceAll("[^\\d.]", "").replace(",", ".");
        double totalAmount = Double.parseDouble(totalAmountText);
        reader.writeTotalAmountData(totalAmountValues);

        String tenderAmount = propertyReader.getproperty("tenderAmount");
        List<String> updatedTenderAmountValues = Collections.singletonList(tenderAmount);
        tenderAmount = tenderAmount.replaceAll("[^\\d.]", "").replace(",", ".");
        double tenderAmountValue = Double.parseDouble(tenderAmount);
        double updatedTenderAmount = tenderAmountValue - totalAmount;

        String updatedTenderAmountText = String.valueOf(updatedTenderAmount);
        type(wsCashInToOwnAccountPageObjects.tenderAmountField(), "Tender Amount Field", updatedTenderAmountText);
        updatedTenderAmountValues = Collections.singletonList(updatedTenderAmountText);
        reader.writeTenderAmountData(updatedTenderAmountValues);
    }

    public void CIOA_TC_10()throws Exception {
        navigationWalletServices();
        type(wsCashInToOwnAccountPageObjects.referenceNumField(), "Reference Number Field", propertyReader.getproperty("referenceNumber"));
        click(wsCashInToOwnAccountPageObjects.searchButton(), "Search Button");
        type(wsCashInToOwnAccountPageObjects.tenderAmountField(), "Tender Amount Field", propertyReader.getproperty("tenderAmount"));
        click(wsCashInToOwnAccountPageObjects.cancelButton(), "Cancel Button");
        click(wsCashInToOwnAccountPageObjects.yesDoNotProcessButton(), "Yes Do Not Process Button");
        type(wsCashInToOwnAccountPageObjects.referenceNumField(), "Reference Number Field", propertyReader.getproperty("referenceNumber"));
        click(wsCashInToOwnAccountPageObjects.searchButton(), "Search Button");
        if(isVisible(wsCashInToOwnAccountPageObjects.transactionBeingProcessText(), getText(wsCashInToOwnAccountPageObjects.transactionBeingProcessText()))){
            ExtentReporter.logPass("CIOA_TC_10", "Successfully validate  again the cash in transaction if its being processed or not");
        }else{
            ExtentReporter.logFail("CIOA_TC_10", "Failed to validate again the cash in transaction if its being processed or not");
            Assert.fail("Failed to  validate again the cash in transaction if its being processed or not");
        }
    }





}