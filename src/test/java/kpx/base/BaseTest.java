package kpx.base;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import kpx.actual.BillsPayCEBUINSTITUTETECH_Tests;
import kpx.actual.BillsPayEIGHTCHAMP_Tests;
import kpx.actual.BillsPayGOLDENBRIA_Tests;
import kpx.actual.BillsPaySOCOTECO_Tests;
import mlkpx.testSteps.*;
import mlkpx.testSteps.Home_Steps;
import mlkpx.testSteps.Kyc_Steps;
import mlkpx.testSteps.Login_Steps;
import mlkpx.testSteps.Payout_Domestic_Steps;
import mlwallet.testSteps.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static utilities.Driver.DriverManager.*;

import utilities.Driver.AppiumDriverManager;
import utilities.Driver.DriverType;

import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.time.Duration;

public class BaseTest {
    protected Home_Steps homeSteps;
    protected Login_Steps loginSteps;
    protected Kyc_Steps kycSteps;
    protected SendOut_Steps sendOutSteps;
    protected SendOutCancellation_Steps sendOutCancellationSteps;
    protected Payout_Domestic_Steps payoutSteps;
    protected PayoutCancell_Domestic_Steps payoutCancellationSteps;
    protected PayoutCancelle_Partner_Steps payoutCancellePartnerSteps;
    protected PayoutReprinting_Domestic_Steps payoutReprintingSteps;
    protected BillsPayMaynilad_Steps billsPaySteps;
    protected BillsPayCignal_Steps billsPayCignalSteps;
    protected BillsPayPagbig_Steps billsPayPagbigSteps;
    protected BillsPayNordeco_Steps billsPayNordecoSteps;
    protected BillsPayCEBECOIII_Steps billsPayCEBECOIIISteps;
    protected BillsPayFlashpay_Steps billsPayFlashpaySteps;
    protected BillsPayGENTRADE_Steps billsPayGENTRADESteps;
    protected BillsPayISABELWATER_Steps billsPayISABELWATERSteps;
    protected BillsPayLAGUNAWATER_Steps billsPayLAGUNAWATERSteps;
    protected BillsPayPOWERCYCLE_Steps billsPayPOWERCYCLESteps;
    protected BillsPayBAVI_CTG_Steps billsPayBAVICtgSteps;
    protected BillsPayCOTELCO_Steps billsPayCOTELCOSteps;
    protected BillsPayMACROCEBU_Steps billsPayMACROCEBUSteps;
    protected BillsPayHELPMATETALISAY_Steps billsPayHELPMATETALISAYSteps;
    protected BillsPayMLJEWELLERS_Steps billsPayMLJEWELLERSSteps;
    protected BillsPayEIGHTCHAMP_Steps billsPayEIGHTCHAMPSteps;
    protected BillsPayGOLDENBRIA_Steps billsPayGOLDENBRIASteps;
    protected BillsPaySAMELCO1_Steps billsPaySAMELCO1Steps;
    protected BillsPaySOCOTECO_Steps billsPaySOCOTECOSteps;
    protected BillsPayMOELCI_1_Steps billsPayMOELCI1Steps;
    protected BillsPayRMGCORP_Steps billsPayRMGCORPSteps;
    protected BillsPayMETROWATER_Steps billsPayMETROWATERSteps;
    protected BillsPaySTIWEST_Steps billsPaySTIWESTSteps;
    protected BillsPayIPICEBU_Steps billsPayIPICEBUSteps;
    protected BillsPaySEMIGIRECORP_Steps billsPaySEMIGIRECORPSteps;
    protected BillsPayHONDAMOTOR_Steps billsPayHONDAMOTORSteps;
    protected BillsPayCEBUINSTITUTETECH_Steps billsPayCEBUINSTITUTETECHSteps;
    protected BillsPayVECO_Steps billsPayVECOSteps;
    protected BillsPayZCWATERDISTRICT_Steps billsPayZCWATERDISTRICTSteps;
    protected BillsPayCENTROESCOLAR_Steps billsPayCENTROESCOLARSteps;
    protected BillsPaySANTAPHARMA_Steps billsPaySANTAPHARMASteps;
    protected BillsPayCARMONA_Steps billsPayCARMONASteps;
    protected BillsPayBBBROTHERSPHINC_Steps billsPayBBBROTHERSPHINCSteps;
    protected BillsPayMETROBANKVISAYAN_Steps billsPayMETROBANKVISAYANSteps;
    protected BillsPayJOHNFOUNDATION_Steps billsPayJOHNFOUNDATIONSteps;
    protected BillsPay123LENDING_Steps billsPay123LENDINGSteps;
    protected BillsPayBREADANDMORE_Steps billsPayBREADANDMORESteps;



