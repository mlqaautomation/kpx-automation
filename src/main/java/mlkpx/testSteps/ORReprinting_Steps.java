package mlkpx.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class ORReprinting_Steps extends Base_Steps{
    public void OR_TC_01()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(orReprintingPageObjects.orReprintingLink(), "OR Reprinting Page ");
        if(isVisible(orReprintingPageObjects.orReprintText(), getText(orReprintingPageObjects.orReprintText()))){
            LoggingUtils.info("Successfully Navigate for SendOut Reprint Page ");
        }
//        String randomKPTN = reader.getRandomKPTN(); // Call the getRandomKPTN function
//        type(orReprintingPageObjects.kptnButtonInReprint(), "KPTN Field", randomKPTN); // Use the random KPTN value
        type(orReprintingPageObjects.kptnButtonInReprint(), "KPTN ORReprint field ", propertyReader.getproperty("kptnValidCodeforORSO"));
        type(orReprintingPageObjects.reasonORReprint(), "Reason ORReprint field ", propertyReader.getproperty("reason_ORandSOReprint"));
        click(orReprintingPageObjects.reprintButton(), "Reprint Button");
        if(isVisible(orReprintingPageObjects.printSendoutORReceiptText(), getText(orReprintingPageObjects.printSendoutORReceiptText()))){
            ExtentReporter.logPass("OR_TC_01", "Successfully Validate OR Reprinting");
        }else{
            ExtentReporter.logFail("OR_TC_01", "Fail to Validate OR Reprinting");
            Assert.fail("Fail to Validate OR Reprinting");
        }
    }

    public void OR_TC_02()throws Exception{
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(orReprintingPageObjects.orReprintingLink(), "OR Reprinting  Page ");
        if(isVisible(orReprintingPageObjects.orReprintText(), getText(orReprintingPageObjects.orReprintText()))){
            LoggingUtils.info("Successfully Navigate for SendOut Reprint Page ");
        }
        type(orReprintingPageObjects.kptnButtonInReprint(), "KPTN ORReprint field ", propertyReader.getproperty("invalidkptnfield"));
        type(orReprintingPageObjects.reasonORReprint(), "Reason ORReprint field ", propertyReader.getproperty("reason_ORandSOReprint"));
        click(orReprintingPageObjects.reprintButton(), "Reprint Button");
        if(isVisible(orReprintingPageObjects.noTransactionFoundText(), getText(orReprintingPageObjects.noTransactionFoundText()))){
            ExtentReporter.logPass("OR_TC_02", "Successfully Validate OR Reprinting with Non-Existing KPTN");
        }else{
            ExtentReporter.logFail("OR_TC_02", "Fail to Validate OR Reprinting with Non-Existing KPTN");
            Assert.fail("Fail to Validate OR Reprinting with Non-Existing KPTN");
        }
    }

}
