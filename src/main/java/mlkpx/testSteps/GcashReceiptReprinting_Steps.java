package mlkpx.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;

public class GcashReceiptReprinting_Steps extends Base_Steps{


    public void GRR_TC_01() throws Exception{
        click(gcashCashInPageObjects.gcashNav(), "Gcash NavLink");
        click(gcashReceiptReprintingPageObjects.receiptReprinting(), "Gcash Receipt Reprinting NavLink");
        if (isVisible(gcashReceiptReprintingPageObjects.receiptReprintingText(), getText(gcashReceiptReprintingPageObjects.receiptReprintingText()))) {
            ExtentReporter.logPass("GRR_TC_01", "Successfully Navigate Gcash Receipt Reprinting Landing Page");
        } else {
            ExtentReporter.logFail("GRR_TC_01", "Failed to Navigate Gcash Receipt Reprinting Landing Page");
            Assert.fail("Failed to Navigate Gcash Receipt Reprinting Landing Page");
        }
    }
    public void GRR_TC_02() throws Exception{
        GRR_TC_01();
        type(gcashReceiptReprintingPageObjects.referenceNumberField(),"Reference Field", propertyReader.getproperty("validKPTN"));
        click(gcashReceiptReprintingPageObjects.searchButton(),"Search Button");
        if (isVisible(gcashReceiptReprintingPageObjects.receiptPage(), getText(gcashReceiptReprintingPageObjects.receiptPage()))) {
            ExtentReporter.logPass("GRR_TC_02", "Successfully verify Success Gcash Receipt Reprinting");
        } else {
            ExtentReporter.logFail("GRR_TC_02", "Failed to verify success Gcash Receipt Reprinting");
            Assert.fail("Failed to verify success Gcash Receipt Reprinting");
        }
        click(gcashReceiptReprintingPageObjects.cancelButton(),"Cancel Button");
    }
    public void GRR_TC_03() throws Exception{
        GRR_TC_01();
        type(gcashReceiptReprintingPageObjects.referenceNumberField(),"Reference Field", propertyReader.getproperty("invalidKPTN"));
        click(gcashReceiptReprintingPageObjects.searchButton(),"Search Button");
        if (isVisible(gcashReceiptReprintingPageObjects.errorText(), getText(gcashReceiptReprintingPageObjects.errorText()))) {
            ExtentReporter.logPass("GRR_TC_03", "Successfully verify invalid KPTN");
        } else {
            ExtentReporter.logFail("GRR_TC_03", "Failed to verify invalid KPTN");
            Assert.fail("Failed to verify invalid KPTN");
        }
        click(gcashReceiptReprintingPageObjects.okButton(),"OK Button");
    }












}
