package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayChangeD_Cignal_Tests extends BaseTest {
    //B I L L S  P A Y   C I G N A L   C H A N G E  D E T A I L S
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful BillsPay Change Details Cignal Partners")
    public void BPCignal_ChangeDetails_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateSuccessfulBillsPayCignal();
            this.billsPayChangeDCignalSteps.validateSuccessfulBillsPayCIGNALChangeDetails();
        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote BillsPay Change Details Cignal Partners")
    public void BPCignal_ChangeDetails_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDSteps.navigatePayoutPage();
            this.billsPayCignalSteps.validateSuccessfulRemoteBillsPayCignal();
            this.billsPayChangeDCignalSteps.validateSuccessfulBillsPayCIGNALRemoteChangeDetails();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate BillsPay Change Details No Reference Provided Cignal Partners")
    public void BPCignal_ChangeDetails_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDCignalSteps.navigatePayoutPage();
            this.billsPayChangeDCignalSteps.validateBillsPayChangeDetailsCIGNALNoRef();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate BillsPay Change Details Invalid Reference Provided Cignal Partners")
    public void BPCignal_ChangeDetails_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDCignalSteps.navigatePayoutPage();
            this.billsPayChangeDCignalSteps.validateBillsPayChangeDetailsCIGNALInvalidRef();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate BillsPay Change Details No IR Provided Cignal Partners")
    public void BPCignal_ChangeDetails_TC_05()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDCignalSteps.navigatePayoutPage();
            this.billsPayChangeDCignalSteps.validateBillsPayChangeDetailsCIGNALNoIR();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate BillsPay Change Details Invalid IR Provided Cignal Partners")
    public void BPCignal_ChangeDetails_TC_06()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDCignalSteps.navigatePayoutPage();
            this.billsPayChangeDCignalSteps.validateBillsPayChangeDetailsCIGNALCIGNALInvalidIR();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate BillsPay Change Details No Reason Provided Cignal Partners")
    public void BPCignal_ChangeDetails_TC_07()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDCignalSteps.navigatePayoutPage();
            this.billsPayChangeDCignalSteps.validateBillsPayChangeDetailsCIGNALNoReason();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Remote BillsPay Change Details No Reason Provided Cignal Partners")
    public void BPCignal_ChangeDetails_TC_08()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDCignalSteps.navigatePayoutPage();
            this.billsPayChangeDCignalSteps.validateBillsPayRemoteChangeDetailsCIGNALNoReason();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To validate BillsPay Change Details Not Selecting Initiated Provided Cignal Partners")
    public void BPCignal_ChangeDetails_TC_09()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDCignalSteps.navigatePayoutPage();
            this.billsPayChangeDCignalSteps.validateBillsPayChangeDetailsCIGNALNoInitiated();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To validate Keep transaction BillsPay Change Details Cignal Partners ")
    public void BPCignal_ChangeDetails_TC_10()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDCignalSteps.navigatePayoutPage();
            this.billsPayChangeDCignalSteps.validateKeepTransactionCIGNALBillsPayChangeDetails();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To validate Stay In Page BillsPay Change Details Cignal Partners")
    public void BPCignal_ChangeDetails_TC_11()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDCignalSteps.navigatePayoutPage();
            this.billsPayChangeDCignalSteps.validateStayPageBillsPayCIGNALChangeDetails();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To validate BillsPay Change Details No Changes Cignal Partners")
    public void BPCignal_ChangeDetails_TC_12()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDCignalSteps.navigatePayoutPage();
            this.billsPayChangeDCignalSteps.validateStayPageBillsPayCIGNALNoChangeDetails();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To validate BillsPay Change Details No Letters Allowed Cignal Partners")
    public void BPCignal_ChangeDetails_TC_13()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayChangeDCignalSteps.navigatePayoutPage();
            this.billsPayChangeDCignalSteps.validateStayPageBillsPayCIGNALOnlyLetters();

        }

    }

}
