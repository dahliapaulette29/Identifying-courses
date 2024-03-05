package stepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.Firstcoursepage;
import pom.ForEnterprise;
import pom.ForLanguageLearning;
import pom.ForWebDevelopment;
import pom.Secondcoursepage;
import utilities.ExcelUtility;
import utilities.Screenshot;

public class Coursera {
	public static WebDriver driver;
	String oldwindow;
	@Given("user navigates to coursera")
	public void user_navigates_to_coursera() throws InterruptedException {
		int browser;
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
		driver.manage().window().maximize();
	}

	@When("searches for Web Development Courses")
	public void searches_for_Web_Development_Courses() throws InterruptedException, IOException {
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

	@When("level is selected as beginner")
	public void level_is_selected_as_beginner() throws IOException, InterruptedException {
		ForWebDevelopment web=new ForWebDevelopment(driver);
		//Screenshot s=new Screenshot();
		Thread.sleep(3000);
		web.level();
		Thread.sleep(3000);
		Screenshot.screen(driver, "selecting level");
	}

	@When("language is selected as English")
	public void language_is_selected_as_english() throws IOException, InterruptedException {
		ForWebDevelopment web=new ForWebDevelopment(driver);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		//Screenshot s=new Screenshot();
		js1.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[contains(text(), 'Language')]")));
		Thread.sleep(3000);
		//show more
		js1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='cds-checkboxAndRadio-labelContent css-imksha']//*[contains(text(),'English')]")));
		Thread.sleep(3000);
		/*js1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='search-results-header-wrapper']/div/div[1]/div/div[3]/div[2]/button/span")));
		Thread.sleep(3000);
		js1.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@placeholder='Search for Language']")));
		driver.findElement(By.xpath("//*[@placeholder='Search for Language']")).sendKeys("English");
		Thread.sleep(3000);
		js1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"checkbox-group\"]/div/label/span")));
		Thread.sleep(7000);*/
		Screenshot.screen(driver, "selecting language");
		//web.apply();
		Thread.sleep(6000);
		Screenshot.screen(driver, "courses");
	}

	@Then("get first course details")
	public void get_first_course_details() throws InterruptedException, IOException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Firstcoursepage fcp=new Firstcoursepage(driver);
		//Screenshot s=new Screenshot();
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[contains(text(), 'Filter by')]")));
		Thread.sleep(6000); 
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//*[@class='cds-CommonCard-title css-1sktkql'])[1]")));
		oldwindow = driver.getWindowHandle();
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

	@Then("get second course details")
	public void get_second_course_details() throws InterruptedException, IOException {
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
		//ForWebDevelopment web=new ForWebDevelopment(driver);
		web.homePage();
	}

	@Given("searches for Language Learning")
	public void searches_for_Language_Learning() throws IOException, InterruptedException {
		ForLanguageLearning lang=new ForLanguageLearning(driver);
		ExcelUtility excel=new ExcelUtility();
		String searchvalue=excel.readDatalang();
		lang.search(searchvalue);
		Screenshot.screen(driver, "langsearch");
		Thread.sleep(6000);
	}

	@When("search bar is clicked")
	public void search_bar_is_clicked() throws InterruptedException {
		ForLanguageLearning lang=new ForLanguageLearning(driver);
		lang.searchbutton();
		Thread.sleep(6000);
	}

	@When("count of levels available is taken")
	public void count_of_levels_available_is_taken() throws InterruptedException, IOException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[contains(text(), 'Level')]")));
		List<WebElement>levels=new ArrayList<WebElement>();
		levels = driver.findElements(By.xpath("//div[@data-testid=\"search-filter-group-Level\"]/div/div//span[@class=\"cds-checkboxAndRadio-labelContent css-imksha\"]/span"));
		for (WebElement webElement : levels) {
			String levelname = webElement.getText();
			System.out.println(levelname);
		}
		System.out.println();
		System.out.println("The number of levels are" + levels.size());
		System.out.println("-------------------------");
		Screenshot.screen(driver, "levelcount");
		Thread.sleep(5000);
	}

	@When("count of languages available is taken")
	public void count_of_languages_available_is_taken() throws InterruptedException, IOException {
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
			System.out.println(langname);
		}
	    System.out.println();
	    System.out.println("The number of languages are"+langlist.size());
	    System.out.println("-------------------------");
		Thread.sleep(5000);
		Screenshot.screen(driver, "langcount");
		lang.apply();
		Thread.sleep(4000);
		//lang.homePage();
	}

	@Given("user navigates back to the home page")
	public void user_navigates_back_to_the_home_page() {
		ForLanguageLearning lang=new ForLanguageLearning(driver);
		lang.homePage();
	}

	@Given("clicks for enterprise")
	public void clicks_for_enterprise() throws IOException, InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@id='rendered-content']/div/div[1]/footer/div/div/div/div[5]/p")));
		ForEnterprise enter=new ForEnterprise(driver);
		enter.forEnterprise();
		Thread.sleep(3000);
		Screenshot.screen(driver, "enterprise");
	}

	@When("solution is selected")
	public void solution_is_selected() throws IOException, InterruptedException {
		ForEnterprise enter=new ForEnterprise(driver);
		enter.chooseSolution();
		Thread.sleep(3000);
		Screenshot.screen(driver, "choose Solution");;
	}

	@When("clicks coursera for campus")
	public void clicks_coursera_for_campus() throws IOException, InterruptedException {
		ForEnterprise enter=new ForEnterprise(driver);
		enter.chooseCourseraforcampus();
		Thread.sleep(5000);
		Screenshot.screen(driver, "Coursera for Campus");
	}

	@Then("fills ready to transform form")
	public void fills_ready_to_transform_form() throws InterruptedException, IOException {
		ForEnterprise enter=new ForEnterprise(driver);
		ExcelUtility excel=new ExcelUtility();
		String data[]=ExcelUtility.readExcelData();
		JavascriptExecutor js4=(JavascriptExecutor)driver;
		js4.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/main/div/div[7]/div/div[2]/div/div/div/div/div/div[2]/div[3]")));
		Thread.sleep(3000);
		enter.giveFirstname(data[0]);
		Thread.sleep(3000);
		enter.giveLastname(data[1]);
		Thread.sleep(3000);
		enter.giveMail(data[2]);
		Thread.sleep(3000);
		enter.givePhonenumber(data[3]);
		Thread.sleep(3000);
		enter.givecname(data[4]);
		Thread.sleep(2000);
		enter.chooseInstitute();
		Thread.sleep(2000);
		enter.chooseJobrole();
		Thread.sleep(2000);
		enter.choosseDepartment();
		Thread.sleep(3000);
		enter.chooseDescribe();
		Thread.sleep(4000);
		enter.chooseCountry();
		Thread.sleep(3000);
		enter.chooseState();
		Thread.sleep(4000);
		Screenshot.screen(driver, "submission");
	}

	@Then("clicks submit button")
	public void clicks_submit_button() throws InterruptedException {
		ForEnterprise enter=new ForEnterprise(driver);
		enter.clickSubmit();
		Thread.sleep(4000);
	}

	@Then("captures error message")
	public void captures_error_message() throws IOException {
		ForEnterprise enter=new ForEnterprise(driver);
		Screenshot.screen(driver, "error message");
		String error=enter.eMessage();
		System.out.println();
		System.out.println("Error Message :"+error);
		driver.quit();
	}

}
