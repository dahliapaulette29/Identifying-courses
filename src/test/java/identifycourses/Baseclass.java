package identifycourses;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Baseclass {
	public static WebDriver driver;
	
	@BeforeTest (groups= {"smoke","regression","master"})
	public  void getDriver() throws InterruptedException, Exception
	{
	    /*int browser;
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Select a browser");
		System.out.println("1.Chrome     2.Edge");
		browser=sc.nextInt();
		if(browser==1)
			driver = new ChromeDriver();
		else if(browser==2)
			driver=new EdgeDriver();
		else
			System.out.println("Invalid Browser");
		driver.manage().deleteAllCookies();
		driver.get("https://www.coursera.org/");
		Thread.sleep(5000);
		driver.manage().window().maximize();*/
		//http://10.66.138.113:4444
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.WIN11);
		capabilities.setBrowserName("MicrosoftEdge");
		driver = new RemoteWebDriver(new URL("http://192.168.60.93:4444"),capabilities);
		driver.get("https://www.coursera.org/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
	
	}
	@AfterTest (groups= {"smoke","regression","master"})
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
	}
	


}
