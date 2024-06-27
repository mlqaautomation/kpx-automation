package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class BillsPayReport_PageObjects {


    public WebElement billspayReportPage(){
        return getDriver().findElement(By.xpath("//*[text()='Bills Pay Report']"));
    }
    public WebElement billspayCancellationReportPage(){
        return getDriver().findElement(By.xpath("//*[text()='Cancellation Report']"));
    }
    public WebElement billspayBranchTransactionReportPage(){
        return getDriver().findElement(By.xpath("//*[text()='Branch Transaction Report']"));
    }
    public WebElement billspayCancellationText(){
        return getDriver().findElement(By.xpath("//*[text()='Bills Pay Cancellation']"));
    }
    public WebElement billspayBranchTransactionText(){
        return getDriver().findElement(By.xpath("//*[text()='Bills Pay Branch Transaction']"));
    }
    public WebElement okButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }
    public WebElement invalidDateText(){
        return getDriver().findElement(By.xpath("//*[text()='Invalid date']"));
    }
    public WebElement futureDateTExt(){
        return getDriver().findElement(By.xpath("//*[text()='Date cannot be a future date.']"));
    }
    public WebElement noReportsGenerate(){
        return getDriver().findElement(By.xpath("//*[text()='No Reports Generated']"));
    }
    public WebElement clearButtonB(){
        return getDriver().findElement(By.xpath("//*[text()='Clear']"));
    }
}
