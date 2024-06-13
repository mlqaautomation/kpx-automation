package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class MLWalletServicesReportBranchReport_PageObjects {
    public WebElement mlWalletReportsNavLink(){
        return getDriver().findElement(By.xpath("//*[text()='ML Wallet Reports']"));
    }
    public WebElement branchTransactionReport(){
        return getDriver().findElement(By.cssSelector("[href=\"/reports/ml-money/branch-transaction\"]"));
    }
    public WebElement branchTransactionPage(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-kbhJrz iJPEWO\"]"));
    }
    public WebElement sendMoneyKwartaPadala(){
        return getDriver().findElement(By.cssSelector("[value=\"SEND_MONEY_AKP\"]"));
    }
    public WebElement cashInViaBranch(){
        return getDriver().findElement(By.cssSelector("[value=\"CASH_IN\"]"));
    }
    public WebElement cashOutViaBranch(){
        return getDriver().findElement(By.cssSelector("[value=\"CASH_OUT\"]"));
    }
}
