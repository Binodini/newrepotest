package reportsTestday6;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.Annotations;

public class EditLead extends Annotations{

	private WebElement editLink;
	private WebElement leadsLink;
	private WebElement findLeads;
	private WebElement enterFName;
	private WebElement clickLeadBtn;
	private WebElement empId;
	private WebElement updateCompName;
	private WebElement updateBtn;
	private WebElement namedisplay;
	private String nametext;

	@Test
	public void EditLeadTest() throws InterruptedException {
		leadsLink = locateElement("linkText","Leads");
		click(leadsLink);
		findLeads = locateElement("linkText","Find Leads");
		click(findLeads);
		enterFName = locateElement("xpath","(//input[@name='firstName'])[3]");
		enterFName.sendKeys("Babu");
		Thread.sleep(2000);
		clickLeadBtn = locateElement("xpath","//button[text()='Find Leads']");
		click(clickLeadBtn);
		empId = locateElement("linkText","Babu");
		click(empId);
		editLink = locateElement("linkText","Edit");
		click(editLink);
		
		updateCompName = locateElement("id","updateLeadForm_companyName");
		updateCompName.clear();
		updateCompName.sendKeys("Anushka's enterprizes");
		
		updateBtn = locateElement("xpath","//input[@value='Update']");
		click(updateBtn);
		
		namedisplay = locateElement("id","viewLead_companyName_sp");
		nametext = namedisplay.getText();
		System.out.println(nametext);
		if(nametext != null) {
			System.out.println("Anushka's enterprizes (10593)");
		}else {
			System.out.println("not found");
		}

	}



}
