package com.gurukula.testsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.gurukula.pages.LoginPage;
import com.gurukula.pages.RegistrationPage;
import com.gurukula.pages.StaffPage;
import com.gurukula.pages.BranchesPage;
import com.gurukula.pages.HomePage;


public class TestCases {
	
	WebDriver driver;

    LoginPage objLogin;

    HomePage objHomePage;
    
    RegistrationPage objRegistrationpage;
    
    BranchesPage objBranchPage; 
    
    StaffPage objStaffPage;

    @BeforeSuite

    public void setup(){
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\harsh\\geckodriver-v0.11.1-win64\\geckodriver.exe");
    	driver =new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/gurukula-0.0.1-SNAPSHOT/#/");
    }
    
    /*This test case verifies that all the fields on login page display correctly. */
    @Test(priority=0)
    public void verifyAllFieldsOnLoginPage() throws InterruptedException{
    objLogin = new LoginPage(driver);
    String loginPageTitle = objLogin.getLoginTitle();
    Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
    objLogin.clickloginLink();
    Thread.sleep(5000);
    objLogin.verifyAllFields();
    }



     /*This TestCase verifies the login page title, Logs in the user successfully and verifies
       that the home page is displayed */
    @Test(priority=1)
    public void successfulLogin() throws InterruptedException{
    objLogin = new LoginPage(driver);
    String loginPageTitle = objLogin.getLoginTitle();
    Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
    Thread.sleep(5000);
    objLogin.loginToGurukula("admin", "admin");
    objHomePage = new HomePage(driver);
    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
    }
    
    
    /*  This TestCase verifies the login page title, Fails to Login the user and verifies
    that error message is displayed */
    @Test(priority=2)
    public void uncessfulLogin() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        objLogin.loginToGurukula("admin", "wrongpassword");
        Thread.sleep(2000);
        String loginerror = objLogin.loginError.getText();
        System.out.println(loginerror);
        Thread.sleep(2000);
        Assert.assertTrue(loginerror.contains("Authentication failed!"));
    }
    
   
    /*  This TestCase to navigate to registration page */
    @Test(priority=3)
    public void registrationPage() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        objLogin.clickRegistrationLink();
    }
    
    
    /*  This TestCase clicks entity and goes to branches page*/
    @Test(priority=4)
    public void goToBranches() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
        objHomePage.clickEntitiesMenu();
        Thread.sleep(4000);
        objHomePage.clickbranch();
        objBranchPage = new BranchesPage(driver);
        Thread.sleep(4000);
        Assert.assertTrue(objBranchPage.getBranchesPagetitle().contains("Branches"));
     
    }
    
    /*This test case creates a new branch*/
    @Test(priority=5)
    public void createNewBranches() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
        objHomePage.clickEntitiesMenu();
        Thread.sleep(4000);
        objHomePage.clickbranch();
        objBranchPage = new BranchesPage(driver);
        Thread.sleep(4000);
        Assert.assertTrue(objBranchPage.getBranchesPagetitle().contains("Branches"));
        objBranchPage.createBranch();
        Thread.sleep(4000);
        objBranchPage.verifyBranchByName();
       
    }
    
    /*This test case searches an already created branch*/
    @Test(priority=6)
    public void searchACreatedBranches() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
        objHomePage.clickEntitiesMenu();
        Thread.sleep(2000);
        objHomePage.clickbranch();
        objBranchPage = new BranchesPage(driver);
        Thread.sleep(2000);
        Assert.assertTrue(objBranchPage.getBranchesPagetitle().contains("Branches"));
        objBranchPage.searchTextBoxByName();
        Thread.sleep(2000);
        objBranchPage.verifyBranchByName();
    }
    
    /*This test case tests the use of the view button on branches page*/
    @Test(priority=7)
    public void viewBranch() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
        objHomePage.clickEntitiesMenu();
        Thread.sleep(2000);
        objHomePage.clickbranch();
        objBranchPage = new BranchesPage(driver);
        Thread.sleep(2000);
        Assert.assertTrue(objBranchPage.getBranchesPagetitle().contains("Branches"));
        objBranchPage.clickViewButton();
        Thread.sleep(2000);
        objBranchPage.verifyBranchNameAndCode();
    }
    
    /*This test case is used to edit an already created branch*/
    @Test(priority=8)
    public void editBranch() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
        objHomePage.clickEntitiesMenu();
        Thread.sleep(2000);
        objHomePage.clickbranch();
        objBranchPage = new BranchesPage(driver);
        Thread.sleep(2000);
        Assert.assertTrue(objBranchPage.getBranchesPagetitle().contains("Branches"));
        objBranchPage.clickEditButton();
        Thread.sleep(2000);
        objBranchPage.editBranchNameAndCode();
    }
    
    /*This test deletes an existing branch*/
    @Test(priority=9)
    public void deleteBranch() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
        objHomePage.clickEntitiesMenu();
        Thread.sleep(2000);
        objHomePage.clickbranch();
        objBranchPage = new BranchesPage(driver);
        Thread.sleep(2000);
        Assert.assertTrue(objBranchPage.getBranchesPagetitle().contains("Branches"));
        objBranchPage.deleteBranchButton.click();
        Thread.sleep(2000);
        objBranchPage.confirmDelete.click();
    }
    
    /*This test case clicks entity and goes to the staff page*/
    @Test(priority=10)
    public void goToStaff() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
        objHomePage.clickEntitiesMenu();
        Thread.sleep(4000);
        objHomePage.clickstaff();
        objStaffPage = new StaffPage(driver);
        Thread.sleep(4000);
        Assert.assertTrue(objStaffPage.getStaffsPagetitle().contains("Staffs"));
    }
    
    /*This test case creates a new staff*/
    @Test(priority=11)
    public void createStaff() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
	
	objHomePage.clickEntitiesMenu();
        Thread.sleep(4000);
        objHomePage.clickbranch();
        objBranchPage = new BranchesPage(driver);
        Thread.sleep(4000);
        Assert.assertTrue(objBranchPage.getBranchesPagetitle().contains("Branches"));
        objBranchPage.createBranch();
        Thread.sleep(4000);
	    
        objHomePage.clickEntitiesMenu();
        Thread.sleep(4000);
        objHomePage.clickstaff();
        objStaffPage = new StaffPage(driver);
        Thread.sleep(4000);
        Assert.assertTrue(objStaffPage.getStaffsPagetitle().contains("Staffs"));
        objStaffPage.createStaff();
    }
    
    /*This test case searches an already created staff*/
    @Test(priority=12)
    public void searchACreatedStaff() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
        objHomePage.clickEntitiesMenu();
        Thread.sleep(2000);
        objHomePage.clickstaff();
        objStaffPage = new StaffPage(driver);
        Thread.sleep(2000);
        Assert.assertTrue(objStaffPage.getStaffsPagetitle().contains("Staffs"));
        objStaffPage.searchTextBoxByName();
        Thread.sleep(2000);
        objStaffPage.verifyBranchByName();
    }
    
    /*This test case tests the use of the view button on staffs page*/
    @Test(priority=13)
    public void viewStaff() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
        objHomePage.clickEntitiesMenu();
        Thread.sleep(2000);
        objHomePage.clickstaff();
        objStaffPage = new StaffPage(driver);
        Thread.sleep(2000);
        Assert.assertTrue(objStaffPage.getStaffsPagetitle().contains("Staffs"));
        objStaffPage.clickViewButton();
        Thread.sleep(2000);
        objStaffPage.verifyStaffName();
    }
    
    /*This test case is used to edit an already created staff*/
    @Test(priority=14)
    public void editStaff() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
        objHomePage.clickEntitiesMenu();
        Thread.sleep(2000);
        objHomePage.clickstaff();
        objStaffPage = new StaffPage(driver);
        Thread.sleep(2000);
        Assert.assertTrue(objStaffPage.getStaffsPagetitle().contains("Staffs"));
        objStaffPage.clickEditButton();
        Thread.sleep(2000);
        objStaffPage.editStaffName();
    }
    
    /*This test deletes an existing staff*/
    @Test(priority=16)
    public void deleteStaff() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
        objHomePage.clickEntitiesMenu();
        Thread.sleep(2000);
        objHomePage.clickstaff();
        objStaffPage = new StaffPage(driver);
        Thread.sleep(2000);
        Assert.assertTrue(objStaffPage.getStaffsPagetitle().contains("Staffs"));
        objStaffPage.deleteStaffButton.click();
        Thread.sleep(2000);
        objStaffPage.confirmDelete.click();
    }
    
    /*This test case tests verifies the presence of pagination button in staffs table. Pagination will redirect to next page after 20 entries*/
    @Test(priority=17)
    public void pagination() throws Exception{
    	objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
        Thread.sleep(5000);
        objLogin.loginToGurukula("admin", "admin");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
        objHomePage.clickEntitiesMenu();
        Thread.sleep(2000);
        objHomePage.clickstaff();
        objStaffPage = new StaffPage(driver);
        Thread.sleep(2000);
        Assert.assertTrue(objStaffPage.getStaffsPagetitle().contains("Staffs"));
        objStaffPage.verifyPaginationButtons();
    }
    
    
    /*This Test Case performs login and logout functions*/
    @Test(priority=18)
    public void logout() throws Exception{
    	    	objLogin = new LoginPage(driver);
    	        String loginPageTitle = objLogin.getLoginTitle();
    	        Assert.assertTrue(loginPageTitle.contains("Welcome to Gurukula!"));
    	        Thread.sleep(5000);
    	        objLogin.loginToGurukula("admin", "admin");
    	        objHomePage = new HomePage(driver);
    	        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("You are logged in as user"));
    	        objLogin.logOut();
    	        
    	
    }
    
    
    @AfterSuite
    public void tearDown(){
    	driver.quit();
    }

}
