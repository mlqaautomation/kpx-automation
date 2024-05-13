package mlkpx.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class RequestForChange_Steps extends Base_Steps{
    public void RFC_TC_01()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(requestForChangePageObjects.rfcLink(),"Request for Change Link");
        click(requestForChangePageObjects.domesticRFClink(), "Domestic RFC Link");
//        click(requestForChangePageObjects.idTypeDropDown(),"ID Type DropDown");
//        click(requestForChangePageObjects.idTypeSelected(),"Selected ID Type ");
        click(requestForChangePageObjects.kptnField(),"RFC KPTN Field");
        waitSleep(2000);
        reader.refreshTestData();
        waitSleep(3000);
        String forChange = reader.getSendOutForChange();
        type(requestForChangePageObjects.kptnField(), "RFC KPTN Field ", forChange);
        click(requestForChangePageObjects.searchButton(), "RFC Search Button");
        if(isVisible(requestForChangePageObjects.rfcText(), getText(requestForChangePageObjects.rfcText()))){
            ExtentReporter.logPass("RFC_TC_01", "Successfully Navigate for RFC Page");
        }else{
            ExtentReporter.logFail("RFC_TC_01", "Fail to verify navigation");
            Assert.fail("Fail to verify navigation");
        }
        clearField(requestForChangePageObjects.senderIDNumber());
        type(requestForChangePageObjects.senderIDNumber(),"ID Number", "21103789");
        click(requestForChangePageObjects.senderProvinceChange(),"Sender Province Field");
        click(requestForChangePageObjects.senderNewProvince(),"Sender New Province");
        clearField(requestForChangePageObjects.senderHouseField());
        type(requestForChangePageObjects.senderHouseField(),"Sender House Field", propertyReader.getproperty("senderhouse"));
        type(requestForChangePageObjects.senderHouseNum(),"ID Number", "talamban09");
        scrollDown(100);
        clearField(requestForChangePageObjects.receiverLastNameField());
        type(requestForChangePageObjects.receiverLastNameField(),"Receiver Lastname Field", propertyReader.getproperty("receiverlastname"));
        clearField(requestForChangePageObjects.receiverFirstNameField());
        type(requestForChangePageObjects.receiverFirstNameField(),"Receiver Firstname Field", propertyReader.getproperty("receiverfirstname"));
        clearField(requestForChangePageObjects.receiverMiddleNameField());
        type(requestForChangePageObjects.receiverMiddleNameField(),"Receiver Middlename Field", propertyReader.getproperty("receivermiddlename"));
        click(requestForChangePageObjects.receiverProvinceField(),"Receiver Province Field");
        click(requestForChangePageObjects.receiverNewProvince(),"Receiver New Province");

        clearField(requestForChangePageObjects.receiverHouseField());
        type(requestForChangePageObjects.receiverHouseField(),"Receiver House No", propertyReader.getproperty("receiverhouseno"));
        click(requestForChangePageObjects.receiverNoContactNo(),"Receiver Check No Contact Number");
        scrollUp(driver);
        type(requestForChangePageObjects.irNo(),"IR Number", propertyReader.getproperty("irnumber"));
        click(requestForChangePageObjects.initiatedBy(), "Initiated By");
        click(requestForChangePageObjects.initiatedByCustomer(),"Initiated By Customer");
        type(requestForChangePageObjects.reason(),"Reason for Change", propertyReader.getproperty("reasonforchange"));
        waitSleep(5000);
        click(requestForChangePageObjects.rfcSubmitButton(),"RFC Submit Button");
        waitSleep(3000);
        click(requestForChangePageObjects.yesChangeDetailsButton(),"Yes Change Details");
        waitSleep(3000);
        if(isVisible(requestForChangePageObjects.detailsChangeText(), getText(requestForChangePageObjects.detailsChangeText()))){
            ExtentReporter.logPass("RFC_TC_01", "Successfully Change Details");
        }else{
            ExtentReporter.logFail("RFC_TC_01", "Fail to Change Details");
            Assert.fail("Fail to Change Details");
        }
        click(requestForChangePageObjects.rfcProceedToPrinting(),"Proceed to Printing");
        click(sendOutPageObjects.cancelButtoninReceipt(),"Cancel button");
    }
    public void RFC_TC_02()throws Exception {
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(requestForChangePageObjects.rfcLink(), "Request for Change Link");
        click(requestForChangePageObjects.domesticRFClink(), "Domestic RFC Link");
        waitSleep(3000);
        click(requestForChangePageObjects.kptnField(), "RFC KPTN Field");
        type(requestForChangePageObjects.kptnField(), "RFC KPTN Field ", propertyReader.getproperty("invalidkptnfield"));
        click(requestForChangePageObjects.searchButton(), "RFC Search Button");
        if (isVisible(requestForChangePageObjects.noTransactionFoundText(), getText(requestForChangePageObjects.noTransactionFoundText()))) {
            ExtentReporter.logPass("RFC_TC_02", "Validate Request for Change with Non-existing KPTN");
        } else {
            ExtentReporter.logFail("RFC_TC_02", "Fail");
            Assert.fail("Fail");
        }
    }
    public void RFC_TC_03()throws Exception {
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(requestForChangePageObjects.rfcLink(), "Request for Change Link");
        click(requestForChangePageObjects.domesticRFClink(), "Domestic RFC Link");
        waitSleep(3000);
        click(requestForChangePageObjects.kptnField(), "RFC KPTN Field");
        type(requestForChangePageObjects.kptnField(), "RFC KPTN Field ", propertyReader.getproperty("cancelledkptn"));
        click(requestForChangePageObjects.searchButton(), "RFC Search Button");
        if (isVisible(requestForChangePageObjects.sendoutCancelledText(), getText(requestForChangePageObjects.sendoutCancelledText()))) {
            ExtentReporter.logPass("RFC_TC_03", "Sendout transaction has already been cancelled");
        } else {
            ExtentReporter.logFail("RFC_TC_03", "Fail");
            Assert.fail("Fail");
        }
        click(requestForChangePageObjects.cancelOKButton(),"Cancel OK Button");
    }
}
