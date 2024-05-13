package mlkpx.testSteps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;

import java.time.Duration;

public class BillsPayChangeD_Steps extends Base_Steps{
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
    //B I L L S  P A Y    C H A N G E  D E T A I L S
    public void validateSuccessfulBillsPayChangeDetails()throws Exception{
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String BillsPayKPTN = reader.getBillsPayKPTN();
            type(billsPayPageObjects.RefNum(), "KTPN Number",BillsPayKPTN);
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))){
            //Payor Information
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TESTSs");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629355");
            type(billsPayPageObjects.IRNum(), "IR Number", "2111114441262");
            type(billsPayPageObjects.ReasonChange(), "Reason for Change ", "TestingTest");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            click(billsPayPageObjects.YesSaveChanges(), "Yes, Save Changes");
            assertEqual(getText(billsPayPageObjects.SuccessChanges()), "Details have been successfully updated.");
            LoggingUtils.info("Bills Pay Details Updated" +
                    "Details have been successfully updated.");

        }
    }
    public void validateSuccessfulBillsPayRemoteChangeDetails()throws Exception{
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            waitSleep(3000);
            reader.refreshTestData();
            waitSleep(3000);
            String RemoteBillsPayKPTN = reader.getRemoteBillsPayKPTN();
            type(billsPayPageObjects.RefNum(), "KTPN Number",RemoteBillsPayKPTN);
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.PayInformation(), getText(billsPayPageObjects.PayInformation()))){
            click(billsPayPageObjects.RemoteTransaction(), "Remote Transaction");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(billsPayPageObjects.BranchCode()));

            type(billsPayPageObjects.BranchCode(), "Search Branch Code",  propertyReader.getproperty("BranchCode"));
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(13));

            waits.until(ExpectedConditions.elementToBeClickable(billsPayPageObjects.OperatorID()));
            type(billsPayPageObjects.OperatorID(), "Search Operator ID",  propertyReader.getproperty("OperatorID"));
            type(billsPayPageObjects.ReasonRemote(), "Reason", "Testing");
            //Payor Information
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TEST TEST");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING TEST");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL TEST");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629345");
            type(billsPayPageObjects.IRNum(), "IR Number", "2122214441262");
            type(billsPayPageObjects.ReasonChange(), "Reason for Change ", "TestingTest");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            click(billsPayPageObjects.YesSaveChanges(), "Yes, Save Changes");
            assertEqual(getText(billsPayPageObjects.SuccessChanges()), "Details have been successfully updated.");
            LoggingUtils.info("Bills Pay Details Updated" +
                    "Details have been successfully updated.");

        }
    }
    public void validateBillsPayChangeDetailsNoRef()throws Exception{
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","");
            click(billsPayPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(billsPayPageObjects.EmptyRef()), "Reference Number is required");
        }
    }
    public void validateBillsPayChangeDetailsInvalidRef()throws Exception{
        waitSleep(2000);
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPEEEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
            if(isVisible(billsPayPageObjects.InvalidKTPN(), getText(billsPayPageObjects.Page_h5()))){
                assertEqual(getText(billsPayPageObjects.Page_h5()), "No Transaction Found");
            }
            click(billsPayPageObjects.OKButton(), "OK");
        }
    }
    public void validateBillsPayChangeDetailsNoIR()throws Exception{
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.PayInformation(), getText(billsPayPageObjects.PayInformation()))){
            //Payor Information
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TEST");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL Clarin");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629355");
            type(billsPayPageObjects.IRNum(), "IR Number", "");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            assertEqual(getText(billsPayPageObjects.NoIRNum()), "IR Number is required.");

        }
    }
    public void validateBillsPayChangeDetailsInvalidIR()throws Exception{
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.PayInformation(), getText(billsPayPageObjects.PayInformation()))){
            //Payor Information
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TEST");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL Clarin");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629355");
            type(billsPayPageObjects.IRNum(), "IR Number", "4464664");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            assertEqual(getText(billsPayPageObjects.InvalidIRNum()), "Please enter a valid IR No.");

        }
    }
    public void validateBillsPayChangeDetailsNoReason()throws Exception{
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.PayInformation(), getText(billsPayPageObjects.PayInformation()))){
            //Payor Information
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TEST");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL Clarin");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629355");
            type(billsPayPageObjects.IRNum(), "IR Number", "5345555555555");
            type(billsPayPageObjects.ReasonChange(), "Reason for Change ", "");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            assertEqual(getText(billsPayPageObjects.NoReasonChange()), "Reason for Change is required.");

        }
    }
    public void validateBillsPayRemoteChangeDetailsNoReason()throws Exception{
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.PayInformation(), getText(billsPayPageObjects.PayInformation()))){
            click(billsPayPageObjects.RemoteTransaction(), "Remote Transaction");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(billsPayPageObjects.BranchCode()));

            type(billsPayPageObjects.BranchCode(), "Search Branch Code", "12R33A180912");
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(13));

            waits.until(ExpectedConditions.elementToBeClickable(billsPayPageObjects.OperatorID()));
            type(billsPayPageObjects.OperatorID(), "Search Operator ID", "2023639709");
            type(billsPayPageObjects.ReasonRemote(), "Reason", "Testing");
            //Payor Information
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TEST");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL Clarin");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629355");
            type(billsPayPageObjects.IRNum(), "IR Number", "5345555555555");
            type(billsPayPageObjects.ReasonChange(), "Reason for Change ", "");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            assertEqual(getText(billsPayPageObjects.NoReasonChange()), "Reason for Change is required.");

        }
    }
    public void validateBillsPayChangeDetailsNoInitiated()throws Exception{
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.PayInformation(), getText(billsPayPageObjects.PayInformation()))){
            //Payor Information
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TEST");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL Clarin");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629355");
            type(billsPayPageObjects.IRNum(), "IR Number", "5345555555555");
            type(billsPayPageObjects.ReasonChange(), "Reason for Change ", "TestingTest");
            click(billsPayPageObjects.NoInitiatedBy(), "Initiated By");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            LoggingUtils.info("Please select an item in the list display and you can't proceed to change details");

        }
    }
    public void validateKeepTransactionBillsPayChangeDetails()throws Exception{
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.PayInformation(), getText(billsPayPageObjects.PayInformation()))){
            //Payor Information
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TEST");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629355");
            type(billsPayPageObjects.IRNum(), "IR Number", "2111114441262");
            type(billsPayPageObjects.ReasonChange(), "Reason for Change ", "TestingTest");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            click(billsPayPageObjects.CancelChanges(), "Cancel");
            click(billsPayPageObjects.YesKeepTransaction(), "Yes, Keep Transaction");
            LoggingUtils.info("You will return to Bills Pay Change Details" +
                    "Search Transaction");

        }
    }
    public void validateStayPageBillsPayChangeDetails()throws Exception{
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.PayInformation(), getText(billsPayPageObjects.PayInformation()))){
            //Payor Information
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TEST");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629355");
            type(billsPayPageObjects.IRNum(), "IR Number", "2111114441262");
            type(billsPayPageObjects.ReasonChange(), "Reason for Change ", "TestingTest");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            click(billsPayPageObjects.NoCancelChanges(), "No, Keep Transaction");
            LoggingUtils.info("You will stay in the Bills Pay Cancellation" +
                    "Transaction Details");

        }
    }
    public void validateStayPageBillsPayNoChangeDetails()throws Exception{
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.PayInformation(), getText(billsPayPageObjects.PayInformation
                ()))){
            //Payor Information
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TEST TEST");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING TEST");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL TEST");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629345");
            type(billsPayPageObjects.IRNum(), "IR Number", "2122214441262");
            type(billsPayPageObjects.ReasonChange(), "Reason for Change ", "TestingTest");
            click(billsPayPageObjects.InitiatedBy(), "Initiated By");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            assertEqual(getText(billsPayPageObjects.NoEditChanges()), "No Changes Have Been Made");
            LoggingUtils.info("No Changes Have Been Made" +
                    "No detail were changed for this transaction. Do you want to go back and make changes?");

        }
    }
    public void validateStayPageBillsPayOnlyLetters()throws Exception{
        waitSleep(2000);
        click(billsPayPageObjects.BPChangeDetails(), "Bills Pay Change Details");
        if(isVisible(billsPayPageObjects.BillsPayChange(), getText(billsPayPageObjects.BillsPayChange()))) {
            LoggingUtils.info("Navigated the BillsPay Change Details page");
            type(billsPayPageObjects.RefNum(), "KTPN Number","KBPTLEFUPGI");
            click(billsPayPageObjects.SearchButton(), "Search Button");
        }
        if(isVisible(billsPayPageObjects.PayInformation(), getText(billsPayPageObjects.PayInformation
                ()))){
            //Payor Information
            billsPayPageObjects.ChangePayorLastName().clear();
            type(billsPayPageObjects.ChangePayorLastName(), "Payor Last Name", "TEST");
            billsPayPageObjects.ChangePayorFirstName().clear();
            type(billsPayPageObjects.ChangePayorFirstName(), "Payor First Name", "TEST");
            billsPayPageObjects.ChangePayorMiddleName().clear();
            type(billsPayPageObjects.ChangePayorMiddleName(), "Payor Middle Name", "TESTING");
            billsPayPageObjects.ChangePayorAddress().clear();
            type(billsPayPageObjects.ChangePayorAddress(), "Payor Address", "BOHOL");
            billsPayPageObjects.ChangePayorContact().clear();
            type(billsPayPageObjects.ChangePayorContact(), "Payor Contact", "09077629355");
            type(billsPayPageObjects.IRNum(), "IR Number", "2111114441262");
            type(billsPayPageObjects.ReasonChange(), "Reason for Change ", "15345TestingTest");
            click(billsPayPageObjects.SaveChanges(), "Save Changes");
            assertEqual(getText(billsPayPageObjects.OnlyLetters()), "Only letters A-Z, Ñ, - and . are allowed.");

        }
    }
}
