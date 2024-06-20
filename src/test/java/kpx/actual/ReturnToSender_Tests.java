package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class ReturnToSender_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if (this.homeSteps.isInHomePage()) {
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }


    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Verify Navigation of Return To Sender Page")
    public void navigationofReturnToSenderPage()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendOutSteps.DS_TC_08();
            this.returnToSenderSteps.RTS_TC_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Verify Return to Sender with Non-existing KPTN\n")
    public void nonExistingKPTN()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.returnToSenderSteps.RTS_TC_02();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "Verify Return to Sender with cancelled KPTN")
    public void cancelledKPTN()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.returnToSenderSteps.RTS_TC_03();
        }
    }
}
