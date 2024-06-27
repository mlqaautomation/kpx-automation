package mlkpx.testSteps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;

public class BillsPayReport_Steps extends Base_Steps{

    public void navigationForBillspayCancellationReport() throws Exception {
        click(billsPayReportPageObjects.billspayReportPage(), "Billspay Report Page ");
        click(billsPayReportPageObjects.billspayCancellationReportPage(), "Billspay Cancellation Report Page ");

        if (isVisible(billsPayReportPageObjects.billspayBranchTransactionText(), getText(billsPayReportPageObjects.billspayBranchTransactionText()))) {
            ExtentReporter.logPass("navigationForBillspayBranchTransactionReport", "Successfully Navigate to Cancellation Report");
        } else {
            ExtentReporter.logFail("navigationForBillspayBranchTransactionReport", "Failed to Navigate to Cancellation Report");
            Assert.fail("Failed to Navigate to Cancellation Report");
        }
    }
    public void navigationForBillspayBranchTransactionReport() throws Exception {
        click(billsPayReportPageObjects.billspayReportPage(), "Billspay Report Page ");
        click(billsPayReportPageObjects.billspayBranchTransactionReportPage(), "Billspay Branch Transaction Report Page ");

        if (isVisible(billsPayReportPageObjects.billspayBranchTransactionText(), getText(billsPayReportPageObjects.billspayBranchTransactionText()))) {
            ExtentReporter.logPass("navigationForBillspayCancellationReport", "Successfully Navigate to Branch Transaction Report");
        } else {
            ExtentReporter.logFail("navigationForBillspayCancellationReport", "Failed to Navigate to Branch Transaction Report");
            Assert.fail("Failed to Navigate to Branch Transaction Report");
        }
    }

    public void BP_BTR_TC_01() throws Exception {
        navigationForBillspayBranchTransactionReport();
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Month - Date From Dropdown Button", propertyReader.getproperty("monthDaily"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Date - Date From Dropdown Button", propertyReader.getproperty("DateDaily"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Year - Date From Dropdown Button", propertyReader.getproperty("yearDaily"));
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        if (isVisible(billsPayReportPageObjects.okButton(), getText(billsPayReportPageObjects.okButton()))) {
            ExtentReporter.logPass("navigationForBillspayBranchTransactionReport", "Successfully Navigate to Cancellation Report");
        } else {
            ExtentReporter.logFail("navigationForBillspayBranchTransactionReport", "Failed to Navigate to Cancellation Report");
            Assert.fail("Failed to Navigate to Cancellation Report");
        }
    }
    public void BP_BTR_TC_02() throws Exception {
        navigationForBillspayBranchTransactionReport();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        if (isVisible(billsPayReportPageObjects.invalidDateText(), getText(billsPayReportPageObjects.invalidDateText()))) {
            ExtentReporter.logPass("BP_BTR_TC_02", "Successfully verify generating BillsPay Branch Transaction Report with no date Provided");
        } else {
            ExtentReporter.logFail("BP_BTR_TC_02", "Failed to verify generating BillsPay Branch Transaction Report with no date Provided");
            Assert.fail("Failed to verify generating BillsPay Branch Transaction Report with no date Provided");
        }

    }
    public void BP_BTR_TC_03() throws Exception {
        navigationForBillspayBranchTransactionReport();
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Month Dropdown Button", propertyReader.getproperty("monthFutureB"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Date Dropdown Button", propertyReader.getproperty("dateFutureB"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Year Dropdown Button", propertyReader.getproperty("yearFutureB"));
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        if (isVisible(billsPayReportPageObjects.futureDateTExt(), getText(billsPayReportPageObjects.futureDateTExt()))) {
            ExtentReporter.logPass("BP_BTR_TC_03", "Successfully verify generating BillsPay Branch Transaction Report with future date");
        } else {
            ExtentReporter.logFail("BP_BTR_TC_03", "Failed to verify generating BillsPay Branch Transaction Report with future date");
            Assert.fail("Failed to verify generating BillsPay Branch Transaction Report with future date");
        }
    }
    public void BP_BTR_TC_04() throws Exception {
        navigationForBillspayBranchTransactionReport();
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Month Dropdown Button", propertyReader.getproperty("monthNoReports"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Date Dropdown Button", propertyReader.getproperty("dayNoReports"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Year Dropdown Button", propertyReader.getproperty("yearNoReports"));
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        if (isVisible(billsPayReportPageObjects.noReportsGenerate(), getText(billsPayReportPageObjects.noReportsGenerate()))) {
            ExtentReporter.logPass("BP_BTR_TC_04", "Successfully verify no reports generated");
        } else {
            ExtentReporter.logFail("BP_BTR_TC_04", "Failed to verify no reports generated");
            Assert.fail("Failed to verify no reports generated");
        }
        click(billsPayReportPageObjects.okButton(),"Ok Button");
    }
    public void BP_BTR_TC_05() throws Exception {
        navigationForBillspayBranchTransactionReport();
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Month - Date From Dropdown Button", propertyReader.getproperty("monthNoReports"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Date - Date From Dropdown Button", propertyReader.getproperty("dayNoReports"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Year - Date From Dropdown Button", propertyReader.getproperty("yearNoReports"));
        click(billsPayReportPageObjects.clearButtonB(),"Clear button");
    }





}
