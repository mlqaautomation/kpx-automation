package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class GcashTransaction_PageObjects {

    public WebElement transactionNavLink (){
        return getDriver().findElement(By.cssSelector("[href=\"/gcash/transactions\"]"));
    }
    public WebElement gcashTransactionText (){
        return getDriver().findElement(By.xpath("//*[text()='GCash Transactions']"));
    }
    public WebElement searchButton (){
        return getDriver().findElement(By.xpath("//*[text()='Search']"));
    }
    public WebElement clearButton (){
        return getDriver().findElement(By.xpath("//*[text()='Clear']"));
    }
    public WebElement kptn (){
        return getDriver().findElement(By.cssSelector("[name=\"transactionCode\"]"));
    }
    public WebElement misDivision (){
        return getDriver().findElement(By.xpath("(//*[text()='MIS DIVISION'])[2]"));
    }
    public WebElement noResultsFound (){
        return getDriver().findElement(By.xpath("//*[text()='No Results Found']"));
    }
    public WebElement okButton (){
        return getDriver().findElement(By.xpath("//*[text()='OK']"));
    }
    public WebElement firstName (){
        return getDriver().findElement(By.cssSelector("[name=\"firstName\"]"));
    }
    public WebElement lastName (){
        return getDriver().findElement(By.cssSelector("[name=\"lastName\"]"));
    }






    public WebElement failed (){
        return getDriver().findElement(By.xpath("(//*[text()='FAILED'])[2]"));
    }
    public WebElement pending (){
        return getDriver().findElement(By.xpath("(//*[text()='PENDING'])[2]"));
    }
    public WebElement completed (){
        return getDriver().findElement(By.xpath("(//*[text()='COMPLETED'])[2]"));
    }
    public WebElement maxAttempts (){
        return getDriver().findElement(By.xpath("(//*[text()='MAX ATTEMPTS'])[2]"));
    }
    public WebElement toVerify (){
        return getDriver().findElement(By.xpath("(//*[text()='TO VERIFY'])[2]"));
    }
    public WebElement cashOut (){
        return getDriver().findElement(By.xpath("(//*[text()='CASH OUT'])[2]"));
    }
    public WebElement cashIn (){
        return getDriver().findElement(By.xpath("(//*[text()='CASH IN'])[2]"));
    }





    public WebElement transactionType (){
        return getDriver().findElement(By.cssSelector("[name=\"transactionType\"]"));
    }

    public WebElement cashInType (){
        return getDriver().findElement(By.cssSelector("[value=\"SENDOUT\"]"));
    }
    public WebElement cashOutType (){
        return getDriver().findElement(By.cssSelector("[value=\"PAYOUT\"]"));
    }
    public WebElement pendingType (){
        return getDriver().findElement(By.cssSelector("[value=\"PENDING\"]"));
    }
    public WebElement toVerifyType (){
        return getDriver().findElement(By.cssSelector("[value=\"TO_VERIFY\"]"));
    }
    public WebElement failedType (){
        return getDriver().findElement(By.cssSelector("[value=\"FAILED\"]"));
    }
    public WebElement completedType (){
        return getDriver().findElement(By.cssSelector("[value=\"COMPLETED\"]"));
    }
    public WebElement maxAttemptsType (){
        return getDriver().findElement(By.cssSelector("[value=\"MAX_ATTEMPTS\"]"));
    }





}
