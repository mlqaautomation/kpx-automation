package mlkpx.testSteps;

import org.openqa.selenium.Keys;
import utilities.Logger.LoggingUtils;

import java.util.Collections;
import java.util.List;

public class WatchlistTransaction_Steps extends Base_Steps{
    //W  A  T  C  H  L  I  S  T   T R A N S A C T I O N
    public void navigateWatchlistTransaction()throws Exception{
        try{
            click(watchlistPageObjects.CustomerService(), "CustomerService");
            scrollToElement(watchlistPageObjects.WatchlistTransaction());
            click(watchlistPageObjects.WatchlistTransaction(), "Watchlist Transactions");
            waitSleep(5000);
            if(isVisible(watchlistPageObjects.WatchlistTransactionH2(), getText(watchlistPageObjects.WatchlistTransactionH2()))){
                LoggingUtils.info("Navigated to Watchlist Transactions");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Watchlist Transactions"+ e);
        }
    }
    public void WatchlistTransactionTC01() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.ANY(), "ANY");
        type(watchlistPageObjects.KTPNPHolder(), "KTPN: ","KPNTXFFBDOP");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        waitSleep(10000);
        LoggingUtils.info("The Record will display: DATE BLOCKED, REQUEST NUMBER, KPTN, NAME (SENDER/PAWNER), BRANCH, OPERATOR, STATUS and TRANSACTION TYPE");
        click(watchlistPageObjects.ClickRe(), "Click Record");
        waitSleep(10000);
        LoggingUtils.info("The Watchlist Transactions will display\n" +
                "KPTN: \"____\"\n" +
                "Request Number: \"____\"\n" +
                ", Payment Information and the transaction records below.\n");
        click(watchlistPageObjects.ViewAllColumns(), "View All Columns");
        waitSleep(5000);
    }
    public void WatchlistTransactionTC02() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.DomesticTran(), "Domestic Transaction");
        type(watchlistPageObjects.RNPHolder(), "Reference Number: ","RNPLLDQIRE");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        waitSleep(10000);
        LoggingUtils.info("The Record will display: KPTN, REQUEST NUMBER, DATE BLOCKED, SENDER, RECEIVER, BRANCH, OPERATOR PRINCIPAL, APPLIED TO and STATUS");
        click(watchlistPageObjects.ClickRe2(), "Click Record");
        waitSleep(10000);
        LoggingUtils.info("The Watchlist Transactions will display\n" +
                "Request Number: \"____\"\n" +
                ", Payment Information and the transaction records below.");
        click(watchlistPageObjects.ViewAllColumns(), "View All Columns");
        waitSleep(5000);
    }
    public void WatchlistTransactionTC03() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.DomesticTran(), "Domestic Transaction");
        click(watchlistPageObjects.PayoutType(), "Payout Type");
        click(watchlistPageObjects.PayoutTran(), "Payout transaction");
        type(watchlistPageObjects.KTPNPHolder(), "KTPN: ","KPNTXFFBDOP");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        waitSleep(10000);
        LoggingUtils.info("The Record will display: KPTN REQUEST NUMBER DATE BLOCKED SENDER RECEIVER RECEIVER KYC BRANCH OPERATOR PRINCIPAL APPLIED TO STATUS");
        click(watchlistPageObjects.ClickRe(), "Click Record");
        waitSleep(10000);
        LoggingUtils.info("The Watchlist Transactions will display\n" +
                "KPTN: \"____\"\n" +
                "Request Number: \"____\"\n" +
                ", Payment Information and the transaction records below.");
        click(watchlistPageObjects.ViewAllColumns(), "View All Columns");
        waitSleep(5000);
    }
    public void WatchlistTransactionTC04() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.PartnerSendout(), "Partner KYC Sendout Transaction");
        type(watchlistPageObjects.RNPHolder(), "Reference Number: ","RNHIZHPDZF");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        waitSleep(10000);
        LoggingUtils.info("The Record will display: REQUEST NUMBER        DATE BLOCKED        SENDER        BRANCH        OPERATOR        STATUS");
        click(watchlistPageObjects.ClickRe2(), "Click Record");
        waitSleep(10000);
        LoggingUtils.info("The Watchlist Transactions will display\n" +
                "Request Number: \"____\"\n" +
                ", Other Information and the transaction records below.");
        click(watchlistPageObjects.ViewAllColumns(), "View All Columns");
        waitSleep(5000);
    }
    public void WatchlistTransactionTC05() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.PartnerPayout(), "Partner Payout Transaction");
        type(watchlistPageObjects.KTPNPHolder(), "KTPN: ","6693079341");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        waitSleep(10000);
        LoggingUtils.info("The Record will display: KPTN        REF #        DATE BLOCKED        SENDER        RECEIVER        RECEIVER KYC        BRANCH        OPERATOR        PRINCIPAL        STATUS");
        click(watchlistPageObjects.ClickRe(), "Click Record");
        waitSleep(10000);
        LoggingUtils.info("The Watchlist Transactions will display\n" +
                "Request Number: \"____\"\n" +
                "REF #: \"____\"\n" +
                ", Payment Information and the transaction records below.");
        click(watchlistPageObjects.ViewAllColumns(), "View All Columns");
        waitSleep(5000);
    }
    public void WatchlistTransactionTC06() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.QCLTran(), "QCL Transaction");
        type(watchlistPageObjects.RNPHolder(), "Reference Number: ","00152 ");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        waitSleep(10000);
        LoggingUtils.info("The Record will display: REQUEST NUMBER        PTN        DATE BLOCKED        PAWNER        BRANCH        OPERATOR        PRINCIPAL        STATUS\n");
        click(watchlistPageObjects.ClickRe(), "Click Record");
        waitSleep(10000);
        LoggingUtils.info("The Watchlist Transactions will display\n" +
                "Request Number: \"____\"\n" +
                ", Payment Information and the transaction records below.");
        click(watchlistPageObjects.ViewAllColumns(), "View All Columns");
        waitSleep(5000);
    }
    public void WatchlistTransactionTC07() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.ANY(), "ANY");
        type(watchlistPageObjects.KTPNPHolder(), "KTPN: ","RGH RTHB RTH RHRT HTR HTRH");
        type(watchlistPageObjects.RNPHolder(), "Reference Number: ","464645......GRTHRTH456 ");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.Errors()), "Error");
        waitSleep(3000);
        click(watchlistPageObjects.SaveOK(), "OK");
        watchlistPageObjects.KTPNPHolder().clear();
        watchlistPageObjects.RNPHolder().clear();
        click(watchlistPageObjects.LnameCustomer(), "Customer Name Lname");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        assertEqual(getText(watchlistPageObjects.LNameRequired()), "Last Name is required.");
        assertEqual(getText(watchlistPageObjects.FNameRequired()), "First Name is required.");
    }
    public void WatchlistTransactionTC08() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.DomesticTran(), "Domestic Transaction");
        type(watchlistPageObjects.RNPHolder(), "Reference Number: ","6693079341");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.NoResults()), "No Results Found");
        waitSleep(3000);
        click(watchlistPageObjects.SaveOK(), "OK");
        watchlistPageObjects.KTPNPHolder().clear();
        watchlistPageObjects.RNPHolder().clear();
        click(watchlistPageObjects.LnameCustomer(), "Customer Name Lname");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        assertEqual(getText(watchlistPageObjects.LNameRequired()), "Last Name is required.");
        assertEqual(getText(watchlistPageObjects.FNameRequired()), "First Name is required.");
    }
    public void WatchlistTransactionTC09() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.DomesticTran(), "Domestic Transaction");
        click(watchlistPageObjects.PayoutType(), "Payout Type");
        click(watchlistPageObjects.PayoutTran(), "Payout transaction");
        type(watchlistPageObjects.KTPNPHolder(), "KTPN: ","6693079341");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.NoResults()), "No Results Found");
        waitSleep(3000);
        click(watchlistPageObjects.SaveOK(), "OK");
        watchlistPageObjects.KTPNPHolder().clear();
        watchlistPageObjects.RNPHolder().clear();
        click(watchlistPageObjects.LnameCustomer(), "Customer Name Lname");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        assertEqual(getText(watchlistPageObjects.LNameRequired()), "Last Name is required.");
        assertEqual(getText(watchlistPageObjects.FNameRequired()), "First Name is required.");
    }
    public void WatchlistTransactionTC10() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.PartnerSendout(), "Partner KYC Sendout Transaction");
        type(watchlistPageObjects.RNPHolder(), "Reference Number: ","464645......GRTHRTH456");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        assertEqual(getText(watchlistPageObjects.NoResults()), "No Results Found");
        waitSleep(3000);
        click(watchlistPageObjects.SaveOK(), "OK");
        watchlistPageObjects.RNPHolder().clear();
        click(watchlistPageObjects.LnameCustomer(), "Customer Name Lname");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        assertEqual(getText(watchlistPageObjects.LNameRequired()), "Last Name is required.");
        assertEqual(getText(watchlistPageObjects.FNameRequired()), "First Name is required.");
    }
    public void WatchlistTransactionTC11() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.PartnerPayout(), "Partner Payout Transaction");
        type(watchlistPageObjects.KTPNPHolder(), "KTPN: ","464645......GRTHRTH456");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.NoResults()), "No Results Found");
        waitSleep(3000);
        click(watchlistPageObjects.SaveOK(), "OK");
        watchlistPageObjects.KTPNPHolder().clear();
        click(watchlistPageObjects.LnameCustomer(), "Customer Name Lname");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        assertEqual(getText(watchlistPageObjects.LNameRequired()), "Last Name is required.");
        assertEqual(getText(watchlistPageObjects.FNameRequired()), "First Name is required.");
    }
    public void WatchlistTransactionTC12() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.QCLTran(), "QCL Transaction");
        type(watchlistPageObjects.RNPHolder(), "Reference Number: ","464645......GRTHRTH456 ");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.Errors()), "Error");
        waitSleep(3000);
        click(watchlistPageObjects.SaveOK(), "OK");
        watchlistPageObjects.RNPHolder().clear();
        click(watchlistPageObjects.LnameCustomer(), "Customer Name Lname");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        assertEqual(getText(watchlistPageObjects.LNameRequired()), "Last Name is required.");
        assertEqual(getText(watchlistPageObjects.FNameRequired()), "First Name is required.");
    }
    public void WatchlistTransactionTC13() throws Exception {
        waitSleep(2000);
        click(watchlistPageObjects.SelectType(), "Select Type");
        click(watchlistPageObjects.QCLTran(), "QCL Transaction");
        type(watchlistPageObjects.RNPHolder(), "Reference Number: ","6693079341");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        waitSleep(5000);
        assertEqual(getText(watchlistPageObjects.NoResults()), "No Results Found");
        waitSleep(3000);
        click(watchlistPageObjects.SaveOK(), "OK");
        watchlistPageObjects.RNPHolder().clear();
        click(watchlistPageObjects.LnameCustomer(), "Customer Name Lname");
        click(watchlistPageObjects.SearchBu(), "Search Button");
        assertEqual(getText(watchlistPageObjects.LNameRequired()), "Last Name is required.");
        assertEqual(getText(watchlistPageObjects.FNameRequired()), "First Name is required.");
    }

}
