package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class Sendout_Partners_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Successful Western Union Partner Sendout Transaction")
    public void PartnerSendoutWesternUnion_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnersSteps.PS_TC_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Successful Western Union Partner Remote Sendout Transaction")
    public void PartnerSendoutWesternUnionRemote_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnersSteps.PS_TC_02();
        }
    }

}
