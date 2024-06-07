package mlkpx.testSteps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Payout_Partners_Steps extends Base_Steps{

    public void navigatePayoutPage()throws Exception{
        try{
            click(payoutPageObjects.payout_link(), "Payout");
            if(isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))){
                LoggingUtils.info("Navigated to Payout Page");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Payout Page "+ e);
        }
    }
    public void validateSuccessfulPartnerPayout()throws Exception {
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        String sendoutReference = reader.getSendOutReferenceNum(); // Call the getSendOutKPTN function
        type(payoutPageObjects.InputReference(), "Reference Number", sendoutReference);
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(payoutPageObjects.ClickOption());
        click(payoutPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(payoutPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(10000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.SearchKYC(), "Search KYC");
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.SearchKYCAc(), "Search Button");
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(2000);
        if (isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))) {
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        waitSleep(2000);
        scrollToElement(payoutPageObjects.SelectKYC());
        click(payoutPageObjects.SelectKYC(), "Select KYC");
        if (payoutPageObjects.SendoutInfo().getText().contains("Sendout Transaction Information")) {
            waitSleep(2000);
            click(payoutPageObjects.PurposeOfTransaction(), "Purpose of Transaction");
            click(payoutPageObjects.RelationToSender(), "Relation to Sender");
            waitUntilLoadingGone(10000);
            waitSleep(20000);
            waitUntilLoadingGone(10000);
            scrollToElement(payoutPageObjects.ClaimAmount());
            click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");

        }
        if (payoutPageObjects.PayoutConfirm().isEnabled()) {
            waitSleep(3000);
            scrollToElement(payoutPageObjects.ConfirmPayout());
            click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
            waitUntilLoadingGone(10000);
            waitSleep(20000);
            waitUntilLoadingGone(10000);
            if (payoutPageObjects.SuccessfulPay().getText().contains("Payout Successful")) {
                assertEqual(getText(payoutPageObjects.SuccessfulPay()), "Payout Successful");
                List<String> sendoutReferenceList = Collections.singletonList(sendoutReference);
                reader.writePayoutReferenceData(sendoutReferenceList);
                waitUntilLoadingGone(10000);
                click(payoutPageObjects.proceedToPrinting(), "Proceed to Printing");
                waitUntilLoadingGone(10000);
                waitSleep(3000);
                click(payoutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
                waitSleep(5000);
                click(payoutPageObjects.payout_link(), "Payout");
            }

        }
    }
    public void validateRemoteSuccessfulPartnerPayout()throws Exception{
            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
            //todo
            type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

            waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
            type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
            type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

            click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
            waitUntilLoadingGone(10000);
            reader.refreshTestData();
            waitSleep(3000);
            String sendoutReference = reader.getSendOutReferenceNum(); // Call the getSendOutKPTN function
            type(payoutPageObjects.InputReference(), "Reference Number", sendoutReference);
            waitSleep(6000);
            waitUntilLoadingGone(10000);
            scrollToElement(payoutPageObjects.ClickOption());
            click(payoutPageObjects.ClickOption(), "Option");
            waitSleep(2000);
            click(payoutPageObjects.ChooseOption(), "Choose Partners");
            waitSleep(10000);
            scrollToElement(payoutPageObjects.SearchButton());
            click(payoutPageObjects.SearchButton(), "Search Button");
            waitUntilLoadingGone(10000);
            click(payoutPageObjects.SearchKYC(), "Search KYC");
            waitUntilLoadingGone(10000);
            click(payoutPageObjects.SearchKYCAc(), "Search Button");
            waitUntilLoadingGone(10000);
            click(payoutPageObjects.ViewKYCCustomer(), "View KYC");
            waitSleep(2000);
            if(isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))){
                LoggingUtils.info("Navigated to View KYC");
                scrollDown(100);
                waitSleep(3000);
                scrollDown(100);
            }
            waitSleep(2000);
            scrollToElement(payoutPageObjects.SelectKYC());
            click(payoutPageObjects.SelectKYC(), "Select KYC");
            if (payoutPageObjects.SendoutInfo().getText().contains("Sendout Transaction Information")) {
                waitSleep(2000);
                click(payoutPageObjects.PurposeOfTransaction(), "Purpose of Transaction");
                click(payoutPageObjects.RelationToSender(), "Relation to Sender");
                waitUntilLoadingGone(10000);
                waitSleep(5000);
                scrollToElement(payoutPageObjects.ClaimAmount());
                click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");

            }
            if (payoutPageObjects.PayoutConfirm().isEnabled()) {
                waitSleep(2000);
                scrollToElement(payoutPageObjects.ConfirmPayout());
                click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
                waitUntilLoadingGone(10000);
                waitSleep(20000);
                waitUntilLoadingGone(10000);
                if (payoutPageObjects.SuccessfulPay().getText().contains("Payout Successful")) {
                    assertEqual(getText(payoutPageObjects.SuccessfulPay()), "Payout Successful");
                    List<String> sendoutReferenceList = Collections.singletonList(sendoutReference);
                    reader.writePayoutReferenceData(sendoutReferenceList);
                    waitUntilLoadingGone(10000);
                    click(payoutPageObjects.proceedToPrinting(), "Proceed to Printing");
                    waitUntilLoadingGone(10000);
                    click(payoutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
                }

            }
    }
    public void validatePartnerPayoutInvalidRef()throws Exception {
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.InputReference(), "Reference Number", "34645647");
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(payoutPageObjects.ClickOption());
        click(payoutPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(payoutPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(10000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.InvalidRef(), getText(payoutPageObjects.InvalidRef()))){
            assertEqual(getText(payoutPageObjects.InvalidRef()), "Error");
            LoggingUtils.info("Invalid reference number. Please check the reference number and try again.");
        }
        click(payoutPageObjects.OKInvalidKTPN(), "OK");

    }
    public void validateRemotePartnerPayoutInvalidRef()throws Exception{
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.InputReference(), "Reference Number", "645745745");
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(payoutPageObjects.ClickOption());
        click(payoutPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(payoutPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(10000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.InvalidRef(), getText(payoutPageObjects.InvalidRef()))){
            assertEqual(getText(payoutPageObjects.InvalidRef()), "Error");
            LoggingUtils.info("Invalid reference number. Please check the reference number and try again.");
        }
        click(payoutPageObjects.OKInvalidKTPN(), "OK");

    }
    public void validatePartnerPayoutWrongPartner()throws Exception {
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.InputReference(), "Reference Number", "9371565521");
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(payoutPageObjects.ClickOption());
        click(payoutPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        scrollToElement(payoutPageObjects.WrongchooseOption());
        click(payoutPageObjects.WrongchooseOption(), "Choose Partners");
        waitSleep(10000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.InvalidRef(), getText(payoutPageObjects.InvalidRef()))){
            assertEqual(getText(payoutPageObjects.InvalidRef()), "Error");
            LoggingUtils.info("No Transaction Found" +
                    "Transaction could not be found. Please check the Reference No. and try again.");
        }
        click(payoutPageObjects.OKInvalidKTPN(), "OK");

    }
    public void validateRemotePartnerPayoutWrongPartner()throws Exception{
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.InputReference(), "Reference Number", "9371565521");
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(payoutPageObjects.ClickOption());
        click(payoutPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        scrollToElement(payoutPageObjects.WrongchooseOption());
        click(payoutPageObjects.WrongchooseOption(), "Choose Partners");
        waitSleep(10000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.InvalidRef(), getText(payoutPageObjects.InvalidRef()))){
            assertEqual(getText(payoutPageObjects.InvalidRef()), "Error");
            LoggingUtils.info("No Transaction Found" +
                    "Transaction could not be found. Please check the Reference No. and try again.");
        }
        click(payoutPageObjects.OKInvalidKTPN(), "OK");

    }
    public void validatePartnerPayoutClaimedRef()throws Exception {
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.InputReference(), "Reference Number", "2322565816");
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(payoutPageObjects.ClickOption());
        click(payoutPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        scrollToElement(payoutPageObjects.ChooseOption());
        click(payoutPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(10000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        if(isVisible(payoutPageObjects.InvalidKTPN(), getText(payoutPageObjects.InvalidKTPN()))){
            assertEqual(getText(payoutPageObjects.InvalidKTPN()), "No Transaction Found");
            LoggingUtils.info("Transaction already claimed. Please check the Reference No. and try again.");
        }
        click(payoutPageObjects.OKInvalidKTPN(), "OK");

    }
    public void validatePartnerPayoutEmptyRef()throws Exception {
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.InputReference(), "Reference Number", "");
        waitSleep(2000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitSleep(2000);
        assertEqual(getText(payoutPageObjects.RefRequired()), "Reference number is required.");

    }
    public void validateRemotePartnerPayoutEmptyRef()throws Exception{
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.InputReference(), "Reference Number", "");
        waitSleep(2000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitSleep(2000);
        assertEqual(getText(payoutPageObjects.RefRequired()), "Reference number is required.");

    }
    public void validatePartnerPayoutEmptyPartner()throws Exception {
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.InputReference(), "Reference Number", "9371565521");
        waitSleep(2000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        assertEqual(getText(payoutPageObjects.PartnerRequired()), "Please select a partner");

    }
    public void validateRemotePartnerPayoutEmptyPartner()throws Exception{
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.InputReference(), "Reference Number", "9371565521");
        waitSleep(2000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        assertEqual(getText(payoutPageObjects.PartnerRequired()), "Please select a partner");

    }
    public void validatePartnerPayoutEmptyPurpose()throws Exception {
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        type(payoutPageObjects.InputReference(), "Reference Number", "9371565521");
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(payoutPageObjects.ClickOption());
        click(payoutPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(payoutPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(10000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.SearchKYC(), "Search KYC");
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.SearchKYCAc(), "Search Button");
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(2000);
        if (isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))) {
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        waitSleep(2000);
        scrollToElement(payoutPageObjects.SelectKYC());
        click(payoutPageObjects.SelectKYC(), "Select KYC");
        if (payoutPageObjects.SendoutInfo().getText().contains("Sendout Transaction Information")) {
            waitSleep(2000);
            click(payoutPageObjects.RelationToSender(), "Relation to Sender");
            waitUntilLoadingGone(10000);
            waitSleep(5000);
            scrollToElement(payoutPageObjects.ClaimAmount());
            click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");

        }
        if (payoutPageObjects.PayoutConfirm().isEnabled()) {
            waitSleep(2000);
            scrollToElement(payoutPageObjects.ConfirmPayout());
            click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
            waitUntilLoadingGone(10000);
            waitSleep(20000);
            waitUntilLoadingGone(10000);
            if(isVisible(payoutPageObjects.EmptyPurpose(), getText(payoutPageObjects.EmptyPurpose()))){
                assertEqual(getText(payoutPageObjects.EmptyPurpose()), "Something Went Wrong");
                LoggingUtils.info("Purpose of transaction is invalid (code 7005)");
            }
            click(payoutPageObjects.OKInvalidKTPN(), "OK");

        }
    }
    public void validatePartnerPayoutEmptyRelation()throws Exception {
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);

        type(payoutPageObjects.InputReference(), "Reference Number", "9371565521");
        waitSleep(6000);
        waitUntilLoadingGone(10000);
        scrollToElement(payoutPageObjects.ClickOption());
        click(payoutPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(payoutPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(10000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.SearchKYC(), "Search KYC");
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.SearchKYCAc(), "Search Button");
        waitUntilLoadingGone(10000);
        click(payoutPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(2000);
        if (isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))) {
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        waitSleep(2000);
        scrollToElement(payoutPageObjects.SelectKYC());
        click(payoutPageObjects.SelectKYC(), "Select KYC");
        if (payoutPageObjects.SendoutInfo().getText().contains("Sendout Transaction Information")) {
            waitSleep(2000);
            click(payoutPageObjects.PurposeOfTransaction(), "Purpose of Transaction");
            waitUntilLoadingGone(10000);
            waitSleep(5000);
            scrollToElement(payoutPageObjects.ClaimAmount());
            click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");

        }
        if (payoutPageObjects.PayoutConfirm().isEnabled()) {
            waitSleep(2000);
            scrollToElement(payoutPageObjects.ConfirmPayout());
            click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
            waitUntilLoadingGone(10000);
            waitSleep(20000);
            waitUntilLoadingGone(10000);
            if(isVisible(payoutPageObjects.EmptyPurpose(), getText(payoutPageObjects.EmptyPurpose()))){
                assertEqual(getText(payoutPageObjects.EmptyPurpose()), "Something Went Wrong");
                LoggingUtils.info("Relationship to sender is invalid (code 7003)");
            }
            click(payoutPageObjects.OKInvalidKTPN(), "OK");
            waitSleep(2000);
            click(payoutPageObjects.RelationToSender(), "Relation to Sender");
            waitUntilLoadingGone(10000);
            waitSleep(5000);
            scrollToElement(payoutPageObjects.ClaimAmount());
            click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");
            if (payoutPageObjects.PayoutConfirm().isEnabled()) {
                waitSleep(2000);
                scrollToElement(payoutPageObjects.ConfirmPayout());
                click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
                waitUntilLoadingGone(10000);
                waitSleep(20000);
                waitUntilLoadingGone(10000);}
            if(isVisible(payoutPageObjects.EmptyPurpose(), getText(payoutPageObjects.EmptyPurpose()))){
                assertEqual(getText(payoutPageObjects.EmptyPurpose()), "Something Went Wrong");
                LoggingUtils.info("Some transaction details have been changed. Kindly refresh the page and try again.");
            }
            click(payoutPageObjects.OKInvalidKTPN(), "OK");
        }
    }
}
