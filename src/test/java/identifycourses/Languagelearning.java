package identifycourses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pom.ForLanguageLearning;

import utilities.ExcelUtility;
import utilities.Screenshot;

public class Languagelearning extends Baseclass {
	
	//public static WebDriver driver;
	Screenshot s;
	public Languagelearning() 
	{
		s=new Screenshot();
	}
	@Test(priority=0,groups= {"smoke","regression","master"})
	public void searchLanguageLearning() throws InterruptedException, IOException
	{
		ForLanguageLearning lang=new ForLanguageLearning(driver);
		ExcelUtility excel=new ExcelUtility();
		String searchvalue=excel.readDatalang();
		lang.search(searchvalue);
		Screenshot.screen(driver, "langsearch");
		Thread.sleep(3000);
		lang.searchbutton();
		Thread.sleep(3000);
	}
	@Test(priority=1,groups= {"regression","master"})
	public void levelCount() throws InterruptedException, IOException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[contains(text(), 'Level')]")));
		List<WebElement>levels=new ArrayList<WebElement>();
		levels = driver.findElements(By.xpath("//div[@data-testid=\"search-filter-group-Level\"]/div/div//span[@class=\"cds-checkboxAndRadio-labelContent css-imksha\"]/span"));
		for (WebElement webElement : levels) {
			String levelname = webElement.getText();
			System.out.print(levelname+" ");
		}
		System.out.println();
		System.out.println("The number of levels are" +" "+ levels.size());
		System.out.println("-------------------------");
		Screenshot.screen(driver, "levelcount");
		Thread.sleep(5000);
	}
	@Test(priority=2,groups= {"regression","master"})
	public void langCount() throws InterruptedException, IOException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		ForLanguageLearning lang=new ForLanguageLearning(driver);
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[contains(text(), 'Language')]")));
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='search-results-header-wrapper']/div/div[1]/div/div[2]/div[2]/button/span")));
		Thread.sleep(4000);
		List<WebElement>langlist=new ArrayList<WebElement>();
	    langlist = driver.findElements(By.xpath("//div[@class=\"css-11krhap\"]/div[@id=\"checkbox-group\"]/div//div/span/span"));
	    for (WebElement webElement : langlist) {
			String langname = webElement.getText();
			System.out.print(langname+" ");
		}
	    System.out.println();
	    System.out.println("The number of languages are"+" "+langlist.size());
	    System.out.println("-------------------------");
		Thread.sleep(5000);
		Screenshot.screen(driver, "langcount");
		lang.apply();
		Thread.sleep(4000);
		lang.homePage();
	}

}
