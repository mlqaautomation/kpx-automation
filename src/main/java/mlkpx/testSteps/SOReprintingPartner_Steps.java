package mlkpx.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class SOReprintingPartner_Steps extends Base_Steps{

    public void SOR_TC_01()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(soReprintingPageObjects.soReprintingLink(), "SendOut Page ");
        if(isVisible(soReprintingPageObjects.soReprintText(), getText(soReprintingPageObjects.soReprintText()))){
            LoggingUtils.info("Successfully Navigate for SendOut Reprint Page ");
        }
//        String randomKPTN = reader.getRandomKPTN(); // Call the getRandomKPTN function
//        type(orReprintingPageObjects.kptnButtonInReprint(), "KPTN Field", randomKPTN); // Use the random KPTN value
        type(soReprintingPageObjects.kptnButtonInReprint(), "KPTN SOReprint field ", propertyReader.getproperty("kptnValidCodeforORSOPartnerMoneygram"));
        type(soReprintingPageObjects.reasonSOReprint(), "Reason SOReprint field ", propertyReader.getproperty("reason_ORandSOReprint"));
        click(soReprintingPageObjects.reprintButton(), "Reprint Button");
        if(isVisible(soReprintingPageObjects.printSendoutReceiptText(), getText(soReprintingPageObjects.printSendoutReceiptText()))){
            ExtentReporter.logPass("SOR_TC_01", "Successfully Validate SO Reprinting");
        }else{
            ExtentReporter.logFail("SOR_TC_01", "Fail to Validate SO Reprinting");
            Assert.fail("Fail to Validate SO Reprinting");
        }
        click(soReprintingPageObjects.cancelButton(), "Cancel Button");
    }
    public void SOR_TC_02()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(soReprintingPageObjects.soReprintingLink(), "SendOut Page ");
        if(isVisible(soReprintingPageObjects.soReprintText(), getText(soReprintingPageObjects.soReprintText()))){
            LoggingUtils.info("Successfully Navigate for SendOut Reprint Page ");
        }
//        String randomKPTN = reader.getRandomKPTN(); // Call the getRandomKPTN function
//        type(orReprintingPageObjects.kptnButtonInReprint(), "KPTN Field", randomKPTN); // Use the random KPTN value
        type(soReprintingPageObjects.kptnButtonInReprint(), "KPTN SOReprint field ", propertyReader.getproperty("kptnValidCodeforORSOPartnerWesternUnion"));
        type(soReprintingPageObjects.reasonSOReprint(), "Reason SOReprint field ", propertyReader.getproperty("reason_ORandSOReprint"));
        click(soReprintingPageObjects.reprintButton(), "Reprint Button");
        if(isVisible(soReprintingPageObjects.printSendoutReceiptText(), getText(soReprintingPageObjects.printSendoutReceiptText()))){
            ExtentReporter.logPass("SOR_TC_01", "Successfully Validate SO Reprinting");
        }else{
            ExtentReporter.logFail("SOR_TC_01", "Fail to Validate SO Reprinting");
            Assert.fail("Fail to Validate SO Reprinting");
        }
    }

    public void SOR_TC_03()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(soReprintingPageObjects.soReprintingLink(), "SendOut Page ");
        if(isVisible(soReprintingPageObjects.soReprintText(), getText(soReprintingPageObjects.soReprintText()))){
            LoggingUtils.info("Successfully Navigate for SendOut Reprint Page ");
        }
        type(soReprintingPageObjects.kptnButtonInReprint(), "KPTN SOReprint field ", propertyReader.getproperty("invalidkptnfield"));
        type(soReprintingPageObjects.reasonSOReprint(), "Reason SOReprint field ", propertyReader.getproperty("reason_ORandSOReprint"));
        click(soReprintingPageObjects.reprintButton(), "Reprint Button");
        if(isVisible(soReprintingPageObjects.noTransactionFoundText(), getText(soReprintingPageObjects.noTransactionFoundText()))){
            ExtentReporter.logPass("SOR_TC_02", "Successfully Validate SO Reprinting with Non-Existing KPTN");
        }else{
            ExtentReporter.logFail("SOR_TC_02", "Fail to Validate SO Reprinting with Non-Existing KPTN");
            Assert.fail("Fail to Validate SO Reprinting with Non-Existing KPTN");
        }
    }
}
