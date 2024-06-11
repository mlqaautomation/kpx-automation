package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class SendoutPartnerMoneygramCancellation_PageObjects {

    public WebElement partnerButton(){

        return getDriver().findElement(By.xpath("(//input[@class=\"form-check-input\"])[2]"));
    }
    public WebElement partnerSendoutCancelledText(){

        return getDriver().findElement(By.xpath("//*[text()=\"Partner Sendout Cancelled\"]"));
    }
    public WebElement proceedPrintingButton(){

        return getDriver().findElement(By.xpath("//*[text()=\"Proceed to Printing\"]"));
    }

    public WebElement cancelButtonInReceipt(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-iMWBiJ dStcyq btn btn-secondary\"]"));
    }
    public WebElement irNumberField(){
        return getDriver().findElement(By.cssSelector("[name=\"irNumber\"]"));
    }
    public WebElement selectedReason(){
        return getDriver().findElement(By.cssSelector("[value=\"NO RECEIVE LOCATION\"]"));
    }
    public WebElement detailsField(){
        return getDriver().findElement(By.cssSelector("[name=\"details\"]"));
    }
}
