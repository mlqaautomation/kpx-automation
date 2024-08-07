package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class SendOut_PageObjects {

    public WebElement sendOutLink() {
        return getDriver().findElement(By.xpath("//*[text()='Sendout']"));
    }
    public WebElement SendoutTransaction(){
        return getDriver().findElement(By.xpath("(//a[@href='#'])[1]"));
    }
    public WebElement PartnerSendout(){
        return getDriver().findElement(By.xpath("//a[@href='/sendout/partner']"));
    }
    public WebElement SelectPartner(){
        return getDriver().findElement(By.xpath("//option[@label='WESTERN UNION']"));
    }
    public WebElement SelectCountry(){
        return getDriver().findElement(By.xpath("//option[@value='187']"));
    }
    public WebElement OkCountry(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='OK']"));
    }
    public WebElement SelectNationality(){
        return getDriver().findElement(By.xpath("//option[@value='FILIPINO']"));
    }
    public WebElement selectBdate(){
        return getDriver().findElement(By.xpath("//input[@placeholder='Birth Date']"));
    }
    public WebElement selectIDIssuedate(){
        return getDriver().findElement(By.xpath("//input[@name='senderIdIssueDate']"));
    }
    public WebElement selectSex(){
        return getDriver().findElement(By.xpath("//option[@value='male']"));
    }
    public WebElement typeContactNum(){
        return getDriver().findElement(By.xpath("//input[@name='beneficiary.contactNumber']"));
    }
    public WebElement selectProvince(){
        return getDriver().findElement(By.xpath("//option[@value='CA']"));
    }
    public WebElement selectPurpose(){
        return getDriver().findElement(By.xpath("//option[@label='FAMILY SUPPORT/LIVING EXPENSES']"));
    }
    public WebElement selectRelationship(){
        return getDriver().findElement(By.xpath("//option[@label='FAMILY']"));
    }
    public WebElement selectSourceofFund(){
        return getDriver().findElement(By.xpath("//option[@label='SALARY/PAY/WAGE/COMMISSION']"));
    }
    public WebElement selectDeliveryOption(){
        return getDriver().findElement(By.xpath("//option[@label='10 Minute Service']"));
    }
    public WebElement inputPrincipalAmount(){
        return getDriver().findElement(By.xpath("//input[@name='principalAmount']"));
    }
    public WebElement clickSubmitButton(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Submit Sendout']"));
    }
    public WebElement searchReceivers(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Search Receivers']"));
    }
    public WebElement referenceNumber(){
        return getDriver().findElement(By.xpath("//p[@data-testid='sendoutKPTN']"));
    }

    public WebElement sendOutTransaction() {return getDriver().findElement(By.xpath("//*[@class='dropdown-toggle nav-link' and text()='Sendout Transactions']\n"));
    }
    public WebElement yesRadioButton() {
        return getDriver().findElement(By.xpath("//*[text()=\"Yes\"]"));
    }
    public WebElement branchField() {
        return getDriver().findElement(By.cssSelector("[name=\"branchCode\"]"));
    }
    public WebElement branchName(){
        return getDriver().findElement(By.cssSelector("[name='remoteBranch.branchName']"));
    }

    public WebElement branchNotFoundText() {
        return getDriver().findElement(By.xpath("//*[text()=\"Branch not found\"]"));
    }


    public WebElement searchKYC() {
        return getDriver().findElement(By.xpath("//button[normalize-space()='Search KYC']"));
    }

    public WebElement lastName() {
        return getDriver().findElement(By.xpath("//*[@name='lastName']"));
    }

    public WebElement firstName() {
        return getDriver().findElement(By.xpath("//*[@name='firstName']"));
    }
    public WebElement middleName() {
        return getDriver().findElement(By.cssSelector("[name=\"middleName\"]"));
    }

    public WebElement searchBtn() {
        return getDriver().findElement(By.cssSelector("[type='submit']"));
    }

    public WebElement viewButton() {
        return getDriver().findElement(By.xpath("//button[@class=\"mr-3 btn btn-outline-primary btn-sm\" and text()=\"View\"]"));
    }
    public WebElement editButton() {
        return getDriver().findElement(By.xpath("//button[@class='btn btn-outline-secondary btn-sm']"));
    }


    public WebElement selectKYC(){return getDriver().findElement(By.xpath("//button[contains(., 'Select KYC')]"));
    }
    public WebElement WatchlistStat(){return getDriver().findElement(By.xpath("//select[@placeholder='Watchlist Status']"));
    }
    public WebElement NotExempted(){return getDriver().findElement(By.xpath("//option[contains(text(), 'NOT EXEMPTED')]"));
    }
    public WebElement Exempted(){return getDriver().findElement(By.xpath("//option[contains(text(), 'EXEMPTED')]"));
    }
    public WebElement UnderTerrorism(){return getDriver().findElement(By.xpath("//option[contains(text(), 'UNDER TERRORISM')]"));
    }

    public WebElement contactNumber() {
        return getDriver().findElement(By.cssSelector("[name=\"senderOtherInformation.contactNumber\"]"));
    }

