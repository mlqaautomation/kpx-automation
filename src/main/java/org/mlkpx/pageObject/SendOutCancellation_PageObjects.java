package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class SendOutCancellation_PageObjects {
    public WebElement sendOutCancellationLink(){ return getDriver().findElement(By.xpath("//*[text()='Sendout Cancellation']"));}
    public WebElement noTransactionFoundText(){ return getDriver().findElement(By.xpath("//*[text()='No Transaction Found']"));}
    public WebElement keepTransactionButton(){ return getDriver().findElement(By.xpath("//*[text()=\"Keep Transaction\"]"));}
    public WebElement noStayOnThisPage(){ return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));}
    public WebElement cancelDropdown(){ return getDriver().findElement(By.xpath("//*[@href=\"/sendout/cancellation\"]"));}
    public WebElement searchButton(){
        return getDriver().findElement(By.cssSelector("[class=\"btn-sm btn btn-primary\"]"));
    }
    public WebElement okButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));}
    public WebElement cancelSendOutText(){ return getDriver().findElement(By.xpath("(//*[text()=\"Cancel Sendout\"])[2]"));}
    public WebElement kptnField(){
        return getDriver().findElement(By.cssSelector("[name=\"kptn\"]"));
    }
    public WebElement reasonField(){
        return getDriver().findElement(By.cssSelector("[name=\"reason\"]"));
    }
    public WebElement customerOption(){
        return getDriver().findElement(By.cssSelector("[value=\"Customer\"]"));
    }
    public WebElement initiatedByOption(){
        return getDriver().findElement(By.cssSelector("[name=\"initiatedBy\"]"));
    }
    public WebElement irNumberField(){
        return getDriver().findElement(By.cssSelector("[name=\"IRNumber\"]"));
    }

    public WebElement yesKeepTransactionButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-cancel swal2-styled\"]"));
    }
    public WebElement cancelButton(){
        return getDriver().findElement(By.cssSelector("[class=\"btn-sm btn btn-primary\"]"));
    }
    public WebElement noKeepTransaction(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-cancel swal2-styled\"]"));
    }
    public WebElement yesCancelSendout(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }
    public WebElement alreadyCancelledText(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-gEvEer lkAUft\"]"));
    }

}
