package pomrepo_checklist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qsp.trello.genericutility.BaseClass;

public class AllChecklists extends BaseClass {
	
	WebDriver driver;

	public  AllChecklists(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void AllChecklist() throws Throwable {
		//Create forms
		WebElement menu= driver.findElement(By.xpath("//span[text()='Checklist']"));
		
		//To click on all forms

		Actions action=new Actions(driver);
		action.moveToElement(menu,0,0).click().moveToElement(menu,0,80).click().perform();
		
		driver.navigate().refresh();
		Thread.sleep(5000);
	}
	public void AssignChecklist(int a, int b) {
		
	}
}
