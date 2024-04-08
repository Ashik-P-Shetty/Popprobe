package pomrepo_create_company;

import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qsp.trello.genericutility.BaseClass;


public class YopmailOTPReader extends BaseClass {
WebDriver driver;
	public  YopmailOTPReader(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String Otp() throws IOException {
		
		// Navigate to Yopmail
        driver.get("http://www.yopmail.com/en/");

        // Generate a random email address
        //String randomEmail = "popprobe" + System.currentTimeMillis() + "@yopmail.com";

        Actions actions = new Actions(driver);
        // Enter the random email address in the Yopmail input field
        WebElement emailInput = driver.findElement(By.id("login"));
        emailInput.sendKeys(fileUtils.readTheDataFromPropertyFile("Companycreationid"));
        emailInput.sendKeys(Keys.ENTER);

        // Click on "Check Inbox" button
//        WebElement checkInboxButton = driver.findElement(By.cssSelector("input[type='submit'][value='Check Inbox']"));
//        checkInboxButton.click();
        

        // Wait for the email to arrive (you may need to implement a proper wait strategy here)
        // In this example, we use a simple sleep for demonstration purposes
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Switch to the email content iframe
        driver.switchTo().frame("ifmail");

        // Extract the OTP from the email content
        WebElement otpElement = driver.findElement(By.xpath("//p[contains(text(), 'Your email verification code is')]"));
        String otp1 = otpElement.getText().split("is ")[1].trim();
        Pattern pattern = Pattern.compile("\\b[A-Za-z0-9]{6}\\b"); // Assumes OTP is a 6-character alphanumeric code

        // Search for the OTP pattern in the sentence
        Matcher matcher = pattern.matcher(otp1);

        // If a match is found, extract the OTP
        matcher.find();
        String otp = matcher.group();
        System.out.println("OTP: " + otp);
        return(otp);
        
        

	}
}
