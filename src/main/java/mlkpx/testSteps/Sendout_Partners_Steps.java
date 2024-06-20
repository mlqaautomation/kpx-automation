package mlkpx.testSteps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Sendout_Partners_Steps extends Base_Steps{

    public void navigationFOrSendOutDomestic() throws Exception {
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutPageObjects.SendoutTransaction(), "SendOut Transaction ");
        click(sendOutPageObjects.PartnerSendout(), "Partner SendOut Transaction ");

    }
    public void PS_TC_01() throws Exception {
        navigationFOrSendOutDomestic();
        waitSleep(10000);
        click(sendOutPageObjects.SelectPartner(), "Select SendOut Partner ");
        searchKYC();
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        click(sendOutPageObjects.selectIDIssuedate(), "ID Issue Date field ");
        type(sendOutPageObjects.selectIDIssuedate(), "Receiver Birthdate field ", "2020");
        sendOutPageObjects.selectIDIssuedate().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.selectIDIssuedate(), "Receiver Birthdate field ", "02");
        sendOutPageObjects.selectIDIssuedate().sendKeys(Keys.ARROW_LEFT);
        sendOutPageObjects.selectIDIssuedate().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.selectIDIssuedate(), "Receiver Birthdate field ", "02");
        addReceiver();
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.selectSourceofFund(), "Select Source of Fund");
        click(sendOutPageObjects.selectPurpose(), "Select Purpose of Transfer");
        click(sendOutPageObjects.selectRelationship(), "Select Relationship");
        click(sendOutPageObjects.selectDeliveryOption(), "Select Delivery Option");
        String SendoutAmount = reader.getPartnerSendoutAmount();
        type(sendOutPageObjects.inputPrincipalAmount(), "Send Amount",SendoutAmount);
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        scrollToElement(sendOutPageObjects.clickSubmitButton());
        click(sendOutPageObjects.clickSubmitButton(), "Submit Partner Sendout");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.confirmSendOutButton(), "Confirm SendOut Button");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        String referenceNum = getText(sendOutPageObjects.referenceNumber());
        List<String> referenceValues = Collections.singletonList(referenceNum);
        reader.writeReferenceNumData(referenceValues);
        click(sendOutPageObjects.proceedToPrinting(), "Proceed to Printing");
        waitSleep(5000);
        scrollToElement(sendOutPageObjects.cancelButtoninReceipt());
        click(sendOutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");

    }
    public void PS_TC_02() throws Exception {
        navigationFOrSendOutDomestic();
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
        //todo
        type(payoutPageObjects.BranchCode(), "Search Branch Code", propertyReader.getproperty("BranchCode"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(15));

        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", propertyReader.getproperty("OperatorID"));
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
        click(sendOutPageObjects.SelectPartner(), "Select SendOut Partner ");
        searchKYC();
        waitUntilLoadingGone(10000);
        scrollToElement(sendOutPageObjects.selectIDIssuedate());
        click(sendOutPageObjects.selectIDIssuedate(), "ID Issue Date field ");
        type(sendOutPageObjects.selectIDIssuedate(), "Receiver Birthdate field ", "2020");
        sendOutPageObjects.selectIDIssuedate().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.selectIDIssuedate(), "Receiver Birthdate field ", "02");
        sendOutPageObjects.selectIDIssuedate().sendKeys(Keys.ARROW_LEFT);
        sendOutPageObjects.selectIDIssuedate().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.selectIDIssuedate(), "Receiver Birthdate field ", "02");
        addReceiver();
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.selectSourceofFund(), "Select Source of Fund");
        click(sendOutPageObjects.selectPurpose(), "Select Purpose of Transfer");
        click(sendOutPageObjects.selectRelationship(), "Select Relationship");
        click(sendOutPageObjects.selectDeliveryOption(), "Select Delivery Option");
        String SendoutAmount = reader.getPartnerSendoutAmount();
        type(sendOutPageObjects.inputPrincipalAmount(), "Send Amount",SendoutAmount);
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        scrollToElement(sendOutPageObjects.clickSubmitButton());
        click(sendOutPageObjects.clickSubmitButton(), "Submit Partner Sendout");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.confirmSendOutButton(), "Confirm SendOut Button");
        waitUntilLoadingGone(20000);
        waitSleep(15000);
        String referenceNum = getText(sendOutPageObjects.referenceNumber());
        List<String> referenceValues = Collections.singletonList(referenceNum);
        reader.writeReferenceNumData(referenceValues);
        click(sendOutPageObjects.proceedToPrinting(), "Proceed to Printing");
        waitSleep(5000);
        scrollToElement(sendOutPageObjects.cancelButtoninReceipt());
        click(sendOutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");

    }
    public void searchKYC () {
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");

        type(sendOutPageObjects.lastName(), "Lastname ", "Balansag");
        type(sendOutPageObjects.firstName(), "Firstname ", "Rochelle");
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        scrollToElement(sendOutPageObjects.viewButton());
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(6000);
        scrollToBottomOfPageWEB();
        scrollDown(100);
        scrollToElement(sendOutPageObjects.selectKYC());
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        waitSleep(5000);
    }

    public void addReceiver () {
        scrollToElement(sendOutPageObjects.searchReceivers());
        click(sendOutPageObjects.searchReceivers(), "Search Receivers Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.addNewReceivers(), "Add new Receiver ");
        waitUntilLoadingGone(10000);
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", "Siarot");
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", "Enrique");
        type(sendOutPageObjects.r_MiddleName(), "R_Middlename ", "Alferez");
        scrollDown(100);
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.SelectCountry(), "Select Country");
        waitUntilLoadingGone(10000);
        scrollDown(100);
        waitSleep(30000);
        scrollToElement(sendOutPageObjects.OkCountry());
        waitSleep(6000);
        click(sendOutPageObjects.OkCountry(), "Confirm Country");
        click(sendOutPageObjects.SelectNationality(), "Select Nationality");
        click(sendOutPageObjects.selectBdate(), "Receiver Birthdate field ");
        type(sendOutPageObjects.selectBdate(), "Receiver Birthdate field ", "2002");
        sendOutPageObjects.selectBdate().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.selectBdate(), "Receiver Birthdate field ", "02");
        sendOutPageObjects.selectBdate().sendKeys(Keys.ARROW_LEFT);
        sendOutPageObjects.selectBdate().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.selectBdate(), "Receiver Birthdate field ", "11");
        click(sendOutPageObjects.selectSex(), "Receiver Selected Sex Field ");
        type(sendOutPageObjects.typeContactNum(), "Receiver Contact No.", "09203447377");
        click(sendOutPageObjects.selectProvince(), "Receiver Province/State");
        waitUntilLoadingGone(10000);
    }

}
