package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayZCWATERDISTRICT_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  Z C  W A T E R  D I S T R I C T  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in ZAMBOANGA CITY WATER DISTRICT Partner")
    public void BPSendout_ZCWATERDISTRICT_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayZCWATERDISTRICTSteps.navigatePayoutPage();
            this.billsPayZCWATERDISTRICTSteps.BPSendout_ZCWATERDISTRICT_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in ZAMBOANGA CITY WATER DISTRICT Partner")
    public void BPSendout_ZCWATERDISTRICT_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayZCWATERDISTRICTSteps.navigatePayoutPage();
            this.billsPayZCWATERDISTRICTSteps.BPSendout_ZCWATERDISTRICT_02();
        }
    }
    // B I L L S  P A Y  Z C  W A T E R  D I S T R I C T  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in ZAMBOANGA CITY WATER DISTRICT Partner")
    public void BPChangeDetails_ZCWATERDISTRICT_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayZCWATERDISTRICTSteps.navigatePayoutPage();
            this.billsPayZCWATERDISTRICTSteps.BPChangeDetails_ZCWATERDISTRICT_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in ZAMBOANGA CITY WATER DISTRICT Partner")
    public void BPChangeDetails_ZCWATERDISTRICT_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayZCWATERDISTRICTSteps.navigatePayoutPage();
            this.billsPayZCWATERDISTRICTSteps.BPChangeDetails_ZCWATERDISTRICT_02();
        }
    }

    // B I L L S  P A Y   Z C  W A T E R  D I S T R I C T  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in ZAMBOANGA CITY WATER DISTRICT Partner")
    public void BPCancellation_ZCWATERDISTRICT_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayZCWATERDISTRICTSteps.navigatePayoutPage();
            this.billsPayZCWATERDISTRICTSteps.BPSendout_ZCWATERDISTRICT_01();
            this.billsPayZCWATERDISTRICTSteps.BPCancellation_ZCWATERDISTRICT_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in ZAMBOANGA CITY WATER DISTRICT Partner")
    public void BPCancellation_ZCWATERDISTRICT_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayZCWATERDISTRICTSteps.navigatePayoutPage();
            this.billsPayZCWATERDISTRICTSteps.BPSendout_ZCWATERDISTRICT_02();
            this.billsPayZCWATERDISTRICTSteps.BPCancellation_ZCWATERDISTRICT_02();
        }
    }
    // B I L L S  P A Y   Z C  W A T E R  D I S T R I C T   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in ZAMBOANGA CITY WATER DISTRICT Partner")
    public void BPReprinting_ZCWATERDISTRICT_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayZCWATERDISTRICTSteps.navigatePayoutPage();
            this.billsPayZCWATERDISTRICTSteps.BPReprinting_ZCWATERDISTRICT_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in ZAMBOANGA CITY WATER DISTRICT Partner")
    public void BPReprinting_ZCWATERDISTRICT_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayZCWATERDISTRICTSteps.navigatePayoutPage();
            this.billsPayZCWATERDISTRICTSteps.BPReprinting_ZCWATERDISTRICT_02();
        }
    }




}
