package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class CorporatePartnerReport_PageObjects {
    public WebElement currencyText(){
        return getDriver().findElement(By.xpath("//*[text()='Currency']"));
    }
    public WebElement corporatePartnerReportsNavLink(){
        return getDriver().findElement(By.xpath("//*[text()='Corporate Partner Reports']"));
    }
    public WebElement currencyDropdown(){
        return getDriver().findElement(By.cssSelector("[name=\"currency\"]"));
    }
    public WebElement phpText(){
        return getDriver().findElement(By.cssSelector("[value=\"PHP\"]"));
    }
    public WebElement usdText(){
        return getDriver().findElement(By.cssSelector("[value=\"USD\"]"));
    }
    public WebElement sendoutInTransactionType(){
        return getDriver().findElement(By.xpath("//*[text()='SENDOUT']"));
    }
    public WebElement transactionType(){
        return getDriver().findElement(By.cssSelector("[name=\"transactionType\"]"));
    }
    public WebElement payoutInTransactionType(){
        return getDriver().findElement(By.cssSelector("[value=\"PAYOUT\"]"));
    }
    public WebElement defaultAllCurrency (){
        return getDriver().findElement(By.cssSelector("[value=\"ALL\"]"));
    }
    public WebElement dateInCorporatePartner(){
        return getDriver().findElement(By.cssSelector("[name=\"dailyTimeframe\"]"));
    }
    public WebElement timeFrameField(){
        return getDriver().findElement(By.cssSelector("[name=\"timeframe\"]"));
    }
    public WebElement futureDateText(){
        return getDriver().findElement(By.xpath("//*[text()='Date cannot be a future date.']"));
    }
    public WebElement DateRangeFrom(){
        return getDriver().findElement(By.cssSelector("[name=\"dateRangeFrom\"]"));
    }
    public WebElement DateRangeTo(){
        return getDriver().findElement(By.cssSelector("[name=\"dateRangeTo\"]"));
    }

    public WebElement invalidDateFutureDate(){
        return getDriver().findElement(By.xpath("//*[text()='Date cannot be a future date.']"));
    }
    public WebElement yearlyTimeFrame(){
        return getDriver().findElement(By.cssSelector("[name=\"yearlyTimeframe\"]"));
    }
    public WebElement selectedTimeFrameDaily(){
        return getDriver().findElement(By.cssSelector("[value=\"DAILY\"]"));
    }
    public WebElement selectedTimeFrameMonthly(){
        return getDriver().findElement(By.cssSelector("[value=\"MONTHLY\"]"));
    }
    public WebElement selectedTimeFrameDailyDate(){
        return getDriver().findElement(By.cssSelector("[name=\"dailyTimeframe\"]"));
    }

    public WebElement dateRange(){
        return getDriver().findElement(By.cssSelector("[value=\"DATE_RANGE\"]"));
    }


    public WebElement selectedMonthJune(){
        return getDriver().findElement(By.xpath("//*[text()='June']"));
    }
}
