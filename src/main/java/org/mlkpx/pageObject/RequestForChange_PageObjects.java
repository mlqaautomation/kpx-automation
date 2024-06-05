package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class RequestForChange_PageObjects {
    public WebElement rfcLink() { return getDriver().findElement(By.xpath("//*[text()='Request for Change']")); }
    public WebElement rfcText() { return getDriver().findElement(By.xpath("//h2[text()=\"Request for Change\"]")); }
    public WebElement kptnField(){
        return getDriver().findElement(By.cssSelector("[name=\"kptn\"]"));
    }


    public WebElement domesticRFClink(){ return getDriver().findElement(By.xpath("//a[@class=\"nav-link\" and @href=\"/sendout/request-for-change\"]")); }
    public WebElement senderProvinceChange(){ return getDriver().findElement(By.xpath("(//*[@class=\" css-tlfecz-indicatorContainer\"])[1]")); }
    public WebElement senderNewProvince(){ return getDriver().findElement(By.xpath("(//*[text()=\"ABRA\"])[1]")); }
    public WebElement senderCityChange(){ return getDriver().findElement(By.xpath("(//*[@class=\"css-19bqh2r\"])[2]")); }
    public WebElement senderNewCity(){ return getDriver().findElement(By.xpath("(//*[text()=\"BANGUED\"])[1]")); }
    public WebElement senderIDNumber(){ return getDriver().findElement(By.xpath("//input[@placeholder='ID NUMBER']")); }
    public WebElement senderHouseNum(){ return getDriver().findElement(By.xpath("//input[@placeholder='House No, Street / Baranggay / Sitio']")); }


    public WebElement searchButton(){
        return getDriver().findElement(By.cssSelector("[class=\"btn-sm btn btn-primary\"]"));
    }
    public WebElement senderHouseField(){
        return getDriver().findElement(By.cssSelector("[name=\"senderNew.currentAddress.otherAddress\"]"));
    }
    public WebElement receiverLastNameField(){
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.lastName\"]"));
    }
    public WebElement receiverFirstNameField(){
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.firstName\"]"));
    }
    public WebElement receiverMiddleNameField(){
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.middleName\"]"));
    }
    public WebElement receiverProvinceField(){
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.address.addressL1Id\"]"));
    }
    public WebElement receiverNewProvince(){ return getDriver().findElement(By.xpath("//*[text()=\"AKLAN\"]")); }
    public WebElement receiverCityField(){
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.address.addressL2Id\"]"));
    }
    public WebElement receiverNewCity(){ return getDriver().findElement(By.xpath("//*[text()=\"MALAY\"]")); }
    public WebElement receiverHouseField(){
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.address.otherAddress\"]"));
    }
    public WebElement receiverNoContactNo(){
        return getDriver().findElement(By.cssSelector("[name=\"beneficiary.hasNoContactNumber\"]"));
    }
    public WebElement irNo(){
        return getDriver().findElement(By.cssSelector("[name=\"irNo\"]"));
    }
    public WebElement initiatedBy(){
        return getDriver().findElement(By.cssSelector("[name=\"initiatedBy\"]"));
    }
    public WebElement initiatedByCustomer(){
        return getDriver().findElement(By.cssSelector("[value=\"CUSTOMER\"]"));
    }
    public WebElement reason(){
        return getDriver().findElement(By.cssSelector("[name=\"reason\"]"));
    }
    public WebElement rfcSubmitButton(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Submit Request']"));
    }
    public WebElement yesChangeDetailsButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }
    public WebElement noKeepTransactionButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-cancel swal2-styled\"]"));
    }
    public WebElement detailsChangeText(){ return getDriver().findElement(By.xpath("//*[text()=\"Details Changed\"]")); }
    public WebElement rfcProceedToPrinting(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }
    public WebElement rfcCancelButton(){
        return getDriver().findElement(By.cssSelector("[class=\"sc-jnOGJG blZoWd btn btn-secondary\"]"));
    }

    public WebElement sendoutCancelledText(){ return getDriver().findElement(By.xpath("//*[text()=\"Sendout Cancelled\"]")); }
    public WebElement noTransactionFoundText(){ return getDriver().findElement(By.xpath("//*[text()=\"No Transaction Found\"]")); }
    public WebElement detailsChange(){ return getDriver().findElement(By.xpath("//*[text()=\"Details Changed\"]")); }
    public WebElement cancelOKButton(){
        return getDriver().findElement(By.cssSelector("[class=\"swal2-confirm swal2-styled\"]"));
    }
    public WebElement idTypeDropDown(){
        return getDriver().findElement(By.cssSelector("[name=\"senderNew.id.idType\"]"));
    }
    public WebElement idTypeSelected(){
        return getDriver().findElement(By.xpath("(//option[@value=\"3\"])[1]"));
    }
}
