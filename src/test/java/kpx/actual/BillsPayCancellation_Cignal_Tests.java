package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayCancellation_Cignal_Tests extends BaseTest {
    //  B I L L S  P A Y  C I G N A L   C A N C E L L A T I O N
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful Bills Pay Cancellation ")
    public void BPCignalCancellation_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateSuccessfulBillsPayCignal();
            this.billsPayCancellationSteps.validateSuccessfulBillsPayCancellation();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate remote successful Bills Pay Cancellation ")
    public void BPCignalCancellation_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCignalSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateSuccessfulRemoteBillsPayCignal();
            this.billsPayCancellationSteps.validateSuccessfulRemoteBillsPayCancellation();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Empty Reference Bills Pay Cancellation ")
    public void BPCignalCancellation_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationSteps.navigatePayoutPage();
            this.billsPayCancellationSteps.validateEmptyRefBillsPayCancellation();

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Invalid Reference Bills Pay Cancellation ")
    public void BPCignalCancellation_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationSteps.navigatePayoutPage();
            this.billsPayCancellationSteps.validateInvalidRefBillsPayCancellation();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancelled Reference Bills Pay Transaction ")
    public void BPCignalCancellation_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationSteps.navigatePayoutPage();
            this.billsPayCancellationSteps.validateCancelledBillsPayRefNum();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Invalid IR number Bills Pay Transaction ")
    public void BPCignalCancellation_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationSteps.navigatePayoutPage();
            this.billsPayCancellationSteps.validateCancelledBillsPayInvalidIRNumber();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate No Reason Bills Pay Transaction ")
    public void BPCignalCancellation_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationSteps.navigatePayoutPage();
            this.billsPayCancellationSteps.validateCancelledBillsPayNoReason();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate NO IR number Bills Pay Transaction ")
    public void BPCignalCancellation_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationSteps.navigatePayoutPage();
            this.billsPayCancellationSteps.validateCancelledBillsPayNoIRNumber();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate NO Initiated By Bills Pay Transaction ")
    public void BPCignalCancellation_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationSteps.navigatePayoutPage();
            this.billsPayCancellationSteps.validateCancelledBillsPayNoInitiatedBy();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate Keep Transaction By Bills Pay Transaction ")
    public void BPCignalCancellation_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationSteps.navigatePayoutPage();
            this.billsPayCancellationSteps.validateCancelledBillsPayKeepTransaction();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate Stay Transaction By Bills Pay Transaction ")
    public void BPCignalCancellation_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayCancellationSteps.navigatePayoutPage();
            this.billsPayCancellationSteps.validateCancelledBillsPayStayInPage();

        }

    }



}
