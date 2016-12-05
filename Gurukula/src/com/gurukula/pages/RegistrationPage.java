package com.gurukula.pages;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {
	
	WebDriver driver;


	 
		@FindBy(xpath="//*[@class='ng-scope' and contains(text(), 'Registration')]")
	    public WebElement registrationpagetitle;
	 
	 
		@FindBy(xpath="//*[@name='login']")
	    public WebElement login;
		
		@FindBy(xpath="//*[@name='email']")
	    public WebElement email;
	 	
	 	
		@FindBy(xpath="//*[@name='password']")
	    public WebElement password;
	 	
		@FindBy(xpath="//*[@name='confirmPassword']")
	    public WebElement confirmPassword;
	 	
	 	
	 	@FindBy(xpath="//*[@type='submit']")
	    public WebElement registerButton;
	 	
	    

	    public RegistrationPage(WebDriver driver){

	    	this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }
	    
	    
	    public void setLogin(String strLogin){
	        login.sendKeys(strLogin);
	    }
	    
	    public void setEmail(String strEmail){
	        email.sendKeys(strEmail);
	    }
	    

	    public void setPassword(String strPassword){
	    password.sendKeys(strPassword);
	    }
	    
	    public void setConfirmPassword(String strConfirmPassword){
		    confirmPassword.sendKeys(strConfirmPassword);
		    }
	    
	    public void clickRegisterButton(){
	    	registerButton.isDisplayed();
	    	registerButton.click();
	    	
	    }
	    
	    
	    public void fillRegistrationFields(String strLogin,String strEmail, String strPasword,String strConfirmPassword) throws InterruptedException{
	    	
	    	this.setLogin(strLogin);
	    	
	    	Thread.sleep(2000);
	        
	        this.setPassword(strPasword);
	        Thread.sleep(2000);

	        this.setConfirmPassword(strConfirmPassword);
	        Thread.sleep(2000);

	        this.setEmail(strEmail);
	        Thread.sleep(2000);

	        this.clickRegisterButton();

	    }

	    

	    

	        public String getRegistrationPageTitle(){

	         return    registrationpagetitle.getText();

	        }
	
	

}
