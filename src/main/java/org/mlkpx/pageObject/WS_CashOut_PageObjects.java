package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class WS_CashOut_PageObjects {
    public WebElement cashOutNavLink(){return getDriver().findElement(By.xpath("(//*[text()=\"Cash Out\"])[1]"));}
    public WebElement kptnIsRequiredText(){return getDriver().findElement(By.xpath("//*[text()=\"KPTN is required\"]"));}
    public WebElement referenceNumField(){return getDriver().findElement(By.cssSelector("[name=\"kptn\"]"));}
    public WebElement searchButton(){return getDriver().findElement(By.cssSelector("[class=\"btn-sm mt-3 mr-3 btn btn-primary\"]"));}
    public WebElement cancelButton(){return getDriver().findElement(By.cssSelector("[class=\"mr-2 btn btn-secondary\"]"));}
    public WebElement proceedButton(){return getDriver().findElement(By.cssSelector("[class=\"btn btn-primary\"]"));}
    public WebElement noStayOnThisPageButton(){return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));}
    public WebElement yesDoNotProcessButton(){return getDriver().findElement(By.cssSelector("[class=\"swal2-cancel swal2-styled\"]"));}
    public WebElement cancelButtonInProceed(){return getDriver().findElement(By.cssSelector("[class=\"swal2-cancel swal2-styled\"]"));}
    public WebElement confirmCashOut(){return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));}
    public WebElement informationText(){return getDriver().findElement(By.cssSelector("[class=\"col-md-6 col-lg-7\"]"));}
    public WebElement proceedButtonToReceipt(){return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));}
    public WebElement cashOutSuccessfulText(){return getDriver().findElement(By.cssSelector("[class=\"sc-aXZVg FiXoI\"]"));}
    public WebElement transactionReceipt(){return getDriver().findElement(By.cssSelector("[class=\"sc-fxwrCY irBnWG\"]"));}
    public WebElement cancelButtonInReceipt(){return getDriver().findElement(By.cssSelector("[class=\"sc-jnOGJG blZoWd btn btn-secondary\"]"));}
    public WebElement invalidReferenceNum(){return getDriver().findElement(By.cssSelector("[class=\"sc-gEvEer lkAUft\"]"));}
    public WebElement okButton(){return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));}
    public WebElement claimedTransactionText(){return getDriver().findElement(By.cssSelector("[class=\"sc-gEvEer lkAUft\"]"));}
    public WebElement cashoutText(){return getDriver().findElement(By.cssSelector("[class=\"mb-4 col\"]"));}

}
