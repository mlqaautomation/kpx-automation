package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayCancellation_Nordeco_Tests extends BaseTest {
    //  B I L L S  P A Y   N O R D E C O   C A N C E L L A T I O N
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate NORDECO PARTNER successful Bills Pay Cancellation ")
    public void BPNordecoCancellation_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateSuccessfulBillsPayNORDECO();
            this.billsPayCancellationNordecoSteps.validateSuccessfulBillsPayCancellationNORDECOPartner();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate remote successful Bills Pay Cancellation NORDECO PARTNER")
    public void BPNordecoCancellation_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayNordecoSteps.navigatePayoutPage();
            this.billsPayNordecoSteps.validateSuccessfulRemoteBillsPayNORDECO();
            this.billsPayCancellationNordecoSteps.validateSuccessfulRemoteBillsPayCancellationNORDECOPartner();
        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Empty Reference Bills Pay Cancellation NORDECO PARTNER")
    public void BPNordecoCancellation_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationNordecoSteps.navigatePayoutPage();
            this.billsPayCancellationNordecoSteps.validateEmptyRefBillsPayCancellationNORDECOPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Invalid Reference Bills Pay Cancellation NORDECO PARTNER")
    public void BPNordecoCancellation_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationNordecoSteps.navigatePayoutPage();
            this.billsPayCancellationNordecoSteps.validateInvalidRefBillsPayCancellationNORDECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancelled Reference Bills Pay Transaction NORDECO PARTNER")
    public void BPNordecoCancellation_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationNordecoSteps.navigatePayoutPage();
            this.billsPayCancellationNordecoSteps.validateCancelledBillsPayRefNumNORDECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Invalid IR number Bills Pay Transaction NORDECO PARTNER")
    public void BPNordecoCancellation_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationNordecoSteps.navigatePayoutPage();
            this.billsPayCancellationNordecoSteps.validateCancelledBillsPayInvalidIRNumberNORDECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate No Reason Bills Pay Transaction NORDECO PARTNER")
    public void BPNordecoCancellation_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationNordecoSteps.navigatePayoutPage();
            this.billsPayCancellationNordecoSteps.validateCancelledBillsPayNoReasonNORDECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate NO IR number Bills Pay Transaction NORDECO PARTNER")
    public void BPNordecoCancellation_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationNordecoSteps.navigatePayoutPage();
            this.billsPayCancellationNordecoSteps.validateCancelledBillsPayNoIRNumberNORDECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate NO Initiated By Bills Pay Transaction NORDECO PARTNER")
    public void BPNordecoCancellation_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationNordecoSteps.navigatePayoutPage();
            this.billsPayCancellationNordecoSteps.validateCancelledBillsPayNoInitiatedByNORDECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate Keep Transaction By Bills Pay Transaction NORDECO PARTNER")
    public void BPNordecoCancellation_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationNordecoSteps.navigatePayoutPage();
            this.billsPayCancellationNordecoSteps.validateCancelledBillsPayKeepTransactionNORDECOPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate Stay Transaction By Bills Pay Transaction NORDECO PARTNER")
    public void BPNordecoCancellation_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationNordecoSteps.navigatePayoutPage();
            this.billsPayCancellationNordecoSteps.validateCancelledBillsPayStayInPageNORDECOPartner();

        }

    }



}