//    public WebElement searchReceivers() { return getDriver().findElement(By.cssSelector("[class='btn-sm btn btn-primary']"));
//    }

    public WebElement name_Text(int i) {
        return getDriver().findElement(By.xpath("(//*[contains(text(), 'Name:')]/following-sibling::span)["+i+"]"));
    }

    public WebElement selectButton(){
        return getDriver().findElement(By.xpath("(//button[contains(text(), 'Select')])[1]"));
    }
    public WebElement mainOperator(){
        return getDriver().findElement(By.xpath("//p/span[contains(text(), 'SIAROT JR, ENRIQUE ALFEREZ')]"));
    }
//    public WebElement selectButton2Attempt(){
//        return getDriver().findElement(By.cssSelector("[class=\"sc-iapWAC gRiCAy btn-sm btn btn-primary\"]"));
//    }

    public WebElement addNewReceivers() {
        return getDriver().findElement(By.xpath("//div[contains(@class,'d-flex justify-content-between align-items-center mt-4')]/button[contains(@class,'btn-sm btn btn-link')]"));
    }

    public WebElement r_LastName() {

        return getDriver().findElement(By.cssSelector("[placeholder=\"Last Name\"]"));
    }

    public WebElement r_FirstName() {
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.firstName\"]"));
    }

    public WebElement r_MiddleName() {
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.middleName\"]"));
    }

    public WebElement r_CityMunicipality() {
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.address.addressL2Id\"]"));
    }

    public WebElement r_CityMunicipalitySelected() {
        return getDriver().findElement(By.cssSelector("[value=\"804\"]"));
    }

    public WebElement r_ProvinceState() {
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.address.addressL1Id\"]"));
    }

    public WebElement r_ProvinceStateSelect() {

        return getDriver().findElement(By.cssSelector("[value=\"4\"]"));
    }

    public WebElement r_HouseNoStreetBarangaySitio() {
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.address.otherAddress\"]"));
    }

    public WebElement r_birthdate_Field() {
        return getDriver().findElement(By.cssSelector("[placeholder='Birth Date']"));
    }

    public WebElement r_sex_Field() {

        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.gender\"]"));
    }

    public WebElement r_selected_Sex_Field() {

        return getDriver().findElement(By.cssSelector("[value=\"male\"]"));
    }

    public WebElement no_ContactNo() {
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.hasNoContactNumber\"]"));
    }

    public WebElement sourceOfFund() {
        return getDriver().findElement(By.cssSelector("[placeholder=\"Source of Fund\"]"));
    }

    public WebElement purpose() {
        return getDriver().findElement(By.cssSelector("[placeholder=\"Purpose\"]"));
    }

    public WebElement relationToReceiver() {
        return getDriver().findElement(By.cssSelector("[name=\"senderOtherInformation.relationshipWithReceiver\"]"));
    }

    public WebElement messageToReceiver() {
        return getDriver().findElement(By.cssSelector("[name=\"senderOtherInformation.messageToReceiver\"]"));
    }

    public WebElement principalAmount() {

        return getDriver().findElement(By.cssSelector("[id=\"moneyInput\"]"));
    }


    public WebElement submitSendOut(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Submit Sendout']"));
    }

    public WebElement display0Text() {
        return getDriver().findElement(By.xpath("//*[text()=\"Minimum allowed amount is PHP 1.00.\"]"));
    }
    public WebElement negativeDisplayText() {
        return getDriver().findElement(By.xpath("//*[text()=\"Value must be greater than or equal to 0.\"]"));
    }
    public WebElement emptyValueText() {
        return getDriver().findElement(By.xpath("//*[text()=\"Valid Amount is required\"]"));
    }
    public WebElement chargeText() {
        return getDriver().findElement(By.xpath("//*[text()=\"Charge\"]"));
    }

    public WebElement confirmSendOutButton() {
        return getDriver().findElement(By.xpath("//*[text()='Confirm Sendout']"));
    }

    public WebElement proceedToPrinting() {
        return getDriver().findElement(By.xpath("//*[text()='Proceed to Printing']"));
    }

    public WebElement yesCancelTransaction() {
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }

    public WebElement noStayOnThisPage() {
        return getDriver().findElement(By.cssSelector("[class=\"swal2-cancel swal2-styled\"]"));
    }

    public WebElement cancelButton() { return getDriver().findElement(By.xpath("//*[text()='Cancel']"));}

    public WebElement cancelButtoninReceipt() {
        return getDriver().findElement(By.xpath("//button[normalize-space()='Cancel']"));
    }
    public WebElement cancelButtoninConfirmation() { return getDriver().findElement(By.xpath("//button[@class='swal2-cancel swal2-styled' and @style='display: inline-block; background-color: rgb(170, 170, 170);' and text()='Cancel']"));}
    public WebElement provinceDanger() {
        return getDriver().findElement(By.xpath("//*[text()='Cancel']"));
    }
    public WebElement senderLastName(){ return getDriver().findElement(By.xpath("(//p[normalize-space()='Last Name'])[1]/parent::div/following-sibling::div/child::p")); }
    public WebElement senderFirstName(){ return getDriver().findElement(By.xpath("(//p[normalize-space()='First Name'])[1]/parent::div/following-sibling::div/child::p")); }
    public WebElement smsCheckbox(){
        return getDriver().findElement(By.cssSelector("[name='senderOtherInformation.receiveSmsNotification']"));
    }
    public WebElement chargeAmount(){ return getDriver().findElement(By.xpath("(//p[@class=\"text-monospace text-right\"])[1]")); }
    public WebElement otherChargeAmount(){ return getDriver().findElement(By.xpath("(//p[@class='text-monospace text-right'])[2]")); }
    public WebElement receiversMaximumLettersDangerText(){ return getDriver().findElement(By.xpath("//*[text()=\"Maximum of 60 characters.\"]")); }
    public WebElement totalAmount(){

        return getDriver().findElement(By.cssSelector("[class='pr-1']"));
    }
    public WebElement kptnText(){

        return getDriver().findElement(By.cssSelector("[data-testid='sendoutKPTN']"));
    }
    public WebElement reqNum(){

        return getDriver().findElement(By.cssSelector("[data-testid='requestNumber']"));
    }

    public WebElement sendOutSuccessMsg(){
        return getDriver().findElement(By.cssSelector("[class='sc-epALIP bYifLU']"));
    }


    public WebElement theSameTransactionText(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-gEvEer lkAUft\"]"));
    }
    public WebElement theSameTransactionOKButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }
    public WebElement complianceText(){
        return getDriver().findElement(By.xpath("//*[text()='For Compliance Assistance']"));
    }
    public WebElement complianceOKButton() {
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }

    public WebElement RemoteTransaction(){
        return getDriver().findElement(By.xpath("//input[@value='1']"));
    }
    public WebElement BranchCode(){return getDriver().findElement(By.xpath("//input[@name='branchCode']"));
    }

    public WebElement senderContactNo(){return getDriver().findElement(By.xpath("(//*[@class=\"sc-ERObt sc-dNsVcS jennmh jrGRvL\"])[10]"));
    }
    public WebElement OperatorID(){return getDriver().findElement(By.xpath("//input[@placeholder='Operator ID']"));
    }
    public WebElement ReasonRemote(){return getDriver().findElement(By.xpath("//input[@name='remoteBranch.remoteReason']"));

    }
}
