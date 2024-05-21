package mlkpx.testSteps;

import utilities.Logger.LoggingUtils;

public class BillsPayReprinting_Steps extends Base_Steps{
    public void navigatePayoutPage()throws Exception{
        try{
            click(billsPayPageObjects.billsPay_link(), "Bills Pay");
            if(isVisible(billsPayPageObjects.billsPay_h2(), getText(billsPayPageObjects.billsPay_h2()))){
                LoggingUtils.info("Navigated to Bills Pay Page");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Bills Pay Page "+ e);
        }
    }
    //B I L L S  P A Y    R E P R I N T I N G
    public void validateSuccessfulBillsPayReprinting()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        waitSleep(3000);
        reader.refreshTestData();
        waitSleep(3000);
        String BillsPayKPTN = reader.getBillsPayKPTN();
        type(billsPayPageObjects.RefNum(), "Reference Number",BillsPayKPTN);
        type(billsPayPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testings");
        click(billsPayPageObjects.Reprint(), "Search Button");
        if(isVisible(billsPayPageObjects.ReprintBillsReceipt(), getText(billsPayPageObjects.ReprintBillsReceipt()))){
            LoggingUtils.info("Navigated the Bills Pay Reprint Receipt page");
            click(billsPayPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing BillsPay Receipt");

        }
    }
    public void validateSuccessfulRemoteBillsPayReprinting()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        waitSleep(3000);
        reader.refreshTestData();
        waitSleep(3000);
        String RemoteBillsPayKPTN = reader.getRemoteBillsPayKPTN();
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
    public void validateInvalidKTPNBillsPayReprinting()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        type(billsPayPageObjects.RefNum(), "Reference Number","KBPTLFFEFUPGI");
        type(billsPayPageObjects.ReasonReprinting(), "Reason for Reprinting ", "Testings");
        click(billsPayPageObjects.Reprint(), "Search Button");
        assertEqual(getText(billsPayPageObjects.NoTransactionFound()), "Bills Payment transaction could not be found. Please check the reference no. and try again.");

    }
    public void validateEmptyRefBillsPayReprinting()throws Exception{
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
    public void validateEmptyReasonBillsPayReprinting()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        type(billsPayPageObjects.RefNum(), "Reference Number","KBPTLERSPGI");
        type(billsPayPageObjects.ReasonReprinting(), "Reason for Reprinting ", "");
        click(billsPayPageObjects.Reprint(), "Search Button");
        assertEqual(getText(billsPayPageObjects.ReasonRequired()), "Reason is required");

    }
    public void validateOnlyLettersBillsPayReprinting()throws Exception{
        waitSleep(2000);
        scrollToElement(billsPayPageObjects.BPReprinting());
        click(billsPayPageObjects.BPReprinting(), "Bills Pay Reprinting");
        if(isVisible(billsPayPageObjects.BillsPayPrint(), getText(billsPayPageObjects.BillsPayPrint()))) {
            LoggingUtils.info("Navigated the BillsPay Reprinting page");
        }
        type(billsPayPageObjects.RefNum(), "Reference Number","KBPTLERSPGI");
        type(billsPayPageObjects.ReasonReprinting(), "Reason for Reprinting ", "466Testings");
        click(billsPayPageObjects.Reprint(), "Search Button");
        assertEqual(getText(billsPayPageObjects.OnlyLettersP()), "Only letters are allowed.");

    }

}
