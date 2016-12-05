package com.gurukula.pages;
import org.apache.http.entity.EntityTemplate;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class BranchesPage {

	WebDriver driver;

	@FindBy(xpath="//*[@class='ng-scope' and contains(text(), 'Branches')]")
    public WebElement branchesTitle;
	
	
	@FindBy(xpath="//*[@class='btn btn-primary']/span[contains(text(),'Create a new Branch')]")
	public WebElement createNewBranch;
	
	
	@FindBy(xpath="//*[@name='name']")
    public WebElement name;
 	
 	@FindBy(xpath="//*[@name='code']")
    public WebElement code ;
 	
 	@FindBy(xpath="//*[@class='btn btn-primary' and @type='submit']")
    public WebElement saveButton;
 	
 	@FindBy(xpath="//*[@class='ng-binding' and contains(text(),'Boston')]")
    public WebElement verifyBranch;
 	
 	@FindBy(xpath="//*[@id='searchQuery']")
    public WebElement searchTextBox ;
 	
 	@FindBy(xpath="//*[@class='btn btn-info']/span[contains(text(),'Search a Branch')]")
    public WebElement searchBranchButton ;
 	
 	@FindBy(xpath="//*[@class='btn btn-info btn-sm' and @href='#/branch/1']/span[contains(text(),'View')]")
    public WebElement viewBranchButton ;
 	
 	@FindBy(xpath="//*[@value='Boston']")
    public WebElement branchName ;
 	
 	@FindBy(xpath="//*[@value='2222']")
    public WebElement branchCode ;
 	
 	@FindBy(xpath="//*[@class='table-responsive']/table/tbody/tr[1]/td[4]/button[2]")
    public WebElement editBranchButton ;
 	
 	@FindBy(xpath="//*[@class='table-responsive']/table/tbody/tr[1]/td[4]/button[3]")
    public WebElement deleteBranchButton ;
 	
 	@FindBy(xpath="//*[@class='btn btn-danger']/span[contains(text(),'Delete')]")
    public WebElement confirmDelete;
 	
 	 
 	
 	
 	
 	public BranchesPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public String getBranchesPagetitle(){
         return    branchesTitle.getText();
        }
 	
	public void createBranch() throws InterruptedException{
		createNewBranch.click();
		Thread.sleep(2000);
		code.sendKeys("2222");
		Thread.sleep(2000);
		name.sendKeys("Boston");
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);
	}
	
	public void verifyBranchByName(){
 		verifyBranch.isDisplayed();
 	}
	
	public void searchTextBoxByName() throws InterruptedException{
		searchTextBox.sendKeys("Boston");
		Thread.sleep(2000);
		searchBranchButton.click();
	}
	
		public void clickViewButton(){
		viewBranchButton.click();
	}
		
		public void clickEditButton(){
			editBranchButton.click();
		}
	
		public void verifyBranchNameAndCode(){
		branchName.isDisplayed();
		branchCode.isDisplayed();
	}
	
		public void editBranchNameAndCode() throws InterruptedException{
			name.clear();
			name.sendKeys("Miami");
			code.clear();
			code.sendKeys("9999");
			Thread.sleep(4000);
			saveButton.click();
		}
	    
	
	
}
