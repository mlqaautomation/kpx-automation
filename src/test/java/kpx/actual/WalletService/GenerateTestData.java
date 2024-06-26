package kpx.actual.WalletService;

import kpx.base.BaseTest;
import org.testng.annotations.Test;

public class GenerateTestData extends BaseTest{

    @Test(priority = 1 ,description = "First Test to get cash in KPTN")
    public void cashIn1(){
        generateTestData.loginWalletTestData1();
        cashInSteps.cashIn();

    }
    @Test(priority = 2 ,description = "Second Test to get cash in KPTN")
    public void cashIn2(){
        generateTestData.loginWalletTestData2();
        cashInSteps.cashIn();

    }
//    @Test(priority = 3 ,description = "Third Test to get cash in KPTN")
//    public void cashIn3(){
//        generateTestData.loginWalletTestData3();
//        cashInSteps.cashIn();
//
//    }

    @Test(priority = 4 ,description = "First Test to get KwartaPadala KPTN")
    public void kwartaPadala(){
        generateTestData.loginWalletTestData1();
        kwartaPadala.kwartaPadala();
    }
    @Test(priority = 5 ,description = "Second Test to get KwartaPadala KPTN")
    public void kwartaPadala1(){
        generateTestData.loginWalletTestData1();
        kwartaPadala.kwartaPadala1();
    }
    @Test(priority = 6 ,description = "Third Test to get KwartaPadala KPTN")
    public void kwartaPadala2(){
        generateTestData.loginWalletTestData1();
        kwartaPadala.kwartaPadala2();
    }

    @Test(priority = 7 ,description = "First Test to get CashOut KPTN")
    public void cashOut(){
        generateTestData.loginWalletTestData1();
        cashOut.cashOut();

    }
    @Test(priority = 8 ,description = "Second Test to get CashOut KPTN")
    public void cashOut2(){
        generateTestData.loginWalletTestData1();
        cashOut.cashOut2();
    }
    @Test(priority = 9 ,description = "Third Test to get CashOut KPTN")
    public void cashOut3(){
        generateTestData.loginWalletTestData1();
        cashOut.cashOut3();

    }

}
