package reportsTestday6;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.Annotations;

public class DuplicateLead extends Annotations {

	private WebElement leadsclick,flead,email,enterEmail,findLeads,nameDisplay;
	private WebElement duplicateLead;
	private WebElement crLead;
	private WebElement compView;
	private String text;

	@Test
	public void duplicateLead() throws InterruptedException {
		
		leadsclick = locateElement("linkText","Leads");
		click(leadsclick);
		
		flead = locateElement("linkText","Find Leads");
		click(flead);
		
		email = locateElement("xpath","//span[text()='Email']");
		click(email);
		Thread.sleep(2000);
		enterEmail = locateElement("xpath","//input[@name='emailAddress']");
		Thread.sleep(2000);
		enterEmail.sendKeys("babu@testleaf.com");
		Thread.sleep(2000);
		findLeads = locateElement("xpath","//button[text()='Find Leads']");
		click(findLeads);
		nameDisplay = locateElement("linkText","Babu");
		click(nameDisplay);
		
		duplicateLead = locateElement("linkText","Duplicate Lead");
		click(duplicateLead);
		Thread.sleep(2000);
		crLead = locateElement("xpath","//input[@value='Create Lead']");
		click(crLead);
		Thread.sleep(2000);
		compView = locateElement("id","viewLead_companyName_sp");
		text = compView.getText();
		System.out.println(text);
		
		if(text!=null) {System.out.println(text);}else {System.out.println("test");}
		
	}
	
	
	
	
	
	
	
	

}

