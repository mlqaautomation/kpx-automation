package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class WS_CashInToOwnAccount_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "Validate Cash In to Own Account")
    public void CIOA_TC_01() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsCashInToOwnAccountSteps.CIOA_TC_01();
        }
    }
//    @Test(dependsOnMethods = "loginGoogle" , priority = 5, description = "Cash In to Own Account using scan QR Code")
//    public void CIOA_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()) {
//            this.wsCashInToOwnAccountSteps.CIOA_TC_02();
//
//        }
//
//    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 9, description = "Verify receipt")
    public void CIOA_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.wsCashInToOwnAccountSteps.CIOA_TC_03();

        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Validate invalid reference number")
    public void CIOA_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.wsCashInToOwnAccountSteps.CIOA_TC_04();

        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "Validate invalid mobile number")
    public void CIOA_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.wsCashInToOwnAccountSteps.CIOA_TC_05();

        }

    }
//    @Test(dependsOnMethods = "loginGoogle" , priority = 4, description = "Validate invalid QR Code")
//    public void CIOA_TC_06()throws Exception{
//        if(this.homeSteps.isInHomePage()) {
//            this.wsCashInToOwnAccountSteps.CIOA_TC_06();
//
//        }
//
//    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 6, description = "Validate already claimed transaction")
    public void CIOA_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.wsCashInToOwnAccountSteps.CIOA_TC_07();

        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 7, description = "Validate validate expired transaction")
    public void CIOA_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.wsCashInToOwnAccountSteps.CIOA_TC_08();

        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 8, description = "Validate the tender amount is less than the total amount")
    public void CIOA_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.wsCashInToOwnAccountSteps.CIOA_TC_09();

        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Validate again the cash in transaction if its being proccessed or not")
    public void CIOA_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.wsCashInToOwnAccountSteps.CIOA_TC_10();

        }

    }
}
