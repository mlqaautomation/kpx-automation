package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class SOReprinting_PageObjects {
    public WebElement soReprintingLink(){return getDriver().findElement(By.xpath("//*[@href='/sendout/reprinting'] [text()='SO Reprinting']"));}
    public WebElement soReprintText(){return getDriver().findElement(By.xpath("//*[text()=\"Sendout Reprint\"]"));}
    public WebElement kptnButtonInReprint(){
        return getDriver().findElement(By.cssSelector("[name=\"kptn\"]"));}
    public WebElement reasonSOReprint(){
        return getDriver().findElement(By.cssSelector("[name=\"reason\"]"));}
    public WebElement reprintButton(){
        return getDriver().findElement(By.cssSelector("[class=\"btn-sm btn btn-primary\"]"));}
    public WebElement printSendoutReceiptText(){return getDriver().findElement(By.cssSelector("[class=\"sc-ePDLzJ bdAMiC\"]"));}
    public WebElement cancelButton(){return getDriver().findElement(By.xpath("//*[text()='Cancel']"));}
    public WebElement noTransactionFoundText(){return getDriver().findElement(By.xpath("//*[text()=\"No Transaction Found\"]"));}

}
