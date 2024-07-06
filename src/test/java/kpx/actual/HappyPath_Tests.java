package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class HappyPath_Tests extends BaseTest {


    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
//    // SENDOUT TRANSACTION DOMESTIC
//    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To Validate Submit SendOut Transaction")
//    public void DSendout_TC_8() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.sendOutSteps.DS_TC_08();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Verify SendOut Transaction Option Valid Branch Code")
//    public void DSendout_TC_02_1()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_02_1();
//        }
//    }
//    //SENDOUT WATCHLIST DOMESTIC
//    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To Validate kyc from the Watch List")
//    public void DSendout_Watchlist() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.sendOutSteps.DS_TC_11();
//        }
//    }
//
//    //SENDOUT CANCELLATION DOMESTIC
//    @Test(dependsOnMethods = "loginGoogle" , priority = 4, description = "Verify Navigation of SendOut Cancellation and Cancellation of Transaction")
//    public void DSendOutCancellation()throws Exception{
//        if(this.homeSteps.isInHomePage()) {
//            this.sendOutCancellationSteps.DS_TC_08();
//            this.sendOutCancellationSteps.SOC_TC_01();
//        }
//
//    }
//
//    @Test(dependsOnMethods = "loginGoogle" , priority = 5, description = "Verify Navigation of SendOut remote Cancellation and Cancellation of Transaction")
//    public void DSendOutRemoteCancellation()throws Exception{
//        if(this.homeSteps.isInHomePage()) {
//            this.sendOutCancellationSteps.DS_TC_02_1();
//            this.sendOutCancellationSteps.SOC_TC_1_01();
//        }
//
//    }
//
//   // SENDOUT REQUEST FOR CHANGE DOMESTIC
//
//    @Test(dependsOnMethods = "loginGoogle" , priority = 6, description = "Verify Navigation of Request for Change Page and can Request for Change")
//    public void SendoutRequestForChange_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_08();
//            this.requestForChangeSteps.RFC_TC_01();
//        }
//    }
//    //SENDOUT RETURN TO SENDER DOMESTIC
//
//    @Test(dependsOnMethods = "loginGoogle" , priority = 7, description = "Verify Navigation of Return To Sender Page")
//    public void SendoutReturnToSender_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_08();
//            this.returnToSenderSteps.RTS_TC_01();
//        }
//    }
//    //SENDOUT SO REPRINTING DOMESTIC
//    @Test(dependsOnMethods = "loginGoogle" , priority = 8, description = "Validate SO Reprinting")
//    public void SendoutSOReprinting()throws Exception{
//        if(this.homeSteps.isInHomePage()) {
//            this.soReprintingSteps.SOR_TC_01();
//
//        }
//    }
//    //SENDOUT OR REPRINTING DOMESTIC
//    @Test(dependsOnMethods = "loginGoogle" , priority = 9, description = "Validate OR Reprinting")
//    public void SendoutORReprinting()throws Exception{
//        if(this.homeSteps.isInHomePage()) {
//            this.orReprintingSteps.OR_TC_01();
//
//        }
//
//    }
//    // SENDOUT TRANSACTION MONEYGRAM PARTNER
//    @Test(dependsOnMethods = "loginGoogle" , priority = 10, description = "Verify Sendout Moneygram (10 minute service)")
//    public void submitSendoutMoneygram10MinuteService()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendoutPartnerMoneygramSteps.PS_TC_08();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle" , priority = 11, description = "Verify Sendout Moneygram (10 minute service) Remote")
//    public void submitSendoutMoneygram10MinuteServiceRemote()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendoutPartnerMoneygramSteps.PS_TC_08_1();
//        }
//    }
//    //SENDOUT CANCELLATION MONEYGRAM PARTNER
//    @Test(dependsOnMethods = "loginGoogle" , priority = 12, description = "Verify Sendout Cancelation")
//    public void  verifySendoutCancelation()throws Exception{
//        if(this.homeSteps.isInHomePage()) {
//            this.sendoutPartnerMoneygramSteps.PS_TC_08();
//            this.sendoutPartnerMoneygramCancellationSteps.PSOC_TC_01();
//        }
//    }
//    // SENDOUT REQUEST FOR CHANGE MONEYGRAM PARTNER
//    @Test(dependsOnMethods = "loginGoogle" , priority = 13, description = "Verify Navigation of Request for Change Page and can Request for Change Partner")
//    public void requestForChangePartner()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendoutPartnerMoneygramSteps.PS_TC_08();
//            this.requestForChangePartnerSteps.RFCP_TC_01();
//        }
//    }
//    //SENDOUT REPRINTING MONEYGRAM PARTNER AND WESTERN UNION
//    @Test(dependsOnMethods = "loginGoogle" , priority = 14, description = "Validate SO Reprinting Moneygram")
//    public void validateSOReprintingMoneygram()throws Exception{
//        if(this.homeSteps.isInHomePage()) {
//            this.soReprintingPartnerSteps.SOR_TC_01();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle" , priority = 15, description = "Validate SO Reprinting Western Union")
//    public void validateSOReprintingWesternUnion()throws Exception{
//        if(this.homeSteps.isInHomePage()) {
//            this.soReprintingPartnerSteps.SOR_TC_02();
//
//        }
//
//    }
//
//    // SENDOUT TRANSACTION WESTERN UNION  PARTNER
//    @Test(dependsOnMethods = "loginGoogle" , priority = 16, description = "Verify Submit Sendout Western Union")
//    public void submitSendoutWesternUnion()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendoutPartnerMoneygramSteps.PS_TC_13();
//        }
//    }
//
//    @Test(dependsOnMethods = "loginGoogle" , priority = 17, description = "Verify Submit Sendout Western Union Remote")
//    public void submitSendoutWesternUnionRemote()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendoutPartnerMoneygramSteps.PS_TC_14();
//        }
//    }
//
//    //PAYOUT TRANSACTION DOMESTIC
//    @Test(dependsOnMethods = "loginGoogle", priority = 18, description = "Successful domestic payout transaction")
//    public void Payout_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_08();
//            this.payoutSteps.navigatePayoutPage();
//            this.payoutSteps.validateSuccessfulDomesticPayout();
//
//        }
//    }
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 19, description = "Successful remote domestic payout transaction")
//    public void Payout_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_02_1();
//            this.payoutSteps.navigatePayoutPage();
//            this.payoutSteps.validateSuccessfulRemoteDomesticPayout();
//        }
//    }
//
//    //PAYOUT TRANSACTION WESTERN UNION PARTNERS
//    @Test(dependsOnMethods = "loginGoogle", priority =20, description = "Successful partner payout transaction")
//    public void Partner_Payout_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendoutPartnerMoneygramSteps.PS_TC_13();
//            this.payoutPartnersSteps.navigatePayoutPage();
//            this.payoutPartnersSteps.validateSuccessfulPartnerPayout();
//
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 21, description = "Successful remote partner payout transaction")
//    public void Partner_Payout_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendoutPartnerMoneygramSteps.PS_TC_14();
//            this.payoutPartnersSteps.navigatePayoutPage();
//            this.payoutPartnersSteps.validateRemoteSuccessfulPartnerPayout();
//
//        }
//    }
//
//
//    ///PAYOUT CANCELLATION DOMESTIC
//    @Test(dependsOnMethods = "loginGoogle", priority = 22, description = "Validate successful payout cancellation")
//    public void Payout_TC_Cancellation_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_08();
//            this.payoutSteps.navigatePayoutPage();
//            this.payoutSteps.validateSuccessfulDomesticPayout();
//            this.payoutCancellationSteps.validateSuccessfulPayoutCancellation();
//
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 23, description = "Validate remote successful payout cancellation")
//    public void Payout_TC_Cancellation_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_02_1();
//            this.payoutSteps.navigatePayoutPage();
//            this.payoutSteps.validateSuccessfulRemoteDomesticPayout();
//            this.payoutCancellationSteps.validateRemoteSuccessfulPayoutCancellation();
//
//        }
//    }
//    // FOR WATCHLIST
//    @Test(dependsOnMethods = "loginGoogle", priority = 24, description = "Domestic payout transaction for compliance assistance")
//    public void Payout_Watchlist()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.payoutSteps.ForWatchlist();
//            this.payoutSteps.navigatePayoutPage();
//            this.payoutSteps.validateComplianceAssistance();
//
//        }
//
//    }
//
//  //  PAYOUT REPRINTING DOMESTIC
//    @Test(dependsOnMethods = "loginGoogle", priority = 25, description = "To validate successful payout reprinting transaction")
//    public void Payout_TC_Reprinting_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.payoutReprintingSteps.navigatePayoutPage();
//            this.payoutReprintingSteps.validateSuccessfulPayoutReprinting();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 26, description = "To validate successful remote payout reprinting transaction")
//    public void Payout_TC_Reprinting_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.payoutReprintingSteps.navigatePayoutPage();
//            this.payoutReprintingSteps.validateSuccessfulRemotePayoutReprinting();
//
//        }
//
//    }
//    //  PAYOUT REPRINTING WESTERN UNION PARTNERS
//    @Test(dependsOnMethods = "loginGoogle", priority = 27, description = "To validate successful payout reprinting transaction")
//    public void Payout_Western_TC_Reprinting_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendoutPartnerMoneygramSteps.PS_TC_13();
//            this.payoutPartnersSteps.navigatePayoutPage();
//            this.payoutPartnersSteps.validateSuccessfulPartnerPayout();
//            this.payoutReprintingSteps.navigatePayoutPage();
//            this.payoutReprintingSteps.validateSuccessfulPayoutReprinting();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 28, description = "To validate successful remote payout reprinting transaction")
//    public void Payout_Western_TC_Reprinting_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendoutPartnerMoneygramSteps.PS_TC_14();
//            this.payoutPartnersSteps.navigatePayoutPage();
//            this.payoutPartnersSteps.validateRemoteSuccessfulPartnerPayout();
//            this.payoutReprintingSteps.navigatePayoutPage();
//            this.payoutReprintingSteps.validateSuccessfulRemotePayoutReprinting();
//
//        }
//
//    }
//
//    //BILLS PAY SENDOUT MAYNILAD
//    @Test(dependsOnMethods = "loginGoogle", priority = 29, description = "To validate successful bills payment transaction")
//    public void BillsPay_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPaySteps.navigatePayoutPage();
//            this.billsPaySteps.validateSuccessfulBillsPayTransaction();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 30, description = "To validate successful remote bills payment transaction")
//    public void BillsPay_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPaySteps.navigatePayoutPage();
//            this.billsPaySteps.validateSuccessfulRemoteBillsPayTransaction();
//
//        }
//
//    }
//    //BILLS PAY CANCELLATION MAYNILAD
//    @Test(dependsOnMethods = "loginGoogle", priority = 31, description = "To validate successful Bills Pay Cancellation ")
//    public void BPCancellation_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCancellationSteps.navigatePayoutPage();
////            this.billsPaySteps.validateSuccessfulBillsPayTransaction();
//            this.billsPayCancellationSteps.validateSuccessfulBillsPayCancellation();
//
//        }
//
//    }
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 32, description = "To validate remote successful Bills Pay Cancellation ")
//    public void BPCancellation_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCancellationSteps.navigatePayoutPage();
////            this.billsPaySteps.validateSuccessfulRemoteBillsPayTransaction();
//            this.billsPayCancellationSteps.validateSuccessfulRemoteBillsPayCancellation();
//
//        }
//
//    }
//    //BILLS PAY CHANGE DETAILS MAYNILAD
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 33, description = "To validate successful BillsPay Change Details")
//    public void BP_ChangeDetails_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayChangeDSteps.navigatePayoutPage();
//            this.billsPaySteps.validateSuccessfulBillsPayTransaction();
//            this.billsPayChangeDSteps.validateSuccessfulBillsPayChangeDetails();
//        }
//
//    }
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 34, description = "To validate successful remote BillsPay Change Details")
//    public void BP_ChangeDetails_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayChangeDSteps.navigatePayoutPage();
//            this.billsPaySteps.validateSuccessfulRemoteBillsPayTransaction();
//            this.billsPayChangeDSteps.validateSuccessfulBillsPayRemoteChangeDetails();
//
//        }
//    }
//    //BILLS PAY REPRINTING MAYNILAD
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 35, description = "To validate BillsPay Successful Payment Reprint")
//    public void BP_Reprinting_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayReprintingSteps.navigatePayoutPage();
////            this.billsPaySteps.validateSuccessfulBillsPayTransaction();
//            this.billsPayReprintingSteps.validateSuccessfulBillsPayReprinting();
//
//        }
//
//    }
//    //BILLS PAY SENDOUT CIGNAL PARTNER
//    @Test(dependsOnMethods = "loginGoogle", priority = 36, description = "To validate successful bills payment transaction in Cignal Partner")
//    public void CignalBP_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCignalSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulBillsPayCignal();
//
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 37, description = "To validate successful remote bills payment transaction in Cignal Partner")
//    public void CignalBP_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCignalSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulRemoteBillsPayCignal();
//
//        }
//    }
//    //BILLS PAY CANCELLATION CIGNAL PARTNER
//    @Test(dependsOnMethods = "loginGoogle", priority = 38, description = "To validate successful Bills Pay Cancellation CIGNAL Partner")
//    public void BPCignalCancellation_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCignalSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulBillsPayCignal();
//            this.billsPayCancellationCignalTests.validateSuccessfulBillsPayCancellationCIGNALPartner();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 39, description = "To validate remote successful Bills Pay Cancellation CIGNAL Partner")
//    public void BPCignalCancellation_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCignalSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulRemoteBillsPayCignal();
//            this.billsPayCancellationCignalTests.validateSuccessfulRemoteBillsPayCancellationCIGNALPartner();
//
//        }
//
//    }
//    //BILLS PAY CHANGE DETAILS CIGNAL PARTNER
//    @Test(dependsOnMethods = "loginGoogle", priority = 40, description = "To validate successful BillsPay Change Details Cignal Partners")
//    public void BPCignal_ChangeDetails_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayChangeDSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulBillsPayCignal();
//            this.billsPayChangeDCignalSteps.validateSuccessfulBillsPayCIGNALChangeDetails();
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 41, description = "To validate successful remote BillsPay Change Details Cignal Partners")
//    public void BPCignal_ChangeDetails_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayChangeDSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulRemoteBillsPayCignal();
//            this.billsPayChangeDCignalSteps.validateSuccessfulBillsPayCIGNALRemoteChangeDetails();
//
//        }
//
//    }
//    //BILLS PAY REPRINTING CIGNAL PARTNER
//    @Test(dependsOnMethods = "loginGoogle", priority = 42, description = "To validate BillsPay Successful Payment Reprint")
//    public void BPCignal_RP_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCignalSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulBillsPayCignal();
//            this.billsPayReprintingCignalSteps.validateSuccessfulBillsPayCIGNALReprinting();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 43, description = "To validate BillsPay Successful Remote Payment Reprint")
//    public void BPCignal_RP_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCignalSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulRemoteBillsPayCignal();
//            this.billsPayReprintingCignalSteps.validateSuccessfulRemoteBillsPayCIGNALReprinting();
//
//        }
//
//    }
//
//
//    //BILLS PAY SENDOUT NORDECO PARTNER
//    @Test(dependsOnMethods = "loginGoogle", priority = 44, description = "To validate successful bills payment transaction in NORDECO Partner")
//    public void NordecoBP_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayNordecoSteps.navigatePayoutPage();
//            this.billsPayNordecoSteps.validateSuccessfulBillsPayNORDECO();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 45, description = "To validate successful remote bills payment transaction in NORDECO Partner")
//    public void NordecoBP_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayNordecoSteps.navigatePayoutPage();
//            this.billsPayNordecoSteps.validateSuccessfulRemoteBillsPayNORDECO();
//        }
//    }
//
//    //BILLS PAY CANCELLATION NORDECO PARTNER
//    @Test(dependsOnMethods = "loginGoogle", priority = 46, description = "To validate NORDECO PARTNER successful Bills Pay Cancellation ")
//    public void BPNordecoCancellation_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayNordecoSteps.navigatePayoutPage();
//            this.billsPayNordecoSteps.validateSuccessfulBillsPayNORDECO();
//            this.billsPayCancellationNordecoSteps.validateSuccessfulBillsPayCancellationNORDECOPartner();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 47, description = "To validate remote successful Bills Pay Cancellation NORDECO PARTNER")
//    public void BPNordecoCancellation_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayNordecoSteps.navigatePayoutPage();
//            this.billsPayNordecoSteps.validateSuccessfulRemoteBillsPayNORDECO();
//            this.billsPayCancellationNordecoSteps.validateSuccessfulRemoteBillsPayCancellationNORDECOPartner();
//        }
//    }
//
//    //BILLS PAY CHANGE DETAILS NORDECO PARTNER
//    @Test(dependsOnMethods = "loginGoogle", priority = 48, description = "To validate successful BillsPay Change Details Nordeco Partner")
//    public void BPNordeco_ChangeDetails_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCignalSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulBillsPayCignal();
//            this.billsPayChangeDNordecoSteps.validateSuccessfulBillsPayNORDECOChangeDetails();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 49, description = "To validate successful remote BillsPay Change Details Nordeco Partner")
//    public void BPNordeco_ChangeDetails_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayCignalSteps.navigatePayoutPage();
//            this.billsPayCignalSteps.validateSuccessfulRemoteBillsPayCignal();
//            this.billsPayChangeDNordecoSteps.validateSuccessfulBillsPayRemoteNORDECOChangeDetails();
//        }
//    }
//    //BILLS PAY REPRINTING NORDECO PARTNER
//    @Test(dependsOnMethods = "loginGoogle", priority = 50, description = "To validate BillsPay Successful Payment Reprint Nordeco Partner")
//    public void BPNordeco_RP_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayNordecoSteps.navigatePayoutPage();
//            this.billsPayNordecoSteps.validateSuccessfulBillsPayNORDECO();
//            this.billsPayReprintingNordecoSteps.validateSuccessfulBillsPayNORDECOReprinting();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 51, description = "To validate BillsPay Successful Remote Payment Reprint Nordeco Partner")
//    public void BPNordeco_RP_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.billsPayNordecoSteps.navigatePayoutPage();
//            this.billsPayNordecoSteps.validateSuccessfulRemoteBillsPayNORDECO();
//            this.billsPayReprintingNordecoSteps.validateSuccessfulRemoteBillsPayNORDECOReprinting();
//        }
//    }

    //BILLS PAY SENDOUT PAG-IBIG PARTNER
    @Test(dependsOnMethods = "loginGoogle", priority = 52, description = "To validate successful bills payment transaction in Pagibig Partner")
    public void PagibigBP_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulBillsPayPagibig();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 53, description = "To validate successful remote bills payment transaction in Pagibig Partner")
    public void PagibigBP_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulRemoteBillsPayPagibig();
        }
    }
    //BILLS PAY SENDOUT CEBECO III PARTNER
    @Test(dependsOnMethods = "loginGoogle", priority = 54, description = "To validate successful bills payment transaction in CEBECOIII Partner")
    public void CebecoIIIBP_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulBillsPayCEBECOIII();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 55, description = "To validate successful remote bills payment transaction in CEBECOIII Partner")
    public void CebecoIIIBP_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulRemoteBillsPayCEBECOIII();

        }
    }
    //BILLS PAY CANCELLATION PAG-IBIG PARTNER
    @Test(dependsOnMethods = "loginGoogle", priority = 56, description = "To validate PAG-IBIG PARTNER successful Bills Pay Cancellation ")
    public void BPPagibigCancellation_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulBillsPayPagibig();
            this.billsPayCancellationPagibigSteps.validateSuccessfulBillsPayCancellationPAGIBIGPartner();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 57, description = "To validate remote successful Bills Pay Cancellation PAG-IBIG PARTNER")
    public void BPPagibigCancellation_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulRemoteBillsPayPagibig();
            this.billsPayCancellationPagibigSteps.validateSuccessfulRemoteBillsPayCancellationPAGIBIGPartner();
        }
    }
    //BILLS PAY CANCELLATION CEBECO III PARTNER
    @Test(dependsOnMethods = "loginGoogle", priority = 58, description = "To validate CEBECO III PARTNER successful Bills Pay Cancellation ")
    public void BPCEBECOCancellation_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulBillsPayCEBECOIII();
            this.billsPayCancellationCebecoSteps.validateSuccessfulBillsPayCancellationCEBECOPartner();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 59, description = "To validate remote successful Bills Pay Cancellation CEBECO III PARTNER")
    public void BPCEBECOCancellation_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateSuccessfulRemoteBillsPayNORDECO();
            this.billsPayCancellationCebecoSteps.validateSuccessfulRemoteBillsPayCancellationCEBECOPartner();
        }
    }
    //BILLS PAY CHANGE DETAILS PAG-IBIG PARTNER
    @Test(dependsOnMethods = "loginGoogle", priority = 60, description = "To validate successful BillsPay Change Details PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulBillsPayPagibig();
            this.billsPayChangeDPagibigSteps.validateSuccessfulBillsPayPAGIBIGChangeDetails();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 61, description = "To validate successful remote BillsPay Change Details PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulRemoteBillsPayPagibig();
            this.billsPayChangeDPagibigSteps.validateSuccessfulBillsPayRemotePAGIBIGChangeDetails();
        }
    }
    //BILLS PAY CHANGE DETAILS CEBECO III PARTNER
    @Test(dependsOnMethods = "loginGoogle", priority = 62, description = "To validate successful BillsPay Change Details CEBECO Partner")
    public void BPCEBECO_ChangeDetails_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulBillsPayCEBECOIII();
            this.billsPayChangeCEBECOIIISteps.validateSuccessfulBillsPayCEBECOChangeDetails();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 63, description = "To validate successful remote BillsPay Change Details Nordeco Partner")
    public void BPCEBECO_ChangeDetails_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulRemoteBillsPayCEBECOIII();
            this.billsPayChangeCEBECOIIISteps.validateSuccessfulBillsPayRemoteCEBECOChangeDetails();
        }
    }
    //BILLS PAY REPRINTING PAG-IBIG PARTNER
    @Test(dependsOnMethods = "loginGoogle", priority = 64, description = "To validate BillsPay Successful Payment Reprint Pagibig Partner")
    public void BPPagibig_RP_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulBillsPayPagibig();
            this.billsPayReprintingPagibigSteps.validateSuccessfulBillsPayPagibigReprinting();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 65, description = "To validate BillsPay Successful Remote Payment Reprint Pagibig Partner")
    public void BPPagibig_RP_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulRemoteBillsPayPagibig();
            this.billsPayReprintingPagibigSteps.validateSuccessfulRemoteBillsPayPagibigReprinting();
        }
    }

    //BILLS PAY REPRINTING CEBECO III PARTNER
    @Test(dependsOnMethods = "loginGoogle", priority = 66, description = "To validate BillsPay Successful Payment Reprint CEBECO III Partner")
    public void BPCEBECO_RP_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulBillsPayCEBECOIII();
            this.billsPayReprintingCebecoSteps.validateSuccessfulBillsPayCEBECOReprinting();
        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 67, description = "To validate BillsPay Successful Remote Payment Reprint CEBECO III Partner")
    public void BPCEBECO_RP_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulRemoteBillsPayCEBECOIII();
            this.billsPayReprintingCebecoSteps.validateSuccessfulRemoteBillsPayCEBECOReprinting();

        }
    }



    @Test(dependsOnMethods = "loginGoogle", priority = 68, description = "To validate BillsPay Successful Remote Payment Reprint")
    public void BP_Reprinting_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingSteps.navigatePayoutPage();