    protected BillsPayCancellationMaynilad_Steps billsPayCancellationSteps;
    protected BillsPayCancellation_Nordeco_Steps billsPayCancellationNordecoSteps;
    protected BillsPayCancellation_Cignal_Steps billsPayCancellationCignalTests;
    protected BillsPayCancellation_CEBECO_Steps billsPayCancellationCebecoSteps;
    protected BillsPayCancellation_Pagibig_Steps billsPayCancellationPagibigSteps;
    protected BillsPayChangeDMaynilad_Steps billsPayChangeDSteps;
    protected BillsPayChangeDCignal_Steps billsPayChangeDCignalSteps;
    protected BillsPayChangeDNordeco_Steps billsPayChangeDNordecoSteps;
    protected BillsPayChangeCEBECOIII_Steps billsPayChangeCEBECOIIISteps;
    protected BillsPayChangeDPagibig_Steps billsPayChangeDPagibigSteps;
    protected BillsPayReprinting_Maynilad_Steps billsPayReprintingSteps;
    protected BillsPayReprinting_Cignal_Steps billsPayReprintingCignalSteps;
    protected BillsPayReprinting_Nordeco_Steps billsPayReprintingNordecoSteps;
    protected BillsPayReprinting_CEBECO_Steps billsPayReprintingCebecoSteps;
    protected BillsPayReprinting_Pagibig_Steps billsPayReprintingPagibigSteps;
    protected SOReprinting_Steps soReprintingSteps;
    protected RequestForChange_Steps requestForChangeSteps;
    protected ReturnToSender_Steps returnToSenderSteps;
    protected ORReprinting_Steps orReprintingSteps;
    protected WS_CashInToOwnAccount_Steps wsCashInToOwnAccountSteps;
    protected WS_CashInToAnotherAccount wsCashInToAnotherAccount;
    protected WS_CashOut_Steps wsCashOutSteps;
    protected WS_KwartaPadalaPayOut_Steps wsKwartaPadalaPayOutSteps;
    protected WS_Reprinting_Steps wsReprintingSteps;
    protected WS_ShopSafe_Steps wsShopSafeSteps;
    protected SendoutPartner_Moneygram_Steps sendoutPartnerMoneygramSteps;
    protected SendoutPartnerMoneygramCancellation_Steps sendoutPartnerMoneygramCancellationSteps;
    protected RequestForChangePartner_Steps requestForChangePartnerSteps;
    protected ORReprintingPartner_Steps orReprintingPartnerSteps;
    protected SOReprintingPartner_Steps soReprintingPartnerSteps;
    protected KPDomesticReports_Steps kpDomesticReportsSteps;
    protected MLWalletServicesReportBranchReport_Steps mlWalletServicesReportBranchReportSteps;
    protected CorporatePartnerReport_Steps corporatePartnerReportSteps;
    protected BillsPayReport_Steps billsPayReportSteps;
    protected GcashCashIn_Steps gcashCashInSteps;
    protected GcashTransaction_Steps gcashTransactionSteps;
    protected GcashReceiptReprinting_Steps gcashReceiptReprintingSteps;
    protected Users_Steps usersSteps;
    protected UserNewBranch_Steps userNewBranchSteps;
    protected BillspayMetroBankCollection_Steps billspayMetroBankCollectionSteps;



    protected Watchlist_Steps watchlistSteps;
    protected WatchlistConfiguration_Steps watchlistConfigurationSteps;
    protected WatchlistTransaction_Steps watchlistTransactionSteps;

    protected Login loginWalletSteps;
    protected Cash_In cashInSteps;


    protected Kwarta_Padala kwartaPadala;
    protected Cash_Out cashOut;
    protected GenerateTestData generateTestData;


