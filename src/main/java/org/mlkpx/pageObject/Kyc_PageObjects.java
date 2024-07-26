package org.mlkpx.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.Driver.DriverManager.getDriver;

public class Kyc_PageObjects {
    public WebElement kyc_link(){
        return getDriver().findElement(By.cssSelector("[href='/kyc']"));
    }
    public WebElement kycPage_h2(){
        return getDriver().findElement(By.xpath("//h2"));
    }
    public WebElement addKycPage(){
        return getDriver().findElement(By.xpath("//h2[contains(text(), 'Add KYC')]"));
    }
    public WebElement viewKycPage(){
        return getDriver().findElement(By.xpath("//h2[contains(text(), 'View KYC')]"));
    }
    public WebElement kycPage_h4(){
        return getDriver().findElement(By.xpath("//h4"));
    }
    public WebElement lastName_field(){
        return getDriver().findElement(By.name("lastName"));
    }
    public WebElement firstName_field(){
        return getDriver().findElement(By.name("firstName"));
    }
    public WebElement middleName_field(){
        return getDriver().findElement(By.name("middleName"));
    }
    public WebElement suffix_field(){
        return getDriver().findElement(By.name("suffix"));
    }
    public WebElement searchBtn(){
        return getDriver().findElement(By.cssSelector("[type='submit']"));
    }


