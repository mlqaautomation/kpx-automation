
package mlkpx.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.util.Collections;
import java.util.List;

public class WS_KwartaPadalaPayOut_Steps extends Base_Steps {

    public void navigationWalletServicesToKwartaPadalaPayout() throws Exception {
        click(wsCashInToOwnAccountPageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsKwartaPadalaPayOutPageObjects.kwartaPadalaPayoutNavLink(), "Kwarta Padala Payout Nav Link");
        if (isVisible(wsKwartaPadalaPayOutPageObjects.kwartaPadalaPayoutText(), getText(wsKwartaPadalaPayOutPageObjects.kwartaPadalaPayoutText()))) {
            ExtentReporter.logPass("Kwarta Padala Payout navigation", "Successfully Validated Kwarta Padala Payout Page");
        } else {
            ExtentReporter.logFail("Kwarta Padala Payout navigation", "Failed to Validate Kwarta Padala Payout Page");
            Assert.fail("Failed to Validate Kwarta Padala Payout Page");
        }
    }

    public void KPP_TC_01() throws Exception {
        KPP_TC_08();
        click(wsKwartaPadalaPayOutPageObjects.claimAmountButton(),"Claim Amount Button");
        click(wsKwartaPadalaPayOutPageObjects.confirmPayoutButton(),"Confirm Payout Button");
        waitSleep(3000);
        if (isVisible(wsKwartaPadalaPayOutPageObjects.payoutSuccessfulText(), getText(wsKwartaPadalaPayOutPageObjects.payoutSuccessfulText()))) {
            ExtentReporter.logPass("KPP_TC_01", "Successfully validate successful Wallet Services Kwarta Padala Payout");
            String  kptnText = getText(wsKwartaPadalaPayOutPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeKPPrintKTPN(kptnValues);
        } else {
            ExtentReporter.logFail("KPP_TC_01", "Failed to validate successful Wallet Services Kwarta Padala Payout");
            Assert.fail("Failed to validate successful Wallet Services Kwarta Padala Payout");
        }
//        click(wsKwartaPadalaPayOutPageObjects.proceedToPrintingButton(),"Proceed TO printing Button");
//        click(wsKwartaPadalaPayOutPageObjects.cancelButtonReceipt(),"Cancel Button In Receipt");
    }

    public void KPP_TC_02() throws Exception {
        navigationWalletServicesToKwartaPadalaPayout();
        type(sendOutPageObjects.branchField(), "Branch Code Field", propertyReader.getproperty("validBranch_code"));
        type(wsKwartaPadalaPayOutPageObjects.operatorIDField(),"OPerator ID Field", propertyReader.getproperty("operatorID"));
        type(wsKwartaPadalaPayOutPageObjects.reasonField(),"Reason Field", propertyReader.getproperty("Reason"));
        String randomKPPKPTN = reader.getRandomKPPReferenceNum();
        type(wsKwartaPadalaPayOutPageObjects.referenceNumField(), "KPP KPTN Field", randomKPPKPTN);
        type(wsKwartaPadalaPayOutPageObjects.amountField(), "Amount Field", propertyReader.getproperty("validamount"));
        click(wsKwartaPadalaPayOutPageObjects.searchButton(), "Search Button");
        click(wsKwartaPadalaPayOutPageObjects.searchKYCButton(), "Search KYC Button");
        searchKYC();
        click(wsKwartaPadalaPayOutPageObjects.claimAmountButton(),"Claim Amount Button");
        click(wsKwartaPadalaPayOutPageObjects.confirmPayoutButton(),"Confirm Payout Button");
        waitSleep(3000);
        if (isVisible(wsKwartaPadalaPayOutPageObjects.payoutSuccessfulText(), getText(wsKwartaPadalaPayOutPageObjects.payoutSuccessfulText()))) {
            ExtentReporter.logPass("KPP_TC_02", "Successfully validate successful remote Wallet Services Kwarta Padala Payout");
            String  kptnText = getText(wsKwartaPadalaPayOutPageObjects.kptnText());
            List<String> kptnValues = Collections.singletonList(kptnText);
            reader.writeKPPrintKTPN(kptnValues);
        } else {
            ExtentReporter.logFail("KPP_TC_02", "Failed to validate successful remote Wallet Services Kwarta Padala Payout");
            Assert.fail("Failed to validate successful remote Wallet Services Kwarta Padala Payout");
        }
//        click(wsKwartaPadalaPayOutPageObjects.proceedToPrintingButton(),"Proceed TO printing Button");
//        click(wsKwartaPadalaPayOutPageObjects.cancelButtonReceipt(),"Cancel Button In Receipt");
    }

    public void KPP_TC_03() throws Exception {
        navigationWalletServicesToKwartaPadalaPayout();
        click(wsKwartaPadalaPayOutPageObjects.referenceNumField(), "Reference Number Field");
        click(wsKwartaPadalaPayOutPageObjects.searchButton(), "Search Button");
        if (isVisible(wsKwartaPadalaPayOutPageObjects.kptnIsRequiredText(), getText(wsKwartaPadalaPayOutPageObjects.kptnIsRequiredText()))) {
            ExtentReporter.logPass("KPP_TC_03", "Successfully Validate kwarta padala payout without Reference No");
        } else {
            ExtentReporter.logFail("KPP_TC_03", "Failed to Validate kwarta padala payout without Reference No");
            Assert.fail("Failed to Validate kwarta padala payout without Reference No");
        }
    }

    public void KPP_TC_04() throws Exception {
        navigationWalletServicesToKwartaPadalaPayout();
        type(wsKwartaPadalaPayOutPageObjects.referenceNumField(), "Reference Number Field", propertyReader.getproperty("invalidReference"));
        type(wsKwartaPadalaPayOutPageObjects.amountField(), "Amount Field", propertyReader.getproperty("invalidamountNum"));
        click(wsKwartaPadalaPayOutPageObjects.searchButton(), "Search Button");
        if (isVisible(wsKwartaPadalaPayOutPageObjects.invalidReferenceText(), getText(wsKwartaPadalaPayOutPageObjects.invalidReferenceText()))) {
            ExtentReporter.logPass("KPP_TC_04", "Successfully Validate kwarta padala payout invalid Reference No.");
        } else {
            ExtentReporter.logFail("KPP_TC_04", "Failed to Validate kwarta padala payout invalid Reference No.");
            Assert.fail("Failed to Validate kwarta padala payout invalid Reference No.");
        }
        click(wsKwartaPadalaPayOutPageObjects.okButton(), "OK Button");
    }

    public void KPP_TC_05() throws Exception {
        navigationWalletServicesToKwartaPadalaPayout();
        type(wsKwartaPadalaPayOutPageObjects.referenceNumField(), "Reference Number Field", propertyReader.getproperty("validReferenceForInvalidAmount"));
        type(wsKwartaPadalaPayOutPageObjects.amountField(), "Amount Field", propertyReader.getproperty("invalidamountNum"));
        click(wsKwartaPadalaPayOutPageObjects.searchButton(), "Search Button");
        if (isVisible(wsKwartaPadalaPayOutPageObjects.invalidAmountText(), getText(wsKwartaPadalaPayOutPageObjects.invalidAmountText()))) {
            ExtentReporter.logPass("KPP_TC_05", "Successfully Validated kwarta padala payout invalid amount.");
        } else {
            ExtentReporter.logFail("KPP_TC_05", "Failed to Validate kwarta padala payout invalid amount.");
            Assert.fail("Failed to Validate kwarta padala payout invalid amount.");
        }
    }

    public void KPP_TC_06() throws Exception {
        navigationWalletServicesToKwartaPadalaPayout();
        type(wsKwartaPadalaPayOutPageObjects.referenceNumField(), "Reference Number Field", propertyReader.getproperty("validReference"));
        click(wsKwartaPadalaPayOutPageObjects.searchButton(), "Search Button");
        click(wsKwartaPadalaPayOutPageObjects.kwartaPadalaPayoutText(), "Kwarta Padala Text");
        if (isVisible(wsKwartaPadalaPayOutPageObjects.emptyAmount(), getText(wsKwartaPadalaPayOutPageObjects.emptyAmount()))) {
            ExtentReporter.logPass("KPP_TC_06", "Successfully Validated kwarta padala payout without inputting amount");
        } else {
            ExtentReporter.logFail("KPP_TC_06", "Failed to Validate kwarta padala payout without inputting amount");
            Assert.fail("Failed to Validate kwarta padala payout without inputting amount");
        }
    }

    public void KPP_TC_07() throws Exception {
        navigationWalletServicesToKwartaPadalaPayout();
        type(wsKwartaPadalaPayOutPageObjects.referenceNumField(), "Reference Number Field", propertyReader.getproperty("claimedReference"));
        type(wsKwartaPadalaPayOutPageObjects.amountField(), "Amount Field", propertyReader.getproperty("claimedAmount"));
        click(wsKwartaPadalaPayOutPageObjects.searchButton(), "Search Button");
        if (isVisible(wsKwartaPadalaPayOutPageObjects.claimedText(), getText(wsKwartaPadalaPayOutPageObjects.claimedText()))) {
            ExtentReporter.logPass("KPP_TC_07", "Successfully Validated claimed transaction");
        } else {
            ExtentReporter.logFail("KPP_TC_07", "Failed to Validate claimed transaction");
            Assert.fail("Failed to Validate claimed transaction");
        }
    }

    public void KPP_TC_08() throws Exception {
        navigationWalletServicesToKwartaPadalaPayout();
        String randomKPPKPTN = reader.getRandomKPPReferenceNum();
        type(wsKwartaPadalaPayOutPageObjects.referenceNumField(), "KPP KPTN Field", randomKPPKPTN);
        type(wsKwartaPadalaPayOutPageObjects.amountField(), "Amount Field", propertyReader.getproperty("validamount"));
        click(wsKwartaPadalaPayOutPageObjects.searchButton(), "Search Button");
        click(wsKwartaPadalaPayOutPageObjects.searchKYCButton(), "Search KYC Button");
        if (isVisible(wsKwartaPadalaPayOutPageObjects.searchKYCText(), getText(wsKwartaPadalaPayOutPageObjects.searchKYCText()))) {
            ExtentReporter.logPass("KPP_TC_08", "Successfully Navigate KYC Search Page");
        } else {
            ExtentReporter.logFail("KPP_TC_08", "Failed to Navigate KYC Search Page");
            Assert.fail("Failed to Navigate KYC Search Page");
        }
        searchKYC();
        if (isVisible(wsKwartaPadalaPayOutPageObjects.payoutText(), getText(wsKwartaPadalaPayOutPageObjects.payoutText()))) {
            ExtentReporter.logPass("KPP_TC_08", "Successfully Redirect into Payout Sendout Transaction Information and Receiver's Identification");
        } else {
            ExtentReporter.logFail("KPP_TC_08", "Failed to Redirect into Payout Sendout Transaction Information and Receiver's Identification");
            Assert.fail("Failed to Redirect into Payout Sendout Transaction Information and Receiver's Identification");
        }

    }

    public void KPP_TC_09()throws Exception{
        navigationWalletServicesToKwartaPadalaPayout();
        type(wsKwartaPadalaPayOutPageObjects.referenceNumField(), "KPP KPTN Field", propertyReader.getproperty("validReference"));
        type(wsKwartaPadalaPayOutPageObjects.amountField(), "Amount Field", propertyReader.getproperty("validamount"));
        click(wsKwartaPadalaPayOutPageObjects.searchButton(), "Search Button");
        if (isVisible(wsKwartaPadalaPayOutPageObjects.transactionBeingProcessedText(), getText(wsKwartaPadalaPayOutPageObjects.transactionBeingProcessedText()))) {
            ExtentReporter.logPass("KPP_TC_09", "Successfully validate again the cash in transaction if its being proccessed or not");
        } else {
            ExtentReporter.logFail("KPP_TC_09", "Failed to validate again the cash in transaction if its being proccessed or not");
            Assert.fail("Failed to validate again the cash in transaction if its being proccessed or not");
        }

    }

    public void KPP_TC_10()throws Exception{
        navigationWalletServicesToKwartaPadalaPayout();
        type(wsKwartaPadalaPayOutPageObjects.referenceNumField(), "KPP KPTN Field", propertyReader.getproperty("validReference"));
        type(wsKwartaPadalaPayOutPageObjects.amountField(), "Amount Field", propertyReader.getproperty("validamount"));
        click(wsKwartaPadalaPayOutPageObjects.searchButton(), "Search Button");
        click(wsKwartaPadalaPayOutPageObjects.searchKYCButton(), "Search KYC Button");
        searchKYC();
        click(wsKwartaPadalaPayOutPageObjects.cancelButtonInPayoutPage(),"Cancel Button");
        click(wsKwartaPadalaPayOutPageObjects.noStayOnThisPage(),"No, Stay On This Page Button");
        click(wsKwartaPadalaPayOutPageObjects.cancelButtonInPayoutPage(),"Cancel Button");
        click(wsKwartaPadalaPayOutPageObjects.yesDoNotProcessButton(),"Yes, Do Not Process Button");
        if (isVisible(wsKwartaPadalaPayOutPageObjects.kwartaPadalaPayoutText(), getText(wsKwartaPadalaPayOutPageObjects.kwartaPadalaPayoutText()))) {
            ExtentReporter.logPass("KPP_TC_10", "Successfully Validate Cancel Kwarta Padala Payout Transaction");
        } else {
            ExtentReporter.logFail("KPP_TC_10", "Failed to Cancel Kwarta Padala Payout Transaction");
            Assert.fail("Failed to Cancel Kwarta Padala Payout Transaction");
        }


    }

    public void searchKYC(){
        String[] randomName = reader.getRandomName();
        type(sendOutPageObjects.lastName(), "Lastname ", randomName[1]);
        type(sendOutPageObjects.firstName(), "Firstname ", randomName[0]);
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitSleep(2000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollDown(100);
        scrollToElement(sendOutPageObjects.selectKYC());
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
    }
}
