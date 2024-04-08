package pomrepo_create_company;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qsp.trello.genericutility.BaseClass;

public class CreateCompanyLogin extends BaseClass {
	WebDriver driver;

	public  CreateCompanyLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	public void LoginFirstTime() throws IOException, Throwable {
		
		//Login to stage website
		
		//fetch username
		WebElement username= driver.findElement(By.id("email"));
		username.sendKeys(fileUtils.readTheDataFromPropertyFile("Companycreationid"));
		
		//fetch password
		WebElement password= driver.findElement(By.id("password"));
		password.sendKeys(fileUtils.readTheDataFromPropertyFile("password1"));
		
		//Login button
		WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		Thread.sleep(3000);
		
		//Find and Select the store
//		JavascriptExecutor jse=(JavascriptExecutor)driver;
//		for(;;) {
//			try {
//				WebElement store=driver.findElement(By.xpath("//div[text()='Home Centre']"));
//				store.click();
//				break;
//				}
//			catch(NoSuchElementException e) {
//				jse.executeScript("window.scrollBy(0,300");
//			}
//		}
//		Thread.sleep(3000);

	}
}