    public List<WebElement> buttonList(){
        return getDriver().findElements(By.cssSelector("[type='button']"));
    }
    public WebElement lastName_required(){return getDriver().findElement(By.xpath("//*[contains(text(), 'Last name is required.')]"));}
    public WebElement firstName_required(){return getDriver().findElement(By.xpath("//*[contains(text(), 'First name is required.')]"));}
    public WebElement birthDate(){
        return getDriver().findElement(By.xpath("//input[@placeholder='Birth Date']"));
    }
    public WebElement lastName_max60(){return getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div/div[1]/div/small"));}
    public WebElement firstName_max60(){return getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div/div[2]/div/small"));}
    public WebElement middleName_max60(){return getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div/div[3]/div/small"));}
    public WebElement birthdate_field(){return getDriver().findElement(By.cssSelector("[placeholder='Birth Date']"));}
    public WebElement ExpiryDate_field(){return getDriver().findElement(By.cssSelector("[placeholder='Expiry Date']"));}
    public WebElement searchOtherDevice(){return getDriver().findElement(By.xpath("//button[normalize-space()='Search in Other Systems']"));
    }
    public WebElement ViewButtonKYC(){return getDriver().findElement(By.xpath("//button[normalize-space()='View']"));
    }
    public WebElement EditKYC(){return getDriver().findElement(By.xpath("//button[normalize-space()='Edit KYC']"));
    }
    public WebElement GetScoreKYC(){return getDriver().findElement(By.xpath("//button[normalize-space()='Get Score']"));
    }
    public WebElement GetScoreDetailsKYC(){return getDriver().findElement(By.xpath("//button[normalize-space()='Get Score Details']"));
    }
    public WebElement GetPDFPrintKYC(){return getDriver().findElement(By.xpath("//button[normalize-space()='Print PDF']"));
    }
    public WebElement searchInOtherSystemButton() {
        return getDriver().findElement(By.cssSelector("[class='btn btn-primary']"));
    }
    public WebElement AddLName(){return getDriver().findElement(By.xpath("//input[@placeholder='Last Name']"));}
    public WebElement AddFName(){return getDriver().findElement(By.xpath("//input[@placeholder='First Name']"));}
    public WebElement AddMName(){return getDriver().findElement(By.xpath("//input[@placeholder='Middle Name']"));}
    public WebElement Checkbox(){return getDriver().findElement(By.xpath("//input[@name='hasNoMiddleName']"));}
    public WebElement AddBirthPlace(){return getDriver().findElement(By.xpath("//input[@placeholder='Place of Birth']"));}
    public WebElement AddSuffix(){return getDriver().findElement(By.xpath("//option[@value='JR']"));}
    public WebElement SelectNational(){return getDriver().findElement(By.xpath("//option[@value='FILIPINO']"));}
    public WebElement SelectEmptyNational(){return getDriver().findElement(By.xpath("//select[@placeholder='Nationality']"));}
    public WebElement SelectCivilStatus(){return getDriver().findElement(By.xpath("//option[@value='single']"));}
    public WebElement SelectEmptyCivilStatus(){return getDriver().findElement(By.xpath("//select[@placeholder='Civil Status']"));}
    public WebElement SelectGender(){return getDriver().findElement(By.xpath("//option[@value='male']"));}
    public WebElement SelectEmptyGender(){return getDriver().findElement(By.xpath("//select[@placeholder='Gender at Birth']"));}
    public WebElement SelectCountry(){return getDriver().findElement(By.xpath("//option[@value='PHILIPPINES']"));}
    public WebElement ContactInfo(){return getDriver().findElement(By.xpath("//h5[contains(text(),'Contact Information')]"));}
    public WebElement MobileField(){return getDriver().findElement(By.xpath("//input[@name='cellphoneNumber']"));}
    public WebElement MobileCheckout(){return getDriver().findElement(By.cssSelector("[name='hasNoMobileNumber']"));}
    public WebElement TelephoneField(){return getDriver().findElement(By.xpath("//input[@name='telephoneNumber']"));}
    public WebElement EmailField(){return getDriver().findElement(By.xpath("//input[@name='email']"));}

    public WebElement CAddressInfo(){return getDriver().findElement(By.xpath("//h6[contains(text(),'Current Address')]"));}
    public WebElement SelectProvince(){return getDriver().findElement(By.xpath("(//option[contains(text(),'ABRA') and @value='1'])[1]"));}
    public WebElement SelectEmptyProvince(){return getDriver().findElement(By.xpath("(//option[contains(text(),'Select Province')])[1]"));}
    public WebElement SelectMunicipality(){return getDriver().findElement(By.xpath("//option[contains(text(),'BOLINEY') and @value='323']"));}
    public WebElement SelectEmptyMunicipality(){return getDriver().findElement(By.xpath("(//option[contains(text(),'Select City')])[1]"));}
    public WebElement HouseStreetInfo(){return getDriver().findElement(By.xpath("(//input[@placeholder='HOUSE NO, STREET / SITIO / BARANGAY'])[1]"));}


    public WebElement PAddressInfo(){return getDriver().findElement(By.xpath("//h6[contains(text(),'Permanent Address')]"));}
    public WebElement PSelectProvince(){return getDriver().findElement(By.xpath("(//option[contains(text(),'AGUSAN DEL NORTE') and @value='2'])[2]"));}
    public WebElement PSelectEmptyProvince(){return getDriver().findElement(By.xpath("(//option[contains(text(),'Select Province')])[2]"));}

    public WebElement PSelectMunicipality(){return getDriver().findElement(By.xpath("//option[contains(text(),'BUENAVISTA') and @value='589']"));}
    public WebElement PSelectEmptyMunicipality(){return getDriver().findElement(By.xpath("(//option[contains(text(),'Select City')])[2]"));}

    public WebElement PHouseStreetInfo(){return getDriver().findElement(By.xpath("(//input[@placeholder='HOUSE NO, STREET / SITIO / BARANGAY'])[2]"));}
    public WebElement SameCurrentAddress(){return getDriver().findElement(By.xpath("//input[@placeholder='House No, Street']"));}

    public WebElement WorkNature(){return getDriver().findElement(By.xpath("//h5[contains(text(),'Nature of Work')]"));}
    public WebElement SourceIncome(){return getDriver().findElement(By.xpath("//select[@placeholder='Source of Income']"));}
    public WebElement SalaryPayIncome(){return getDriver().findElement(By.xpath("//option[@value='SALARY/PAY/WAGE/COMMISSION']"));}

    public WebElement SelectEmptySourceIncome(){return getDriver().findElement(By.xpath("//option[contains(text(),'Select Source of Income')]"));}

    public WebElement CompanyName(){return getDriver().findElement(By.xpath("//input[@placeholder='Company/Employer Name']"));}
    public WebElement ProductOffered(){return getDriver().findElement(By.xpath("//option[@value='INFORMATION TECHNOLOGY']"));}
    public WebElement EmptyProductOffered(){return getDriver().findElement(By.xpath("//option[contains(text(),'Select Offering')]"));}

    public WebElement WorkAddress(){return getDriver().findElement(By.xpath("//input[@placeholder='Work Address']"));}
    public WebElement PositionAtWork(){return getDriver().findElement(By.xpath("//option[@value='ENGINEER/SPECIALIST/TECHNICIAN']"));}
    public WebElement EmptyPositionAtWork(){return getDriver().findElement(By.xpath("//option[contains(text(),'Select Work Position')]"));}
    public WebElement NatureOfWork(){return getDriver().findElement(By.xpath("//option[@value='BPO AGENT/OFFICER']"));}
    public WebElement EmptyNatureOfWork(){return getDriver().findElement(By.xpath("//option[contains(text(),'Select Nature of Work')]"));}

    public WebElement BusinessSelfEmployIncome(){return getDriver().findElement(By.xpath("//option[@value='BUSINESS INCOME/SELF EMPLOYMENT']"));}
    public WebElement BusinessCompanyName(){return getDriver().findElement(By.xpath("//input[@placeholder='Business/Company Name']"));}
    public WebElement BusinessProductOffered(){return getDriver().findElement(By.xpath("//option[@value='WELLNESS AND PERSONAL GROOMING']"));}
    public WebElement EmptyBusinessProductOffered(){return getDriver().findElement(By.xpath("//option[contains(text(),'Select Offering')]"));}
    public WebElement BusinessWorkAddress(){return getDriver().findElement(By.xpath("//input[@placeholder='Work Address']"));}
    public WebElement BusinessPositionAtWork(){return getDriver().findElement(By.xpath("//option[@value='SUPERVISOR/MANAGER']"));}
    public WebElement BusinessNatureOfWork(){return getDriver().findElement(By.xpath("//option[@value='BEAUTY/WELLNESS SPECIALIST']"));}
    public WebElement EmptyBusinessPositionAtWork(){return getDriver().findElement(By.xpath("//option[contains(text(),'Select Work Position')]"));}
    public WebElement EmptyBusinessNatureOfWork(){return getDriver().findElement(By.xpath("//option[contains(text(),'Select Nature of Work')]"));}

    public WebElement EmptyOccupation(){return getDriver().findElement(By.xpath("//option[contains(text(),'Select Occupation')]"));}

    public WebElement PensionEmployIncome(){return getDriver().findElement(By.xpath("//option[@value='PENSION FOR RETIREE']"));}
    public WebElement ReceivingPensionFrom(){return getDriver().findElement(By.xpath("//option[@value='SSS']"));}
    public WebElement EmptyReceivingPensionFrom(){return getDriver().findElement(By.xpath("//option[contains(text(),'Select Receiving Pension From')]"));}
    public WebElement YearRetired(){return getDriver().findElement(By.xpath("//input[@placeholder='Year Retired']"));}
    public WebElement PositionUponRetirement(){return getDriver().findElement(By.xpath("//option[@value='SECRETARY/ASSISTANT']"));}

    public WebElement FinancialAssistEmployIncome(){return getDriver().findElement(By.xpath("//option[@value='FINANCIAL ASSISTANCE FROM RELATIVES']"));}
    public WebElement InputRemarks(){return getDriver().findElement(By.xpath("//input[@placeholder='Remarks']"));}

    public WebElement StudentScholarIncome(){return getDriver().findElement(By.xpath("//option[@value='STUDENT SCHOLARSHIP ALLOWANCE']"));}
    public WebElement InputSchool(){return getDriver().findElement(By.xpath("//input[@placeholder='School/University']"));}
    public WebElement InputSchoolAdd(){return getDriver().findElement(By.xpath("//input[@placeholder='School Address']"));}
    public WebElement SchoolRemarks(){return getDriver().findElement(By.xpath("//input[@placeholder='Remarks']"));}

    public WebElement RemittanceIncome(){return getDriver().findElement(By.xpath("//option[@value='REGULAR REMITTANCE ABROAD']"));}
    public WebElement RemittanceRemarks(){return getDriver().findElement(By.xpath("//input[@placeholder='Remarks']"));}

    public WebElement GovernmentIncome(){return getDriver().findElement(By.xpath("//option[@value='GOVERNMENT AID/ASSISTANCE/GRANT']"));}
    public WebElement ProgramType(){return getDriver().findElement(By.xpath("//input[@placeholder='e.g. DOLE; SSS']"));}

    public WebElement OtherIncome(){return getDriver().findElement(By.xpath("//option[@value='OTHER SOURCE OF INCOME']"));}
    public WebElement OtherIncomeOccupation(){return getDriver().findElement(By.xpath("//option[@value='HOUSEWIFE/STAY-HOME-SPOUSE']"));}
    public WebElement EmptyOtherIncomeOccupation(){return getDriver().findElement(By.xpath("//option[@value='HOUSEWIFE/STAY-HOME-SPOUSE']"));}
    public WebElement SourceOfFund(){return getDriver().findElement(By.xpath("//input[@placeholder='NONE, SOF  ___']"));}

    public WebElement Identification(){return getDriver().findElement(By.xpath("//h5[contains(text(),'ID')]"));}
    public WebElement IDType(){return getDriver().findElement(By.xpath("(//option[@value='5'])[5]"));}
    public WebElement IDNumber(){return getDriver().findElement(By.xpath("(//input[@placeholder='ID No'])[1]"));}
    public WebElement OtherDetails(){return getDriver().findElement(By.xpath("(//input[@placeholder='Other Details'])[1]"));}

    public WebElement EmptyIDType(){return getDriver().findElement(By.xpath("(//option[contains(text(),'Select ID')])[1]"));}

    public WebElement IDTypeGSIS(){return getDriver().findElement(By.xpath("(//option[@value='20'])[5]"));}
    public WebElement IDTypeOther(){return getDriver().findElement(By.xpath("(//option[@value='27'])[5]"));}

    public WebElement FrontID(){return getDriver().findElement(By.xpath("(//label[contains(text(),'ID')])[6]"));}
    public WebElement WatchlStat(){return getDriver().findElement(By.xpath("//h5[.='Watchlist Status']"));}
    public WebElement ID1Image(){return getDriver().findElement(By.xpath("//img[@alt='ID1']"));}
    public WebElement FCamera(){return getDriver().findElement(By.xpath("(//button[normalize-space()='Camera'])[1]"));}
    public WebElement FCapture(){return getDriver().findElement(By.xpath("//button[normalize-space()='Capture Photo']"));}
    public WebElement FSet(){return getDriver().findElement(By.xpath("//button[normalize-space()='Set Photo']"));}
    public WebElement CloseImage(){return getDriver().findElement(By.xpath("//button[@class='close']"));}
    public WebElement CancelSelectedImage(){return getDriver().findElement(By.xpath("(//button[normalize-space()='Cancel'])[1]"));}

    public WebElement BackID(){return getDriver().findElement(By.xpath("(//label[contains(text(),'ID')])[7]"));}
    public WebElement BCamera(){return getDriver().findElement(By.cssSelector("[type='button'][name='id2File']"));}
    public WebElement BCapture(){return getDriver().findElement(By.xpath("//button[normalize-space()='Capture Photo']"));}
    public WebElement BSet(){return getDriver().findElement(By.xpath("//button[normalize-space()='Set Photo']"));}

    public WebElement BackID2(){return getDriver().findElement(By.xpath("(//label[contains(text(),'ID')])[8]"));}
    public WebElement BCamera2(){return getDriver().findElement(By.cssSelector("[type='button'][name='id3FileFront']"));}
    public WebElement BCapture2(){return getDriver().findElement(By.xpath("//button[normalize-space()='Capture Photo']"));}
    public WebElement BSet2(){return getDriver().findElement(By.xpath("//button[normalize-space()='Set Photo']"));}


    public WebElement CustomerPhoto(){return getDriver().findElement(By.xpath("(//label[@class='subheading'])[4]"));}
    public WebElement CustomerImage(){return getDriver().findElement(By.xpath("(//img[@width='300'])[4]"));}
    public WebElement CCamera(){return getDriver().findElement(By.cssSelector("[name='customerPhoto']"));}
    public WebElement CCapture(){return getDriver().findElement(By.xpath("//button[normalize-space()='Capture Photo']"));}
    public WebElement CSet(){return getDriver().findElement(By.xpath("//button[normalize-space()='Set Photo']"));}


    public WebElement KYCTopPhoto(){return getDriver().findElement(By.xpath("(//label[@class='subheading'])[5]"));}
    public WebElement KYCTOPImage(){return getDriver().findElement(By.xpath("//img[@alt='KYC TOP']"));}
    public WebElement KYCTCamera(){return getDriver().findElement(By.cssSelector("[type='button'][name='kycTop']"));}
    public WebElement KYCTCapture(){return getDriver().findElement(By.xpath("//button[normalize-space()='Capture Photo']"));}
    public WebElement KYCTSet(){return getDriver().findElement(By.xpath("//button[normalize-space()='Set Photo']"));}

    public WebElement KYCBPhoto(){return getDriver().findElement(By.xpath("(//label[@class='subheading'])[6]"));}
    public WebElement KYCBUTTOMImage(){return getDriver().findElement(By.xpath("//img[@alt='KYC BOTTOM']"));}
    public WebElement KYCBCamera(){return getDriver().findElement(By.cssSelector("[type='button'][name='kycBottom']"));}
    public WebElement KYCBCapture(){return getDriver().findElement(By.xpath("//button[normalize-space()='Capture Photo']"));}
    public WebElement KYCBSet(){return getDriver().findElement(By.xpath("//button[normalize-space()='Set Photo']"));}


    public WebElement ActiveStatus(){return getDriver().findElement(By.xpath("//label[contains(text(),'Is Customer Active?')]"));}
    public WebElement KYCEdit(){return getDriver().findElement(By.xpath("(//button[@class='btn-sm btn btn-secondary'])[4]"));}
    public WebElement YesActive(){return getDriver().findElement(By.xpath("(//input[@value='1'])[3]"));}
    public WebElement KYCDone(){return getDriver().findElement(By.xpath("//button[normalize-space()='Done']"));}
    public WebElement SaveNewKYC(){return getDriver().findElement(By.xpath("//button[normalize-space()='Save New KYC']"));}

    public WebElement SaveChanges(){return getDriver().findElement(By.xpath("//button[normalize-space()='Save Changes']"));}
    public WebElement CancelNewKYC(){return getDriver().findElement(By.xpath("(//button[normalize-space()='Cancel'])[7]"));}
    public WebElement LeaveNewKYC(){return getDriver().findElement(By.xpath("//button[normalize-space()='Leave']"));}
    public WebElement StayNewKYC(){return getDriver().findElement(By.xpath("//button[normalize-space()='Stay']"));}
    public WebElement OKButton(){return getDriver().findElement(By.xpath("//button[normalize-space()='OK']"));}
    public WebElement BackToSearchButton(){return getDriver().findElement(By.xpath("//button[normalize-space()='Back to Search']"));}
    public WebElement CloseButton(){return getDriver().findElement(By.xpath("//button[normalize-space()='Close']"));}

    public WebElement MnameRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Middle Name is required.')]"));
    }
    public WebElement Mname60maxCharacter(){return getDriver().findElement(By.xpath("//small[contains(text(),'Maximum of 60 characters.')]"));
    }
    public WebElement BirthPlaceRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Place of Birth is required.')]"));
    }
    public WebElement NationalityRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Nationality is required.')]"));
    }
    public WebElement CivilStaRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Civil Status is required.')]"));
    }
    public WebElement GenderRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Gender at Birth is required.')]"));
    }
    public WebElement MobileNumRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Mobile No. is required.')]"));
    }
    public WebElement ValidTeleRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Please enter a valid telephone number')]"));
    }
    public WebElement InvalidEmail(){return getDriver().findElement(By.xpath("//small[contains(text(),'Invalid email format.')]"));
    }
    public WebElement Max45CharEmail(){return getDriver().findElement(By.xpath("//small[contains(text(),'Maximum of 45 characters.')]"));
    }
    public WebElement ProvinceRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Province is required.')]"));
    }
    public WebElement CityRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'City is required.')]"));
    }
    public WebElement Address200Char(){return getDriver().findElement(By.xpath("//small[contains(text(),'Maximum of 200 characters.')]"));
    }
