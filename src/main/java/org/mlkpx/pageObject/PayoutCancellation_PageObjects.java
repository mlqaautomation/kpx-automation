
package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;
public class PayoutCancellation_PageObjects {
    public WebElement payout_link(){
        return getDriver().findElement(By.cssSelector("[href='/payout']"));
    }
    public WebElement payoutPage_h2(){
        return getDriver().findElement(By.xpath("//h2"));
    }
    public WebElement payoutCanPage(){
        return getDriver().findElement(By.xpath("//a[@class='dropdown-toggle nav-link']"));
    }
    public WebElement payoutRepPage(){
        return getDriver().findElement(By.xpath("//a[@href='/payout/reprint']"));
    }
    public WebElement payoutPage_h5(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'No Transaction Found')]"));
    }
    public WebElement PayoutClaimed(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Payout Claimed')]"));
    }
    public WebElement payoutClaim_h5(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Payout Claimed')]"));
    }
    public WebElement PayoutTransaction(){
        return getDriver().findElement(By.xpath("(//a[@href='/payout'])[2]"));
    }
    public WebElement PayoutCancellation(){
        return getDriver().findElement(By.xpath("(//a[@href='/payout/domestic-cancellation'])[1]"));
    }
    public WebElement PayoutCancellationAmountInfo(){
        return getDriver().findElement(By.xpath("//h2[contains(text(),'Payout Cancellation')]"));
    }
    public WebElement ReprintPayoutReceipt(){
        return getDriver().findElement(By.xpath("//h3[contains(text(),'Reprint Payout Receipt')]"));
    }
    public WebElement ReprintPayoutPartnerReceipt(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-gFVvzn cNiBCK\"]"));
    }
    public WebElement ReprintPayoutPartnerReceipts(){
        return getDriver().findElement(By.xpath("//h3[contains(text(),'Reprint Partner Payout Receipt')]"));
    }

    public WebElement NoTransactionFound(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'No Transaction Found')]"));
    }




    public WebElement UnremoteTransaction(){
        return getDriver().findElement(By.xpath("//input[@value='0']"));
    }
    public WebElement RemoteTransaction(){
        return getDriver().findElement(By.xpath("//input[@value='1']"));
    }
    public WebElement DomesticTransaction(){
        return getDriver().findElement(By.xpath("//input[@value='ML']"));
    }
    public WebElement PayKTPN(){
        return getDriver().findElement(By.xpath("//input[@name='kptn']"));
    }
    public WebElement CancelKTPN(){
        return getDriver().findElement(By.xpath("//input[@name='kptn']"));
    }
    public WebElement RepKTPN(){
        return getDriver().findElement(By.xpath("//input[@name='kptn']"));
    }
    public WebElement IRNum(){
        return getDriver().findElement(By.xpath("//input[@placeholder='IR No.']"));
    }
    public WebElement InitiatedBy(){
        return getDriver().findElement(By.xpath("//select[@name='initiatedBy']"));
    }
    public WebElement ReasonCancel(){
        return getDriver().findElement(By.xpath("//textarea[@placeholder='Reason for Cancellation']"));
    }
    public WebElement ReasonReprinting(){
        return getDriver().findElement(By.xpath("//textarea[@placeholder='Reason for Reprinting']"));
    }
    public WebElement CancelButton(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Cancel Payout']"));
    }
    public WebElement PrintReceipt(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Print Receipt']"));
    }
    public WebElement PrintButton(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Print Receipt']"));
    }
    public WebElement YesCancelButton(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Yes, Cancel Payout']"));
    }
    public WebElement kptnText(){return getDriver().findElement(By.cssSelector("[data-testid='sendoutKPTN']"));
    }
    public WebElement PayAmount(){return getDriver().findElement(By.xpath("//input[@step='0.01' and @name='amount']"));}
    public WebElement SearchButton(){return getDriver().findElement(By.xpath("//button[normalize-space()='Search']"));
    }
    public WebElement Reprint(){return getDriver().findElement(By.xpath("//button[normalize-space()='Reprint']"));
    }
    public WebElement OKay(){return getDriver().findElement(By.xpath("//button[normalize-space()='OK']"));
    }
    public WebElement BranchCode(){return getDriver().findElement(By.xpath("//input[@name='branchCode']"));
    }
    public WebElement OperatorID(){return getDriver().findElement(By.xpath("//input[@placeholder='Operator ID']"));
    }
    public WebElement ReasonRemote(){return getDriver().findElement(By.xpath("//input[@name='remoteBranch.remoteReason']"));
    }
    public WebElement proceedToPrinting() {
        return getDriver().findElement(By.xpath("//*[text()='Proceed to Printing']"));
    }
    public WebElement cancelButtoninReceipt() {
        return getDriver().findElement(By.cssSelector("[class=\"sc-hIUJlX exqbQW btn btn-secondary\"]"));}


    public WebElement payoutKptn() {
        return getDriver().findElement(By.xpath("(//p[@class='sc-iowXnY cjiyKT'])[4]"));
    }

    public WebElement KtpnInfo(){return getDriver().findElement(By.xpath("//p[contains(text(),'KPTN')]"));}
    public WebElement SearchKYC(){return getDriver().findElement(By.xpath("//button[normalize-space()='Search KYC']"));
    }
    public WebElement SearchLName(){return getDriver().findElement(By.xpath("//input[@name='lastName']"));
    }
    public WebElement SearchFName(){return getDriver().findElement(By.xpath("//input[@name='firstName']"));
    }
    public WebElement SearchMName(){return getDriver().findElement(By.xpath("//input[@name='middleName']"));
    }
    public WebElement SearchKYCAc(){return getDriver().findElement(By.xpath("//button[normalize-space()='Search']"));
    }
    public WebElement ViewKYCCustomer(){return getDriver().findElement(By.xpath("(//button[normalize-space()='View'])[1]"));
    }
    public WebElement NavViewKYC(){return getDriver().findElement(By.xpath("//h2[contains(text(),'View KYC')]"));
    }
    public WebElement ActiveStat(){return getDriver().findElement(By.xpath("//h5[contains(text(),'Active Status')]"));
    }
    public WebElement SelectKYC(){return getDriver().findElement(By.xpath("(//button[normalize-space()='Select KYC'])[1]"));
    }
    public WebElement SelectKYCs(){return getDriver().findElement(By.xpath("(//button[normalize-space()='Back'])[1]"));
    }
    public WebElement SelectsKYC(){return getDriver().findElement(By.xpath("//span[contains(text(),'Select KYC')]"));
    }
    public WebElement PayoutInfos(){return getDriver().findElement(By.xpath("//h2[contains(text(),'Payout')]"));
    }
    public WebElement ClaimAmount(){return getDriver().findElement(By.xpath("//button[normalize-space()='Claim Amount']"));
    }
    public WebElement PayoutConfirm(){return getDriver().findElement(By.xpath("//button[normalize-space()='Confirm Payout']"));
    }
    public WebElement ConfirmPayout(){return getDriver().findElement(By.xpath("//button[normalize-space()='Confirm Payout']"));
    }
    public WebElement SuccessfulPay(){return getDriver().findElement(By.xpath("//h5[contains(text(),'Payout Successful')]"));
    }
    public WebElement SuccessfulCancelPay(){return getDriver().findElement(By.xpath("//h5[contains(text(),'Payout Cancelled')]"));
    }
    public WebElement InvalidKTPN(){return getDriver().findElement(By.xpath("//h5[contains(text(),'No Transaction Found')]"));
    }
    public WebElement OKInvalidKTPN(){return getDriver().findElement(By.xpath("//button[normalize-space()='OK']"));
    }
    public WebElement InvalidAmount(){return getDriver().findElement(By.cssSelector("[class='w-100 alert alert-secondary show']"));
    }
    public WebElement AmountClaimed(){return getDriver().findElement(By.cssSelector("[class='sc-gEvEer lkAUft']"));
    }
    public WebElement RequiredKTPN(){return getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[2]/div[1]/div[4]/div/div/div[1]/div/small"));
    }
    public WebElement AmountShouldBeNumber(){return getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[2]/div[1]/div[4]/div/div/div[2]/div/small"));
    }
    public WebElement BranchNotFound(){return getDriver().findElement(By.xpath("(//span[@class='text-danger'])[2]"));
    }
    public WebElement OperatorNotFound(){return getDriver().findElement(By.xpath("(//span[@class='text-danger'])[4]"));
    }

    public WebElement ComplianceAss(){return getDriver().findElement(By.xpath("//h5[@class='sc-aXZVg FiXoI']"));
    }
    public WebElement OKCom(){return getDriver().findElement(By.xpath("//button[normalize-space()='OK']"));
    }
    public WebElement CKTPNRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'KPTN is required')]"));
    }
    public WebElement IRNumRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'IR Number is required')]"));
    }
    public WebElement ReasonRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Reason for Cancellation is required')]"));
    }

    public WebElement ReReasonRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Reason is required')]"));
    }
    public WebElement CannotCancel(){return getDriver().findElement(By.xpath("//h5[contains(text(),'Cannot Cancel Payout')]"));
    }
    public WebElement FailedCancel(){return getDriver().findElement(By.xpath("//h5[contains(text(),'Cancel Payout Failed')]"));
    }
    public WebElement KeepTransaction(){return getDriver().findElement(By.xpath("//button[normalize-space()='Keep Transaction']"));
    }
    public WebElement YesKeepTransaction(){return getDriver().findElement(By.xpath("//button[normalize-space()='Yes, Keep Transaction']"));
    }
    public WebElement AlreadyBeenCancelled(){return getDriver().findElement(By.xpath("//p[contains(text(),'Payout transaction has already been cancelled.')]"));
    }





}
