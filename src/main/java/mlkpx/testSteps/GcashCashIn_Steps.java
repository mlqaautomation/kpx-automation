package mlkpx.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;

public class GcashCashIn_Steps extends Base_Steps{

    public void GCI_TC_01() throws Exception{
        click(gcashCashInPageObjects.gcashNav(), "Gcash NavLink");
        if (isVisible(gcashCashInPageObjects.cashInText(), getText(gcashCashInPageObjects.cashInText()))) {
            ExtentReporter.logPass("GCI_TC_01", "Successfully Navigate Gcash Landing Page");
        } else {
            ExtentReporter.logFail("GCI_TC_01", "Failed to Navigate Gcash Landing Page");
            Assert.fail("Failed to Navigate Gcash Landing Page");
        }
    }
    public void GCI_TC_02() throws Exception{
        click(gcashCashInPageObjects.gcashNav(), "Gcash NavLink");
        click(gcashCashInPageObjects.cashInNav(), "Gcash Cash In NavLink");
        if (isVisible(gcashCashInPageObjects.cashInText(), getText(gcashCashInPageObjects.cashInText()))) {
            ExtentReporter.logPass("GCI_TC_02", "Successfully Navigate Gcash Cash In Page");
        } else {
            ExtentReporter.logFail("GCI_TC_02", "Failed to Navigate Gcash Cash In Page");
            Assert.fail("Failed to Navigate Gcash Cash In Page");
        }
    }
    public void GCI_TC_03() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("validReceiverGcashNumber"));
        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("validSenderGcashNumber"));
        waitSleep(5000);
        type(gcashCashInPageObjects.principalAmount(), "Principal Amount Field", propertyReader.getproperty("gcashPrincipalAmount"));
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        click(gcashCashInPageObjects.confirmButton(), "Confirm Button");
        waitSleep(5000);

        if (isVisible(gcashCashInPageObjects.cashInSuccessfulText(), getText(gcashCashInPageObjects.cashInSuccessfulText()))) {
            ExtentReporter.logPass("GCI_TC_03", "Successfully verify Successful Cash In Transaction");
        } else {
            ExtentReporter.logFail("GCI_TC_03", "Failed to verify Successful Cash In Transaction");
            Assert.fail("Failed to verify Successful Cash In Transaction");
        }
        click(gcashCashInPageObjects.proceedButton(),"Proceed Button");
        click(gcashCashInPageObjects.cancelInReceiptButton(),"Cancel  Button");

    }
    public void GCI_TC_04() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("invalidReceiverGcashNumber"));
        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("validSenderGcashNumber"));
        waitSleep(5000);
        type(gcashCashInPageObjects.principalAmount(), "Principal Amount Field", propertyReader.getproperty("gcashPrincipalAmount"));
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        try{
            isVisible(gcashCashInPageObjects.existingSimilarTransactionModal(), "Existing Similar Transaction Modal");
            click(gcashCashInPageObjects.yesProceedTransaction(),"Yes, Proceed Transaction Button");
            click(gcashCashInPageObjects.confirmButton(),"Confirm Cash In Button");
        }catch(Exception e){
            click(gcashCashInPageObjects.confirmButton(), "Confirm Button");
        }
        waitSleep(10000);
        if (isVisible(gcashCashInPageObjects.unableToProcessCashInTransactionText(), getText(gcashCashInPageObjects.unableToProcessCashInTransactionText()))) {
            ExtentReporter.logPass("GCI_TC_04", "Successfully verify Receiver Invalid Phone Number ");
        } else {
            ExtentReporter.logFail("GCI_TC_04", "Failed to verify Receiver Invalid Phone Number ");
            Assert.fail("Failed to verify Receiver Invalid Phone Number ");
        }
        click(gcashCashInPageObjects.okButton(),"OK Button");
    }
    public void GCI_TC_05() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("validReceiverGcashNumber"));
        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("invalidSenderGcashNumber"));
        waitSleep(5000);
        type(gcashCashInPageObjects.senderFirstName(), "Sender FirstName Field", propertyReader.getproperty("senderFirstName"));
        type(gcashCashInPageObjects.senderMiddleName(), "Sender MiddleName Field", propertyReader.getproperty("senderMiddleName"));
        type(gcashCashInPageObjects.senderLastName(), "Sender LastName Field", propertyReader.getproperty("senderLastName"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Month Field", propertyReader.getproperty("senderBirthMonth"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Date Field", propertyReader.getproperty("senderBirthDate"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Year Field", propertyReader.getproperty("senderBirthYear"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Email Address Field", propertyReader.getproperty("senderEmailAddress"));

        type(gcashCashInPageObjects.principalAmount(), "Principal Amount Field", propertyReader.getproperty("gcashPrincipalAmount"));
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        try{
            isVisible(gcashCashInPageObjects.existingSimilarTransactionModal(), "Existing Similar Transaction Modal");
            click(gcashCashInPageObjects.yesProceedTransaction(),"Yes, Proceed Transaction Button");
            click(gcashCashInPageObjects.confirmButton(),"Confirm Cash In Button");
        }catch(Exception e){
            click(gcashCashInPageObjects.confirmButton(), "Confirm Button");
        }
        waitSleep(10000);
        if (isVisible(gcashCashInPageObjects.unableToProcessCashInTransactionText(), getText(gcashCashInPageObjects.unableToProcessCashInTransactionText()))) {
            ExtentReporter.logPass("GCI_TC_05", "Successfully verify Sender Invalid Phone Number ");
        } else {
            ExtentReporter.logFail("GCI_TC_05", "Failed to verify Sender Invalid Phone Number ");
            Assert.fail("Failed to verify Sender Invalid Phone Number ");
        }
        click(gcashCashInPageObjects.okButton(),"OK Button");
    }
//    public void GCI_TC_06() throws Exception {
//
//    }

    public void GCI_TC_07() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("validSenderGcashNumber"));
        waitSleep(5000);
        type(gcashCashInPageObjects.principalAmount(), "Principal Amount Field", propertyReader.getproperty("gcashPrincipalAmount"));
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        if (isVisible(gcashCashInPageObjects.receiverMobileNumberIsRequiredText(), getText(gcashCashInPageObjects.receiverMobileNumberIsRequiredText()))) {
            ExtentReporter.logPass("GCI_TC_07", "Successfully verify Empty Receivers Mobile number");
        } else {
            ExtentReporter.logFail("GCI_TC_07", "Failed to verify Empty Receivers Mobile number");
            Assert.fail("Failed to verify Empty Receivers Mobile number");
        }
    }

    public void GCI_TC_08() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("validReceiverGcashNumber"));
        type(gcashCashInPageObjects.senderFirstName(), "Sender FirstName Field", propertyReader.getproperty("senderFirstName"));
        type(gcashCashInPageObjects.senderMiddleName(), "Sender MiddleName Field", propertyReader.getproperty("senderMiddleName"));
        type(gcashCashInPageObjects.senderLastName(), "Sender LastName Field", propertyReader.getproperty("senderLastName"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Month Field", propertyReader.getproperty("senderBirthMonth"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Date Field", propertyReader.getproperty("senderBirthDate"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Year Field", propertyReader.getproperty("senderBirthYear"));
        waitSleep(5000);
        type(gcashCashInPageObjects.senderEmail(), "Sender Email Address Field", propertyReader.getproperty("senderEmailAddress"));
        type(gcashCashInPageObjects.principalAmount(), "Principal Amount Field", propertyReader.getproperty("gcashPrincipalAmount"));
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
    }
    public void GCI_TC_09() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("validReceiverGcashNumber"));
        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("notRegisteredSenderGcashNumber"));

        type(gcashCashInPageObjects.senderMiddleName(), "Sender MiddleName Field", propertyReader.getproperty("senderMiddleName"));
        type(gcashCashInPageObjects.senderLastName(), "Sender LastName Field", propertyReader.getproperty("senderLastName"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Month Field", propertyReader.getproperty("senderBirthMonth"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Date Field", propertyReader.getproperty("senderBirthDate"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Year Field", propertyReader.getproperty("senderBirthYear"));
        waitSleep(5000);
        type(gcashCashInPageObjects.senderEmail(), "Sender Email Address Field", propertyReader.getproperty("senderEmailAddress"));
        type(gcashCashInPageObjects.principalAmount(), "Principal Amount Field", propertyReader.getproperty("gcashPrincipalAmount"));
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        if (isVisible(gcashCashInPageObjects.firstNameIsRequired(), getText(gcashCashInPageObjects.firstNameIsRequired()))) {
            ExtentReporter.logPass("GCI_TC_09", "Successfully verify No Firstname Provided");
        } else {
            ExtentReporter.logFail("GCI_TC_09", "Failed to verify No Firstname Provided");
            Assert.fail("Failed to verify No Firstname Provided");
        }

    }
    public void GCI_TC_10() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("validReceiverGcashNumber"));
        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("notRegisteredSenderGcashNumber"));

        type(gcashCashInPageObjects.senderFirstName(), "Sender Firstname Field", propertyReader.getproperty("senderFirstName"));
        type(gcashCashInPageObjects.senderLastName(), "Sender LastName Field", propertyReader.getproperty("senderLastName"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Month Field", propertyReader.getproperty("senderBirthMonth"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Date Field", propertyReader.getproperty("senderBirthDate"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Year Field", propertyReader.getproperty("senderBirthYear"));
        waitSleep(5000);
        type(gcashCashInPageObjects.senderEmail(), "Sender Email Address Field", propertyReader.getproperty("senderEmailAddress"));
        type(gcashCashInPageObjects.principalAmount(), "Principal Amount Field", propertyReader.getproperty("gcashPrincipalAmount"));
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        if (isVisible(gcashCashInPageObjects.middleNameIsRequired(), getText(gcashCashInPageObjects.middleNameIsRequired()))) {
            ExtentReporter.logPass("GCI_TC_10", "Successfully verify No Middlename Provided(uncheck box)");
        } else {
            ExtentReporter.logFail("GCI_TC_10", "Failed to verify No Middlename Provided(uncheck box)");
            Assert.fail("Failed to verify No Middlename Provided(uncheck box)");
        }

    }
    public void GCI_TC_11() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("validReceiverGcashNumber"));
        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("notRegisteredSenderGcashNumber"));

        type(gcashCashInPageObjects.senderFirstName(), "Sender Firstname Field", propertyReader.getproperty("senderFirstName"));
        type(gcashCashInPageObjects.senderMiddleName(), "Sender MiddleName Field", propertyReader.getproperty("senderMiddleName"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Month Field", propertyReader.getproperty("senderBirthMonth"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Date Field", propertyReader.getproperty("senderBirthDate"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Year Field", propertyReader.getproperty("senderBirthYear"));
        waitSleep(5000);
        type(gcashCashInPageObjects.senderEmail(), "Sender Email Address Field", propertyReader.getproperty("senderEmailAddress"));
        type(gcashCashInPageObjects.principalAmount(), "Principal Amount Field", propertyReader.getproperty("gcashPrincipalAmount"));
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        if (isVisible(gcashCashInPageObjects.lastNameIsRequired(), getText(gcashCashInPageObjects.lastNameIsRequired()))) {
            ExtentReporter.logPass("GCI_TC_11", "Successfully verify No Lastname Provided");
        } else {
            ExtentReporter.logFail("GCI_TC_11", "Failed to verify No Lastname Provided");
            Assert.fail("Failed to verify No Lastname Provided");
        }

    }
    public void GCI_TC_12() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("validReceiverGcashNumber"));
        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("notRegisteredSenderGcashNumber"));

        type(gcashCashInPageObjects.senderFirstName(), "Sender Firstname Field", propertyReader.getproperty("senderFirstName"));
        type(gcashCashInPageObjects.senderMiddleName(), "Sender MiddleName Field", propertyReader.getproperty("senderMiddleName"));
        type(gcashCashInPageObjects.senderLastName(), "Sender LastName Field", propertyReader.getproperty("senderLastName"));
        type(gcashCashInPageObjects.senderEmail(), "Sender Email Address Field", propertyReader.getproperty("senderEmailAddress"));
        type(gcashCashInPageObjects.principalAmount(), "Principal Amount Field", propertyReader.getproperty("gcashPrincipalAmount"));
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        if (isVisible(gcashCashInPageObjects.pleaseEnterAValidBirthDate(), getText(gcashCashInPageObjects.pleaseEnterAValidBirthDate()))) {
            ExtentReporter.logPass("GCI_TC_12", "Successfully verify No Birthdate Provided");
        } else {
            ExtentReporter.logFail("GCI_TC_12", "Failed to verify No Birthdate Provided");
            Assert.fail("Failed to verify No Birthdate Provided");
        }

    }

    public void GCI_TC_13() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("validReceiverGcashNumber"));
        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("notRegisteredSenderGcashNumber"));
        type(gcashCashInPageObjects.senderFirstName(), "Sender Firstname Field", propertyReader.getproperty("senderFirstName"));
        type(gcashCashInPageObjects.senderMiddleName(), "Sender MiddleName Field", propertyReader.getproperty("senderMiddleName"));
        type(gcashCashInPageObjects.senderLastName(), "Sender LastName Field", propertyReader.getproperty("senderLastName"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Month Field", propertyReader.getproperty("senderBirthMonthFuture"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Date Field", propertyReader.getproperty("senderBirthDateFuture"));
        type(gcashCashInPageObjects.senderBirthdate(), "Sender Birth Year Field", propertyReader.getproperty("senderBirthYearFuture"));
        waitSleep(5000);
        type(gcashCashInPageObjects.senderEmail(), "Sender Email Address Field", propertyReader.getproperty("senderEmailAddress"));
        type(gcashCashInPageObjects.principalAmount(), "Principal Amount Field", propertyReader.getproperty("gcashPrincipalAmount"));
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        if (isVisible(gcashCashInPageObjects.futureDate(), getText(gcashCashInPageObjects.futureDate()))) {
            ExtentReporter.logPass("GCI_TC_13", "Successfully verify Future Birthdate Provided");
        } else {
            ExtentReporter.logFail("GCI_TC_13", "Failed to verify Future Birthdate Provided");
            Assert.fail("Failed to verify Future Birthdate Provided");
        }

    }

    public void GCI_TC_14() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("validReceiverGcashNumber"));
        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("validSenderGcashNumber"));
        waitSleep(5000);
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        if (isVisible(gcashCashInPageObjects.emptyAmountText(), getText(gcashCashInPageObjects.emptyAmountText()))) {
            ExtentReporter.logPass("GCI_TC_14", "Successfully verify Empty Amount Provided");
        } else {
            ExtentReporter.logFail("GCI_TC_14", "Failed to verify Empty Amount Provided");
            Assert.fail("Failed to verify Empty Amount Provided");
        }


    }
    public void GCI_TC_15() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("validReceiverGcashNumber"));
        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("validSenderGcashNumber"));
        waitSleep(5000);
        type(gcashCashInPageObjects.principalAmount(), "Principal Amount 0", "0");
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        if (isVisible(gcashCashInPageObjects.zeroAmountText(), getText(gcashCashInPageObjects.zeroAmountText()))) {
            ExtentReporter.logPass("GCI_TC_15", "Successfully verify Zero Amount Provided");
        } else {
            ExtentReporter.logFail("GCI_TC_15", "Failed to verify Zero Amount Provided");
            Assert.fail("Failed to verify Zero Amount Provided");
        }
    }
