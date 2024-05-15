package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class WS_KwartaPadalaPayOut_PageObjects {
    public WebElement kwartaPadalaPayoutNavLink(){return getDriver().findElement(By.xpath("(//*[text()=\"Kwarta Padala Payout\"])[1]"));}
    public WebElement kwartaPadalaPayoutText(){return getDriver().findElement(By.xpath("(//*[text()=\"Kwarta Padala Payout\"])[3]"));}
    public WebElement searchKYCText(){return getDriver().findElement(By.xpath("//*[text()=\"Search Registered KYC\"]"));}
    public WebElement referenceNumField(){return getDriver().findElement(By.cssSelector("[name=\"kptn\"]"));}
    public WebElement kptnText(){

        return getDriver().findElement(By.cssSelector("[data-testid='sendoutKPTN']"));
    }
    public WebElement searchButton(){return getDriver().findElement(By.cssSelector("[class=\"btn-sm mt-3 btn btn-primary\"]"));}
    public WebElement amountField(){return getDriver().findElement(By.cssSelector("[name=\"amount\"]"));}
    public WebElement searchKYCButton(){return getDriver().findElement(By.xpath("(//button[normalize-space()='Search KYC'])"));}
    public WebElement okButton(){return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));}
    public WebElement kptnIsRequiredText(){return getDriver().findElement(By.xpath("//*[text()=\"KPTN is required\"]"));}
    public WebElement emptyAmount(){return getDriver().findElement(By.xpath("//*[text()=\"Amount should be a number\"]"));}
    public WebElement invalidReferenceText(){return getDriver().findElement(By.cssSelector("[class=\"sc-gEvEer lkAUft\"]"));}
    public WebElement invalidAmountText(){return getDriver().findElement(By.cssSelector("[class=\"w-100 alert alert-secondary show\"]"));}
    public WebElement payoutText(){return getDriver().findElement(By.cssSelector("[class=\"mb-4\"]"));}
    public WebElement cancelButtonInPayoutPage(){return getDriver().findElement(By.cssSelector("[class=\"btn btn-secondary\"]"));}
    public WebElement noStayOnThisPage(){return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));}
    public WebElement yesDoNotProcessButton(){return getDriver().findElement(By.cssSelector("[class=\"swal2-cancel swal2-styled\"]"));}
    public WebElement claimAmountButton(){return getDriver().findElement(By.cssSelector("[class=\"btn btn-primary\"]"));}
    public WebElement claimedText(){return getDriver().findElement(By.cssSelector("[class=\"sc-gEvEer lkAUft\"]"));}
    public WebElement transactionBeingProcessedText(){return getDriver().findElement(By.cssSelector("[class=\"sc-aXZVg FiXoI\"]"));}
    public WebElement operatorIDField(){return getDriver().findElement(By.cssSelector("[placeholder=\"Operator ID\"]"));}
    public WebElement reasonField(){return getDriver().findElement(By.cssSelector("[name=\"remoteBranch.remoteReason\"]"));}
    public WebElement payoutSuccessfulText(){return getDriver().findElement(By.cssSelector("[class=\"sc-aXZVg FiXoI\"]"));}
    public WebElement proceedToPrintingButton(){return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));}
    public WebElement confirmPayoutButton(){return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));}
    public WebElement cancelButtonReceipt(){return getDriver().findElement(By.cssSelector("[class=\"sc-jnOGJG blZoWd btn btn-secondary\"]"));}
    public WebElement searchKYC() {
        return getDriver().findElement(By.xpath("//*[text()='Search KYC']"));
    }

}
