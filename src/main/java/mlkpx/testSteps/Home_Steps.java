package mlkpx.testSteps;

import org.testng.Assert;
import org.testng.asserts.Assertion;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;


public class Home_Steps extends Base_Steps {
    public boolean isInHomePage(){
        waitSleep(5000);
        if (isVisible(homePageObjects.searchField(), "Search Field")) {
            LoggingUtils.info("Successfully directed to the Homepage");
            return true;
        } else {
            LoggingUtils.error("Failed directed to the Homepage");
            ExtentReporter.logFail("!isInHomePage", "Failed directed to the Homepage ");
            return false;
        }
    }
}

