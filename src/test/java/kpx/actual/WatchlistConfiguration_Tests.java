package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class WatchlistConfiguration_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("helpdesk");
        this.loginSteps.loginKpx("helpdesk");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
   //  W  A  T  C  H  L  I  S  T   C O N F I G U R A T I O N
//    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "Validate Watchlist Configuration to add Threshold Configurations")
//    public void WatchlistConfiguration_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.watchlistConfigurationSteps.navigateWatchlistConfiguration();
//            this.watchlistConfigurationSteps.WatchlistConfigurationTC01();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "Validate Watchlist Configuration to add String Configurations")
//    public void WatchlistConfiguration_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.watchlistConfigurationSteps.navigateWatchlistConfiguration();
//            this.watchlistConfigurationSteps.WatchlistConfigurationTC02();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "Validate Watchlist Configuration to add String Omission")
//    public void WatchlistConfiguration_TC_03()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.watchlistConfigurationSteps.navigateWatchlistConfiguration();
//            this.watchlistConfigurationSteps.WatchlistConfigurationTC03();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "Validate Watchlist Threshold Configurations in sendout that has meet (5 Watchlist/Alias (No. of words)) and (3 Matched Words ) ")
//    public void WatchlistConfiguration_TC_04()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.watchlistConfigurationSteps.WatchlistConfigurationTC04();
//        }
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "Validate Watchlist in payour that has meet the string conversion in watchlist config")
    public void WatchlistConfiguration_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistConfigurationSteps.WatchlistConfigurationTC05();
        }
    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "Validate Configuration Cancel the Changes")
//    public void WatchlistConfiguration_TC_06()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.watchlistConfigurationSteps.navigateWatchlistConfiguration();
//            this.watchlistConfigurationSteps.WatchlistConfigurationTC06();
//        }
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "Validate the Unsave Changes")
    public void WatchlistConfiguration_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistConfigurationSteps.navigateWatchlistConfiguration();
            this.watchlistConfigurationSteps.WatchlistConfigurationTC07();
        }
    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "Validate Duplicate Adding Threshold")
//    public void WatchlistConfiguration_TC_08()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.watchlistConfigurationSteps.navigateWatchlistConfiguration();
//            this.watchlistConfigurationSteps.WatchlistConfigurationTC08();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "Validate Duplicate String Conversion")
//    public void WatchlistConfiguration_TC_09()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.watchlistConfigurationSteps.navigateWatchlistConfiguration();
//            this.watchlistConfigurationSteps.WatchlistConfigurationTC09();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "Validate Duplicate String Ommission")
//    public void WatchlistConfiguration_TC_10()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.watchlistConfigurationSteps.navigateWatchlistConfiguration();
//            this.watchlistConfigurationSteps.WatchlistConfigurationTC10();
//        }
//    }
}
