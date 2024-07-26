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
    public boolean logout(){
        click(homePageObjects.logout(), "Logout Button");
        waitSleep(15000);
        if (isVisible(googlePageObjects.signInWithKPX(), "signIn with KPX")) {
            LoggingUtils.info("Successfully logout");
            return true;
        } else {
            LoggingUtils.error("Failed to logout");
            ExtentReporter.logFail("!isInLogout", "Failed to logout");
            return false;
        }
    }
    public boolean okButton(){
        click(usersPageObjects.okButton(), "OK Button");
        if (isVisible(homePageObjects.logout(), "Log Out Button")) {
            LoggingUtils.info("Success");
            return true;
        } else {
            LoggingUtils.error("Failed");
            ExtentReporter.logFail("!isInLogout", "Failed");
            return false;
        }

    }
}

