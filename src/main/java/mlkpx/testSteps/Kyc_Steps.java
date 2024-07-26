package mlkpx.testSteps;

import org.openqa.selenium.*;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;
public class Kyc_Steps extends Base_Steps {


    public void navigateKycPage() throws Exception {
        try {
            click(kycPageObjects.kyc_link(), "Kyc Page");
            if (isVisible(kycPageObjects.kycPage_h2(), getText(kycPageObjects.kycPage_h2()))) {
                LoggingUtils.info("KYC page will display");
            }
        } catch (Exception e) {
            LoggingUtils.info("KYC page will not display " + e);
        }
    }
    public void searchRegisteredKYC_Valid() throws Exception {
        try {

            type(kycPageObjects.lastName_field(), "Last name field", propertyReader.getproperty("Last_name"));
            type(kycPageObjects.firstName_field(), "First name field", propertyReader.getproperty("First_name"));
            click(kycPageObjects.searchBtn(), "Search button");
            if (!kycPageObjects.buttonList().isEmpty()) {
                ExtentReporter.logPass("searchRegisteredKYC_Valid", "Successfully Search KYC");
            }
        } catch (Exception e) {
            ExtentReporter.logFail("searchRegisteredKYC_Valid", "" + e);
        }
    }
    public void searchRegisteredKYC_Invalid() {
        try {
            type(kycPageObjects.lastName_field(), "Last name field", "");
            type(kycPageObjects.firstName_field(), "First name field", "");
            click(kycPageObjects.searchBtn(), "Search button");
            assertEqual(getText(kycPageObjects.lastName_required()), "LAST NAME IS REQUIRED.");
            assertEqual(getText(kycPageObjects.firstName_required()), "FIRST NAME IS REQUIRED.");
        } catch (Exception e) {
            ExtentReporter.logFail("searchRegisteredKYC_Invalid", "" + e);
        }
    }
    public void searchRegisteredKYC_Invalid03() {
        try {
            type(kycPageObjects.lastName_field(), "Numeric Last name field", "45645");
            type(kycPageObjects.firstName_field(), "Numeric First name field", "456456");
            click(kycPageObjects.searchBtn(), "Search button");
            ExtentReporter.logPass("searchRegisteredKYC_Invalid03", "Can't Input Numbers" +
                    " Cannot proceed to search or No Dat");
        } catch (Exception e) {
            ExtentReporter.logFail("searchRegisteredKYC_Invalid03", "" + e);
        }
    }
    public void searchRegisteredKYC_Invalid04() {
        try {
            type(kycPageObjects.lastName_field(), "Special Character Last name field", "#$%@$%%#^^");
            type(kycPageObjects.firstName_field(), "Special Character First name field", "#$%@$%%#^^");
            click(kycPageObjects.searchBtn(), "Search button");
            ExtentReporter.logPass("searchRegisteredKYC_Invalid04", "Can't Input Special Characters" +
                    "- Cannot proceed to search or No Data");
        } catch (Exception e) {
            ExtentReporter.logFail("searchRegisteredKYC_Invalid04", "" + e);
        }
    }
    public void searchRegisteredKYC_Invalid05() {
        try {
            type(kycPageObjects.lastName_field(), "60 Character Last name field", propertyReader.getproperty("MLast_name"));
            type(kycPageObjects.firstName_field(), "60 Character First name field", propertyReader.getproperty("MFirst_name"));
            type(kycPageObjects.middleName_field(), "60 Character Middle name field", propertyReader.getproperty("MMiddle_name"));
            type(kycPageObjects.suffix_field(), "Suffix field", "JRRRR");
            click(kycPageObjects.searchBtn(), "Search button");
            assertEqual(getText(kycPageObjects.lastName_max60()), "MAXIMUM OF 60 CHARACTERS.");
            assertEqual(getText(kycPageObjects.firstName_max60()), "MAXIMUM OF 60 CHARACTERS.");
            ExtentReporter.logPass("searchRegisteredKYC_Invalid05", "Can input only 5 letters in Suffix");
        } catch (Exception e) {
            ExtentReporter.logFail("searchRegisteredKYC_Invalid05", "" + e);
        }
    }
    public void AddNewKYC_ValidCancelAndLeave() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "one");
        type(kycPageObjects.firstName_field(), "First name field", "two");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }

        type(kycPageObjects.AddMName(), "Middle name field", "Alferez");
        click(kycPageObjects.Checkbox(), "Check Button");
        click(kycPageObjects.AddSuffix(), "Select Suffix");
        type(kycPageObjects.AddBirthPlace(), "Edit/Input Valid BirthDate", "Bohol, Philippines");
        click(kycPageObjects.SelectNational(), "Select Nationality");
        click(kycPageObjects.SelectCivilStatus(), "Select Civil Status");
        click(kycPageObjects.SelectGender(), "Select Gender at Birth");
        click(kycPageObjects.SelectCountry(), "Select Country Birth");


        if (kycPageObjects.ContactInfo().getText().contains("Contact Information")) {
            scrollDown(30);
            waitSleep(2000);
            click(kycPageObjects.MobileCheckout(), "Click Mobile Number");
            waitSleep(2000);
            type(kycPageObjects.MobileField(), "Input Mobile Number", "09203447377");
            waitSleep(2000);
            type(kycPageObjects.TelephoneField(), "Input Telephone", "02454321345");
            type(kycPageObjects.EmailField(), "Input Email", "testing@gmail.com");

        }
        if (kycPageObjects.CAddressInfo().getText().contains("CURRENT ADDRESS")) {
            click(kycPageObjects.SelectProvince(), "Select Province");
            click(kycPageObjects.SelectMunicipality(), "Select Municipality");
            type(kycPageObjects.HouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "Testing,testing,testing");
        }
        if (kycPageObjects.PAddressInfo().getText().contains("PERMANENT ADDRESS")) {
            click(kycPageObjects.PSelectProvince(), "Select Permanent Province");
            click(kycPageObjects.PSelectMunicipality(), "Select Permanent Municipality");
            type(kycPageObjects.PHouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "Testing,testing,testing");
            click(kycPageObjects.SameCurrentAddress(), "Click Checkout");
        }
        if (kycPageObjects.WorkNature().getText().contains("Nature of Work")) {
            click(kycPageObjects.SourceIncome(), "Select Source of Income");
            type(kycPageObjects.CompanyName(), "Select Company Employee Name", "Mlhuillier");
            click(kycPageObjects.ProductOffered(), "Select Product and Services");
            type(kycPageObjects.WorkAddress(), "Input Work Address", "Cebu City");
            click(kycPageObjects.PositionAtWork(), "Select Position at Work");
            click(kycPageObjects.NatureOfWork(), "Select Nature of Work");
        }
        if (kycPageObjects.Identification().getText().contains("ID")) {
            click(kycPageObjects.IDType(), "Select ID Type");
            type(kycPageObjects.IDNumber(), "Input ID Number", "1234567891011");
        }
        waitSleep(5000);
        if (kycPageObjects.FrontID().getText().contains("ID1")) {
            scrollToElement(kycPageObjects.FCamera());
            click(kycPageObjects.FCamera(), "Select Camera ID 1");
            waitSleep(4000);
            scrollToElement(kycPageObjects.FCapture());
            click(kycPageObjects.FCapture(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.FSet(), "Select Set Photo");
        }
        if (kycPageObjects.BackID().getText().contains("ID2")) {
            click(kycPageObjects.BCamera(), "Select Camera ID 2");
            waitSleep(4000);
            scrollToElement(kycPageObjects.BCapture());
            click(kycPageObjects.BCapture(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.BSet(), "Select Set Photo");
        }
        if (kycPageObjects.BackID2().getText().contains("ID3")) {
            click(kycPageObjects.BCamera2(), "Select Camera ID 3");
            waitSleep(4000);
            scrollToElement(kycPageObjects.BCapture2());
            click(kycPageObjects.BCapture2(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.BSet2(), "Select Set Photo");
            waitSleep(3000);
        }
        if (kycPageObjects.CustomerPhoto().getText().contains("CUSTOMER'S PHOTO")) {
            click(kycPageObjects.CCamera(), "Select Camera");
            waitSleep(4000);
            scrollToElement(kycPageObjects.CCapture());
            click(kycPageObjects.CCapture(), "Select Capture Photo");
            waitSleep(4000);
            click(kycPageObjects.CSet(), "Select Set Photo");
            waitSleep(4000);
        }

        if (kycPageObjects.KYCTopPhoto().getText().contains("KYC TOP")) {
            click(kycPageObjects.KYCTCamera(), "Select Camera");
            waitSleep(4000);
            scrollToElement(kycPageObjects.KYCTCapture());
            click(kycPageObjects.KYCTCapture(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.KYCTSet(), "Select Set Photo");
        }
        if (kycPageObjects.KYCBPhoto().getText().contains("KYC BOTTOM")) {
            click(kycPageObjects.KYCBCamera(), "Select Camera");
            waitSleep(4000);
            scrollToElement(kycPageObjects.KYCBCapture());
            click(kycPageObjects.KYCBCapture(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.KYCBSet(), "Select Set Photo");
        }
        scrollDown(100);
        scrollToElement(kycPageObjects.CancelNewKYC());
        click(kycPageObjects.CancelNewKYC(), "Click Cancel");
        assertEqual(getText(kycPageObjects.UnsavedChanges()), "Unsaved Changes");
        LoggingUtils.info("Unsaved Changes\n" +
                "You have unsaved changes. Are you sure you want to leave?");
        click(kycPageObjects.StayNewKYC(), "Stay");
        click(kycPageObjects.CancelNewKYC(), "Click Cancel");
        assertEqual(getText(kycPageObjects.UnsavedChanges()), "Unsaved Changes");
        LoggingUtils.info("Unsaved Changes\n" +
                "You have unsaved changes. Are you sure you want to leave?");
        click(kycPageObjects.LeaveNewKYC(), "Leave");
        waitUntilLoadingGone(5000);

    }
    public void VerifyAddKYCInvalidInputs() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "Elpmas");
        type(kycPageObjects.firstName_field(), "First name field", "Gnitset");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }
        type(kycPageObjects.AddMName(), "Middle name field", "");
        click(kycPageObjects.Checkbox(), "Check Button");
        assertEqual(getText(kycPageObjects.MnameRequired()), "Middle Name is required.");
        type(kycPageObjects.AddMName(), "Middle name field", "TRTFRTYFGHFCFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
        click(kycPageObjects.AddSuffix(), "Select Suffix");
        assertEqual(getText(kycPageObjects.Mname60maxCharacter()), "Maximum of 60 characters.");

        kycPageObjects.AddMName().clear();
        type(kycPageObjects.AddMName(), "Middle name field", "As");
        type(kycPageObjects.AddBirthPlace(), "Edit/Input Valid BirthDate", "");
        click(kycPageObjects.AddSuffix(), "Select Suffix");
        assertEqual(getText(kycPageObjects.BirthPlaceRequired()), "Place of Birth is required.");
        type(kycPageObjects.AddBirthPlace(), "Edit/Input Valid BirthDate", "Bohol, Philippines");

        click(kycPageObjects.SelectEmptyNational(), "Select Nationality");
        click(kycPageObjects.AddMName(), "Middle name field");
        assertEqual(getText(kycPageObjects.NationalityRequired()), "Nationality is required.");
        click(kycPageObjects.SelectNational(), "Select Nationality");

        click(kycPageObjects.SelectEmptyCivilStatus(), "Select Civil Status");
        click(kycPageObjects.AddMName(), "Middle name field");
        assertEqual(getText(kycPageObjects.CivilStaRequired()), "Civil Status is required.");
        click(kycPageObjects.SelectCivilStatus(), "Select Civil Status");

        click(kycPageObjects.SelectEmptyGender(), "Select Empty Gender");
        click(kycPageObjects.AddSuffix(), "Select Suffix");
        assertEqual(getText(kycPageObjects.GenderRequired()), "Gender at Birth is required.");
        click(kycPageObjects.SelectGender(), "Select Gender at Birth");
        click(kycPageObjects.SelectCountry(), "Select Country Birth");

//        if (kycPageObjects.ContactInfo().getText().contains("Contact Information")) {
//            scrollDown(30);
//            waitSleep(2000);
//            click(kycPageObjects.MobileCheckout(), "Click Mobile Number");
//            waitSleep(2000);
//            type(kycPageObjects.MobileField(), "Input Mobile Number", "");
//            type(kycPageObjects.TelephoneField(), "Input Telephone", "");
//            waitSleep(2000);
//            assertEqual(getText(kycPageObjects.MobileNumRequired()), "Mobile No. is required.");
//            type(kycPageObjects.TelephoneField(), "Input Telephone", "02454321345");
//            type(kycPageObjects.EmailField(), "Input Email", "testing@gmail.com");
//
//        }


    }
    public void VerifyAddKYCContactInfo() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "Elpmas");
        type(kycPageObjects.firstName_field(), "First name field", "Gnitset");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }
        if (kycPageObjects.ContactInfo().getText().contains("Contact Information")) {
            scrollDown(30);
            waitSleep(2000);
            click(kycPageObjects.MobileCheckout(), "Click Mobile Number");
            waitSleep(2000);
            type(kycPageObjects.MobileField(), "Input Mobile Number", "09203447377");
            waitSleep(2000);
            type(kycPageObjects.TelephoneField(), "Input Telephone", "02454321345");
            type(kycPageObjects.EmailField(), "Input Email", "testing@gmail.com");
            waitSleep(2000);

        }
    }
    public void VerifyAddKYCContactInvalidInfo() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "Elpmas");
        type(kycPageObjects.firstName_field(), "First name field", "Gnitset");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }
        if (kycPageObjects.ContactInfo().getText().contains("Contact Information")) {
            scrollDown(30);
            waitSleep(2000);
            click(kycPageObjects.MobileCheckout(), "Click Mobile Number");
            waitSleep(2000);
            type(kycPageObjects.MobileField(), "Input Mobile Number", "");
            click(kycPageObjects.TelephoneField(), "Telephone");
            assertEqual(getText(kycPageObjects.MobileNumRequired()), "Mobile No. is required.");
            waitSleep(2000);
            type(kycPageObjects.MobileField(), "Input Mobile Number", "09203447377");
            type(kycPageObjects.TelephoneField(), "Input Telephone", "55677");
            click(kycPageObjects.EmailField(), "Input Email");
            assertEqual(getText(kycPageObjects.ValidTeleRequired()), "Please enter a valid telephone number");

            type(kycPageObjects.TelephoneField(), "Input Telephone", "06456456456");
            type(kycPageObjects.EmailField(), "Input Email", "testing");
            click(kycPageObjects.TelephoneField(), "Telephone");
            assertEqual(getText(kycPageObjects.InvalidEmail()), "Invalid email format.");
            waitSleep(1000);
            kycPageObjects.EmailField().clear();
            type(kycPageObjects.EmailField(), "Input Email", "GDGDHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
            click(kycPageObjects.TelephoneField(), "Telephone");
            assertEqual(getText(kycPageObjects.Max45CharEmail()), "Maximum of 45 characters.");
        }
    }
    public void AddKYCAddressInputs() throws Exception {

        type(kycPageObjects.lastName_field(), "Last name field", "one");
        type(kycPageObjects.firstName_field(), "First name field", "two");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }

        scrollDown(30);
        waitSleep(2000);
        if (kycPageObjects.CAddressInfo().getText().contains("CURRENT ADDRESS")) {
            LoggingUtils.info("Country select input is disabled and set to \"Philippines\".");
            click(kycPageObjects.SelectProvince(), "Select Province");
            LoggingUtils.info("Selected Province/State will display");
            click(kycPageObjects.SelectMunicipality(), "Select Municipality");
            LoggingUtils.info("Selected City/Municipality will display");
            type(kycPageObjects.HouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "Testing,testing,testing");
            LoggingUtils.info("Inputted Address will display");
        }
        if (kycPageObjects.PAddressInfo().getText().contains("PERMANENT ADDRESS")) {
            click(kycPageObjects.SameCurrentAddress(), "Click Checkout");
            LoggingUtils.info("Permanent address and Current address are display the same");
            click(kycPageObjects.SameCurrentAddress(), "Click Checkout");
            click(kycPageObjects.PSelectProvince(), "Select Permanent Province");
            LoggingUtils.info("Selected Province/State will display");
            click(kycPageObjects.PSelectMunicipality(), "Select Permanent Municipality");
            LoggingUtils.info("Selected City/Municipality will display");
            kycPageObjects.PHouseStreetInfo().clear();
            type(kycPageObjects.PHouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "Testing,testing,testing");
            LoggingUtils.info("Inputted Address will display");

        }
    }
    public void AddKYCAddressInvalidInputs() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "one");
        type(kycPageObjects.firstName_field(), "First name field", "two");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }

        scrollDown(30);
        waitSleep(2000);
        if (kycPageObjects.CAddressInfo().getText().contains("CURRENT ADDRESS")) {
            click(kycPageObjects.SelectEmptyProvince(), "Select Province");
            click(kycPageObjects.HouseStreetInfo(), "House No, Street/ Sitio/Baranggay");
            assertEqual(getText(kycPageObjects.ProvinceRequired()), "Province is required.");
            click(kycPageObjects.SelectProvince(), "Select Province");

            click(kycPageObjects.SelectEmptyMunicipality(), "Select Municipality");
            click(kycPageObjects.HouseStreetInfo(), "House No, Street/ Sitio/Baranggay");
            assertEqual(getText(kycPageObjects.CityRequired()), "City is required.");
            click(kycPageObjects.SelectMunicipality(), "Select Municipality");

//            type(kycPageObjects.HouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "BOGTONGBOD, CLARIN, BOHOL");
//            click(kycPageObjects.SelectMunicipality(), "Select Municipality");
//            assertEqual(getText(kycPageObjects.OnlyLetterAllowed()), "Only letters A-Z and numbers 0-9 are allowed.");
//            kycPageObjects.HouseStreetInfo().clear();
            type(kycPageObjects.HouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "456GFHH65Y7GN22KUIKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKMMMMMMMMMMMMMMMMMMMMMMUJY MNTRFJJJJJJJJJJJJJJJJJJJJJJJJJJJ456GFHH65Y7GN22KUIKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKMMMMMMMMMMMMMMMMMMMMMMUJY MNTRFJJJJJJJJJJJJJJJJJJJJJJJJJJJGJJJJJJJKKKKKKKKKKKKKKKKKKKKKKKKKKKKKGJJJJJJJKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
            click(kycPageObjects.SelectMunicipality(), "Select Municipality");
            assertEqual(getText(kycPageObjects.Address200Char()), "Maximum of 200 characters.");
            kycPageObjects.HouseStreetInfo().clear();
            type(kycPageObjects.HouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "Testing,testing,testing");
        }
        if (kycPageObjects.PAddressInfo().getText().contains("PERMANENT ADDRESS")) {
            click(kycPageObjects.PSelectEmptyProvince(), "Select Permanent Province");
            click(kycPageObjects.PHouseStreetInfo(), "House No, Street/ Sitio/Baranggay");
            assertEqual(getText(kycPageObjects.ProvinceRequired()), "Province is required.");
            click(kycPageObjects.PSelectProvince(), "Select Permanent Province");

            click(kycPageObjects.PSelectEmptyMunicipality(), "Select Permanent Municipality");
            click(kycPageObjects.PHouseStreetInfo(), "House No, Street/ Sitio/Baranggay");
            assertEqual(getText(kycPageObjects.CityRequired()), "City is required.");
            click(kycPageObjects.PSelectMunicipality(), "Select Permanent Municipality");

            kycPageObjects.PHouseStreetInfo().clear();
            type(kycPageObjects.PHouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "456GFHH65Y7GN22KUIKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKMMMMMMMMMMMMMMMMMMMMMMUJY MNTRFJJJJJJJJJJJJJJJJJJJJJJJJJJJ456GFHH65Y7GN22KUIKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKMMMMMMMMMMMMMMMMMMMMMMUJY MNTRFJJJJJJJJJJJJJJJJJJJJJJJJJJJGJJJJJJJKKKKKKKKKKKKKKKKKKKKKKKKKKKKKGJJJJJJJKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
            click(kycPageObjects.PSelectMunicipality(), "Select Permanent Municipality");
            assertEqual(getText(kycPageObjects.Address200Char()), "Maximum of 200 characters.");
            kycPageObjects.PHouseStreetInfo().clear();
            type(kycPageObjects.PHouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "Testing,testing,testing");


        }
    }
    public void AddKYCNatureWOrkInputs() throws Exception {

        type(kycPageObjects.lastName_field(), "Last name field", "one");
        type(kycPageObjects.firstName_field(), "First name field", "two");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }
        scrollDown(40);
        waitSleep(2000);

        if (kycPageObjects.WorkNature().getText().contains("Nature of Work")) {
            click(kycPageObjects.SalaryPayIncome(), "SALARY/PAY/WAGE/COMMISSION Source of Income");
            LoggingUtils.info("Salary/pay... will display and company/employer inputs, product/service select, work adress input, position select, nature of work select will be visible");
            type(kycPageObjects.CompanyName(), "Select Company Employee Name", "Mlhuillier");
            LoggingUtils.info("Company/Employer name will display");
            click(kycPageObjects.ProductOffered(), "Select Product and Services");
            LoggingUtils.info("Selected Services offered will display");
            type(kycPageObjects.WorkAddress(), "Input Work Address", "Cebu City");
            LoggingUtils.info("Work address will display");
            click(kycPageObjects.PositionAtWork(), "Select Position at Work");
            LoggingUtils.info("Selected position at work will display");
            click(kycPageObjects.NatureOfWork(), "Select Nature of Work");
            LoggingUtils.info("Selected Nature of work will display");

            waitSleep(2000);
            click(kycPageObjects.BusinessSelfEmployIncome(), "BUSINESS INCOME/SELF EMPLOYMENT Source of Income");
            LoggingUtils.info(" Business income/self-employment will display and company name input, product/service select, work adress input, position select, nature of work select will be visible");
            type(kycPageObjects.BusinessCompanyName(), "Select Business/Company Name", "Barber Shop");
            LoggingUtils.info("Business/Company name will display");
            click(kycPageObjects.BusinessProductOffered(), "Select Product and Services");
            LoggingUtils.info("Selected Services offered will display");
            type(kycPageObjects.BusinessWorkAddress(), "Input Work Address", "Cebu City");
            LoggingUtils.info("Work address will display");
            click(kycPageObjects.BusinessPositionAtWork(), "Select Position at Work");
            LoggingUtils.info("Selected position at work will display");
            click(kycPageObjects.BusinessNatureOfWork(), "Select Nature of Work");
            LoggingUtils.info("Selected Nature of work will display");

            waitSleep(2000);
            click(kycPageObjects.PensionEmployIncome(), "PENSION FOR RETIREE Source of Income");
            LoggingUtils.info("Pension for retiree will display and select receiving pension from, year retired input, and select work position will be visible");
            click(kycPageObjects.ReceivingPensionFrom(), "Select Receiving Pension From");
            LoggingUtils.info("Selected Receiving pension from will display");
            type(kycPageObjects.YearRetired(), "Select Product and Services", "2020");
            LoggingUtils.info("Inputted Year Retired will display");
            click(kycPageObjects.PositionUponRetirement(), "Select Posistion Upon Retirement");
            LoggingUtils.info("Selected Position upon retirement will display");

            waitSleep(2000);
            click(kycPageObjects.FinancialAssistEmployIncome(), "FINANCIAL ASSISTANCE FROM RELATIVE Source of Income");
            LoggingUtils.info("Selected FINANCIAL ASSISTANCE FROM RELATIVE will display and Remarks input will be visible");
            type(kycPageObjects.InputRemarks(), "Input Remarks", "Testing Testing");
            LoggingUtils.info("Inputted Remarks will display");

            waitSleep(2000);
            click(kycPageObjects.StudentScholarIncome(), "STUDENT SCHOLARSHIP ALLOWANCE Source of Income");
            LoggingUtils.info("STUDENT SCHOLARSHIP ALLOWANCE will display and School/Univ input, School Address input, Remarks input will be visible");
            type(kycPageObjects.InputSchool(), " Input School/University", "University Of San Carlos");
            LoggingUtils.info("Inputted School/University will display");
            type(kycPageObjects.InputSchoolAdd(), "Input School Address", "Talamban Cebu City");
            LoggingUtils.info("Inputted School/University Address will display");
            type(kycPageObjects.SchoolRemarks(), "Input Remarks", "Testing Testing");
            LoggingUtils.info("Inputted Remarks will display");

            waitSleep(2000);
            click(kycPageObjects.RemittanceIncome(), "REGULAR REMITTANCE ABROAD");
            LoggingUtils.info("REGULAR REMITTANCE ABROAD will display and Remarks input will be visible");
            type(kycPageObjects.RemittanceRemarks(), "Input Remarks", "Testing Testing");
            LoggingUtils.info("Inputted Remarks will display");

            waitSleep(2000);
            click(kycPageObjects.GovernmentIncome(), "GOVERNMENT AID/ASSITANCE/GRANT");
            LoggingUtils.info("GOVERNMENT AID/ASSITANCE/GRANT will display and Grant/Program Type input will be visible");
            type(kycPageObjects.ProgramType(), " Input Grant/Program Type", "Pantawid Pamilyang Pilipino Program");
            LoggingUtils.info("Inputted Grant/Program Type will display");

            waitSleep(2000);
            click(kycPageObjects.OtherIncome(), "OTHER SOURCE OF INCOME");
            LoggingUtils.info("OTHER SOURCE OF INCOME will display and Select Occupation,Source of funds input will be visible");
            click(kycPageObjects.OtherIncomeOccupation(), "Select Occupation");
            LoggingUtils.info("Selected Occupation will display");
            type(kycPageObjects.SourceOfFund(), "Input Source of Funds", "Other Job");
            LoggingUtils.info("Inputted Source of Funds will display");

        }
    }
    public void AddKYCNatureWOrkInvalidInputs() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "one");
        type(kycPageObjects.firstName_field(), "First name field", "two");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }
        scrollDown(40);
        waitSleep(2000);

        if (kycPageObjects.WorkNature().getText().contains("Nature of Work")) {
            click(kycPageObjects.SelectEmptySourceIncome(), "Select Empty Source of Income");
            click(kycPageObjects.IDNumber(), "Input ID Number");
            assertEqual(getText(kycPageObjects.SourceIncomeRequired()), "Source of Income is required.");
            click(kycPageObjects.SalaryPayIncome(), "SALARY/PAY/WAGE/COMMISSION Source of Income");

            type(kycPageObjects.CompanyName(), "Select Company Employee Name", "");
            click(kycPageObjects.EmptyProductOffered(), "Empty Product and Services");
            assertEqual(getText(kycPageObjects.CompanyInputRequired()), "Input is required.");
            type(kycPageObjects.CompanyName(), "Select Company Employee Name", "DRG645BFHYFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFYYYYYYYYYYYYYYYYYYYYYYYY");
            click(kycPageObjects.WorkAddress(), "Input Work Address");
            assertEqual(getText(kycPageObjects.Max45CharEmail()), "Maximum of 45 characters.");
            kycPageObjects.CompanyName().clear();
            type(kycPageObjects.CompanyName(), "Select Company Employee Name", "MLhuillier");

            click(kycPageObjects.EmptyProductOffered(), "Empty Product and Services");
            click(kycPageObjects.WorkAddress(), "Input Work Address");
            assertEqual(getText(kycPageObjects.CompanyInputRequired()), "Input is required.");
            click(kycPageObjects.ProductOffered(), "Select Product and Services");

            type(kycPageObjects.WorkAddress(), "Input Work Address", "45TGTGBGRTGTTTTTTT45TGTGBGRTGTTTTTTTTTTTTTTTTT4444444444444444444444GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG45TGTGBGRTGTTTTTTTTTTTTTTTTT4444444444444444444444GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGTTTTTTTTTT4444444444444444444444GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
            click(kycPageObjects.CompanyName(), "Select Company Employee Name");
            assertEqual(getText(kycPageObjects.Max100CharWork()), "Maximum of 100 characters.");
            kycPageObjects.WorkAddress().clear();
            type(kycPageObjects.WorkAddress(), "Input Work Address", "Cebu City");

            click(kycPageObjects.EmptyPositionAtWork(), "Select Empty Position at Work");
            click(kycPageObjects.CompanyName(), "Select Company Employee Name");
            assertEqual(getText(kycPageObjects.CompanyInputRequired()), "Input is required.");
            click(kycPageObjects.PositionAtWork(), "Select Position at Work");

            click(kycPageObjects.EmptyNatureOfWork(), "Select Empty Nature of Work");
            click(kycPageObjects.CompanyName(), "Select Company Employee Name");
            assertEqual(getText(kycPageObjects.CompanyInputRequired()), "Input is required.");
            click(kycPageObjects.NatureOfWork(), "Select Nature of Work");


            waitSleep(2000);
            click(kycPageObjects.BusinessSelfEmployIncome(), "BUSINESS INCOME/SELF EMPLOYMENT Source of Income");
            type(kycPageObjects.BusinessCompanyName(), "Select Empty Business/Company Name", "");
            click(kycPageObjects.EmptyBusinessProductOffered(), "Select Empty Product and Services");
            assertEqual(getText(kycPageObjects.CompanyInputRequired()), "Input is required.");
            type(kycPageObjects.BusinessCompanyName(), "Select Empty Business/Company Name", "HGFJHFFFFFFFFFFFFFFFFFFFFFFFFFFFFFGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
            click(kycPageObjects.EmptyBusinessProductOffered(), "Select Empty Product and Services");
            assertEqual(getText(kycPageObjects.Max45CharEmail()), "Maximum of 45 characters.");
            kycPageObjects.BusinessCompanyName().clear();
            type(kycPageObjects.BusinessCompanyName(), "Select Business/Company Name", "Barber Shop");

            click(kycPageObjects.EmptyBusinessProductOffered(), "Select Empty Product and Services");
            click(kycPageObjects.BusinessCompanyName(), "Business/Company Name");
            assertEqual(getText(kycPageObjects.CompanyInputRequired()), "Input is required.");
            click(kycPageObjects.BusinessProductOffered(), "Select Product and Services");

            type(kycPageObjects.BusinessWorkAddress(), "Input Empty Work Address", "HBFTHFTHTHTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTHBFTHFTHTHTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
            click(kycPageObjects.BusinessCompanyName(), "Business/Company Name");
            assertEqual(getText(kycPageObjects.Max100CharWork()), "Maximum of 100 characters.");
            kycPageObjects.BusinessWorkAddress().clear();
            type(kycPageObjects.BusinessWorkAddress(), "Input Work Address", "Cebu City");

            click(kycPageObjects.EmptyBusinessPositionAtWork(), "Select Empty Position at Work");
            click(kycPageObjects.BusinessCompanyName(), "Business/Company Name");
            assertEqual(getText(kycPageObjects.CompanyInputRequired()), "Input is required.");
            click(kycPageObjects.BusinessPositionAtWork(), "Select Position at Work");

            click(kycPageObjects.EmptyBusinessNatureOfWork(), "Select Empty Nature of Work");
            click(kycPageObjects.BusinessCompanyName(), "Business/Company Name");
            assertEqual(getText(kycPageObjects.CompanyInputRequired()), "Input is required.");
            click(kycPageObjects.BusinessNatureOfWork(), "Select Nature of Work");


            waitSleep(2000);
            click(kycPageObjects.PensionEmployIncome(), "PENSION FOR RETIREE Source of Income");
            click(kycPageObjects.EmptyReceivingPensionFrom(), "Select Empty Receiving Pension From");
            click(kycPageObjects.YearRetired(), "Select Year Retired");
            assertEqual(getText(kycPageObjects.CompanyInputRequired()), "Input is required.");
            click(kycPageObjects.ReceivingPensionFrom(), "Select Receiving Pension From");
            type(kycPageObjects.YearRetired(), "Select Year Retired", "2020");
            click(kycPageObjects.PositionUponRetirement(), "Select Position Upon Retirement");


            waitSleep(2000);
            click(kycPageObjects.StudentScholarIncome(), "STUDENT SCHOLARSHIP ALLOWANCE Source of Income");
            type(kycPageObjects.InputSchool(), " Input School/University", "");
            click(kycPageObjects.InputSchoolAdd(), "Input School Address");
            assertEqual(getText(kycPageObjects.CompanyInputRequired()), "Input is required.");
            type(kycPageObjects.InputSchool(), " Input School/University", "DFGDGDFGHGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRGGGGGGGGGGGGG");
            click(kycPageObjects.InputSchoolAdd(), "Input School Address");
            assertEqual(getText(kycPageObjects.Max45CharEmail()), "Maximum of 45 characters.");
            kycPageObjects.InputSchool().clear();
            type(kycPageObjects.InputSchool(), " Input School/University", "University Of San Carlos");

            type(kycPageObjects.InputSchoolAdd(), "Input School Address", "DFGDGDFGHGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRGGGGGGGGGGGGG");
            click(kycPageObjects.SchoolRemarks(), "Input Remarks");
            assertEqual(getText(kycPageObjects.Max100CharWork()), "Maximum of 100 characters.");
            kycPageObjects.InputSchoolAdd().clear();
            type(kycPageObjects.InputSchoolAdd(), "Input School Address", "Talamban Cebu City");
            type(kycPageObjects.SchoolRemarks(), "Input Remarks", "Testing Testing");

            waitSleep(2000);
            click(kycPageObjects.GovernmentIncome(), "GOVERNMENT AID/ASSITANCE/GRANT");
            type(kycPageObjects.ProgramType(), " Input Grant/Program Type", "GGGGGGGGGGGGGGGGGGGGGGGGEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEGGGGGGGGGGGGGGGGGGGGGGGGEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
            click(kycPageObjects.IDNumber(), "Input ID Number");
            assertEqual(getText(kycPageObjects.Max45CharEmail()), "Maximum of 45 characters.");
            kycPageObjects.ProgramType().clear();
            type(kycPageObjects.ProgramType(), " Input Grant/Program Type", "4ps");

            waitSleep(2000);
            click(kycPageObjects.OtherIncome(), "OTHER SOURCE OF INCOME");
            click(kycPageObjects.EmptyOccupation(), "Select Empty Occupation");
            click(kycPageObjects.SourceOfFund(), "Input Empty Source of Funds");
            assertEqual(getText(kycPageObjects.CompanyInputRequired()), "Input is required.");
            click(kycPageObjects.OtherIncomeOccupation(), "Select Occupation");

            type(kycPageObjects.SourceOfFund(), "Input Empty Source of Funds", "");
            click(kycPageObjects.IDNumber(), "Input ID Number");
            assertEqual(getText(kycPageObjects.CompanyInputRequired()), "Input is required.");
            type(kycPageObjects.SourceOfFund(), "Input Source of Funds", "Other Job");
        }
    }
    public void AddKYCIDInputs() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "one");
        type(kycPageObjects.firstName_field(), "First name field", "two");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }

        scrollDown(55);
        waitSleep(2000);
        if (kycPageObjects.Identification().getText().contains("ID")) {
            click(kycPageObjects.IDType(), "Select ID Type PHIL NATIONAL ID-PHILSYS");
            LoggingUtils.info("Selected ID \"PHIL NATIONAL ID-PHILSYS\" will display");
            type(kycPageObjects.IDNumber(), "Input ID Number", "1234567891011");
            LoggingUtils.info("Inputted ID No. will be accepted and display");

            click(kycPageObjects.IDTypeGSIS(), "Select ID Type GSIS (E-CARD)");
            LoggingUtils.info("Selected ID \"GSIS (E-CARD)\" will display and Expiry Date input is visible");
            type(kycPageObjects.IDNumber(), "Input ID Number", "00420240204");
            LoggingUtils.info("Inputted ID GSIS (E-CARD) No. will be accepted and display");
            click(kycPageObjects.ExpiryDate_field(), "ExpiryDate field");
            type(kycPageObjects.ExpiryDate_field(), "ExpiryDate field", "2050");
            kycPageObjects.ExpiryDate_field().sendKeys(Keys.ARROW_LEFT);
            type(kycPageObjects.ExpiryDate_field(), "ExpiryDate field", "06");
            kycPageObjects.ExpiryDate_field().sendKeys(Keys.ARROW_LEFT);
            kycPageObjects.ExpiryDate_field().sendKeys(Keys.ARROW_LEFT);
            type(kycPageObjects.ExpiryDate_field(), "ExpiryDate field", "11");
            LoggingUtils.info("Inputted Expiry Date will display");
            waitSleep(2000);

            click(kycPageObjects.IDTypeOther(), "Select ID Type Other ID's");
            LoggingUtils.info("Selected Other ID will display");
            type(kycPageObjects.OtherDetails(), "Other Details", "Testing");
            LoggingUtils.info("Inputted Other Details will display");
        }
        waitSleep(2000);


    }
    public void AddKYCIDInvalidInputs() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "one");
        type(kycPageObjects.firstName_field(), "First name field", "two");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }
        scrollDown(55);
        waitSleep(2000);
        if (kycPageObjects.Identification().getText().contains("ID")) {
            click(kycPageObjects.EmptyIDType(), "Select ID Type");
            click(kycPageObjects.EmptyIDType(), "Select Empty ID Type");
            click(kycPageObjects.IDNumber(), "Input ID Number");
            assertEqual(getText(kycPageObjects.IDTypeRequired()), "ID Type is required.");

            click(kycPageObjects.IDType(), "Select PhilSysID Type");
            type(kycPageObjects.IDNumber(), "Input ID Number", "910116HTH");
            click(kycPageObjects.IDType(), "Select ID Type");
            assertEqual(getText(kycPageObjects.IDNoWrong()), "Please input (PID + max 16 digits)");
            kycPageObjects.IDNumber().clear();
            type(kycPageObjects.IDNumber(), "Input ID Number", "1234567891011");

            click(kycPageObjects.IDTypeGSIS(), "Select ID Type GSIS (E-CARD)");
            type(kycPageObjects.IDNumber(), "Input ID Number", "56756NGHN");
            click(kycPageObjects.IDTypeGSIS(), "Select ID Type GSIS (E-CARD)");
            assertEqual(getText(kycPageObjects.IDGSISWrong()), "Please input (GSIS + max 11 digits)");
            kycPageObjects.IDNumber().clear();
            type(kycPageObjects.IDNumber(), "Input ID Number", "GSIS00420240204");

            click(kycPageObjects.ExpiryDate_field(), "ExpiryDate field");
            type(kycPageObjects.ExpiryDate_field(), "ExpiryDate field", "20");
            kycPageObjects.ExpiryDate_field().sendKeys(Keys.ARROW_LEFT);
            click(kycPageObjects.IDNumber(), "Input ID Number");
            assertEqual(getText(kycPageObjects.ExpDateRequired()), "Expiry Date is required.");
            kycPageObjects.ExpiryDate_field().clear();

            click(kycPageObjects.ExpiryDate_field(), "ExpiryDate field");
            type(kycPageObjects.ExpiryDate_field(), "ExpiryDate field", "2000");
            kycPageObjects.ExpiryDate_field().sendKeys(Keys.ARROW_LEFT);
            type(kycPageObjects.ExpiryDate_field(), "ExpiryDate field", "06");
            kycPageObjects.ExpiryDate_field().sendKeys(Keys.ARROW_LEFT);
            kycPageObjects.ExpiryDate_field().sendKeys(Keys.ARROW_LEFT);
            type(kycPageObjects.ExpiryDate_field(), "ExpiryDate field", "11");
            click(kycPageObjects.IDNumber(), "Input ID Number");
            assertEqual(getText(kycPageObjects.ExpDateAlready()), "Id is already expired.");
        }
        waitSleep(3000);

    }
    public void AddKYCCustomerPhotos() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "one");
        type(kycPageObjects.firstName_field(), "First name field", "two");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }
        scrollDown(55);
        waitSleep(5000);
        if (kycPageObjects.FrontID().getText().contains("ID1")) {

            click(kycPageObjects.FCamera(), "Select Camera ID 1");
            LoggingUtils.info("Selected Camera Source will display");
            waitSleep(4000);
            scrollToElement(kycPageObjects.FCapture());
            click(kycPageObjects.FCapture(), "Select Capture Photo");
            LoggingUtils.info(" Photo will be captured");
            waitSleep(2000);
            click(kycPageObjects.FSet(), "Select Set Photo");
            LoggingUtils.info("Photo will be set");
            click(kycPageObjects.ID1Image(), "Click ID Camera Button");
            LoggingUtils.info("Image Capture Modal will display");
            click(kycPageObjects.CloseImage(), "ID1 PREVIEW");
            waitSleep(1000);
            click(kycPageObjects.CancelSelectedImage(), "ID1 Cancel Selected Image");

        }
    }
    public void AddKYCCustomerPhotosTOPBOTTOM() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "one");
        type(kycPageObjects.firstName_field(), "First name field", "two");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }
        scrollDown(55);
        waitSleep(2000);
        if (kycPageObjects.CustomerPhoto().getText().contains("CUSTOMER'S PHOTO")) {
            click(kycPageObjects.CCamera(), "Select Camera");
            LoggingUtils.info("Selected Camera Source will display");
            waitSleep(4000);
            scrollToElement(kycPageObjects.CCapture());
            click(kycPageObjects.CCapture(), "Select Capture Photo");
            LoggingUtils.info(" Photo will be captured");
            waitSleep(4000);
            click(kycPageObjects.CSet(), "Select Set Photo");
            LoggingUtils.info("Photo will be set");
            click(kycPageObjects.CustomerImage(), "Click Customer Image");
            LoggingUtils.info("Image Capture Modal will display");
            click(kycPageObjects.CloseImage(), "Customer PREVIEW");
            waitSleep(1000);
            click(kycPageObjects.CancelSelectedImage(), "Customer Cancel Selected Image");

        }

        if (kycPageObjects.KYCTopPhoto().getText().contains("KYC TOP")) {
            click(kycPageObjects.KYCTCamera(), "Select Camera");
            LoggingUtils.info("Selected Camera Source will display");
            waitSleep(4000);
            scrollToElement(kycPageObjects.KYCTCapture());
            click(kycPageObjects.KYCTCapture(), "Select Capture Photo");
            LoggingUtils.info("Photo will be captured");
            waitSleep(2000);
            click(kycPageObjects.KYCTSet(), "Select Set Photo");
            LoggingUtils.info("Photo will be set");
            click(kycPageObjects.KYCTOPImage(), "Click KYC TOP Image");
            LoggingUtils.info("Image Capture Modal will display");
            click(kycPageObjects.CloseImage(), "KYC TOP PREVIEW");
            waitSleep(1000);
            click(kycPageObjects.CancelSelectedImage(), "KYC TOP Cancel Selected Image");

        }
        if (kycPageObjects.KYCBPhoto().getText().contains("KYC BOTTOM")) {
            click(kycPageObjects.KYCBCamera(), "Select Camera");
            LoggingUtils.info("Selected Camera Source will display");
            waitSleep(4000);
            scrollToElement(kycPageObjects.KYCBCapture());
            click(kycPageObjects.KYCBCapture(), "Select Capture Photo");
            LoggingUtils.info("Photo will be captured");
            waitSleep(2000);
            click(kycPageObjects.KYCBSet(), "Select Set Photo");
            LoggingUtils.info("Photo will be set");
            click(kycPageObjects.KYCBUTTOMImage(), "Click KYC BOTTOM Image");
            LoggingUtils.info("Image Capture Modal will display");
            click(kycPageObjects.CloseImage(), "KYC BOTTOM PREVIEW");
            waitSleep(1000);
            click(kycPageObjects.CancelSelectedImage(), "KYC BOTTOM Cancel Selected Image");
        }
    }
    public void ToVerifyCustomerPhotosSection() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "one");
        type(kycPageObjects.firstName_field(), "First name field", "two");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }
        scrollDown(55);
        waitSleep(2000);
        if (kycPageObjects.FrontID().getText().contains("ID1")) {
            assertEqual(getText(kycPageObjects.ID1Required()), "ID 1 Photo is required.");
            LoggingUtils.info("Prompt message \"ID 1 Photo is required.\" will display");

        }
        if (kycPageObjects.CustomerPhoto().getText().contains("CUSTOMER'S PHOTO")) {
//            assertEqual(getText(kycPageObjects.CustomerPhotoRequired()), "Customer's Photo is required.");
            LoggingUtils.info("Prompt message \"Customer's Photo is required.\" will display");
        }

        if (kycPageObjects.KYCTopPhoto().getText().contains("KYC TOP")) {
            assertEqual(getText(kycPageObjects.KYCTOPRequired()), "KYC Top Photo is required.");
            LoggingUtils.info("Prompt message \"KYC Top Photo is required.\" will display");
        }
        if (kycPageObjects.KYCBPhoto().getText().contains("KYC BOTTOM")) {
            assertEqual(getText(kycPageObjects.KYCBRequired()), "KYC Bottom Photo is required.");
            LoggingUtils.info("Prompt message \"KYC Bottom Photo is required.\" will display");
        }
    }
    public void ToVerifyBranchRemarks() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "one");
        type(kycPageObjects.firstName_field(), "First name field", "two");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }
        scrollDown(55);
        waitSleep(2000);
        if (isVisible(kycPageObjects.BranchRemarks(), getText(kycPageObjects.BranchRemarks()))) {
            LoggingUtils.info("Branch Remarks");
            scrollToElement(kycPageObjects.BranchRemarksButton());
            click(kycPageObjects.BranchRemarksButton(), "Click edit under branch remarks");
            LoggingUtils.info("Remarks Input box will be enabled");
            type(kycPageObjects.TypeBranchRemarks(), "Input remarks", "Testing Testing");
            LoggingUtils.info("Inputted remarks will display");
            click(kycPageObjects.BranchRemarksDone(), "Click Done branch remarks");
            LoggingUtils.info("After Clicking Done remarks will display");

        }

    }
    public void AddNewKYC_ValidSave() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "Amodia");
        type(kycPageObjects.firstName_field(), "First name field", "Donald");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", "2003");
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", "01");
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", "19");
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }

        type(kycPageObjects.AddMName(), "Middle name field", "Nalo");
        click(kycPageObjects.Checkbox(), "Check Button");
        click(kycPageObjects.AddSuffix(), "Select Suffix");
        type(kycPageObjects.AddBirthPlace(), "Edit/Input Valid BirthDate", "Bohol, Philippines");
        click(kycPageObjects.SelectNational(), "Select Nationality");
        click(kycPageObjects.SelectCivilStatus(), "Select Civil Status");
        click(kycPageObjects.SelectGender(), "Select Gender at Birth");
        click(kycPageObjects.SelectCountry(), "Select Country Birth");


        if (kycPageObjects.ContactInfo().getText().contains("Contact Information")) {
            scrollDown(30);
            waitSleep(2000);
            click(kycPageObjects.MobileCheckout(), "Click Mobile Number");
            waitSleep(2000);
            type(kycPageObjects.MobileField(), "Input Mobile Number", "09202837300");
            waitSleep(2000);
            type(kycPageObjects.TelephoneField(), "Input Telephone", "02454321345");
            type(kycPageObjects.EmailField(), "Input Email", "Donald@gmail.com");

        }
        if (kycPageObjects.CAddressInfo().getText().contains("CURRENT ADDRESS")) {
            click(kycPageObjects.SelectProvince(), "Select Province");
            click(kycPageObjects.SelectMunicipality(), "Select Municipality");
            type(kycPageObjects.HouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "Testing,testing,testing");
        }
        if (kycPageObjects.PAddressInfo().getText().contains("PERMANENT ADDRESS")) {
            click(kycPageObjects.PSelectProvince(), "Select Permanent Province");
            click(kycPageObjects.PSelectMunicipality(), "Select Permanent Municipality");
            type(kycPageObjects.PHouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "Testing,testing,testing");
            click(kycPageObjects.SameCurrentAddress(), "Click Checkout");
        }
        if (kycPageObjects.WorkNature().getText().contains("Nature of Work")) {
            click(kycPageObjects.SourceIncome(), "Select Source of Income");
            type(kycPageObjects.CompanyName(), "Select Company Employee Name", "Gaisano" +
                    "");
            click(kycPageObjects.ProductOffered(), "Select Product and Services");
            type(kycPageObjects.WorkAddress(), "Input Work Address", "Cebu City");
            click(kycPageObjects.PositionAtWork(), "Select Position at Work");
            click(kycPageObjects.NatureOfWork(), "Select Nature of Work");
        }
        if (kycPageObjects.Identification().getText().contains("ID")) {
            click(kycPageObjects.IDType(), "Select ID Type");
            type(kycPageObjects.IDNumber(), "Input ID Number", "1234511191011");
        }
        waitSleep(5000);
        if (kycPageObjects.FrontID().getText().contains("ID1")) {
            scrollToElement(kycPageObjects.FCamera());
            click(kycPageObjects.FCamera(), "Select Camera ID 1");
            waitSleep(4000);
            scrollToElement(kycPageObjects.FCapture());
            click(kycPageObjects.FCapture(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.FSet(), "Select Set Photo");
        }
        if (kycPageObjects.BackID().getText().contains("ID2")) {
            click(kycPageObjects.BCamera(), "Select Camera ID 2");
            waitSleep(4000);
            scrollToElement(kycPageObjects.BCapture());
            click(kycPageObjects.BCapture(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.BSet(), "Select Set Photo");
        }
        if (kycPageObjects.BackID2().getText().contains("ID3")) {
            click(kycPageObjects.BCamera2(), "Select Camera ID 3");
            waitSleep(4000);
            scrollToElement(kycPageObjects.BCapture2());
            click(kycPageObjects.BCapture2(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.BSet2(), "Select Set Photo");
            waitSleep(3000);
        }
        if (kycPageObjects.CustomerPhoto().getText().contains("CUSTOMER'S PHOTO")) {
            click(kycPageObjects.CCamera(), "Select Camera");
            waitSleep(4000);
            scrollToElement(kycPageObjects.CCapture());
            click(kycPageObjects.CCapture(), "Select Capture Photo");
            waitSleep(4000);
            click(kycPageObjects.CSet(), "Select Set Photo");
            waitSleep(4000);
        }

        if (kycPageObjects.KYCTopPhoto().getText().contains("KYC TOP")) {
            click(kycPageObjects.KYCTCamera(), "Select Camera");
            waitSleep(4000);
            scrollToElement(kycPageObjects.KYCTCapture());
            click(kycPageObjects.KYCTCapture(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.KYCTSet(), "Select Set Photo");
        }
        if (kycPageObjects.KYCBPhoto().getText().contains("KYC BOTTOM")) {
            click(kycPageObjects.KYCBCamera(), "Select Camera");
            waitSleep(4000);
            scrollToElement(kycPageObjects.KYCBCapture());
            click(kycPageObjects.KYCBCapture(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.KYCBSet(), "Select Set Photo");
        }
        scrollDown(100);
        scrollToElement(kycPageObjects.SaveNewKYC());
        click(kycPageObjects.SaveNewKYC(), "Save New KYC");
        waitUntilLoadingGone(5000);
        assertEqual(getText(kycPageObjects.UserSuccessfullyAdded()), "Successfully added KYC");
        LoggingUtils.info("Successfully added KYC\n" +
                "KYC for user has been added.");
        click(kycPageObjects.OKButton(), "OK");

    }
    public void AddNewKYCAlreadyExistUser() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "Anothername");
        type(kycPageObjects.firstName_field(), "First name field", "thisname");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.birthdate_field(), "Birthdate field");
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
        type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
        click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
        waitUntilLoadingGone(10000);
        waitSleep(30000);
        if (isVisible(kycPageObjects.addKycPage(), getText(kycPageObjects.addKycPage()))) {
            LoggingUtils.info("Add KYC page will display, Inputted Last name will display and not editable");
        }

        type(kycPageObjects.AddMName(), "Middle name field", "Alferez");
        click(kycPageObjects.Checkbox(), "Check Button");
        click(kycPageObjects.AddSuffix(), "Select Suffix");
        type(kycPageObjects.AddBirthPlace(), "Edit/Input Valid BirthDate", "Bohol, Philippines");
        click(kycPageObjects.SelectNational(), "Select Nationality");
        click(kycPageObjects.SelectCivilStatus(), "Select Civil Status");
        click(kycPageObjects.SelectGender(), "Select Gender at Birth");
        click(kycPageObjects.SelectCountry(), "Select Country Birth");


        if (kycPageObjects.ContactInfo().getText().contains("Contact Information")) {
            scrollDown(30);
            waitSleep(2000);
            click(kycPageObjects.MobileCheckout(), "Click Mobile Number");
            waitSleep(2000);
            type(kycPageObjects.MobileField(), "Input Mobile Number", "09203447379");
            waitSleep(2000);
            type(kycPageObjects.TelephoneField(), "Input Telephone", "02454321345");
            type(kycPageObjects.EmailField(), "Input Email", "testing@gmail.com");

        }
        if (kycPageObjects.CAddressInfo().getText().contains("CURRENT ADDRESS")) {
            click(kycPageObjects.SelectProvince(), "Select Province");
            click(kycPageObjects.SelectMunicipality(), "Select Municipality");
            type(kycPageObjects.HouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "Testing,testing,testing");
        }
        if (kycPageObjects.PAddressInfo().getText().contains("PERMANENT ADDRESS")) {
            click(kycPageObjects.PSelectProvince(), "Select Permanent Province");
            click(kycPageObjects.PSelectMunicipality(), "Select Permanent Municipality");
            type(kycPageObjects.PHouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "Testing,testing,testing");
            click(kycPageObjects.SameCurrentAddress(), "Click Checkout");
        }
        if (kycPageObjects.WorkNature().getText().contains("Nature of Work")) {
            click(kycPageObjects.SourceIncome(), "Select Source of Income");
            type(kycPageObjects.CompanyName(), "Select Company Employee Name", "Mlhuillier");
            click(kycPageObjects.ProductOffered(), "Select Product and Services");
            type(kycPageObjects.WorkAddress(), "Input Work Address", "Cebu City");
            click(kycPageObjects.PositionAtWork(), "Select Position at Work");
            click(kycPageObjects.NatureOfWork(), "Select Nature of Work");
        }
        if (kycPageObjects.Identification().getText().contains("ID")) {
            click(kycPageObjects.IDType(), "Select ID Type");
            type(kycPageObjects.IDNumber(), "Input ID Number", "1234567891011");
        }
        waitSleep(5000);
        if (kycPageObjects.FrontID().getText().contains("ID1")) {
            scrollToElement(kycPageObjects.FCamera());
            click(kycPageObjects.FCamera(), "Select Camera ID 1");
            waitSleep(4000);
            scrollToElement(kycPageObjects.FCapture());
            click(kycPageObjects.FCapture(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.FSet(), "Select Set Photo");
        }
        if (kycPageObjects.BackID().getText().contains("ID2")) {
            click(kycPageObjects.BCamera(), "Select Camera ID 2");
            waitSleep(4000);
            scrollToElement(kycPageObjects.BCapture());
            click(kycPageObjects.BCapture(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.BSet(), "Select Set Photo");
        }
        if (kycPageObjects.BackID2().getText().contains("ID3")) {
            click(kycPageObjects.BCamera2(), "Select Camera ID 3");
            waitSleep(4000);
            scrollToElement(kycPageObjects.BCapture2());
            click(kycPageObjects.BCapture2(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.BSet2(), "Select Set Photo");
            waitSleep(3000);
        }
        if (kycPageObjects.CustomerPhoto().getText().contains("CUSTOMER'S PHOTO")) {
            click(kycPageObjects.CCamera(), "Select Camera");
            waitSleep(4000);
            scrollToElement(kycPageObjects.CCapture());
            click(kycPageObjects.CCapture(), "Select Capture Photo");
            waitSleep(4000);
            click(kycPageObjects.CSet(), "Select Set Photo");
            waitSleep(4000);
        }
        if (kycPageObjects.KYCTopPhoto().getText().contains("KYC TOP")) {
            click(kycPageObjects.KYCTCamera(), "Select Camera");
            waitSleep(4000);
            scrollToElement(kycPageObjects.KYCTCapture());
            click(kycPageObjects.KYCTCapture(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.KYCTSet(), "Select Set Photo");
        }
        if (kycPageObjects.KYCBPhoto().getText().contains("KYC BOTTOM")) {
            click(kycPageObjects.KYCBCamera(), "Select Camera");
            waitSleep(4000);
            scrollToElement(kycPageObjects.KYCBCapture());
            click(kycPageObjects.KYCBCapture(), "Select Capture Photo");
            waitSleep(2000);
            click(kycPageObjects.KYCBSet(), "Select Set Photo");
        }
        scrollDown(100);
        scrollToElement(kycPageObjects.SaveNewKYC());
        click(kycPageObjects.SaveNewKYC(), "Save New KYC");
        waitUntilLoadingGone(5000);
        assertEqual(getText(kycPageObjects.UserAlreadyExist()), "KYC Already Exists in KPX");
        LoggingUtils.info("KYC Already Exists in KPX\n" +
                "The following existing KYC already contains some of the customer information");
        click(kycPageObjects.OKButton(), "OK");
    }
    public void EditRegisteredKYC() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "Newname");
        type(kycPageObjects.firstName_field(), "First name field", "thisname");
        click(kycPageObjects.searchBtn(), "Search button");
        click(kycPageObjects.ViewButtonKYC(), "View button");
        waitSleep(5000);
        if (isVisible(kycPageObjects.viewKycPage(), getText(kycPageObjects.viewKycPage()))) {
            LoggingUtils.info("View KYC page will display");
            click(kycPageObjects.EditKYC(), "Click Edit KYC");
        }
        scrollDown(60);
        waitSleep(5000);
        if (kycPageObjects.CustomerPhoto().getText().contains("CUSTOMER'S PHOTO")) {
            click(kycPageObjects.CCamera(), "Select Camera");
            waitSleep(4000);
            scrollToElement(kycPageObjects.CCapture());
            click(kycPageObjects.CCapture(), "Select Capture Photo");
            waitSleep(4000);
            click(kycPageObjects.CSet(), "Select Set Photo");
            waitSleep(4000);
        }
        scrollDown(100);
        scrollToElement(kycPageObjects.SaveChanges());
        click(kycPageObjects.SaveChanges(), "Save Changes");
        waitUntilLoadingGone(5000);
        assertEqual(getText(kycPageObjects.UserEditUpdated()), "Successfully updated KYC");
        LoggingUtils.info("Successfully updated KYC\n" +
                "KYC for Lastname and Firstname has been updated.");
        click(kycPageObjects.OKButton(), "OK");
    }
    public void EditExistingKYC() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "Newname");
        type(kycPageObjects.firstName_field(), "First name field", "thisname");
        click(kycPageObjects.searchBtn(), "Search button");
        LoggingUtils.info("Records will display");
        click(kycPageObjects.ViewButtonKYC(), "View button");
        LoggingUtils.info("Redirect to View KYC page, inputs are disabled  and edit button is visible");
        waitSleep(5000);
        if (isVisible(kycPageObjects.viewKycPage(), getText(kycPageObjects.viewKycPage()))) {
            LoggingUtils.info("View KYC page will display");
            click(kycPageObjects.EditKYC(), "Click Edit KYC");
        }
        scrollDown(20);
        waitSleep(5000);
        kycPageObjects.EmailField().clear();
        type(kycPageObjects.EmailField(), "Input Email", "enriquesiarot@gmail.com");

        scrollDown(100);
        scrollToElement(kycPageObjects.SaveChanges());
        click(kycPageObjects.SaveChanges(), "Save Changes");
        waitSleep(5000);
        assertEqual(getText(kycPageObjects.UserEditExist()), "KYC Already Exists in KPX");
        LoggingUtils.info("KYC Already Exists in KPX\n" +
                "The following existing KYC already contains some of the customer information (Email):");
        click(kycPageObjects.BackToSearchButton(), "Back to Search");
    }
    public void ViewKYCGetScore() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "Newname");
        type(kycPageObjects.firstName_field(), "First name field", "thisname");
        click(kycPageObjects.searchBtn(), "Search button");
        LoggingUtils.info("Records will display");
        click(kycPageObjects.ViewButtonKYC(), "View button");
        LoggingUtils.info("Redirect to View KYC page, inputs are disabled  and edit button is visible");
        waitSleep(5000);
        if (isVisible(kycPageObjects.viewKycPage(), getText(kycPageObjects.viewKycPage()))) {
            LoggingUtils.info("View KYC page will display");
            click(kycPageObjects.GetScoreKYC(), "Click Get Score");
        }

        waitSleep(5000);
        LoggingUtils.info("User Information will display, CKYC ID, name and Mobile Number");
        click(kycPageObjects.CloseButton(), "Close");
    }
    public void ViewKYCGetScoreDetails() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "Newname");
        type(kycPageObjects.firstName_field(), "First name field", "thisname");
        click(kycPageObjects.searchBtn(), "Search button");
        LoggingUtils.info("Records will display");
        click(kycPageObjects.ViewButtonKYC(), "View button");
        LoggingUtils.info("Redirect to View KYC page, inputs are disabled  and edit button is visible");
        waitSleep(5000);
        if (isVisible(kycPageObjects.viewKycPage(), getText(kycPageObjects.viewKycPage()))) {
            LoggingUtils.info("View KYC page will display");
            click(kycPageObjects.GetScoreDetailsKYC(), "Click Get Score Details");
            LoggingUtils.info("Score Details, BILLS PAYMENT, LOANS, QCL\n" +
                    "- User Information will display, CKYC ID, name and Mobile Number");
        }

        waitSleep(5000);
        LoggingUtils.info("Display Score Details, BILLS PAYMENT, LOANS, QCL\n" +
                "- User Information will display, CKYC ID, name and Mobile Number");
        click(kycPageObjects.CloseButton(), "Close");
    }
    public void ViewKYCPrintPDF() throws Exception {
        type(kycPageObjects.lastName_field(), "Last name field", "Newname");
        type(kycPageObjects.firstName_field(), "First name field", "thisname");
        click(kycPageObjects.searchBtn(), "Search button");
        LoggingUtils.info("Records will display");
        click(kycPageObjects.ViewButtonKYC(), "View button");
        LoggingUtils.info("Redirect to View KYC page, inputs are disabled  and edit button is visible");
        waitSleep(5000);
        if (isVisible(kycPageObjects.viewKycPage(), getText(kycPageObjects.viewKycPage()))) {
            LoggingUtils.info("View KYC page will display");
            click(kycPageObjects.GetPDFPrintKYC(), "Click Print PDF");
        }

        waitSleep(5000);
        assertEqual(getText(kycPageObjects.KYCRecord()), "KYC Record Generated");
        LoggingUtils.info("KYC Record Generated\n" +
                "Successfully generated KYC record.");
        click(kycPageObjects.OKButton(), "OK");
    }


}


