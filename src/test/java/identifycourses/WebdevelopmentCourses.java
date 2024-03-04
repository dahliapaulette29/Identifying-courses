package identifycourses;
 
import java.io.IOException;
import java.util.Set;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pom.Firstcoursepage;
import pom.ForWebDevelopment;
import pom.Secondcoursepage;

import utilities.ExcelUtility;
import utilities.Screenshot;
 
public class WebdevelopmentCourses extends Baseclass {
	
	public String oldwindow;
	Screenshot s;
	public WebdevelopmentCourses() 
	{
		s=new Screenshot();
	}
	@Test(priority=0,groups= {"smoke","regression","master"})
	public void searchingWebDevelopmentCourses() throws InterruptedException, IOException
	{
		ForWebDevelopment web=new ForWebDevelopment(driver);
		ExcelUtility excel=new ExcelUtility();
		//Screenshot s=new Screenshot();
		String searchvalue=excel.readDataweb();
		web.search(searchvalue);
		Screenshot.screen(driver, "websearch");
		Thread.sleep(6000);
		web.searchbutton();
		Thread.sleep(6000);
	}
	@Test(priority=1,groups= {"regression","master"})
	public void selectinglevel() throws InterruptedException, IOException
	{
		
		ForWebDevelopment web=new ForWebDevelopment(driver);
		//Screenshot s=new Screenshot();
		Thread.sleep(3000);
		web.level();
		Thread.sleep(3000);
		Screenshot.screen(driver, "selecting level");
		
	}
	@Test(priority=2,groups= {"regression","master"})
	public void selectinglanguages() throws InterruptedException, IOException
	{
		ForWebDevelopment web=new ForWebDevelopment(driver);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		//Screenshot s=new Screenshot();
		js1.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[contains(text(), 'Language')]")));
		Thread.sleep(3000);
		//show more
		js1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='cds-checkboxAndRadio-labelContent css-imksha']//*[contains(text(),'English')]")));
		Thread.sleep(3000);
		/*js1.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@placeholder='Search for Language']")));
		driver.findElement(By.xpath("//*[@placeholder='Search for Language']")).sendKeys("English");
		Thread.sleep(3000);
		js1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"checkbox-group\"]/div/label/span")));
		Thread.sleep(7000);*/
		Screenshot.screen(driver, "selecting language");
		//web.apply();
		Thread.sleep(6000);
		Screenshot.screen(driver, "courses");
	}
	@Test(priority=3,groups= {"regression","master"})
	public void firstCourse() throws InterruptedException, IOException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Firstcoursepage fcp=new Firstcoursepage(driver);
		//Screenshot s=new Screenshot();
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[contains(text(), 'Filter by')]")));
		Thread.sleep(6000); 
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//*[@class='cds-CommonCard-title css-1sktkql'])[1]")));
		//String n1=driver.findElement(By.xpath("(//*[@class='cds-CommonCard-title css-1sktkql'])[1]")).getText();
		//String d1=driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/main/div[2]/div/div/div/div/div[2]/ul[1]/li[1]/div/div/div/div/div/div[2]/div[3]/div[3]/p")).getText();
		//String r1=driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/main/div[2]/div/div/div/div/div[2]/ul[1]/li[1]/div/div/div/div/div/div[2]/div[3]/div[2]")).getText();
		oldwindow=driver.getWindowHandle();
		Set<String>handle=driver.getWindowHandles();
		for(String newwindow1:handle)
		{	
			driver.switchTo().window(newwindow1);
		}
		System.out.println("Course-1");
		System.out.println("-----------");
		Screenshot.screen(driver, "course1");
		Thread.sleep(2000);
		String n1=fcp.getCourseName1();
		String d1=fcp.getDuration1();
		String r1=fcp.getRating();
		System.out.println("Course Name :"+n1);
		System.out.println("Course Duration :"+d1);
		System.out.println("Course Rating :"+r1);
		driver.close();
		driver.switchTo().window(oldwindow);
		System.out.println("-------------------");
		Thread.sleep(6000);
	}
	@Test(priority=4,groups= {"regression","master"})
	public void secondCourse() throws InterruptedException, IOException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//Screenshot s=new Screenshot();
		ForWebDevelopment web=new ForWebDevelopment(driver);
		Secondcoursepage scp=new Secondcoursepage(driver);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//*[@class='cds-CommonCard-title css-1sktkql'])[2]")));
		Set<String>handles1=driver.getWindowHandles();
		for(String newwindow2:handles1)
		{
			driver.switchTo().window(newwindow2);
		}
		//String n2=driver.findElement(By.xpath("//*[@class='cds-CommonCard-title css-1sktkql'])[2]")).getText();
		//String d2=driver.findElement(By.xpath("//*[@class='cds-CommonCard-metadata']/p)[2]\")")).getText();
		//String r2=driver.findElement(By.xpath("//*[@class='cds-119 css-11uuo4b cds-121'])[2]")).getText();
		System.out.println("Course-2");
		System.out.println("-----------");
		Screenshot.screen(driver, "course2");
		String n2=scp.getCourseName2();
		String d2=scp.getDuration2();
		String r2=scp.getRating2();
		System.out.println("Course Name :"+n2);
		System.out.println("Course Duration :"+d2);
		System.out.println("Course Rating :"+r2);
		System.out.println("-------------------");
		driver.close();
		driver.switchTo().window(oldwindow);
		Thread.sleep(6000);
		web.homePage();
		//driver.navigate().back();
	}
 
}