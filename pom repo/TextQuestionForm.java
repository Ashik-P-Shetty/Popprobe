package pomrepo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qsp.trello.genericutility.BaseClass;

public class TextQuestionForm extends BaseClass {
	
	WebDriver driver;

	public  TextQuestionForm(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void TextQuestion(int a, int b) throws Throwable, IOException {	
		
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
		
		texttype();
		
		
		
		
		
	}
	
	public void texttype() throws Throwable {
		
		WebElement textType=driver.findElement(By.xpath("//li[@data-value='text']"));
		textType.sendKeys(Keys.ARROW_DOWN);
		textType.click();
		
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
