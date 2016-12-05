package com.gurukula.pages;
import org.apache.http.entity.EntityTemplate;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class StaffPage {
	WebDriver driver;

	@FindBy(xpath=" //*[@class='ng-scope' and contains(text(), 'Staffs')]")
    public WebElement staffsTitle;
	
	
	@FindBy(xpath=" //*[@class='btn btn-primary']/span[contains(text(),'Create a new Staff')]")
	public WebElement createNewStaff;
	
	
	@FindBy(xpath="//*[@name='name']")
    public WebElement name;
	
	@FindBy(xpath=".//select[@name='related_branch']")
    public WebElement branch;
	
	
	@FindBy(xpath=".//select[@class='form-control ng-pristine ng-untouched ng-valid']/option[2]")
    public WebElement branchValue;
 	
	
 	
 	@FindBy(xpath="//*[@class='btn btn-primary' and @type='submit']")
    public WebElement saveButton;
 	
 	@FindBy(xpath="//*[@class='ng-binding' and contains(text(),'Rohan')]")
    public WebElement verifyStaff;
 	
 	@FindBy(xpath="//*[@id='searchQuery']")
    public WebElement searchTextBox ;
 	
 	@FindBy(xpath="//*[@class='btn btn-info']/span[contains(text(),'Search a Staff')]")
    public WebElement searchStaffButton ;
 	
 	@FindBy(xpath=" //*[@class='btn btn-info btn-sm' and @href='#/staff/1']/span[contains(text(),'View')]")
    public WebElement viewStaffButton ;
 	
 	@FindBy(xpath="//*[@value='Rohan']")
    public WebElement staffName ;
 	
 	
 	@FindBy(xpath="//*[@class='table-responsive']/table/tbody/tr[1]/td[4]/button[2]")
    public WebElement editStaffButton ;
 	
 	@FindBy(xpath="//*[@class='table-responsive']/table/tbody/tr[1]/td[4]/button[3]")
    public WebElement deleteStaffButton ;
 	
 	@FindBy(xpath="//*[@class='btn btn-danger']/span[contains(text(),'Delete')]")
    public WebElement confirmDelete;
 	
	@FindBy(xpath="//*[@class='pager']/li[1]/a")
    public WebElement firstPage;
	
	@FindBy(xpath="//*[@class='pager']/li[4]/a")
    public WebElement lastPage;
	
 	
 	
 	
 	public StaffPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public String getStaffsPagetitle(){
         return    staffsTitle.getText();
        }
 	
	public void createStaff() throws InterruptedException{
		createNewStaff.click();
		Thread.sleep(2000);
		name.sendKeys("Rohan");
		Thread.sleep(2000);
		branchValue.click();
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);
	}
	
	public void verifyBranchByName(){
 		verifyStaff.isDisplayed();
 	}
	
	public void searchTextBoxByName() throws InterruptedException{
		searchTextBox.sendKeys("Rohan");
		Thread.sleep(2000);
		searchStaffButton.click();
	}
	
		public void clickViewButton(){
		viewStaffButton.click();
	}
		
		public void clickEditButton(){
			editStaffButton.click();
		}
	
		public void verifyStaffName(){
		staffName.isDisplayed();
	}
	
		public void editStaffName() throws InterruptedException{
			name.clear();
			name.sendKeys("Bharvi");
			Thread.sleep(4000);
			saveButton.click();
		}
	    
		public void verifyPaginationButtons(){
			firstPage.isDisplayed();
			firstPage.click();
			lastPage.isDisplayed();
			lastPage.click();
		}
}
