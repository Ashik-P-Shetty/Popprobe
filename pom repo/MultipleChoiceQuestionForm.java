package pomrepo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qsp.trello.genericutility.BaseClass;

public class MultipleChoiceQuestionForm extends BaseClass {

	WebDriver driver;

	public  MultipleChoiceQuestionForm(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void MutlipleChoiceQuestion(int a,int b) throws Throwable, IOException {	
		
		//Question
		WebElement question= driver.findElement(By.name("title"));
		question.sendKeys(excelUtils.readTheStringData("popprobe form", a, b));
		
		//Description
		WebElement description= driver.findElement(By.xpath("//textarea[@name='description']"));
		description.sendKeys(excelUtils.readTheStringData("popprobe form", a, b));
		
		//Question score
		WebElement questionScore=driver.findElement(By.name("questionscore"));
		questionScore.sendKeys("1");
		
		//Question type
		WebElement questionType=driver.findElement(By.id("mui-component-select-questiontype"));
		questionType.click();
		
		multiplechoicetype();
		
		
		
		
		
	}
	
	public void multiplechoicetype() throws Throwable {
		Thread.sleep(3000);
		WebElement textType=driver.findElement(By.xpath("//li[@data-value='multiplechoice']"));
		textType.sendKeys(Keys.ARROW_DOWN);
		textType.click();
		
		//To select main list
		WebElement mainList= driver.findElement(By.id("mui-component-select-attachedlist"));
		mainList.click();
		Thread.sleep(3000);
		WebElement regionsOfBangalore=driver.findElement(By.xpath("//li[text()='Regions of Bangalore']"));
		regionsOfBangalore.click();
		
		//validation is required?
		WebElement isRequired=driver.findElement(By.xpath("//label[text()='1. Is Required?']/parent::div[@class='MuiFormControl-root MuiFormControl-fullWidth css-tzsjye']/descendant::input[@value='yes']"));
		isRequired.click();
		
		//take image
		WebElement takeImage= driver.findElement(By.xpath("//label[text()='3. Take Image']/parent::div[@class='MuiFormControl-root MuiFormControl-fullWidth css-tzsjye']/descendant::input[@value='yes']"));
		takeImage.click();
		
		//Always allow comment
		WebElement allowComment=driver.findElement(By.xpath("//label[text()='5. Always allow Comment']/parent::div[@class='MuiFormControl-root MuiFormControl-fullWidth css-tzsjye']/descendant::input[@value='yes']"));
		allowComment.click();
	
		WebElement questionDoneButton=driver.findElement(By.xpath("//button[@type='submit']"));
		questionDoneButton.submit();
	
}
}
