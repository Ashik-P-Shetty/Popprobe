package popprobe;

import org.testng.annotations.Test;

import com.qsp.trello.genericutility.BaseClass;

import pomrepo_create_company.Company;
import pomrepo_create_company.CreateCompanyLogin;

public class CreateCompany extends BaseClass {

	@Test
	public void CreateCompanys() throws Throwable {
		Company signup = new Company(driver);
		signup.Signup();
		CreateCompanyLogin loginNewCompany = new CreateCompanyLogin(driver);
		Thread.sleep(5000);
		loginNewCompany.LoginFirstTime();
	}
	
}
