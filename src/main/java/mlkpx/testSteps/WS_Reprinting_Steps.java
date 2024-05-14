
package mlkpx.testSteps;

import utilities.Logger.LoggingUtils;

public class WS_Reprinting_Steps extends Base_Steps{
    public void navigateWalletServicesPage() throws Exception {
        try {
            click(walletServicesPageObjects.Wallet_link(), "Cash In to Another Account");
            if (isVisible(walletServicesPageObjects.WalletPage_h2(), getText(walletServicesPageObjects.WalletPage_h2()))) {
                LoggingUtils.info("Navigated to Wallet Services Page");
            }
        } catch (Exception e) {
            LoggingUtils.info("Failed to Navigate Wallet Services Page " + e);
        }
    }
    // WALLET SERVICES / RECEIPT REPRINTING / Cash In To Own Account
    public void validateSuccessfulCashInOwnReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.CashInOwnReprinting(), "Cash In to Own Account Receipt");
        if(isVisible(walletServicesPageObjects.CashInOwnPage(), getText(walletServicesPageObjects.CashInOwnPage()))){
            LoggingUtils.info("Navigated the Cash In to Own Account Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","ACIWICTZLCH");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        if(isVisible(walletServicesPageObjects.ReprintCashInOwnReceipt(), getText(walletServicesPageObjects.ReprintCashInOwnReceipt()))){
            LoggingUtils.info("Navigated the Cash In to Own Account Receipt page");
            click(walletServicesPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing Cash In to Own Account receipt");

        }
    }
    public void validateCashInOwnInvalidRefNumReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.CashInOwnReprinting(), "Cash In to Own Account Receipt");
        if(isVisible(walletServicesPageObjects.CashInOwnPage(), getText(walletServicesPageObjects.CashInOwnPage()))){
            LoggingUtils.info("Navigated the Cash In to Own Account Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","ACKWTZLLH");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        assertEqual(getText(walletServicesPageObjects.InvalidRefReprinting()), "Warning");
        LoggingUtils.info("Warning" + "Transaction reference number not found.");

    }
    public void validateCashInOwnCompleteInvalidRefNumReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.CashInOwnReprinting(), "Cash In to Own Account Receipt");
        if(isVisible(walletServicesPageObjects.CashInOwnPage(), getText(walletServicesPageObjects.CashInOwnPage()))){
            LoggingUtils.info("Navigated the Cash In to Own Account Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","ACALDSSQYXH");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        assertEqual(getText(walletServicesPageObjects.CompleteInvalidRefReprinting()), "Wrong transaction type");
        LoggingUtils.info("Wrong transaction type" + "Reference number does not match transaction type.");

    }
    public void validateCashInOwnEmptyRefNumReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.CashInOwnReprinting(), "Cash In to Own Account Receipt");
        if(isVisible(walletServicesPageObjects.CashInOwnPage(), getText(walletServicesPageObjects.CashInOwnPage()))){
            LoggingUtils.info("Navigated the Cash In to Own Account Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        assertEqual(getText(walletServicesPageObjects.EmptyRefReprinting()), "KPTN is required");

    }


    // WALLET SERVICES / RECEIPT REPRINTING / Cash In To Another Account
    public void validateSuccessfulCashInAnotherAccReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.BranchCashInReprinting(), "Cash In to Own Account Receipt");
        if(isVisible(walletServicesPageObjects.BranchCashInPage(), getText(walletServicesPageObjects.BranchCashInPage()))){
            LoggingUtils.info("Navigated the Cash In to Another Account Receipt page");
        }
        String CIAKPTN = reader.getCIAReprintKPTN();
        type(walletServicesPageObjects.RefKTPN(), "Reference Number",CIAKPTN);
        click(walletServicesPageObjects.Reprint(), "Search Button");
        if(isVisible(walletServicesPageObjects.ReprintBranchCashInReceipt(), getText(walletServicesPageObjects.ReprintBranchCashInReceipt()))){
            LoggingUtils.info("Navigated the Cash In to Another Account Receipt page");
            click(walletServicesPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing Cash In to Another Account Receipt");

        }
    }
    public void validateCashInAnotherAccInvalidRefNumReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.BranchCashInReprinting(), "Cash In to Own Account Receipt");
        if(isVisible(walletServicesPageObjects.BranchCashInPage(), getText(walletServicesPageObjects.BranchCashInPage()))){
            LoggingUtils.info("Navigated the Cash In to Another Account Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","ACALDQYXH");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        assertEqual(getText(walletServicesPageObjects.InvalidRefReprinting()), "Warning");
        LoggingUtils.info("Warning" + "Transaction reference number not found.");

    }
    public void validateCashInAnotherAccCompleteInvalidRefNumReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.BranchCashInReprinting(), "Cash In to Own Account Receipt");
        if(isVisible(walletServicesPageObjects.BranchCashInPage(), getText(walletServicesPageObjects.BranchCashInPage()))){
            LoggingUtils.info("Navigated the Cash In to Another Account Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","ACIWICTZLCH");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        assertEqual(getText(walletServicesPageObjects.CompleteInvalidRefReprinting()), "Wrong transaction type");
        LoggingUtils.info("Wrong transaction type" + "Reference number does not match transaction type.");

    }
    public void validateCashInAnotherAccEmptyRefNumReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.BranchCashInReprinting(), "Cash In to Own Account Receipt");
        if(isVisible(walletServicesPageObjects.BranchCashInPage(), getText(walletServicesPageObjects.BranchCashInPage()))){
            LoggingUtils.info("Navigated the Cash In to Another Account Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        assertEqual(getText(walletServicesPageObjects.EmptyRefReprinting()), "KPTN is required");

    }

    // WALLET SERVICES / RECEIPT REPRINTING / Cash Out
    public void validateSuccessfulCashOutReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.CashOutReprinting(), "Cash Out Receipt");
        if(isVisible(walletServicesPageObjects.CashOutPage(), getText(walletServicesPageObjects.CashOutPage()))){
            LoggingUtils.info("Navigated the Cash Out Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","ACONEOMWVSL");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        if(isVisible(walletServicesPageObjects.ReprintCashOutReceipt(), getText(walletServicesPageObjects.ReprintCashOutReceipt()))){
            LoggingUtils.info("Navigated the Cash Out Receipt page");
            click(walletServicesPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing Cash Out Receipt");

        }
    }
    public void validateCashOutInvalidRefNumReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.CashOutReprinting(), "Cash Out Receipt");
        if(isVisible(walletServicesPageObjects.CashOutPage(), getText(walletServicesPageObjects.CashOutPage()))){
            LoggingUtils.info("Navigated the Cash Out Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","ACASQYXH");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        assertEqual(getText(walletServicesPageObjects.InvalidRefReprinting()), "Warning");
        LoggingUtils.info("Warning" + "Transaction reference number not found.");

    }
    public void validateCashOutCompleteInvalidRefNumReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.CashOutReprinting(), "Cash Out Receipt");
        if(isVisible(walletServicesPageObjects.CashOutPage(), getText(walletServicesPageObjects.CashOutPage()))){
            LoggingUtils.info("Navigated the Cash Out Receipt Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","ACALDSSQYXH");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        assertEqual(getText(walletServicesPageObjects.CompleteInvalidRefReprinting()), "Wrong transaction type");
        LoggingUtils.info("Wrong transaction type" + "Reference number does not match transaction type.");

    }
    public void validateCashOutEmptyRefNumReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.CashOutReprinting(), "Cash Out Receipt");
        if(isVisible(walletServicesPageObjects.CashOutPage(), getText(walletServicesPageObjects.CashOutPage()))){
            LoggingUtils.info("Navigated the Cash Out Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        assertEqual(getText(walletServicesPageObjects.EmptyRefReprinting()), "KPTN is required");

    }

    // WALLET SERVICES / RECEIPT REPRINTING / Kwarta Padala Payout
    public void validateSuccessfulKPPayoutReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.KPPayoutReprinting(), "Kwarta Padala Payout Receipt");
        if(isVisible(walletServicesPageObjects.KPPayoutPage(), getText(walletServicesPageObjects.KPPayoutPage()))){
            LoggingUtils.info("Navigated the Kwarta Padala Payout Receipt page");
        }
        String KPKPTN = reader.getKPReprintKPTN();
        type(walletServicesPageObjects.RefKTPN(), "Reference Number",KPKPTN);
        click(walletServicesPageObjects.Reprint(), "Search Button");
        if(isVisible(walletServicesPageObjects.ReprintKPPayoutReceipt(), getText(walletServicesPageObjects.ReprintKPPayoutReceipt()))){
            LoggingUtils.info("Navigated the Kwarta Padala Payout Receipt page");
            click(walletServicesPageObjects.PrintReceipt(), "Print Receipt");
//            click(payoutPageObjects.PrintButton(), "Print");
            LoggingUtils.info("Successful in printing Kwarta Padala Payout Receipt");

        }
    }
    public void validateKPPayoutInvalidRefNumReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.KPPayoutReprinting(), "Kwarta Padala Payout Receipt");
        if(isVisible(walletServicesPageObjects.KPPayoutPage(), getText(walletServicesPageObjects.KPPayoutPage()))){
            LoggingUtils.info("Navigated the Kwarta Padala Payout Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","ACALSQYXH");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        assertEqual(getText(walletServicesPageObjects.InvalidRefReprinting()), "Warning");
        LoggingUtils.info("Warning" +
                "Transaction reference number not found. (version: c4f7d23)");

    }
    public void validateKPPayoutCompleteInvalidRefNumReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.KPPayoutReprinting(), "Kwarta Padala Payout Receipt");
        if(isVisible(walletServicesPageObjects.KPPayoutPage(), getText(walletServicesPageObjects.KPPayoutPage()))){
            LoggingUtils.info("Navigated the Kwarta Padala Payout Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","ACONEOMWVSL");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        assertEqual(getText(walletServicesPageObjects.CompleteInvalidRefReprinting()), "Wrong transaction type");
        LoggingUtils.info("Wrong transaction type" + "Reference number does not match transaction type.");

    }
    public void validateKPPayoutEmptyRefNumReprinting()throws Exception{
        click(walletServicesPageObjects.ReceiptReprinting(), "Wallet Services Receipt Reprinting");
        click(walletServicesPageObjects.KPPayoutReprinting(), "Kwarta Padala Payout Receipt");
        if(isVisible(walletServicesPageObjects.KPPayoutPage(), getText(walletServicesPageObjects.KPPayoutPage()))){
            LoggingUtils.info("Navigated the Kwarta Padala Payout Receipt page");
        }
        type(walletServicesPageObjects.RefKTPN(), "Reference Number","");
        click(walletServicesPageObjects.Reprint(), "Search Button");
        assertEqual(getText(walletServicesPageObjects.EmptyRefReprinting()), "KPTN is required");

    }
}
