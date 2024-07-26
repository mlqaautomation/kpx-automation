package mlkpx.testSteps;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.util.Collections;
import java.util.List;

public class WatchlistConfiguration_Steps extends Base_Steps{
    //W  A  T  C  H  L  I  S  T   C O N F I G U R A T I O N
    public void navigateWatchlistConfiguration()throws Exception{
        try{
            click(watchlistPageObjects.CustomerService(), "Customer Service");
            click(watchlistPageObjects.WatchlistDropdown(), "Watchlist Dropdown");
            click(watchlistPageObjects.WatchlistConfiguration(), "Watchlist Configuration");
            waitSleep(5000);
            if(isVisible(watchlistPageObjects.Watchlist_Alias(), getText(watchlistPageObjects.Watchlist_Alias()))){
                LoggingUtils.info("Navigated to Watchlist Configurations");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Watchlist Configurations"+ e);
        }
    }
    public void WatchlistConfigurationTC01() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.Threshold(), "Threshold Configurations");
        click(watchlistPageObjects.AddRowThreshold(), "Add Row");
        waitSleep(5000);
        watchlistPageObjects.WatchlistAlias().clear();
        type(watchlistPageObjects.WatchlistAlias(), "Watchlist/Alias (No. of words)","3");
        watchlistPageObjects.MatchedWords().clear();
        type(watchlistPageObjects.MatchedWords(), "Matched Words","3");
        scrollToElement(watchlistPageObjects.SaveChangess());
        click(watchlistPageObjects.SaveChangess(), "Save Changes");
        waitSleep(10000);
        assertEqual(getText(watchlistPageObjects.ThresholdConfigurationsSaved()), "Threshold Configurations Saved!");
        click(watchlistPageObjects.SaveOK(), "OK");
        waitSleep(8000);
        scrollToElement(watchlistPageObjects.Delete());
        click(watchlistPageObjects.Delete(), "Delete");
        scrollToElement(watchlistPageObjects.SaveChangess());
        click(watchlistPageObjects.SaveChangess(), "Save Changes");
        waitSleep(10000);
        assertEqual(getText(watchlistPageObjects.ThresholdConfigurationsSaved()), "Threshold Configurations Saved!");
        click(watchlistPageObjects.SaveOK(), "OK");

    }
    public void WatchlistConfigurationTC02() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.StringConversion(), "String Configurations");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.AddRowString());
        click(watchlistPageObjects.AddRowString(), "Add Row String");
        waitSleep(5000);
        type(watchlistPageObjects.OriginalString(), "Original String","Sia-rot");
        type(watchlistPageObjects.NewString(), "New String","Siarot");
        scrollToElement(watchlistPageObjects.SaveChangess2());
        click(watchlistPageObjects.SaveChangess2(), "Save Changes");
        waitSleep(10000);
        assertEqual(getText(watchlistPageObjects.StringConfigurationsSaved()), "String Configurations Saved!");
        click(watchlistPageObjects.SaveOK(), "OK");
        waitSleep(10000);
        scrollToElement(watchlistPageObjects.Delete1());
        click(watchlistPageObjects.Delete1(), "Delete");
        scrollToElement(watchlistPageObjects.SaveChangess2());
        click(watchlistPageObjects.SaveChangess2(), "Save Changes");
        waitSleep(10000);
        assertEqual(getText(watchlistPageObjects.StringConfigurationsSaved()), "String Configurations Saved!");
        click(watchlistPageObjects.SaveOK(), "OK");

    }
    public void WatchlistConfigurationTC03() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.StringOmission(), "String Omission");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.AddRowString());
        click(watchlistPageObjects.AddRowString(), "Add Row String");
        waitSleep(5000);
        watchlistPageObjects.OriginalString1().clear();
        type(watchlistPageObjects.OriginalString1(), "Original String","Sia-rot");
