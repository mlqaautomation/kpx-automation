package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class RequestForChangePartner_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if (this.homeSteps.isInHomePage()) {
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }


    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Verify Navigation of Request for Change Page and can Request for Change Partner")
    public void requestForChangePartner()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_08();
            this.requestForChangePartnerSteps.RFCP_TC_01();
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Invalid KPTN Code")
    public void invalidKPTNCode()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.requestForChangePartnerSteps.RFCP_TC_02();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "Cancelled KPTN Code")
    public void cancelledKPTN()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.requestForChangePartnerSteps.RFCP_TC_03();
        }
    }
        }
