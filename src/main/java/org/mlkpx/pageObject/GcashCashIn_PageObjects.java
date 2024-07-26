package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class GcashCashIn_PageObjects {
    public WebElement gcashNav (){
        return getDriver().findElement(By.xpath("//*[text()='GCash']"));
    }
    public WebElement cashInNav (){
        return getDriver().findElement(By.xpath("(//*[text()='Cash In'])[1]"));
    }
    public WebElement cashInText (){
        return getDriver().findElement(By.xpath("(//*[text()='Cash In'])[2]"));
    }
    public WebElement cashOutNav (){
        return getDriver().findElement(By.xpath("//*[text()='Cash Out']"));
    }
    public WebElement tranSactions (){
        return getDriver().findElement(By.xpath("//*[text()='Transactions']"));
    }
    public WebElement receiptPrinting (){
        return getDriver().findElement(By.xpath("//*[text()='Receipt Reprinting']"));
    }



    public WebElement gcashNumberReceiver (){
        return getDriver().findElement(By.cssSelector("[name=\"receiverMobileNumber\"]"));
    }
    public WebElement gcashNumberSender (){
        return getDriver().findElement(By.cssSelector("[name=\"senderMobileNumber\"]"));
    }
    public WebElement senderFirstName (){
        return getDriver().findElement(By.cssSelector("[name=\"senderFirstName\"]"));
    }
    public WebElement senderMiddleName (){
        return getDriver().findElement(By.cssSelector("[name=\"senderMiddleName\"]"));
    }
    public WebElement middleNameCheckbox (){
        return getDriver().findElement(By.cssSelector("[name=\"senderHasNoMiddleName\"]"));
    }

    public WebElement senderLastName (){
        return getDriver().findElement(By.cssSelector("[name=\"senderLastName\"]"));
    }
    public WebElement senderBirthdate (){
        return getDriver().findElement(By.cssSelector("[name=\"birthdate\"]"));
    }
    public WebElement senderEmail (){
        return getDriver().findElement(By.cssSelector("[name=\"email\"]"));
    }
    public WebElement principalAmount (){
        return getDriver().findElement(By.cssSelector("[name=\"principalAmount\"]"));
    }
    public WebElement submitButton (){
        return getDriver().findElement(By.cssSelector("[type=\"submit\"]"));
    }
    public WebElement cancelButton (){
        return getDriver().findElement(By.xpath("//*[text()='Cancel']"));
    }
    public WebElement confirmButton (){
        return getDriver().findElement(By.xpath("//*[text()='Confirm Cash In']"));
    }

    public WebElement goBackAndReviewButton (){
        return getDriver().findElement(By.xpath("//*[text()='Go Back & Review']"));
    }
    public WebElement okButton (){
        return getDriver().findElement(By.xpath("//*[text()='OK']"));
    }
    public WebElement checkStatusButton (){
        return getDriver().findElement(By.xpath("//*[text()='Check Status']"));
    }
    public WebElement transactionPendingText (){
        return getDriver().findElement(By.xpath("//*[text()='Transaction is Pending']"));
    }
    public WebElement proceedButton (){
        return getDriver().findElement(By.xpath("//*[text()='Proceed to Printing']"));
    }
    public WebElement cashInSuccessfulText (){
        return getDriver().findElement(By.xpath("//*[text()='Cash In Successful']"));
    }
    public WebElement unableToProcessCashInTransactionText (){
        return getDriver().findElement(By.xpath("//*[text()='Unable to process cash in transaction']"));
    }
    public WebElement receiverMobileNumberIsRequiredText (){
        return getDriver().findElement(By.xpath("//*[text()='Receiver Mobile No. is required.']"));
    }
    public WebElement firstNameIsRequired (){
        return getDriver().findElement(By.xpath("//*[text()='First name is required.']"));
    }

    public WebElement middleNameIsRequired (){
        return getDriver().findElement(By.xpath("//*[text()='Middle name is required.']"));
    }
    public WebElement lastNameIsRequired (){
        return getDriver().findElement(By.xpath("//*[text()='Last name is required.']"));
    }
    public WebElement pleaseEnterAValidBirthDate (){
        return getDriver().findElement(By.xpath("//*[text()='Please enter a valid birth date']"));
    }
    public WebElement futureDate (){
        return getDriver().findElement(By.xpath("//*[text()='Birth date cannot be the current date or future date']"));
    }
    public WebElement emptyAmountText (){
        return getDriver().findElement(By.xpath("//*[text()='Please enter a valid number.']"));
    }
    public WebElement zeroAmountText (){
        return getDriver().findElement(By.xpath("//*[text()='Value must be greater than or equal to 1.']"));
    }
    public WebElement exceedTransaction (){
        return getDriver().findElement(By.xpath("//*[text()='We are unable to process your request. Wallet capacity exceeded. (version: 920f8ee)']"));
    }












    public WebElement existingSimilarTransactionModal (){
        return getDriver().findElement(By.xpath("//*[text()='Existing Similar Transaction']"));
    }
    public WebElement yesProceedTransaction (){
        return getDriver().findElement(By.xpath("//*[text()='Yes, Proceed Transaction']"));
    }
    public WebElement pendingText (){
        return getDriver().findElement(By.xpath("//*[text()='PENDING']"));
    }
    public WebElement verificationForSenderInformationName (){
        return getDriver().findElement(By.cssSelector("[class=\"sc-ERObt jyTjOh\"]"));
    }











    public WebElement cancelInReceiptButton (){
        return getDriver().findElement(By.xpath("//*[text()='Cancel']"));
    }






}
