package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Secondcoursepage extends Basepage  {
	WebDriver driver;
	public Secondcoursepage(WebDriver driver)
	{
		
		super(driver);
	}
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[1]/div[1]/section/h1")
	WebElement name2;
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[3]/div[1]")
	WebElement duration2;
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]")
	WebElement rating2;
	public String getCourseName2() {
		
		String name = name2.getText();
		return name;
	}
	public String getDuration2() {
		
		String duration = duration2.getText();
		return duration;
	}
	public String getRating2() {
		
		String rating = rating2.getText();
		return rating;
	}

}
