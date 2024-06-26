package mlkpx.testSteps;

import mlwallet.testSteps.GenerateTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
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
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
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
        waitSleep(7000);
        if (isVisible(wsCashInToOwnAccountPageObjects.cashInSuccessfulText(), getText(wsCashInToOwnAccountPageObjects.cashInSuccessfulText()))) {
            ExtentReporter.logPass("CIOA_TC_01", "Successfully Cash In");
            String kptnText = getText(walletServicesPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeCIOPrintKTPN(kptnValues);
        } else {
            ExtentReporter.logFail("CIOA_TC_01", "Failed to Cash In");
            Assert.fail("Failed to Cash In");
        }
        click(wsCashInToOwnAccountPageObjects.proceedToPrintingButton(), "Proceed To Printing Button");
        waitUntilLoadingGone(10000);
        click(wsCashInToOwnAccountPageObjects.cancelReceiptButton(), "Cancel Button");

    }
    public void CIOA_TC_02()throws Exception {
        navigationWalletServices();
        click(walletServicesPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(walletServicesPageObjects.BranchCode()));

        type(walletServicesPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("validBranch_code"));
        waitSleep(15000);

        type(walletServicesPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("operatorID"));
        type(walletServicesPageObjects.ReasonRemote(), "Reason", "Testing");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
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
        waitSleep(8000);
        if (isVisible(wsCashInToOwnAccountPageObjects.cashInSuccessfulText(), getText(wsCashInToOwnAccountPageObjects.cashInSuccessfulText()))) {
            ExtentReporter.logPass("CIOA_TC_01", "Successfully Cash In");
            String kptnText = getText(walletServicesPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeCIOPrintKTPN(kptnValues);
        } else {
            ExtentReporter.logFail("CIOA_TC_01", "Failed to Cash In");
            Assert.fail("Failed to Cash In");
        }
        click(wsCashInToOwnAccountPageObjects.proceedToPrintingButton(), "Proceed To Printing Button");
        waitUntilLoadingGone(10000);
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
        type(wsCashInToOwnAccountPageObjects.referenceNumField(), "Reference Number Field", propertyReader.getproperty("referenceNumber"));
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

        reader.setRandomValueFromCIOA_TC_09("ACILKATHIKS");
    }

    public void CIOA_TC_10()throws Exception {
        navigationWalletServices();
//        String randomValueOFCIOA9 = reader.getRandomValueFromCIOA_TC_09(); // Store the random value here
//        type(wsCashInToOwnAccountPageObjects.referenceNumField(), "Reference Number Field", randomValueOFCIOA9);
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