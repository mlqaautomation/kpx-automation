package mlkpx.testSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;

import java.util.List;

public class CorporatePartnerReport_Steps extends Base_Steps{

    public void CPRBTR_TC_01() throws Exception {
        click(corporatePartnerReportPageObjects.corporatePartnerReportsNavLink(), "Corporate Partner Reports NavLink");
        click(kpDomesticReportsPageObjects.branchTransactionReport(), "Branch Transaction Reports NavLink");
        if (isVisible(corporatePartnerReportPageObjects.currencyText(), getText(corporatePartnerReportPageObjects.currencyText()))) {
            ExtentReporter.logPass("CPRBTR_TC_01", "Successfully Navigate Corporate Partner Reports  Branch Transaction Report");
        } else {
            ExtentReporter.logFail("CPRBTR_TC_01", "Failed to Navigate Corporate Partner Reports Branch Transaction Report");
            Assert.fail("Failed to Navigate Corporate Partner Reports Branch Transaction Report");
        }
    }

    public void CPRBTR_TC_02() throws Exception {
        CPRBTR_TC_01();
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        if (isVisible(kpDomesticReportsPageObjects.selectedTransactionTypeSendout(), getText(kpDomesticReportsPageObjects.selectedTransactionTypeSendout()))) {
            ExtentReporter.logPass("CPRBTR_TC_02", "Successfully Verify Transaction Type and TimeFrame Dropdown Options");
        } else {
            ExtentReporter.logFail("CPRBTR_TC_02", "Failed to Verify Transaction Type and TimeFrame Dropdown Options");
            Assert.fail("Failed to Verify Transaction Type and TimeFrame Dropdown Optionst");
        }
    }
    public void CPRBTR_TC_03() throws Exception {
        CPRBTR_TC_01();
        click(corporatePartnerReportPageObjects.currencyDropdown(), "Currency DropDown Button");
        if (isVisible(corporatePartnerReportPageObjects.phpText(), getText(corporatePartnerReportPageObjects.phpText()))) {
            ExtentReporter.logPass("CPRBTR_TC_02", "Successfully Verify Transaction Type and TimeFrame Dropdown Options");
        } else {
            ExtentReporter.logFail("CPRBTR_TC_02", "Failed to Verify Transaction Type and TimeFrame Dropdown Options");
            Assert.fail("Failed to Verify Transaction Type and TimeFrame Dropdown Option");
        }
    }
    public void CPRBTR_TC_04() throws Exception {
        CPRBTR_TC_01();
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.transactionType(), "Transaction Type DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.sendoutInTransactionType(), "Selected Transaction Type (Sendout))");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.timeFrameField(), "Timeframe Field");
        click(corporatePartnerReportPageObjects.selectedTimeFrameMonthly(), "Monthly Timeframe Field");
        click(kpDomesticReportsPageObjects.selectedMonthJuly(), "Selected Month July");
//        click(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Date DropDown Button");
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Month - Date Dropdown Button", propertyReader.getproperty("monthCorporate"));
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "day - Date Dropdown Button", propertyReader.getproperty("dayCorporate"));
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Year - Date Dropdown Button", propertyReader.getproperty("yearCorporate"));
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(17000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");

    }
    public void CPRBTR_TC_05() throws Exception {
        CPRBTR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.payoutInTransactionType(), "Selected Transaction Type (Payout))");
        waitSleep(3000);

        click(corporatePartnerReportPageObjects.timeFrameField(), "Timeframe Field");
        click(corporatePartnerReportPageObjects.selectedTimeFrameMonthly(), "Monthly Timeframe Field");
        click(corporatePartnerReportPageObjects.selectedMonthJune(), "Selected Month June");
