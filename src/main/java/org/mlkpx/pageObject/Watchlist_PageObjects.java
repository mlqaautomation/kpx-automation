package org.mlkpx.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.Driver.DriverManager.getDriver;

public class Watchlist_PageObjects {
    public WebElement CustomerService(){
        return getDriver().findElement(By.cssSelector("[href='/customer-service/domestic-transaction']"));
    }
    public WebElement WatchlistDropdown(){
        return getDriver().findElement(By.cssSelector("[href='#']"));
    }
    public WebElement Watchlist(){
        return getDriver().findElement(By.cssSelector("[href='/customer-service/watchlist/']"));
    }
    public WebElement WatchlistConfiguration(){
        return getDriver().findElement(By.cssSelector("[href='/customer-service/watchlist/config/']"));
    }
    public WebElement Watchlist_Alias(){
        return getDriver().findElement(By.xpath("//h2"));
    }
    public WebElement WatchlistUpdate(){
        return getDriver().findElement(By.xpath("//h2[contains(text(),'Update Watchlist')]"));
    }
    public WebElement WatchlistTransaction(){
        return getDriver().findElement(By.xpath("//a[.='Watchlist Transactions']"));
    }
    public WebElement WatchlistTransactionH2(){
        return getDriver().findElement(By.xpath("//h2[contains(text(),'Watchlist Transactions')]"));
    }
    public WebElement ManageAliases(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Manage Aliases')]"));
    }
    public WebElement AddWatchlist(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Add Watchlist']"));
    }
    public WebElement AddWatchlistByGenInfo(){
        return getDriver().findElement(By.xpath("//input[@value='GENERAL_INFORMATION']"));
    }
    public WebElement AddWatchlistByMobileNum(){
        return getDriver().findElement(By.xpath("//input[@value='MOBILE_NUMBER']"));
    }
    public WebElement AddWatchlistByCompanyName(){
        return getDriver().findElement(By.xpath("//input[@value='COMPANY_NAME']"));
    }
    public WebElement GenInfoLName(){
        return getDriver().findElement(By.xpath("//input[@placeholder='Last Name']"));
    }
    public WebElement GenInfoFName(){
        return getDriver().findElement(By.xpath("//input[@placeholder='First Name']"));
    }
    public WebElement GenInfoMName(){
        return getDriver().findElement(By.xpath("//input[@placeholder='Middle Name']"));
    }
    public WebElement NoMName(){
        return getDriver().findElement(By.xpath("//input[@name='hasNoMiddleName']"));
    }
    public WebElement AliasLName(){
        return getDriver().findElement(By.xpath("(//input[@placeholder='Last Name'])[2]"));
    }
    public WebElement AliasFName(){
        return getDriver().findElement(By.xpath("(//input[@placeholder='First Name'])[2]"));
    }
    public WebElement AliasMName(){
        return getDriver().findElement(By.xpath("(//input[@placeholder='Middle Name'])[2]"));
    }
    public WebElement AliasLName1(){
        return getDriver().findElement(By.xpath("(//input[@placeholder='Last Name'])[1]"));
    }
    public WebElement AliasFName1(){
        return getDriver().findElement(By.xpath("(//input[@placeholder='First Name'])[1]"));
    }
    public WebElement AliasMName1(){
        return getDriver().findElement(By.xpath("(//input[@placeholder='Middle Name'])[1]"));
    }
    public WebElement AliasNoMName(){
        return getDriver().findElement(By.xpath("//input[@name='defaultAliases[0].isMiddleNameRequired']"));
    }
    public WebElement AppliedAll(){
        return getDriver().findElement(By.xpath("//input[@name='appliedToAll']"));
    }
    public WebElement AppliedPayout(){
        return getDriver().findElement(By.xpath("//input[@value='DOMESTIC_KPX_PAYOUT']"));
    }
    public WebElement AppliedSendout(){
        return getDriver().findElement(By.xpath("//input[@value='DOMESTIC_KPX_SENDOUT']"));
    }
    public WebElement AppliedQCL(){
        return getDriver().findElement(By.xpath("//input[@value='QCL']"));
    }
    public WebElement IsActive(){
        return getDriver().findElement(By.xpath("//input[@value='1']"));
    }
    public WebElement RemarksWatch(){
        return getDriver().findElement(By.xpath("//textarea[@placeholder='Remarks']"));
    }
    public WebElement SaveWatchlist(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Save']"));
    }
    public WebElement Successful(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Success')]"));
    }
    public WebElement SaveOK(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='OK']"));
    }
    public WebElement OK(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='OK']"));
    }
    public WebElement EditWatchlist(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Edit']"));
    }
    public WebElement AddAlias(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Add Alias']"));
    }
    public WebElement SaveAlias(){
        return getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[2]"));
    }
    public WebElement MobileNum(){
        return getDriver().findElement(By.xpath("//input[@placeholder='09XX-XXX-YYYY']"));
    }
    public WebElement CompanyName(){
        return getDriver().findElement(By.xpath("//input[@name='companyName']"));
    }
    public WebElement AliasCompanyName(){
        return getDriver().findElement(By.xpath("//input[@name='defaultAliases[0].companyName']"));
    }
    public WebElement Compliance(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'For Compliance Assistance')]"));
    }
    public WebElement lastNameW() {
        return getDriver().findElement(By.xpath("//*[@name='lastName']"));
    }
    public WebElement firstNameW() {
        return getDriver().findElement(By.xpath("//*[@name='firstName']"));
    }
    public WebElement middleNameW() {
        return getDriver().findElement(By.cssSelector("[name=\"middleName\"]"));
    }
    public WebElement SearchWatchlist(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Search']"));
    }
    public WebElement ClearInputs(){
        return getDriver().findElement(By.xpath("//button[@class='btn-sm btn btn-secondary']"));
    }
    public WebElement ViewWatchL(){
        return getDriver().findElement(By.xpath("//a[.='View >']"));
    }
    public WebElement BackWatchlist(){
        return getDriver().findElement(By.xpath("//div[@class='breadcrumb']/a[.='Watchlist']"));
    }
    public WebElement RequiredLname(){
        return getDriver().findElement(By.xpath("//small[@class='text-danger']"));
    }
    public WebElement RequiredFname(){
        return getDriver().findElement(By.xpath("//small[@class='text-danger']"));
    }
    public WebElement RequiredMobile(){
        return getDriver().findElement(By.xpath("//small[@class='text-danger']"));
    }
    public WebElement RequiredCompany(){
        return getDriver().findElement(By.xpath("//small[@class='text-danger']"));
    }
    public WebElement RequiredLnamed(){
        return getDriver().findElement(By.xpath("//small[.='Last name is required.']"));
    }
    public WebElement RequiredFnamed(){
        return getDriver().findElement(By.xpath("//small[.='First name is required.']"));
    }
    public WebElement RequiredApplied(){
        return getDriver().findElement(By.xpath("//small[@class='text-danger']"));
    }
    public WebElement RequiredRem(){
        return getDriver().findElement(By.xpath("//small[.='Remarks is required.']"));
    }
    public WebElement AlreadyExist(){
        return getDriver().findElement(By.xpath("//h5[@class='sc-aXZVg FiXoI']"));
    }




    public WebElement Threshold(){
        return getDriver().findElement(By.xpath("//a[.='Threshold']"));
    }
    public WebElement StringConversion(){
        return getDriver().findElement(By.xpath("//a[.='String Conversion']"));
    }
    public WebElement StringOmission(){
        return getDriver().findElement(By.xpath("//a[.='String Omission']"));
    }
    public WebElement AddRowThreshold(){
        return getDriver().findElement(By.xpath("//div[@class='d-flex flex-column mt-2 col-md-10']/button[@class='font-weight-bold btn btn-link btn-sm']"));
    }
    public WebElement AddRowString(){
        return getDriver().findElement(By.xpath("//div[@class='tab-pane active']//button[@class='font-weight-bold btn btn-link btn-sm']"));
    }
    public WebElement SelectString(){
        return getDriver().findElement(By.xpath("(//div[@class=' css-1hwfws3'])[27]"));
    }
    public WebElement WatchlistAlias(){
        return getDriver().findElement(By.xpath("(//input[@type='number'])[15]"));
    }
    public WebElement OriginalString(){
        return getDriver().findElement(By.xpath("(//input[@name='originalString'])[53]"));
    }
    public WebElement OriginalString1(){
        return getDriver().findElement(By.xpath("(//input[@name='originalString'])[79]"));
    }
    public WebElement NewString(){
        return getDriver().findElement(By.xpath("(//input[@name='newString'])[53]"));
    }
    public WebElement String(){
        return getDriver().findElement(By.xpath("//div[@class=' css-1uccc91-singleValue']"));
    }
    public WebElement MatchedWords(){
        return getDriver().findElement(By.xpath("(//input[@type='number'])[16]"));
    }
    public WebElement SaveChangess(){
        return getDriver().findElement(By.xpath("//div[@class='text-right mt-4 col-md-10']//span[.='Save Changes']"));
    }
    public WebElement Cancel1(){
        return getDriver().findElement(By.xpath("(//button[normalize-space()='Cancel'])[1]"));
    }
    public WebElement NoKeepIt(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='No, keep it']"));
    }
    public WebElement YesCancelIt(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Yes, cancel it!']"));
    }
    public WebElement SaveChangess2(){
        return getDriver().findElement(By.xpath("(//button[normalize-space()='Save Changes'])[2]"));
    }
    public WebElement SaveChangess3(){
        return getDriver().findElement(By.xpath("(//button[normalize-space()='Save Changes'])[3]"));
    }
    public WebElement ThresholdConfigurationsSaved(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Threshold Configurations Saved!')]"));
    }
    public WebElement DuplicateRowsDetected(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Duplicate Rows Detected')]"));
    }
    public WebElement FailedToSaveWatchlist(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Failed to save watchlist configurations')]"));
    }
    public WebElement AreYouSure(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Are you sure?')]"));
    }
    public WebElement UnsavedChanges(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Unsaved Changes')]"));
    }
    public WebElement StringConfigurationsSaved(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'String Configurations Saved!')]"));
    }
    public WebElement Delete(){
        return getDriver().findElement(By.xpath("(//button[@aria-label='Remove'])[8]"));
    }
    public WebElement Delete1(){
        return getDriver().findElement(By.xpath("(//button[@aria-label='Remove'])[60]"));
    }
    public WebElement Delete2(){
        return getDriver().findElement(By.xpath("(//button[@aria-label='Remove'])[86]"));
    }
    public WebElement StayOnThisPage(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='No, Stay On This Page']"));
    }
    public WebElement YesLeavePage(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Yes, Leave the Page']"));
    }
    public WebElement SelectType(){
        return getDriver().findElement(By.xpath("//select[@name='transactionType']"));
    }
    public WebElement ANY(){
        return getDriver().findElement(By.xpath("//option[@value='ANY']"));
    }
    public WebElement KTPNPHolder(){
        return getDriver().findElement(By.xpath("//input[@placeholder='____ ___ ____ ___ ____']"));
    }
    public WebElement SearchBu(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Search']"));
    }
    public WebElement ClickRe(){
        return getDriver().findElement(By.xpath("//td[.='BLOCKED']"));
    }
    public WebElement ClickRe2(){
        return getDriver().findElement(By.xpath("//span[@status='EXPIRED']"));
    }
    public WebElement ViewAllColumns(){
        return getDriver().findElement(By.xpath("//label[@class='custom-control-label']"));
    }
    public WebElement DomesticTran(){
        return getDriver().findElement(By.xpath("//option[@value='DOMESTIC']"));
    }
    public WebElement RNPHolder(){
        return getDriver().findElement(By.xpath("//input[@placeholder='Request Number']"));
    }
    public WebElement PayoutType(){
        return getDriver().findElement(By.xpath("//select[@name='domesticTransactionType']"));
    }
    public WebElement PayoutTran(){
        return getDriver().findElement(By.xpath("//option[@value='PAYOUT']"));
    }
    public WebElement PartnerSendout(){
        return getDriver().findElement(By.xpath("//option[@value='PARTNER']"));
    }
    public WebElement PartnerPayout(){
        return getDriver().findElement(By.xpath("//option[@value='PARTNER_PAYOUT']"));
    }
    public WebElement QCLTran(){
        return getDriver().findElement(By.xpath("//option[@value='QCL']"));
    }
    public WebElement Errors(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'Error')]"));
    }
    public WebElement NoResults(){
        return getDriver().findElement(By.xpath("//h5[contains(text(),'No Results Found')]"));
    }
    public WebElement LnameCustomer(){
        return getDriver().findElement(By.xpath("//input[@name='lastName']"));
    }
    public WebElement LNameRequired(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'Last Name is required.')]"));
    }
    public WebElement FNameRequired(){
        return getDriver().findElement(By.xpath("//small[contains(text(),'First Name is required.')]"));
    }

}
