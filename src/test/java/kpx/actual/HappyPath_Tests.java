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
    // SENDOUT TRANSACTION
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To Validate Submit SendOut Transaction")
    public void DSendout_TC_8() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.sendOutSteps.DS_TC_08();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Verify SendOut Transaction Option Valid Branch Code")
    public void DSendout_TC_02_1()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendOutSteps.DS_TC_02_1();
        }
    }
    //SENDOUT CANCELLATION
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Verify Navigation of SendOut Cancellation and Cancellation of Transaction")
    public void DSendOutCancellation()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.sendOutCancellationSteps.DS_TC_08();
            this.sendOutCancellationSteps.SOC_TC_01();
        }

    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "Verify Navigation of SendOut remote Cancellation and Cancellation of Transaction")
    public void DSendOutRemoteCancellation()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.sendOutCancellationSteps.DS_TC_02_1();
            this.sendOutCancellationSteps.SOC_TC_1_01();
        }

    }

   // SENDOUT REQUEST FOR CHANGE
    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "Verify Navigation of Request for Change Page and can Request for Change")
    public void SendoutRequestForChange_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendOutSteps.DS_TC_08();
            this.requestForChangeSteps.RFC_TC_01();
        }
    }
    //SENDOUT RETURN TO SENDER
    @Test(dependsOnMethods = "loginGoogle" , priority = 4, description = "Verify Navigation of Return To Sender Page")
    public void SendoutReturnToSender_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendOutSteps.DS_TC_08();
            this.returnToSenderSteps.RTS_TC_01();
        }
    }
    //SENDOUT SO REPRINTING
    @Test(dependsOnMethods = "loginGoogle" , priority = 5, description = "Validate SO Reprinting")
    public void SendoutSOReprinting()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.soReprintingSteps.SOR_TC_01();

        }
    }
    //SENDOUT OR REPRINTING
    @Test(dependsOnMethods = "loginGoogle" , priority = 6, description = "Validate OR Reprinting")
    public void SendoutORReprinting()throws Exception{
        if(this.homeSteps.isInHomePage()) {
            this.orReprintingSteps.OR_TC_01();

        }

    }

    //PAYOUT TRANSACTION
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "Successful domestic payout transaction")
    public void Payout_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendOutSteps.DS_TC_08();
            this.payoutSteps.navigatePayoutPage();
            this.payoutSteps.validateSuccessfulDomesticPayout();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "Successful remote domestic payout transaction")
    public void Payout_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendOutSteps.DS_TC_02_1();
            this.payoutSteps.navigatePayoutPage();
            this.payoutSteps.validateSuccessfulRemoteDomesticPayout();
        }
    }
    ///PAYOUT CANCELLATION
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "Validate successful payout cancellation")
    public void Payout_TC_Cancellation_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendOutSteps.DS_TC_08();
            this.payoutSteps.navigatePayoutPage();
            this.payoutSteps.validateSuccessfulDomesticPayout();
            this.payoutCancellationSteps.validateSuccessfulPayoutCancellation();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "Validate remote successful payout cancellation")
    public void Payout_TC_Cancellation_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendOutSteps.DS_TC_02_1();
            this.payoutSteps.navigatePayoutPage();
            this.payoutSteps.validateSuccessfulRemoteDomesticPayout();
            this.payoutCancellationSteps.validateRemoteSuccessfulPayoutCancellation();

        }
    }
  //  PAYOUT REPRINTING
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate successful payout reprinting transaction")
    public void Payout_TC_Reprinting_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutReprintingSteps.navigatePayoutPage();
            this.payoutReprintingSteps.validateSuccessfulPayoutReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate successful remote payout reprinting transaction")
    public void Payout_TC_Reprinting_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutReprintingSteps.navigatePayoutPage();
            this.payoutReprintingSteps.validateSuccessfulRemotePayoutReprinting();

        }

    }



    //BILLS PAY SENDOUT
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate successful bills payment transaction")
    public void BillsPay_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulBillsPayTransaction();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate successful remote bills payment transaction")
    public void BillsPay_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPaySteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulRemoteBillsPayTransaction();

        }

    }
    //BILLS PAY CANCELLATION
    @Test(dependsOnMethods = "loginGoogle", priority = 14, description = "To validate successful Bills Pay Cancellation ")
    public void BPCancellation_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationSteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulBillsPayTransaction();
            this.billsPayCancellationSteps.validateSuccessfulBillsPayCancellation();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 14, description = "To validate remote successful Bills Pay Cancellation ")
    public void BPCancellation_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationSteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulRemoteBillsPayTransaction();
            this.billsPayCancellationSteps.validateSuccessfulRemoteBillsPayCancellation();

        }

    }
    //BILLS PAY CHANGE DETAILS
    @Test(dependsOnMethods = "loginGoogle", priority = 15, description = "To validate successful BillsPay Change Details")
    public void BP_ChangeDetails_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulBillsPayTransaction();
            this.billsPayChangeDSteps.validateSuccessfulBillsPayChangeDetails();
        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 15, description = "To validate successful remote BillsPay Change Details")
    public void BP_ChangeDetails_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulRemoteBillsPayTransaction();
            this.billsPayChangeDSteps.validateSuccessfulBillsPayRemoteChangeDetails();

        }
    }
    //BILLS PAY REPRINTING
    @Test(dependsOnMethods = "loginGoogle", priority = 16, description = "To validate BillsPay Successful Payment Reprint")
    public void BP_Reprinting_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingSteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulBillsPayTransaction();
            this.billsPayReprintingSteps.validateSuccessfulBillsPayReprinting();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 17, description = "To validate BillsPay Successful Remote Payment Reprint")
    public void BP_Reprinting_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayReprintingSteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulRemoteBillsPayTransaction();
            this.billsPayReprintingSteps.validateSuccessfulRemoteBillsPayReprinting();

        }
    }
