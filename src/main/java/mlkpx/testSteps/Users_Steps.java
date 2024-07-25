package mlkpx.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;


public class Users_Steps extends Base_Steps{

    public void U_TC_01()throws Exception{
        click(usersPageObjects.usersNav(), "Users Nav");
        if(isVisible(usersPageObjects.usersTextPage(), getText(usersPageObjects.usersTextPage()))){
            ExtentReporter.logPass("U_TC_01", "Successfully Navigate to the Users Page");
        }else{
            ExtentReporter.logFail("U_TC_01", "Fail to Navigate to the Users Page");
            Assert.fail("Fail to Navigate to the Users Page");
        }

    }
    public void U_TC_02()throws Exception{
        U_TC_01();
        click(usersPageObjects.usersDropDown(), "Users Drop Down");
        click(usersPageObjects.addBranchUserDropdown(), "Add Branch User Drop Down");
        if(isVisible(usersPageObjects.addBranchUserText(), getText(usersPageObjects.addBranchUserText()))){
            ExtentReporter.logPass("U_TC_02", "Successfully Navigate to the Add Branch Users");
        }else{
            ExtentReporter.logFail("U_TC_02", "Fail to Navigate to the Add Branch Users");
            Assert.fail("Fail to Navigate to the Add Branch Users");
        }
    }
    public void U_TC_03() throws Exception {
        U_TC_02();
        String resourceID = generateRandomResourceID(8);
        type(usersPageObjects.resourceID(), "Resource ID Field", resourceID);
        List<String> resourceIDs = new ArrayList<>();
        resourceIDs.add(resourceID);
        reader.getRandomResourceID(String.valueOf(resourceIDs));
        type(usersPageObjects.firstNameUserInfo(),"First Name Field", propertyReader.getproperty("firstnameBranchUser"));
        type(usersPageObjects.middleNameUserInfo(),"Middle Name Field", propertyReader.getproperty("middlenameBranchUser"));
        type(usersPageObjects.lastNameUserInfo(),"Last Name Field", propertyReader.getproperty("lastnameBranchUser"));
        type(usersPageObjects.emailUserInfo(),"Email Field", propertyReader.getproperty("emailBranchUser"));
        type(usersPageObjects.contactInfo(),"Contact Field", propertyReader.getproperty("contactBranchUser"));
        waitSleep(15000);
        click(usersPageObjects.roleTellerAutoApprove(),"Teller Auto Approve Role");
        click(usersPageObjects.selectedZoneVISAYAS(),"VISAYAS ZONE");
        waitSleep(13000);
        click(usersPageObjects.regionNameCebuCentralBRegion(),"Cebu Central B Region Region");
        waitSleep(17000);
        click(usersPageObjects.areaNameCentralBAreaA(),"Area Name Central B Area A");
        waitSleep(8000);
        click(usersPageObjects.branchNameMLFuente1(),"Branch Name ML Fuente 1");
        String lastName = propertyReader.getproperty("lastnameBranchUser");
        String username = generateUsername(lastName, resourceID);
        reader.getGenerateUsername(username);
        // Verify the username
        boolean isUsernameCorrect = verifyUsername(lastName, resourceID, username);
        if (isUsernameCorrect) {
            LoggingUtils.info("Username is correct: " + username);
        } else {
            LoggingUtils.error("Username is incorrect: " + username);
            Assert.fail("Failed to verify Username");
        }
        // Verify the password
        boolean isPasswordCorrect = verifyPassword(resourceID);
        if (isPasswordCorrect) {
            LoggingUtils.info("Password is correct: " + resourceID);

        } else {
            LoggingUtils.error("Password is incorrect: " + resourceID);
            Assert.fail("Failed to verify Password");
        }

        scrollToElement(usersPageObjects.saveChangesButton());
        click(usersPageObjects.saveChangesButton(),"Save Changes Button");
        click(usersPageObjects.confirmButton(),"Confirm Button");
        waitSleep(10000);
        if(isVisible(usersPageObjects.branchUserCreatedText(), getText(usersPageObjects.branchUserCreatedText()))){
            ExtentReporter.logPass("U_TC_03", "Successfully Adding New Branch User");
        }else{
            ExtentReporter.logFail("U_TC_03", "Fail to Create New Branch User");
            Assert.fail("Fail to Create New Branch User");
        }
        click(usersPageObjects.okButton(),"Ok Button");
    }


