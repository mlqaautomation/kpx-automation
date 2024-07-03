package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayCancellation_Pagibig_Tests extends BaseTest {
    //  B I L L S  P A Y   P A G - I B I G    C A N C E L L A T I O N
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate PAG-IBIG PARTNER successful Bills Pay Cancellation ")
    public void BPPagibigCancellation_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulBillsPayPagibig();
            this.billsPayCancellationPagibigSteps.validateSuccessfulBillsPayCancellationPAGIBIGPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate remote successful Bills Pay Cancellation PAG-IBIG PARTNER")
    public void BPPagibigCancellation_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulRemoteBillsPayPagibig();
            this.billsPayCancellationPagibigSteps.validateSuccessfulRemoteBillsPayCancellationPAGIBIGPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Empty Reference Bills Pay Cancellation PAG-IBIG PARTNER")
    public void BPPagibigCancellation_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationPagibigSteps.navigatePayoutPage();
            this.billsPayCancellationPagibigSteps.validateEmptyRefBillsPayCancellationPAGIBIGPartner();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Invalid Reference Bills Pay Cancellation PAG-IBIG PARTNER")
    public void BPPagibigCancellation_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationPagibigSteps.navigatePayoutPage();
            this.billsPayCancellationPagibigSteps.validateInvalidRefBillsPayCancellationPAGIBIGPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancelled Reference Bills Pay Transaction PAG-IBIG PARTNER")
    public void BPPagibigCancellation_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationPagibigSteps.navigatePayoutPage();
            this.billsPayCancellationPagibigSteps.validateCancelledBillsPayRefNumNPAGIBIGPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Invalid IR number Bills Pay Transaction PAG-IBIG PARTNER")
    public void BPPagibigCancellation_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationPagibigSteps.navigatePayoutPage();
            this.billsPayCancellationPagibigSteps.validateCancelledBillsPayInvalidIRNumberPAGIBIGPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate No Reason Bills Pay Transaction PAG-IBIG PARTNER")
    public void BPPagibigCancellation_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationPagibigSteps.navigatePayoutPage();
            this.billsPayCancellationPagibigSteps.validateCancelledBillsPayNoReasonPAGIBIGPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate NO IR number Bills Pay Transaction PAG-IBIG PARTNER")
    public void BPPagibigCancellation_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationPagibigSteps.navigatePayoutPage();
            this.billsPayCancellationPagibigSteps.validateCancelledBillsPayNoIRNumberPAGIBIGPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate NO Initiated By Bills Pay Transaction PAG-IBIG PARTNER")
    public void BPPagibigCancellation_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationPagibigSteps.navigatePayoutPage();
            this.billsPayCancellationPagibigSteps.validateCancelledBillsPayNoInitiatedByPAGIBIGPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate Keep Transaction By Bills Pay Transaction PAG-IBIG PARTNER")
    public void BPPagibigCancellation_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationPagibigSteps.navigatePayoutPage();
            this.billsPayCancellationPagibigSteps.validateCancelledBillsPayKeepTransactionPAGIBIGPartner();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate Stay Transaction By Bills Pay Transaction PAG-IBIG PARTNER")
    public void BPPagibigCancellation_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationPagibigSteps.navigatePayoutPage();
            this.billsPayCancellationPagibigSteps.validateCancelledBillsPayStayInPagePAGIBIGPartner();

        }

    }



}
