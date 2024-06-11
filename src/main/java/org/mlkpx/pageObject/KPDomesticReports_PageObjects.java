package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class KPDomesticReports_PageObjects {

    public WebElement clearButton(){
        return getDriver().findElement(By.xpath("//*[text()='Clear']"));
    }
    public WebElement generateReportButton(){
        return getDriver().findElement(By.xpath("//*[text()='Generate Report']"));
    }
    public WebElement kpDomesticReportsNavLink(){
        return getDriver().findElement(By.xpath("//*[text()='KP Domestic Reports']"));
    }
    public WebElement branchTransactionReport(){
        return getDriver().findElement(By.xpath("//*[text()='Branch Transaction Report']"));
    }
    public WebElement transactionTypeText(){
        return getDriver().findElement(By.xpath("//*[text()='Transaction Type']"));
    }
    public WebElement selectedTransactionTypeSendout(){
        return getDriver().findElement(By.xpath("(//option[@value='SENDOUT'])[1]"));
    }
    public WebElement selectedTransactionTypePayout(){
        return getDriver().findElement(By.xpath("//*[text()='PAYOUT']"));
    }
    public WebElement selectedTransactionTypeSendoutCancellation(){
        return getDriver().findElement(By.xpath("//*[text()='SENDOUT CANCELLATION']"));
    }
    public WebElement selectedTransactionTypeReturnToSender(){
        return getDriver().findElement(By.xpath("//*[text()='RETURN TO SENDER']"));
    }
    public WebElement selectedTransactionTypeRequestForChange(){
        return getDriver().findElement(By.xpath("//*[text()='REQUEST FOR CHANGE']"));
    }
    public WebElement selectedTransactionTypePayoutCancellation(){
        return getDriver().findElement(By.xpath("//*[text()='PAYOUT CANCELLATION']"));
    }
    public WebElement month(){
        return getDriver().findElement(By.xpath("//*[text()='Month']"));
    }
    public WebElement year(){
        return getDriver().findElement(By.xpath("//*[text()='Year']"));
    }
    public WebElement noReportsGenerated(){
        return getDriver().findElement(By.xpath("//*[text()='No Reports Generated']"));
    }
    public WebElement monthDropDownButton(){
        return getDriver().findElement(By.cssSelector("[name=\"monthlyTimeframe\"]"));
    }
    public WebElement selectedMonthMay(){
        return getDriver().findElement(By.xpath("//*[@name='monthlyTimeframe']/option[6]"));
    }
    public WebElement selectedMonthDecember(){
        return getDriver().findElement(By.xpath("//*[@name='monthlyTimeframe']/option[13]"));
    }
    public WebElement selectedMonthJune(){
        return getDriver().findElement(By.xpath("//*[text()='June']"));
    }
    public WebElement selectedYear2024(){
        return getDriver().findElement(By.cssSelector("[value=\"2024\"]"));
    }
    public WebElement transactionType(){
        return getDriver().findElement(By.cssSelector("[name=\"transactionType\"]"));
    }
    public WebElement timeFrame(){
        return getDriver().findElement(By.cssSelector("[name=\"timeframe\"]"));
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

    public WebElement DateRange(){
        return getDriver().findElement(By.cssSelector("[value=\"DATE_RANGE\"]"));
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

}