    public void U_TC_05()throws Exception{
        U_TC_02();
        type(usersPageObjects.resourceID(), "Resource ID Field", propertyReader.getproperty("sameResourceID"));
        type(usersPageObjects.firstNameUserInfo(),"First Name Field", propertyReader.getproperty("firstnameBranchUser"));
        type(usersPageObjects.middleNameUserInfo(),"Middle Name Field", propertyReader.getproperty("middlenameBranchUser"));
        type(usersPageObjects.lastNameUserInfo(),"Last Name Field", propertyReader.getproperty("lastnameBranchUser"));
        type(usersPageObjects.emailUserInfo(),"Email Field", propertyReader.getproperty("emailBranchUser"));
        type(usersPageObjects.contactInfo(),"Contact Field", propertyReader.getproperty("contactBranchUser"));
        waitSleep(15000);
        click(usersPageObjects.roleTellerAutoApprove(),"Teller Auto Approve Role");
        click(usersPageObjects.selectedZoneVISAYAS(),"VISAYAS ZONE");
        waitSleep(13000);
        click(usersPageObjects.regionNameCebuCentralBRegion(),"Cebu Central B Region Region");
        waitSleep(17000);
        click(usersPageObjects.areaNameCentralBAreaA(),"Area Name Central B Area A");
        waitSleep(8000);
        click(usersPageObjects.branchNameMLFuente1(),"Branch Name ML Fuente 1");
        scrollToElement(usersPageObjects.saveChangesButton());
        click(usersPageObjects.saveChangesButton(),"Save Changes Button");
        click(usersPageObjects.confirmButton(),"Confirm Button");
        waitSleep(5000);
        if(isVisible(usersPageObjects.unableToCreateUserText(), getText(usersPageObjects.unableToCreateUserText()))){
            ExtentReporter.logPass("U_TC_05", "Successfully verify Add Branch User - Existing Resource ID");
        }else{
            ExtentReporter.logFail("U_TC_05", "Fail to verify Add Branch User - Existing Resource ID");
            Assert.fail("Fail to verify Add Branch User - Existing Resource ID");
        }
        click(usersPageObjects.okButton(),"OK Button");
    }
    public void U_TC_06()throws Exception{
        U_TC_02();
        String resourceID = generateRandomResourceID(8);
        type(usersPageObjects.resourceID(), "Resource ID Field", resourceID);

        type(usersPageObjects.middleNameUserInfo(),"Middle Name Field", propertyReader.getproperty("middlenameBranchUser"));
        type(usersPageObjects.lastNameUserInfo(),"Last Name Field", propertyReader.getproperty("lastnameBranchUser"));
        type(usersPageObjects.emailUserInfo(),"Email Field", propertyReader.getproperty("emailBranchUser"));
        type(usersPageObjects.contactInfo(),"Contact Field", propertyReader.getproperty("contactBranchUser"));
        scrollToElement(usersPageObjects.saveChangesButton());
        click(usersPageObjects.saveChangesButton(),"Save Changes Button");
        click(usersPageObjects.middleNameText(),"Middle Name Text");
        if(isVisible(usersPageObjects.firstNameDangerText(), getText(usersPageObjects.firstNameDangerText()))){
            ExtentReporter.logPass("U_TC_06", "Successfully verify Add Branch User - Empty First Name");
        }else{
            ExtentReporter.logFail("U_TC_06", "Fail to verify Add Branch User - Empty First Name");
            Assert.fail("Fail to verify Add Branch User - Empty First Name");
        }

    }
    public void U_TC_07()throws Exception{
        U_TC_02();
        String resourceID = generateRandomResourceID(8);
        type(usersPageObjects.resourceID(), "Resource ID Field", resourceID);
        type(usersPageObjects.firstNameUserInfo(),"First Name Field", propertyReader.getproperty("firstnameBranchUser"));
        type(usersPageObjects.middleNameUserInfo(),"Middle Name Field", propertyReader.getproperty("middlenameBranchUser"));
        type(usersPageObjects.emailUserInfo(),"Email Field", propertyReader.getproperty("emailBranchUser"));

        type(usersPageObjects.contactInfo(),"Contact Field", propertyReader.getproperty("contactBranchUser"));
        scrollToElement(usersPageObjects.saveChangesButton());
        click(usersPageObjects.saveChangesButton(),"Save Changes Button");
        click(usersPageObjects.middleNameText(),"Middle Name Text");
        if(isVisible(usersPageObjects.lastNameDangerText(), getText(usersPageObjects.lastNameDangerText()))){
            ExtentReporter.logPass("U_TC_07", "Successfully verify Add Branch User - Empty Last Name");
        }else{
            ExtentReporter.logFail("U_TC_07", "Fail to verify Add Branch User - Empty Last Name");
            Assert.fail("Fail to verify Add Branch User - Empty Last Name");
        }

    }


