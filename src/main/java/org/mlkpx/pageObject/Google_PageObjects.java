package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class Google_PageObjects {
    public WebElement googleContainer (){
        return getDriver().findElement(By.cssSelector("[role='button']"));
    }
    public WebElement googleContainerAlbert (){
        return getDriver().findElement(By.cssSelector("[class=\"nsm7Bb-HzV7m-LgbsSe-MJoBVe\"]"));
    }
    public WebElement signInWithKPX (){

        return getDriver().findElement(By.xpath("//button[normalize-space()='SIGN IN WITH KPX']"));

    }

    public WebElement emailField(){
        return getDriver().findElement(By.cssSelector("[id='identifierId']"));
    }

    public WebElement emailNextButton(){
        return getDriver().findElement(By.cssSelector("[id='identifierNext']"));
    }

    public WebElement passwordField(){
        return getDriver().findElement(By.name("Passwd"));
    }

    public WebElement passNextButton(){
        return getDriver().findElement(By.cssSelector("[id='passwordNext']"));
    }

    public WebElement anotherWayButton(){
        return getDriver().findElement(By.cssSelector("[jsname='eBSUOb']"));
    }

    public WebElement selectGoogleAuthenticator(){
        return getDriver().findElement(By.xpath("//*[contains(text(), 'Google Authenticator')]"));
    }

    public WebElement codeField(){
        return getDriver().findElement(By.cssSelector("[type='tel']"));
    }
    public WebElement totpNextButton(){
        return getDriver().findElement(By.cssSelector("[id='totpNext']"));
    }
    public WebElement chooseCurrentAccount(){
        return getDriver().findElement(By.cssSelector("[aria-labelledby='picker-item-label-0']"));
    }
    public WebElement useOtherAccount(){
        return getDriver().findElement(By.cssSelector("[id='use-other']"));
    }

    public WebElement googleContainer2 (){
        return getDriver().findElement(By.cssSelector("[class='haAclf']"));
    }
    public WebElement emailAlbertContainer2 (){
        return getDriver().findElement(By.cssSelector("[class=\"fFW7wc-ibnC6b-sM5MNb TAKBxb \"]"));
    }

}
