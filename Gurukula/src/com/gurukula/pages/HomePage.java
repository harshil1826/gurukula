package com.gurukula.pages;
import org.apache.http.entity.EntityTemplate;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	 WebDriver driver;


	 
	 @FindBy(xpath="//*[@translate='main.logged.message']")

	    WebElement homepagetitle;
	 
	 @FindBy(xpath="//*[@translate='global.menu.entities.main']")

	    WebElement entitiesmenu;
	 
	 @FindBy(xpath="//*[@translate='global.menu.entities.branch']")

	    WebElement branch;
	 
	 @FindBy(xpath="//*[@translate='global.menu.entities.staff']")

	    WebElement staff;
	 

	    

	    public HomePage(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }

	    

	    
	    public void clickEntitiesMenu(){
	    	entitiesmenu.click();
	    	
	    }
	    
	    public void clickbranch(){
	    	branch.click();
	    	
	    }
	    
	    public void clickstaff(){
	    	staff.click();
	    	
	    }
	    

	        public String getHomePageDashboardUserName(){

	         return    homepagetitle.getText();

	        }
	
	

}
