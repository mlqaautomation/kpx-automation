package kpx.actual;

import org.testng.annotations.Test;
import kpx.base.BaseTest;
import utilities.ExtentReport.ExtentReporter;

public class Kyc_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {

        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "Test to verify display of registered kyc records")
    public void KYC_TC_01_02() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.kycSteps.navigateKycPage();
            this.kycSteps.searchRegisteredKYC_Valid();
            ExtentReporter.logPass("KYC_TC_02", "Registered KYC records will display");
        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "Negative Testing for KYC Search")
    public void KYC_TC_03() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.kycSteps.navigateKycPage();
            this.kycSteps.searchRegisteredKYC_Invalid();
            this.kycSteps.searchRegisteredKYC_Invalid03();
            this.kycSteps.searchRegisteredKYC_Invalid04();
            this.kycSteps.searchRegisteredKYC_Invalid05();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "Test to ADD KYC Cancel After If stay or Leave")
    public void KYC_TC_04() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.AddNewKYC_ValidCancelAndLeave();

        }

    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To Verify Add KYC Name invalid inputs")
    public void KYC_TC_05() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.VerifyAddKYCInvalidInputs();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To Verify Add KYC Contact Information Inputs")
    public void KYC_TC_06() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.VerifyAddKYCContactInfo();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To Verify Add KYC Contact Information with Invalid Inputs")
    public void KYC_TC_07() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.VerifyAddKYCContactInvalidInfo();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To Verify Add KYC Address Inputs")
    public void KYC_TC_08() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.AddKYCAddressInputs();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To Verify Add KYC Invalid Address Inputs")
    public void KYC_TC_09() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.AddKYCAddressInvalidInputs();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To Verify Add KYC Nature of Work Inputs")
    public void KYC_TC_10() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.AddKYCNatureWOrkInputs();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To Verify Add KYC Nature of Work Invalid Inputs")
    public void KYC_TC_11() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.AddKYCNatureWOrkInvalidInputs();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To Verify Add KYC ID Inputs (Preferred and Non-Preferred)")
    public void KYC_TC_12() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.AddKYCIDInputs();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To Verify Add KYC ID Invalid Inputs (Preferred and Non-Preferred)")
    public void KYC_TC_13() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.AddKYCIDInvalidInputs();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 14, description = "To Verify Add KYC Customer Photos Camera")
    public void KYC_TC_14() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.AddKYCCustomerPhotos();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 15, description = "Add KYC Customer's Photo, KYC TOP, KYC BOTTOM")
    public void KYC_TC_15() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.AddKYCCustomerPhotosTOPBOTTOM();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 16, description = "To Validate Customer Photos Section")
    public void KYC_TC_16() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.ToVerifyCustomerPhotosSection();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 18, description = "To Validate Add KYC Branch Remarks Input")
    public void KYC_TC_18() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.ToVerifyBranchRemarks();

    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 19, description = "To Validate Save New KYC")
//    public void KYC_TC_19() throws Exception {
//        this.homeSteps.isInHomePage();
//        this.kycSteps.navigateKycPage();
//        this.kycSteps.AddNewKYC_ValidSave();
//
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 20, description = "To Verify Adding new KYC if user already exist (use newly created KYC)")
    public void KYC_TC_20() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.AddNewKYCAlreadyExistUser();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 21, description = "To Verify Edit Registered KYC")
    public void KYC_TC_21() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.EditRegisteredKYC();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 22, description = "To Verify Edit KYC with exisitng KYC")
    public void KYC_TC_22() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.EditExistingKYC();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 23, description = "View Existing KYC then Get Score")
    public void KYC_TC_23() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.ViewKYCGetScore();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 24, description = "View Existing KYC then Get Score Details")
    public void KYC_TC_24() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.ViewKYCGetScoreDetails();

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 25, description = "View Existing KYC then Print PDF")
    public void KYC_TC_25() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.ViewKYCPrintPDF();

    }


}