    public void U_TC_08()throws Exception{
        U_TC_02();
        String resourceID = generateRandomResourceID(8);
        type(usersPageObjects.resourceID(), "Resource ID Field", resourceID);
        type(usersPageObjects.firstNameUserInfo(),"First Name Field", propertyReader.getproperty("firstnameBranchUser"));
        type(usersPageObjects.middleNameUserInfo(),"Middle Name Field", propertyReader.getproperty("middlenameBranchUser"));
        type(usersPageObjects.lastNameUserInfo(),"Last Name Field", propertyReader.getproperty("lastnameBranchUser"));

        type(usersPageObjects.contactInfo(),"Contact Field", propertyReader.getproperty("contactBranchUser"));
        waitSleep(20000);
        click(usersPageObjects.roleTellerAutoApprove(),"Teller Auto Approve Role");
        click(usersPageObjects.selectedZoneVISAYAS(),"VISAYAS ZONE");
        waitSleep(13000);
        click(usersPageObjects.regionNameCebuCentralBRegion(),"Cebu Central B Region Region");
        waitSleep(17000);
        click(usersPageObjects.areaNameCentralBAreaA(),"Area Name Central B Area A");
        waitSleep(8000);
        click(usersPageObjects.branchNameMLFuente1(),"Branch Name ML Fuente 1");
        scrollToElement(usersPageObjects.saveChangesButton());
        click(usersPageObjects.saveChangesButton(),"Save Changes Button");
        if(isVisible(usersPageObjects.emailDangerText(), getText(usersPageObjects.emailDangerText()))){
            ExtentReporter.logPass("U_TC_08", "Successfully verify Add Branch User - Empty Email");
        }else{
            ExtentReporter.logFail("U_TC_08", "Fail to verify Add Branch User - Empty Email");
            Assert.fail("Fail to verify Add Branch User - Empty Email");
        }

    }


