package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class Users_Tests extends BaseTest {

    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("helpdesk");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("loginGoogle","Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 1, description = "To verify Navigation for User Page")
    public void verifyNavigationForUserPage()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_01();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 2, description = "To verify Navigation for Add Branch User")
    public void verifyNavigationForAddBranchUser()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_02();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 3, description = "To verify Successful Adding New Branch User")
    public void verifySuccessfulAddingNewBranchUser()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_03();

        }

    }

    @Test(dependsOnMethods = "loginGoogle", priority = 4, description = "To verify Add Branch User - Existing Resource ID")
    public void verifyAddBranchUserExistingResourceID()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_05();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 5, description = "To verify Add Branch User - Empty First Name")
    public void verifyAddBranchUserEmptyFirstName()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_06();

        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 6, description = "To verify Add Branch User - Empty Last Name")
    public void verifyAddBranchUserEmptyLastName()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_07();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 7, description = "To verify Add Branch User - Empty Email")
    public void verifyAddBranchUserEmptyEmail()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_08();

        }

    }
    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "To verify Add Branch User - Don't Select Role")
    public void verifyAddBranchUserDontSelectRole()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_09();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "To verify Add Branch User - invalid Zone ")
    public void verifyAddBranchUserInvalidZone()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_10();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "To verify Add Branch User - invalid Region Name")
    public void verifyAddBranchUserInvalidRegionName()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_11();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To verify Navigation for Branch User in Users Dropdown")
    public void navigationForBranchUserInUsersDropdown()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_12();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To verify Search User ID in Branch Users")
    public void verifySearchUserIDinBranchUsers()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_13();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To verify Search invalid User ID in Branch Users")
    public void verifySearchInvalidUserIDinBranchUsers()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_14();
        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 14, description = "To verify Generate Report Branch User - Invalid Zone")
    public void verifyGenerateReportInBranchUserInvalidZone()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_16();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 15, description = "To verify Generate Report Branch User - Invalid Region Name")
    public void verifyGenerateReportInBranchUserInvalidRegionName()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_17();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 16, description = "Navigate Reliever Page under Users Module")
    public void navigateRelieverPageUnderUsersModule()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_18();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 17, description = "verify Search User ID in Reliever")
    public void verifySearchUserIDinReliever()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_19();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 18, description = "verify Search Invalid User ID in Reliever")
    public void verifySearchUserInvalidIDinReliever()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_20();
        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 19, description = "verify Inactive an account")
    public void verifyInactiveAnAccount()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_21();
        }
    }

    @Test(dependsOnMethods = "loginGoogle", priority = 21,description = "Logging in via gmail and kpx inactive account user")
    public void inactiveAccount()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.homeSteps.logout();
            this.loginSteps.signInGoogle2();
            this.loginSteps.loginKpxInactiveAccount("inactiveAccount");

        }
    }
    @Test(dependsOnMethods = "loginGoogle", priority = 20, description = "To verify Generate Report in branch User")
    public void verifyGenerateReportInBranchUser()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.usersSteps.U_TC_15();
        }
    }
}
