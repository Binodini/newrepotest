package reportsTestday6;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.Annotations;

public class DeleteLead extends Annotations {
	private static WebElement leadsLink,findLeads;
	private WebElement phNum;
	private WebElement entPh;
	private WebElement clilink;
	private WebElement delete;
	
	
	
	@Test
	public void deleteLead() throws InterruptedException {
		
		leadsLink = locateElement("linkText","Leads");
		click(leadsLink);
		
		
		findLeads = locateElement("linkText","Find Leads");
		click(findLeads);
		
		
		phNum = locateElement("xpath","//span[text()='Phone']");
		
		click(phNum);
		entPh = locateElement("xpath","//input[@name='phoneNumber']");
		entPh.sendKeys("9884432408");
		clilink = locateElement("linkText","Gayu");
		
		clilink.click();
		delete = locateElement("className","subMenuButtonDangerous");
		click(delete);
		Thread.sleep(2000);
		System.out.println("deleted successfully!");
		
	}
	
	
	
	
	
	
	
	

}

