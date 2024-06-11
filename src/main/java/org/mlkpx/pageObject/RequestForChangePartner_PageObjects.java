package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class RequestForChangePartner_PageObjects {

    public WebElement rfcPartnerSendoutLink(){
        return getDriver().findElement(By.cssSelector("[href=\"/sendout/request-for-change-partner\"]"));
    }
    public WebElement partnerSendoutAmendmentText(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-iHmpnF glnAlU mb-4\"]"));
    }
    public WebElement rfcReferenceNumber(){
        return getDriver().findElement(By.cssSelector("[name=\"refNum\"]"));
    }
    public WebElement rfcpMiddleNameField(){
        return getDriver().findElement(By.cssSelector("[name=\"newReceiverMiddleName\"]"));
    }
    public WebElement selectedReasonForChange(){
        return getDriver().findElement(By.cssSelector("[value=\"WRONG RECEIVER MIDDLE NAME\"]"));
    }
    public WebElement otherDetailsField(){
        return getDriver().findElement(By.cssSelector("[placeholder=\"Other Details for Amending\"]"));
    }
    public WebElement sendoutTransactionInformationText(){
        return getDriver().findElement(By.xpath("//*[text()='Sendout Transaction Information']"));
    }
    public WebElement rfcpCancelButtoninReceipt() {
        return getDriver().findElement(By.xpath("//*[text()='Cancel']"));}
    public WebElement rfcpCancelledText() {
        return getDriver().findElement(By.cssSelector("[class=\"sc-gEvEer lkAUft\"]"));}
    public WebElement rfcpNavigation() {
        return getDriver().findElement(By.cssSelector("[class=\"sc-iHmpnF glnAlU mb-4\"]"));}
}
