package mlkpx.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;

public class RequestForChangePartner_Steps extends Base_Steps{

    public void RFCP_TC_01()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(requestForChangePageObjects.rfcLink(),"Request for Change Link");
        click(requestForChangePartnerPageObjects.rfcPartnerSendoutLink(), "Request For Change Partner Sendout Link");
        if(isVisible(requestForChangePartnerPageObjects.partnerSendoutAmendmentText(), getText(requestForChangePartnerPageObjects.partnerSendoutAmendmentText()))){
            ExtentReporter.logPass("RFCP_TC_01", "Successfully Navigation of Request for Change Page");
        }else{
            ExtentReporter.logFail("RFCP_TC_01", "Fail to Navigation of Request for Change Page");
            Assert.fail("Fail to Navigation of Request for Change Page");
        }
        click(requestForChangePartnerPageObjects.rfcReferenceNumber(),"RFCP Reference Nimber Field");
        waitSleep(3000);
        reader.refreshTestData();
        waitSleep(3000);
        String forChangePartner = reader.getSendOutPartnerMoneygram10Min();
        type(requestForChangePartnerPageObjects.rfcReferenceNumber(), "RFCP Reference Number Field ", forChangePartner);
        click(requestForChangePageObjects.searchButton(), "RFC Search Button");
        if(isVisible(requestForChangePartnerPageObjects.sendoutTransactionInformationText(), getText(requestForChangePartnerPageObjects.sendoutTransactionInformationText()))){
            ExtentReporter.logPass("RFCP_TC_01", "Successfully Validate Request for Change Partner");
        }else{
            ExtentReporter.logFail("RFCP_TC_01", "Fail to Validate Request for Change Partner");
            Assert.fail("Fail to verify navigation");
        }
        clearField(requestForChangePartnerPageObjects.rfcpMiddleNameField());
        type(requestForChangePartnerPageObjects.rfcpMiddleNameField(),"Middle Name", "Change");

        type(requestForChangePageObjects.irNo(),"IR Number", propertyReader.getproperty("irnumber"));
        click(requestForChangePageObjects.initiatedBy(), "Initiated By");
        click(requestForChangePageObjects.initiatedByCustomer(),"Initiated By Customer");
        click(requestForChangePageObjects.reason(),"Reason for Change");
        click(requestForChangePartnerPageObjects.selectedReasonForChange(),"Selected Reason for Change");
        type(requestForChangePartnerPageObjects.otherDetailsField(),"Middle Name", "Change Middle Name");
        click(requestForChangePageObjects.rfcSubmitButton(),"RFC Submit Button");
        click(requestForChangePageObjects.yesChangeDetailsButton(),"Yes Change Details");
        waitUntilLoadingGone(15000);
        if(isVisible(requestForChangePageObjects.detailsChangeText(), getText(requestForChangePageObjects.detailsChangeText()))){
            ExtentReporter.logPass("RFCP_TC_01", "Successfully Change Details");
        }else{
            ExtentReporter.logFail("RFCP_TC_01", "Fail to Change Details");
            Assert.fail("Fail to Change Details");
        }
        click(requestForChangePageObjects.rfcProceedToPrinting(),"Proceed to Printing");
        click(requestForChangePartnerPageObjects.rfcpCancelButtoninReceipt(),"RFCP Cancel button");
    }
    public void RFCP_TC_02()throws Exception {
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(requestForChangePageObjects.rfcLink(),"Request for Change Link");
        click(requestForChangePartnerPageObjects.rfcPartnerSendoutLink(), "Request For Change Partner Sendout Link");
        waitUntilLoadingGone(10000);
        click(requestForChangePartnerPageObjects.rfcReferenceNumber(),"RFCP Reference Number Field");
        type(requestForChangePartnerPageObjects.rfcReferenceNumber(), "RFCP Reference Number Field", propertyReader.getproperty("rfcpInvalidReferenceNumber"));
        click(requestForChangePageObjects.searchButton(), "RFC Search Button");
        if (isVisible(requestForChangePageObjects.noTransactionFoundText(), getText(requestForChangePageObjects.noTransactionFoundText()))) {
            ExtentReporter.logPass("RFCP_TC_02", "Successfully Validate Request for Change with Non-existing KPTN");
        } else {
            ExtentReporter.logFail("RFCP_TC_02", "Fail to Validate Request for Change with Non-existing KPTN");
            Assert.fail("Fail to Validate Request for Change with Non-existing KPTN");
        }
    }
    public void RFCP_TC_03()throws Exception {
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(requestForChangePageObjects.rfcLink(),"Request for Change Link");
        click(requestForChangePartnerPageObjects.rfcPartnerSendoutLink(), "Request For Change Partner Sendout Link");
        waitUntilLoadingGone(10000);
        click(requestForChangePartnerPageObjects.rfcReferenceNumber(),"RFCP Reference Nimber Field");
        type(requestForChangePartnerPageObjects.rfcReferenceNumber(), "RFCP Reference Nimber Field", propertyReader.getproperty("rfcpCancelledReference"));
        click(requestForChangePageObjects.searchButton(), "RFCP Search Button");
        waitSleep(10000);
        if (isVisible(requestForChangePartnerPageObjects.rfcpCancelledText(), getText(requestForChangePartnerPageObjects.rfcpCancelledText()))) {
            ExtentReporter.logPass("RFCP_TC_03", "Sendout transaction has already been cancelled");
        } else {
            ExtentReporter.logFail("RFCP_TC_03", "Fail");
            Assert.fail("Fail");
        }
        click(requestForChangePageObjects.cancelOKButton(),"Cancel OK Button");
    }
}