    protected Sendout_Partners_Steps sendoutPartnersSteps;
    protected Payout_Partners_Steps payoutPartnersSteps;
    @Parameters("type")
    @BeforeClass (alwaysRun = true)
    public void setUp(final String type){
        if(type.equals("mobile")){
//            AppiumDriverManager.setupServer();
//            AppiumDriverManager.startActivity();
//            initWallet();
        }else if(type.equals("web")){
            final String browser ="chrome";
            initializeDriver(DriverType.valueOf(browser.toUpperCase()));
            getDriver().manage().deleteAllCookies();
            getDriver().get(System.getProperty("targetUrl"));
            init();
        }else{
            throw new AssertionError("Unsupported Type: " + type);
        }
        ExtentReporter.setPlatform(type);

    }
    private void initializeDriver(DriverType driverType) {
        createDriver(driverType);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("type")
    public void setUpTests(final String type){
        if(type.equals("web")) {
            getDriver().get(System.getProperty("homeUrl"));
        }else if(type.equals("mobile")){
            LoggingUtils.info("Starting app...");
            AppiumDriverManager.setupServer();
            AppiumDriverManager.startActivity();
            initWallet();
            PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverManager.getAndroidDriver(), Duration.ofSeconds(10)), this);
        }
    }
    @AfterMethod(alwaysRun = true)
    @Parameters("type")
    public void clean(final String type){
        if(type.equals("mobile")) {
//            LoggingUtils.info("Resetting app...");
            AppiumDriverManager.stopServer();
        }
        LoggingUtils.info("------>>>Test Ended<<<-------");
    }
    @AfterClass(alwaysRun = true)
    @Parameters("type")
    public void tearDown (final String type) {
        if(type.equals("mobile")){
//            AppiumDriverManager.stopServer();
        }else if(type.equals("web")){
            closeWebBrowser();
        }else{
            throw new IllegalArgumentException("Unsupported Type: " + type);
        }
    }
    public void init(){
        this.loginSteps = new Login_Steps();
        this.homeSteps = new Home_Steps();
        this.kycSteps = new Kyc_Steps();
        this.sendOutSteps = new SendOut_Steps();
        this.sendOutCancellationSteps = new SendOutCancellation_Steps();
        this.payoutSteps = new Payout_Domestic_Steps();
        this.payoutCancellationSteps = new PayoutCancell_Domestic_Steps();
        this.payoutReprintingSteps = new PayoutReprinting_Domestic_Steps();
        this.billsPaySteps = new BillsPayMaynilad_Steps();
        this.billsPayCignalSteps = new BillsPayCignal_Steps();
        this.billsPayPagbigSteps = new BillsPayPagbig_Steps();
        this.billsPayNordecoSteps = new BillsPayNordeco_Steps();
        this.billsPayCEBECOIIISteps = new BillsPayCEBECOIII_Steps();
        this.billsPayFlashpaySteps = new BillsPayFlashpay_Steps();
        this.billsPayGENTRADESteps = new BillsPayGENTRADE_Steps();
        this.billsPayISABELWATERSteps = new BillsPayISABELWATER_Steps();
        this.billsPayLAGUNAWATERSteps = new BillsPayLAGUNAWATER_Steps();
        this.billsPayPOWERCYCLESteps = new BillsPayPOWERCYCLE_Steps();
        this.billsPayBAVICtgSteps = new BillsPayBAVI_CTG_Steps();
        this.billsPayCOTELCOSteps = new BillsPayCOTELCO_Steps();
        this.billsPayMACROCEBUSteps = new BillsPayMACROCEBU_Steps();
        this.billsPayHELPMATETALISAYSteps = new BillsPayHELPMATETALISAY_Steps();
        this.billsPayMLJEWELLERSSteps = new BillsPayMLJEWELLERS_Steps();
        this.billsPayEIGHTCHAMPSteps = new BillsPayEIGHTCHAMP_Steps();
        this.billsPayGOLDENBRIASteps = new BillsPayGOLDENBRIA_Steps();
        this.billsPaySAMELCO1Steps = new BillsPaySAMELCO1_Steps();
        this.billsPaySOCOTECOSteps = new BillsPaySOCOTECO_Steps();
        this.billsPayMOELCI1Steps = new BillsPayMOELCI_1_Steps();
        this.billsPayRMGCORPSteps = new BillsPayRMGCORP_Steps();
        this.billsPayMETROWATERSteps = new BillsPayMETROWATER_Steps();
        this.billsPaySTIWESTSteps = new BillsPaySTIWEST_Steps();
        this.billsPayIPICEBUSteps = new BillsPayIPICEBU_Steps();
        this.billsPaySEMIGIRECORPSteps = new BillsPaySEMIGIRECORP_Steps();
        this.billsPayCEBUINSTITUTETECHSteps = new BillsPayCEBUINSTITUTETECH_Steps();
        this.billsPayHONDAMOTORSteps = new BillsPayHONDAMOTOR_Steps();
        this.billsPayVECOSteps = new BillsPayVECO_Steps();
        this.billsPayZCWATERDISTRICTSteps = new BillsPayZCWATERDISTRICT_Steps();
        this.billsPayCENTROESCOLARSteps = new BillsPayCENTROESCOLAR_Steps();
        this.billsPaySANTAPHARMASteps = new BillsPaySANTAPHARMA_Steps();
        this.billsPayCARMONASteps = new BillsPayCARMONA_Steps();
        this.billsPayBBBROTHERSPHINCSteps = new BillsPayBBBROTHERSPHINC_Steps();
        this.billsPayMETROBANKVISAYANSteps = new BillsPayMETROBANKVISAYAN_Steps();
        this.billsPayJOHNFOUNDATIONSteps = new BillsPayJOHNFOUNDATION_Steps();
        this.billsPay123LENDINGSteps = new BillsPay123LENDING_Steps();
        this.billsPayBREADANDMORESteps = new BillsPayBREADANDMORE_Steps();



        this.billsPayCancellationSteps = new BillsPayCancellationMaynilad_Steps();
        this.billsPayCancellationCignalTests = new BillsPayCancellation_Cignal_Steps();
        this.billsPayCancellationNordecoSteps = new BillsPayCancellation_Nordeco_Steps();
        this.billsPayCancellationCebecoSteps = new BillsPayCancellation_CEBECO_Steps();
        this.billsPayCancellationPagibigSteps = new BillsPayCancellation_Pagibig_Steps();
        this.billsPayChangeDSteps = new BillsPayChangeDMaynilad_Steps();
        this.billsPayChangeDCignalSteps = new BillsPayChangeDCignal_Steps();
        this.billsPayChangeDNordecoSteps = new BillsPayChangeDNordeco_Steps();
        this.billsPayChangeCEBECOIIISteps = new BillsPayChangeCEBECOIII_Steps();
        this.billsPayChangeDPagibigSteps = new BillsPayChangeDPagibig_Steps();
        this.billsPayReprintingSteps = new BillsPayReprinting_Maynilad_Steps();
        this.billsPayReprintingCignalSteps = new BillsPayReprinting_Cignal_Steps();
        this.billsPayReprintingNordecoSteps = new BillsPayReprinting_Nordeco_Steps();
        this.billsPayReprintingCebecoSteps = new BillsPayReprinting_CEBECO_Steps();
        this.billsPayReprintingPagibigSteps = new BillsPayReprinting_Pagibig_Steps();
        this.soReprintingSteps = new SOReprinting_Steps();
        this.requestForChangeSteps = new RequestForChange_Steps();
        this.returnToSenderSteps = new ReturnToSender_Steps();
        this.orReprintingSteps = new ORReprinting_Steps();
        this.wsCashInToOwnAccountSteps = new WS_CashInToOwnAccount_Steps();
        this.wsCashInToAnotherAccount = new WS_CashInToAnotherAccount();
        this.wsCashOutSteps = new WS_CashOut_Steps();
        this.wsKwartaPadalaPayOutSteps = new WS_KwartaPadalaPayOut_Steps();
        this.wsReprintingSteps = new WS_Reprinting_Steps();
        this.wsShopSafeSteps = new WS_ShopSafe_Steps();
        this.sendoutPartnerMoneygramSteps = new SendoutPartner_Moneygram_Steps();
        this.sendoutPartnerMoneygramCancellationSteps = new SendoutPartnerMoneygramCancellation_Steps();
        this.requestForChangePartnerSteps = new RequestForChangePartner_Steps();
        this.orReprintingPartnerSteps = new ORReprintingPartner_Steps();
        this.soReprintingPartnerSteps = new SOReprintingPartner_Steps();


        this.watchlistSteps = new Watchlist_Steps();
        this.watchlistConfigurationSteps = new WatchlistConfiguration_Steps();
        this.watchlistTransactionSteps = new WatchlistTransaction_Steps();

        this.sendoutPartnersSteps = new Sendout_Partners_Steps();
        this.payoutPartnersSteps = new Payout_Partners_Steps();
        this.payoutCancellePartnerSteps = new PayoutCancelle_Partner_Steps();
        this.kpDomesticReportsSteps = new KPDomesticReports_Steps();
        this.mlWalletServicesReportBranchReportSteps = new MLWalletServicesReportBranchReport_Steps();
        this.corporatePartnerReportSteps = new CorporatePartnerReport_Steps();
        this.billsPayReportSteps = new BillsPayReport_Steps();
        this.gcashCashInSteps = new GcashCashIn_Steps();
        this.gcashTransactionSteps = new GcashTransaction_Steps();
        this.gcashReceiptReprintingSteps = new GcashReceiptReprinting_Steps();
        this.usersSteps = new Users_Steps();
        this.userNewBranchSteps = new UserNewBranch_Steps();
        this.billspayMetroBankCollectionSteps = new BillspayMetroBankCollection_Steps();

    }
    public void initWallet(){
        this.loginWalletSteps = new Login();
        this.cashInSteps = new Cash_In();
        this.kwartaPadala = new Kwarta_Padala();
        this.cashOut = new Cash_Out();
        this.generateTestData = new GenerateTestData();
    }
}