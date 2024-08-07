package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayIPICEBU_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }
    // B I L L S  P A Y  I P I  - C E B U  S E N D O U T
    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To validate successful bills payment transaction in IPI-CEBU Partner")
    public void BPSendout_IPICEBU_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayIPICEBUSteps.navigatePayoutPage();
            this.billsPayIPICEBUSteps.BPSendout_IPICEBU_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To validate successful remote bills payment transaction in IPI-CEBU Partner")
    public void BPSendout_IPICEBU_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayIPICEBUSteps.navigatePayoutPage();
            this.billsPayIPICEBUSteps.BPSendout_IPICEBU_02();
        }
    }
    // B I L L S  P A Y  I P I  - C E B U  D E T A I L S
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To validate Change Details in IPI-CEBU Partner")
    public void BPChangeDetails_IPICEBU_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayIPICEBUSteps.navigatePayoutPage();
            this.billsPayIPICEBUSteps.BPChangeDetails_IPICEBU_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To validate Change Det ails in IPI-CEBU Partner")
    public void BPChangeDetails_IPICEBU_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayIPICEBUSteps.navigatePayoutPage();
            this.billsPayIPICEBUSteps.BPChangeDetails_IPICEBU_02();
        }
    }

    // B I L L S  P A Y   I P I  - C E B U  C A N C E L L A T I O N
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To validate Cancellation in IPI-CEBU Partner")
    public void BPCancellation_IPICEBU_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayIPICEBUSteps.navigatePayoutPage();
            this.billsPayIPICEBUSteps.BPSendout_IPICEBU_01();
            this.billsPayIPICEBUSteps.BPCancellation_IPICEBU_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To validate Cancellation in IPI-CEBU Partner")
    public void BPCancellation_IPICEBU_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayIPICEBUSteps.navigatePayoutPage();
            this.billsPayIPICEBUSteps.BPSendout_IPICEBU_02();
            this.billsPayIPICEBUSteps.BPCancellation_IPICEBU_02();
        }
    }
    // B I L L S  P A Y   I P I  - C E B U   R E P R I N T I N G
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To validate Reprinting in IPI-CEBU Partner")
    public void BPReprinting_IPICEBU_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayIPICEBUSteps.navigatePayoutPage();
            this.billsPayIPICEBUSteps.BPReprinting_IPICEBU_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To validate Reprinting in IPI-CEBU Partner")
    public void BPReprinting_IPICEBU_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.billsPayIPICEBUSteps.navigatePayoutPage();
            this.billsPayIPICEBUSteps.BPReprinting_IPICEBU_02();
        }
    }




}