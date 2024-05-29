package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class Login_PageObjects{

    public WebElement userNameField(){
        return getDriver().findElement(By.cssSelector("[placeholder=\"Username\"]"));
    }
    public WebElement passwordField(){
        return getDriver().findElement(By.cssSelector("[placeholder=\"PASSWORD\"]"));
    }

    public WebElement invalidCredText(){
        return getDriver().findElement(By.cssSelector("[class='sc-aXZVg FiXoI']"));
    }
    public WebElement loginButton(){
        return getDriver().findElement(By.cssSelector("[type='submit']"));
    }

}
