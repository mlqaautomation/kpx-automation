package mlkpx.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class SendoutPartnerMoneygramCancellation_Steps extends Base_Steps{

    public void PSOC_TC_01()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutCancellationPageObjects.sendOutCancellationLink(), "SendOut Cancellation Page ");
        click(sendOutCancellationPageObjects.cancelDropdown(), "Cancel Dropdown");
        waitSleep(1000);
        if(isVisible(sendOutCancellationPageObjects.cancelSendOutText(), getText(sendOutCancellationPageObjects.cancelSendOutText()))){
            LoggingUtils.info("Successfully Navigate for SendOut Cancellation Page ");
        }
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        click(sendoutPartnerMoneygramCancellationPageObjects.partnerButton(),"Partner Button");
        String sendOutPartnerMoneygramKPTN = reader.getSendOutPartnerMoneygram10Min();
        type(sendOutCancellationPageObjects.kptnField(), "KPTN Field", sendOutPartnerMoneygramKPTN);
        click(sendOutCancellationPageObjects.searchButton(),"Search button");
        waitUntilLoadingGone(10000);
        click(sendoutPartnerMoneygramCancellationPageObjects.irNumberField(),"IR Number Field");
        type(sendoutPartnerMoneygramCancellationPageObjects.irNumberField(),"IR Number Field", propertyReader.getproperty("irNumber"));
        click(sendOutCancellationPageObjects.initiatedByOption(),"Initiated By Option");
        click(sendOutCancellationPageObjects.customerOption(),"Customer Option");
        click(sendOutCancellationPageObjects.reasonField(),"Reason");
        click(sendoutPartnerMoneygramCancellationPageObjects.selectedReason(),"No Receive Location Option");
        type(sendoutPartnerMoneygramCancellationPageObjects.detailsField(),"Details Field", propertyReader.getproperty("detailsP"));
        click(sendOutCancellationPageObjects.cancelButton(), "Cancel Button");
        click(sendOutCancellationPageObjects.noKeepTransaction(),"No, Keep Transaction");
        click(sendOutCancellationPageObjects.cancelButton(), "Cancel Button");
        click(sendOutCancellationPageObjects.yesCancelSendout(),"Yes Cancel Sendout");
        if(isVisible(sendoutPartnerMoneygramCancellationPageObjects.partnerSendoutCancelledText(), getText(sendoutPartnerMoneygramCancellationPageObjects.partnerSendoutCancelledText()))){
            LoggingUtils.info("Successfully Cancel the Transaction");
        }else {
            ExtentReporter.logFail("SOC_TC_01", "Failed to Cancel the Transaction");
            Assert.fail("Failed to Cancel the Transaction");
        }
        click(sendoutPartnerMoneygramCancellationPageObjects.proceedPrintingButton(),"Proceed to Printing Button");
        waitSleep(2000);
        click(sendoutPartnerMoneygramCancellationPageObjects.cancelButtonInReceipt(),"Cancel Button");
    }



    public void PSOC_TC_02()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutCancellationPageObjects.sendOutCancellationLink(), "SendOut Cancellation Page ");
        click(sendOutCancellationPageObjects.cancelDropdown(), "Cancel Dropdown");
        click(sendoutPartnerMoneygramCancellationPageObjects.partnerButton(),"Partner Button");
        click(sendOutCancellationPageObjects.kptnField(), "KPTN Field");
        type(sendOutCancellationPageObjects.kptnField(), "KPTN Field ", propertyReader.getproperty("invalidReferenceNumber"));
        click(sendOutCancellationPageObjects.searchButton(), "Search Button");
        if(isVisible(sendOutCancellationPageObjects.noTransactionFoundText(), getText(sendOutCancellationPageObjects.noTransactionFoundText()))){
            LoggingUtils.info("No Transaction Found ");
        }else {
            ExtentReporter.logFail("PSOC_TC_02", "Failed to go Back to the Cancel Sendout Page");
            Assert.fail("Failed to go Back to the Cancel Sendout Page");
        }
        click(sendOutCancellationPageObjects.okButton(),"OK button");

    }
    public void PSOC_TC_03()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutCancellationPageObjects.sendOutCancellationLink(), "SendOut Cancellation Page ");
        click(sendOutCancellationPageObjects.cancelDropdown(), "Cancel Dropdown");
        click(sendoutPartnerMoneygramCancellationPageObjects.partnerButton(),"Partner Button");
        click(sendOutCancellationPageObjects.kptnField(), "KPTN Field");
        type(sendOutCancellationPageObjects.kptnField(), "KPTN Field ", propertyReader.getproperty("cancelledReference"));
        click(sendOutCancellationPageObjects.searchButton(), "Search Button");
        if(isVisible(sendOutCancellationPageObjects.alreadyCancelledText(), getText(sendOutCancellationPageObjects.alreadyCancelledText()))){
            LoggingUtils.info("Sendout transaction has already been cancelled");
        }else {
            ExtentReporter.logFail("SOC_TC_03", "Fail");
            Assert.fail("Fail");
        }
        click(sendOutCancellationPageObjects.okButton(),"OK button");

    }
}
