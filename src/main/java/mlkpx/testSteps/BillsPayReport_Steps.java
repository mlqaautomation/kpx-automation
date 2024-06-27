package mlkpx.testSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;

import java.util.List;

public class BillsPayReport_Steps extends Base_Steps{


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
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Month Dropdown Button", propertyReader.getproperty("monthDaily"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Date Dropdown Button", propertyReader.getproperty("DateDaily"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Year Dropdown Button", propertyReader.getproperty("yearDaily"));
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
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Month Dropdown Button", propertyReader.getproperty("monthNoReports"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Date Dropdown Button", propertyReader.getproperty("dayNoReports"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Year Dropdown Button", propertyReader.getproperty("yearNoReports"));
        click(billsPayReportPageObjects.clearButtonB(),"Clear button");
    }



    public void navigationForBillspayCancellationReport() throws Exception {
        click(billsPayReportPageObjects.billspayReportPage(), "Billspay Report Page ");
        click(billsPayReportPageObjects.billspayCancellationReportPage(), "Billspay Cancellation Report Page ");
        if (isVisible(billsPayReportPageObjects.billspayCancellationText(), getText(billsPayReportPageObjects.billspayCancellationText()))) {
            ExtentReporter.logPass("BP-CR_TC_01", "Successfully Navigate to Cancellation Report Page");
        } else {
            ExtentReporter.logFail("BP-CR_TC_01", "Failed to Navigate to Cancellation Report Page");
            Assert.fail("Failed to Navigate to Cancellation Report Page");
        }
    }


    public void BP_CR_TC_02() throws Exception {
        navigationForBillspayCancellationReport();
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        click(billsPayReportPageObjects.billsPaymentCancellationTransactionType(), "Bills Payment Cancellation Transaction Type DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(), "TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedTimeFrameDaily(),"Daily TimeFrame Dropdown Button");
        waitSleep(3000);
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Month Dropdown Button", propertyReader.getproperty("monthReportsC"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Date Dropdown Button", propertyReader.getproperty("dayReportsC"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Year Dropdown Button", propertyReader.getproperty("yearReportsC"));
        waitSleep(3000);
        click(billsPayReportPageObjects.filterDropdown(), "Filter Dropdown Button");
        click(billsPayReportPageObjects.selectedFilterBranch(), "Branch Filter Dropdown Button");
        waitSleep(3000);
        click(billsPayReportPageObjects.branchDropdown(), "Branch Dropdown Button");
        click(billsPayReportPageObjects.misDivision(), "MIS Branch Dropdown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(5000);
        if (isVisible(billsPayReportPageObjects.reportsGenerated(), getText(billsPayReportPageObjects.reportsGenerated()))) {
            ExtentReporter.logPass("BP-CR_TC_02", "Successfully Generate Billspay Cancellation Report Daily");
        } else {
            ExtentReporter.logFail("BP-CR_TC_02", "Failed to Generate Billspay Cancellation Report Daily");
            Assert.fail("Failed to Generate Billspay Cancellation Report Daily");
        }
        click(billsPayReportPageObjects.okButton(),"OK button");
    }

    public void BP_CR_TC_03() throws Exception {
        navigationForBillspayCancellationReport();
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        click(billsPayReportPageObjects.billsPaymentChangeDetailsTransactionType(), "Bills Payment Change Details Transaction Type DropDown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.timeFrame(), "TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedTimeFrameDaily(),"Daily TimeFrame Dropdown Button");
        waitSleep(2000);
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Month Dropdown Button", propertyReader.getproperty("monthReportsC"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Date Dropdown Button", propertyReader.getproperty("dayReportsC"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Year Dropdown Button", propertyReader.getproperty("yearReportsC"));
        waitSleep(2000);
        click(billsPayReportPageObjects.filterDropdown(), "Filter Dropdown Button");
        click(billsPayReportPageObjects.selectedFilterBranch(), "Branch Filter Dropdown Button");
        waitSleep(2000);
        click(billsPayReportPageObjects.branchDropdown(), "Branch Dropdown Button");
        click(billsPayReportPageObjects.misDivision(), "MIS Branch Dropdown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(5000);
        if (isVisible(billsPayReportPageObjects.reportsGenerated(), getText(billsPayReportPageObjects.reportsGenerated()))) {
            ExtentReporter.logPass("BP-CR_TC_03", "Successfully Generate Billspay Change Details Report Daily");
        } else {
            ExtentReporter.logFail("BP-CR_TC_03", "Failed to Generate Billspay Change Details Report Daily");
            Assert.fail("Failed to Generate Billspay Change Details Report Daily");
        }
        click(billsPayReportPageObjects.okButton(),"OK button");
    }
    public void BP_CR_TC_04() throws Exception {
        navigationForBillspayCancellationReport();
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        click(billsPayReportPageObjects.billsPaymentCancellationTransactionType(), "Bills Payment Cancellation Transaction Type DropDown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.timeFrame(), "TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedTimeFrameMonthly(),"Monthly TimeFrame Dropdown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.monthDropDownButton(),"Month DropDown Button");
        click(billsPayReportPageObjects.monthOfJune(),"Month of June");
        waitSleep(2000);
        click(billsPayReportPageObjects.yearDropdown(),"Year Dropdown Button");
        click(billsPayReportPageObjects.year2024(),"Year 2024");
        waitSleep(2000);
        click(billsPayReportPageObjects.filterDropdown(), "Filter Dropdown Button");
        click(billsPayReportPageObjects.selectedFilterBranch(), "Branch Filter Dropdown Button");
        waitSleep(2000);
        click(billsPayReportPageObjects.branchDropdown(), "Branch Dropdown Button");
        click(billsPayReportPageObjects.misDivision(), "MIS Branch Dropdown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(5000);
        if (isVisible(billsPayReportPageObjects.reportsGenerated(), getText(billsPayReportPageObjects.reportsGenerated()))) {
            ExtentReporter.logPass("BP-CR_TC_04", "Successfully Generate Billspay Cancellation Report Monthly");
        } else {
            ExtentReporter.logFail("BP-CR_TC_04", "Failed to Generate Billspay Cancellation Report Monthly");
            Assert.fail("Failed to Generate Billspay Cancellation Report Monthly");
        }
        click(billsPayReportPageObjects.okButton(),"OK button");
    }

    public void BP_CR_TC_05() throws Exception {
        navigationForBillspayCancellationReport();
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        click(billsPayReportPageObjects.billsPaymentChangeDetailsTransactionType(), "Bills Payment Change Details Transaction Type DropDown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.timeFrame(), "TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedTimeFrameMonthly(),"Monthly TimeFrame Dropdown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.monthDropDownButton(),"Month DropDown Button");
        click(billsPayReportPageObjects.monthOfJune(),"Month of June");
        waitSleep(2000);
        click(billsPayReportPageObjects.yearDropdown(),"Year Dropdown Button");
        click(billsPayReportPageObjects.year2024(),"Year 2024");
        waitSleep(2000);
        click(billsPayReportPageObjects.filterDropdown(), "Filter Dropdown Button");
        click(billsPayReportPageObjects.selectedFilterBranch(), "Branch Filter Dropdown Button");
        waitSleep(2000);
        click(billsPayReportPageObjects.branchDropdown(), "Branch Dropdown Button");
        click(billsPayReportPageObjects.misDivision(), "MIS Branch Dropdown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(5000);
        if (isVisible(billsPayReportPageObjects.reportsGenerated(), getText(billsPayReportPageObjects.reportsGenerated()))) {
            ExtentReporter.logPass("BP-CR_TC_05", "Successfully Generate Billspay Change Details Report Monthly");
        } else {
            ExtentReporter.logFail("BP-CR_TC_05", "Failed to Generate Billspay Change Details Report Monthly");
            Assert.fail("Failed to Generate Billspay Change Details Report Monthly");
        }
        click(billsPayReportPageObjects.okButton(),"OK button");
    }

    public void BP_CR_TC_06() throws Exception {
        navigationForBillspayCancellationReport();
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        click(billsPayReportPageObjects.billsPaymentCancellationTransactionType(), "Bills Payment Cancellation Transaction Type DropDown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.timeFrame(), "TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.DateRange(),"Date Range Dropdown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.DateRangeFrom(),"Date From Dropdown Button");
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Year - Date From Dropdown Button", propertyReader.getproperty("yearFrom"));
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Month - Date From Dropdown Button", propertyReader.getproperty("dateFrom"));
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Date - Date From Dropdown Button", propertyReader.getproperty("monthFrom"));
        click(kpDomesticReportsPageObjects.DateRangeTo(),"Date To Dropdown Button");
        type(kpDomesticReportsPageObjects.DateRangeTo(), "", propertyReader.getproperty("yearTo"));
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeTo(), "Date - Date To Dropdown Button", propertyReader.getproperty("dateTo"));
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeTo(), "Month - Date To Dropdown Button", propertyReader.getproperty("monthTo"));
        waitSleep(2000);
        click(billsPayReportPageObjects.filterDropdown(), "Filter Dropdown Button");
        click(billsPayReportPageObjects.selectedFilterBranch(), "Branch Filter Dropdown Button");
        waitSleep(2000);
        click(billsPayReportPageObjects.branchDropdown(), "Branch Dropdown Button");
        click(billsPayReportPageObjects.misDivision(), "MIS Branch Dropdown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(5000);
        if (isVisible(billsPayReportPageObjects.reportsGenerated(), getText(billsPayReportPageObjects.reportsGenerated()))) {
            ExtentReporter.logPass("BP-CR_TC_06", "Successfully Generate Billspay Cancellation Report Date Range");
        } else {
            ExtentReporter.logFail("BP-CR_TC_06", "Failed to Generate Billspay Cancellation Report Date Range");
            Assert.fail("Failed to Generate Billspay Cancellation Report Date Range");
        }
        click(billsPayReportPageObjects.okButton(),"OK button");
    }
    public void BP_CR_TC_07() throws Exception {
        navigationForBillspayCancellationReport();
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        click(billsPayReportPageObjects.billsPaymentChangeDetailsTransactionType(), "Bills Payment Change Details Transaction Type DropDown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.DateRange(),"Date Range Dropdown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.DateRangeFrom(),"Date From Dropdown Button");
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Year - Date From Dropdown Button", propertyReader.getproperty("yearFrom"));
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Month - Date From Dropdown Button", propertyReader.getproperty("dateFrom"));
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Date - Date From Dropdown Button", propertyReader.getproperty("monthFrom"));
        click(kpDomesticReportsPageObjects.DateRangeTo(),"Date To Dropdown Button");
        type(kpDomesticReportsPageObjects.DateRangeTo(), "", propertyReader.getproperty("yearTo"));
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeTo(), "Date - Date To Dropdown Button", propertyReader.getproperty("dateTo"));
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeTo(), "Month - Date To Dropdown Button", propertyReader.getproperty("monthTo"));
        waitSleep(2000);
        click(billsPayReportPageObjects.filterDropdown(), "Filter Dropdown Button");
        click(billsPayReportPageObjects.selectedFilterBranch(), "Branch Filter Dropdown Button");
        waitSleep(2000);
        click(billsPayReportPageObjects.branchDropdown(), "Branch Dropdown Button");
        click(billsPayReportPageObjects.misDivision(), "MIS Branch Dropdown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(5000);
        if (isVisible(billsPayReportPageObjects.reportsGenerated(), getText(billsPayReportPageObjects.reportsGenerated()))) {
            ExtentReporter.logPass("BP-CR_TC_05", "Successfully Generate Billspay Change Details Report Date Range");
        } else {
            ExtentReporter.logFail("BP-CR_TC_05", "Failed to Generate Billspay Change Details Report Date Range");
            Assert.fail("Failed to Generate Billspay Change Details Report Date Range");
        }
        click(billsPayReportPageObjects.okButton(),"OK button");
    }
    public void BP_CR_TC_08() throws Exception {
        navigationForBillspayCancellationReport();
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        click(billsPayReportPageObjects.billsPaymentCancellationTransactionType(), "Bills Payment Cancellation Transaction Type DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(), "TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedTimeFrameDaily(), "Daily TimeFrame Dropdown Button");
        waitSleep(3000);
        click(billsPayReportPageObjects.filterDropdown(), "Filter Dropdown Button");
        click(billsPayReportPageObjects.selectedFilterBranch(), "Branch Filter Dropdown Button");
        waitSleep(3000);
        click(billsPayReportPageObjects.branchDropdown(), "Branch Dropdown Button");
        click(billsPayReportPageObjects.misDivision(), "MIS Branch Dropdown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.generateReportButton(), "Generate Report Button");
        click(kpDomesticReportsPageObjects.generateReportButton(), "Generate Report Button");
        waitSleep(2000);
        if (isVisible(billsPayReportPageObjects.invalidDateText(), getText(billsPayReportPageObjects.invalidDateText()))) {
            ExtentReporter.logPass("BP-CR_TC_08", "Successfully verify no date provided ");
        } else {
            ExtentReporter.logFail("BP-CR_TC_08", "Failed to verify no date provided ");
            Assert.fail("Failed to verify no date provided");
        }
    }


    public void BP_CR_TC_09() throws Exception {
        navigationForBillspayCancellationReport();
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        click(billsPayReportPageObjects.billsPaymentCancellationTransactionType(), "Bills Payment Cancellation Transaction Type DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(), "TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedTimeFrameDaily(), "Daily TimeFrame Dropdown Button");
        waitSleep(3000);
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Month Dropdown Button", propertyReader.getproperty("monthFutureB"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Date Dropdown Button", propertyReader.getproperty("dateFutureB"));
        type(kpDomesticReportsPageObjects.selectedTimeFrameDailyDate(), "Year Dropdown Button", propertyReader.getproperty("yearFutureB"));
        waitSleep(3000);
        click(billsPayReportPageObjects.filterDropdown(), "Filter Dropdown Button");
        click(billsPayReportPageObjects.selectedFilterBranch(), "Branch Filter Dropdown Button");
        waitSleep(3000);
        click(billsPayReportPageObjects.branchDropdown(), "Branch Dropdown Button");
        click(billsPayReportPageObjects.misDivision(), "MIS Branch Dropdown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.generateReportButton(), "Generate Report Button");
        waitSleep(2000);
        if (isVisible(billsPayReportPageObjects.futureDateTExt(), getText(billsPayReportPageObjects.futureDateTExt()))) {
            ExtentReporter.logPass("BP-CR_TC_09", "Successfully verify generating Report with future date");
        } else {
            ExtentReporter.logFail("BP-CR_TC_09", "Failed to verify generating Report with future date");
            Assert.fail("Failed to verify generating Report with future date");
        }
    }

    public void BP_CR_TC_10() throws Exception {
        navigationForBillspayCancellationReport();
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        click(billsPayReportPageObjects.billsPaymentCancellationTransactionType(), "Bills Payment Cancellation Transaction Type DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(), "TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedTimeFrameMonthly(),"Monthly TimeFrame Dropdown Button");
        waitSleep(2000);
        click(kpDomesticReportsPageObjects.monthDropDownButton(),"Month DropDown Button");
        click(billsPayReportPageObjects.monthOfJune(),"Month of June");
        waitSleep(2000);
        click(billsPayReportPageObjects.yearDropdown(),"Year Dropdown Button");
        click(billsPayReportPageObjects.year2024(),"Year 2024");
        waitSleep(2000);
        click(billsPayReportPageObjects.filterDropdown(), "Filter Dropdown Button");
        click(billsPayReportPageObjects.selectedFilterBranch(), "Branch Filter Dropdown Button");
        waitSleep(2000);
        click(billsPayReportPageObjects.branchDropdown(), "Branch Dropdown Button");
        click(billsPayReportPageObjects.misDivision(), "MIS Branch Dropdown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.clearButton(),"Clear Button");

        // Check if any element with the text "2024" is no longer present after clicking the Clear button
        List<WebElement> yearElements = driver.findElements(By.cssSelector("[name=\"yearlyTimeframe\"]"));
        if (yearElements.isEmpty()) {
            ExtentReporter.logPass("BP-CR_TC_10", "Successfully Verify Clear button");
        } else {
            ExtentReporter.logFail("BP-CR_TC_10", "Fail to Verify Clear button");
            Assert.fail("Fail to Verify button");
        }
    }
}
