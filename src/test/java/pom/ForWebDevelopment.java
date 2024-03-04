package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForWebDevelopment extends Basepage{
	WebDriver driver;
	public ForWebDevelopment(WebDriver driver)
	{
		
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='rendered-content']/div/header/div/div/div[2]/div[1]/div[3]/div/form/div/div[1]/input")
	WebElement search;
	
	@FindBy(xpath="//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']")
	WebElement btn;
	
	@FindBy(xpath="//span[@class='cds-checkboxAndRadio-labelContent css-imksha']//*[contains(text(),'Beginner')]")
	WebElement beginner;
	
	@FindBy(xpath="/html/body/div[7]/div[3]/div/div/div[2]/div[3]/button[1]/span")
	WebElement applybtn;
	
	@FindBy(xpath="//*[@id='rendered-content']/div/div/span/div[1]/header/div[1]/div/div/div[1]/div[2]/div/div[2]/div/div/a/div/img")
	WebElement home;
	
	public void search(String course)
	{
		search.sendKeys(course);
		
	}
	public void searchbutton()
	{
		btn.click();
	}
	
	public void level()
	{
		beginner.click();
	}
	public void apply()
	{
		applybtn.click();
	}
	public void homePage()
	{
		home.click();
	}
	
	

}
