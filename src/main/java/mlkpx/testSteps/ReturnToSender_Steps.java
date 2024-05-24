package mlkpx.testSteps;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;

public class ReturnToSender_Steps extends Base_Steps{

    public void RTS_TC_01()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(returnToSenderPageObjects.rtsNavlink(),"Return to Sender Nav Link");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitUntilLoadingGone(10000);
        String randomKPTN = reader.getSendOutKPTN();
        type(sendOutCancellationPageObjects.kptnField(), "KPTN Field", randomKPTN);
        click(returnToSenderPageObjects.searchButton(), "RTS Search Button");
        if(isVisible(returnToSenderPageObjects.returnToSenderText(), getText(returnToSenderPageObjects.returnToSenderText()))){
            ExtentReporter.logPass("RTS_TC_01", "Successfully Navigate for RTC Page");
        }else{
            ExtentReporter.logFail("RTS_TC_01", "Fail to verify navigation");
            Assert.fail("Fail to verify navigation");
        }
        type(returnToSenderPageObjects.irNo(),"IR Number", propertyReader.getproperty("irnumber"));
        type(returnToSenderPageObjects.reason(),"Return to Sender", propertyReader.getproperty("reasonforchange"));
        click(returnToSenderPageObjects.returnToSenderButton(),"RTS Submit Button");
        click(returnToSenderPageObjects.noKeepTransactionButton(),"No Keep Transaction");
        click(returnToSenderPageObjects.returnToSenderButton(),"RTS Submit Button");
        click(returnToSenderPageObjects.yesReturnToSenderButton(),"Yes Return to Sender");
        if(isVisible(returnToSenderPageObjects.returnToSenderSuccess(), getText(returnToSenderPageObjects.returnToSenderSuccess()))){
            ExtentReporter.logPass("RTS_TC_01", "Successfully Return To Sender");
        }else{
            ExtentReporter.logFail("RTS_TC_01", "Fail to Return To Sender");
            Assert.fail("Fail to Return To Sender");
        }
        click(returnToSenderPageObjects.rtsProceedToPrinting(),"Proceed to Printing");
        click(sendOutPageObjects.cancelButtoninReceipt(),"Cancel button");
    }

    public void RTS_TC_02()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(returnToSenderPageObjects.rtsNavlink(),"Return to Sender Nav Link");
        type(returnToSenderPageObjects.rtsKPTNField(), "RTS KPTN Field ", propertyReader.getproperty("invalidkptnfield"));
        click(returnToSenderPageObjects.searchButton(), "RTS Search Button");
        if(isVisible(returnToSenderPageObjects.returnToSenderText(), getText(returnToSenderPageObjects.returnToSenderText()))){
            ExtentReporter.logPass("RTS_TC_02", "Non-existing KPTN");
        }else{
            ExtentReporter.logFail("RTS_TC_02", "Fail");
            Assert.fail("Fail");
        }
    }

    public void RTS_TC_03()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(returnToSenderPageObjects.rtsNavlink(),"Return to Sender Nav Link");
        type(returnToSenderPageObjects.rtsKPTNField(), "RTS KPTN Field ", propertyReader.getproperty("cancelledkptn"));
        click(returnToSenderPageObjects.searchButton(), "RTS Search Button");
        if(isVisible(returnToSenderPageObjects.returnToSenderText(), getText(returnToSenderPageObjects.returnToSenderText()))){
            ExtentReporter.logPass("RTS_TC_03", "Cancelled KPTN");
        }else{
            ExtentReporter.logFail("RTS_TC_03", "Fail");
            Assert.fail("Fail");
        }
    }

}
