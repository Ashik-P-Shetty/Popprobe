package pomrepo_create_company;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qsp.trello.genericutility.BaseClass;
import com.qsp.trello.genericutility.JavaUtility;

public class AddNewCompany extends BaseClass {
	WebDriver driver;

	public  AddNewCompany(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void NewCompany() throws IOException, Throwable {
		//Click on Add new Company Button
		WebElement addNewButton= driver.findElement(By.xpath("//a[@class='submenu-item']"));
		addNewButton.click();
		
		//Add company name
		WebElement compName= driver.findElement(By.name("companyname"));
		JavaUtility time= new JavaUtility();
		String companyName= fileUtils.readTheDataFromPropertyFile("CompanyName")+ " "+ time.localDateTime();
		compName.sendKeys(companyName);
		
		//Click on ok button
		WebElement okButton = driver.findElement(By.xpath("//button[text()='OK']"));
		okButton.click();
		
		
		//Click what does your company do dropdown
		WebElement companyDropDown= driver.findElement(By.xpath("//div[@aria-controls=':rc:']"));
		companyDropDown.click();
		
		//Choose Restraunt from option
		WebElement restraunt=driver.findElement(By.xpath("//li[@data-value='Restaurant']"));
		Thread.sleep(2000);
		restraunt.click();
		
		//Choose image option
		WebElement imageDropDown= driver.findElement(By.xpath("//div[@aria-controls=':rd:']"));
		imageDropDown.click();
		
		//Choose photo
		WebElement image=driver.findElement(By.xpath("//li[text()='Photo']"));
		Thread.sleep(2000);
		image.click();
		
		//Click on Create Button
		WebElement createButton = driver.findElement(By.xpath("//button[text()='CREATE']"));
		createButton.click();
		Thread.sleep(3000);
		
		//Click on the Company
		WebElement company1= driver.findElement(By.xpath("//div[text()= '"+companyName+"']"));
		company1.click();
		
		
		
		
		
	}
}
