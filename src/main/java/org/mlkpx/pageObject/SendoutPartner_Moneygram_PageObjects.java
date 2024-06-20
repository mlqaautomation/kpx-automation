package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class SendoutPartner_Moneygram_PageObjects {

    public WebElement sendoutTransactionLink() {
        return getDriver().findElement(By.xpath("//*[text()='Sendout Transactions']"));
    }
    public WebElement sendoutPartnerText() {
        return getDriver().findElement(By.xpath("//*[text()='Sendout Partner']"));
    }
    public WebElement intendedToUse() {
        return getDriver().findElement(By.xpath("//*[text()='Intended Use']"));
    }
    public WebElement partnerSendout() {
        return getDriver().findElement(By.cssSelector("[href=\"/sendout/partner\"]"));
    }
    public WebElement receiversCountry() {
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.address.addressL0Id\"]"));
    }
    public WebElement selectPartner() {
        return getDriver().findElement(By.cssSelector("[name=\"partnerId\"]"));
    }
    public WebElement selectMoneygram() {
        return getDriver().findElement(By.cssSelector("[label=\"MONEYGRAM\"]"));
    }
    public WebElement selectWesternUnion() {
        return getDriver().findElement(By.cssSelector("[label=\"WESTERN UNION\"]"));
    }
    public WebElement contactNumberReceiver() {
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.contactNumber\"]"));
    }
    public WebElement nationalityReceivers() {
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.nationality\"]"));
    }
    public WebElement selectedNationalityReceivers() {
        return getDriver().findElement(By.cssSelector("[value=\"FILIPINO\"]"));
    }
    public WebElement yesRadioButton() {
        return getDriver().findElement(By.xpath("//*[text()=\"Yes\"]"));
    }
    public WebElement restrictionModalOKButton() {
        return getDriver().findElement(By.xpath("//button[contains(@class,'swal2-confirm swal2-styled')]"));
    }

    public WebElement senderInformationText() {
        return getDriver().findElement(By.xpath("//*[text()='Sender Information']"));
    }
    public WebElement firstName_max60(){return getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div/div[2]/div/small"));}
    public WebElement countryMalaysia(){return getDriver().findElement(By.xpath("//option[@value='107'][text()='MALAYSIA']"));}
    public WebElement searchReceiver(){return getDriver().findElement(By.xpath("//button[@type='button' and @class='btn-sm btn btn-primary' and text()='Search Receivers']"));}


    //other information

    public WebElement sourceOfFund() {
        return getDriver().findElement(By.cssSelector("[name=\"senderOtherInformation.incomeSource\"]"));
    }
    public WebElement selectedSourceOfFund() {
        return getDriver().findElement(By.cssSelector("[label=\"SALARY/PAY/WAGE/COMMISSION\"]"));
    }
    public WebElement purposeOfTransfer() {
        return getDriver().findElement(By.cssSelector("[name=\"transferReason\"]"));
    }
    public WebElement selectedPurposeOfTransfer() {
        return getDriver().findElement(By.cssSelector("[label=\"FAMILY SUPPORT/LIVING EXPENSES\"]"));
    }
    public WebElement relationshipWithReceiver() {
        return getDriver().findElement(By.cssSelector("[name=\"senderOtherInformation.relationshipWithReceiver\"]"));
    }
    public WebElement selectedRelationshipWithReceiver() {
        return getDriver().findElement(By.cssSelector("[label=\"FAMILY\"]"));
    }
    public WebElement intendedToUse2() {
        return getDriver().findElement(By.cssSelector("[name=\"senderOtherInformation.intendedUse\"]"));
    }
    public WebElement selectedIntendedToUse2() {
        return getDriver().findElement(By.cssSelector("[label=\"BUSINESS RELATED\"]"));
    }
    public WebElement deliveryOptions() {
        return getDriver().findElement(By.cssSelector("[name=\"senderOtherInformation.deliveryOption\"]"));
    }
    public WebElement selectedDeliveryOptions10MinuteService() {
        return getDriver().findElement(By.cssSelector("[label=\"10 Minute Service\"]"));
    }
    public WebElement selectedDeliveryOptionsAccountDeposit() {
        return getDriver().findElement(By.cssSelector("[label=\"Account Deposit\"]"));
    }
    public WebElement sendAmountField() {
        return getDriver().findElement(By.cssSelector("[name=\"principalAmount\"]"));
    }
    public WebElement okButtonInTransactionInvalidAmount() {
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }
    public WebElement transactionAmountIsInvalidTextInModal() {
        return getDriver().findElement(By.cssSelector("[class=\"sc-gEvEer lkAUft\"]"));
    }
    public WebElement exceedTheTransactionLimitText() {
        return getDriver().findElement(By.cssSelector("[class=\"sc-gEvEer lkAUft\"]"));
    }
    public WebElement totalAmount() {
        return getDriver().findElement(By.cssSelector("[class=\"text-monospace\"]"));
    }
    public WebElement submitButton() {
        return getDriver().findElement(By.xpath("//button[normalize-space()='Submit Sendout']"));
    }
    public WebElement proceedToPrintingButton() {
        return getDriver().findElement(By.xpath("//*[text()='Proceed to Printing']"));
    }

    public WebElement confirmSendoutButton(){return getDriver().findElement(By.xpath("//button[normalize-space()='Confirm Sendout']"));
    }
    public WebElement sendoutSuccessfulText() {
        return getDriver().findElement(By.xpath("//*[text()='Sendout Successful']"));
    }
    public WebElement cancelButton() {
        return getDriver().findElement(By.xpath("//*[text()='Cancel']"));
    }
    public WebElement cancelSendoutButton() {
        return getDriver().findElement(By.cssSelector("[class=\"swal2-cancel swal2-styled\"]"));
    }
    public WebElement stayOnThisPageButton() {
        return getDriver().findElement(By.xpath("//*[text()='Stay On This Page']"));
    }
    public WebElement yesCancelTransactionButton() {
        return getDriver().findElement(By.xpath("//*[text()='Yes, Cancel Transaction']"));
    }
    public WebElement cancelInPrintingButton() {
        return getDriver().findElement(By.xpath("//*[text()='Cancel']"));
    }
    public WebElement principalAmountDangerText() {
        return getDriver().findElement(By.xpath("//*[text()=\"Principal amount must have a valid value\"]"));
    }
    public WebElement sendFeeText() {
        return getDriver().findElement(By.xpath("//*[text()='Send Fee']"));
    }
    public WebElement complianceOKButton() {
        return getDriver().findElement(By.xpath("(//button[contains(@class, 'swal2-confirm') and contains(@class, 'swal2-styled') and contains(@style, 'background-color: rgb(221, 51, 51)') and text()='OK'])[1]"));
    }
    public WebElement complianceText() {
        return getDriver().findElement(By.xpath("//*[text()='For Compliance Assistance']"));
    }
    public WebElement additionalInfoText() {
        return getDriver().findElement(By.xpath("//*[text()='Additional Information']"));
    }

    public WebElement referenceNumber(){
        return getDriver().findElement(By.cssSelector("[data-testid=\"sendoutKPTN\"]"));
    }
    public WebElement agentDropDown(){
        return getDriver().findElement(By.cssSelector("[name=\"senderOtherInformation.agentId\"]"));
    }
    public WebElement selectedAgentAllBanks(){
        return getDriver().findElement(By.cssSelector("[label=\"ALL BANKS\"]"));
    }
    public WebElement bankEWalletNameDropDown(){
        return getDriver().findElement(By.cssSelector("[name=\"senderOtherInformation.bankId\"]"));
    }
    public WebElement selectedBAnkOrEWallet(){
        return getDriver().findElement(By.cssSelector("[label=\"SUMITOMO MITSUI BANKING CORPORATION MALAYSIA\"]"));
    }
    public WebElement accountNumber(){

        return getDriver().findElement(By.cssSelector("[name=\"senderOtherInformation.accountNumber\"]"));
    }
    public WebElement birthDateDropDown(){

        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.birthDate\"]"));
    }



}
