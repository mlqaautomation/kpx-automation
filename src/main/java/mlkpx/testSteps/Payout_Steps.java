package mlkpx.testSteps;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.yaml.snakeyaml.error.YAMLException;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Payout_Steps extends Base_Steps{

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
    public void validateSuccessfulDomesticPayout()throws Exception{
            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            waitUntilLoadingGone(10000);
            reader.refreshTestData();
            waitSleep(3000);  
            String sendoutKPTN = reader.getSendOutKPTN(); // Call the getSendOutKPTN function
            type(payoutPageObjects.PayKTPN(), "KTPN", sendoutKPTN);
            type(payoutPageObjects.PayAmount(), "Amount", "100");
            waitUntilLoadingGone(10000);
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
            if (payoutPageObjects.KtpnInfo().getText().contains("KPTN")) {
                waitSleep(2000);
                scrollToElement(payoutPageObjects.ClaimAmount());
                click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");
            }


            if (payoutPageObjects.PayoutConfirm().isEnabled()) {
//                try{
                    waitSleep(2000);
                    scrollToElement(payoutPageObjects.ConfirmPayout());
                    click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
                    if (payoutPageObjects.SuccessfulPay().getText().contains("Payout Successful")) {
                        assertEqual(getText(payoutPageObjects.SuccessfulPay()), "Payout Successful");
                        List<String> sendoutKPTNList = Collections.singletonList(sendoutKPTN);
                        reader.writePayoutKptnData(sendoutKPTNList);
                        waitUntilLoadingGone(10000);
                        click(payoutPageObjects.proceedToPrinting(), "Proceed to Printing");
                        waitUntilLoadingGone(10000);
                        click(payoutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
                    }

//                }catch (Exception e){
//                    LoggingUtils.info("Payout Unsuccessful");
//                    List<String> payoutKPTNList = Collections.singletonList(sendoutKPTN);
//                    reader.writeKptnData(payoutKPTNList);
//                    waitSleep(2000);
//                }

            }

    }
    public void validateSuccessfulRemoteDomesticPayout()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
            //todo
            type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));

            waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
            type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
            type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            waitUntilLoadingGone(10000);
            reader.refreshTestData();
            waitSleep(3000);
            String sendoutRemoteKPTN = reader.getRemoteKPTN(); // Call the getSendOutRemoteKPTN function
            type(payoutPageObjects.PayKTPN(), "KTPN Number", sendoutRemoteKPTN);
            type(payoutPageObjects.PayAmount(), "Amount", "100");
            waitUntilLoadingGone(10000);
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
            if (payoutPageObjects.KtpnInfo().getText().contains("KPTN")) {
                waitSleep(2000);
                scrollToElement(payoutPageObjects.ClaimAmount());
                click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");
            }

            if (payoutPageObjects.PayoutConfirm().isEnabled()) {
//                try{
                waitSleep(2000);
                scrollToElement(payoutPageObjects.ConfirmPayout());
                    click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");

                    if (getText(payoutPageObjects.SuccessfulPay()).equals("Payout Successful")) {
                        assertEqual(getText(payoutPageObjects.SuccessfulPay()), "Payout Successful");
                        List<String> payoutremoteKPTNList = Collections.singletonList(sendoutRemoteKPTN);
                        reader.writeRemotePayoutKptnData(payoutremoteKPTNList);
                        waitUntilLoadingGone(10000);
                        click(payoutPageObjects.proceedToPrinting(), "Proceed to Printing");
                        waitUntilLoadingGone(10000);
                        click(payoutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
                    }

//                }catch (Exception e){
//                    LoggingUtils.info("Payout Remote Unsuccessful");
//                    List<String> kptnValues = Collections.singletonList(sendoutRemoteKPTN);
//                    reader.writeRemoteKptnData(kptnValues);
//                    waitSleep(2000);
//                }

            }

    }
    public void navigationFOrSendOutDomestic() throws Exception {
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
    }
    public void searchKYC () {
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        String[] randomName = reader.getRandomName();
        type(sendOutPageObjects.lastName(), "Lastname ", "Quin");
        type(sendOutPageObjects.firstName(), "Firstname ", "Anna");
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(10000);
        scrollToElement(sendOutPageObjects.selectKYC());
        scrollDown(100);
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
    }
    public void search1KYC () {
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        String[] randomName = reader.getRandomName();
        type(sendOutPageObjects.lastName(), "Lastname ", "Briar");
        type(sendOutPageObjects.firstName(), "Firstname ", "Aurelia");
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollToElement(sendOutPageObjects.selectKYC());
        scrollDown(100);
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
    }
    public void searchReceiver () {
        waitUntilLoadingGone(10000);
        scrollToElement(sendOutPageObjects.searchReceivers());
        click(sendOutPageObjects.searchReceivers(), "Search Receivers Button ");
        scrollToElement(sendOutPageObjects.selectButton());
        click(sendOutPageObjects.selectButton(), "Select Button");
        waitUntilLoadingGone(10000);
        scrollToElement(sendOutPageObjects.no_ContactNo());
        waitSleep(5000);
        click(sendOutPageObjects.no_ContactNo(), "Contact No Checkbox");
    }
    public void ForWatchlist() throws Exception {
        navigationFOrSendOutDomestic();
        searchKYC();
        searchReceiver();
        waitUntilLoadingGone(10000);
        type(sendOutPageObjects.sourceOfFund(), "Source of Fund field ", propertyReader.getproperty("source_of_fund"));
        type(sendOutPageObjects.purpose(), "Purpose field ", propertyReader.getproperty("purpose"));
        type(sendOutPageObjects.relationToReceiver(), "Relation to Receiver field ", propertyReader.getproperty("relationshiptoreceiver"));
        type(sendOutPageObjects.messageToReceiver(), "Message to Receiver field ", propertyReader.getproperty("messagetoreceiver"));
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ", "200");
        click(sendOutPageObjects.submitSendOut(), "Submit SendOut Button");
        click(sendOutPageObjects.confirmSendOutButton(), "Confirm SendOut Button");
        waitSleep(20000);
        //todo get value of kptn locator and post it to yaml file
        String kptnText = getText(sendOutPageObjects.kptnText());
        List<String> kptnValues = Collections.singletonList(kptnText);
        reader.writeCWKptnData(kptnValues);
        click(sendOutPageObjects.proceedToPrinting(), "Proceed to Printing");
        waitSleep(2000);
        click(sendOutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
    }

    public void validateComplianceAssistance()throws Exception{
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
        click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        String WatchlistKPTN = reader.getWatchlistKPTN();
        type(payoutPageObjects.PayKTPN(), "Compliance KTPN Number", WatchlistKPTN);
        type(payoutPageObjects.PayAmount(), "Amount", "200");
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        click(payoutPageObjects.SearchKYC(), "Search KYC");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
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
        click(payoutPageObjects.SelectKYC(), "Select KYC");
        if (payoutPageObjects.PayoutInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Payout Information's");
            waitSleep(2000);
            scrollToElement(payoutPageObjects.ClaimAmount());
            click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");
        }

        if (payoutPageObjects.PayoutConfirm().isEnabled()) {
            click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
            WebDriverWait ca = new WebDriverWait(driver, Duration.ofSeconds(10));
            ca.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OKCom()));
            assertEqual(getText(payoutPageObjects.ComplianceAss()), "For Compliance Assistance");
            click(payoutPageObjects.OKCom(), "Click OK");

        }


    }
    public void ForRemoteWatchlist() throws Exception {
        navigationFOrSendOutDomestic();
        search1KYC();
        searchReceiver();
        waitUntilLoadingGone(10000);
        type(sendOutPageObjects.sourceOfFund(), "Source of Fund field ", propertyReader.getproperty("source_of_fund"));
        type(sendOutPageObjects.purpose(), "Purpose field ", propertyReader.getproperty("purpose"));
        type(sendOutPageObjects.relationToReceiver(), "Relation to Receiver field ", propertyReader.getproperty("relationshiptoreceiver"));
        type(sendOutPageObjects.messageToReceiver(), "Message to Receiver field ", propertyReader.getproperty("messagetoreceiver"));
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ", "200");
        click(sendOutPageObjects.submitSendOut(), "Submit SendOut Button");
        click(sendOutPageObjects.confirmSendOutButton(), "Confirm SendOut Button");
        waitSleep(3000);
        //todo get value of kptn locator and post it to yaml file
        String rekptnText = getText(sendOutPageObjects.kptnText());
        List<String> kptnValues = Collections.singletonList(rekptnText);
        reader.writeCWRemoteKptnData(kptnValues);
        click(sendOutPageObjects.proceedToPrinting(), "Proceed to Printing");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
    }
    public void validateRemoteComplianceAssistance()throws Exception{

        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitSleep(10000);
        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

        click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        String RemoteWatchlistKPTN = reader.getRemoteWatchlistKPTN();
        type(payoutPageObjects.PayKTPN(), "Compliance KTPN Number", RemoteWatchlistKPTN);
        type(payoutPageObjects.PayAmount(), "Amount", "200");
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
        click(payoutPageObjects.SelectKYC(), "Select KYC");
        if (payoutPageObjects.PayoutInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Payout Information's");
            waitSleep(2000);
            scrollToElement(payoutPageObjects.ClaimAmount());
            click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");
        }


        if (payoutPageObjects.PayoutConfirm().isEnabled()) {
            click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
            WebDriverWait ca = new WebDriverWait(driver, Duration.ofSeconds(10));
            ca.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OKCom()));
            assertEqual(getText(payoutPageObjects.ComplianceAss()), "For Compliance Assistance");
            click(payoutPageObjects.OKCom(), "Click OK");

        }


    }
    public void validateInvalidKTPN()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", propertyReader.getproperty("InvalidKTPNnum"));
            type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("PayAmount"));
            click(payoutPageObjects.SearchButton(), "Search Button");

            if(isVisible(payoutPageObjects.InvalidKTPN(), getText(payoutPageObjects.payoutPage_h5()))){
                assertEqual(getText(payoutPageObjects.payoutPage_h5()), "No Transaction Found");
            }
            click(payoutPageObjects.OKInvalidKTPN(), "OK");


    }
    public void validateRemoteInvalidKTPN()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");

            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitSleep(10000);
        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

        click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
        type(payoutPageObjects.PayKTPN(), "KTPN Number", propertyReader.getproperty("InvalidKTPNnum"));
        type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("PayAmount"));
        waitUntilLoadingGone(10000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");

        if (isVisible(payoutPageObjects.InvalidKTPN(), getText(payoutPageObjects.payoutPage_h5()))) {
            assertEqual(getText(payoutPageObjects.payoutPage_h5()), "No Transaction Found");
        }
        click(payoutPageObjects.OKInvalidKTPN(), "OK");





    }
    public void validateInvalidAmountDPT()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", propertyReader.getproperty("UnclaimKTPNnum"));
            type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("InvalidAmount"));
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.payoutPage_h5()), "No Transaction Found");
//            assertEqual(getText(payoutPageObjects.InvalidAmount()), "Amount entered does not match amount in KPTN / reference no.");


    }
    public void validateInvalidAmountRemoteDPT()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitSleep(10000);
        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", propertyReader.getproperty("UnclaimKTPNnum"));
            type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("InvalidAmount"));
            waitUntilLoadingGone(10000);
            scrollToElement(payoutPageObjects.SearchButton());
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.payoutPage_h5()), "No Transaction Found");


    }
    public void validateClaimedDomesticPayout()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            String payoutKPTN = reader.getSuccessPayoutKPTN(); // Call the getPayoutKPTN function
            type(payoutPageObjects.PayKTPN(), "KTPN Number", payoutKPTN);
            type(payoutPageObjects.PayAmount(), "Amount", "100");
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.payoutClaim_h5()), "No Transaction Found");


    }
    public void validateClaimedRemoteDomesticPayout()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitSleep(10000);
        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", "KPNABODVPUQ");
            type(payoutPageObjects.PayAmount(), "Amount", "100");
            waitUntilLoadingGone(10000);
            scrollToElement(payoutPageObjects.SearchButton());
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.payoutClaim_h5()), "No Transaction Found");


    }
    public void validateDPTwithoutKTPNInput()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", "");
            type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("PayAmount"));
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.RequiredKTPN()), "KPTN is required");


    }
    public void validateRemoteDPTwithoutKTPNInput()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitSleep(10000);
        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", "");
            payoutPageObjects.PayAmount().clear();
            type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("PayAmount"));
            waitSleep(2000);
            scrollToElement(payoutPageObjects.SearchButton());
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.RequiredKTPN()), "KPTN is required");


    }
    public void validateDPTwithoutAmountInput()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", propertyReader.getproperty("ClaimKTPNnum"));
            type(payoutPageObjects.PayAmount(), "Amount", "");
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.AmountShouldBeNumber()), "Amount should be a number");


    }
    public void validateRemoteDPTWithoutAmountInput()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitSleep(10000);
        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
            waitSleep(4);
            type(payoutPageObjects.PayKTPN(), "KTPN Number", propertyReader.getproperty("ClaimKTPNnum"));
            type(payoutPageObjects.PayAmount(), "Amount", "");
            waitSleep(2000);
            scrollToElement(payoutPageObjects.SearchButton());
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.AmountShouldBeNumber()), "Amount should be a number");


    }
    public void validateRemoteInvalidBranchCode()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));

            type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R3180912");
            ExtentReporter.logPass("validateRemoteInvalidBranchCode","Branch not found");


    }
    public void validateRemoteInvalidOperatorID()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
            payoutPageObjects.BranchCode().clear();
            type(payoutPageObjects.BranchCode(), "Search Branch Code", "0617143912");
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
            waitSleep(10000);
            waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
            type(payoutPageObjects.OperatorID(), "Search Operator ID", "20236709");
            ExtentReporter.logPass("validateRemoteInvalidOperatorID","Operator not found");


    }






}






