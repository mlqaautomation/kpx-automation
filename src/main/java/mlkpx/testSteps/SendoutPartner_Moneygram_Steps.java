package mlkpx.testSteps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class SendoutPartner_Moneygram_Steps extends Base_Steps {

    public void PS_TC_01() throws Exception {
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendoutPartnerMoneygramPageObjects.sendoutTransactionLink(), "Sendout Transaction");
        click(sendoutPartnerMoneygramPageObjects.partnerSendout(), "Partner Sendout Dropdown Button");
        if (isVisible(sendoutPartnerMoneygramPageObjects.sendoutPartnerText(), getText(sendoutPartnerMoneygramPageObjects.sendoutPartnerText()))) {
            ExtentReporter.logPass("PS_TC_01", "Successfully Validated  Sendout Partner Page Navigation");
        } else {
            ExtentReporter.logFail("PS_TC_01", "Failed to Validate SendOut Partner Page Navigation");
            Assert.fail("Failed to Validate SendOut Partner Page Navigation");
        }
    }
    public void PS_TC_02 () throws Exception {
        PS_TC_01();
        click(sendOutPageObjects.yesRadioButton(), "Yes Button ");
        waitSleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
        click(sendoutPartnerMoneygramPageObjects.selectPartner(), "Select Partner");
        click(sendoutPartnerMoneygramPageObjects.selectMoneygram(), "Select Moneygram in Dropdown");
        if (isVisible(sendoutPartnerMoneygramPageObjects.intendedToUse(), getText(sendoutPartnerMoneygramPageObjects.intendedToUse()))) {
            ExtentReporter.logPass("PS_TC_02", "Successfully Validate Transaction Options Valid Branch Code");
        } else {
            ExtentReporter.logFail("PS_TC_02", "Failed to Validate Transaction Options Valid Branch Code");
            Assert.fail("Failed to Validate Transaction Options Valid Branch Code");
        }
    }

    public void PS_TC_03 () throws Exception {
        PS_TC_01();
        click(sendoutPartnerMoneygramPageObjects.selectPartner(), "Select Partner");
        click(sendoutPartnerMoneygramPageObjects.selectMoneygram(), "Select Moneygram in Dropdown");
        searchKYC();
        if (isVisible(sendoutPartnerMoneygramPageObjects.senderInformationText(), getText(sendoutPartnerMoneygramPageObjects.senderInformationText()))) {
            ExtentReporter.logPass("PS_TC_03", "Successfully Validate Search Kyc in Sendout Partner");
        } else {
            ExtentReporter.logFail("PS_TC_03", "Failed to Validate Search Kyc in Sendout Partner");
            Assert.fail("Failed to Validate Search Kyc in Sendout Partner");
        }
    }
    public void PS_TC_03_1() throws Exception {
        PS_TC_01();
        click(sendoutPartnerMoneygramPageObjects.selectPartner(), "Select Partner");
        click(sendoutPartnerMoneygramPageObjects.selectMoneygram(), "Select Moneygram in Dropdown");
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        searchRegisteredKYC_Invalid();
        searchRegisteredKYC_Invalid03();
        searchRegisteredKYC_Invalid04();
        searchRegisteredKYC_Invalid05();
        if (isVisible(sendoutPartnerMoneygramPageObjects.firstName_max60(), getText(sendoutPartnerMoneygramPageObjects.firstName_max60()))) {
            ExtentReporter.logPass("PS_TC_03_1", "Successfully Validate Search Kyc in Sendout Partner Negative Test");
        } else {
            ExtentReporter.logFail("PS_TC_03_1", "Failed to Validate Search Kyc in Sendout Partner Negative Test");
            Assert.fail("Failed to Validate Search Kyc in Sendout Partner Negative Test");
        }

    }
    public void PS_TC_04() throws Exception {
        PS_TC_01();
        click(sendoutPartnerMoneygramPageObjects.selectPartner(), "Select Partner");
        click(sendoutPartnerMoneygramPageObjects.selectMoneygram(), "Select Moneygram in Dropdown");
        searchKYC();
        addReceiver();
    }

    public void PS_TC_04_1() throws Exception {
        PS_TC_01();
        click(sendoutPartnerMoneygramPageObjects.selectPartner(), "Select Partner");
        click(sendoutPartnerMoneygramPageObjects.selectMoneygram(), "Select Moneygram in Dropdown");
        searchKYC();
        waitUntilLoadingGone(15000);
        scrollToElement(sendOutPageObjects.searchReceivers());
        click(sendoutPartnerMoneygramPageObjects.searchReceiver(), "Search Receivers Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.addNewReceivers(), "Add new Receiver ");
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", propertyReader.getproperty("MLast_name"));
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", propertyReader.getproperty("MFirst_name"));
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", propertyReader.getproperty("MFirst_name"));
        waitSleep(3000);
        if(isVisible(sendOutPageObjects.receiversMaximumLettersDangerText(), getText(sendOutPageObjects.receiversMaximumLettersDangerText()))){
            ExtentReporter.logPass("PS_TC_04_1", "Successfully Verify Add Receiver New Negative Test");
        }else{
            ExtentReporter.logFail("PS_TC_04_1", "Fail to Verify Add Receiver New Negative Test");
            Assert.fail("Fail to Verify Add Receiver New Negative Test");
        }

    }
    public void PS_TC_05() throws Exception {
        PS_TC_02();
        searchKYC();
        waitUntilLoadingGone(10000);
        scrollToElement(sendOutPageObjects.searchReceivers());
        click(sendoutPartnerMoneygramPageObjects.searchReceiver(), "Search Receivers Button ");
        waitUntilLoadingGone(10000);
        scrollDown(100);
        LoggingUtils.info(getText(sendOutPageObjects.name_Text(1)));
        String selectedReceiverName = getText(sendOutPageObjects.name_Text(1));
        click(sendOutPageObjects.selectButton(), "Select Button");
        waitSleep(35000);
        click(sendoutPartnerMoneygramPageObjects.nationalityReceivers(),"Nationality Dropdown Field");
        click(sendoutPartnerMoneygramPageObjects.selectedNationalityReceivers()," Selected Nationality Receivers ");
        type(sendoutPartnerMoneygramPageObjects.contactNumberReceiver(),"Receiver's Contact Number", propertyReader.getproperty("Contact_number"));
        String value = getValue(sendOutPageObjects.r_LastName());
        String[] receiverNames = selectedReceiverName.split(",");
        boolean containsName = false;
        for (String name : receiverNames) {
            if (value.contains(name.trim())) { //loops the lastname text until comma
                containsName = true;
                break;
            }
        }
        if (containsName) {
            ExtentReporter.logPass("PS_TC_05", "Successfully Validate Search Receiver  ");
            LoggingUtils.info("Successfully Validate Search Receiver  ");
        } else {
            ExtentReporter.logFail("PS_TC_05", "Failed to Validate Search Receiver  ");
            LoggingUtils.error("Failed to Validate Search Receiver " + getValue(sendOutPageObjects.r_LastName()) + " Expected " + selectedReceiverName);
            Assert.fail("Failure due to Incorrect Details"); //assert the script to fail in testng
        }

    }
    public void PS_TC_06() throws Exception {
        PS_TC_05();
        scrollUp(driver);
        click(sendoutPartnerMoneygramPageObjects.sourceOfFund(),"Source of Fund Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedSourceOfFund(),"Selected Source of Fund");
        click(sendoutPartnerMoneygramPageObjects.purposeOfTransfer(),"Purpose of Transfer Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedPurposeOfTransfer(),"Selected Purpose of Transfer");
        click(sendoutPartnerMoneygramPageObjects.relationshipWithReceiver(),"Relationship with Receiver Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedRelationshipWithReceiver(),"Selected Relationship with Receiver");
        click(sendoutPartnerMoneygramPageObjects.intendedToUse2(),"Intended to Use Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedIntendedToUse2()," Selected Intended to Use");
        click(sendoutPartnerMoneygramPageObjects.deliveryOptions(),"Delivery Options Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedDeliveryOptions10MinuteService(),"Selected Delivery Options 10 Minute Service");
    }
    public void PS_TC_07() throws Exception {
        PS_TC_06();
        scrollToElement(sendoutPartnerMoneygramPageObjects.sendAmountField());
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Valid Principal Amount field ", propertyReader.getproperty("validAmount"));
        waitSleep(15000);
        assertEqual(getText(sendOutPageObjects.chargeAmount()), propertyReader.getproperty("minimumCharge"));

        if (isTotalCorrect()) {
            ExtentReporter.logPass("Total Computation", "is Correct");
        } else {
            ExtentReporter.logFail("Total Computation", "is not Correct");
            Assert.fail("Total Computation is not correct");
        }

    }
    public void PS_TC_07_1() throws Exception {
        PS_TC_06();
        scrollToElement(sendoutPartnerMoneygramPageObjects.sendAmountField());
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Principal Amount field ", propertyReader.getproperty("principalAmountEmpty"));
        click(sendoutPartnerMoneygramPageObjects.sendFeeText(),"Send Fee Text");
        if (isVisible(sendoutPartnerMoneygramPageObjects.principalAmountDangerText(), getText((sendoutPartnerMoneygramPageObjects.principalAmountDangerText())))) {
            ExtentReporter.logPass("Empty Value", "Principal amount must have a valid value");
        }
//        waitSleep(15000);
//        click(sendoutPartnerMoneygramPageObjects.okButtonInTransactionInvalidAmount(),"Modal in Transaction Invalid Amount");
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Principal Amount field ", propertyReader.getproperty("principalAmountZero"));
        waitSleep(8000);
        click(sendoutPartnerMoneygramPageObjects.okButtonInTransactionInvalidAmount(),"OK button in Transaction Modal");
//        if (isVisible(sendoutPartnerMoneygramPageObjects.transactionAmountIsInvalidTextInModal(), getText((sendoutPartnerMoneygramPageObjects.transactionAmountIsInvalidTextInModal())))) {
//            ExtentReporter.logPass("Input Amount (Zero)", "Transaction amount is invalid (code 7060) (version: b3b65ae)");
//        }
        clearField(sendoutPartnerMoneygramPageObjects.sendAmountField());
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Principal Amount field ", propertyReader.getproperty("principalAmountNegative"));
        waitSleep(8000);
        click(sendoutPartnerMoneygramPageObjects.okButtonInTransactionInvalidAmount(),"OK button in Transaction Modal");
//        if (isVisible(sendoutPartnerMoneygramPageObjects.transactionAmountIsInvalidTextInModal(), getText((sendoutPartnerMoneygramPageObjects.transactionAmountIsInvalidTextInModal())))) {
//            ExtentReporter.logPass("Input Amount (Negative Value)", "Transaction amount is invalid (code 7060) (version: b3b65ae)");
//        }
        clearField(sendoutPartnerMoneygramPageObjects.sendAmountField());
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Principal Amount field ", propertyReader.getproperty("maximumAmount"));
        waitSleep(8000);
        if (isVisible(sendoutPartnerMoneygramPageObjects.exceedTheTransactionLimitText(), getText((sendoutPartnerMoneygramPageObjects.exceedTheTransactionLimitText())))) {
            ExtentReporter.logPass("Maximum Amount", "The amount exceeds the transaction limit. (code 1025) (version: b3b65ae)");
        }
        click(sendoutPartnerMoneygramPageObjects.okButtonInTransactionInvalidAmount(),"OK button in Transaction Modal");
        clearField(sendoutPartnerMoneygramPageObjects.sendAmountField());

        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Valid Principal Amount field ", propertyReader.getproperty("lowestAmount"));
        waitSleep(15000);
        assertEqual(getText(sendOutPageObjects.chargeAmount()), propertyReader.getproperty("minimumCharge"));
        clearField(sendoutPartnerMoneygramPageObjects.sendAmountField());
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Valid Principal Amount field ", propertyReader.getproperty("highestAmount"));
        waitSleep(23000);
        assertEqual(getText(sendOutPageObjects.chargeAmount()), propertyReader.getproperty("maximumCharge"));
        waitSleep(3000);
        if (isTotalCorrect()) {
            ExtentReporter.logPass("Total Computation", "is Correct");
        } else {
            ExtentReporter.logFail("Total Computation", "is not Correct");
            Assert.fail("Total Computation is not correct");
        }

    }

    public boolean isTotalCorrect () throws Exception {
        double principalAmt = parseTotalValue(getValue(sendoutPartnerMoneygramPageObjects.sendAmountField()));
        double chargeAmt = parseTotalValue(getText(sendOutPageObjects.chargeAmount()));
//        double otherChargeAmt = parseTotalValue(getText(sendOutPageObjects.otherChargeAmount()));
        double totalAmt = parseTotalValue(getText(sendoutPartnerMoneygramPageObjects.totalAmount()));
//        double expectedTotal = principalAmt + chargeAmt + otherChargeAmt;
        double expectedTotal = principalAmt + chargeAmt;
        assertEqual(totalAmt, expectedTotal);
        LoggingUtils.info("Expected total: " + expectedTotal + ", actual: " + totalAmt);
        return Math.abs(expectedTotal - totalAmt) < 0.0001;
    }



    public void PS_TC_08() throws Exception {
        PS_TC_01();
        click(sendoutPartnerMoneygramPageObjects.selectPartner(), "Select Partner");
        click(sendoutPartnerMoneygramPageObjects.selectMoneygram(), "Select Moneygram in Dropdown");
        searchKYC();
        waitUntilLoadingGone(10000);
        scrollToElement(sendOutPageObjects.searchReceivers());
        click(sendoutPartnerMoneygramPageObjects.searchReceiver(), "Search Receivers Button ");
        waitUntilLoadingGone(10000);
        scrollDown(100);
        LoggingUtils.info(getText(sendOutPageObjects.name_Text(1)));
        String selectedReceiverName = getText(sendOutPageObjects.name_Text(1));
        click(sendOutPageObjects.selectButton(), "Select Button");
        waitSleep(30000);
        click(sendoutPartnerMoneygramPageObjects.nationalityReceivers(),"Nationality Dropdown Field");
        click(sendoutPartnerMoneygramPageObjects.selectedNationalityReceivers()," Selected Nationality Receivers ");
        type(sendoutPartnerMoneygramPageObjects.contactNumberReceiver(),"Receiver's Contact Number", propertyReader.getproperty("Contact_number"));
        String value = getValue(sendOutPageObjects.r_LastName());
        String[] receiverNames = selectedReceiverName.split(",");
        boolean containsName = false;
        for (String name : receiverNames) {
            if (value.contains(name.trim())) { //loops the lastname text until comma
                containsName = true;
                break;
            }
        }
        if (containsName) {
            ExtentReporter.logPass("PS_TC_05", "Successfully Validate Search Receiver  ");
            LoggingUtils.info("Successfully Validate Search Receiver  ");
        } else {
            ExtentReporter.logFail("PS_TC_05", "Failed to Validate Search Receiver  ");
            LoggingUtils.error("Failed to Validate Search Receiver " + getValue(sendOutPageObjects.r_LastName()) + " Expected " + selectedReceiverName);
            Assert.fail("Failure due to Incorrect Details"); //assert the script to fail in testng
        }

        scrollUp(driver);
        click(sendoutPartnerMoneygramPageObjects.sourceOfFund(),"Source of Fund Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedSourceOfFund(),"Selected Source of Fund");
        click(sendoutPartnerMoneygramPageObjects.purposeOfTransfer(),"Purpose of Transfer Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedPurposeOfTransfer(),"Selected Purpose of Transfer");
        click(sendoutPartnerMoneygramPageObjects.relationshipWithReceiver(),"Relationship with Receiver Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedRelationshipWithReceiver(),"Selected Relationship with Receiver");
        click(sendoutPartnerMoneygramPageObjects.intendedToUse2(),"Intended to Use Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedIntendedToUse2()," Selected Intended to Use");
        click(sendoutPartnerMoneygramPageObjects.deliveryOptions(),"Delivery Options Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedDeliveryOptions10MinuteService(),"Selected Delivery Options 10 Minute Service");

        scrollToElement(sendoutPartnerMoneygramPageObjects.sendAmountField());
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Valid Principal Amount field ", propertyReader.getproperty("validAmount"));
        waitSleep(15000);
        click(sendoutPartnerMoneygramPageObjects.submitButton(),"Submit Sendout Button");
        click(sendoutPartnerMoneygramPageObjects.confirmSendoutButton(),"Confirm Sendout Button");
        waitSleep(15000);
        //todo get value of kptn locator and post it to yaml file
        String referenceNumber = getText(sendoutPartnerMoneygramPageObjects.referenceNumber());
        List<String> kptnValues = Collections.singletonList(referenceNumber);
        reader.writeKptnDataMoneygramPartner10MinuteService(kptnValues);
        if(isVisible(sendoutPartnerMoneygramPageObjects.sendoutSuccessfulText(), getText(sendoutPartnerMoneygramPageObjects.sendoutSuccessfulText()))){
            ExtentReporter.logPass("PS_TC_08", "Successfully Sendout Partner Moneygram");
        }else{
            ExtentReporter.logFail("PS_TC_08", "Fail to Verify Sendout Partner Moneygram");
            Assert.fail("Fail to Verify Sendout Partner Moneygram");
        }
        click(sendoutPartnerMoneygramPageObjects.proceedToPrintingButton(),"Proceed to Printing Button");
        click(sendoutPartnerMoneygramPageObjects.cancelInPrintingButton(),"Cancel In Printing Button");

    }
    public void PS_TC_08_1() throws Exception {
        PS_TC_02();
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        String[] randomName = reader.getRandomName();
        type(sendOutPageObjects.lastName(), "Lastname ", propertyReader.getproperty("forPartnerLastName"));
        type(sendOutPageObjects.firstName(), "Firstname ", propertyReader.getproperty("forPartnerFirstName"));
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollToBottomOfPageWEB();
        scrollToElement(sendOutPageObjects.selectKYC());
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        waitUntilLoadingGone(10000);
        scrollToElement(sendOutPageObjects.searchReceivers());
        click(sendoutPartnerMoneygramPageObjects.searchReceiver(), "Search Receivers Button ");
        waitUntilLoadingGone(10000);
        scrollDown(100);
        LoggingUtils.info(getText(sendOutPageObjects.name_Text(1)));
        String selectedReceiverName = getText(sendOutPageObjects.name_Text(1));
        click(sendOutPageObjects.selectButton(), "Select Button");
        waitSleep(33000);
        click(sendoutPartnerMoneygramPageObjects.nationalityReceivers(),"Nationality Dropdown Field");
        waitSleep(2000);
        click(sendoutPartnerMoneygramPageObjects.selectedNationalityReceivers()," Selected Nationality Receivers ");
        type(sendoutPartnerMoneygramPageObjects.contactNumberReceiver(),"Receiver's Contact Number", propertyReader.getproperty("Contact_number"));
        String value = getValue(sendOutPageObjects.r_LastName());
        String[] receiverNames = selectedReceiverName.split(",");
        boolean containsName = false;
        for (String name : receiverNames) {
            if (value.contains(name.trim())) { //loops the lastname text until comma
                containsName = true;
                break;
            }
        }
        if (containsName) {
            ExtentReporter.logPass("PS_TC_05", "Successfully Validate Search Receiver  ");
            LoggingUtils.info("Successfully Validate Search Receiver  ");
        } else {
            ExtentReporter.logFail("PS_TC_05", "Failed to Validate Search Receiver  ");
            LoggingUtils.error("Failed to Validate Search Receiver " + getValue(sendOutPageObjects.r_LastName()) + " Expected " + selectedReceiverName);
            Assert.fail("Failure due to Incorrect Details"); //assert the script to fail in testng
        }
        scrollUp(driver);
        click(sendoutPartnerMoneygramPageObjects.sourceOfFund(),"Source of Fund Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedSourceOfFund(),"Selected Source of Fund");
        click(sendoutPartnerMoneygramPageObjects.purposeOfTransfer(),"Purpose of Transfer Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedPurposeOfTransfer(),"Selected Purpose of Transfer");
        click(sendoutPartnerMoneygramPageObjects.relationshipWithReceiver(),"Relationship with Receiver Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedRelationshipWithReceiver(),"Selected Relationship with Receiver");
        click(sendoutPartnerMoneygramPageObjects.intendedToUse2(),"Intended to Use Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedIntendedToUse2()," Selected Intended to Use");
        click(sendoutPartnerMoneygramPageObjects.deliveryOptions(),"Delivery Options Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedDeliveryOptions10MinuteService(),"Selected Delivery Options 10 Minute Service");

        scrollToElement(sendoutPartnerMoneygramPageObjects.sendAmountField());
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Valid Principal Amount field ", propertyReader.getproperty("validAmount"));
        waitSleep(15000);
        click(sendoutPartnerMoneygramPageObjects.submitButton(),"Submit Sendout Button");
        click(sendoutPartnerMoneygramPageObjects.confirmSendoutButton(),"Confirm Sendout Button");
        waitSleep(15000);
        //todo get value of kptn locator and post it to yaml file
        String referenceNumber = getText(sendoutPartnerMoneygramPageObjects.referenceNumber());
        List<String> kptnValues = Collections.singletonList(referenceNumber);
        reader.writeKptnDataMoneygramPartner10MinuteServiceRemote(kptnValues);
        if(isVisible(sendoutPartnerMoneygramPageObjects.sendoutSuccessfulText(), getText(sendoutPartnerMoneygramPageObjects.sendoutSuccessfulText()))){
            ExtentReporter.logPass("PS_TC_08_1", "Successfully Sendout Partner Moneygram Remote");
        }else{
            ExtentReporter.logFail("PS_TC_08_1", "Fail to Verify Sendout Partner Moneygram Remote");
            Assert.fail("Fail to Verify Sendout Partner Moneygram");
        }
        click(sendoutPartnerMoneygramPageObjects.proceedToPrintingButton(),"Proceed to Printing Button");
        click(sendoutPartnerMoneygramPageObjects.cancelInPrintingButton(),"Cancel In Printing Button");

    }
    public void PS_TC_09_PS_TC_011() throws Exception {
        PS_TC_06();
        scrollToElement(sendoutPartnerMoneygramPageObjects.sendAmountField());
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Valid Principal Amount field ", propertyReader.getproperty("validAmount"));
        waitSleep(15000);
        click(sendoutPartnerMoneygramPageObjects.submitButton(),"Submit Sendout Button");
        click(sendoutPartnerMoneygramPageObjects.cancelSendoutButton(),"Cancel Button");
        click(sendoutPartnerMoneygramPageObjects.cancelButton(),"Cancel Button");
        click(sendoutPartnerMoneygramPageObjects.stayOnThisPageButton(),"Stay On This Page Button");
        click(sendoutPartnerMoneygramPageObjects.cancelButton(),"Cancel Button");
        click(sendoutPartnerMoneygramPageObjects.yesCancelTransactionButton(),"Yes, Cancel Transaction Button");
        if(isVisible(sendoutPartnerMoneygramPageObjects.sendoutPartnerText(), getText(sendoutPartnerMoneygramPageObjects.sendoutPartnerText()))){
            ExtentReporter.logPass("PS_TC_09", "Successfully Cancel The Transaction");
        }else{
            ExtentReporter.logFail("PS_TC_09", "Fail to Verify Cancel The Transaction");
            Assert.fail("Fail to Verify Cancel The Transaction");
        }
    }
    public void PS_TC_10() throws Exception {
        PS_TC_01();
        click(sendoutPartnerMoneygramPageObjects.selectPartner(), "Select Partner");
        click(sendoutPartnerMoneygramPageObjects.selectMoneygram(), "Select Moneygram in Dropdown");
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        String[] randomName = reader.getRandomName();
        type(sendOutPageObjects.lastName(), "Lastname ", propertyReader.getproperty("watchListKYCLastName"));
        type(sendOutPageObjects.firstName(), "Firstname ", propertyReader.getproperty("watchListKYCFirstName"));
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollToBottomOfPageWEB();
        scrollDown(100);
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        if(isVisible(sendoutPartnerMoneygramPageObjects.complianceText(), getText(sendoutPartnerMoneygramPageObjects.complianceText()))){
            ExtentReporter.logPass("PS_TC_10", "Successfully Verify WatchListed KYC");
        }else{
            ExtentReporter.logFail("PS_TC_10", "Fail to Verify WatchListed KYC");
            Assert.fail("Fail to Verify WatchListed KYC");
        }
        click(sendoutPartnerMoneygramPageObjects.complianceOKButton(),"Compliance OK Button");

    }






    public void PS_TC_12() throws Exception {
        PS_TC_05();
        scrollUp(driver);
        click(sendoutPartnerMoneygramPageObjects.sourceOfFund(),"Source of Fund Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedSourceOfFund(),"Selected Source of Fund");
        click(sendoutPartnerMoneygramPageObjects.purposeOfTransfer(),"Purpose of Transfer Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedPurposeOfTransfer(),"Selected Purpose of Transfer");
        click(sendoutPartnerMoneygramPageObjects.relationshipWithReceiver(),"Relationship with Receiver Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedRelationshipWithReceiver(),"Selected Relationship with Receiver");
        click(sendoutPartnerMoneygramPageObjects.intendedToUse2(),"Intended to Use Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedIntendedToUse2()," Selected Intended to Use");
        click(sendoutPartnerMoneygramPageObjects.deliveryOptions(),"Delivery Options Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedDeliveryOptionsAccountDeposit(),"Selected Delivery Options Account Deposit");
        scrollToElement(sendoutPartnerMoneygramPageObjects.sendAmountField());
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Valid Principal Amount field ", propertyReader.getproperty("validAmount"));
        waitSleep(15000);
        if(isVisible(sendoutPartnerMoneygramPageObjects.additionalInfoText(), getText(sendoutPartnerMoneygramPageObjects.additionalInfoText()))){
            ExtentReporter.logPass("PS_TC_12", "Additional Information is Visible");
        }else{
            ExtentReporter.logFail("PS_TC_12", "Fail to see Additional Information");
            Assert.fail("Fail to see Additional Information");
        }
        click(sendoutPartnerMoneygramPageObjects.agentDropDown(),"Agent Drop Down Button");
        click(sendoutPartnerMoneygramPageObjects.selectedAgentAllBanks(),"Selected Agent All Banks");
        click(sendoutPartnerMoneygramPageObjects.bankEWalletNameDropDown(),"Bank / E-wallet Drop Down");
        click(sendoutPartnerMoneygramPageObjects.selectedBAnkOrEWallet(),"Selected Bank / E-wallet Drop Down");
        type(sendoutPartnerMoneygramPageObjects.accountNumber(), "Account Number", propertyReader.getproperty("accountNumber"));
        click(sendoutPartnerMoneygramPageObjects.submitButton(),"Submit Sendout Button");
        scrollDown(50);
        click(sendoutPartnerMoneygramPageObjects.confirmSendoutButton(),"Confirm Sendout Button");
        waitSleep(15000);
        //todo get value of kptn locator and post it to yaml file
        String referenceNumber = getText(sendoutPartnerMoneygramPageObjects.referenceNumber());
        List<String> kptnValues = Collections.singletonList(referenceNumber);
        reader.writeKptnDataMoneygramPartnerAccountDeposit(kptnValues);

        click(sendoutPartnerMoneygramPageObjects.proceedToPrintingButton(),"Proceed to Printing Button");
        click(sendoutPartnerMoneygramPageObjects.cancelInPrintingButton(),"Cancel In Printing Button");

    }


    public void PS_TC_13() throws Exception {
        PS_TC_01();
        click(sendoutPartnerMoneygramPageObjects.selectPartner(), "Select Partner");
        click(sendoutPartnerMoneygramPageObjects.selectWesternUnion(), "Select Western Union in Dropdown");
        searchKYC();

        waitUntilLoadingGone(10000);
        scrollToElement(sendOutPageObjects.searchReceivers());
        click(sendoutPartnerMoneygramPageObjects.searchReceiver(), "Search Receivers Button ");
        waitUntilLoadingGone(10000);
        scrollDown(100);
        LoggingUtils.info(getText(sendOutPageObjects.name_Text(1)));
        String selectedReceiverName = getText(sendOutPageObjects.name_Text(1));
        click(sendOutPageObjects.selectButton(), "Select Button");
        waitSleep(30000);
        scrollToElement(sendoutPartnerMoneygramPageObjects.restrictionModalOKButton());
        click(sendoutPartnerMoneygramPageObjects.restrictionModalOKButton(),"Restriction Modal Ok button Dropdown");
        scrollDown(100);
        click(sendoutPartnerMoneygramPageObjects.nationalityReceivers(),"Nationality Dropdown Field");
        click(sendoutPartnerMoneygramPageObjects.selectedNationalityReceivers()," Selected Nationality Receivers ");
        type(sendoutPartnerMoneygramPageObjects.contactNumberReceiver(),"Receiver's Contact Number", propertyReader.getproperty("Contact_number"));
        String value = getValue(sendOutPageObjects.r_LastName());
        String[] receiverNames = selectedReceiverName.split(",");
        boolean containsName = false;
        for (String name : receiverNames) {
            if (value.contains(name.trim())) { //loops the lastname text until comma
                containsName = true;
                break;
            }
        }
        if (containsName) {
            ExtentReporter.logPass("PS_TC_13", "Successfully Validate Search Receiver  ");
            LoggingUtils.info("Successfully Validate Search Receiver  ");
        } else {
            ExtentReporter.logFail("PS_TC_13", "Failed to Validate Search Receiver  ");
            LoggingUtils.error("Failed to Validate Search Receiver " + getValue(sendOutPageObjects.r_LastName()) + " Expected " + selectedReceiverName);
            Assert.fail("Failure due to Incorrect Details"); //assert the script to fail in testng
        }

        scrollUp(driver);
        click(sendoutPartnerMoneygramPageObjects.sourceOfFund(),"Source of Fund Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedSourceOfFund(),"Selected Source of Fund");
        click(sendoutPartnerMoneygramPageObjects.purposeOfTransfer(),"Purpose of Transfer Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedPurposeOfTransfer(),"Selected Purpose of Transfer");
        click(sendoutPartnerMoneygramPageObjects.relationshipWithReceiver(),"Relationship with Receiver Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedRelationshipWithReceiver(),"Selected Relationship with Receiver");
        click(sendoutPartnerMoneygramPageObjects.deliveryOptions(),"Delivery Options Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedDeliveryOptions10MinuteService(),"Selected Delivery Options 10 Minute Service");

        scrollToElement(sendoutPartnerMoneygramPageObjects.sendAmountField());
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Valid Principal Amount field ", propertyReader.getproperty("validAmount"));
        waitSleep(15000);
        click(sendoutPartnerMoneygramPageObjects.submitButton(),"Submit Sendout Button");
        click(sendoutPartnerMoneygramPageObjects.confirmSendoutButton(),"Confirm Sendout Button");
        waitSleep(15000);
        //todo get value of kptn locator and post it to yaml file
        String referenceNumber = getText(sendoutPartnerMoneygramPageObjects.referenceNumber());
        List<String> kptnValues = Collections.singletonList(referenceNumber);
        reader.writeKptnDataWesternUnionPartner10MinuteService(kptnValues);
        if(isVisible(sendoutPartnerMoneygramPageObjects.sendoutSuccessfulText(), getText(sendoutPartnerMoneygramPageObjects.sendoutSuccessfulText()))){
            ExtentReporter.logPass("PS_TC_13", "Successfully Sendout Partner Moneygram");
        }else{
            ExtentReporter.logFail("PS_TC_13", "Fail to Verify Sendout Partner Moneygram");
            Assert.fail("Fail to Verify Sendout Partner Moneygram");
        }
        click(sendoutPartnerMoneygramPageObjects.proceedToPrintingButton(),"Proceed to Printing Button");
        click(sendoutPartnerMoneygramPageObjects.cancelInPrintingButton(),"Cancel In Printing Button");

    }
    public void PS_TC_14() throws Exception {
        PS_TC_01();
        click(sendOutPageObjects.yesRadioButton(), "Yes Button ");
        waitSleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(13));
        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
        click(sendoutPartnerMoneygramPageObjects.selectPartner(), "Select Partner");
        click(sendoutPartnerMoneygramPageObjects.selectWesternUnion(), "Select Western Union in Dropdown");
        searchKYC();

        waitUntilLoadingGone(10000);
        scrollToElement(sendOutPageObjects.searchReceivers());
        click(sendoutPartnerMoneygramPageObjects.searchReceiver(), "Search Receivers Button ");
        waitUntilLoadingGone(10000);
        scrollDown(100);
        LoggingUtils.info(getText(sendOutPageObjects.name_Text(1)));
        String selectedReceiverName = getText(sendOutPageObjects.name_Text(1));
        click(sendOutPageObjects.selectButton(), "Select Button");
        waitSleep(30000);
        scrollToElement(sendoutPartnerMoneygramPageObjects.restrictionModalOKButton());
        click(sendoutPartnerMoneygramPageObjects.restrictionModalOKButton(),"Restriction Modal Ok button Dropdown");
        scrollDown(100);
        click(sendoutPartnerMoneygramPageObjects.nationalityReceivers(),"Nationality Dropdown Field");
        click(sendoutPartnerMoneygramPageObjects.selectedNationalityReceivers()," Selected Nationality Receivers ");
        type(sendoutPartnerMoneygramPageObjects.contactNumberReceiver(),"Receiver's Contact Number", propertyReader.getproperty("Contact_number"));
        String value = getValue(sendOutPageObjects.r_LastName());
        String[] receiverNames = selectedReceiverName.split(",");
        boolean containsName = false;
        for (String name : receiverNames) {
            if (value.contains(name.trim())) { //loops the lastname text until comma
                containsName = true;
                break;
            }
        }
        if (containsName) {
            ExtentReporter.logPass("PS_TC_14", "Successfully Validate Search Receiver  ");
            LoggingUtils.info("Successfully Validate Search Receiver  ");
        } else {
            ExtentReporter.logFail("PS_TC_14", "Failed to Validate Search Receiver  ");
            LoggingUtils.error("Failed to Validate Search Receiver " + getValue(sendOutPageObjects.r_LastName()) + " Expected " + selectedReceiverName);
            Assert.fail("Failure due to Incorrect Details"); //assert the script to fail in testng
        }

        scrollUp(driver);
        click(sendoutPartnerMoneygramPageObjects.sourceOfFund(),"Source of Fund Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedSourceOfFund(),"Selected Source of Fund");
        click(sendoutPartnerMoneygramPageObjects.purposeOfTransfer(),"Purpose of Transfer Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedPurposeOfTransfer(),"Selected Purpose of Transfer");
        click(sendoutPartnerMoneygramPageObjects.relationshipWithReceiver(),"Relationship with Receiver Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedRelationshipWithReceiver(),"Selected Relationship with Receiver");
        click(sendoutPartnerMoneygramPageObjects.deliveryOptions(),"Delivery Options Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedDeliveryOptions10MinuteService(),"Selected Delivery Options 10 Minute Service");

        scrollToElement(sendoutPartnerMoneygramPageObjects.sendAmountField());
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Valid Principal Amount field ", propertyReader.getproperty("validAmount"));
        waitSleep(15000);
        click(sendoutPartnerMoneygramPageObjects.submitButton(),"Submit Sendout Button");
        click(sendoutPartnerMoneygramPageObjects.confirmSendoutButton(),"Confirm Sendout Button");
        waitSleep(15000);
        //todo get value of kptn locator and post it to yaml file
        String referenceNumber = getText(sendoutPartnerMoneygramPageObjects.referenceNumber());
        List<String> kptnValues = Collections.singletonList(referenceNumber);
        reader.writeKptnDataWesternUnionPartner10MinuteServiceRemote(kptnValues);
        if(isVisible(sendoutPartnerMoneygramPageObjects.sendoutSuccessfulText(), getText(sendoutPartnerMoneygramPageObjects.sendoutSuccessfulText()))){
            ExtentReporter.logPass("PS_TC_14", "Successfully Sendout Partner Moneygram");
        }else{
            ExtentReporter.logFail("PS_TC_14", "Fail to Verify Sendout Partner Moneygram");
            Assert.fail("Fail to Verify Sendout Partner Moneygram");
        }
        click(sendoutPartnerMoneygramPageObjects.proceedToPrintingButton(),"Proceed to Printing Button");
        click(sendoutPartnerMoneygramPageObjects.cancelInPrintingButton(),"Cancel In Printing Button");

    }




    public void searchKYC () {
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        String[] randomName = reader.getRandomName();
        type(sendOutPageObjects.lastName(), "Lastname ", propertyReader.getproperty("forPartnerLastName"));
        type(sendOutPageObjects.firstName(), "Firstname ", propertyReader.getproperty("forPartnerFirstName"));
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollDown(100);
        scrollToBottomOfPageWEB();
        scrollToElement(sendOutPageObjects.selectKYC());
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
    }

    public void addReceiver () {
        scrollToElement(sendoutPartnerMoneygramPageObjects.searchReceiver());
        click(sendoutPartnerMoneygramPageObjects.searchReceiver(), "Search Receivers Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.addNewReceivers(), "Add new Receiver ");
        waitUntilLoadingGone(10000);
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", propertyReader.getproperty("ReceiverLastName"));
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", propertyReader.getproperty("ReceiverFirstName"));
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", propertyReader.getproperty("ReceiverMiddleName"));
        scrollDown(100);
        waitUntilLoadingGone(10000);
        click(sendoutPartnerMoneygramPageObjects.receiversCountry(), "Receiver's Country");
        click(sendoutPartnerMoneygramPageObjects.countryMalaysia(), "Select Country Malaysia");
        waitSleep(30000);
        click(sendoutPartnerMoneygramPageObjects.birthDateDropDown(), "Receiver Birthdate field ");
        waitSleep(2000);
        type(sendoutPartnerMoneygramPageObjects.birthDateDropDown(), "Receiver Birthdate field ", propertyReader.getproperty("r_birthDate"));
        sendoutPartnerMoneygramPageObjects.birthDateDropDown().sendKeys(Keys.ARROW_LEFT);
        type(sendoutPartnerMoneygramPageObjects.birthDateDropDown(), "Receiver Birthdate field ", propertyReader.getproperty("r_month"));
        sendoutPartnerMoneygramPageObjects.birthDateDropDown().sendKeys(Keys.ARROW_LEFT);
        sendoutPartnerMoneygramPageObjects.birthDateDropDown().sendKeys(Keys.ARROW_LEFT);
        type(sendoutPartnerMoneygramPageObjects.birthDateDropDown(), "Receiver Birthdate field ", propertyReader.getproperty("r_day"));
        click(sendOutPageObjects.r_sex_Field(), "Receiver Sex Field ");
        click(sendOutPageObjects.r_selected_Sex_Field(), "Receiver Selected Sex Field ");
        type(sendoutPartnerMoneygramPageObjects.contactNumberReceiver(),"Receiver's Contact Number", propertyReader.getproperty("Contact_number"));
        scrollUp(driver);
    }







    public void searchRegisteredKYC_Invalid(){
        try{
            type(kycPageObjects.lastName_field(), "Last name field", "");
            type(kycPageObjects.firstName_field(), "First name field", "");
            click(kycPageObjects.searchBtn(), "Search button");
            assertEqual(getText(kycPageObjects.lastName_required()),"LAST NAME IS REQUIRED.");
            assertEqual(getText(kycPageObjects.firstName_required()),"FIRST NAME IS REQUIRED.");
        }catch (Exception e){
            ExtentReporter.logFail("searchRegisteredKYC_Invalid",""+e);
        }
    }


    public void searchRegisteredKYC_Invalid03(){
        try{
            type(kycPageObjects.lastName_field(), "Numeric Last name field", "45645");
            type(kycPageObjects.firstName_field(), "Numeric First name field", "456456");
            click(kycPageObjects.searchBtn(), "Search button");
            ExtentReporter.logPass("searchRegisteredKYC_Invalid03","Can't Input Numbers" +
                    " Cannot proceed to search or No Dat");
        }catch (Exception e){
            ExtentReporter.logFail("searchRegisteredKYC_Invalid03",""+e);
        }
    }
    public void searchRegisteredKYC_Invalid04() {
        try {
            type(kycPageObjects.lastName_field(), "Special Character Last name field", "#$%@$%%#^^");
            type(kycPageObjects.firstName_field(), "Special Character First name field", "#$%@$%%#^^");
            click(kycPageObjects.searchBtn(), "Search button");
            ExtentReporter.logPass("searchRegisteredKYC_Invalid04","Can't Input Special Characters" +
                    "- Cannot proceed to search or No Data");
        }catch (Exception e){
            ExtentReporter.logFail( "searchRegisteredKYC_Invalid04",""+e);
        }
    }
    public void searchRegisteredKYC_Invalid05() {
        try {
            type(kycPageObjects.lastName_field(), "60 Character Last name field", propertyReader.getproperty("MLast_name"));
            type(kycPageObjects.firstName_field(), "60 Character First name field", propertyReader.getproperty("MFirst_name"));
            type(kycPageObjects.middleName_field(), "60 Character Middle name field", propertyReader.getproperty("MMiddle_name"));
            type(kycPageObjects.suffix_field(), "Suffix field", "JRRRR");
            click(kycPageObjects.searchBtn(), "Search button");
            assertEqual(getText(kycPageObjects.lastName_max60()), "MAXIMUM OF 60 CHARACTERS.");
            assertEqual(getText(kycPageObjects.firstName_max60()), "MAXIMUM OF 60 CHARACTERS.");
            ExtentReporter.logPass("searchRegisteredKYC_Invalid05", "Can input only 5 letters in Suffix");
        } catch (Exception e) {
            ExtentReporter.logFail("searchRegisteredKYC_Invalid05", "" + e);
        }
    }

}


