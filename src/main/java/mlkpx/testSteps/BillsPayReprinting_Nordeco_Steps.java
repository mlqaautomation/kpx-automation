package mlkpx.testSteps;

import utilities.Logger.LoggingUtils;

public class BillsPayReprinting_Nordeco_Steps extends Base_Steps{
    public void navigatePayoutPage()throws Exception{
        try{
            waitSleep(2000);
            scrollToElement(billsPayPageObjects.billsPay_link());
            click(billsPayPageObjects.billsPay_link(), "Bills Pay");
            if(isVisible(billsPayPageObjects.billsPay_h2(), getText(billsPayPageObjects.billsPay_h2()))){
                LoggingUtils.info("Navigated to Bills Pay Page");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Bills Pay Page "+ e);
        }
    }
    //B I L L S  P A Y   N O R D E C O  R E P R I N T I N G
    public void validateSuccessfulBillsPayNORDECOReprinting()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "NORDECO Partner Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        waitSleep(3000);
        reader.refreshTestData();
        waitSleep(3000);
        String BillsPayKPTNNordeco = reader.getBillsPayNordecoKPTN();
        type(billsPayPageObjects.RefNum(), "Reference Number",BillsPayKPTNNordeco);
        type(billsPayPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testings");
        click(billsPayPageObjects.Reprint(), "Search Button");
        if(isVisible(billsPayPageObjects.ReprintBillsReceipt(), getText(billsPayPageObjects.ReprintBillsReceipt()))){
            LoggingUtils.info("Navigated the Bills Pay Reprint Receipt page");
            click(billsPayPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing BillsPay Receipt");

        }
    }
    public void validateSuccessfulRemoteBillsPayNORDECOReprinting()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "NORDECO Partner Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        waitSleep(3000);
        reader.refreshTestData();
        waitSleep(3000);
        String RemoteBillsPayKPTN = reader.getRemoteBillsPayCEBECOKPTN();
        type(billsPayPageObjects.RefNum(), "Reference Number",RemoteBillsPayKPTN);
        type(billsPayPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testings");
        click(billsPayPageObjects.Reprint(), "Search Button");
        if(isVisible(billsPayPageObjects.ReprintBillsReceipt(), getText(billsPayPageObjects.ReprintBillsReceipt()))){
            LoggingUtils.info("Navigated the Bills Pay Reprint Receipt page");
            click(billsPayPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing Remote BillsPay Receipt");

        }
    }
    public void validateInvalidKTPNBillsPayNORDECOReprinting()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        type(billsPayPageObjects.RefNum(), "Reference Number","KBPTLFFETRFUPGI");
        type(billsPayPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testings");
        click(billsPayPageObjects.Reprint(), "Search Button");
        assertEqual(getText(billsPayPageObjects.NoTransactionFound()), "No Transaction Found");
        LoggingUtils.info("No Transaction Found\n" +
                "Bills Payment transaction could not be found. Please check the reference no. and try again.");


    }
    public void validateEmptyRefBillsPayNORDECOReprinting()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        type(billsPayPageObjects.RefNum(), "Reference Number","");
        click(billsPayPageObjects.Reprint(), "Search Button");
        assertEqual(getText(billsPayPageObjects.RefRequired()), "Reference number is required");

    }
    public void validateEmptyReasonBillsPayNORDECOReprinting()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        type(billsPayPageObjects.RefNum(), "Reference Number","KBPYZYPRMEU");
        type(billsPayPageObjects.ReasonReprinting(), "Reason for Reprinting ", "");
        click(billsPayPageObjects.Reprint(), "Search Button");
        assertEqual(getText(billsPayPageObjects.ReasonRequired()), "Reason is required");

    }
    public void validateOnlyLettersBillsPayNORDECOReprinting()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        type(billsPayPageObjects.RefNum(), "Reference Number","KBPYZYPRMEU");
        type(billsPayPageObjects.ReasonReprinting(), "Reason for Reprinting ", "466Testings");
        click(billsPayPageObjects.Reprint(), "Search Button");
        assertEqual(getText(billsPayPageObjects.OnlyLettersP()), "Only letters are allowed.");

    }

}
