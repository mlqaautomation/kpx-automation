package mlkpx.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;

public class GcashTransaction_Steps extends Base_Steps{


    public void GT_TC_01() throws Exception{
        click(gcashCashInPageObjects.gcashNav(), "Gcash NavLink");
        click(gcashTransactionPageObjects.transactionNavLink(), "Gcash Transaction NavLink");
        if (isVisible(gcashTransactionPageObjects.gcashTransactionText(), getText(gcashTransactionPageObjects.gcashTransactionText()))) {
            ExtentReporter.logPass("GT_TC_01", "Successfully Navigate Gcash Transaction Landing Page");
        } else {
            ExtentReporter.logFail("GT_TC_01", "Failed to Navigate Gcash Transaction Landing Page");
            Assert.fail("Failed to Navigate Gcash Transaction Landing Page");
        }
    }
    public void GT_TC_02() throws Exception{
        GT_TC_01();
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);
        if (isVisible(gcashTransactionPageObjects.failed(), getText(gcashTransactionPageObjects.failed()))) {
            ExtentReporter.logPass("GT_TC_02", "Successfully verify Search Type(any) Status(any)");
        } else {
            ExtentReporter.logFail("GT_TC_02", "Failed to verify Search Type(any) Status(any)");
            Assert.fail("Failed to verify Search Type(any) Status(any)");
        }
        if (isVisible(gcashTransactionPageObjects.completed(), getText(gcashTransactionPageObjects.completed()))) {
            ExtentReporter.logPass("GT_TC_02", "Successfully verify Search Type(any) Status(any)");
        } else {
            ExtentReporter.logFail("GT_TC_02", "Failed to verify Search Type(any) Status(any)");
            Assert.fail("Failed to verify Search Type(any) Status(any)");
        }
        if (isVisible(gcashTransactionPageObjects.maxAttempts(), getText(gcashTransactionPageObjects.maxAttempts()))) {
            ExtentReporter.logPass("GT_TC_02", "Successfully verify Search Type(any) Status(any)");
        } else {
            ExtentReporter.logFail("GT_TC_02", "Failed to verify Search Type(any) Status(any)");
            Assert.fail("Failed to verify Search Type(any) Status(any)");
        }
        if (isVisible(gcashTransactionPageObjects.pending(), getText(gcashTransactionPageObjects.pending()))) {
            ExtentReporter.logPass("GT_TC_02", "Successfully verify Search Type(any) Status(any)");
        } else {
            ExtentReporter.logFail("GT_TC_02", "Failed to verify Search Type(any) Status(any)");
            Assert.fail("Failed to verify Search Type(any) Status(any)");
        }
    }

    public void GT_TC_03() throws Exception{
        GT_TC_01();
        click(gcashTransactionPageObjects.cashInType(),"CASH IN TYPE");
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);
        if (isVisible(gcashTransactionPageObjects.cashIn(), getText(gcashTransactionPageObjects.cashIn()))) {
            ExtentReporter.logPass("GT_TC_03", "Successfully verify Search Type(CASH IN) Status(any)");
        } else {
            ExtentReporter.logFail("GT_TC_03", "Failed to verify Search Type(CASH IN) Status(any)");
            Assert.fail("Failed to verify Search Type(CASH IN) Status(any)");
        }
    }

    public void GT_TC_04() throws Exception{
        GT_TC_01();
        click(gcashTransactionPageObjects.cashOutType(),"CASH OUT TYPE");
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);
        if (isVisible(gcashTransactionPageObjects.cashOut(), getText(gcashTransactionPageObjects.cashOut()))) {
            ExtentReporter.logPass("GT_TC_04", "Successfully verify Search Type(CASH OUT) Status(any)");
        } else {
            ExtentReporter.logFail("GT_TC_04", "Failed to verify Search Type(CASH OUT) Status(any)");
            Assert.fail("Failed to verify Search Type(CASH OUT) Status(any)");
        }
    }
    public void GT_TC_05() throws Exception{
        GT_TC_01();
        click(gcashTransactionPageObjects.cashInType(),"CASH IN TYPE");
        click(gcashTransactionPageObjects.pendingType(),"PENDING TYPE");
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);

        if (isVisible(gcashTransactionPageObjects.pending(), getText(gcashTransactionPageObjects.pending()))) {
            ExtentReporter.logPass("GT_TC_05", "Successfully verify Search Type(CASH IN) Status(PENDING)");
        } else {
            ExtentReporter.logFail("GT_TC_05", "Failed to verify Search Type(CASH IN) Status(PENDING)");
            Assert.fail("Failed to verify Search Type(CASH IN) Status(PENDING)");
        }
    }
    public void GT_TC_06() throws Exception{
        GT_TC_01();
        click(gcashTransactionPageObjects.cashInType(),"CASH IN TYPE");
        click(gcashTransactionPageObjects.completedType(),"COMPLETED TYPE");
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);

        if (isVisible(gcashTransactionPageObjects.completed(), getText(gcashTransactionPageObjects.completed()))) {
            ExtentReporter.logPass("GT_TC_06", "Successfully verify Search Type(CASH IN) Status(COMPLETE)");
        } else {
            ExtentReporter.logFail("GT_TC_06", "Failed to verify Search Type(CASH IN) Status(COMPLETE)");
            Assert.fail("Failed to verify Search Type(CASH IN) Status(COMPLETE)");
        }
    }
    public void GT_TC_07() throws Exception{
        GT_TC_01();
        click(gcashTransactionPageObjects.cashInType(),"CASH IN TYPE");
        click(gcashTransactionPageObjects.failedType(),"FAILED TYPE");
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);

        if (isVisible(gcashTransactionPageObjects.failed(), getText(gcashTransactionPageObjects.failed()))) {
            ExtentReporter.logPass("GT_TC_07", "Successfully verify Search Type(CASH IN) Status(FAILED)");
        } else {
            ExtentReporter.logFail("GT_TC_07", "Failed to verify Search Type(CASH IN) Status(FAILED)");
            Assert.fail("Failed to verify Search Type(CASH IN) Status(FAILED)");
        }
    }
    public void GT_TC_08() throws Exception{
        GT_TC_01();
        click(gcashTransactionPageObjects.cashInType(),"CASH IN TYPE");
        click(gcashTransactionPageObjects.maxAttemptsType(),"MAX ATTEMPTS TYPE");
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);

        if (isVisible(gcashTransactionPageObjects.maxAttempts(), getText(gcashTransactionPageObjects.maxAttempts()))) {
            ExtentReporter.logPass("GT_TC_08", "Successfully verify Search Type(CASH IN) Status(MAX ATTEMPTS)");
        } else {
            ExtentReporter.logFail("GT_TC_08", "Failed to verify Search Type(CASH IN) Status(MAX ATTEMPTS)");
            Assert.fail("Failed to verify Search Type(CASH IN) Status(MAX ATTEMPTS)");
        }
    }
    public void GT_TC_09() throws Exception{
        GT_TC_01();
        click(gcashTransactionPageObjects.cashOutType(),"CASH OUT TYPE");
        click(gcashTransactionPageObjects.pendingType(),"PENDING TYPE");
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);

        if (isVisible(gcashTransactionPageObjects.pending(), getText(gcashTransactionPageObjects.pending()))) {
            ExtentReporter.logPass("GT_TC_09", "Successfully verify Search Type(CASH OUT) Status(PENDING)");
        } else {
            ExtentReporter.logFail("GT_TC_09", "Failed to verify Search Type(CASH OUT) Status(PENDING)");
            Assert.fail("Failed to verify Search Type(CASH OUT) Status(PENDING)");
        }
    }
    public void GT_TC_10() throws Exception{
        GT_TC_01();
        click(gcashTransactionPageObjects.cashOutType(),"CASH OUT TYPE");
        click(gcashTransactionPageObjects.completedType(),"COMPLETED TYPE");
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);

        if (isVisible(gcashTransactionPageObjects.gcashTransactionText(), getText(gcashTransactionPageObjects.gcashTransactionText()))) {
            ExtentReporter.logPass("GT_TC_10", "Successfully verify Search Type(CASH OUT) Status(COMPLETED)");
        } else {
            ExtentReporter.logFail("GT_TC_10", "Failed to verify Search Type(CASH OUT) Status(COMPLETED)");
            Assert.fail("Failed to verify Search Type(CASH OUT) Status(COMPLETED)");
        }
    }
    public void GT_TC_11() throws Exception{
        GT_TC_01();
        click(gcashTransactionPageObjects.cashOutType(),"CASH OUT TYPE");
        click(gcashTransactionPageObjects.failedType(),"FAILED TYPE");
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);

        if (isVisible(gcashTransactionPageObjects.failed(), getText(gcashTransactionPageObjects.failed()))) {
            ExtentReporter.logPass("GT_TC_11", "Successfully verify Search Type(CASH OUT) Status(FAILED)");
        } else {
            ExtentReporter.logFail("GT_TC_11", "Failed to verify Search Type(CASH OUT) Status(FAILED)");
            Assert.fail("Failed to verify Search Type(CASH OUT) Status(FAILED)");
        }
    }
    public void GT_TC_12() throws Exception{
        GT_TC_01();
        type(gcashTransactionPageObjects.kptn(),"KPTN field", propertyReader.getproperty("validKPTN"));
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);
        if (isVisible(gcashTransactionPageObjects.misDivision(), getText(gcashTransactionPageObjects.misDivision()))) {
            ExtentReporter.logPass("GT_TC_12", "Successfully verify Search valid KPTN");
        } else {
            ExtentReporter.logFail("GT_TC_12", "Failed to verify Search valid KPTN");
            Assert.fail("Failed to verify Search valid KPTN");
        }
    }
    public void GT_TC_13() throws Exception{
        GT_TC_01();
        type(gcashTransactionPageObjects.kptn(),"KPTN field", propertyReader.getproperty("invalidKPTN"));
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);

        if (isVisible(gcashTransactionPageObjects.noResultsFound(), getText(gcashTransactionPageObjects.noResultsFound()))) {
            ExtentReporter.logPass("GT_TC_13", "Successfully verify Search invalid KPTN");
        } else {
            ExtentReporter.logFail("GT_TC_13", "Failed to verify Search invalid KPTN");
            Assert.fail("Failed to verify Search invalid KPTN");
        }
        click(gcashTransactionPageObjects.okButton(),"OK Button");
    }
    public void GT_TC_14() throws Exception{
        GT_TC_01();
        type(gcashTransactionPageObjects.firstName(),"Firstname field", propertyReader.getproperty("gcashFirstname"));
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);

        if (isVisible(gcashTransactionPageObjects.misDivision(), getText(gcashTransactionPageObjects.misDivision()))) {
            ExtentReporter.logPass("GT_TC_14", "Successfully verify Search Firstname");
        } else {
            ExtentReporter.logFail("GT_TC_14", "Failed to verify Search Firstname");
            Assert.fail("Failed to verify Search Firstname");
        }
    }
    public void GT_TC_15() throws Exception{
        GT_TC_01();

        type(gcashTransactionPageObjects.lastName(),"Lastname field", propertyReader.getproperty("gcashLastname"));
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);

        if (isVisible(gcashTransactionPageObjects.misDivision(), getText(gcashTransactionPageObjects.misDivision()))) {
            ExtentReporter.logPass("GT_TC_15", "Successfully verify Search Lastname");
        } else {
            ExtentReporter.logFail("GT_TC_15", "Failed to verify Search Lastname");
            Assert.fail("Failed to verify Search Lastname");
        }
    }
    public void GT_TC_16() throws Exception{
        GT_TC_01();
        click(gcashTransactionPageObjects.cashInType(),"Cash in TYPE");
        click(gcashTransactionPageObjects.completedType(),"Completed Type");
        type(gcashTransactionPageObjects.kptn(),"KPTN Field", propertyReader.getproperty("invalidKPTN"));
        type(gcashTransactionPageObjects.firstName(),"Firstname Field", propertyReader.getproperty("invalidFirstname"));
        type(gcashTransactionPageObjects.lastName(),"Lastname Field", propertyReader.getproperty("invalidLastname"));
        click(gcashTransactionPageObjects.searchButton(), "Search Button");
        waitSleep(5000);

        if (isVisible(gcashTransactionPageObjects.noResultsFound(), getText(gcashTransactionPageObjects.noResultsFound()))) {
            ExtentReporter.logPass("GT_TC_16", "Successfully verify Search Transaction that has no Result Found");
        } else {
            ExtentReporter.logFail("GT_TC_16", "Failed to verify Search Transaction that has no Result Found");
            Assert.fail("Failed to verify Search Transaction that has no Result Found");
        }
    }
    public void GT_TC_17() throws Exception{
        GT_TC_01();

        click(gcashTransactionPageObjects.cashInType(),"Cash in TYPE");
        click(gcashTransactionPageObjects.completedType(),"Completed TYPE");
        type(gcashTransactionPageObjects.kptn(),"KPTN Field", propertyReader.getproperty("invalidKPTN"));
        type(gcashTransactionPageObjects.firstName(),"Firstname Field", propertyReader.getproperty("invalidFirstname"));
        type(gcashTransactionPageObjects.lastName(),"Lastname Field", propertyReader.getproperty("invalidLastname"));
        click(gcashTransactionPageObjects.clearButton(), "Clear Button");
//        waitSleep(2000);
//        if (isVisible(gcashTransactionPageObjects.gcashTransactionText(), getText(gcashTransactionPageObjects.gcashTransactionText()))) {
//            ExtentReporter.logPass("GT_TC_17", "Successfully verify Clear Button");
//        } else {
//            ExtentReporter.logFail("GT_TC_17", "Failed to verify Clear Button");
//            Assert.fail("Failed to verify Clear Button");
//        }
    }























}