//    public WebElement OnlyLetterAllowed(){return getDriver().findElement(By.xpath("//small[contains(text(),'Only letters A-Z and numbers 0-9 are allowed.')]"));
//    }

    public WebElement SourceIncomeRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Source of Income is required.')]"));
    }
    public WebElement CompanyInputRequired(){return getDriver().findElement(By.xpath("(//small[contains(text(),'Input is required.')])[1]"));
    }
    public WebElement Max100CharWork(){return getDriver().findElement(By.xpath("//small[contains(text(),'Maximum of 100 characters.')]"));
    }
    public WebElement IDNoWrong(){return getDriver().findElement(By.xpath("//small[contains(text(),'Please input (PID + max 16 digits)')]"));
    }
    public WebElement ExpDateRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Expiry Date is required.')]"));
    }
    public WebElement ExpDateAlready(){return getDriver().findElement(By.xpath("//small[contains(text(),'Id is already expired.')]"));
    }
    public WebElement IDTypeRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'ID Type is required.')]"));
    }
    public WebElement IDGSISWrong(){return getDriver().findElement(By.xpath("//small[contains(text(),'Please input (GSIS + max 11 digits)')]"));
    }
    public WebElement ID1Required(){return getDriver().findElement(By.xpath("//small[contains(text(),'ID 1 Photo is required.')]"));
    }
    public WebElement CustomerPhotoRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'Customer's Photo is required.')]"));
    }
    public WebElement KYCTOPRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'KYC Top Photo is required.')]"));
    }
    public WebElement KYCBRequired(){return getDriver().findElement(By.xpath("//small[contains(text(),'KYC Bottom Photo is required.')]"));
    }

    public WebElement BranchRemarks(){
        return getDriver().findElement(By.xpath("//h5[contains(text(), 'Branch Remarks')]"));
    }
    public WebElement BranchRemarksButton(){return getDriver().findElement(By.xpath("//button[normalize-space()='Edit']"));
    }
    public WebElement BranchRemarksDone(){return getDriver().findElement(By.xpath("//button[normalize-space()='Done']"));
    }
    public WebElement TypeBranchRemarks(){return getDriver().findElement(By.xpath("(//textarea[@placeholder='REMARKS'])[3]"));}

    public WebElement UserAlreadyExist(){return getDriver().findElement(By.xpath("//h5[contains(text(), 'KYC Already Exists in KPX')]"));
    }
    public WebElement UserEditUpdated(){return getDriver().findElement(By.xpath("//h5[contains(text(), 'Successfully updated KYC')]"));
    }
    public WebElement UserSuccessfullyAdded(){return getDriver().findElement(By.xpath("//h5[contains(text(), 'Successfully added KYC')]"));
    }
    public WebElement UserEditExist(){return getDriver().findElement(By.xpath("//h5[contains(text(), 'KYC Already Exists in KPX')]"));
    }
    public WebElement KYCRecord(){return getDriver().findElement(By.xpath("//h5[contains(text(), 'KYC Record Generated')]"));
    }
    public WebElement UnsavedChanges(){return getDriver().findElement(By.xpath("//h5[contains(text(), 'Unsaved Changes')]"));
    }
}
