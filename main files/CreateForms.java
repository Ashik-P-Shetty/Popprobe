package popprobe;

import org.testng.annotations.Test;

import com.qsp.trello.genericutility.BaseClass;

import pomrepo.AllForms;
import pomrepo.BooleanQuestionForm;
import pomrepo.LoginToPopprobe;
import pomrepo.MultipleChoiceQuestionForm;
import pomrepo.NumericQuestionForm;
import pomrepo.SingleChoiceQuestionForm;
import pomrepo.TextQuestionForm;

public class CreateForms extends BaseClass {

	@Test
	public void CreateForm() throws Throwable{
		int count=4,a=1,b=0,c=1,d=3,e=5,f=7,g=9;
		LoginToPopprobe login= new LoginToPopprobe(driver);
		login.LoginToStage();
		AllForms createForm= new AllForms(driver);
		createForm.AllForm();
		
		for(int i=1;i<=count;i++) {
		//Create New Form
		Thread.sleep(1000);
		createForm.AddNewForm(a,b);
		int type1=2;
		for(int j=1;j>0;j++) {
		//Add text question
		if(excelUtils.readTheStringData("popprobe form", a, type1).equals("text")) {
			createForm.AddQuestionButton();
		TextQuestionForm text= new TextQuestionForm(driver);
		text.TextQuestion(a,c);
		type1+=2;
		}
		
		else if (excelUtils.readTheStringData("popprobe form", a, type1).equals("numeric")) {
			createForm.AddQuestionButton();
		NumericQuestionForm numeric=new NumericQuestionForm(driver);
		numeric.NumericQuestion(a,d);	
		type1+=2;

		}
		else if(excelUtils.readTheStringData("popprobe form", a, type1).equals("boolean")){
			createForm.AddQuestionButton();
		BooleanQuestionForm bool= new BooleanQuestionForm(driver);
		bool.BooleanQuestion(a,e);
		type1+=2;

		}
		else if(excelUtils.readTheStringData("popprobe form", a, type1).equals("single")){
			createForm.AddQuestionButton();
		SingleChoiceQuestionForm singleChoice= new SingleChoiceQuestionForm(driver);
		singleChoice.SingleChoiceQuestion(a, f);
		type1+=2;

		}
		else if(excelUtils.readTheStringData("popprobe form", a, type1).equals("multi")){
			createForm.AddQuestionButton();
		MultipleChoiceQuestionForm multipleChoice= new MultipleChoiceQuestionForm(driver);
		multipleChoice.MutlipleChoiceQuestion(a, g);
		type1+=2;

		}
		else if(excelUtils.readTheStringData("popprobe form", a, type1).equals("end")) {
			createForm.CreateButton();
			break;
		}
		}
		a++;
		Thread.sleep(5000);
		}
		
			
		
	}
}
