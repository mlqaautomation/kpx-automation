package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class Users_PageObjects {
    public WebElement usersNav(){
        return getDriver().findElement(By.cssSelector("[href=\"/users/branch-users\"]"));}
    public WebElement usersTextPage(){
        return getDriver().findElement(By.xpath("//*[text()='Search User']"));}
    public WebElement usersDropDown(){
        return getDriver().findElement(By.cssSelector("[class=\"dropdown-toggle nav-link\"]"));}
    public WebElement addBranchUserDropdown(){
        return getDriver().findElement(By.xpath("//*[text()='Add Branch User']"));}
    public WebElement addBranchUserText(){
        return getDriver().findElement(By.xpath("(//*[text()='Add Branch User'])[2]"));}
    public WebElement branchUserDropDown(){
        return getDriver().findElement(By.xpath("(//*[text()='Branch Users'])[1]"));}
    public WebElement branchUserText(){
        return getDriver().findElement(By.xpath("(//*[text()='Branch Users'])[2]"));}
    public WebElement resourceID(){
        return getDriver().findElement(By.cssSelector("[name=\"resourceIdNumber\"]"));}
    public WebElement firstNameUserInfo(){
        return getDriver().findElement(By.cssSelector("[name=\"firstName\"]"));}
    public WebElement middleNameUserInfo(){
        return getDriver().findElement(By.cssSelector("[name=\"middleName\"]"));}
    public WebElement lastNameUserInfo(){
        return getDriver().findElement(By.cssSelector("[name=\"lastName\"]"));}
    public WebElement emailUserInfo(){
        return getDriver().findElement(By.cssSelector("[placeholder=\"Email\"]"));}
    public WebElement contactInfo(){
        return getDriver().findElement(By.cssSelector("[name=\"contactNumber\"]"));}
    public WebElement roleTellerAutoApprove(){
        return getDriver().findElement(By.xpath("//*[text()='TELLER AUTOAPPROVE']"));}
    public WebElement statusActive(){
        return getDriver().findElement(By.xpath("//*[text()=' ACTIVE']"));}
    public WebElement statusInactive(){
        return getDriver().findElement(By.xpath("//*[text()=' INACTIVE']"));}
    public WebElement zone(){
        return getDriver().findElement(By.cssSelector("[name=\"zoneId\"]"));}
    public WebElement selectedZoneVISAYAS(){
        return getDriver().findElement(By.xpath("//*[text()='VISAYAS']"));}
    public WebElement selectedInvalidZoneNEW(){
        return getDriver().findElement(By.xpath("//*[text()='NEW']"));}
    public WebElement regionNameCebuCentralBRegion(){
        return getDriver().findElement(By.xpath("//*[text()='CEBU CENTRAL B REGION']"));}
    public WebElement hoRegion(){
        return getDriver().findElement(By.xpath("(//*[text()='HO'])[1]"));}
    public WebElement hoArea(){
        return getDriver().findElement(By.xpath("(//*[text()='HO'])[2]"));}
    public WebElement headOfficeBranch(){
        return getDriver().findElement(By.xpath("//*[text()='HEAD OFFICE']"));}
    public WebElement generateReportButton2(){
        return getDriver().findElement(By.xpath("(//*[text()='Generate Report'])[2]"));}
    public WebElement clearButton(){
        return getDriver().findElement(By.xpath("//*[text()='Clear']"));}
    public WebElement reportGeneratedText(){
        return getDriver().findElement(By.xpath("//*[text()='Reports Generated']"));}
    public WebElement invalidRegionSWQAFORTESTREGION(){
        return getDriver().findElement(By.xpath("//*[text()='SWQA FORTEST REGION']"));}
    public WebElement areaNameCentralBAreaA(){
        return getDriver().findElement(By.xpath("//*[text()='CEBU CENTRAL B AREA A']"));}
    public WebElement branchNameMLFuente1(){
        return getDriver().findElement(By.xpath("//*[text()='ML FUENTE 1']"));}
    public WebElement usernameBranchInfo(){
        return getDriver().findElement(By.cssSelector("[name=\"username\"]"));}
    public WebElement passwordBranchInfo(){
        return getDriver().findElement(By.cssSelector("[name=\"password\"]"));}
    public WebElement saveChangesButton(){
        return getDriver().findElement(By.xpath("//*[text()='Save Changes']"));}
    public WebElement confirmButton(){
        return getDriver().findElement(By.xpath("//*[text()='Confirm']"));}
    public WebElement okButton(){
        return getDriver().findElement(By.xpath("//*[text()='OK']"));}
    public WebElement branchUserCreatedText(){
        return getDriver().findElement(By.xpath("//*[text()='Branch User Created']"));}

    public WebElement changePassText(){
        return getDriver().findElement(By.xpath("//*[text()='Change Password']"));}
    public WebElement sameResourceIDText(){
        return getDriver().findElement(By.xpath("//*[text()='Resource ID is already taken.']"));}

    public WebElement unableToCreateUserText(){
        return getDriver().findElement(By.xpath("//*[text()='Unable to Create User']"));}
    public WebElement middleNameText(){
        return getDriver().findElement(By.xpath("//*[text()='Middle Name']"));}

    public WebElement firstNameDangerText(){
        return getDriver().findElement(By.xpath("//*[text()='First Name is required.']"));}
    public WebElement lastNameDangerText(){
        return getDriver().findElement(By.xpath("//*[text()='Last Name is required.']"));}
    public WebElement emailDangerText(){
        return getDriver().findElement(By.xpath("//*[text()='Email is required.']"));}
    public WebElement roleDangerText(){
        return getDriver().findElement(By.xpath("//*[text()='Role is required.']"));}
    public WebElement noRegionText(){
        return getDriver().findElement(By.xpath("//*[text()='No Regions found']"));}
    public WebElement noAreasFound(){
        return getDriver().findElement(By.xpath("//*[text()='No Areas found']"));}
    public WebElement resourceIDNoField(){
        return getDriver().findElement(By.cssSelector("[name=\"resourceIdNo\"]"));}
    public WebElement searchButton(){
        return getDriver().findElement(By.xpath("//*[text()='Search']"));}
    public WebElement userInformationText(){
        return getDriver().findElement(By.xpath("//*[text()='User Information']"));}
    public WebElement userNotFoundText(){
        return getDriver().findElement(By.xpath("//*[text()='User Not Found']"));}
    public WebElement generateReportButton(){
            return getDriver().findElement(By.xpath("//*[text()='Generate Report']"));}
    public WebElement relieverNavLink(){
            return getDriver().findElement(By.cssSelector("[href=\"/users/branch-users/reliever\"]"));
    }
    public WebElement relieverText(){
            return getDriver().findElement(By.xpath("(//*[text()='Reliever'])[2]"));
    }
    public WebElement inActiveButton(){
            return getDriver().findElement(By.xpath("//*[text()='INACTIVE']"));
    }
    public WebElement userIsInActiveText(){
            return getDriver().findElement(By.xpath("//*[text()='USER INACTIVE']"));
    }
    public WebElement yesUpdateUser(){
            return getDriver().findElement(By.xpath("//*[text()='Yes, Update User']"));
    }

}
