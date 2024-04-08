package pomrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qsp.trello.genericutility.BaseClass;

public class AllForms extends BaseClass {

WebDriver driver;

	public  AllForms(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void AllForm() throws Throwable {
		//Create forms
		WebElement menu= driver.findElement(By.xpath("//span[text()='Checklist']"));
		
		//To click on all forms

		Actions action=new Actions(driver);
		action.moveToElement(menu,0,0).click().moveToElement(menu,0,160).click().perform();
		
		driver.navigate().refresh();
		Thread.sleep(5000);
	}
	
	public void AddNewForm(int a,int b) throws Throwable {	
		//Create new form
		
		Actions action=new Actions(driver);
		WebElement newFormButton= driver.findElement(By.xpath("//button[contains(.,'Create New Form')]"));
		action.moveToElement(newFormButton, 0, 0).click().perform();
		Thread.sleep(3000);
		//Fill title
		WebElement title= driver.findElement(By.id("outlined-basic"));
		title.sendKeys(excelUtils.readTheStringData("popprobe form", a, b));
		
		//Select report to dropdown
		WebElement selectReportDD= driver.findElement(By.id("mui-component-select-reportselect"));
		selectReportDD.click();
		
		//select admin
		WebElement admin=driver.findElement(By.xpath("//span[text()='Admin']"));
		admin.click();
		driver.navigate().refresh();
		
		//Selfie required
		WebElement selfie=driver.findElement(By.xpath("//span[text()='Selfie required']"));
		selfie.click();
	}
	
	public void AddQuestionButton() {
		//Add Question
		WebElement addQuestion= driver.findElement(By.xpath("//button[text()='Add Question']"));
		addQuestion.click();
	}
	
	public void CreateButton() {
		WebElement createButton=driver.findElement(By.xpath("//button[text()='Create']"));
		createButton.sendKeys(Keys.ARROW_UP);
		createButton.click();
	}
	
	
}
