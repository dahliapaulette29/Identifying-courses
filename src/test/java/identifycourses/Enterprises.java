package identifycourses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pom.ForEnterprise;

import utilities.ExcelUtility;
import utilities.Screenshot;


public class Enterprises extends Baseclass {
	
	//public static WebDriver driver;
	Screenshot s;
	public Enterprises() 
	{
		s=new Screenshot();
	}
	@Test(priority=0,groups= {"smoke","regression","master"})
	public void forEnterprises() throws InterruptedException, IOException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@id='rendered-content']/div/div[1]/footer/div/div/div/div[5]/p")));
		ForEnterprise enter=new ForEnterprise(driver);
		enter.forEnterprise();
		Thread.sleep(3000);
		Screenshot.screen(driver, "enterprise");
		enter.chooseSolution();
		Thread.sleep(3000);
		Screenshot.screen(driver, "choose Solution");
		enter.chooseCourseraforcampus();
		Thread.sleep(5000);
		Screenshot.screen(driver, "Coursera for Campus");
		Thread.sleep(2000);
	}
	@Test(priority=1,groups= {"regression","master"})
	public void readyToTransform() throws InterruptedException, IOException
	{
		ForEnterprise enter=new ForEnterprise(driver);
		ExcelUtility excel=new ExcelUtility();
		String data[]=excel.readExcelData();
		
		JavascriptExecutor js4=(JavascriptExecutor)driver;
		js4.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/main/div/div[7]/div/div[2]/div/div/div/div/div/div[2]/div[3]")));
		Thread.sleep(4000);
		enter.giveFirstname(data[0]);
		Thread.sleep(4000);
		enter.giveLastname(data[1]);
		Thread.sleep(4000);
		enter.giveMail(data[2]);
		Thread.sleep(4000);
		enter.givePhonenumber(data[3]);
		Thread.sleep(4000);
		enter.givecname(data[4]);
		Thread.sleep(4000);
	}
	@Test(priority=2,groups= {"regression","master"})
	public void dropDowns() throws InterruptedException, IOException
	{
		ForEnterprise enter=new ForEnterprise(driver);
		enter.chooseInstitute();
		Thread.sleep(2000);
		enter.chooseJobrole();
		Thread.sleep(2000);
		enter.choosseDepartment();
		Thread.sleep(2000);
		enter.chooseDescribe();
		Thread.sleep(2000);
		enter.chooseCountry();
		Thread.sleep(2000);
		enter.chooseState();
		Thread.sleep(2000);
		Screenshot.screen(driver, "submission");
		enter.clickSubmit();
		Thread.sleep(4000);
		
	}
	@Test(priority=3,groups= {"regression","master"})
	public void errorMessage() throws IOException
	{
		ForEnterprise enter=new ForEnterprise(driver);
		Screenshot.screen(driver, "error message");
		String error=enter.eMessage();
		System.out.println();
		System.out.println("Error Message :"+error);
	}

}