//        click(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Date DropDown Button");
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Month - Date Dropdown Button", propertyReader.getproperty("monthCorporate"));
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "day - Date Dropdown Button", propertyReader.getproperty("dayCorporate"));
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Year - Date Dropdown Button", propertyReader.getproperty("yearCorporate"));
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        waitSleep(3000);
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(17000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");

    }
    public void CPRBTR_TC_06() throws Exception {
        CPRBTR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.sendoutInTransactionType(), "Selected Transaction Type (Sendout))");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.currencyDropdown(), "Currency DropDown Button");
        click(corporatePartnerReportPageObjects.phpText(), "PHP DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.timeFrameField(), "Timeframe Field");
        click(corporatePartnerReportPageObjects.selectedTimeFrameMonthly(), "Monthly Timeframe Field");
        click(corporatePartnerReportPageObjects.selectedMonthJune(), "Selected Month June");
//        click(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Date DropDown Button");
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Month - Date Dropdown Button", propertyReader.getproperty("monthCorporate"));
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "day - Date Dropdown Button", propertyReader.getproperty("dayCorporate"));
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Year - Date Dropdown Button", propertyReader.getproperty("yearCorporate"));
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        waitSleep(3000);
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(17000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");

    }
    public void CPRBTR_TC_07() throws Exception {
        CPRBTR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.sendoutInTransactionType(), "Selected Transaction Type (Sendout))");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.currencyDropdown(), "Currency DropDown Button");
        click(corporatePartnerReportPageObjects.usdText(), "USD DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Date DropDown Button");
        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Month - Date Dropdown Button", propertyReader.getproperty("monthCorporate"));
        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "day - Date Dropdown Button", propertyReader.getproperty("dayCorporate"));
        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Year - Date Dropdown Button", propertyReader.getproperty("yearCorporate"));
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        waitSleep(3000);
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(17000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");

    }
    public void CPRBTR_TC_08() throws Exception {
        CPRBTR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.payoutInTransactionType(), "Selected Transaction Type (Payout))");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.phpText(), "PHP DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.timeFrameField(), "Timeframe Field");
        click(corporatePartnerReportPageObjects.selectedTimeFrameMonthly(), "Monthly Timeframe Field");
        click(corporatePartnerReportPageObjects.selectedMonthJune(), "Selected Month June");
//        click(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Date DropDown Button");;
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Month - Date Dropdown Button", propertyReader.getproperty("monthCorporate"));
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "day - Date Dropdown Button", propertyReader.getproperty("dayCorporate"));
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Year - Date Dropdown Button", propertyReader.getproperty("yearCorporate"));
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        waitSleep(3000);
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(17000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");

    }
    public void CPRBTR_TC_09() throws Exception {
        CPRBTR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.payoutInTransactionType(), "Selected Transaction Type (Payout))");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.usdText(), "USD DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Date DropDown Button");

        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Month - Date Dropdown Button", propertyReader.getproperty("monthCorporate"));
        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "day - Date Dropdown Button", propertyReader.getproperty("dayCorporate"));
        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Year - Date Dropdown Button", propertyReader.getproperty("yearCorporate"));
        Assert.assertTrue(kpDomesticReportsPageObjects.generateReportButton().isEnabled(), "Generate Report Button is not clickable");
        // Get the current tab count before clicking the generateReportButton
        int initialTabCount = driver.getWindowHandles().size();
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(17000);
        int finalTabCount = driver.getWindowHandles().size();
        // Verify that the tab count has increased by 1, indicating a new tab has been opened
        Assert.assertEquals(finalTabCount, initialTabCount + 1, "Generate Report Button did not open a new tab");

    }
    public void CPRBTR_TC_10() throws Exception {
        CPRBTR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.sendoutInTransactionType(), "Selected Transaction Type (Sendout))");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.currencyDropdown(), "Currency DropDown Button");
        click(corporatePartnerReportPageObjects.phpText(), "PHP DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.timeFrameField(), "Timeframe Field");
        click(corporatePartnerReportPageObjects.selectedTimeFrameMonthly(), "Monthly Timeframe Field");
        click(corporatePartnerReportPageObjects.selectedMonthJune(), "Selected Month June");
//        click(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Date DropDown Button");
//
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Month - Date Dropdown Button", propertyReader.getproperty("monthCorporate"));
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "day - Date Dropdown Button", propertyReader.getproperty("dayCorporate"));
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Year - Date Dropdown Button", propertyReader.getproperty("yearCorporate"));
        click(kpDomesticReportsPageObjects.clearButton(),"Clear button");
        Assert.assertTrue(corporatePartnerReportPageObjects.phpText().isEnabled(), "Failed to verify the function of Clear Button");
