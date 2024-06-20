package utilities.ReusableComponents;

import org.openqa.selenium.*;

import java.time.Duration;
import java.util.Set;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;
import utilities.yamlReader.yamlReader;
import org.testng.Assert;

import static utilities.Driver.DriverManager.getDriver;

public class GeneralMethod extends ExtentReporter{
    protected final WebDriver driver = getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    public final yamlReader reader = new yamlReader();
    private JavascriptExecutor js;
    private boolean loadingInProgress = false;

    public void click(WebElement locator, String elementName){
        try {
            if (isDisplayed(locator)) {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                LoggingUtils.info("Clicked on element: " + elementName);
                ExtentReporter.logInfo("Clicked on element: " + elementName, "");
            }
        } catch (Exception e) {
            ExtentReporter.logFail("Failed to click element: " + elementName, "Caused: " + e);
            LoggingUtils.error("Failed to click element: " + elementName);
            throw new AssertionError("Failed to click element: " + elementName);
        }
    }

    public void type(WebElement locator, String elementName, String text){
        try {
            if(isDisplayed(locator)) {
                WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
                element.sendKeys(text);
                LoggingUtils.info("Typed into field: " + elementName + ", Value: "+ text);
                ExtentReporter.logInfo("Typed into field: " + elementName , "Typed Value: "+ text);
            }
        } catch (NoSuchElementException e) {
        LoggingUtils.error("Failed to type into field: "+ elementName + ", Value: "+ text);
        ExtentReporter.logFail("Failed to type into field: "+ elementName , " Typed Value:: "+ text);

        throw new AssertionError("Failed to type into field: "+ elementName + ", Value: "+ text);
        }
    }

    public void typeEnter(WebElement locator, String elementName, String text){
        try {
            if(isDisplayed(locator)) {
                WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
                element.sendKeys(text + Keys.ENTER);
                LoggingUtils.info("Typed into field: " + elementName + ", Value: "+ text);
                ExtentReporter.logInfo("Typed into field: " + elementName , "Typed Value: "+ text);
            }
        } catch (NoSuchElementException e) {
            LoggingUtils.error("Failed to type into field: "+ elementName + ", Value: "+ text);
            ExtentReporter.logFail("Failed to type into field: "+ elementName , "Typed Value: "+ text);
            throw new AssertionError("Failed to type into field: "+ elementName + ", Value: "+ text);
        }
    }

    public boolean isVisible(WebElement locator, String elementName){
        try{
            wait.until(ExpectedConditions.visibilityOf(locator));
            LoggingUtils.info("Element: " + elementName + ", is visible");
            return true;
        }catch (NoSuchElementException e){
            ExtentReporter.logFail("Element: " + elementName + "not visible", "Caused: ");
            LoggingUtils.error("Element: " + elementName + "not visible");
            throw new AssertionError("Element: " + elementName + " not visible" );
        }
    }

