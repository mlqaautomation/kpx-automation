package mlkpx.testSteps;

import utilities.Logger.LoggingUtils;

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
    public void validateSuccessfulPartnerPayout()throws Exception{
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
        click(payoutPageObjects.PartnerTransaction(), "Domestic Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        String sendoutReference = reader.getSendOutReferenceNum(); // Call the getSendOutKPTN function
        type(payoutPageObjects.InputReference(), "Reference Number", sendoutReference);
        waitSleep(2000);
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
}
