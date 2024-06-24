package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class SendoutPartner_Moneygram_Test extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if (this.homeSteps.isInHomePage()) {
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Verify Navigation of Partner Sendout")
    public void navigationForSendOutPartner()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_01();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Verify Sendout Transaction Option valid (Moneygram)")
    public void sendoutTransactionOptionValidBranchCodeMoneygram()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_02();
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "Verify search KYC Sender (Moneygram)")
    public void searchKYCSenderMoneygram()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_03();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 4, description = "Verify Submit Sendout Western Union")
    public void submitSendoutWesternUnion()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_13();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 5, description = "Verify Search Kyc in Sendout Partner Negative Test")
    public void searchKycinSendoutPartnerNegativeTest()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_03_1();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 6, description = "Verify Add New Receiver in Sendout")
    public void addNewReceiverInSendout()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_04();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 7, description = "Verify Add New Receiver in Sendout Negative Test")
    public void addNewReceiverInSendoutNegativeTest()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_04_1();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 8, description = "Verify Search Receiver")
    public void searchReceiver()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_05();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 9, description = "Verify Other information input section")
    public void otherInformation()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_06();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 10, description = "Verify Sendout Information Negative Test Amount")
    public void sendoutInformationNegativeTestAmount()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_07_1();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 11, description = "Verify Sendout Information")
    public void sendoutInformationAmount()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_07();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 12, description = "Verify Sendout Information (10 minute service)")
    public void submitSendoutMoneygram10MinuteService()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_08();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 13, description = "Verify Sendout Information (10 minute service) Remote")
    public void submitSendoutMoneygram10MinuteServiceRemote()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_08_1();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 14, description = "Verify Cancel Transaction")
    public void cancelTransactionMoneygram()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_09_PS_TC_011();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 15, description = "Verify WatchListed KYC")
    public void watchlistedKYC()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_10();
        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 16, description = "Verify WatchListed KYC")
    public void submitSendoutMoneygramAccountDeposit()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_12();
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 17, description = "Verify Submit Sendout Western Union Remote")
    public void submitSendoutWesternUnionRemote()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.sendoutPartnerMoneygramSteps.PS_TC_14();
        }
    }


}
