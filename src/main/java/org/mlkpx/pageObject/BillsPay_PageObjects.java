package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class BillsPay_PageObjects {
    public WebElement billsPay_link(){
        return getDriver().findElement(By.cssSelector("[href='/bills/payments']"));
    }
    public WebElement billsPay_h2(){
        return getDriver().findElement(By.xpath("//h2"));
    }
    public WebElement billsPay_PayInfo(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Payor Information')]"));
    }
    public WebElement billsPay_ConfiInfo(){
        return getDriver().findElement(By.xpath("//h4[contains(text(),'Bills Pay Confirmation')]"));
    }
    public WebElement BPSendout(){
        return getDriver().findElement(By.xpath("(//a[@href='/bills/payments'])[2]"));
    }
    public WebElement BPCancellation(){
        return getDriver().findElement(By.xpath("(//a[@href='/bills/cancellation'])[1]"));
    }
    public WebElement BPChangeDetails(){
        return getDriver().findElement(By.xpath("(//a[@href='/bills/change-details'])[1]"));
    }
    public WebElement BPReprinting(){
        return getDriver().findElement(By.xpath("(//a[@href='/bills/reprint'])[1]"));
    }
    public WebElement NoRemoteTransaction(){
        return getDriver().findElement(By.xpath("//input[@value='0']"));
    }
    public WebElement RemoteTransaction(){
        return getDriver().findElement(By.xpath("//input[@value='1']"));
    }
    public WebElement kptnText(){

        return getDriver().findElement(By.cssSelector("[data-testid='payout-success-ref-num']"));
    }
    public WebElement BPPartners(){
        return getDriver().findElement(By.xpath("//div[@class=' css-tlfecz-indicatorContainer']"));
    }
//    public WebElement BPChoosePartners(String option) {
//        String xpath = "//div[contains(text(),'" + option + "')]";
//        return getDriver().findElement(By.xpath(xpath));
//    }
    public WebElement BPChoosePartners(){
        return getDriver().findElement(By.xpath("//div[@class=' css-1wa3eu0-placeholder']"));
    }

    public WebElement RefRequired(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'Reference number is required')]"));
    }
    public WebElement ReasonRequired(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'Reason is required')]"));
    }
    public WebElement OnlyLettersP(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'Only letters are allowed.')]"));
    }
    public WebElement SelectPartners(){
        return getDriver().findElement(By.xpath("//span[contains(text(),'Please select the partner that will receive the payment.')]"));
    }
    public WebElement EmptyAccount(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'Account number is a required field')]"));
    }
    public WebElement EmptyLastname(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'Account last name is a required field')]"));
    }
    public WebElement EmptyFirstname(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'Account first name is a required field')]"));
    }
    public WebElement EmptyLPayor(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'Payor last name is a required field')]"));
    }
    public WebElement EmptyFPayor(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'Payor first name is a required field')]"));
    }
    public WebElement EmptyAddress(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'Payor address is a required field')]"));
    }
    public WebElement EmptyContact(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'Payor contact number is a required field')]"));
    }
    public WebElement EmptyAmount(){
        return getDriver().findElement(By.xpath("//span[contains(text(),'Payment amount must have a valid value')]"));
    }
    public WebElement ZeroAmount(){
        return getDriver().findElement(By.xpath("//span[contains(text(),'Minimum amount is 1')]"));
    }
    public WebElement InvalidAccountNum(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Incorrect Payment Details')]"));
    }
    public WebElement InvalidContact(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'Must start with 639|09|9 followed by 9 digits.')]"));
    }


    public WebElement BPAccNum(){
        return getDriver().findElement(By.xpath("//input[@name='accountNumber']"));
    }
    public WebElement BPLastName(){
        return getDriver().findElement(By.xpath("//input[@name='accountLastName']"));
    }
    public WebElement BPFirstName(){
        return getDriver().findElement(By.xpath("//input[@name='accountFirstName']"));
    }
    public WebElement BPMiddleName() {
        return getDriver().findElement(By.xpath("//input[@name='accountMiddleName']"));
    }
    public WebElement AccountNum(){
        return getDriver().findElement(By.xpath("//input[@name='accountAccountNumber']"));
    }
    //payor infos
    public WebElement infoPayorLastName(){
        return getDriver().findElement(By.cssSelector("[name=\"payorInformation.payorLastName\"]"));
    }
    public WebElement ChangePayorLastName(){
        return getDriver().findElement(By.xpath("(//input[@placeholder='Last Name'])[2]"));
    }
    public WebElement infoPayorFirstName(){
        return getDriver().findElement(By.cssSelector("[name=\"payorInformation.payorFirstName\"]"));
    }
    public WebElement ChangePayorFirstName(){
        return getDriver().findElement(By.xpath("(//input[@placeholder='Last Name'])[2]"));
    }
    public WebElement infoPayorMiddleName(){
        return getDriver().findElement(By.cssSelector("[name=\"payorInformation.payorMiddleName\"]"));
    }
    public WebElement ChangePayorMiddleName(){
        return getDriver().findElement(By.xpath("(//input[@placeholder='Middle Name'])[2]"));
    }
    public WebElement PayInformation(){
        return getDriver().findElement(By.xpath("(//h5[@class='mt-5'][2])"));
    }
    public WebElement infoPayorAddress(){
        return getDriver().findElement(By.cssSelector("[name=\"payorInformation.payorAddress\"]"));
    }
    public WebElement ChangePayorAddress(){
        return getDriver().findElement(By.xpath("(//input[@placeholder='Address'])[1]"));
    }
    public WebElement infoPayorContact(){
        return getDriver().findElement(By.cssSelector("[name=\"payorInformation.payorContactNumber\"]"));
    }
    public WebElement ChangePayorContact(){
        return getDriver().findElement(By.xpath("(//input[@placeholder='Contact Number'])[1]"));
    }
    public WebElement BPPage_h2(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Account Information')]"));
    }
    public WebElement PayorLastName(){
        return getDriver().findElement(By.cssSelector("[name=\"payorLastName\"]"));
    }

    public WebElement PayorFirstName(){
        return getDriver().findElement(By.cssSelector("[name=\"payorFirstName\"]"));
    }

    public WebElement PayorMiddleName(){
        return getDriver().findElement(By.cssSelector("[name=\"payorMiddleName\"]"));
    }

    public WebElement PayorAddress(){
        return getDriver().findElement(By.cssSelector("[name=\"payorAddress\"]"));
    }

    public WebElement PayorContact(){
        return getDriver().findElement(By.cssSelector("[name=\"payorContactNumber\"]"));
    }

    //payment infos

    public WebElement PaymentAmount(){
        return getDriver().findElement(By.xpath("//input[@name='paymentAmount']"));
    }
    public WebElement PaymentDetails(){
        return getDriver().findElement(By.xpath("//textarea[@name='otherDetails']"));
    }
    public WebElement SubmitBillsPay(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Submit Bills Pay']"));
    }

    public WebElement ConfirmSubmitBillsPay(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Confirm Payment']"));
    }
    public WebElement SuccessfulBillsPay(){return getDriver().findElement(By.xpath("//h5[contains(text(),'Bills Pay Successful')]"));
    }
    public WebElement DuplicateBillsPay(){return getDriver().findElement(By.xpath("//h5[contains(text(),'Duplicate Bills Payment')]"));
    }
    public WebElement OKCom(){return getDriver().findElement(By.xpath("//button[normalize-space()='OK']"));
    }
    public WebElement ReviewBillsPay(){
        return getDriver().findElement(By.xpath("//input[@type='checkbox']"));
    }
    public WebElement BillsPayText(){
        return getDriver().findElement(By.xpath("//h2[contains(text(),'Bills Pay Cancellation')]"));
    }
    public WebElement BillsPayChange(){
        return getDriver().findElement(By.xpath("//h2[contains(text(),'Bills Pay Change Details')]"));
    }
    public WebElement BillsPayPrint(){
        return getDriver().findElement(By.xpath("//h2[contains(text(),'Bills Pay Reprint')]"));
    }
    public WebElement proceedToPrinting() {
        return getDriver().findElement(By.xpath("//*[text()='Proceed to Printing']"));
    }
    public WebElement cancelButtoninReceipt() {
        return getDriver().findElement(By.xpath("//button[normalize-space()='Cancel']"));}

    public WebElement RepKTPN(){
        return getDriver().findElement(By.xpath("//input[@name='refNo']"));
    }
    public WebElement RefNum(){
        return getDriver().findElement(By.xpath("//input[@name='refNo']"));
    }

    public WebElement SearchButton(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Search']"));
    }
    public WebElement IRNum(){
        return getDriver().findElement(By.xpath("//input[@placeholder='IR No.']"));
    }
    public WebElement InitiatedBy(){
        return getDriver().findElement(By.xpath("//option[@value='CUSTOMER']"));
    }
    public WebElement NoInitiatedBy(){
        return getDriver().findElement(By.xpath("//option[@value='']"));
    }
    public WebElement ReasonCancel(){
        return getDriver().findElement(By.xpath("//textarea[@placeholder='Reason for Cancellation']"));
    }
    public WebElement ReasonChange(){
        return getDriver().findElement(By.xpath("//textarea[@placeholder='Reason for Change']"));
    }
    public WebElement ReasonReprinting(){
        return getDriver().findElement(By.xpath("//textarea[@placeholder='Reason for Reprinting']"));
    }
    public WebElement Reprint(){return getDriver().findElement(By.xpath("//button[normalize-space()='Reprint']"));
    }
    public WebElement ReprintBillsReceipt(){
        return getDriver().findElement(By.xpath("//h3[contains(text(),'Reprint Bills Pay Receipt')]"));
    }
    public WebElement PrintReceipt(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Print Receipt']"));
    }
    public WebElement NoTransactionFound(){
        return getDriver().findElement(By.xpath("//p[contains(text(),'Bills Payment transaction could not be found. Please check the reference no. and try again.')]"));
    }
    public WebElement CancelPayment(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Cancel Payment']"));
    }
    public WebElement SaveChanges(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Save Changes']"));
    }
    public WebElement CancelChanges(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Cancel']"));
    }
    public WebElement YesCancelPayment(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Yes, Cancel Payment']"));
    }
    public WebElement YesSaveChanges(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Yes, Save Changes']"));
    }
    public WebElement GoBack(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Go Back']"));
    }
    public WebElement NoCancelPayment(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='No, Keep Transaction']"));
    }
    public WebElement NoCancelChanges(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='No, Keep Transaction']"));
    }
    public WebElement KeepTransaction(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Keep Transaction']"));
    }
    public WebElement YesKeepTransaction(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Yes, Keep Transaction']"));
    }

    public WebElement BranchCode(){return getDriver().findElement(By.xpath("//input[@name='branchCode']"));
    }
    public WebElement OperatorID(){return getDriver().findElement(By.xpath("//input[@placeholder='Operator ID']"));
    }
    public WebElement ReasonRemote(){return getDriver().findElement(By.xpath("//input[@name='remoteBranch.remoteReason']"));
    }
    public WebElement EmptyRef(){return getDriver().findElement(By.xpath("//small[contains(text(),'Reference Number is required')]"));
    }
    public WebElement InvalidKTPN(){return getDriver().findElement(By.xpath("//h5[contains(text(),'No Transaction Found')]"));
    }
    public WebElement CancelledRefNum(){return getDriver().findElement(By.xpath("//h5[contains(text(),'Bills Payment Cancelled')]"));
    }

    public WebElement InvalidIRNum() {
        return getDriver().findElement(By.xpath("//*[text()='Please enter valid IR No.']"));
    }

        public WebElement InvalidIR () {
            return getDriver().findElement(By.xpath("//small[contains(text(),'Please enter valid IR No.')]"));
        }


        public WebElement SuccessChanges () {
            return getDriver().findElement(By.xpath("//p[contains(text(),'Details have been successfully updated.')]"));
        }
        public WebElement NoEditChanges () {
            return getDriver().findElement(By.xpath("//h5[text()='No Changes Have Been Made']"));
        }
        public WebElement NoIRNum () {
            return getDriver().findElement(By.xpath("//small[contains(text(),'IR Number is required')]"));
        }
        public WebElement OnlyLetters () {
            return getDriver().findElement(By.xpath("//small[contains(text(),'Only letters A-Z, Ñ, - and . are allowed.')]"));
        }
        public WebElement NoReason () {
            return getDriver().findElement(By.xpath("//small[contains(text(),'Reason for Cancellation is required')]"));
        }
        public WebElement NoReasonChange () {
            return getDriver().findElement(By.xpath("//small[contains(text(),'Reason for Change is required.')]"));
        }
        public WebElement Page_h5 () {
            return getDriver().findElement(By.xpath("//h5[contains(text(),'No Transaction Found')]"));
        }
        public WebElement OKButton () {
            return getDriver().findElement(By.xpath("//button[normalize-space()='OK']"));
        }
        public WebElement ClickOption () {
            return getDriver().findElement(By.cssSelector("[width='20']"));
        }
        public WebElement ChooseOption () {
            return getDriver().findElement(By.xpath("(//*[@class=' css-26l3qy-menu']//img)[2]"));
        }



}