//
//   // WALLET SERVICES CASH IN TO OWN ACCOUNT
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 18, description = "Validate Cash In to Own Account Page")
//    public void CIOA_TC_01() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.wsCashInToOwnAccountSteps.CIOA_TC_01();
//        }
//    }
//
//    //WALLET SERVICES CASH IN ANOTHER ACCOUNT
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 19, description = "To validate successful Cash In to another Account")
//    public void CashInAnotherAcc_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.wsCashInToAnotherAccount.navigateWalletServicesPage();
//            this.wsCashInToAnotherAccount.ValidateSuccessCashInToAnotherAccount();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 20, description = "To validate remote successful Cash In to another Account")
//    public void CashInAnotherAcc_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.wsCashInToAnotherAccount.navigateWalletServicesPage();
//            this.wsCashInToAnotherAccount.ValidateRemoteSuccessCashInToAnotherAccount();
//
//        }
//
//    }
//
//    //WALLET SERVICES CASH OUT
//    @Test(dependsOnMethods = "loginGoogle", priority = 21, description = "Validate Cash Out")
//    public void CO_TC_01() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.wsCashOutSteps.CO_TC_01();
//
//        }
//
//    }
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 22, description = "Validate verify remote Cash Out")
//    public void CO_TC_08() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.wsCashOutSteps.CO_TC_08();
//
//        }
//
//    }
//
//
//    //WALLET SERVICES KWARTA PADALA
//    @Test(dependsOnMethods = "loginGoogle", priority = 23, description = "Validate To validate successful Wallet Services Kwarta Padala Payout")
//    public void KPP_TC_01() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.wsKwartaPadalaPayOutSteps.KPP_TC_01();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 24, description = "Validate To validate successful remote Wallet Services Kwarta Padala Payout")
//    public void KPP_TC_02() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.wsKwartaPadalaPayOutSteps.KPP_TC_02();
//
//        }
//    }
//
//
//    //WALLET SERVICES REPRINTING
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 25, description = "To validate successful WS-Reprint Cash In to Own Account Receipt Reprinting")
//    public void WS_RR_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.wsReprintingSteps.navigateWalletServicesPage();
//            this.wsReprintingSteps.validateSuccessfulCashInOwnReprinting();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 26, description = "To validate successful WS-Reprint Cash In to Another Account Receipt Reprinting")
//    public void WS_RR_TC_05()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.wsReprintingSteps.navigateWalletServicesPage();
//            this.wsReprintingSteps.validateSuccessfulCashInAnotherAccReprinting();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 27, description = "To validate successful WS-ReprintCash Out Receipt Reprinting")
//    public void WS_RR_TC_09()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.wsReprintingSteps.navigateWalletServicesPage();
//            this.wsReprintingSteps.validateSuccessfulCashOutReprinting();
//
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 28, description = "To validate successful WS-Reprint Kwarta Padala Payout Receipt Reprinting")
//    public void WS_RR_TC_13()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.wsReprintingSteps.navigateWalletServicesPage();
//            this.wsReprintingSteps.validateSuccessfulKPPayoutReprinting();
//
//        }
//
//    }

}
