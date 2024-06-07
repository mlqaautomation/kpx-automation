package mlkpx.testSteps;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;

import java.util.Collections;
import java.util.List;

public class Sendout_Partners_Steps extends Base_Steps{

    public void navigationFOrSendOutDomestic() throws Exception {
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutPageObjects.PartnerTransaction(), "SendOut Transaction ");
        click(sendOutPageObjects.PartnerSendout(), "SendOut Transaction ");

    }
    public void PS_TC_01() throws Exception {
        navigationFOrSendOutDomestic();
        click(sendOutPageObjects.SelectPartner(), "Select SendOut Partner ");
        searchKYC();
        waitUntilLoadingGone(10000);
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
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        String referenceNum = getText(sendOutPageObjects.referenceNumber());
        List<String> referenceValues = Collections.singletonList(referenceNum);
        reader.writeReferenceNumData(referenceValues);
        click(sendOutPageObjects.proceedToPrinting(), "Proceed to Printing");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");

    }
    public void searchKYC () {
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        String[] randomName = reader.getRandomName();
        type(sendOutPageObjects.lastName(), "Lastname ", "Balansag");
        type(sendOutPageObjects.firstName(), "Firstname ", "Rochelle");
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        waitSleep(2000);
        scrollToElement(sendOutPageObjects.viewButton());
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(6000);
        scrollToBottomOfPageWEB();
        scrollDown(100);
        scrollToElement(sendOutPageObjects.selectKYC());
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        waitSleep(2000);
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
        waitSleep(30000);
        waitUntilLoadingGone(10000);
        scrollDown(100);
        waitSleep(10000);
        scrollToElement(sendOutPageObjects.OkCountry());
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
