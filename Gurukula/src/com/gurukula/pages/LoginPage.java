package com.gurukula.pages;


import org.eclipse.jetty.util.security.Password;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	/**

     * All WebElements are identified by @FindBy annotation

     */

    WebDriver driver;
    
    @FindBy(xpath="//*[@translate='main.title']")

    WebElement title;
    

    @FindBy(linkText="login")

   public WebElement loginlink;
    
    
    @FindBy(linkText="Register a new account")

    public WebElement registrationLink;
    
    
    @FindBy(xpath="//*[@id='username']")

    WebElement userName;
    

    @FindBy(id="password")

    WebElement password;
    
    @FindBy(xpath="//*[@class='btn btn-primary ng-scope']")

    WebElement loginButton;
    
    
    @FindBy(xpath="//*[@translate='login.messages.error.authentication']")

    public WebElement loginError;
   
    @FindBy(xpath="//*[@class='hidden-tablet ng-scope' and contains(text(),'Account')]")
    public WebElement accountButton;
   
    @FindBy(xpath="  //*[@class='ng-scope' and contains(text(),'Log out')]")
    public WebElement logoutButton;

    
    public LoginPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    
    public void clickloginLink(){
    	
    	loginlink.isDisplayed();
        loginlink.click();

}
    
    public void clickRegistrationLink(){
    	
    	registrationLink.isDisplayed();
    	registrationLink.click();

}


    public void setUserName(String strUserName){

        userName.sendKeys(strUserName);

        

    }

    

    public void setPassword(String strPassword){

    password.sendKeys(strPassword);

    }

    

    public void clickLoginButton(){

            loginButton.click();

    }

    

    public String getLoginTitle(){

     return    title.getText();

    }
    
    
    
    public void verifyAllFields(){
    	userName.isDisplayed();
    	password.isDisplayed();
    	loginButton.isDisplayed();
    	
    }

    
    public void loginToGurukula(String strUserName,String strPasword) throws InterruptedException{
    	
    	this.clickloginLink();
        
        this.setUserName(strUserName);

        this.setPassword(strPasword);
        
       // Thread.sleep(5000);
        

        this.clickLoginButton();

    }

    public void logOut() throws Exception{
    	accountButton.click();
        Thread.sleep(2000);
        logoutButton.click();
        

    }
	
}