    /**
     * boolean return type for conditions
     *
     * @param locator
     * @return
     * @throws NoSuchElementException
     */
    public boolean isDisplayed(WebElement locator) {
        try {
            wait.until(ExpectedConditions.visibilityOf(locator));
            return locator.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    public String getText(WebElement locator){
        String val = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
            val = element.getText();
        }catch(Exception e){
            ExtentReporter.logFail("Cannot get text for element" + e.getMessage(), "Caused: "+ e);
            LoggingUtils.error("Cannot get text for element" + e.getMessage());
            throw new AssertionError("Cannot get text for element" + e.getMessage());
        }
       return val;

    }

    public void assertEqual(String actual, String expected){
        try{
            Assert.assertEquals(actual, expected);
            LoggingUtils.info(actual +  " and " + expected + " are matched");
            ExtentReporter.logInfo("Assertion: "+actual +  " and " + expected + " are matched" , "asserted values " + actual + " and " + expected);
        }catch(Exception e){
            LoggingUtils.error("Assertion error: "+ e.getMessage());
            ExtentReporter.logFail("Assertion error: "+ e.getMessage(), "Caused: "+ e);
            throw new AssertionError("Assertion error: "+ e.getMessage());
        }
    }
    public void assertEqual(double actual, double expected){
        try{
            Assert.assertEquals(actual, expected);
            LoggingUtils.info(actual +  " and " + expected + " are matched");
            ExtentReporter.logInfo("Assertion: "+actual +  " and " + expected + " are matched" , "asserted values " + actual + " and " + expected);
        }catch(Exception e){
            LoggingUtils.error("Assertion error: "+ e.getMessage());
            ExtentReporter.logFail("Assertion error: "+ e.getMessage(), "Caused: "+ e);
            throw new AssertionError("Assertion error: "+ e.getMessage());
        }
    }

    public void waitImplicitly(int seconds){
        try{
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
            LoggingUtils.info("Waiting implicitly for: " + seconds + " seconds");
        }catch(Exception e){
            LoggingUtils.error("waitImplicitly error: "+ e.getMessage());
        }
    }
    public void waitSleep(int miliSeconds){
        try{
            Thread.sleep(miliSeconds);
            LoggingUtils.info("Waiting for: " + miliSeconds + " miliSeconds");
        }catch(Exception e){
            LoggingUtils.error("wait error: "+ e.getMessage());
        }
    }


    public void switchToNextTab() {
        String currentWindowHandle = getDriver().getWindowHandle();
        Set<String> windowHandles = getDriver().getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                getDriver().switchTo().window(windowHandle);
                LoggingUtils.info("Switch to " + currentWindowHandle);
                ExtentReporter.logInfo("Switch Next Tab" , "Window ID: "+currentWindowHandle);
                break;
            }
        }
    }
    public void switchToNextTabClose() {
        String currentWindowHandle = getDriver().getWindowHandle();
        Set<String> windowHandles = getDriver().getWindowHandles();

        // Check if there are multiple windows/tabs open
        if (windowHandles.size() <= 1) {
            LoggingUtils.info("No next tab/window to switch to or close");
            ExtentReporter.logInfo("No Tab to Switch", "No Tab to Switch");
            return;
        }

        boolean foundNextWindow = false;

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                try {
                    getDriver().switchTo().window(windowHandle);
                    getDriver().close();
                    LoggingUtils.info("Closed window: " + windowHandle);
                    ExtentReporter.logInfo("Closed window: " + windowHandle, "");
                    foundNextWindow = true;
                } catch (NoSuchWindowException e) {
                    LoggingUtils.error("Failed to switch to/close window: " + windowHandle);
                    ExtentReporter.logFail("Failed to switch to/close window: " + windowHandle, "");
                }
                break;
            }
        }

        if (!foundNextWindow) {
            LoggingUtils.error("No next tab/window found to switch to or close");
            ExtentReporter.logFail("No next tab/window found to switch to or close", "");
        }

        // Switch driver focus back to the original window/tab
        getDriver().switchTo().window(currentWindowHandle);
    }

    public void switchToPreviousTab() {
        String currentWindowHandle = getWebDriver().getWindowHandle();
        Set<String> windowHandles = getWebDriver().getWindowHandles();
        String previousWindowHandle = null;

        for (String windowHandle : windowHandles) {
            if (windowHandle.equals(currentWindowHandle)) {
                break;
            }
            previousWindowHandle = windowHandle;
        }

        if (previousWindowHandle != null) {
            getWebDriver().switchTo().window(previousWindowHandle);
            LoggingUtils.info("Switch to " + previousWindowHandle);
            ExtentReporter.logInfo("Switch Previous Tab " ,"Previous Tab ID: "+ currentWindowHandle);
        } else {
            throw new IllegalStateException("No previous tab found");
        }
    }
    public void scrollToBottomOfPageWEB() {
        try{
            js = (JavascriptExecutor) getWebDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }catch (Exception e){
            LoggingUtils.info("Error: "+e);
        }

    }

    public void waitUntilLoadingGone(int maxWaitTimeMs) {
        long startTime = System.currentTimeMillis();
        boolean isLoading = true;

        while (isLoading) {
            if (System.currentTimeMillis() - startTime > maxWaitTimeMs) {
                LoggingUtils.info("Reached maximum wait time of " + maxWaitTimeMs + " ms. Continuing...");
                break;
            }

            try {
                // Check the loading condition here
                isLoading = isThereAnyLoadingInProgress();

                if (isLoading) {
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                LoggingUtils.error("Error while waiting for loading to finish: " + e.getMessage());
                break;
            }
        }

        LoggingUtils.info("Finished waiting for loading to be gone.");
    }

    private boolean isThereAnyLoadingInProgress() {
        // Implement your own logic to check the loading condition
        // For example, you might have a variable that tracks the loading state
        return loadingInProgress;
    }

    public  void scrollToTopOfPageWEB() {
        try{
            js= (JavascriptExecutor) getWebDriver();
            js.executeScript("window.scrollBy(0,-250)", "");
        }catch (Exception e ){
            LoggingUtils.info("Error: "+e);
        }
    }
    public void scrollToSpecificScrollPosition(int scrollPosition) {
        try{
            js = (JavascriptExecutor) getWebDriver();
            js.executeScript("window.scrollTo(0, arguments[0])", scrollPosition);
            LoggingUtils.info("Scrolling into position: "+ scrollPosition);
        }catch (Exception e){
            LoggingUtils.info("Error "+ e);
        }

    }
//    public void scrollToElement(WebElement element) {
//        try{
//            js = (JavascriptExecutor) getWebDriver();
//            js.executeScript("arguments[0].scrollIntoView(true);", element);
//            LoggingUtils.info("Scrolling into element: "+ element);
//        }catch (Exception e){
//            LoggingUtils.info("Error "+ e);
//        }
//
//    }
    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) getWebDriver();
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            LoggingUtils.info("Scrolling into element: " + element);
        } catch (Exception e) {
            LoggingUtils.info("Error while scrolling to element: " + e);
        }
    }
    public static void scrollVertically(By byLocator, int scrollValue) {
        try {
            WebElement divElement = getWebDriver().findElement(byLocator);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) getWebDriver();
            jsExecutor.executeScript("arguments[0].scrollLeft = arguments[1]", divElement, scrollValue);
            LoggingUtils.info(">>Scrolled vertically to using locator: " + byLocator);
            ExtentReporter.logInfo("Scroll Vertically ", "Scrolling vertically with the  value of :" + scrollValue);
        } catch (Exception e) {
            LoggingUtils.error(">>Failed to scroll vertically using locator: " + byLocator + " - " + e.getMessage());
            ExtentReporter.logFail("Unable Scroll vertically ", "Scrolling vertically with the  error of :" + e.getMessage());
            throw e;
        }
    }

    public List<WebElement> staleException_Click(WebElement locator) {
        List<WebElement> outcome = null;
        int repeat = 0;
        while (repeat <= 6) {
            try {
                List<WebElement> ele = getDriver().findElements((By) locator);
                break;
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
            repeat++;
        }
        return outcome;
    }
    public void scrollDown(int scrollPercentage) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        long totalHeight = (long) jsExecutor.executeScript("return document.body.scrollHeight");
        long scrollHeight = totalHeight * scrollPercentage / 100;

        jsExecutor.executeScript("window.scrollTo(0, " + scrollHeight + ")");
    }

    public void scrollDownInElement(WebElement element, int scrollPercentage) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        long totalHeight = (long) jsExecutor.executeScript("return arguments[0].scrollHeight;", element);
        long scrollHeight = totalHeight * scrollPercentage / 100;

        jsExecutor.executeScript("arguments[0].scrollTop = arguments[1];", element, scrollHeight);
    }
    public void scrollUp(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 0)");
    }
    // Get the generated KPTN
    public String getGeneratedKPTN() {
        WebElement kptnElement = driver.findElement(By.id("kptnElementId")); // Replace "kptnElementId" with the actual ID or locator of the element displaying the KPTN
        String generatedKPTN = kptnElement.getText();
        return generatedKPTN;
    }

    // Perform actions using the generated KPTN
    public void performActionWithGeneratedKPTN() {
        // Perform actions to generate the KPTN
        // ...

        String generatedKPTN = getGeneratedKPTN();
        System.out.println("Generated KPTN: " + generatedKPTN);

        // Use the generated KPTN in your subsequent code
        // ...
    }


    public void clearInput(WebElement locator, String elementName) {
        try {
            if (isDisplayed(locator)) {
                WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
                element.clear();
                LoggingUtils.info("Cleared input field: " + elementName);
                ExtentReporter.logInfo("Cleared input field: " + elementName, "");
            }
        } catch (NoSuchElementException e) {
            LoggingUtils.error("Failed to clear input field: " + elementName);
            ExtentReporter.logFail("Failed to clear input field: " + elementName, "Caused: " + e);
            throw new AssertionError("Failed to clear input field: " + elementName);
        }
    }

    public void clearField(WebElement locator){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            locator.clear();
            LoggingUtils.info("Element " + locator + " field cleared");
        }catch (Exception e)
        {
            ExtentReporter.logFail("clearField", ""+ e);
            LoggingUtils.error("Failed to clear element " + locator);
        }
    }
    public boolean isChecked(WebElement locator){
        try{
            return locator.isSelected();
        }catch (Exception e){
            LoggingUtils.error(""+e);
            return false;
        }
    }

    public boolean isUnchecked(WebElement locator) {
        try {
            return !locator.isSelected();
        } catch (Exception e) {
            LoggingUtils.error("" + e);
            return false;
        }
    }
    public String getValue(WebElement locator) {
        String val = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
            val = element.getAttribute("value");
        } catch (Exception e) {
            ExtentReporter.logFail("Cannot get value for element" + e.getMessage(), "Caused: " + e);
            LoggingUtils.error("Cannot get value for element" + e.getMessage());
            throw new AssertionError("Cannot get value for element" + e.getMessage());
        }
        return val;

    }
    public double parseTotalValue(String total) {
        total = total.replaceAll(",", ""); // Remove commas if present
        String numericPart = total.replaceAll("[^0-9.]", ""); // Extract numeric part by removing non-numeric characters
        return Double.parseDouble(numericPart);
    }
    public void navigateBack(){
        try{
            driver.navigate().back();
            LoggingUtils.info("Navigating back");
            ExtentReporter.logInfo("Navigating Back" , "Previous Page");
        }catch (Exception e){
            throw new AssertionError("Cannot get value for element" + e.getMessage());
        }
    }

    /**
     * Checks if an element is present on the web page.
     *
     * @param locator The locator of the element to be checked.
     * @return true if the element is present, false otherwise.
     */
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    /**
     * Checks if an element is clickable on the web page.
     *
     * @param locator The locator of the element to be checked.
     * @return true if the element is clickable, false otherwise.
     */
    public boolean isElementClickable(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    /**
     * Checks if an element is present on the page.
     *
     * @param by The locator used to find the element.
     * @return true if the element is present, false otherwise.
     */
    public boolean isPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}