    public void U_TC_09() throws Exception {
        U_TC_02();
        String resourceID = generateRandomResourceID(8);
        type(usersPageObjects.resourceID(), "Resource ID Field", resourceID);
        type(usersPageObjects.firstNameUserInfo(),"First Name Field", propertyReader.getproperty("firstnameBranchUser"));
        type(usersPageObjects.middleNameUserInfo(),"Middle Name Field", propertyReader.getproperty("middlenameBranchUser"));
        type(usersPageObjects.lastNameUserInfo(),"Last Name Field", propertyReader.getproperty("lastnameBranchUser"));
        type(usersPageObjects.emailUserInfo(),"Email Field", propertyReader.getproperty("emailBranchUser"));
        type(usersPageObjects.contactInfo(),"Contact Field", propertyReader.getproperty("contactBranchUser"));
        waitSleep(15000);

        click(usersPageObjects.selectedZoneVISAYAS(),"VISAYAS ZONE");
        waitSleep(13000);
        click(usersPageObjects.regionNameCebuCentralBRegion(),"Cebu Central B Region Region");
        waitSleep(17000);
        click(usersPageObjects.areaNameCentralBAreaA(),"Area Name Central B Area A");
        waitSleep(8000);
        click(usersPageObjects.branchNameMLFuente1(),"Branch Name ML Fuente 1");
        scrollToElement(usersPageObjects.saveChangesButton());
        click(usersPageObjects.saveChangesButton(),"Save Changes Button");
        click(usersPageObjects.saveChangesButton(),"Save Changes Button");

        if(isVisible(usersPageObjects.roleDangerText(), getText(usersPageObjects.roleDangerText()))){
            ExtentReporter.logPass("U_TC_09", "Successfully verify Add Branch User - Don't Select Role");
        }else{
            ExtentReporter.logFail("U_TC_09", "Fail to verify Add Branch User - Don't Select Role");
            Assert.fail("Fail to verify Add Branch User - Don't Select Role");
        }
    }
    public void U_TC_10() throws Exception {
        U_TC_02();
        String resourceID = generateRandomResourceID(8);
        type(usersPageObjects.resourceID(), "Resource ID Field", resourceID);
        type(usersPageObjects.firstNameUserInfo(),"First Name Field", propertyReader.getproperty("firstnameBranchUser"));
        type(usersPageObjects.middleNameUserInfo(),"Middle Name Field", propertyReader.getproperty("middlenameBranchUser"));
        type(usersPageObjects.lastNameUserInfo(),"Last Name Field", propertyReader.getproperty("lastnameBranchUser"));
        type(usersPageObjects.emailUserInfo(),"Email Field", propertyReader.getproperty("emailBranchUser"));
        type(usersPageObjects.contactInfo(),"Contact Field", propertyReader.getproperty("contactBranchUser"));
        waitSleep(15000);
        click(usersPageObjects.roleTellerAutoApprove(),"Teller Auto Approve Role");
        click(usersPageObjects.selectedInvalidZoneNEW(),"New ZONE invalid");
        waitSleep(7000);
        if(isVisible(usersPageObjects.noRegionText(), getText(usersPageObjects.noRegionText()))){
            ExtentReporter.logPass("U_TC_10", "Successfully verify Add Branch User - invalid Zone ");
        }else{
            ExtentReporter.logFail("U_TC_10", "Fail to verify Add Branch User - invalid Zone ");
            Assert.fail("Fail to verify Add Branch User - invalid Zone ");
        }
        click(usersPageObjects.okButton(),"OK button");
    }
    public void U_TC_11() throws Exception {
        U_TC_02();
        String resourceID = generateRandomResourceID(8);
        type(usersPageObjects.resourceID(), "Resource ID Field", resourceID);
        type(usersPageObjects.firstNameUserInfo(),"First Name Field", propertyReader.getproperty("firstnameBranchUser"));
        type(usersPageObjects.middleNameUserInfo(),"Middle Name Field", propertyReader.getproperty("middlenameBranchUser"));
        type(usersPageObjects.lastNameUserInfo(),"Last Name Field", propertyReader.getproperty("lastnameBranchUser"));
        type(usersPageObjects.emailUserInfo(),"Email Field", propertyReader.getproperty("emailBranchUser"));
        type(usersPageObjects.contactInfo(),"Contact Field", propertyReader.getproperty("contactBranchUser"));
        waitSleep(15000);
        click(usersPageObjects.roleTellerAutoApprove(),"Teller Auto Approve Role");
        click(usersPageObjects.selectedZoneVISAYAS(),"Visayas Zone");
        waitSleep(13000);
        click(usersPageObjects.invalidRegionSWQAFORTESTREGION(),"SWQA FORTEST REGION Region");
        waitSleep(10000);
        if(isVisible(usersPageObjects.noAreasFound(), getText(usersPageObjects.noAreasFound()))){
            ExtentReporter.logPass("U_TC_11", "Successfully verify Add Branch User - invalid Region Name");
        }else{
            ExtentReporter.logFail("U_TC_11", "Fail to verify Add Branch User - invalid Region Name");
            Assert.fail("Fail to verify Add Branch User - invalid Region Name");
        }
        click(usersPageObjects.okButton(),"OK button");
    }
    public void U_TC_12() throws Exception {
        U_TC_01();
        click(usersPageObjects.usersDropDown(), "Users Drop Down");
        click(usersPageObjects.branchUserDropDown(), "Branch User Drop Down");
        if(isVisible(usersPageObjects.branchUserText(), getText(usersPageObjects.branchUserText()))){
            ExtentReporter.logPass("U_TC_12", "Successfully Navigate to Branch User in Users Dropdown");
        }else{
            ExtentReporter.logFail("U_TC_12", "Fail to Navigate to Branch User in Users Dropdown");
            Assert.fail("Fail to Navigate to Branch User in Users Dropdown");
        }
    }
    public void U_TC_13() throws Exception {
        U_TC_12();
        type(usersPageObjects.resourceIDNoField(), "Resource ID Number Field", propertyReader.getproperty("sameResourceID"));
        click(usersPageObjects.searchButton(), "Search Button");
        waitSleep(20000);
        if(isVisible(usersPageObjects.userInformationText(), getText(usersPageObjects.userInformationText()))){
            ExtentReporter.logPass("U_TC_13", "Successfully verify Search User ID in Branch Users");
        }else{
            ExtentReporter.logFail("U_TC_13", "Fail to verify Search User ID in Branch Users");
            Assert.fail("Fail to verify Search User ID in Branch Users");
        }
    }
    public void U_TC_14() throws Exception {
        U_TC_12();
        type(usersPageObjects.resourceIDNoField(), "Resource ID Number Field", propertyReader.getproperty("invalidResourceID"));
        click(usersPageObjects.searchButton(), "Search Button");
        waitSleep(18000);
        if(isVisible(usersPageObjects.userNotFoundText(), getText(usersPageObjects.userNotFoundText()))){
            ExtentReporter.logPass("U_TC_14", "Successfully verify Search invalid User ID in Branch Users");
        }else{
            ExtentReporter.logFail("U_TC_14", "Fail to verify Search invalid User ID in Branch Users");
            Assert.fail("Fail to verify Search invalid User ID in Branch Users");
        }
        click(usersPageObjects.okButton(),"OK Button");
    }
    public void U_TC_15() throws Exception {
        U_TC_12();
        click(usersPageObjects.generateReportButton(), "generate Report Button");
        click(usersPageObjects.selectedZoneVISAYAS(), "selected Zone VISAYAS");
        waitSleep(15000);
        click(usersPageObjects.hoRegion(), "HO Region");
        click(usersPageObjects.hoArea(), "HO Area");
        waitSleep(15000);
        click(usersPageObjects.headOfficeBranch(), "Head Office Branch");
        click(usersPageObjects.generateReportButton2(), "generate Report Button2");
        waitSleep(13000);
        if(isVisible(usersPageObjects.reportGeneratedText(), getText(usersPageObjects.reportGeneratedText()))){
            ExtentReporter.logPass("U_TC_15", "Successfully verify Generate Report in branch User");
        }else{
            ExtentReporter.logFail("U_TC_15", "Fail to verify Generate Report in branch User");
            Assert.fail("Fail to verify Generate Report in branch User");
        }
        click(usersPageObjects.okButton(),"OK Button");
    }
    public void U_TC_16() throws Exception {
        U_TC_12();
        click(usersPageObjects.generateReportButton(), "generate Report Button");
        waitSleep(7000);
        click(usersPageObjects.selectedInvalidZoneNEW(), "selected Invalid Zone NEW");
        waitSleep(15000);
        if(isVisible(usersPageObjects.noRegionText(), getText(usersPageObjects.noRegionText()))){
            ExtentReporter.logPass("U_TC_16", "Successfully verify Generate Report Branch User - Invalid Zone");
        }else{
            ExtentReporter.logFail("U_TC_16", "Fail to verify Generate Report Branch User - Invalid Zone");
            Assert.fail("Fail to verify Generate Report Branch User - Invalid Zone");
        }
        click(usersPageObjects.okButton(),"OK Button");
    }
    public void U_TC_17() throws Exception {
        U_TC_12();
        click(usersPageObjects.generateReportButton(), "generate Report Button");
        waitSleep(8000);
        click(usersPageObjects.selectedZoneVISAYAS(), "selected Zone VISAYAS");
        waitSleep(15000);
        click(usersPageObjects.invalidRegionSWQAFORTESTREGION(), "invalid Region SWQA FORTEST REGION");
        waitSleep(12000);
        if(isVisible(usersPageObjects.noAreasFound(), getText(usersPageObjects.noAreasFound()))){
            ExtentReporter.logPass("U_TC_17", "Successfully verify Generate Report Branch User - Invalid Region Name");
        }else{
            ExtentReporter.logFail("U_TC_17", "Fail to verify Generate Report Branch User - Invalid Region Name");
            Assert.fail("Fail to verify Generate Report Branch User - Invalid Region Name");
        }
        click(usersPageObjects.okButton(),"OK Button");
    }