//        click(watchlistPageObjects.SelectString(), "Select String");
//        click(watchlistPageObjects.String(), "String");
        scrollToElement(watchlistPageObjects.SaveChangess3());
        click(watchlistPageObjects.SaveChangess3(), "Save Changes");
        waitSleep(10000);
        assertEqual(getText(watchlistPageObjects.StringConfigurationsSaved()), "String Configurations Saved!");
        click(watchlistPageObjects.SaveOK(), "OK");
        waitSleep(10000);
        scrollToElement(watchlistPageObjects.Delete2());
        click(watchlistPageObjects.Delete2(), "Delete");
        scrollToElement(watchlistPageObjects.SaveChangess3());
        click(watchlistPageObjects.SaveChangess3(), "Save Changes");
        waitSleep(10000);
        assertEqual(getText(watchlistPageObjects.StringConfigurationsSaved()), "String Configurations Saved!");
        click(watchlistPageObjects.SaveOK(), "OK");

    }
    public void WatchlistConfigurationTC04() throws Exception {
        waitSleep(5000);
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        type(sendOutPageObjects.lastName(), "Lastname ", "Balansag");
        type(sendOutPageObjects.firstName(), "Firstname ", "Rochelle");
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(10000);
        scrollToBottomOfPageWEB();
        scrollDown(100);
        scrollToElement(sendOutPageObjects.selectKYC());
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        waitUntilLoadingGone(10000);
        scrollToElement(sendOutPageObjects.searchReceivers());
        click(sendOutPageObjects.searchReceivers(), "Search Receivers Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.addNewReceivers(), "Add new Receiver ");
        waitUntilLoadingGone(10000);
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", "De la Cruz");
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", "One");
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", "April");
        scrollDown(100);
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.r_ProvinceState(), "Receiver Province/State");
        click(sendOutPageObjects.r_ProvinceStateSelect(), "Receiver Selected Province/State");
        click(sendOutPageObjects.r_CityMunicipality(), "Receiver City Municipality");
        click(sendOutPageObjects.r_CityMunicipalitySelected(), "Receiver Selected City Municipality");
        type(sendOutPageObjects.r_HouseNoStreetBarangaySitio(), "Receiver House No. Street/Barangay/Sitio ", propertyReader.getproperty("HouseNoStreetBarangaySitio"));
        click(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ");
        type(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ", "2002");
        sendOutPageObjects.r_birthdate_Field().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ", "11");
        sendOutPageObjects.r_birthdate_Field().sendKeys(Keys.ARROW_LEFT);
        sendOutPageObjects.r_birthdate_Field().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ", "02");
        click(sendOutPageObjects.r_sex_Field(), "Receiver Sex Field ");
        click(sendOutPageObjects.r_selected_Sex_Field(), "Receiver Selected Sex Field ");
        type(watchlistPageObjects.MobileNum(), "Receiver No Contact No. ", "09541787499");
        scrollUp(driver);
        waitUntilLoadingGone(10000);
        waitUntilLoadingGone(10000);
        type(sendOutPageObjects.sourceOfFund(), "Source of Fund field ", propertyReader.getproperty("source_of_fund"));
        type(sendOutPageObjects.purpose(), "Purpose field ", propertyReader.getproperty("purpose"));
        type(sendOutPageObjects.relationToReceiver(), "Relation to Receiver field ", propertyReader.getproperty("relationshiptoreceiver"));
        type(sendOutPageObjects.messageToReceiver(), "Message to Receiver field ", propertyReader.getproperty("messagetoreceiver"));
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ", "100");
        waitSleep(15000);
        scrollToElement(sendOutPageObjects.submitSendOut());
        click(sendOutPageObjects.submitSendOut(), "Submit SendOut Button");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.confirmSendOutButton(), "Confirm SendOut Button");
        waitUntilLoadingGone(10000);
        assertEqual(getText(watchlistPageObjects.Compliance()), "For Compliance Assistance");
        String reqNumber = getText(sendOutPageObjects.reqNum());
        List<String> reqValues = Collections.singletonList(reqNumber);
        reader.writeReqNumData(reqValues);
        click(watchlistPageObjects.OK(), "OK");

    }
    public void WatchlistConfigurationTC05() throws Exception {
        waitSleep(10000);
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        type(sendOutPageObjects.lastName(), "Lastname ", "Balansag");
        type(sendOutPageObjects.firstName(), "Firstname ", "Rochelle");
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(10000);
        scrollToBottomOfPageWEB();
        scrollDown(100);
        scrollToElement(sendOutPageObjects.selectKYC());
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        waitUntilLoadingGone(10000);
        scrollToElement(sendOutPageObjects.searchReceivers());
        click(sendOutPageObjects.searchReceivers(), "Search Receivers Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.addNewReceivers(), "Add new Receiver ");
        waitUntilLoadingGone(10000);
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", "De Silva");
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", "Kim-Lee");
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", "His");
        scrollDown(100);
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.r_ProvinceState(), "Receiver Province/State");
        click(sendOutPageObjects.r_ProvinceStateSelect(), "Receiver Selected Province/State");
        click(sendOutPageObjects.r_CityMunicipality(), "Receiver City Municipality");
        click(sendOutPageObjects.r_CityMunicipalitySelected(), "Receiver Selected City Municipality");
        type(sendOutPageObjects.r_HouseNoStreetBarangaySitio(), "Receiver House No. Street/Barangay/Sitio ", propertyReader.getproperty("HouseNoStreetBarangaySitio"));
        click(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ");
        type(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ", "2005");
        sendOutPageObjects.r_birthdate_Field().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ", "11");
        sendOutPageObjects.r_birthdate_Field().sendKeys(Keys.ARROW_LEFT);
        sendOutPageObjects.r_birthdate_Field().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ", "01");
        click(sendOutPageObjects.r_sex_Field(), "Receiver Sex Field ");
        click(sendOutPageObjects.r_selected_Sex_Field(), "Receiver Selected Sex Field ");
        type(watchlistPageObjects.MobileNum(), "Receiver No Contact No. ","09651784577");
        scrollUp(driver);
        waitUntilLoadingGone(10000);
        waitUntilLoadingGone(10000);
        type(sendOutPageObjects.sourceOfFund(), "Source of Fund field ", propertyReader.getproperty("source_of_fund"));
        type(sendOutPageObjects.purpose(), "Purpose field ", propertyReader.getproperty("purpose"));
        type(sendOutPageObjects.relationToReceiver(), "Relation to Receiver field ", propertyReader.getproperty("relationshiptoreceiver"));
        type(sendOutPageObjects.messageToReceiver(), "Message to Receiver field ", propertyReader.getproperty("messagetoreceiver"));
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ", "100");
        waitSleep(15000);
        scrollToElement(sendOutPageObjects.submitSendOut());
        click(sendOutPageObjects.submitSendOut(), "Submit SendOut Button");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.confirmSendOutButton(), "Confirm SendOut Button");
        waitUntilLoadingGone(10000);
        String kptnText = getText(sendOutPageObjects.kptnText());
        List<String> kptnValues = Collections.singletonList(kptnText);
        reader.writeKptnDataCompliance(kptnValues);
        click(sendOutPageObjects.proceedToPrinting(), "Proceed to Printing");
        waitUntilLoadingGone(12000);
        click(sendOutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
        waitSleep(5000);
        try{
            click(payoutPageObjects.payout_link(), "Payout");
            if(isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))){
                LoggingUtils.info("Navigated to Payout Page");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Payout Page "+ e);
        }
        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
        click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(3000);
        String sendoutKPTNCompliance = reader.getSendOutKPTNCompliance();
        type(payoutPageObjects.PayKTPN(), "KTPN", sendoutKPTNCompliance);
        type(payoutPageObjects.PayAmount(), "Amount", "100");
        waitUntilLoadingGone(10000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(15000);
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
        scrollToBottomOfPageWEB();
        scrollDown(100);
        scrollToElement(payoutPageObjects.SelectKYC());
        click(payoutPageObjects.SelectKYC(), "Select KYC");
        if (payoutPageObjects.KtpnInfo().getText().contains("KPTN")) {
            waitSleep(2000);
            scrollToElement(payoutPageObjects.ClaimAmount());
            click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");
            waitUntilLoadingGone(10000);
            if (payoutPageObjects.PayoutConfirm().isEnabled()) {
                waitSleep(2000);
                scrollToElement(payoutPageObjects.ConfirmPayout());
                click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
                assertEqual(getText(watchlistPageObjects.Compliance()), "For Compliance Assistance");
                click(watchlistPageObjects.OK(), "OK");

            }
        }
    }
    public void WatchlistConfigurationTC06() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.Threshold(), "Threshold Configurations");
        click(watchlistPageObjects.AddRowThreshold(), "Add Row");
        waitSleep(5000);
        watchlistPageObjects.WatchlistAlias().clear();
        type(watchlistPageObjects.WatchlistAlias(), "Watchlist/Alias (No. of words)","3");
        watchlistPageObjects.MatchedWords().clear();
        type(watchlistPageObjects.MatchedWords(), "Matched Words","3");
        scrollToElement(watchlistPageObjects.Cancel1());
        click(watchlistPageObjects.Cancel1(), "Cancel Changes");
        assertEqual(getText(watchlistPageObjects.AreYouSure()), "Are you sure?");
        click(watchlistPageObjects.NoKeepIt(), "No, Keep it");
        scrollToElement(watchlistPageObjects.Cancel1());
        click(watchlistPageObjects.Cancel1(), "Cancel Changes");
        click(watchlistPageObjects.NoKeepIt(), "Yes, cancel it!");
        scrollToElement(watchlistPageObjects.SaveChangess());
        click(watchlistPageObjects.SaveChangess(), "Save Changes");
        waitSleep(10000);
        assertEqual(getText(watchlistPageObjects.ThresholdConfigurationsSaved()), "Threshold Configurations Saved!");
        click(watchlistPageObjects.SaveOK(), "OK");
    }
    public void WatchlistConfigurationTC07() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.Threshold(), "Threshold Configurations");
        click(watchlistPageObjects.AddRowThreshold(), "Add Row");
        waitSleep(5000);
        watchlistPageObjects.WatchlistAlias().clear();
        type(watchlistPageObjects.WatchlistAlias(), "Watchlist/Alias (No. of words)","3");
        click(watchlistPageObjects.StringConversion(), "String Configurations");
        assertEqual(getText(watchlistPageObjects.UnsavedChanges()), "Unsaved Changes");
        LoggingUtils.info("Unsaved Changes\n" +
                        "        You have unsaved changes. Are you sure you want to leave?");
        click(watchlistPageObjects.StayOnThisPage(), "No, Stay On This Page");
        click(watchlistPageObjects.StringConversion(), "String Configurations");
        click(watchlistPageObjects.YesLeavePage(), "Yes, Leave the Page");
    }
    public void WatchlistConfigurationTC08() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.Threshold(), "Threshold Configurations");
        click(watchlistPageObjects.AddRowThreshold(), "Add Row");
        waitSleep(5000);
        watchlistPageObjects.WatchlistAlias().clear();
        type(watchlistPageObjects.WatchlistAlias(), "Watchlist/Alias (No. of words)","6");
        watchlistPageObjects.MatchedWords().clear();
        type(watchlistPageObjects.MatchedWords(), "Matched Words","6");
        scrollToElement(watchlistPageObjects.SaveChangess());
        click(watchlistPageObjects.SaveChangess(), "Save Changes");
        assertEqual(getText(watchlistPageObjects.DuplicateRowsDetected()), "Duplicate Rows Detected");
        LoggingUtils.info("Duplicate Rows Detected\n" +
                "Please ensure that there are no duplicate rows before saving.");
        click(watchlistPageObjects.SaveOK(), "OK");

    }
    public void WatchlistConfigurationTC09() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.StringConversion(), "String Configurations");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.AddRowString());
        click(watchlistPageObjects.AddRowString(), "Add Row String");
        waitSleep(5000);
        type(watchlistPageObjects.OriginalString(), "Original String", "MACDONALD");
        type(watchlistPageObjects.NewString(), "New String", "MCDONALD");
        scrollToElement(watchlistPageObjects.SaveChangess2());
        click(watchlistPageObjects.SaveChangess2(), "Save Changes");
        assertEqual(getText(watchlistPageObjects.FailedToSaveWatchlist()), "Failed to save watchlist configurations");
        LoggingUtils.info("Failed to save watchlist configurations\n" +
                "Error: Request failed with status code 400 (version: N/A)");
        click(watchlistPageObjects.SaveOK(), "OK");
    }
    public void WatchlistConfigurationTC10() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.StringOmission(), "String Omission");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.AddRowString());
        click(watchlistPageObjects.AddRowString(), "Add Row String");
        waitSleep(5000);
        watchlistPageObjects.OriginalString1().clear();
        type(watchlistPageObjects.OriginalString1(), "Original String", "ATTY.");
//        click(watchlistPageObjects.SelectString(), "Select String");
//        click(watchlistPageObjects.String(), "String");
        scrollToElement(watchlistPageObjects.SaveChangess3());
        click(watchlistPageObjects.SaveChangess3(), "Save Changes");
        assertEqual(getText(watchlistPageObjects.FailedToSaveWatchlist()), "Failed to save watchlist configurations");
        LoggingUtils.info("Failed to save watchlist configurations\n" +
                "Error: Request failed with status code 400 (version: N/A)");
        click(watchlistPageObjects.SaveOK(), "OK");
    }
}
