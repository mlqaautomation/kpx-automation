package utilities.Driver;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utilities.Logger.LoggingUtils;
import utilities.ApkPath.Apk;
import java.util.Map;
public class AppiumDriverManager {
    //todo *
    protected static final String IP_Address = "127.0.0.1";
    protected static final int PORT = 4723;
    private static AppiumDriverLocalService service;
    protected static AndroidDriver driver;
    public static final String APP_ID = "com.mlhuillier.mlwallet";
    public static final String APP_Activity = "MainActivity";

    public static void setupServer(){
        service = new AppiumServiceBuilder()
                .withIPAddress(IP_Address)
                .usingPort(PORT)
                .build();
        service.start();
        LoggingUtils.info("Starting Service----");
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setApp(Apk.API_DEMOS_APK.toString())
                .autoGrantPermissions()
                .setAutomationName("uiautomator2")
                .setNoReset(false).headless()
                .eventTimings();
        driver = new AndroidDriver(service.getUrl(), options);
    }
    public static void stopServer(){
        if(driver != null){
            driver.quit();

        }
        if(service != null){
            service.stop();
        }
    }
    public static void startActivity(){
        Map<String, String> args = new java.util.HashMap<>();
        args.put("component", String.format("%s/%s", APP_ID, APP_Activity));
        LoggingUtils.info("Starting Activity......" + APP_ID +"/" + APP_Activity);
        driver.executeScript(
                "mobile: startActivity",
                args
        );
    }
    public static void clearApp(){
        Map<String, String> args = new java.util.HashMap<>();
        args.put("component", String.format("%s/%s", APP_ID, APP_Activity));
        LoggingUtils.info("Clear APP......");
        driver.executeScript(
                "mobile: clearApp",
                ImmutableMap.of("appId", APP_ID)
        );
    }
    public static void resetApp(){
        clearApp();
        startActivity();
    }
    public static AndroidDriver getAndroidDriver() {
        return driver;
    }

}
