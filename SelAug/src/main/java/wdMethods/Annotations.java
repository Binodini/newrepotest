package wdMethods;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Annotations extends SeMethods {
	private WebElement mousehoveronicon;
	private WebElement loginbtn;
	private WebElement username;
	private WebElement password;
	private WebElement loginBtn;
	
	
	private WebElement userName;
	private WebElement passWd;
	private WebElement submit;
	private WebElement clickcrmSfa;

	@Parameters({"url","uName","pword"})
	@BeforeMethod() //groups={"sanity"}
		public void login(String url,String uName, String pword){
		startApp("chrome", url);
		 userName = locateElement("id","username");
		 userName.sendKeys(uName);
		 passWd = locateElement("id","password");
		 passWd.sendKeys(pword);
		 submit = locateElement("class","decorativeSubmit");
		 click(submit);
		 clickcrmSfa = locateElement("linkText","CRM/SFA");
		 clickcrmSfa.click();
	}
	@AfterMethod() //groups={"smoke"}
	public void closeApp(){
		 closeBrowser();
		
		
	}
}
