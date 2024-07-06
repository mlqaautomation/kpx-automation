package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayChangeD_Pagibig_Tests extends BaseTest {
    //B I L L S  P A Y   P A G - I B I G   C H A N G E  D E T A I L S
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful BillsPay Change Details PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulBillsPayPagibig();
            this.billsPayChangeDPagibigSteps.validateSuccessfulBillsPayPAGIBIGChangeDetails();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote BillsPay Change Details PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayPagbigSteps.navigatePayoutPage();
            this.billsPayPagbigSteps.validateSuccessfulRemoteBillsPayPagibig();
            this.billsPayChangeDPagibigSteps.validateSuccessfulBillsPayRemotePAGIBIGChangeDetails();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate BillsPay Change Details No Reference Provided PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDPagibigSteps.navigatePayoutPage();
            this.billsPayChangeDPagibigSteps.validateBillsPayChangeDetailsPAGIBIGNoRef();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate BillsPay Change Details Invalid Reference Provided PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDPagibigSteps.navigatePayoutPage();
            this.billsPayChangeDPagibigSteps.validateBillsPayChangeDetailsPAGIBIGInvalidRef();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate BillsPay Change Details No IR Provided PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDPagibigSteps.navigatePayoutPage();
            this.billsPayChangeDPagibigSteps.validateBillsPayChangeDetailsPAGIBIGNoIR();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate BillsPay Change Details Invalid IR Provided PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDPagibigSteps.navigatePayoutPage();
            this.billsPayChangeDPagibigSteps.validateBillsPayChangeDetailsPAGIBIGInvalidIR();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate BillsPay Change Details No Reason Provided PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDPagibigSteps.navigatePayoutPage();
            this.billsPayChangeDPagibigSteps.validateBillsPayChangeDetailsPAGIBIGNoReason();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Remote BillsPay Change Details No Reason Provided PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDPagibigSteps.navigatePayoutPage();
            this.billsPayChangeDPagibigSteps.validateBillsPayRemoteChangeDetailsPAGIBIGNoReason();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate BillsPay Change Details Not Selecting Initiated Provided PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDPagibigSteps.navigatePayoutPage();
            this.billsPayChangeDPagibigSteps.validateBillsPayChangeDetailsPAGIBIGNoInitiated();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate Keep transaction BillsPay Change Details PAGIBIG Partner ")
    public void BPPagibig_ChangeDetails_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDPagibigSteps.navigatePayoutPage();
            this.billsPayChangeDPagibigSteps.validateKeepTransactionBillsPayChangeDetailsPAGIBIG();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate Stay In Page BillsPay Change Details PAGIBIG Partner ")
    public void BPPagibig_ChangeDetails_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDPagibigSteps.navigatePayoutPage();
            this.billsPayChangeDPagibigSteps.validateStayPageBillsPayChangeDetailsPAGIBIG();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate BillsPay Change Details No Changes PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDPagibigSteps.navigatePayoutPage();
            this.billsPayChangeDPagibigSteps.validateStayPageBillsPayNoChangeDetailsPAGIBIG();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate BillsPay Change Details No Letters Allowed PAGIBIG Partner")
    public void BPPagibig_ChangeDetails_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDPagibigSteps.navigatePayoutPage();
            this.billsPayChangeDPagibigSteps.validateStayPageBillsPayPAGIBIGOnlyLetters();

        }

    }

}
