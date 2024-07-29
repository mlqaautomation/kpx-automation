package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class Watchlist_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("helpdesk");
        this.loginSteps.loginKpx("helpdesk");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // W  A  T  C  H  L  I  S  T
//    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To verify successful Add, Update and Add Alias Watchlist for Sendout and Payout using (General Information)")
//    public void Watchlist_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.watchlistSteps.navigateWatchlist();
//            this.watchlistSteps.WatchlistTC01();
//        }
//    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To verify successful Add, Update and Add Alias Watchlist for Sendout and Payout using (Mobile Number)")
    public void Watchlist_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC02();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To verify successful Add, Update and Add Alias Watchlist for Sendout and Payout using (Company Name)")
    public void Watchlist_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC03();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "Transact to Verify the Added Watchlist in Sendout Domestic Watchlist Using (General Information)")
    public void Watchlist_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC04();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "Transact to Verify the Added Watchlist in Sendout Domestic Watchlist Using (Mobile Number)")
    public void Watchlist_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC05();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "Transact to Verify the Added Watchlist in Sendout Domestic Watchlist Using (Company Name)")
    public void Watchlist_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC06();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "Transact to Verify the Added Watchlist in Payout Domestic Watchlist Using (General Information)")
    public void Watchlist_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC07();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "Transact to Verify the Added Watchlist in Payout Domestic Watchlist Using (Mobile Number)")
    public void Watchlist_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC08();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "Transact to Verify the Added Watchlist in Payout Domestic Watchlist Using (Mobile Number)")
    public void Watchlist_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC09();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To verify the Search Watchlist by General Information, Mobile Number, Company Name")
    public void Watchlist_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC10();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To verify successful Add Watchlist for QCL and Wallet Services using (Mobile Number)")
    public void Watchlist_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC11();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "Validate the Watchlist  Gen Info empty field, Mobile Num empty field and Company Name empty field")
    public void Watchlist_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC12();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "Validate the Watchlist  Gen Info clear field, Mobile Num clear field and Company Name clear field")
    public void Watchlist_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC13();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 14, description = "Validate the Watchlist Gen Info Invalid Input, Mobile Num Invalid Input and Company Name Invalid Input")
    public void Watchlist_TC_14()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC14();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 15, description = "Validate Add Watchlist using the Empty details General Information Empty details Mobile Number, Empty details Company Name")
    public void Watchlist_TC_15()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC15();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 16, description = "Validate Add Watchlist General Information that Already Exists ")
    public void Watchlist_TC_16()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC16();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 17, description = "Validate Add Watchlist Mobile Number that Already Exists ")
    public void Watchlist_TC_17()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC17();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 18, description = "Validate Add Watchlist Company Name that Already Exists ")
    public void Watchlist_TC_18()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.navigateWatchlist();
            this.watchlistSteps.WatchlistTC18();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 19, description = "Validate Sendout Partner in Moneygram that is watchlisted while transacting sendout ")
    public void Watchlist_TC_19()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.WatchlistTC19();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 20, description = "Validate Sendout Partner in Western Union that is watchlisted while transacting sendout ")
    public void Watchlist_TC_20()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.WatchlistTC20();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 21, description = "Validate Sendout and payout Partner in Western Union that is watchlisted while transacting in payout ")
    public void Watchlist_TC_21()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.watchlistSteps.WatchlistTC21();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 22, description = "Validate KYC watchlist Under Terrorist status")
    public void Watchlist_TC_22()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kycSteps.navigateKycPage();
            this.watchlistSteps.WatchlistTC22();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 23, description = "Validate KYC watchlist Not Exempted status")
    public void Watchlist_TC_23()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kycSteps.navigateKycPage();
            this.watchlistSteps.WatchlistTC23();
        }
    }

}
