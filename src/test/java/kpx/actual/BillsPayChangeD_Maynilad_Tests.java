package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayChangeD_Maynilad_Tests extends BaseTest {
    //B I L L S  P A Y    C H A N G E  D E T A I L S
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful BillsPay Change Details")
    public void BP_CD_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulBillsPayTransaction();
            this.billsPayChangeDSteps.validateSuccessfulBillsPayChangeDetails();
        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote BillsPay Change Details")
    public void BP_CD_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPaySteps.validateSuccessfulRemoteBillsPayTransaction();
            this.billsPayChangeDSteps.validateSuccessfulBillsPayRemoteChangeDetails();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate BillsPay Change Details No Reference Provided")
    public void BP_CD_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayChangeDSteps.validateBillsPayChangeDetailsNoRef();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate BillsPay Change Details Invalid Reference Provided")
    public void BP_CD_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayChangeDSteps.validateBillsPayChangeDetailsInvalidRef();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate BillsPay Change Details No IR Provided")
    public void BP_CD_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayChangeDSteps.validateBillsPayChangeDetailsNoIR();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate BillsPay Change Details Invalid IR Provided")
    public void BP_CD_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayChangeDSteps.validateBillsPayChangeDetailsInvalidIR();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate BillsPay Change Details No Reason Provided")
    public void BP_CD_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayChangeDSteps.validateBillsPayChangeDetailsNoReason();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Remote BillsPay Change Details No Reason Provided")
    public void BP_CD_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayChangeDSteps.validateBillsPayRemoteChangeDetailsNoReason();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate BillsPay Change Details Not Selecting Initiated Provided")
    public void BP_CD_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayChangeDSteps.validateBillsPayChangeDetailsNoInitiated();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate Keep transaction BillsPay Change Details ")
    public void BP_CD_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayChangeDSteps.validateKeepTransactionBillsPayChangeDetails();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate Stay In Page BillsPay Change Details ")
    public void BP_CD_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayChangeDSteps.validateStayPageBillsPayChangeDetails();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate BillsPay Change Details No Changes")
    public void BP_CD_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayChangeDSteps.validateStayPageBillsPayNoChangeDetails();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate BillsPay Change Details No Letters Allowed")
    public void BP_CD_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayChangeDSteps.validateStayPageBillsPayOnlyLetters();

        }

    }

}
