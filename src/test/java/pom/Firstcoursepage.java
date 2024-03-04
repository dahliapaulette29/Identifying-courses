package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Firstcoursepage extends Basepage {
	WebDriver driver;
	public Firstcoursepage(WebDriver driver)
	{
		
		super(driver);
	}
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[1]/div[1]/section/div/div[1]/h1")
	WebElement name1;
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/section/div/div[3]/div/div/div[1]")
	WebElement duration1;
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/section/div/div[1]/div/div/div[1]")
	WebElement rating1;
	public String getCourseName1() {
		
		String name = name1.getText();
		return name;
	}
	public String getDuration1() {
		
		String duration = duration1.getText();
		return duration;
	}
	public String getRating() {
		
		String rating = rating1.getText();
		return rating;
	}
}
