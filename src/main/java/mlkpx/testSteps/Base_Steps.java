package mlkpx.testSteps;

import org.mlkpx.pageObject.*;
import utilities.ReusableComponents.GeneralMethod;
import utilities.PropertyReader.propertyReader;
import org.testng.Assert;
public abstract class Base_Steps extends GeneralMethod {

    Kyc_PageObjects kycPageObjects = new Kyc_PageObjects();
    Home_PageObjects homePageObjects = new Home_PageObjects();
    Login_PageObjects loginPageObjects = new Login_PageObjects();
    Google_PageObjects googlePageObjects = new Google_PageObjects();
    SendOut_PageObjects sendOutPageObjects = new SendOut_PageObjects();
    SendOutCancellation_PageObjects sendOutCancellationPageObjects = new SendOutCancellation_PageObjects();
    SOReprinting_PageObjects soReprintingPageObjects = new SOReprinting_PageObjects();
    RequestForChange_PageObjects requestForChangePageObjects = new RequestForChange_PageObjects();
    ReturnToSender_PageObjects returnToSenderPageObjects = new ReturnToSender_PageObjects();
    ORReprinting_PageObjects orReprintingPageObjects = new ORReprinting_PageObjects();
    WalletServices_PageObjects walletServicesPageObjects = new WalletServices_PageObjects();
    BillsPay_PageObjects billsPayPageObjects = new BillsPay_PageObjects();
    Payout_PageObjects payoutPageObjects = new Payout_PageObjects();
    PayoutCancellation_PageObjects payoutCancellationPageObjects = new PayoutCancellation_PageObjects();
    PayoutReprinting_PageObjects payoutReprintingPageObjects = new PayoutReprinting_PageObjects();
    WS_CashInToOwnAccount_PageObjects wsCashInToOwnAccountPageObjects = new WS_CashInToOwnAccount_PageObjects();
    WS_CashOut_PageObjects wsCashOutPageObjects = new WS_CashOut_PageObjects();
    WS_KwartaPadalaPayOut_PageObjects wsKwartaPadalaPayOutPageObjects = new WS_KwartaPadalaPayOut_PageObjects();
    WS_ShopSafe_PageObjects wsShopSafePageObjects = new WS_ShopSafe_PageObjects();
    SendoutPartner_Moneygram_PageObjects sendoutPartnerMoneygramPageObjects = new SendoutPartner_Moneygram_PageObjects();
    SendoutPartnerMoneygramCancellation_PageObjects sendoutPartnerMoneygramCancellationPageObjects = new SendoutPartnerMoneygramCancellation_PageObjects();
    RequestForChangePartner_PageObjects requestForChangePartnerPageObjects = new RequestForChangePartner_PageObjects();
    ORReprintingPartner_PageObjects orReprintingPartnerPageObjects = new ORReprintingPartner_PageObjects();
    SOReprintingPartner_PageObjects soReprintingPartnerPageObjects = new SOReprintingPartner_PageObjects();
    KPDomesticReports_PageObjects kpDomesticReportsPageObjects = new KPDomesticReports_PageObjects();
    MLWalletServicesReportBranchReport_PageObjects mlWalletServicesReportBranchReportPageObjects = new MLWalletServicesReportBranchReport_PageObjects();
    CorporatePartnerReport_PageObjects corporatePartnerReportPageObjects = new CorporatePartnerReport_PageObjects();
    GcashCashIn_PageObjects gcashCashInPageObjects = new GcashCashIn_PageObjects();
    GcashTransaction_PageObjects gcashTransactionPageObjects = new GcashTransaction_PageObjects();
    GcashReceiptReprinting_PageObjects gcashReceiptReprintingPageObjects = new GcashReceiptReprinting_PageObjects();
    Users_PageObjects usersPageObjects = new Users_PageObjects();
    UserNewBranch_PageObjects userNewBranchPageObjects = new UserNewBranch_PageObjects();

    BillsPayReport_PageObjects billsPayReportPageObjects = new BillsPayReport_PageObjects();

    Sendout_Partners_PageObjects sendoutPartnersPageObjects = new Sendout_Partners_PageObjects();
    Payout_Partners_PageObjects payoutPartnersPageObjects = new Payout_Partners_PageObjects();
    final String filepath = "src\\test\\java\\resources\\testData.properties";
    propertyReader propertyReader = new propertyReader(filepath);
    Assert anAssert;
}
