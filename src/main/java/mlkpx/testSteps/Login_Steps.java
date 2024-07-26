package mlkpx.testSteps;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.ReusableComponents.TOTPGenerator;

public class Login_Steps extends Base_Steps {

    public void signInGoogle(String role)throws NoSuchElementException {
        try{
            click(googlePageObjects.signInWithKPX(),"Sign in With KPX");
            click(googlePageObjects.googleContainer(), "Google Sign in Container");
            switchToNextTab();
            waitUntilLoadingGone(10000);
            typeEnter(googlePageObjects.emailField(), "Email Field", reader.getEmailByRole(role));
            typeEnter(googlePageObjects.passwordField(), "Password Field", reader.getPasswordByRole(role));
//            click(googlePageObjects.anotherWayButton(), "Another way");
//            click(googlePageObjects.selectGoogleAuthenticator(), "Google Auth Option");
            typeEnter(googlePageObjects.codeField(), "Auth Key Field", TOTPGenerator.getTwoFactorCode());
            switchToPreviousTab();
        }catch (Exception e){
            click(googlePageObjects.selectGoogleAuthenticator(), "Google Auth Option");
            typeEnter(googlePageObjects.codeField(), "Auth Key Field", TOTPGenerator.getTwoFactorCode());
            switchToPreviousTab();
        }
    }
    public void signInGoogle2()throws NoSuchElementException {

        click(googlePageObjects.signInWithKPX(), "Sign in With KPX");
        click(googlePageObjects.googleContainer(), "Google Sign in Container");
        switchToNextTab();
        waitUntilLoadingGone(10000);
        click(googlePageObjects.emailAlbertContainer2(), "emailAlbertContainer2");
        switchToPreviousTab();
    }
    public void signInGoogleV2()throws Exception{
        // logging in google via clicking the email, this only happens when browser is not closed
        try{
            click(googlePageObjects.googleContainer(), "Google Sign in Container");
            switchToNextTab();
            click(googlePageObjects.chooseCurrentAccount(), getText(googlePageObjects.chooseCurrentAccount()));
            switchToPreviousTab();
        }catch (Exception e){
            click(googlePageObjects.googleContainer2(), "Google Sign in Container");
            switchToNextTab();
            click(googlePageObjects.chooseCurrentAccount(), getText(googlePageObjects.chooseCurrentAccount()));
            switchToPreviousTab();
        }
    }
    public void loginKpx(String role)throws Exception{
        waitSleep(5000);
        try{
            type(loginPageObjects.userNameField(),"kpx username field", reader.getKpxUsername(role));
            type(loginPageObjects.passwordField(), "kpx password field", reader.getKpxPassword(role));
            click(loginPageObjects.loginButton(), "Login button");

        }catch (Exception e){
            ExtentReporter.logFail("loginKpx, ","error "+ e);
        }
    }
    public void loginKpxInactiveAccount(String role)throws Exception{
        waitSleep(5000);
        try{
            type(loginPageObjects.userNameField(),"kpx username field", reader.getUsernameInActiveAccount(role));
            type(loginPageObjects.passwordField(), "kpx password field", reader.getPasswordInActiveAccount(role));
            click(loginPageObjects.loginButton(), "Login button");
            if(isVisible(usersPageObjects.userIsInActiveText(), getText(usersPageObjects.userIsInActiveText()))){
                ExtentReporter.logPass("U_TC_21", "Successfully verify Inactive an account");
            }else{
                ExtentReporter.logFail("U_TC_21", "Fail to verify Inactive an account");
                Assert.fail("Fail to verify Inactive an account");
            }
            click(usersPageObjects.okButton(),"OK Button");

        }catch (Exception e){
            ExtentReporter.logFail("loginKpxInactiveAccount, ","error "+ e);
        }
    }
    public void newBranchUser()throws Exception{
        waitSleep(5000);
        try{
            String usernameNewBranchUser = reader.getUsernameNewBranchUser();
            type(loginPageObjects.userNameField(),"kpx username field", usernameNewBranchUser);
            String passwordNewBranchUser = reader.getPasswordNewBranchUser();
            type(loginPageObjects.passwordField(), "kpx password field", passwordNewBranchUser);
            click(loginPageObjects.loginButton(), "Login button");

        }catch (Exception e){
            ExtentReporter.logFail("newBranchUser, ","error "+ e);
        }
    }
    public void isInvalidAccount(){
        if(isVisible(loginPageObjects.invalidCredText(), getText(loginPageObjects.invalidCredText()))){
            ExtentReporter.logPass("isInvalidAccount ","Successfully Validated Invalid Account");
        }else{
            ExtentReporter.logFail("isInvalidAccount ","Failed to Validate");
        }

    }
}