//        List<WebElement> phpElements = driver.findElements(By.cssSelector("[value=\"PHP\"]"));
//        if (phpElements.isEmpty()) {
//            ExtentReporter.logPass("CPRBTR_TC_10", "Successfully Clear all the transactions");
//        } else {
//            ExtentReporter.logFail("CPRBTR_TC_10", "Failed to Clear all the transactions");
//            Assert.fail("Failed to Clear all the transactions");
//        }
    }
    public void CPRBTR_TC_11() throws Exception {
        CPRBTR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.sendoutInTransactionType(), "Selected Transaction Type (Sendout))");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.timeFrameField(), "Timeframe Field");
        click(corporatePartnerReportPageObjects.dateRange(), "Date Range Timeframe Field");

        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Year - Date From Dropdown Button", propertyReader.getproperty("yearFrom"));
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Month - Date From Dropdown Button", propertyReader.getproperty("dateFrom"));
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        kpDomesticReportsPageObjects.DateRangeFrom().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeFrom(), "Date - Date From Dropdown Button", propertyReader.getproperty("monthFrom"));
        click(kpDomesticReportsPageObjects.DateRangeTo(),"Date To Dropdown Button");
        type(kpDomesticReportsPageObjects.DateRangeTo(), "", propertyReader.getproperty("yearFuture"));
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeTo(), "Date - Date To Dropdown Button", propertyReader.getproperty("dateFuture"));
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        kpDomesticReportsPageObjects.DateRangeTo().sendKeys(Keys.ARROW_LEFT);
        type(kpDomesticReportsPageObjects.DateRangeTo(), "Month - Date To Dropdown Button", propertyReader.getproperty("monthFuture"));


//        click(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Date DropDown Button");
//        waitSleep(3000);
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Month - Date Dropdown Button", propertyReader.getproperty("monthCorporateI"));
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "day - Date Dropdown Button", propertyReader.getproperty("dayCorporateI"));
//        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Year - Date Dropdown Button", propertyReader.getproperty("yearCorporateI"));
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(2000);
        if (isVisible(corporatePartnerReportPageObjects.futureDateText(), getText(corporatePartnerReportPageObjects.futureDateText()))) {
            ExtentReporter.logPass("CPRBTR_TC_11", "Successfully Verify Invalid Date");
        } else {
            ExtentReporter.logFail("CPRBTR_TC_11", "Failed to Verify Invalid Date");
            Assert.fail("Failed to Verify Invalid Date");
        }

    }
    public void CPRBTR_TC_12() throws Exception {
        CPRBTR_TC_01();
        waitSleep(3000);
        click(kpDomesticReportsPageObjects.transactionType(), "Transaction Type DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.sendoutInTransactionType(), "Selected Transaction Type (Sendout))");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.currencyDropdown(), "Currency DropDown Button");
        click(corporatePartnerReportPageObjects.phpText(), "PHP DropDown Button");
        waitSleep(3000);
        click(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Date DropDown Button");
        waitSleep(3000);
        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Month - Date Dropdown Button", propertyReader.getproperty("monthCorporateNo"));
        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "day - Date Dropdown Button", propertyReader.getproperty("dayCorporateNo"));
        type(corporatePartnerReportPageObjects.dateInCorporatePartner(), "Year - Date Dropdown Button", propertyReader.getproperty("yearCorporateNo"));
        click(kpDomesticReportsPageObjects.generateReportButton(),"Generate Report Button");
        waitSleep(2000);
        if (isVisible(kpDomesticReportsPageObjects.noReportsGenerated(), getText(kpDomesticReportsPageObjects.noReportsGenerated()))) {
            ExtentReporter.logPass("CPRBTR_TC_12", "Successfully Verify No Reports Generated");
        } else {
            ExtentReporter.logFail("CPRBTR_TC_12", "Failed to Verify No Reports Generated");
            Assert.fail("Failed to Verify No Reports Generated");
        }

    }


}
