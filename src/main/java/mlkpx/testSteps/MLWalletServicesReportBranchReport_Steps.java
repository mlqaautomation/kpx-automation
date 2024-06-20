package mlkpx.testSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;

import java.util.List;

public class MLWalletServicesReportBranchReport_Steps extends Base_Steps{
    public void MLWBR_TC_01() throws Exception {
        click(mlWalletServicesReportBranchReportPageObjects.mlWalletReportsNavLink(), "MLWallet Reports NavLink");
        click(mlWalletServicesReportBranchReportPageObjects.branchTransactionReport(), "Branch Transaction Reports NavLink");
        if (isVisible(mlWalletServicesReportBranchReportPageObjects.branchTransactionPage(), getText(mlWalletServicesReportBranchReportPageObjects.branchTransactionPage()))) {
            ExtentReporter.logPass("MLWBR_TC_01", "Successfully Navigate MLWallet Reports Branch Transaction Report");
        } else {
            ExtentReporter.logFail("MLWBR_TC_01", "Failed to Navigate MLWallet Reports Branch Transaction Report");
            Assert.fail("Failed to Navigate MLWallet Reports Branch Transaction Report");
        }
    }

    public void MLWBR_TC_02() throws Exception {
        MLWBR_TC_01();
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        if (isVisible(mlWalletServicesReportBranchReportPageObjects.sendMoneyKwartaPadala(), getText(mlWalletServicesReportBranchReportPageObjects.sendMoneyKwartaPadala()))) {
            ExtentReporter.logPass("KP_BTR_TC_02", "Successfully Verify Transaction Type and TimeFrame Dropdown Options");
        } else {
            ExtentReporter.logFail("KP_BTR_TC_02", "Failed to Verify Transaction Type and TimeFrame Dropdown Options");
            Assert.fail("Failed to Verify Transaction Type and TimeFrame Dropdown Optionst");
        }
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");
        if (isVisible(kpDomesticReportsPageObjects.selectedTimeFrameDaily(), getText(kpDomesticReportsPageObjects.selectedTimeFrameDaily()))) {
            ExtentReporter.logPass("KP_BTR_TC_02", "Successfully Verify Transaction Type and TimeFrame Dropdown Options");
        } else {
            ExtentReporter.logFail("KP_BTR_TC_02", "Failed to Verify Transaction Type and TimeFrame Dropdown Options");
            Assert.fail("Failed to Verify Transaction Type and TimeFrame Dropdown Optionst");
        }
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        click(mlWalletServicesReportBranchReportPageObjects.sendMoneyKwartaPadala(),"Send Money Kwarta Padala DropDown Button");
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedTimeFrameMonthly(),"Monthly TimeFrame Dropdown Button");
        if (isVisible(kpDomesticReportsPageObjects.month(), getText(kpDomesticReportsPageObjects.month()))) {
            ExtentReporter.logPass("Shows Month whenever user choose Monthly in Timeframe", "Successfully Verify Transaction Type Dropdown Options Sendout - Monthly");
        } else {
            ExtentReporter.logFail("Shows Month whenever user choose Monthly in Timeframe", "Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
            Assert.fail("Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
        }
        if (isVisible(kpDomesticReportsPageObjects.year(), getText(kpDomesticReportsPageObjects.year()))) {
            ExtentReporter.logPass("Shows Year whenever user choose Monthly in Timeframe", "Successfully Verify Transaction Type Dropdown Options Sendout - Monthly");
        } else {
            ExtentReporter.logFail("Shows Year whenever user choose Monthly in Timeframe", "Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
            Assert.fail("Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
        }
        click(kpDomesticReportsPageObjects.monthDropDownButton(),"Month DropDown Button");
        click(kpDomesticReportsPageObjects.selectedMonthMay(),"May Month Dropdown Button");
        click(kpDomesticReportsPageObjects.yearlyTimeFrame(),"Yearly TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedYear2024(),"Year 2024 Button");
    }
    public void MLWBR_TC_03() throws Exception {
        MLWBR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        waitSleep(3000);
        click(mlWalletServicesReportBranchReportPageObjects.sendMoneyKwartaPadala(),"Send Money Kwarta Padala DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.selectedTimeFrameMonthly(),"Monthly TimeFrame Dropdown Button");
        waitSleep(3000);
        // Verify that the Month and Year are visible
        boolean isMonthVisible = isVisible(kpDomesticReportsPageObjects.month(), getText(kpDomesticReportsPageObjects.month()));
        boolean isYearVisible = isVisible(kpDomesticReportsPageObjects.year(), getText(kpDomesticReportsPageObjects.year()));

        if (isMonthVisible && isYearVisible) {
            ExtentReporter.logPass("Shows Month and Year whenever user choose Monthly in Timeframe", "Successfully Verify Transaction Type Dropdown Options Sendout - Monthly");
        } else {
            if (!isMonthVisible) {
                ExtentReporter.logFail("Shows Month whenever user choose Monthly in Timeframe", "Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
            }
            if (!isYearVisible) {
                ExtentReporter.logFail("Shows Year whenever user choose Monthly in Timeframe", "Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
            }
            Assert.fail("Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
        }

        click(kpDomesticReportsPageObjects.monthDropDownButton(),"Month DropDown Button");
        waitSleep(1000);
        click(kpDomesticReportsPageObjects.selectedMonthMay(),"May Month Dropdown Button");
        waitSleep(1000);
        click(kpDomesticReportsPageObjects.yearlyTimeFrame(),"Yearly TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedYear2024(),"Year 2024 Button");
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(20000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");
//        // Check if any element with the text "2024" is no longer present after clicking the Clear button
//        List<WebElement> yearElements = driver.findElements(By.cssSelector("[name=\"yearlyTimeframe\"]"));
//        if (yearElements.isEmpty()) {
//            ExtentReporter.logPass("KP_BTR_TC_21", "Yearly Time Frame is not present after clicking the Clear button");
//        } else {
//            ExtentReporter.logFail("KP_BTR_TC_21", "Yearly Time Frame is still present after clicking the Clear button");
//            Assert.fail("Year '2024' is still present after clicking the Clear button");
//        }
    }
    public void MLWBR_TC_04() throws Exception {
        MLWBR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        waitSleep(3000);
        click(mlWalletServicesReportBranchReportPageObjects.cashInViaBranch(),"Cash In via Branch DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.selectedTimeFrameMonthly(),"Monthly TimeFrame Dropdown Button");
        waitSleep(3000);
        // Verify that the Month and Year are visible
        boolean isMonthVisible = isVisible(kpDomesticReportsPageObjects.month(), getText(kpDomesticReportsPageObjects.month()));
        boolean isYearVisible = isVisible(kpDomesticReportsPageObjects.year(), getText(kpDomesticReportsPageObjects.year()));

        if (isMonthVisible && isYearVisible) {
            ExtentReporter.logPass("Shows Month and Year whenever user choose Monthly in Timeframe", "Successfully Verify Transaction Type Dropdown Options Sendout - Monthly");
        } else {
            if (!isMonthVisible) {
                ExtentReporter.logFail("Shows Month whenever user choose Monthly in Timeframe", "Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
            }
            if (!isYearVisible) {
                ExtentReporter.logFail("Shows Year whenever user choose Monthly in Timeframe", "Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
            }
            Assert.fail("Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
        }

        click(kpDomesticReportsPageObjects.monthDropDownButton(),"Month DropDown Button");
        waitSleep(1000);
        click(kpDomesticReportsPageObjects.selectedMonthMay(),"May Month Dropdown Button");
        waitSleep(1000);
        click(kpDomesticReportsPageObjects.yearlyTimeFrame(),"Yearly TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedYear2024(),"Year 2024 Button");
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(20000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");
    }
    public void MLWBR_TC_05() throws Exception {
        MLWBR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        waitSleep(3000);
        click(mlWalletServicesReportBranchReportPageObjects.cashOutViaBranch(),"Cash Out via Branch DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.selectedTimeFrameMonthly(),"Monthly TimeFrame Dropdown Button");
        waitSleep(3000);
        // Verify that the Month and Year are visible
        boolean isMonthVisible = isVisible(kpDomesticReportsPageObjects.month(), getText(kpDomesticReportsPageObjects.month()));
        boolean isYearVisible = isVisible(kpDomesticReportsPageObjects.year(), getText(kpDomesticReportsPageObjects.year()));

        if (isMonthVisible && isYearVisible) {
            ExtentReporter.logPass("Shows Month and Year whenever user choose Monthly in Timeframe", "Successfully Verify Transaction Type Dropdown Options Sendout - Monthly");
        } else {
            if (!isMonthVisible) {
                ExtentReporter.logFail("Shows Month whenever user choose Monthly in Timeframe", "Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
            }
            if (!isYearVisible) {
                ExtentReporter.logFail("Shows Year whenever user choose Monthly in Timeframe", "Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
            }
            Assert.fail("Failed to Verify Transaction Type Dropdown Options Sendout - Monthly");
        }

        click(kpDomesticReportsPageObjects.monthDropDownButton(),"Month DropDown Button");
        waitSleep(1000);
        click(kpDomesticReportsPageObjects.selectedMonthMay(),"May Month Dropdown Button");
        waitSleep(1000);
        click(kpDomesticReportsPageObjects.yearlyTimeFrame(),"Yearly TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedYear2024(),"Year 2024 Button");
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(20000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");
    }
    public void MLWBR_TC_06() throws Exception {
        MLWBR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        waitSleep(3000);
        click(mlWalletServicesReportBranchReportPageObjects.sendMoneyKwartaPadala(),"Send Money Kwarta Padala DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");
        waitSleep(3000);
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
        waitSleep(3000);
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(20000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");
    }
    public void MLWBR_TC_07() throws Exception {
        MLWBR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        waitSleep(3000);
        click(mlWalletServicesReportBranchReportPageObjects.cashInViaBranch(),"Cash In via Branch DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");
        waitSleep(3000);
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
        waitSleep(3000);
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(15000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");
    }
    public void MLWBR_TC_08() throws Exception {
        MLWBR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        waitSleep(3000);
        click(mlWalletServicesReportBranchReportPageObjects.cashOutViaBranch(),"Cash Out via Branch DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");
        waitSleep(3000);
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
        waitSleep(3000);
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(20000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");
    }
    public void MLWBR_TC_09() throws Exception {
        MLWBR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        waitSleep(3000);
        click(mlWalletServicesReportBranchReportPageObjects.sendMoneyKwartaPadala(),"Send Money Kwarta Padala DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");
        waitSleep(3000);
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
        waitSleep(3000);
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(15000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");
    }
    public void MLWBR_TC_10() throws Exception {
        MLWBR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        waitSleep(3000);
        click(mlWalletServicesReportBranchReportPageObjects.cashInViaBranch(),"Cash In via Branch DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");

        waitSleep(3000);
        click(kpDomesticReportsPageObjects.DateRange(),"Date Range Dropdown Button");
        click(kpDomesticReportsPageObjects.DateRangeFrom(),"Date From Dropdown Button");
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Year - Date From Dropdown Button", propertyReader.getproperty("yearFrom"));
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Month - Date From Dropdown Button", propertyReader.getproperty("dateFrom"));
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Date - Date From Dropdown Button", propertyReader.getproperty("monthFrom"));

        waitSleep(1000);
        click(kpDomesticReportsPageObjects.DateRangeTo(),"Date To Dropdown Button");
        type(kpDomesticReportsPageObjects.DateRangeTo(), "Year - Date to Dropdown Button", propertyReader.getproperty("yearTo"));
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeTo(), "Date - Date to Dropdown Button", propertyReader.getproperty("dateTo"));
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeTo(), "Month - Date to Dropdown Button", propertyReader.getproperty("monthTo"));

        waitSleep(1000);
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(20000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");
    }
    public void MLWBR_TC_11() throws Exception {
        MLWBR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        waitSleep(3000);
        click(mlWalletServicesReportBranchReportPageObjects.cashOutViaBranch(),"Cash Out via Branch DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");

        waitSleep(3000);
        click(kpDomesticReportsPageObjects.DateRange(),"Date Range Dropdown Button");
        click(kpDomesticReportsPageObjects.DateRangeFrom(),"Date From Dropdown Button");
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Year - Date From Dropdown Button", propertyReader.getproperty("yearFrom"));
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Month - Date From Dropdown Button", propertyReader.getproperty("dateFrom"));
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Date - Date From Dropdown Button", propertyReader.getproperty("monthFrom"));

        waitSleep(1000);
        click(kpDomesticReportsPageObjects.DateRangeTo(),"Date To Dropdown Button");
        type(kpDomesticReportsPageObjects.DateRangeTo(), "Year - Date to Dropdown Button", propertyReader.getproperty("yearTo"));
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeTo(), "Date - Date to Dropdown Button", propertyReader.getproperty("dateTo"));
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeTo(), "Month - Date to Dropdown Button", propertyReader.getproperty("monthTo"));

        waitSleep(1000);
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(20000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");
    }





    public void MLWBR_TC_12() throws Exception {
        MLWBR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        waitSleep(3000);
        click(mlWalletServicesReportBranchReportPageObjects.sendMoneyKwartaPadala(),"Send Money Kwarta Padala DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.selectedTimeFrameMonthly(),"Monthly TimeFrame Dropdown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.monthDropDownButton(),"Month DropDown Button");
        click(kpDomesticReportsPageObjects.selectedMonthJune(),"June Month Dropdown Button");

        click(kpDomesticReportsPageObjects.yearlyTimeFrame(),"Yearly TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedYear2024(),"Year 2024 Button");
        click(kpDomesticReportsPageObjects.clearButton(),"Clear button");

        // Check if any element with the text "2024" is no longer present after clicking the Clear button
        List<WebElement> yearElements = driver.findElements(By.cssSelector("[name=\"yearlyTimeframe\"]"));
        if (yearElements.isEmpty()) {
            ExtentReporter.logPass("MLWBR_TC_12", "Yearly Time Frame is not present after clicking the Clear button");
        } else {
            ExtentReporter.logFail("MLWBR_TC_12", "Yearly Time Frame is still present after clicking the Clear button");
            Assert.fail("Year '2024' is still present after clicking the Clear button");
        }
    }

//    public void MLWBR_TC_13() throws Exception {
//        MLWBR_TC_01();
//        waitSleep(3000);
//        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
//        waitSleep(3000);
//        click(mlWalletServicesReportBranchReportPageObjects.sendMoneyKwartaPadala(),"Send Money Kwarta Padala DropDown Button");
//        waitSleep(3000);
//        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");
//        waitSleep(3000);
//        click(kpDomesticReportsPageObjects.DateRange(),"Date Range Dropdown Button");
//        waitSleep(3000);
//        click(kpDomesticReportsPageObjects.DateRangeFrom(),"Date From Dropdown Button");
//        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Year - Date From Dropdown Button", propertyReader.getproperty("yearFrom"));
//        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
//        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Month - Date From Dropdown Button", propertyReader.getproperty("dateFrom"));
//        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
//        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
//        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Date - Date From Dropdown Button", propertyReader.getproperty("monthFrom"));
//        click(kpDomesticReportsPageObjects.DateRangeTo(),"Date To Dropdown Button");
//        type(kpDomesticReportsPageObjects.DateRangeTo(), "", propertyReader.getproperty("yearFuture"));
//        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
//        type(kpDomesticReportsPageObjects.DateRangeTo(), "Date - Date To Dropdown Button", propertyReader.getproperty("dateFuture"));
//        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
//        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
//        type(kpDomesticReportsPageObjects.DateRangeTo(), "Month - Date To Dropdown Button", propertyReader.getproperty("monthFuture"));
//
//        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
//        if (isVisible(kpDomesticReportsPageObjects.invalidDateFutureDate(), getText(kpDomesticReportsPageObjects.invalidDateFutureDate()))) {
//            ExtentReporter.logPass("KP_BTR_TC_22", "Successfully Verify Invalid Date");
//        } else {
//            ExtentReporter.logFail("KP_BTR_TC_22", "Failed to Verify Invalid Date");
//            Assert.fail("Failed to Verify Invalid Date");
//        }
//    }
    public void MLWBR_TC_14() throws Exception {
        MLWBR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(),"Transaction Type DropDown Button");
        waitSleep(3000);
        click(mlWalletServicesReportBranchReportPageObjects.sendMoneyKwartaPadala(),"Send Money Kwarta Padala DropDown Button");
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.timeFrame(),"TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedTimeFrameMonthly(),"Monthly TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.monthDropDownButton(),"Month DropDown Button");
        click(kpDomesticReportsPageObjects.selectedMonthDecember(),"December Month Dropdown Button");
        click(kpDomesticReportsPageObjects.yearlyTimeFrame(),"Yearly TimeFrame Dropdown Button");
        click(kpDomesticReportsPageObjects.selectedYear2024(),"Year 2024 Button");
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Button");
        waitSleep(10000);
        if (isVisible(kpDomesticReportsPageObjects.noReportsGenerated(), getText(kpDomesticReportsPageObjects.noReportsGenerated()))) {
            ExtentReporter.logPass("KP_BTR_TC_23", "Successfully Verify No Reports Generated");
        } else {
            ExtentReporter.logFail("KP_BTR_TC_23", "Failed to Verify No Reports Generated");
            Assert.fail("Failed to Verify No Reports Generated");
        }
    }


}