    public void U_TC_18() throws Exception {
        U_TC_01();
        click(usersPageObjects.relieverNavLink(), "reliever Nav Link");
        if(isVisible(usersPageObjects.relieverText(), getText(usersPageObjects.relieverText()))){
            ExtentReporter.logPass("U_TC_18", "Successfully Navigate Reliever Page under Users Module");
        }else{
            ExtentReporter.logFail("U_TC_18", "Fail to Navigate Reliever Page under Users Module");
            Assert.fail("Fail to Navigate Reliever Page under Users Module");
        }
    }
    public void U_TC_19() throws Exception {
        U_TC_18();
        type(usersPageObjects.resourceIDNoField(), "Resource ID Number Field", propertyReader.getproperty("otherResourceID"));
        click(usersPageObjects.searchButton(), "Search Button");
        waitSleep(20000);
        if(isVisible(usersPageObjects.userInformationText(), getText(usersPageObjects.userInformationText()))){
            ExtentReporter.logPass("U_TC_19", "Successfully verify Search User ID in Reliever");
        }else{
            ExtentReporter.logFail("U_TC_19", "Fail to verify Search User ID in Reliever");
            Assert.fail("Fail to verify Search User ID in Reliever");
        }
    }
    public void U_TC_20() throws Exception {
        U_TC_18();
        type(usersPageObjects.resourceIDNoField(), "Resource ID Number Field", propertyReader.getproperty("invalidResourceID"));
        click(usersPageObjects.searchButton(), "Search Button");
        waitSleep(18000);
        if(isVisible(usersPageObjects.userNotFoundText(), getText(usersPageObjects.userNotFoundText()))){
            ExtentReporter.logPass("U_TC_20", "Successfully verify Search invalid User ID in Reliever");
        }else{
            ExtentReporter.logFail("U_TC_20", "Fail to verify Search invalid User ID in Reliever");
            Assert.fail("Fail to verify Search invalid User ID in Reliever");
        }
        click(usersPageObjects.okButton(),"OK Button");
    }
    public void U_TC_21() throws Exception {
        U_TC_12();
        type(usersPageObjects.resourceIDNoField(), "Resource ID Number Field", propertyReader.getproperty("inActiveAccount"));
        click(usersPageObjects.searchButton(),"Search Button");
        waitSleep(25000);
        click(usersPageObjects.inActiveButton(),"INACTIVE Button");
        waitSleep(5000);
        scrollToElement(usersPageObjects.saveChangesButton());
        click(usersPageObjects.saveChangesButton(),"Save Changes Button");
        click(usersPageObjects.yesUpdateUser(),"Yes Update User");
        waitSleep(7000);
        click(usersPageObjects.okButton(),"OK Button");
    }























    public boolean verifyPassword(String resourceID) {
        String displayedPassword = usersPageObjects.passwordBranchInfo().getAttribute("value");
        return displayedPassword.equals(resourceID);
    }
    public boolean verifyUsername(String lastName, String resourceID, String expectedUsername) {
        String expectedPrefix = lastName.substring(0, Math.min(lastName.length(), 4));
        String expectedFullUsername = expectedPrefix + resourceID;
        return expectedUsername.equals(expectedFullUsername);
    }

    public String generateRandomResourceID(int digitCount) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digitCount; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }

    private String generateUsername(String lastName, String resourceID) {
        String username = lastName.substring(0, Math.min(lastName.length(), 4)) + resourceID;
        return username;
    }






}
