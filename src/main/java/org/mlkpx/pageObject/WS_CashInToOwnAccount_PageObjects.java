package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class WS_CashInToOwnAccount_PageObjects {

    public WebElement walletServicesLink(){return getDriver().findElement(By.xpath("//*[@href=\"/wallet-services/cash-in\"]"));}
    public WebElement walletServicesText(){return getDriver().findElement(By.xpath("(//*[text()=\"Wallet Services\"])[2]"));}
    public WebElement cashInText(){return getDriver().findElement(By.xpath("//h2[@class=\"mb-2\"]"));}
    public WebElement referenceNumField(){
        return getDriver().findElement(By.cssSelector("[name=\"kptn\"]"));
    }
    public WebElement mobileNumField(){
        return getDriver().findElement(By.cssSelector("[name=\"mobileNumber\"]"));
    }
    public WebElement searchButton(){
        return getDriver().findElement(By.cssSelector("[type=\"submit\"]"));
    }
    public WebElement proceedButton(){
        return getDriver().findElement(By.cssSelector("[class=\"btn btn-primary\"]"));
    }
    public WebElement tenderAmountField(){
        return getDriver().findElement(By.cssSelector("[id=\"moneyInput\"]"));
    }
    public WebElement totalAmount(){
        return getDriver().findElement(By.cssSelector("[class=\"text-right text-monospace col-md-8\"]"));
    }
    public WebElement yesDoNotProcessButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-cancel swal2-styled\"]"));
    }
    public WebElement noStayOnThisPageButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }
    public WebElement cancelButton(){
        return getDriver().findElement(By.cssSelector("[class=\"mr-2 btn btn-secondary\"]"));
    }
    public WebElement cancelInProceedButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-cancel swal2-styled\"]"));
    }
    public WebElement confirmCashInButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }
    public WebElement cashInSuccessfulText(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-aXZVg FiXoI\"]"));
    }
    public WebElement proceedToPrintingButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }
    public WebElement cancelReceiptButton(){
        return getDriver().findElement(By.xpath("//*[text()='Cancel']"));
    }
    public WebElement detailsReceipt(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-fxwrCY irBnWG\"]"));
    }
    public WebElement invalidReferenceNumberText(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-gEvEer lkAUft\"]"));
    }
    public WebElement expiredReferenceNumberText(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-gEvEer lkAUft\"]"));
    }
    public WebElement transactionClaimedText(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-gEvEer lkAUft\"]"));
    }
    public WebElement invalidMobileNumberText(){
        return getDriver().findElement(By.xpath("//*[text()=\"Invalid Mobile No.\"]"));
    }
    public WebElement okButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }
    public WebElement transactionBeingProcessText(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-aXZVg FiXoI\"]"));
    }
    public WebElement mobileNum(){
        return getDriver().findElement(By.xpath("(//*[@name=\"searchBy\"])[2]"));
    }
    public WebElement invalidTenderAmountText(){
        return getDriver().findElement(By.xpath("//*[text()=\"Tender amount cannot be less than total amount\"]"));
    }
}
