package org.mlkpx.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import static utilities.Driver.DriverManager.getDriver;

public class Home_PageObjects{
    public WebElement searchField (){
        return getDriver().findElement(By.cssSelector("[placeholder=\"Search MLKP\"]"));
    }
    public WebElement logout (){
        return getDriver().findElement(By.xpath("//span[@class='sc-iXzfSG fNneYW navbar-text']"));
    }
}