//            this.billsPaySteps.validateSuccessfulRemoteBillsPayTransaction();
            this.billsPayReprintingSteps.validateSuccessfulRemoteBillsPayReprinting();

        }
    }

  //  WALLET SERVICES CASH IN TO OWN ACCOUNT

    @Test(dependsOnMethods = "loginGoogle", priority = 69, description = "Validate Cash In to Own Account Page")
    public void CashInToOwnAcc_TC_01() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsCashInToOwnAccountSteps.CIOA_TC_01();
        }
    }

    //WALLET SERVICES CASH IN ANOTHER ACCOUNT

    @Test(dependsOnMethods = "loginGoogle", priority = 70, description = "To validate successful Cash In to another Account")
    public void CashInAnotherAcc_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsCashInToAnotherAccount.navigateWalletServicesPage();
            this.wsCashInToAnotherAccount.ValidateSuccessCashInToAnotherAccount();

        }

    }

   // WALLET SERVICES CASH OUT
    @Test(dependsOnMethods = "loginGoogle", priority = 71, description = "Validate Cash Out")
    public void CashOut_TC_01() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsCashOutSteps.CO_TC_01();

        }

    }



   // WALLET SERVICES KWARTA PADALA
    @Test(dependsOnMethods = "loginGoogle", priority = 72, description = "Validate To validate successful Wallet Services Kwarta Padala Payout")
    public void KPP_TC_01() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.wsKwartaPadalaPayOutSteps.KPP_TC_01();

        }

    }


    //WALLET SERVICES REPRINTING

    @Test(dependsOnMethods = "loginGoogle", priority = 73, description = "To validate successful WS-Reprint Cash In to Own Account Receipt Reprinting")
    public void WS_RR_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateSuccessfulCashInOwnReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 74, description = "To validate successful WS-Reprint Cash In to Another Account Receipt Reprinting")
    public void WS_RR_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateSuccessfulCashInAnotherAccReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 75, description = "To validate successful WS-ReprintCash Out Receipt Reprinting")
    public void WS_RR_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateSuccessfulCashOutReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 76, description = "To validate successful WS-Reprint Kwarta Padala Payout Receipt Reprinting")
    public void WS_RR_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.wsReprintingSteps.navigateWalletServicesPage();
            this.wsReprintingSteps.validateSuccessfulKPPayoutReprinting();

        }

    }

}
