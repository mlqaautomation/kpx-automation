package mlkpx.testSteps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class SendOutCancellation_Steps extends Base_Steps{

    public void DS_TC_08() throws Exception {
        navigationFOrSendOutDomestic();
        searchKYC();
        searchReceiver();
        waitSleep(5000);
        type(sendOutPageObjects.sourceOfFund(), "Source of Fund field ", propertyReader.getproperty("source_of_fund"));
        type(sendOutPageObjects.purpose(), "Purpose field ", propertyReader.getproperty("purpose"));
        type(sendOutPageObjects.relationToReceiver(), "Relation to Receiver field ", propertyReader.getproperty("relationshiptoreceiver"));
        type(sendOutPageObjects.messageToReceiver(), "Message to Receiver field ", propertyReader.getproperty("messagetoreceiver"));
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ", "200");
        click(sendOutPageObjects.submitSendOut(), "Submit SendOut Button");
        click(sendOutPageObjects.confirmSendOutButton(), "Confirm SendOut Button");
        waitSleep(3000);
        //todo get value of kptn locator and post it to yaml file
        String kptnText = getText(sendOutPageObjects.kptnText());
        List<String> kptnValues = Collections.singletonList(kptnText);
        reader.writeKptnData(kptnValues);
        click(sendOutPageObjects.proceedToPrinting(), "Proceed to Printing");
        waitSleep(2000);
        click(sendOutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
        if (isVisible(sendOutPageObjects.sendOutTransaction(), getText(sendOutPageObjects.sendOutTransaction()))) {
            ExtentReporter.logPass("DS_TC_08", "Successfully Validate Submit SendOut Transaction");
        } else {
            ExtentReporter.logFail("DS_TC_08", "Failed to Validate Submit SendOut Transaction");
            Assert.fail("Validate Submit SendOut Transaction");
        }
    }
    public void SOC_TC_01()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutCancellationPageObjects.sendOutCancellationLink(), "SendOut Cancellation Page ");
        click(sendOutCancellationPageObjects.cancelDropdown(), "Cancel Dropdown");
        waitSleep(1000);
        if(isVisible(sendOutCancellationPageObjects.cancelSendOutText(), getText(sendOutCancellationPageObjects.cancelSendOutText()))){
            LoggingUtils.info("Successfully Navigate for SendOut Cancellation Page ");
        }
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitUntilLoadingGone(10000);
        String  sendoutKPTN = reader.getSendOutKPTN(); // Call the getSendOutKPTN function
        type(sendOutCancellationPageObjects.kptnField(), "KPTN Field", sendoutKPTN); // Use the random KPTN value
        click(sendOutCancellationPageObjects.searchButton(),"Search button");
        waitUntilLoadingGone(10000);
        click(sendOutCancellationPageObjects.irNumberField(),"IR Number Field");
        type(sendOutCancellationPageObjects.irNumberField(),"IR Number Field", propertyReader.getproperty("iRNumber"));
        click(sendOutCancellationPageObjects.initiatedByOption(),"Initiated By Option");
        click(sendOutCancellationPageObjects.customerOption(),"Customer Option");
        type(sendOutCancellationPageObjects.reasonField(),"Reason Field", propertyReader.getproperty("reasonfield"));
        click(sendOutCancellationPageObjects.cancelButton(), "Cancel Button");
        click(sendOutCancellationPageObjects.noKeepTransaction(),"No, Keep Transaction");
        click(sendOutCancellationPageObjects.cancelButton(), "Cancel Button");
        click(sendOutCancellationPageObjects.yesCancelSendout(),"Yes Cancel Sendout");

        if(isVisible(sendOutCancellationPageObjects.cancelSendOutText(), getText(sendOutCancellationPageObjects.cancelSendOutText()))){
            LoggingUtils.info("Successfully Cancel the Transaction");
        }else {
            ExtentReporter.logFail("SOC_TC_01", "Failed to Cancel the Transaction");
            Assert.fail("Failed to Cancel the Transaction");
        }
    }
    public void DS_TC_02_1() throws Exception { // Test Case for Sendout Transaction Option
        navigationFOrSendOutDomestic();
        click(sendOutPageObjects.yesRadioButton(), "Yes Button ");
        waitSleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        type(sendOutPageObjects.lastName(), "Lastname ", propertyReader.getproperty("Lastname"));
        type(sendOutPageObjects.firstName(), "Firstname ", propertyReader.getproperty("Firstname"));
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollToElement(sendOutPageObjects.selectKYC());
        scrollDown(100);
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        waitSleep(5000);
        scrollDown(100);
        searchReceiver();
        waitUntilLoadingGone(10000);
        scrollToElement(sendOutPageObjects.sourceOfFund());
        type(sendOutPageObjects.sourceOfFund(), "Source of Fund field ", propertyReader.getproperty("source_of_fund"));
        type(sendOutPageObjects.purpose(), "Purpose field ", propertyReader.getproperty("purpose"));
        type(sendOutPageObjects.relationToReceiver(), "Relation to Receiver field ", propertyReader.getproperty("relationshiptoreceiver"));
        type(sendOutPageObjects.messageToReceiver(), "Message to Receiver field ", propertyReader.getproperty("messagetoreceiver"));
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ","300");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.submitSendOut(), "Submit SendOut Button");
        click(sendOutPageObjects.confirmSendOutButton(), "Confirm SendOut Button");
        waitSleep(3000);
        //todo get value of kptn locator and post it to yaml file
        String  kptnText = getText(sendOutPageObjects.kptnText());
        List<String> kptnValues = Collections.singletonList(kptnText);
        reader.writeRemoteKptnData(kptnValues);
        click(sendOutPageObjects.proceedToPrinting(), "Proceed to Printing");
        waitSleep(2000);
        click(sendOutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
//        click(sendOutPageObjects.proceedToPrinting(), "Proceed to Printing");
//        waitSleep(3000);
//        if(isVisible(sendOutPageObjects.mainOperator(), getText(sendOutPageObjects.mainOperator()))){
//            ExtentReporter.logPass("DS_TC_02_1", "Successfully Validated Sendout Transaction Option Valid Branch Code");
//        }else{
//            ExtentReporter.logFail("DS_TC_02_1", "Fail to Validated Sendout Transaction Option Valid Branch Code");
//            Assert.fail("Fail to Validated Sendout Transaction Option Valid Branch Code");
//        }
//        click(sendOutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");

    }

    public void SOC_TC_1_01()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutCancellationPageObjects.sendOutCancellationLink(), "SendOut Cancellation Page ");
        click(sendOutCancellationPageObjects.cancelDropdown(), "Cancel Dropdown");
        waitSleep(1000);
        if(isVisible(sendOutCancellationPageObjects.cancelSendOutText(), getText(sendOutCancellationPageObjects.cancelSendOutText()))){
            LoggingUtils.info("Successfully Navigate for SendOut Cancellation Page ");
        }
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        String remotesendoutKPTN = reader.getSendOutRemoteKPTN();
        type(sendOutCancellationPageObjects.kptnField(), "KPTN Field", remotesendoutKPTN); // Use the random KPTN value
        click(sendOutCancellationPageObjects.searchButton(),"Search button");
        waitSleep(2000);
        click(sendOutCancellationPageObjects.irNumberField(),"IR Number Field");
        type(sendOutCancellationPageObjects.irNumberField(),"IR Number Field", propertyReader.getproperty("iRNumber"));
        click(sendOutCancellationPageObjects.initiatedByOption(),"Initiated By Option");
        click(sendOutCancellationPageObjects.customerOption(),"Customer Option");
        type(sendOutCancellationPageObjects.reasonField(),"Reason Field", propertyReader.getproperty("reasonfield"));
        click(sendOutCancellationPageObjects.cancelButton(), "Cancel Button");
        click(sendOutCancellationPageObjects.noKeepTransaction(),"No, Keep Transaction");
        click(sendOutCancellationPageObjects.cancelButton(), "Cancel Button");
        click(sendOutCancellationPageObjects.yesCancelSendout(),"Yes Cancel Sendout");

        if(isVisible(sendOutCancellationPageObjects.cancelSendOutText(), getText(sendOutCancellationPageObjects.cancelSendOutText()))){
            LoggingUtils.info("Successfully Cancel the Transaction");
        }else {
            ExtentReporter.logFail("SOC_TC_01", "Failed to Cancel the Transaction");
            Assert.fail("Failed to Cancel the Transaction");
        }
    }



    public void SOC_TC_02()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutCancellationPageObjects.sendOutCancellationLink(), "SendOut Cancellation Page ");
        click(sendOutCancellationPageObjects.cancelDropdown(), "Cancel Dropdown");
        click(sendOutCancellationPageObjects.kptnField(), "KPTN Field");
        type(sendOutCancellationPageObjects.kptnField(), "KPTN Field ", propertyReader.getproperty("invalidkptnfield"));
        click(sendOutCancellationPageObjects.searchButton(), "Search Button");
        if(isVisible(sendOutCancellationPageObjects.noTransactionFoundText(), getText(sendOutCancellationPageObjects.noTransactionFoundText()))){
            LoggingUtils.info("No Transaction Found ");
        }else {
            ExtentReporter.logFail("SOC_TC_02", "Failed to go Back to the Cancel Sendout Page");
            Assert.fail("Failed to go Back to the Cancel Sendout Page");
        }
        click(sendOutCancellationPageObjects.okButton(),"OK button");

    }
    public void SOC_TC_03()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutCancellationPageObjects.sendOutCancellationLink(), "SendOut Cancellation Page ");
        click(sendOutCancellationPageObjects.cancelDropdown(), "Cancel Dropdown");
        click(sendOutCancellationPageObjects.kptnField(), "KPTN Field");
        type(sendOutCancellationPageObjects.kptnField(), "KPTN Field ", propertyReader.getproperty("kptCancelCode"));
        click(sendOutCancellationPageObjects.searchButton(), "Search Button");
        if(isVisible(sendOutCancellationPageObjects.alreadyCancelledText(), getText(sendOutCancellationPageObjects.alreadyCancelledText()))){
            LoggingUtils.info("Sendout transaction has already been cancelled");
        }else {
            ExtentReporter.logFail("SOC_TC_03", "Fail");
            Assert.fail("Fail");
        }
        click(sendOutCancellationPageObjects.okButton(),"OK button");

    }

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
    public void searchKYC () {
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        String[] randomName = reader.getRandomName();
        type(sendOutPageObjects.lastName(), "Lastname ", randomName[1]);
        type(sendOutPageObjects.firstName(), "Firstname ", randomName[0]);
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
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
        waitSleep(5000);
    }

}
