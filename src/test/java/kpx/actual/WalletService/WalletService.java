package kpx.actual.WalletService;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

import static org.testng.Assert.assertTrue;
import static utilities.Driver.AppiumDriverManager.APP_ID;
import static utilities.Driver.AppiumDriverManager.getAndroidDriver;

public class WalletService extends BaseTest {
    @Test(description = "Test to verify app is installed")
    public void isAppInstalledTest(){
        assertTrue(getAndroidDriver().isAppInstalled(APP_ID));
        ExtentReporter.logPass("isAppInstalledTest", "MLWALLET is installed");
    }
    @Test(dependsOnMethods="isAppInstalledTest" ,description = "Test to verify Login")

    public void loginTest(){
        loginWalletSteps.loginWallet();
    }

    @Test(dependsOnMethods="loginTest" ,description = "Test to get cash in KPTN")
    public void cashIn(){
        cashInSteps.cashIn();
    }

    @Test(dependsOnMethods="loginTest", priority = 2 ,description = "Test to get KwartaPadala KPTN")
    public void kwartaPadala(){
        kwartaPadala.kwartaPadala();
    }
    @Test(dependsOnMethods="loginTest", priority = 3 ,description = "Test to get CashOut KPTN")
    public void cashOut(){
        cashOut.cashOut();
    }

}

