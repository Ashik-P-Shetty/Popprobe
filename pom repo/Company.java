package pomrepo_create_company;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;

import com.qsp.trello.genericutility.BaseClass;

public class Company extends BaseClass{
	WebDriver driver;

	public  Company(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void Signup() throws IOException, Throwable{
		//Click on signup button
		WebElement signup = driver.findElement(By.xpath("//a[text()='Sign Up']"));
		signup.click();
		
		// click on email text field and enter email
		WebElement emailTextField= driver.findElement(By.id("email"));
		emailTextField.sendKeys(fileUtils.readTheDataFromPropertyFile("Companycreationid"));

		
		// click on next button
		WebElement nextButton= driver.findElement(By.xpath("//button[text()='Next']"));
		nextButton.click();
		Thread.sleep(5000);
		
		//Switch to new window
	    driver.switchTo().newWindow(WindowType.TAB);
				
		//Get all window handles
		Set<String> allWindowId = driver.getWindowHandles();
		        
		YopmailOTPReader yopmail= new YopmailOTPReader(driver);
		String otp= yopmail.Otp();
		
		for(String wid : allWindowId) {
        	String url=driver.switchTo().window(wid).getCurrentUrl();
        	
        	if(url.equals(("https://staging.popprobe.com/signUp"))){
        		WebElement otpField= driver.findElement(By.xpath("//input[@data-id='0']"));
        		otpField.sendKeys(otp);
        		
        		Thread.sleep(3000);
        		WebElement next1Button= driver.findElement(By.xpath("//button[text()='Next']"));
        		next1Button.click();   
        		break;
        		}
        }
		//Enter First name
		WebElement firstName= driver.findElement(By.id("first_name"));
		firstName.sendKeys(fileUtils.readTheDataFromPropertyFile("Firstname"));
		
		//Enter last name
		WebElement lastName= driver.findElement(By.id("last_name"));
		lastName.sendKeys(fileUtils.readTheDataFromPropertyFile("Lastname"));
	
		
		//Select country
		WebElement country= driver.findElement(By.id("country_code"));
		country.click();
		
		Thread.sleep(5000);
		//India
		WebElement india= driver.findElement(By.xpath("//li[@data-value='91']"));
		india.click();
		
		//Enter Phone number
		WebElement phoneNumber= driver.findElement(By.id("mobile_number"));
		phoneNumber.sendKeys(fileUtils.readTheDataFromPropertyFile("Phonenumber"));
		
		//Enter Password
		WebElement password= driver.findElement(By.id("password"));
		password.sendKeys(fileUtils.readTheDataFromPropertyFile("password1"));
		
		//ReEnter Password
		WebElement rpassword= driver.findElement(By.id("retype_password"));
		rpassword.sendKeys(fileUtils.readTheDataFromPropertyFile("password1"));
		
		//Finish Button
		WebElement finishButton= driver.findElement(By.xpath("//button[text()='Finish']"));
		finishButton.click();
		
		//Go to login page
		WebElement loginButton= driver.findElement(By.xpath("//a[text()='Log in']"));
		loginButton.click();
		
		
	}
}
