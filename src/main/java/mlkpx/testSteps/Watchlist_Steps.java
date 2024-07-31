package mlkpx.testSteps;

import org.mlkpx.pageObject.Watchlist_PageObjects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Watchlist_Steps extends Base_Steps{
    //W  A  T  C  H  L  I  S  T
    public void navigateWatchlist()throws Exception{
        try{
            click(watchlistPageObjects.CustomerService(), "Customer Service");
            click(watchlistPageObjects.WatchlistDropdown(), "Watchlist Dropdown");
            click(watchlistPageObjects.Watchlist(), "Watchlist");
            waitSleep(5000);
            if(isVisible(watchlistPageObjects.Watchlist_Alias(), getText(watchlistPageObjects.Watchlist_Alias()))){
                LoggingUtils.info("Navigated to Watchlist / Alias Page");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Watchlist / Alias Page "+ e);
        }
    }
    public void WatchlistTC01() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.AddWatchlist(), "Add Watchlist");
        click(watchlistPageObjects.AddWatchlistByGenInfo(), "Add Watchlist by  General Information");
        String LNames= reader.getRandomLNames();
        type(watchlistPageObjects.GenInfoLName(), "General Information Last Name:",LNames);
        String FNames= reader.getRandomFNames();
        type(watchlistPageObjects.GenInfoFName(), "General Information First Name:", FNames);
        type(watchlistPageObjects.GenInfoMName(), "General Information Middle Name:", "testing");
        click(watchlistPageObjects.NoMName(), "No Middle Name");
        click(watchlistPageObjects.AppliedAll(), "Applied All");
        click(watchlistPageObjects.AppliedPayout(), "Applied to Payout");
        click(watchlistPageObjects.AppliedSendout(), "Applied to Sendout");
        click(watchlistPageObjects.IsActive(), "Is Active?, Yes");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.SaveWatchlist());
        click(watchlistPageObjects.SaveWatchlist(), "Save Watchlist");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.Successful()), "Success");
        LoggingUtils.info("Success, Watchlist successfully added!");
        click(watchlistPageObjects.SaveOK(), "Save OK");
        waitSleep(5000);
        if (isVisible(watchlistPageObjects.WatchlistUpdate(), getText(watchlistPageObjects.WatchlistUpdate()))) {
            LoggingUtils.info("Navigated to Update Watchlist Page");
        }
        click(watchlistPageObjects.EditWatchlist(), "Edit/Update Watchlist");
        click(watchlistPageObjects.AppliedAll(), "Applied All");
        click(watchlistPageObjects.AppliedPayout(), "Applied to Payout");
        click(watchlistPageObjects.AppliedSendout(), "Applied to Sendout");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        scrollDown(50);
        click(watchlistPageObjects.AddAlias(), "Add Alias");
        waitSleep(3000);

        if (isVisible(watchlistPageObjects.ManageAliases(), getText(watchlistPageObjects.ManageAliases()))) {
            LoggingUtils.info("Navigated the Manage Aliases Modal");
            type(watchlistPageObjects.AliasLName(), "Aliases Last Name:", "lastalias");
            type(watchlistPageObjects.AliasMName(), "Aliases First Name:", "firstalias");
            type(watchlistPageObjects.AliasFName(), "Aliases Middle Name:", "Als");
            click(watchlistPageObjects.AliasNoMName(), "Alias No Middle Name");
            click(watchlistPageObjects.SaveAlias(), "Save Alias");
            waitSleep(5000);
            assertEqual(getText(watchlistPageObjects.Successful()), "Success");
            LoggingUtils.info("Success, Alias successfully added!");
            click(watchlistPageObjects.SaveOK(), "Save OK");
            scrollDown(100);
            waitSleep(5000);
            LoggingUtils.info("The Added Alias Information will display and Watchlist Logs");
            scrollUp2(100);
            click(watchlistPageObjects.SaveWatchlist(), "Save Update Watchlist");
            assertEqual(getText(watchlistPageObjects.Successful()), "Success");
            LoggingUtils.info("Success, Watchlist successfully updated!");
            click(watchlistPageObjects.SaveOK(), "OK");

        }

    }
    public void WatchlistTC02() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.AddWatchlist(), "Add Watchlist");
        click(watchlistPageObjects.AddWatchlistByMobileNum(), "Add Watchlist by Mobile Number");
        String MobileNum= reader.getMobileNumber();
        click(watchlistPageObjects.MobileNum(), "ML Money Mobile No.");
        type(watchlistPageObjects.MobileNum(), "ML Money Mobile No.",MobileNum);
        waitSleep(5000);
        click(watchlistPageObjects.AppliedAll(), "Applied All");
        click(watchlistPageObjects.AppliedPayout(), "Applied to Payout");
        click(watchlistPageObjects.AppliedSendout(), "Applied to Sendout");
        click(watchlistPageObjects.IsActive(), "Is Active?, Yes");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.SaveWatchlist());
        click(watchlistPageObjects.SaveWatchlist(), "Save Watchlist");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.Successful()), "Success");
        LoggingUtils.info("Success, Watchlist successfully added!");
        click(watchlistPageObjects.SaveOK(), "Save OK");
        waitSleep(5000);
        if (isVisible(watchlistPageObjects.WatchlistUpdate(), getText(watchlistPageObjects.WatchlistUpdate()))) {
            LoggingUtils.info("Navigated to Update Watchlist Page");
        }
        click(watchlistPageObjects.EditWatchlist(), "Edit/Update Watchlist");
        click(watchlistPageObjects.AppliedAll(), "Applied All");
        click(watchlistPageObjects.AppliedPayout(), "Applied to Payout");
        click(watchlistPageObjects.AppliedSendout(), "Applied to Sendout");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        scrollDown(50);
        click(watchlistPageObjects.AddAlias(), "Add Alias");
        waitSleep(3000);

        if (isVisible(watchlistPageObjects.ManageAliases(), getText(watchlistPageObjects.ManageAliases()))) {
            LoggingUtils.info("Navigated the Manage Aliases Modal");
            type(watchlistPageObjects.AliasLName1(), "Aliases Last Name:", "lastalias");
            type(watchlistPageObjects.AliasMName1(), "Aliases First Name:", "firstalias");
            type(watchlistPageObjects.AliasFName1(), "Aliases Middle Name:", "Als");
            click(watchlistPageObjects.AliasNoMName(), "Alias No Middle Name");
            click(watchlistPageObjects.SaveAlias(), "Save Alias");
            waitSleep(5000);
            assertEqual(getText(watchlistPageObjects.Successful()), "Success");
            LoggingUtils.info("Success, Alias successfully added!");
            click(watchlistPageObjects.SaveOK(), "Save OK");
            scrollDown(100);
            waitSleep(5000);
            LoggingUtils.info("The Added Alias Information will display and Watchlist Logs");
            scrollUp2(100);
            click(watchlistPageObjects.SaveWatchlist(), "Save Update Watchlist");
            assertEqual(getText(watchlistPageObjects.Successful()), "Success");
            LoggingUtils.info("Success, Watchlist successfully updated!");
            click(watchlistPageObjects.SaveOK(), "OK");

        }
    }
    public void WatchlistTC03() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.AddWatchlist(), "Add Watchlist");
        click(watchlistPageObjects.AddWatchlistByCompanyName(), "Add Watchlist by Company Name");
        String CompanyName= reader.getCompanyName();
        type(watchlistPageObjects.CompanyName(), "Company/Employer Name",CompanyName);
        click(watchlistPageObjects.AppliedAll(), "Applied All");
        click(watchlistPageObjects.AppliedPayout(), "Applied to Payout");
        click(watchlistPageObjects.AppliedSendout(), "Applied to Sendout");
        click(watchlistPageObjects.IsActive(), "Is Active?, Yes");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.SaveWatchlist());
        click(watchlistPageObjects.SaveWatchlist(), "Save Watchlist");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.Successful()), "Success");
        LoggingUtils.info("Success, Watchlist successfully added!");
        click(watchlistPageObjects.SaveOK(), "Save OK");
        waitSleep(5000);
        if (isVisible(watchlistPageObjects.WatchlistUpdate(), getText(watchlistPageObjects.WatchlistUpdate()))) {
            LoggingUtils.info("Navigated to Update Watchlist Page");
        }
        click(watchlistPageObjects.EditWatchlist(), "Edit/Update Watchlist");
        click(watchlistPageObjects.AppliedAll(), "Applied All");
        click(watchlistPageObjects.AppliedPayout(), "Applied to Payout");
        click(watchlistPageObjects.AppliedSendout(), "Applied to Sendout");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        scrollDown(50);
        click(watchlistPageObjects.AddAlias(), "Add Alias");
        waitSleep(3000);

        if (isVisible(watchlistPageObjects.ManageAliases(), getText(watchlistPageObjects.ManageAliases()))) {
            LoggingUtils.info("Navigated the Manage Aliases Modal");
            type(watchlistPageObjects.AliasCompanyName(), "Company Name:", "CompanyName");
            click(watchlistPageObjects.SaveAlias(), "Save Alias");
            waitSleep(5000);
            assertEqual(getText(watchlistPageObjects.Successful()), "Success");
            LoggingUtils.info("Success, Alias successfully added!");
            click(watchlistPageObjects.SaveOK(), "Save OK");
            scrollDown(100);
            waitSleep(5000);
            LoggingUtils.info("The Added Alias Information will display and Watchlist Logs");
            scrollUp2(100);
            click(watchlistPageObjects.SaveWatchlist(), "Save Update Watchlist");
            assertEqual(getText(watchlistPageObjects.Successful()), "Success");
            LoggingUtils.info("Success, Watchlist successfully updated!");
            click(watchlistPageObjects.SaveOK(), "OK");

        }
    }
    public void WatchlistTC04() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.AddWatchlistByGenInfo(), "Watchlist by General Information");
        type(watchlistPageObjects.lastNameW(), "Lastname ","Yeng");
        type(watchlistPageObjects.firstNameW(), "Firstname ", "Cha");
        type(watchlistPageObjects.middleNameW(), "Middlename ", "Lou");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        LoggingUtils.info("The Watchlist in General Information Records will Display.");
        waitSleep(5000);
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        String[] randomName = reader.getRandomName();
        type(sendOutPageObjects.lastName(), "Lastname ", randomName[1]);
        type(sendOutPageObjects.firstName(), "Firstname ", randomName[0]);
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
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", "Yeng");
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", "Cha");
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", "Lou");
        scrollDown(100);
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.r_ProvinceState(), "Receiver Province/State");
        click(sendOutPageObjects.r_ProvinceStateSelect(), "Receiver Selected Province/State");
        click(sendOutPageObjects.r_CityMunicipality(), "Receiver City Municipality");
        click(sendOutPageObjects.r_CityMunicipalitySelected(), "Receiver Selected City Municipality");
        type(sendOutPageObjects.r_HouseNoStreetBarangaySitio(), "Receiver House No. Street/Barangay/Sitio ", propertyReader.getproperty("HouseNoStreetBarangaySitio"));
        click(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ");
        type(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ", "2000");
        sendOutPageObjects.r_birthdate_Field().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ", "06");
        sendOutPageObjects.r_birthdate_Field().sendKeys(Keys.ARROW_LEFT);
        sendOutPageObjects.r_birthdate_Field().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ", "03");
        click(sendOutPageObjects.r_sex_Field(), "Receiver Sex Field ");
        click(sendOutPageObjects.r_selected_Sex_Field(), "Receiver Selected Sex Field ");
        click(sendOutPageObjects.no_ContactNo(), "Receiver No Contact No. ");
        scrollUp(driver);
        waitUntilLoadingGone(10000);
        waitUntilLoadingGone(10000);
        type(sendOutPageObjects.sourceOfFund(), "Source of Fund field ", propertyReader.getproperty("source_of_fund"));
        type(sendOutPageObjects.purpose(), "Purpose field ", propertyReader.getproperty("purpose"));
        type(sendOutPageObjects.relationToReceiver(), "Relation to Receiver field ", propertyReader.getproperty("relationshiptoreceiver"));
        type(sendOutPageObjects.messageToReceiver(), "Message to Receiver field ", propertyReader.getproperty("messagetoreceiver"));
        type(sendOutPageObjects.principalAmount(), "Principal Amount field ", "100");
        waitSleep(20000);
        scrollToElement(sendOutPageObjects.submitSendOut());
        click(sendOutPageObjects.submitSendOut(), "Submit SendOut Button");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.confirmSendOutButton(), "Confirm SendOut Button");
        waitUntilLoadingGone(10000);
        waitSleep(15000);
        assertEqual(getText(watchlistPageObjects.Compliance()), "For Compliance Assistance");
        String reqNumber = getText(sendOutPageObjects.reqNum());
        List<String> reqValues = Collections.singletonList(reqNumber);
        reader.writeReqNumData(reqValues);
        click(watchlistPageObjects.OK(), "OK");

    }
    public void WatchlistTC05() throws Exception {
        waitSleep(3000);
        click(watchlistPageObjects.AddWatchlistByMobileNum(), "Search Watchlist by Mobile Number");
        click(watchlistPageObjects.MobileNum(), "ML Money Mobile No.");
        type(watchlistPageObjects.MobileNum(), "ML Money Mobile No.","653241259");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        LoggingUtils.info("The Watchlist in Mobile Number Records will Display.");
        waitSleep(5000);
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        type(sendOutPageObjects.lastName(), "Lastname ","Siarott");
        type(sendOutPageObjects.firstName(), "Firstname ","Enriquee");
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
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", "Siarot");
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", "Enrique");
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", "Alferez");
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
        type(watchlistPageObjects.MobileNum(), "Receiver No Contact No. ","09653241259");
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
        waitSleep(15000);
        assertEqual(getText(watchlistPageObjects.Compliance()), "For Compliance Assistance");
        String reqNumber = getText(sendOutPageObjects.reqNum());
        List<String> reqValues = Collections.singletonList(reqNumber);
        reader.writeReqNumData(reqValues);
        click(watchlistPageObjects.OK(), "OK");

    }
    public void WatchlistTC06() throws Exception {
        waitSleep(3000);
        click(watchlistPageObjects.AddWatchlistByCompanyName(), "Search Watchlist by Company Name");
        type(watchlistPageObjects.CompanyName(), "Company/Employer Name","CCO TRADING");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        LoggingUtils.info("The Watchlist in Company/Employer Records will Display.");
        waitSleep(5000);
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        type(sendOutPageObjects.lastName(), "Lastname ","Roxas");
        type(sendOutPageObjects.firstName(), "Firstname ","Gabrielle");
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
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", "Siarot");
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", "Enrique");
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", "Alferez");
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
        type(watchlistPageObjects.MobileNum(), "Receiver No Contact No. ","09653241259");
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
        waitSleep(15000);
        assertEqual(getText(watchlistPageObjects.Compliance()), "For Compliance Assistance");
        String reqNumber = getText(sendOutPageObjects.reqNum());
        List<String> reqValues = Collections.singletonList(reqNumber);
        reader.writeReqNumData(reqValues);
        click(watchlistPageObjects.OK(), "OK");

    }
    public void WatchlistTC07() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.AddWatchlistByGenInfo(), "Watchlist by General Information");
        type(watchlistPageObjects.lastNameW(), "Lastname ","Wing");
        type(watchlistPageObjects.firstNameW(), "Firstname ", "Chao");
        type(watchlistPageObjects.middleNameW(), "Middlename ", "Ram");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        LoggingUtils.info("The Watchlist in General Information Records will Display.");
        waitSleep(5000);
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        String[] randomName = reader.getRandomName();
        type(sendOutPageObjects.lastName(), "Lastname ", randomName[1]);
        type(sendOutPageObjects.firstName(), "Firstname ", randomName[0]);
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
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", "Wing");
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", "Chao");
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", "Ram");
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
        type(watchlistPageObjects.MobileNum(), "Receiver No Contact No. ","09204785999");
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
        waitUntilLoadingGone(20000);
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
                waitSleep(15000);
                assertEqual(getText(watchlistPageObjects.Compliance()), "For Compliance Assistance");
                click(watchlistPageObjects.OK(), "OK");

            }
        }

    }
    public void WatchlistTC08() throws Exception {
        waitSleep(3000);
        click(watchlistPageObjects.AddWatchlistByMobileNum(), "Search Watchlist by Mobile Number");
        click(watchlistPageObjects.MobileNum(), "ML Money Mobile No.");
        type(watchlistPageObjects.MobileNum(), "ML Money Mobile No.","684539677");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        LoggingUtils.info("The Watchlist in Mobile Number Records will Display.");
        waitSleep(5000);
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        String[] randomName = reader.getRandomName();
        type(sendOutPageObjects.lastName(), "Lastname ", randomName[1]);
        type(sendOutPageObjects.firstName(), "Firstname ", randomName[0]);
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
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", "Siarot");
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", "Enrique");
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", "Alferez");
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
        type(watchlistPageObjects.MobileNum(), "Receiver No Contact No. ","09684539677");
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
                waitSleep(15000);
                assertEqual(getText(watchlistPageObjects.Compliance()), "For Compliance Assistance");
                click(watchlistPageObjects.OK(), "OK");

            }
        }
    }
    public void WatchlistTC09() throws Exception {
        waitSleep(3000);
        click(watchlistPageObjects.AddWatchlistByCompanyName(), "Search Watchlist by Company Name");
        type(watchlistPageObjects.CompanyName(), "Company/Employer Name","Solaris Horizons");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        LoggingUtils.info("The Watchlist in Company/Employer Records will Display.");
        waitSleep(5000);
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        type(sendOutPageObjects.lastName(), "Lastname ", "Siarot");
        type(sendOutPageObjects.firstName(), "Firstname ", "Enrique");
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(10000);
        scrollToBottomOfPageWEB();
        scrollDown(100);
        scrollToElement(sendOutPageObjects.selectKYC());
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(sendOutPageObjects.searchReceivers(), "Search Receivers Button ");
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.addNewReceivers(), "Add new Receiver ");
        waitUntilLoadingGone(10000);
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", "Siarots");
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", "Enriques");
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", "Testings");
        scrollDown(100);
        waitUntilLoadingGone(10000);
        click(sendOutPageObjects.r_ProvinceState(), "Receiver Province/State");
        click(sendOutPageObjects.r_ProvinceStateSelect(), "Receiver Selected Province/State");
        click(sendOutPageObjects.r_CityMunicipality(), "Receiver City Municipality");
        click(sendOutPageObjects.r_CityMunicipalitySelected(), "Receiver Selected City Municipality");
        type(sendOutPageObjects.r_HouseNoStreetBarangaySitio(), "Receiver House No. Street/Barangay/Sitio ", propertyReader.getproperty("HouseNoStreetBarangaySitio"));
        click(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ");
        type(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ", "2004");
        sendOutPageObjects.r_birthdate_Field().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ", "04");
        sendOutPageObjects.r_birthdate_Field().sendKeys(Keys.ARROW_LEFT);
        sendOutPageObjects.r_birthdate_Field().sendKeys(Keys.ARROW_LEFT);
        type(sendOutPageObjects.r_birthdate_Field(), "Receiver Birthdate field ", "02");
        click(sendOutPageObjects.r_sex_Field(), "Receiver Sex Field ");
        click(sendOutPageObjects.r_selected_Sex_Field(), "Receiver Selected Sex Field ");
        type(watchlistPageObjects.MobileNum(), "Receiver No Contact No. ","09310241077");
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
        waitSleep(15000);
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
                waitSleep(15000);
                assertEqual(getText(watchlistPageObjects.Compliance()), "For Compliance Assistance");
                click(watchlistPageObjects.OK(), "OK");

            }
        }
    }
    public void WatchlistTC10() throws Exception {
        click(watchlistPageObjects.AddWatchlistByGenInfo(), "Search Watchlist by General Information");
        type(watchlistPageObjects.lastNameW(), "Lastname ","Yeng");
        type(watchlistPageObjects.firstNameW(), "Firstname ", "Cha");
        type(watchlistPageObjects.middleNameW(), "Middlename ", "Lou");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        waitUntilLoadingGone(10000);
        LoggingUtils.info("The Watchlist in General Information Records will Display.");
        click(watchlistPageObjects.ViewWatchL(), "Click View");
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        click(watchlistPageObjects.BackWatchlist(), "Go Back Search Watchlist");

        waitSleep(5000);
        click(watchlistPageObjects.AddWatchlistByMobileNum(), "Search Watchlist by Mobile Number");
        click(watchlistPageObjects.MobileNum(), "ML Money Mobile No.");
        type(watchlistPageObjects.MobileNum(), "ML Money Mobile No.","653241259");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        waitUntilLoadingGone(10000);
        LoggingUtils.info("The Watchlist in Mobile Number Records will Display.");
        click(watchlistPageObjects.ViewWatchL(), "Click View");
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        click(watchlistPageObjects.BackWatchlist(), "Go Back Search Watchlist");

        waitSleep(5000);
        click(watchlistPageObjects.AddWatchlistByCompanyName(), "Search Watchlist by Company Name");
        type(watchlistPageObjects.CompanyName(), "Company/Employer Name", "CCO TRADING");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        waitUntilLoadingGone(10000);
        LoggingUtils.info("The Watchlist in Company/Employer Records will Display.");
        click(watchlistPageObjects.ViewWatchL(), "Click View");
        waitSleep(5000);
        waitUntilLoadingGone(10000);
        click(watchlistPageObjects.BackWatchlist(), "Go Back Search Watchlist");

    }
    public void WatchlistTC11() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.AddWatchlist(), "Add Watchlist");
        click(watchlistPageObjects.AddWatchlistByGenInfo(), "Add Watchlist QCL by  General Information");
        String LNames= reader.getRandomLNames();
        type(watchlistPageObjects.GenInfoLName(), "General Information Last Name:",LNames);
        String FNames= reader.getRandomFNames();
        type(watchlistPageObjects.GenInfoFName(), "General Information First Name:", FNames);
        type(watchlistPageObjects.GenInfoMName(), "General Information Middle Name:", "testing");
        click(watchlistPageObjects.NoMName(), "No Middle Name");
        click(watchlistPageObjects.AppliedAll(), "Applied All");
        click(watchlistPageObjects.AppliedQCL(), "Applied to QCL");
        click(watchlistPageObjects.IsActive(), "Is Active?, Yes");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.SaveWatchlist());
        click(watchlistPageObjects.SaveWatchlist(), "Save Watchlist");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.Successful()), "Success");
        LoggingUtils.info("Success, Watchlist successfully added!");
        click(watchlistPageObjects.SaveOK(), "Save OK");
        waitSleep(5000);
        click(watchlistPageObjects.BackWatchlist(), "Go Back Search Watchlist");

        waitSleep(5000);
        click(watchlistPageObjects.AddWatchlist(), "Add Watchlist");
        click(watchlistPageObjects.AddWatchlistByMobileNum(), "Add QCL Watchlist by Mobile Number");
        String MobileNum= reader.getMobileNumber();
        click(watchlistPageObjects.MobileNum(), "ML Money Mobile No.");
        type(watchlistPageObjects.MobileNum(), "ML Money Mobile No.",MobileNum);
        waitSleep(5000);
        click(watchlistPageObjects.AppliedAll(), "Applied All");
        click(watchlistPageObjects.AppliedQCL(), "Applied to QCL");
        click(watchlistPageObjects.IsActive(), "Is Active?, Yes");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.SaveWatchlist());
        click(watchlistPageObjects.SaveWatchlist(), "Save Watchlist");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.Successful()), "Success");
        LoggingUtils.info("Success, Watchlist successfully added!");
        click(watchlistPageObjects.SaveOK(), "Save OK");
        waitSleep(5000);
        click(watchlistPageObjects.BackWatchlist(), "Go Back Search Watchlist");

        waitSleep(5000);
        click(watchlistPageObjects.AddWatchlist(), "Add Watchlist");
        click(watchlistPageObjects.AddWatchlistByCompanyName(), "Add QCL Watchlist by Company Name");
        String CompanyName = reader.getCompanyName();
        type(watchlistPageObjects.CompanyName(), "Company/Employer Name", CompanyName);
        click(watchlistPageObjects.AppliedAll(), "Applied All");
        click(watchlistPageObjects.AppliedQCL(), "Applied to QCL");
        click(watchlistPageObjects.IsActive(), "Is Active?, Yes");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.SaveWatchlist());
        click(watchlistPageObjects.SaveWatchlist(), "Save Watchlist");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.Successful()), "Success");
        LoggingUtils.info("Success, Watchlist successfully added!");
        click(watchlistPageObjects.SaveOK(), "Save OK");
        waitSleep(5000);
        click(watchlistPageObjects.BackWatchlist(), "Go Back Search Watchlist");
    }
    public void WatchlistTC12() throws Exception {
        click(watchlistPageObjects.AddWatchlistByGenInfo(), "Search Watchlist by General Information");
        type(watchlistPageObjects.lastNameW(), "Lastname ", "");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        assertEqual(getText(watchlistPageObjects.RequiredLname()), "Last name is required.");
        waitSleep(3000);
        type(watchlistPageObjects.lastNameW(), "Lastname ", "Test");
        type(watchlistPageObjects.firstNameW(), "Firstname ", "");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        assertEqual(getText(watchlistPageObjects.RequiredFname()), "First name is required.");
        waitSleep(3000);
        type(watchlistPageObjects.firstNameW(), "Firstname ", "test");

        click(watchlistPageObjects.AddWatchlistByMobileNum(), "Search Watchlist by Mobile Number");
        click(watchlistPageObjects.MobileNum(), "ML Money Mobile No.");
        type(watchlistPageObjects.MobileNum(), "ML Money Mobile No.","");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        assertEqual(getText(watchlistPageObjects.RequiredMobile()), "Mobile number is required.");
        waitSleep(3000);

        click(watchlistPageObjects.AddWatchlistByCompanyName(), "Search Watchlist by Company Name");
        type(watchlistPageObjects.CompanyName(), "Company/Employer Name", "");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        assertEqual(getText(watchlistPageObjects.RequiredCompany()), "Company Name is required.");
        waitSleep(3000);

    }
    public void WatchlistTC13() throws Exception {
        click(watchlistPageObjects.AddWatchlistByGenInfo(), "Search Watchlist by General Information");
        type(watchlistPageObjects.lastNameW(), "Lastname ", "Test");
        type(watchlistPageObjects.firstNameW(), "Firstname ", "Test");
        type(watchlistPageObjects.middleNameW(), "Middlename ", "test");
        click(watchlistPageObjects.ClearInputs(), "Clear All Inputs");
        LoggingUtils.info("All Inputted will cleared or deleted");
        waitSleep(3000);


        click(watchlistPageObjects.AddWatchlistByMobileNum(), "Search Watchlist by Mobile Number");
        click(watchlistPageObjects.MobileNum(), "ML Money Mobile No.");
        type(watchlistPageObjects.MobileNum(), "ML Money Mobile No.","365421155");
        click(watchlistPageObjects.ClearInputs(), "Clear All Inputs");
        LoggingUtils.info("Inputted will cleared or deleted");
        waitSleep(3000);

        click(watchlistPageObjects.AddWatchlistByCompanyName(), "Search Watchlist by Company Name");
        type(watchlistPageObjects.CompanyName(), "Company/Employer Name", "Testing");
        click(watchlistPageObjects.ClearInputs(), "Clear All Inputs");
        LoggingUtils.info("Inputted will cleared or deleted");
        waitSleep(3000);

    }
    public void WatchlistTC14() throws Exception {
        click(watchlistPageObjects.AddWatchlistByGenInfo(), "Search Watchlist by General Information");
        type(watchlistPageObjects.lastNameW(), "Lastname ", "fgsdgdg");
        type(watchlistPageObjects.firstNameW(), "Firstname ", "gerg");
        type(watchlistPageObjects.middleNameW(), "Middlename ", "gerg");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        LoggingUtils.info("Watchlist is not added, empty records.");
        waitSleep(3000);


        click(watchlistPageObjects.AddWatchlistByMobileNum(), "Search Watchlist by Mobile Number");
        click(watchlistPageObjects.MobileNum(), "ML Money Mobile No.");
        type(watchlistPageObjects.MobileNum(), "ML Money Mobile No.","365421155");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        LoggingUtils.info("Watchlist is not added, empty records.");
        waitSleep(3000);

        click(watchlistPageObjects.AddWatchlistByCompanyName(), "Search Watchlist by Company Name");
        type(watchlistPageObjects.CompanyName(), "Company/Employer Name", "gergg");
        click(watchlistPageObjects.SearchWatchlist(), "Search Watchlist");
        LoggingUtils.info("Watchlist is not added, empty records.");
        waitSleep(3000);

    }
    public void WatchlistTC15() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.AddWatchlist(), "Add Watchlist");
        click(watchlistPageObjects.AddWatchlistByGenInfo(), "Add Watchlist by  General Information");
        type(watchlistPageObjects.GenInfoLName(), "General Information Last Name:", "");
        click(watchlistPageObjects.GenInfoFName(), "General Information First Name:");
        assertEqual(getText(watchlistPageObjects.RequiredLnamed()), "Last name is required.");
        type(watchlistPageObjects.GenInfoLName(), "General Information Last Name:", "testing");

        type(watchlistPageObjects.GenInfoFName(), "General Information First Name:", "");
        click(watchlistPageObjects.GenInfoMName(), "General Information Middle Name:");
        assertEqual(getText(watchlistPageObjects.RequiredFnamed()), "First name is required.");
        type(watchlistPageObjects.GenInfoFName(), "General Information First Name:", "testing");

        type(watchlistPageObjects.GenInfoMName(), "General Information Middle Name:", "");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.SaveWatchlist());
        click(watchlistPageObjects.SaveWatchlist(), "Save Watchlist");
        LoggingUtils.info("Middle name is required.");
        type(watchlistPageObjects.GenInfoMName(), "General Information Middle Name:", "testing");
        click(watchlistPageObjects.NoMName(), "No Middle Name");

        click(watchlistPageObjects.AppliedAll(), "Applied All");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.SaveWatchlist());
        click(watchlistPageObjects.SaveWatchlist(), "Save Watchlist");
        assertEqual(getText(watchlistPageObjects.RequiredApplied()), "At least one option must be selected");
        click(watchlistPageObjects.AppliedPayout(), "Applied to Payout");

        click(watchlistPageObjects.IsActive(), "Is Active?, Yes");
        watchlistPageObjects.RemarksWatch().clear();
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "");
        scrollDown(100);
        scrollToElement(watchlistPageObjects.SaveWatchlist());
        click(watchlistPageObjects.SaveWatchlist(), "Save Watchlist");
        assertEqual(getText(watchlistPageObjects.RequiredRem()), "Remarks is required.");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "tests");

    }
    public void WatchlistTC16() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.AddWatchlist(), "Add Watchlist");
        click(watchlistPageObjects.AddWatchlistByGenInfo(), "Add Watchlist by  General Information");
        type(watchlistPageObjects.lastNameW(), "Lastname ","Yeng");
        type(watchlistPageObjects.firstNameW(), "Firstname ", "Cha");
        type(watchlistPageObjects.middleNameW(), "Middlename ", "Lou");
        click(watchlistPageObjects.IsActive(), "Is Active?, Yes");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        waitSleep(3000);
        scrollToElement(watchlistPageObjects.SaveWatchlist());
        click(watchlistPageObjects.SaveWatchlist(), "Save Watchlist");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.AlreadyExist()), "Watchlist Already Exists");
        click(watchlistPageObjects.OK(), "OK");
    }
    public void WatchlistTC17() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.AddWatchlist(), "Add Watchlist");
        click(watchlistPageObjects.AddWatchlistByMobileNum(), "Add Watchlist by Mobile Number");
        click(watchlistPageObjects.MobileNum(), "ML Money Mobile No.");
        type(watchlistPageObjects.MobileNum(), "ML Money Mobile No.","653241259");
        click(watchlistPageObjects.IsActive(), "Is Active?, Yes");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        waitSleep(3000);
        scrollToElement(watchlistPageObjects.SaveWatchlist());
        click(watchlistPageObjects.SaveWatchlist(), "Save Watchlist");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.AlreadyExist()), "Watchlist Already Exists");
        click(watchlistPageObjects.OK(), "OK");
    }
    public void WatchlistTC18() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.AddWatchlist(), "Add Watchlist");
        click(watchlistPageObjects.AddWatchlistByCompanyName(), "Add Watchlist by Company Name");
        type(watchlistPageObjects.CompanyName(), "Company/Employer Name","CCO TRADING");
        click(watchlistPageObjects.IsActive(), "Is Active?, Yes");
        type(watchlistPageObjects.RemarksWatch(), "Remarks :", "Testing");
        waitSleep(3000);
        scrollToElement(watchlistPageObjects.SaveWatchlist());
        click(watchlistPageObjects.SaveWatchlist(), "Save Watchlist");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.AlreadyExist()), "Watchlist Already Exists");
        click(watchlistPageObjects.OK(), "OK");
    }
    public void WatchlistTC19() throws Exception {
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendoutPartnerMoneygramPageObjects.sendoutTransactionLink(), "Sendout Transaction");
        click(sendoutPartnerMoneygramPageObjects.partnerSendout(), "Partner Sendout Dropdown Button");
        waitSleep(5000);
        if (isVisible(sendoutPartnerMoneygramPageObjects.sendoutPartnerText(), getText(sendoutPartnerMoneygramPageObjects.sendoutPartnerText()))) {
            ExtentReporter.logPass("PS_TC_01", "Successfully Validated  Sendout Partner Page Navigation");
        } else {
            ExtentReporter.logFail("PS_TC_01", "Failed to Validate SendOut Partner Page Navigation");
            Assert.fail("Failed to Validate SendOut Partner Page Navigation");
        }
        waitSleep(20000);
        click(sendoutPartnerMoneygramPageObjects.selectPartner(), "Select Partner");
        click(sendoutPartnerMoneygramPageObjects.selectMoneygram(), "Select Moneygram in Dropdown");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        click(sendOutPageObjects.searchKYC(), "Search KYC button");
        type(sendOutPageObjects.lastName(), "Lastname ", "Roxas");
        type(sendOutPageObjects.firstName(), "Firstname ", "Gabrielle");
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        scrollToElement(sendOutPageObjects.viewButton());
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollDown(100);
        waitSleep(8000);
        scrollToBottomOfPageWEB();
        scrollToElement(sendOutPageObjects.selectKYC());
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        waitSleep(10000);
        assertEqual(getText(watchlistPageObjects.Compliance()), "For Compliance Assistance");
        String reqNumber = getText(sendOutPageObjects.reqNum());
        List<String> reqValues = Collections.singletonList(reqNumber);
        reader.writeReqNumData(reqValues);
        click(watchlistPageObjects.OK(), "OK");

    }
    public void WatchlistTC20() throws Exception {
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendoutPartnerMoneygramPageObjects.sendoutTransactionLink(), "Sendout Transaction");
        click(sendoutPartnerMoneygramPageObjects.partnerSendout(), "Partner Sendout Dropdown Button");
        waitSleep(5000);
        if (isVisible(sendoutPartnerMoneygramPageObjects.sendoutPartnerText(), getText(sendoutPartnerMoneygramPageObjects.sendoutPartnerText()))) {
            ExtentReporter.logPass("PS_TC_01", "Successfully Validated  Sendout Partner Page Navigation");
        } else {
            ExtentReporter.logFail("PS_TC_01", "Failed to Validate SendOut Partner Page Navigation");
            Assert.fail("Failed to Validate SendOut Partner Page Navigation");
        }
        waitSleep(20000);
        click(sendoutPartnerMoneygramPageObjects.selectPartner(), "Select Partner");
        click(sendoutPartnerMoneygramPageObjects.selectWesternUnion(), "Select Western Union in Dropdown");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        click(sendOutPageObjects.searchKYC(), "Search KYC button");
        type(sendOutPageObjects.lastName(), "Lastname ", "Roxas");
        type(sendOutPageObjects.firstName(), "Firstname ", "Gabrielle");
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        scrollToElement(sendOutPageObjects.viewButton());
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollDown(100);
        waitSleep(8000);
        scrollToBottomOfPageWEB();
        scrollToElement(sendOutPageObjects.selectKYC());
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        waitSleep(10000);
        assertEqual(getText(watchlistPageObjects.Compliance()), "For Compliance Assistance");
        String reqNumber = getText(sendOutPageObjects.reqNum());
        List<String> reqValues = Collections.singletonList(reqNumber);
        reader.writeReqNumData(reqValues);
        click(watchlistPageObjects.OK(), "OK");

    }
    public void WatchlistTC21() throws Exception {
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendoutPartnerMoneygramPageObjects.sendoutTransactionLink(), "Sendout Transaction");
        click(sendoutPartnerMoneygramPageObjects.partnerSendout(), "Partner Sendout Dropdown Button");
        waitSleep(10000);
        if (isVisible(sendoutPartnerMoneygramPageObjects.sendoutPartnerText(), getText(sendoutPartnerMoneygramPageObjects.sendoutPartnerText()))) {
            ExtentReporter.logPass("PS_TC_01", "Successfully Validated  Sendout Partner Page Navigation");
        } else {
            ExtentReporter.logFail("PS_TC_01", "Failed to Validate SendOut Partner Page Navigation");
            Assert.fail("Failed to Validate SendOut Partner Page Navigation");
        }
        waitSleep(20000);
        click(sendoutPartnerMoneygramPageObjects.selectPartner(), "Select Partner");
        click(sendoutPartnerMoneygramPageObjects.selectWesternUnion(), "Select Western Union in Dropdown");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        click(sendOutPageObjects.searchKYC(), "Search KYC button");
        type(sendOutPageObjects.lastName(), "Lastname ", "Torres");
        type(sendOutPageObjects.firstName(), "Firstname ", "Ley");
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        scrollToElement(sendOutPageObjects.viewButton());
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(5000);
        scrollDown(100);
        waitSleep(8000);
        scrollToBottomOfPageWEB();
        scrollToElement(sendOutPageObjects.selectKYC());
        click(sendOutPageObjects.selectKYC(), "Select KYC Button");
        waitUntilLoadingGone(10000);
        waitSleep(10000);

        scrollToElement(sendOutPageObjects.searchReceivers());
        click(sendOutPageObjects.searchReceivers(), "Search Receivers Button ");
        waitUntilLoadingGone(5000);
        scrollDown(50);
        LoggingUtils.info(getText(sendOutPageObjects.name_Text(1)));
        String selectedReceiverName = getText(sendOutPageObjects.name_Text(1));
        click(sendOutPageObjects.selectButton(), "Select Button");
        waitSleep(45000);
        try {
            if (isVisible(sendoutPartnerMoneygramPageObjects.restrictionModalOKButton(),"restriction Modal OK Button")){
                scrollDown(100);
                scrollToElement(sendoutPartnerMoneygramPageObjects.restrictionModalOKButton());
                click(sendoutPartnerMoneygramPageObjects.restrictionModalOKButton(),"OK Button");
                click(sendoutPartnerMoneygramPageObjects.nationalityReceivers(), "Nationality Dropdown Field");
                click(sendoutPartnerMoneygramPageObjects.selectedNationalityReceivers(), " Selected Nationality Receivers ");
                type(sendoutPartnerMoneygramPageObjects.contactNumberReceiver(), "Receiver's Contact Number", propertyReader.getproperty("Contact_number"));

            }

        }catch (Exception e){
            click(sendoutPartnerMoneygramPageObjects.nationalityReceivers(), "Nationality Dropdown Field");
            click(sendoutPartnerMoneygramPageObjects.selectedNationalityReceivers(), " Selected Nationality Receivers ");
            type(sendoutPartnerMoneygramPageObjects.contactNumberReceiver(), "Receiver's Contact Number", propertyReader.getproperty("Contact_number"));
            String value = getValue(sendOutPageObjects.r_LastName());
            String[] receiverNames = selectedReceiverName.split(",");
            boolean containsName = false;
            for (String name : receiverNames) {
                if (value.contains(name.trim())) { //loops the lastname text until comma
                    containsName = true;
                    break;
                }
            }
            if (containsName) {
                ExtentReporter.logPass("PS_TC_05", "Successfully Validate Search Receiver  ");
                LoggingUtils.info("Successfully Validate Search Receiver  ");
            } else {
                ExtentReporter.logFail("PS_TC_05", "Failed to Validate Search Receiver  ");
                LoggingUtils.error("Failed to Validate Search Receiver " + getValue(sendOutPageObjects.r_LastName()) + " Expected " + selectedReceiverName);
                Assert.fail("Failure due to Incorrect Details"); //assert the script to fail in testng
            }
        }
        scrollUp(driver);
        click(sendoutPartnerMoneygramPageObjects.sourceOfFund(),"Source of Fund Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedSourceOfFund(),"Selected Source of Fund");
        click(sendoutPartnerMoneygramPageObjects.purposeOfTransfer(),"Purpose of Transfer Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedPurposeOfTransfer(),"Selected Purpose of Transfer");
        click(sendoutPartnerMoneygramPageObjects.relationshipWithReceiver(),"Relationship with Receiver Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedRelationshipWithReceiver(),"Selected Relationship with Receiver");
        click(sendoutPartnerMoneygramPageObjects.deliveryOptions(),"Delivery Options Dropdown Button");
        click(sendoutPartnerMoneygramPageObjects.selectedDeliveryOptions10MinuteService(),"Selected Delivery Options 10 Minute Service");

        scrollToElement(sendoutPartnerMoneygramPageObjects.sendAmountField());
        String SendoutAmount = reader.getPartnerSendoutAmount();
        type(sendoutPartnerMoneygramPageObjects.sendAmountField(), "Valid Principal Amount field ", SendoutAmount);
        waitSleep(20000);
        scrollToElement(sendoutPartnerMoneygramPageObjects.submitButton());
        click(sendoutPartnerMoneygramPageObjects.submitButton(),"Submit Sendout Button");
        waitSleep(10000);
        scrollToElement(sendoutPartnerMoneygramPageObjects.confirmSendoutButton());
        click(sendoutPartnerMoneygramPageObjects.confirmSendoutButton(),"Confirm Sendout Button");
        waitSleep(40000);
        String referenceNumber = getText(sendoutPartnerMoneygramPageObjects.referenceNumber());
        List<String> kptnValues = Collections.singletonList(referenceNumber);
        reader.WesternUnionPartnerWatchlistKPTN(kptnValues);
        if(isVisible(sendoutPartnerMoneygramPageObjects.sendoutSuccessfulText(), getText(sendoutPartnerMoneygramPageObjects.sendoutSuccessfulText()))){
            ExtentReporter.logPass("PS_TC_13", "Successfully Sendout Partner Western Union");
        }else{
            ExtentReporter.logFail("PS_TC_13", "Fail to Verify Sendout Partner Western Union");
            Assert.fail("Fail to Verify Sendout Partner Western Union");
        }
        click(sendoutPartnerMoneygramPageObjects.proceedToPrintingButton(),"Proceed to Printing Button");
        click(sendoutPartnerMoneygramPageObjects.cancelInPrintingButton(),"Cancel In Printing Button");

        try{
            click(payoutPageObjects.payout_link(), "Payout");
            if(isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))){
                LoggingUtils.info("Navigated to Payout Page");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Payout Page "+ e);
        }

        click(payoutPageObjects.PartnerTransaction(), "Partner Transaction");
        waitUntilLoadingGone(10000);
        reader.refreshTestData();
        waitSleep(5000);
        String sendoutReference = reader.getSendOutWatchlistPartnerNum();
        type(payoutPageObjects.InputReference(), "Reference Number", sendoutReference);
        waitUntilLoadingGone(10000);
        waitSleep(20000);
        scrollToElement(payoutPageObjects.ClickOption());
        click(payoutPageObjects.ClickOption(), "Option");
        waitSleep(2000);
        click(payoutPageObjects.ChooseOption(), "Choose Partners");
        waitSleep(5000);
        scrollToElement(payoutPageObjects.SearchButton());
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitUntilLoadingGone(10000);
        waitSleep(5000);
        scrollToElement(payoutPageObjects.SearchKYC());
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
            waitSleep(10000);
            click(payoutPageObjects.PurposeOfTransaction(), "Purpose of Transaction");
            waitSleep(5000);
            click(payoutPageObjects.RelationToSender(), "Relation to Sender");
            waitUntilLoadingGone(5000);
            waitSleep(10000);
            waitUntilLoadingGone(10000);
            scrollToElement(payoutPageObjects.ClaimAmount());
            waitSleep(15000);
            click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");
        }
        if (payoutPageObjects.PayoutConfirm().isEnabled()) {
            waitSleep(10000);
            scrollToElement(payoutPageObjects.ConfirmPayout());
            click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
            waitUntilLoadingGone(10000);
            waitSleep(1000);
            waitUntilLoadingGone(10000);
            waitSleep(1000);
            assertEqual(getText(watchlistPageObjects.Compliance()), "For Compliance Assistance");
            click(watchlistPageObjects.OK(), "OK");


        }

    }
    public void WatchlistTC22() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "Amadia");
        type(kycPageObjects.firstName_field(), "First name field", "Donald");
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(10000);
        click(sendOutPageObjects.editButton(), "Edit Button ");
        scrollDown(50);
        if (kycPageObjects.WatchlStat().getText().contains("Watchlist Status")) {
            waitSleep(5000);
            click(sendOutPageObjects.WatchlistStat(), "Click Watchlist Status Button");
            click(sendOutPageObjects.UnderTerrorism(), "Under Terrorism");
//            click(sendOutPageObjects.NotExempted(), "Not Exempted");
            scrollDown(100);
            waitSleep(30000);
            scrollToElement(kycPageObjects.SaveChanges());
            click(kycPageObjects.SaveChanges(), "Save Changes");
            waitUntilLoadingGone(20000);
            assertEqual(getText(kycPageObjects.UserEditUpdated()), "Successfully updated KYC");
            LoggingUtils.info("Successfully updated KYC");
            click(kycPageObjects.OKButton(), "OK");
        }
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        type(sendOutPageObjects.lastName(), "Lastname ","Amadia");
        type(sendOutPageObjects.firstName(), "Firstname ","Donald");
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
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", "Siarot");
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", "Enrique");
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", "Alferez");
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
        type(watchlistPageObjects.MobileNum(), "Receiver No Contact No. ","09653241259");
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
    public void WatchlistTC23() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "Rose ann");
        type(kycPageObjects.firstName_field(), "First name field", "Taller");
        click(sendOutPageObjects.searchBtn(), "Search Button ");
        waitUntilLoadingGone(10000);
        waitSleep(10000);
        click(sendOutPageObjects.viewButton(), "View Button ");
        waitSleep(10000);
        click(sendOutPageObjects.editButton(), "Edit Button ");
        scrollDown(50);
        if (kycPageObjects.WatchlStat().getText().contains("Watchlist Status")) {
            waitSleep(5000);
            click(sendOutPageObjects.WatchlistStat(), "Click Watchlist Status Button");
            click(sendOutPageObjects.NotExempted(), "Not Exempted");

            scrollDown(100);
            waitSleep(30000);
            scrollToElement(kycPageObjects.SaveChanges());
            click(kycPageObjects.SaveChanges(), "Save Changes");
            waitUntilLoadingGone(20000);
            assertEqual(getText(kycPageObjects.UserEditUpdated()), "Successfully updated KYC");
            LoggingUtils.info("Successfully updated KYC");
            click(kycPageObjects.OKButton(), "OK");
        }
        click(sendOutPageObjects.sendOutLink(), "SendOut Page ");
        click(sendOutPageObjects.searchKYC(), "Search KYC button ");
        type(sendOutPageObjects.lastName(), "Lastname ","Rose ann");
        type(sendOutPageObjects.firstName(), "Firstname ","Taller");
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
        type(sendOutPageObjects.r_LastName(), "R_Lastname ", "Siarot");
        type(sendOutPageObjects.r_FirstName(), "R_Firstname ", "Enrique");
        type(sendOutPageObjects.r_MiddleName(), "R_Firstname ", "Alferez");
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
        type(watchlistPageObjects.MobileNum(), "Receiver No Contact No. ","09653241259");
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
}
