package seleniumtutorials;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.Chrome.driver",
				"C:\\Users\\sharm\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
		
String parentWindow = driver.getWindowHandle();
System.out.println(parentWindow);
driver.findElement(By.cssSelector("#contact_me > div > div:nth-child(1) > div > h2")).click();
	
Set<String>windows = driver.getWindowHandles();
for(String window:windows) {
	if(!window.equals(parentWindow)) {
		driver.switchTo().window(window);
		break;
	}
}
System.out.println(driver.getCurrentUrl());
WebElement first_name = driver.findElement(By.cssSelector("#contact_form > input:nth-child(1)"));
WebElement last_name = driver.findElement(By.cssSelector("#contact_form > input:nth-child(2)"));
WebElement email_address = driver.findElement(By.cssSelector("#contact_form > input:nth-child(3)"));	
WebElement message = driver.findElement(By.cssSelector("#contact_form > textarea"));
WebElement submit_button = driver.findElement(By.cssSelector("#form_buttons > input:nth-child(2)"));
	first_name.sendKeys("ganesh");
	last_name.sendKeys("sharma");
	email_address.sendKeys("sharmagg34@gmail.com");
	message.sendKeys("I am learning ");
	submit_button.click();
	
	
	driver.switchTo().window(parentWindow);
	System.out.println(driver.getCurrentUrl());
	
	}}

	
	
	


