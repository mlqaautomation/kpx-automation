package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class GcashReceiptReprinting_PageObjects {


    public WebElement receiptReprinting (){
        return getDriver().findElement(By.xpath("//*[text()='Receipt Reprinting']"));
    }
    public WebElement receiptReprintingText (){
        return getDriver().findElement(By.xpath("//*[text()='Receipt Printing']"));
    }
    public WebElement referenceNumberField (){
        return getDriver().findElement(By.cssSelector("[name=\"referenceNumber\"]"));
    }
    public WebElement searchButton (){
        return getDriver().findElement(By.xpath("//*[text()='Search']"));
    }
    public WebElement receiptPage (){
        return getDriver().findElement(By.cssSelector("[class=\"sc-ePDLzJ bdAMiC\"]"));
    }
    public WebElement errorText (){
        return getDriver().findElement(By.xpath("//*[text()='Error']"));
    }
    public WebElement okButton (){
        return getDriver().findElement(By.xpath("//*[text()='OK']"));
    }
    public WebElement cancelButton (){
        return getDriver().findElement(By.xpath("//*[text()='Cancel']"));
    }
}