//    public void GCI_TC_16() throws Exception {
//        GCI_TC_02();
//        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("validReceiverGcashNumber"));
//        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("validSenderGcashNumber"));
//        waitSleep(5000);
//        click(gcashCashInPageObjects.submitButton(), "Submit Button");
//        if (isVisible(gcashCashInPageObjects.zeroAmountText(), getText(gcashCashInPageObjects.zeroAmountText()))) {
//            ExtentReporter.logPass("GCI_TC_16", "Successfully verify Pending Status");
//        } else {
//            ExtentReporter.logFail("GCI_TC_16", "Failed to verify Pending Status");
//            Assert.fail("Failed to verify Pending Status");
//        }
//    }
    public void GCI_TC_17() throws Exception {
        GCI_TC_02();
        type(gcashCashInPageObjects.gcashNumberReceiver(), "Receiver Gcash Number", propertyReader.getproperty("validReceiverGcashNumber"));
        type(gcashCashInPageObjects.gcashNumberSender(), "Sender Gcash Number", propertyReader.getproperty("validSenderGcashNumberForExceedAmount"));
        waitSleep(5000);
        type(gcashCashInPageObjects.principalAmount(), "Principal Amount Field", propertyReader.getproperty("exceedGcashPrincipalAmount"));
        click(gcashCashInPageObjects.submitButton(), "Submit Button");
        try{
            isVisible(gcashCashInPageObjects.existingSimilarTransactionModal(), "Existing Similar Transaction Modal");
            click(gcashCashInPageObjects.yesProceedTransaction(),"Yes, Proceed Transaction Button");
            click(gcashCashInPageObjects.confirmButton(),"Confirm Cash In Button");
        }catch(Exception e){
            click(gcashCashInPageObjects.confirmButton(), "Confirm Button");
        }
        if (isVisible(gcashCashInPageObjects.exceedTransaction(), getText(gcashCashInPageObjects.exceedTransaction()))) {
            ExtentReporter.logPass("GCI_TC_17", "Successfully verify Wallet Capacity exceeded");
        } else {
            ExtentReporter.logFail("GCI_TC_17", "Failed to verify Wallet Capacity exceeded");
            Assert.fail("Failed to verify Zero Amount Provided");
        }
        click(gcashCashInPageObjects.okButton(),"OK Button");
    }












}
