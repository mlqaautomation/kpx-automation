package mlkpx.testSteps;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class SendOutNegativeTest_Steps extends Base_Steps{
    public void navigationFOrSendOutDomestic() throws Exception {
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
    }

    public void DS_TC_01() throws Exception { //Test Case for Verify Navigation for SendOut Domestic
        navigationFOrSendOutDomestic();
        if (isVisible(sendOutPageObjects.sendOutTransaction(), getText(sendOutPageObjects.sendOutTransaction()))) {
            ExtentReporter.logPass("DS_TC_01", "Successfully Validated SendOut Domestic Page Navigation");
            LoggingUtils.info("Successfully Navigate for SendOut Domestic Page ");
        } else {
            ExtentReporter.logFail("DS_TC_01", "Failed to Validate SendOut Domestic Page Navigation");
            LoggingUtils.info("Failed to Validate SendOut Domestic Page Navigation ");
        }
    }

    public void DS_TC_02() throws Exception { // Test Case for Sendout Transaction Option Invalid Branch Code
        navigationFOrSendOutDomestic();
        click(sendOutPageObjects.yesRadioButton(), "Yes Button ");
        waitSleep(3000);
        type(sendOutPageObjects.branchField(), "Branch Code Field", propertyReader.getproperty("invalidBranch_code"));
        waitSleep(2000); //hard wait for 2 seconds
        isVisible(sendOutPageObjects.branchNotFoundText(), "Branch not found text");
        if(isVisible(sendOutPageObjects.branchNotFoundText(), getText(sendOutPageObjects.branchNotFoundText()))){
            ExtentReporter.logPass("DS_TC_02", "Successfully Verify SendOut Transaction Option Invalid Branch Code");
        }else{
            ExtentReporter.logFail("DS_TC_02", "Fail to Verify SendOut Transaction Option Invalid Branch Code");
            Assert.fail("Fail to Verify SendOut Transaction Option Valid Branch Code");
        }
    }
    public void DS_TC_03_1() throws Exception {
        navigationFOrSendOutDomestic();
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        searchRegisteredKYC_Invalid();
        searchRegisteredKYC_Invalid03();
        searchRegisteredKYC_Invalid04();
        searchRegisteredKYC_Invalid05();
    }

    public void DS_TC_04_1() throws Exception {
        navigationFOrSendOutDomestic();
        searchKYC();
        click(sendOutPageObjects.searchReceivers(), "Search Receivers Button ");
        click(sendOutPageObjects.addNewReceivers(), "Add new Receiver ");
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", propertyReader.getproperty("MLast_name"));
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", propertyReader.getproperty("MFirst_name"));
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", propertyReader.getproperty("MFirst_name"));
        type(sendOutPageObjects.principalAmount(),"Principal Amount", propertyReader.getproperty("principalAmount"));
        click(sendOutPageObjects.submitSendOut(),"Submit Sendout Button");
        if(isVisible(sendOutPageObjects.receiversMaximumLettersDangerText(), getText(sendOutPageObjects.receiversMaximumLettersDangerText()))){
            ExtentReporter.logPass("DS_TC_04_1", "Successfully Verify Add Receiver New Negative Test");
        }else{
            ExtentReporter.logFail("DS_TC_04_1", "Fail to Verify Add Receiver New Negative Test");
            Assert.fail("Fail to Verify Add Receiver New Negative Test");
        }

    }

    public void DS_TC_07() throws Exception {
        navigationFOrSendOutDomestic();
        searchKYC();
        searchReceiver();
        scrollUp(driver);
        click(sendOutPageObjects.sourceOfFund(), "Source of Fund field ");
        type(sendOutPageObjects.sourceOfFund(), "Source of Fund field ", propertyReader.getproperty("source_of_fund"));
        type(sendOutPageObjects.purpose(), "Purpose field ", propertyReader.getproperty("purpose"));
        type(sendOutPageObjects.relationToReceiver(), "Relation to Receiver field ", propertyReader.getproperty("relationshiptoreceiver"));
        type(sendOutPageObjects.messageToReceiver(), "Message to Receiver field ", propertyReader.getproperty("messagetoreceiver"));
        assertEqual(getValue(sendOutPageObjects.sourceOfFund()), propertyReader.getproperty("source_of_fund"));
        assertEqual(getValue(sendOutPageObjects.purpose()), propertyReader.getproperty("purpose"));
        assertEqual(getValue(sendOutPageObjects.relationToReceiver()), propertyReader.getproperty("relationshiptoreceiver"));
        assertEqual(getValue(sendOutPageObjects.messageToReceiver()), propertyReader.getproperty("messagetoreceiver"));
        scrollToElement(sendOutPageObjects.principalAmount());
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ", propertyReader.getproperty("principal_amount_empty"));
        click(sendOutPageObjects.chargeText(), "Charge Text");
        if (isVisible(sendOutPageObjects.emptyValueText(), getText((sendOutPageObjects.emptyValueText())))) {
            ExtentReporter.logPass("Empty Value", "Valid Amount is required");
        }
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ", propertyReader.getproperty("principal_amount0"));
        if (isVisible(sendOutPageObjects.display0Text(), getText((sendOutPageObjects.display0Text())))) {
            ExtentReporter.logPass("Input Amount (Zero)", "Min allowed amount is PHP 1.00");
        }
        clearField(sendOutPageObjects.principalAmount());
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ", propertyReader.getproperty("negative_principal_amount"));
        if (isVisible(sendOutPageObjects.negativeDisplayText(), getText((sendOutPageObjects.negativeDisplayText())))) {
            ExtentReporter.logPass("Input Amount (Negative Value)", "Value must be greater than or equal to 0");
        }
        clearField(sendOutPageObjects.principalAmount());

        type(sendOutPageObjects.principalAmount(), "Valid Principal Amount field ", propertyReader.getproperty("firstAmount"));
        waitSleep(3000);
        assertEqual(getText(sendOutPageObjects.chargeAmount()), propertyReader.getproperty("minCharge"));
        clearField(sendOutPageObjects.principalAmount());

        type(sendOutPageObjects.principalAmount(), "Valid Principal Amount field ", propertyReader.getproperty("lastAmount"));
        waitSleep(3000);
        assertEqual(getText(sendOutPageObjects.chargeAmount()), propertyReader.getproperty("maxCharge"));
        waitSleep(3000);

        if (isTotalCorrect()) {
            ExtentReporter.logPass("Total Computation", "is Correct");
        } else {
            ExtentReporter.logFail("Total Computation", "is not Correct");
            Assert.fail("Total Computation is not correct");
        }
    }

    public void DS_TC_09() throws Exception {
        principalAmount();
        click(sendOutPageObjects.cancelButton(), "Cancel SendOut Button");
        click(sendOutPageObjects.noStayOnThisPage(), "No Stay On This Page");
        waitSleep(3000);
        if (isVisible(sendOutPageObjects.messageToReceiver(), getText(sendOutPageObjects.messageToReceiver()))) {
            ExtentReporter.logPass("DS_TC_09", "Successfully Stay on the sendout page and inputted data will not be cleared");
        } else {
            ExtentReporter.logFail("DS_TC_09", "Failed to Stay on the sendout page and inputted data will not be cleared");
            Assert.fail("Failed Stay on the sendout page and inputted data will not be cleared");
        }
        click(sendOutPageObjects.cancelButton(), "Cancel SendOut Button");
        click(sendOutPageObjects.yesCancelTransaction(), "Yes Cancel Transaction");
    }
    public void DS_TC_10 ()throws Exception {
        principalAmount();
        click(sendOutPageObjects.submitSendOut(), "Submit SendOut Button");
        click(sendOutPageObjects.cancelButtoninConfirmation(), "Cancel Button");
        waitSleep(3000);
        if (sendOutPageObjects.messageToReceiver().isEnabled()) {
            ExtentReporter.logPass("DS_TC_10", "Successfully redirected to the SendOut Domestic Page");;
        } else {
            ExtentReporter.logFail("DS_TC_10", "Failed to redirect to the SendOut Domestic Page");
            Assert.fail("Failed to redirect to the SendOut Domestic Page");
        }
    }
    public void DS_TC_11 ()throws Exception {
        navigationFOrSendOutDomestic();
        searchWatchListKYC();
        searchReceiver();
        waitSleep(2000);
        type(sendOutPageObjects.sourceOfFund(), "Source of Fund field ", propertyReader.getproperty("source_of_fund"));
        type(sendOutPageObjects.purpose(), "Purpose field ", propertyReader.getproperty("purpose"));
        type(sendOutPageObjects.relationToReceiver(), "Relation to Receiver field ", propertyReader.getproperty("relationshiptoreceiver"));
        type(sendOutPageObjects.messageToReceiver(), "Message to Receiver field ", propertyReader.getproperty("messagetoreceiver"));
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ", propertyReader.getproperty("valid_principal_amount"));
        click(sendOutPageObjects.submitSendOut(), "Submit SendOut Button");
        click(sendOutPageObjects.confirmSendOutButton(), "Confirm SendOut Button");
        waitSleep(4000);
        if (isVisible(sendOutPageObjects.complianceText(), getText(sendOutPageObjects.complianceText()))) {
            ExtentReporter.logPass("DS_TC_11", "Successfully validate kyc from the Watch List");
        } else {
            ExtentReporter.logFail("DS_TC_11", "Failed to validate kyc from the Watch List");
            Assert.fail("Failed to validate kyc from the Watch List");
        }
        click(sendOutPageObjects.complianceOKButton(), "Compliance Button");

    }

    public void DS_TC_12 ()throws Exception {
        navigationFOrSendOutDomestic();
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        type(sendOutPageObjects.lastName(), "Lastname Field", propertyReader.getproperty("theSameTransactionLastName"));
        type(sendOutPageObjects.firstName(), "Firstname Field", propertyReader.getproperty("theSameTransactionFirstName"));
        type(sendOutPageObjects.middleName(), "Middlename Field", propertyReader.getproperty("theSameTransactionMiddleName"));
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitSleep(2000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollToElement(sendOutPageObjects.selectKYC());
        scrollDown(100);
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        click(sendOutPageObjects.searchReceivers(), "Search Receivers Button ");
        waitSleep(5000);
        scrollToElement(sendOutPageObjects.selectButton());
        click(sendOutPageObjects.selectButton(), "Select Button");
        scrollToElement(sendOutPageObjects.no_ContactNo());
        click(sendOutPageObjects.no_ContactNo(), "Contact No Checkbox");
        type(sendOutPageObjects.sourceOfFund(), "Source of Fund field ", propertyReader.getproperty("source_of_fund"));
        waitSleep(3000);
        type(sendOutPageObjects.purpose(), "Purpose field ", propertyReader.getproperty("purpose"));
        type(sendOutPageObjects.relationToReceiver(), "Relation to Receiver field ", propertyReader.getproperty("relationshiptoreceiver"));
        type(sendOutPageObjects.messageToReceiver(), "Message to Receiver field ", propertyReader.getproperty("messagetoreceiver"));
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ", propertyReader.getproperty("valid_principal_amount"));
        waitSleep(3000);
        click(sendOutPageObjects.submitSendOut(), "Submit SendOut Button");
        click(sendOutPageObjects.confirmSendOutButton(), "Confirm SendOut Button");
        click(sendOutPageObjects.proceedToPrinting(), "Proceed to Printing");
        waitSleep(2000);
        click(sendOutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
        waitSleep(10000);

        navigationFOrSendOutDomestic();
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        type(sendOutPageObjects.lastName(), "Lastname Field", propertyReader.getproperty("theSameTransactionLastName"));
        type(sendOutPageObjects.firstName(), "Firstname Field", propertyReader.getproperty("theSameTransactionFirstName"));
        type(sendOutPageObjects.middleName(), "Middlename Field", propertyReader.getproperty("theSameTransactionMiddleName"));
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitSleep(2000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollToElement(sendOutPageObjects.selectKYC());
        scrollDown(100);
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        click(sendOutPageObjects.searchReceivers(), "Search Receivers Button ");
        waitSleep(5000);
        scrollToElement(sendOutPageObjects.selectButton());
        click(sendOutPageObjects.selectButton(), "Select Button");
        scrollToElement(sendOutPageObjects.no_ContactNo());
        click(sendOutPageObjects.no_ContactNo(), "Contact No Checkbox");
        type(sendOutPageObjects.sourceOfFund(), "Source of Fund field ", propertyReader.getproperty("source_of_fund"));
        waitSleep(3000);
        type(sendOutPageObjects.purpose(), "Purpose field ", propertyReader.getproperty("purpose"));
        type(sendOutPageObjects.relationToReceiver(), "Relation to Receiver field ", propertyReader.getproperty("relationshiptoreceiver"));
        type(sendOutPageObjects.messageToReceiver(), "Message to Receiver field ", propertyReader.getproperty("messagetoreceiver"));
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ", propertyReader.getproperty("valid_principal_amount"));
        waitSleep(3000);
        click(sendOutPageObjects.submitSendOut(), "Submit SendOut Button");
        click(sendOutPageObjects.confirmSendOutButton(), "Confirm SendOut Button");
        waitSleep(3000);
        if (isVisible(sendOutPageObjects.theSameTransactionText(), getText(sendOutPageObjects.theSameTransactionText()))) {
            ExtentReporter.logPass("DS_TC_12", "Successfully validate the same transaction");
        } else {
            ExtentReporter.logFail("DS_TC_12", "Failed to validate the same transaction");
            Assert.fail("Failed to validate kyc from the Watch List");
        }
        click(sendOutPageObjects.theSameTransactionOKButton(), "The same Transaction Button");
    }


    public void principalAmount() throws Exception {
        navigationFOrSendOutDomestic();
        searchKYC();
        searchReceiver();
        scrollUp(driver);
        click(sendOutPageObjects.sourceOfFund(), "Source of Fund field ");
        type(sendOutPageObjects.sourceOfFund(), "Source of Fund field ", propertyReader.getproperty("source_of_fund"));
        type(sendOutPageObjects.purpose(), "Purpose field ", propertyReader.getproperty("purpose"));
        type(sendOutPageObjects.relationToReceiver(), "Relation to Receiver field ", propertyReader.getproperty("relationshiptoreceiver"));
        type(sendOutPageObjects.messageToReceiver(), "Message to Receiver field ", propertyReader.getproperty("messagetoreceiver"));
        assertEqual(getValue(sendOutPageObjects.sourceOfFund()), propertyReader.getproperty("source_of_fund"));
        assertEqual(getValue(sendOutPageObjects.purpose()), propertyReader.getproperty("purpose"));
        assertEqual(getValue(sendOutPageObjects.relationToReceiver()), propertyReader.getproperty("relationshiptoreceiver"));
        assertEqual(getValue(sendOutPageObjects.messageToReceiver()), propertyReader.getproperty("messagetoreceiver"));
        scrollToElement(sendOutPageObjects.principalAmount());
        type(sendOutPageObjects.principalAmount(), "Valid Principal Amount field ", propertyReader.getproperty("lastAmount"));
        waitSleep(3000);
        assertEqual(getText(sendOutPageObjects.chargeAmount()), propertyReader.getproperty("maxCharge"));
        waitSleep(3000);

        if (isTotalCorrect()) {
            ExtentReporter.logPass("Total Computation", "is Correct");
        } else {
            ExtentReporter.logFail("Total Computation", "is not Correct");
            Assert.fail("Total Computation is not correct");
        }
    }

    public boolean isTotalCorrect () throws Exception {
        double principalAmt = parseTotalValue(getValue(sendOutPageObjects.principalAmount()));
        double chargeAmt = parseTotalValue(getText(sendOutPageObjects.chargeAmount()));
        double otherChargeAmt = parseTotalValue(getText(sendOutPageObjects.otherChargeAmount()));
        double totalAmt = parseTotalValue(getText(sendOutPageObjects.totalAmount()));
        double expectedTotal = principalAmt + chargeAmt + otherChargeAmt;
        assertEqual(totalAmt, expectedTotal);
        LoggingUtils.info("Expected total: " + expectedTotal + ", actual: " + totalAmt);
        return Math.abs(expectedTotal - totalAmt) < 0.0001;
    }

    public void searchKYC () {
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        String[] randomName = reader.getRandomName();
        type(sendOutPageObjects.lastName(), "Lastname ", randomName[1]);
        type(sendOutPageObjects.firstName(), "Firstname ", randomName[0]);
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitSleep(2000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollToElement(sendOutPageObjects.selectKYC());
        scrollDown(100);
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
    }
    public void searchWatchListKYC () {
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        type(sendOutPageObjects.lastName(), "Lastname Field", propertyReader.getproperty("watchListKYCLastName"));
        type(sendOutPageObjects.firstName(), "Firstname Field", propertyReader.getproperty("watchListKYCFirstName"));
        type(sendOutPageObjects.middleName(), "Middlename Field", propertyReader.getproperty("watchListKYCMiddleName"));
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitSleep(2000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollToElement(sendOutPageObjects.selectKYC());
        scrollDown(100);
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
    }


    public void searchReceiver () {
        click(sendOutPageObjects.searchReceivers(), "Search Receivers Button ");
        scrollToElement(sendOutPageObjects.selectButton());
        click(sendOutPageObjects.selectButton(), "Select Button");
        scrollToElement(sendOutPageObjects.no_ContactNo());
        click(sendOutPageObjects.no_ContactNo(), "Contact No Checkbox");
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
            assertEqual(getText(kycPageObjects.lastName_max60()),"MAXIMUM OF 60 CHARACTERS.");
            assertEqual(getText(kycPageObjects.firstName_max60()),"MAXIMUM OF 60 CHARACTERS.");
            ExtentReporter.logPass("searchRegisteredKYC_Invalid05","Can input only 5 letters in Suffix");
        }catch (Exception e){
            ExtentReporter.logFail("searchRegisteredKYC_Invalid05",""+e);
        }
    }
}
