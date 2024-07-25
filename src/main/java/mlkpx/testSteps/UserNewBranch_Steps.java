package mlkpx.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class UserNewBranch_Steps extends Base_Steps{

    public boolean isInHomePageNewBranch(){
        waitSleep(10000);
        waitUntilLoadingGone(10000);
        if (isVisible(usersPageObjects.changePassText(), "change Pass Text")) {
            LoggingUtils.info("Successfully directed to the Homepage New Branch User");
            return true;
        } else {
            LoggingUtils.error("Failed directed to the Homepage New Branch User");
            ExtentReporter.logFail("!isInHomePage", "Failed directed to the Homepage New Branch User");
            return false;
        }
    }

    public void U_TC_04()throws Exception{
        waitSleep(3000);
        click(usersPageObjects.okButton(), "OK Button");
        if(isVisible(usersPageObjects.changePassText(), getText(usersPageObjects.changePassText()))){
            ExtentReporter.logPass("U_TC_04", "Successfully Navigate to the Add Branch Users");
        }else{
            ExtentReporter.logFail("U_TC_04", "Fail to Navigate to the Add Branch Users");
            Assert.fail("Fail to Navigate to the Add Branch Users");
        }
    }
}
