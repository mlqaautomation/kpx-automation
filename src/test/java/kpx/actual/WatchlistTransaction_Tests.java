package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class WatchlistTransaction_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("helpdesk");
        this.loginSteps.loginKpx("helpdesk");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
   //  W  A  T  C  H  L  I  S  T   T R A N S A C T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "Validate the Any Type of Watchlisted Transactions")
    public void WatchlistTransaction_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistTransactionSteps.navigateWatchlistTransaction();
            this.watchlistTransactionSteps.WatchlistTransactionTC01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "Validate the Domestic Transaction Type in Sendout of Watchlisted Transactions")
    public void WatchlistTransaction_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistTransactionSteps.navigateWatchlistTransaction();
            this.watchlistTransactionSteps.WatchlistTransactionTC02();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "Validate the Domestic Transaction Type in Payout of Watchlisted Transactions")
    public void WatchlistTransaction_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistTransactionSteps.navigateWatchlistTransaction();
            this.watchlistTransactionSteps.WatchlistTransactionTC03();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "Validate the Partners Transaction Type in Sendout of Watchlisted Transactions")
    public void WatchlistTransaction_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistTransactionSteps.navigateWatchlistTransaction();
            this.watchlistTransactionSteps.WatchlistTransactionTC04();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "Validate the Partners Transaction Type in Payout of Watchlisted Transactions")
    public void WatchlistTransaction_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistTransactionSteps.navigateWatchlistTransaction();
            this.watchlistTransactionSteps.WatchlistTransactionTC05();
        }
    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "Validate the QCLTransaction Type of Watchlisted Transactions")
//    public void WatchlistTransaction_TC_06()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.watchlistTransactionSteps.navigateWatchlistTransaction();
//            this.watchlistTransactionSteps.WatchlistTransactionTC05();
//        }
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "Validate Invalid Inputs in Any type of transaction and clear it")
    public void WatchlistTransaction_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistTransactionSteps.navigateWatchlistTransaction();
            this.watchlistTransactionSteps.WatchlistTransactionTC07();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "Validate Invalid KTPN Inputs in Domestic Transaction Sendout type and clear it")
    public void WatchlistTransaction_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistTransactionSteps.navigateWatchlistTransaction();
            this.watchlistTransactionSteps.WatchlistTransactionTC08();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "Validate Invalid KTPN Inputs in Domestic Transaction Payout type and clear it")
    public void WatchlistTransaction_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistTransactionSteps.navigateWatchlistTransaction();
            this.watchlistTransactionSteps.WatchlistTransactionTC09();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "Validate Invalid Request Inputs in Partner Transaction Sendout type and clear it")
    public void WatchlistTransaction_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistTransactionSteps.navigateWatchlistTransaction();
            this.watchlistTransactionSteps.WatchlistTransactionTC10();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "Validate Invalid KTPN Inputs in Partner Transaction Payout type and clear it")
    public void WatchlistTransaction_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistTransactionSteps.navigateWatchlistTransaction();
            this.watchlistTransactionSteps.WatchlistTransactionTC11();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "Validate Invalid Reference Num Inputs in QCL Transaction and clear it")
    public void WatchlistTransaction_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistTransactionSteps.navigateWatchlistTransaction();
            this.watchlistTransactionSteps.WatchlistTransactionTC12();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "Validate Invalid Reference Num Inputs in QCL Transaction and clear it")
    public void WatchlistTransaction_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistTransactionSteps.navigateWatchlistTransaction();
            this.watchlistTransactionSteps.WatchlistTransactionTC13();
        }
    }
}
