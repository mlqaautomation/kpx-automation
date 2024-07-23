package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class UserNewBranch_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx new branch user")
    public void newBranch() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.newBranchUser();
        if(this.userNewBranchSteps.isInHomePageNewBranch()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "newBranch", priority = 1, description = "To verify That The New Branch User Can Login Successfully")
    public void verifyThatTheNewBranchUserCanLoginSuccessfully()throws Exception{
        if(this.userNewBranchSteps.isInHomePageNewBranch()){
            this.userNewBranchSteps.U_TC_04();

        }

    }
}
