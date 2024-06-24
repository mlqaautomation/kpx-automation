package mlkpx.testSteps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class WS_CashInToAnotherAccount extends Base_Steps{
    // WALLET SERVICES / CASH IN TO ANOTHER ACCOUNT

    public void navigateWalletServicesPage() throws Exception {
        try {
            click(walletServicesPageObjects.Wallet_link(), "Cash In to Another Account");
            if (isVisible(walletServicesPageObjects.WalletPage_h2(), getText(walletServicesPageObjects.WalletPage_h2()))) {
                LoggingUtils.info("Navigated to Wallet Services Page");
            }
        } catch (Exception e) {
            LoggingUtils.info("Failed to Navigate Wallet Services Page " + e);
        }
    }
    public void ValidateSuccessCashInToAnotherAccount() throws Exception {

        click(walletServicesPageObjects.CashInAnotherAccount(), "Cash In to Another Account");
        if (isVisible(walletServicesPageObjects.WalletPage(), getText(walletServicesPageObjects.WalletPage()))) {
//            type(walletServicesPageObjects.WalletCardNum(), "ML Card Number", "");
            click(walletServicesPageObjects.SearchKYC(), "Search KYC Button");
        }
        waitUntilLoadingGone(10000);
        type(walletServicesPageObjects.SearchLName(), "Last name field", "AMOC");
        type(walletServicesPageObjects.SearchFName(), "First name field", "ROSELYN");
        type(walletServicesPageObjects.SearchMName(), "Middle name field", "");
        click(walletServicesPageObjects.SearchKYCAc(), "Search Button");
        waitUntilLoadingGone(10000);
        click(walletServicesPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(3000);
        if (isVisible(walletServicesPageObjects.KYCPage(), getText(walletServicesPageObjects.KYCPage()))) {
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        click(walletServicesPageObjects.SelectKYC(), "Select KYC");
        if (walletServicesPageObjects.CashInInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Cash In to Another Account Information's");
            click(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.");
            type(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.", "078845625");
            type(walletServicesPageObjects.PrincipalAmount(), "Principal Amount", "1000");
            click(walletServicesPageObjects.SubmitSendMoney(), "Select Claim Amount");
            waitSleep(2000);
        }
        if (walletServicesPageObjects.SendMoneyInfo().isEnabled()) {
            type(walletServicesPageObjects.TenderAmount(), "Tender Amount", "1003");
            click(walletServicesPageObjects.ProceedSendMoney(), "Proceed");
        }
        if (walletServicesPageObjects.SendMoneyConfirmation().isEnabled()) {
            click(walletServicesPageObjects.ConfirmSendMoney(), "Confirm Send Money");
            assertEqual(getText(walletServicesPageObjects.SuccessfulSendMoney()), "Send Money Successful");
            String kptnText = getText(walletServicesPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeCIAPrintKTPN(kptnValues);
            click(walletServicesPageObjects.ProceedToPrint(), "Proceed to Printing");
//            click(walletServicesPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
//            LoggingUtils.info("Successful in printing Money Sendout Receipt");
            click(walletServicesPageObjects.CancelToPrint(), "Cancel to Printing");
            LoggingUtils.info("Redirect to Wallet Services" +
                    "Cash In to Another Account");
        }

    }
    public void ValidateRemoteSuccessCashInToAnotherAccount() throws Exception {

        click(walletServicesPageObjects.CashInAnotherAccount(), "Cash In to Another Account");

        if (isVisible(walletServicesPageObjects.WalletPage(), getText(walletServicesPageObjects.WalletPage()))) {
            click(walletServicesPageObjects.RemoteTransaction(), "Remote Transaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(walletServicesPageObjects.BranchCode()));

            type(walletServicesPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("validBranch_code"));
            waitSleep(15000);

            type(walletServicesPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("operatorID"));
            type(walletServicesPageObjects.ReasonRemote(), "Reason", "Testing");
//            type(walletServicesPageObjects.WalletCardNum(), "ML Card Number", "");
            click(walletServicesPageObjects.SearchKYC(), "Search KYC Button");
        }
        waitSleep(2);
        type(walletServicesPageObjects.SearchLName(), "Last name field", "AMOC");
        type(walletServicesPageObjects.SearchFName(), "First name field", "ROSELYN");
        type(walletServicesPageObjects.SearchMName(), "Middle name field", "");
        click(walletServicesPageObjects.SearchKYCAc(), "Search Button");
        waitSleep(2);
        click(walletServicesPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(2);
        if (isVisible(walletServicesPageObjects.KYCPage(), getText(walletServicesPageObjects.KYCPage()))) {
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        click(walletServicesPageObjects.SelectKYC(), "Select KYC");
        if (walletServicesPageObjects.CashInInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Cash In to Another Account Information's");
            click(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.");
            type(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.", "078845625");
            type(walletServicesPageObjects.PrincipalAmount(), "Principal Amount", "1000");
            click(walletServicesPageObjects.SubmitSendMoney(), "Select Claim Amount");
            waitSleep(2000);
        }
        if (walletServicesPageObjects.SendMoneyInfo().isEnabled()) {
            type(walletServicesPageObjects.TenderAmount(), "Tender Amount", "1003");
            click(walletServicesPageObjects.ProceedSendMoney(), "Proceed");
        }
        if (walletServicesPageObjects.SendMoneyConfirmation().isEnabled()) {
            click(walletServicesPageObjects.ConfirmSendMoney(), "Confirm Send Money");
            assertEqual(getText(walletServicesPageObjects.SuccessfulSendMoney()), "Send Money Successful");
            String kptnText = getText(walletServicesPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeCIAPrintKTPN(kptnValues);
            click(walletServicesPageObjects.ProceedToPrint(), "Proceed to Printing");
//            click(walletServicesPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
//            LoggingUtils.info("Successful in printing Money Sendout Receipt");
            click(walletServicesPageObjects.CancelToPrint(), "Cancel to Printing");
            LoggingUtils.info("Redirect to Wallet Services" +
                    "Cash In to Another Account");
        }
    }
    public void ValidateCashInToAnotherAccWithNoMobileProvided() throws Exception {

        click(walletServicesPageObjects.CashInAnotherAccount(), "Cash In to Another Account");
        if (isVisible(walletServicesPageObjects.WalletPage(), getText(walletServicesPageObjects.WalletPage()))) {
//            type(walletServicesPageObjects.WalletCardNum(), "ML Card Number", "");
            click(walletServicesPageObjects.SearchKYC(), "Search KYC Button");
        }
        waitUntilLoadingGone(10000);
        type(walletServicesPageObjects.SearchLName(), "Last name field", "AMOC");
        type(walletServicesPageObjects.SearchFName(), "First name field", "ROSELYN");
        type(walletServicesPageObjects.SearchMName(), "Middle name field", "");
        click(walletServicesPageObjects.SearchKYCAc(), "Search Button");
        waitUntilLoadingGone(10000);
        click(walletServicesPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(3000);
        if (isVisible(walletServicesPageObjects.KYCPage(), getText(walletServicesPageObjects.KYCPage()))) {
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        click(walletServicesPageObjects.SelectKYC(), "Select KYC");
        if (walletServicesPageObjects.CashInInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Cash In to Another Account Information's");
            click(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.");
            type(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.", "");
            click(walletServicesPageObjects.WalletCardNum(), "Select Claim Amount");
            assertEqual(getText(walletServicesPageObjects.MobileRequired()), "Mobile number is required.");
        }


    }
    public void ValidateCashInToAnotherAccWithInvalidMobileProvided() throws Exception {

        click(walletServicesPageObjects.CashInAnotherAccount(), "Cash In to Another Account");
        if (isVisible(walletServicesPageObjects.WalletPage(), getText(walletServicesPageObjects.WalletPage()))) {
//            type(walletServicesPageObjects.WalletCardNum(), "ML Card Number", "");
            click(walletServicesPageObjects.SearchKYC(), "Search KYC Button");
        }
        waitUntilLoadingGone(10000);
        type(walletServicesPageObjects.SearchLName(), "Last name field", "AMOC");
        type(walletServicesPageObjects.SearchFName(), "First name field", "ROSELYN");
        type(walletServicesPageObjects.SearchMName(), "Middle name field", "");
        click(walletServicesPageObjects.SearchKYCAc(), "Search Button");
        waitUntilLoadingGone(10000);
        click(walletServicesPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(3000);
        if (isVisible(walletServicesPageObjects.KYCPage(), getText(walletServicesPageObjects.KYCPage()))) {
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        click(walletServicesPageObjects.SelectKYC(), "Select KYC");
        if (walletServicesPageObjects.CashInInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Cash In to Another Account Information's");
            click(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.");
            type(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.", "53456");
            click(walletServicesPageObjects.WalletCardNum(), "Select Claim Amount");
            assertEqual(getText(walletServicesPageObjects.InvalidMobileRequired()), "Invalid Mobile No.");
        }
    }
    public void ValidateCashInToAnotherAccWithNoPrincipal() throws Exception {

        click(walletServicesPageObjects.CashInAnotherAccount(), "Cash In to Another Account");
        if (isVisible(walletServicesPageObjects.WalletPage(), getText(walletServicesPageObjects.WalletPage()))) {
//            type(walletServicesPageObjects.WalletCardNum(), "ML Card Number", "");
            click(walletServicesPageObjects.SearchKYC(), "Search KYC Button");
        }
        waitUntilLoadingGone(10000);
        type(walletServicesPageObjects.SearchLName(), "Last name field", "AMOC");
        type(walletServicesPageObjects.SearchFName(), "First name field", "ROSELYN");
        type(walletServicesPageObjects.SearchMName(), "Middle name field", "");
        click(walletServicesPageObjects.SearchKYCAc(), "Search Button");
        waitUntilLoadingGone(10000);
        click(walletServicesPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(3000);
        if (isVisible(walletServicesPageObjects.KYCPage(), getText(walletServicesPageObjects.KYCPage()))) {
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        click(walletServicesPageObjects.SelectKYC(), "Select KYC");
        if (walletServicesPageObjects.CashInInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Cash In to Another Account Information's");
            click(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.");
            type(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.", "078845625");
            type(walletServicesPageObjects.PrincipalAmount(), "Principal Amount", "");
            click(walletServicesPageObjects.WalletCardNum(), "Select Claim Amount");
            assertEqual(getText(walletServicesPageObjects.AmountNumber()), "Amount should be a number");
        }
    }
    public void ValidateCashInToAnotherAccWithInputtedZero() throws Exception {

        click(walletServicesPageObjects.CashInAnotherAccount(), "Cash In to Another Account");
        if (isVisible(walletServicesPageObjects.WalletPage(), getText(walletServicesPageObjects.WalletPage()))) {
//            type(walletServicesPageObjects.WalletCardNum(), "ML Card Number", "");
            click(walletServicesPageObjects.SearchKYC(), "Search KYC Button");
        }
        waitUntilLoadingGone(10000);
        type(walletServicesPageObjects.SearchLName(), "Last name field", "AMOC");
        type(walletServicesPageObjects.SearchFName(), "First name field", "ROSELYN");
        type(walletServicesPageObjects.SearchMName(), "Middle name field", "");
        click(walletServicesPageObjects.SearchKYCAc(), "Search Button");
        waitUntilLoadingGone(10000);
        click(walletServicesPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(3000);
        if (isVisible(walletServicesPageObjects.KYCPage(), getText(walletServicesPageObjects.KYCPage()))) {
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        click(walletServicesPageObjects.SelectKYC(), "Select KYC");
        if (walletServicesPageObjects.CashInInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Cash In to Another Account Information's");
            click(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.");
            type(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.", "078845625");
            type(walletServicesPageObjects.PrincipalAmount(), "Principal Amount", "0");
            click(walletServicesPageObjects.SubmitSendMoney(), "Select Claim Amount");
            assertEqual(getText(walletServicesPageObjects.Minnumber()), "Minimum amount is 1");
        }

    }
    public void ValidateCashInToAnotherAccWithInputtedLessTotal() throws Exception {

        click(walletServicesPageObjects.CashInAnotherAccount(), "Cash In to Another Account");
        if (isVisible(walletServicesPageObjects.WalletPage(), getText(walletServicesPageObjects.WalletPage()))) {
//            type(walletServicesPageObjects.WalletCardNum(), "ML Card Number", "");
            click(walletServicesPageObjects.SearchKYC(), "Search KYC Button");
        }
        waitUntilLoadingGone(10000);
        type(walletServicesPageObjects.SearchLName(), "Last name field", "AMOC");
        type(walletServicesPageObjects.SearchFName(), "First name field", "ROSELYN");
        type(walletServicesPageObjects.SearchMName(), "Middle name field", "");
        click(walletServicesPageObjects.SearchKYCAc(), "Search Button");
        waitUntilLoadingGone(10000);
        click(walletServicesPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(3000);
        if (isVisible(walletServicesPageObjects.KYCPage(), getText(walletServicesPageObjects.KYCPage()))) {
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        click(walletServicesPageObjects.SelectKYC(), "Select KYC");
        if (walletServicesPageObjects.CashInInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Cash In to Another Account Information's");
            click(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.");
            type(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.", "078845625");
            type(walletServicesPageObjects.PrincipalAmount(), "Principal Amount", "1000");
            click(walletServicesPageObjects.SubmitSendMoney(), "Select Claim Amount");
            waitSleep(2000);
        }
        if (walletServicesPageObjects.SendMoneyInfo().isEnabled()) {
            typeEnter(walletServicesPageObjects.TenderAmount(), "Tender Amount", "434");
            assertEqual(getText(walletServicesPageObjects.LessTenderAmount()), "Tender amount cannot be less than total amount");

        }


    }
    public void ValidateCashInToAnotherAccWithInputtedFiftyThousandsAbove() throws Exception {

        click(walletServicesPageObjects.CashInAnotherAccount(), "Cash In to Another Account");
        if (isVisible(walletServicesPageObjects.WalletPage(), getText(walletServicesPageObjects.WalletPage()))) {
//            type(walletServicesPageObjects.WalletCardNum(), "ML Card Number", "");
            click(walletServicesPageObjects.SearchKYC(), "Search KYC Button");
        }
        waitUntilLoadingGone(10000);
        type(walletServicesPageObjects.SearchLName(), "Last name field", "AMOC");
        type(walletServicesPageObjects.SearchFName(), "First name field", "ROSELYN");
        type(walletServicesPageObjects.SearchMName(), "Middle name field", "");
        click(walletServicesPageObjects.SearchKYCAc(), "Search Button");
        waitUntilLoadingGone(10000);
        click(walletServicesPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(3000);
        if (isVisible(walletServicesPageObjects.KYCPage(), getText(walletServicesPageObjects.KYCPage()))) {
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        click(walletServicesPageObjects.SelectKYC(), "Select KYC");
        if (walletServicesPageObjects.CashInInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Cash In to Another Account Information's");
            click(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.");
            type(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.", "078845625");
            type(walletServicesPageObjects.PrincipalAmount(), "Principal Amount", "50001");
            click(walletServicesPageObjects.SubmitSendMoney(), "Select Claim Amount");
            waitSleep(2000);
        }
        if (walletServicesPageObjects.SendMoneyInfo().isEnabled()) {
            type(walletServicesPageObjects.TenderAmount(), "Tender Amount", "50001");
            click(walletServicesPageObjects.ProceedSendMoney(), "Proceed");

        }
        if (walletServicesPageObjects.SendMoneyConfirmation().isEnabled()) {
            click(walletServicesPageObjects.ConfirmSendMoney(), "Confirm Send Money");
            assertEqual(getText(walletServicesPageObjects.TransactionNotAllowed()), "Transaction not allowed");

        }
    }
    public void ValidateCashInToAnotherAccCustomerCannotFound() throws Exception {

        click(walletServicesPageObjects.CashInAnotherAccount(), "Cash In to Another Account");
        if (isVisible(walletServicesPageObjects.WalletPage(), getText(walletServicesPageObjects.WalletPage()))) {
//            type(walletServicesPageObjects.WalletCardNum(), "ML Card Number", "");
            click(walletServicesPageObjects.SearchKYC(), "Search KYC Button");
        }
        waitUntilLoadingGone(10000);
        type(walletServicesPageObjects.SearchLName(), "Last name field", "AMOC");
        type(walletServicesPageObjects.SearchFName(), "First name field", "ROSELYN");
        type(walletServicesPageObjects.SearchMName(), "Middle name field", "");
        click(walletServicesPageObjects.SearchKYCAc(), "Search Button");
        waitUntilLoadingGone(10000);
        click(walletServicesPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(3000);
        if (isVisible(walletServicesPageObjects.KYCPage(), getText(walletServicesPageObjects.KYCPage()))) {
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        click(walletServicesPageObjects.SelectKYC(), "Select KYC");
        if (walletServicesPageObjects.CashInInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Cash In to Another Account Information's");
            click(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.");
            type(walletServicesPageObjects.ReceiversMobileNum(), "Receiver's ML Money Mobile No.", "078749625");
            type(walletServicesPageObjects.PrincipalAmount(), "Principal Amount", "1000");
            click(walletServicesPageObjects.SubmitSendMoney(), "Select Claim Amount");
            waitSleep(2000);
            assertEqual(getText(walletServicesPageObjects.CustomerCannotFound()), "Customer not found");
        }


    }
}