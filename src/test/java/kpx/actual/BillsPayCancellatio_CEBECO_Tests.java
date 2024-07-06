package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayCancellatio_CEBECO_Tests extends BaseTest {
    //  B I L L S  P A Y   C E B E C O III   C A N C E L L A T I O N
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate CEBECO III PARTNER successful Bills Pay Cancellation ")
    public void BPCEBECOCancellation_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCEBECOIIISteps.navigatePayoutPage();
            this.billsPayCEBECOIIISteps.validateSuccessfulBillsPayCEBECOIII();
            this.billsPayCancellationCebecoSteps.validateSuccessfulBillsPayCancellationCEBECOPartner();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate remote successful Bills Pay Cancellation CEBECO III PARTNER")
    public void BPCEBECOCancellation_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateSuccessfulRemoteBillsPayNORDECO();
            this.billsPayCancellationCebecoSteps.validateSuccessfulRemoteBillsPayCancellationCEBECOPartner();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Empty Reference Bills Pay Cancellation CEBECO III PARTNER")
    public void BPCEBECOCancellation_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationCebecoSteps.navigatePayoutPage();
            this.billsPayCancellationCebecoSteps.validateEmptyRefBillsPayCancellationCEBECOPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Invalid Reference Bills Pay Cancellation CEBECO III PARTNER")
    public void BPCEBECOCancellation_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationCebecoSteps.navigatePayoutPage();
            this.billsPayCancellationCebecoSteps.validateInvalidRefBillsPayCancellationCEBECOPartner();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancelled Reference Bills Pay Transaction CEBECO III PARTNER")
    public void BPCEBECOCancellation_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationCebecoSteps.navigatePayoutPage();
            this.billsPayCancellationCebecoSteps.validateCancelledBillsPayRefNumCEBECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Invalid IR number Bills Pay Transaction CEBECO III PARTNER")
    public void BPCEBECOCancellation_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationCebecoSteps.navigatePayoutPage();
            this.billsPayCancellationCebecoSteps.validateCancelledBillsPayInvalidIRNumberCEBECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate No Reason Bills Pay Transaction CEBECO III PARTNER")
    public void BPCEBECOCancellation_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationCebecoSteps.navigatePayoutPage();
            this.billsPayCancellationCebecoSteps.validateCancelledBillsPayNoReasonCEBECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate NO IR number Bills Pay Transaction CEBECO III PARTNER")
    public void BPCEBECOCancellation_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationCebecoSteps.navigatePayoutPage();
            this.billsPayCancellationCebecoSteps.validateCancelledBillsPayNoIRNumberCEBECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate NO Initiated By Bills Pay Transaction CEBECO III PARTNER")
    public void BPCEBECOCancellation_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationCebecoSteps.navigatePayoutPage();
            this.billsPayCancellationCebecoSteps.validateCancelledBillsPayNoInitiatedByCEBECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate Keep Transaction By Bills Pay Transaction CEBECO III PARTNER")
    public void BPCEBECOCancellation_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationCebecoSteps.navigatePayoutPage();
            this.billsPayCancellationCebecoSteps.validateCancelledBillsPayKeepTransactionCEBECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate Stay Transaction By Bills Pay Transaction CEBECO III PARTNER")
    public void BPCEBECOCancellation_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationCebecoSteps.navigatePayoutPage();
            this.billsPayCancellationCebecoSteps.validateCancelledBillsPayStayInPageCEBECOPartner();

        }

    }



}
