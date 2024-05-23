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
    public void KYC_TC_02() throws Exception {
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
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "Test to ADD KYC")
    public void KYC_TC_04() throws Exception {
        this.homeSteps.isInHomePage();
        this.kycSteps.navigateKycPage();
        this.kycSteps.AddNewKYC_Valid();
        this.kycSteps.AddNewKYC01();

        }
    }






