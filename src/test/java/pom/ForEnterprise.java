package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ForEnterprise extends Basepage{
	WebDriver driver;
	public ForEnterprise(WebDriver driver)
	{
		
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='rendered-content']/div/div[1]/footer/div/div/div/div[5]/ul/li[10]/a")
	WebElement enterprise;
	
	@FindBy(xpath="//*[@id='rendered-content']/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/div[2]/a")
	WebElement solution;
	
	@FindBy(xpath="//*[@id='rendered-content']/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/div/div/div/div[2]/div/div[2]/a/p")
	WebElement courseraforcampus;
	
	@FindBy(id="FirstName")
	WebElement firstname;
	
	@FindBy(id="LastName")
	WebElement lastname;
	
	@FindBy(id="Email")
	WebElement email ;
	
	@FindBy(id="Phone")
	WebElement phonenumber;
	
	@FindBy(id="Company")
	WebElement cname;
	
	@FindBy(id="Institution_Type__c")
	WebElement institution;
	
	@FindBy(id="Title")
	WebElement jobrole;
	
	@FindBy(id="Department")
	WebElement dept;
	
	@FindBy(id="What_the_lead_asked_for_on_the_website__c")
	WebElement describe;
	
	@FindBy(id="Country")
	WebElement countryname;
	
	@FindBy(id="State")
	WebElement statename;
	
	@FindBy(xpath="//*[@id='mktoForm_1512']/div[50]/span/button")
	WebElement submitbutton;
	
	@FindBy(id="ValidMsgPhone")
	WebElement errormsg;
	
	public void forEnterprise()
	{
		enterprise.click();
	}
	public void chooseSolution()
	{
		solution.click();
	}
	public void chooseCourseraforcampus()
	{
		courseraforcampus.click();
	}
	public void giveFirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	public void giveMail(String mail)
	{
		email.sendKeys(mail);
	}
	public void giveLastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	public void givePhonenumber(String num)
	{
		phonenumber.sendKeys(num);
	}
	public void givecname(String col)
	{
		cname.sendKeys(col);
	}
	public void chooseInstitute()
	{
		Select Institutiontype=new Select(institution);
		Institutiontype.selectByVisibleText("Other");
	}
	public void chooseJobrole()
	{
		Select Jobrole=new Select(jobrole);
		Jobrole.selectByVisibleText("Student");
	}
	public void choosseDepartment()
	{
		Select Department=new Select(dept);
		Department.selectByVisibleText("Continuing Education");
	}
	public void chooseDescribe()
	{
		Select bestdescribes=new Select(describe);
		bestdescribes.selectByVisibleText("Tech Support");
	}
	public void chooseState()
	{
		Select state=new Select(statename);
		state.selectByVisibleText("Tamil Nadu");
	}
	public void chooseCountry()
	{
		Select country=new Select(countryname);
		country.selectByVisibleText("India");
	}
	public void clickSubmit()
	{
		submitbutton.click();
	}
	public String eMessage() {
		
		String name = errormsg.getText();
		return name;
	}
	

}
