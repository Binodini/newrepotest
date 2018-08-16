package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeMethods implements WdMethods{
	public static RemoteWebDriver driver ;
	int i = 1;
	private String actualTitle;
	private boolean contains;
	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
				 driver = new ChromeDriver();			
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "F:\\selenium\\chromedriver.exe");
				 driver = new FirefoxDriver();		
			}
			driver.manage().window().maximize();
			driver.navigate().to(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The Browser "+browser+" is Launched Successfully");
		} catch (WebDriverException e) {
			System.err.println("WebDriverException not found");
			//e.printStackTrace();
		}catch(Exception e){
			System.err.println("Exception :The Browser is not present in your system");
			
		}finally{
		
		takeSnap();
		}
	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case "id": 	  return driver.findElementById(locValue);
			case "class": return driver.findElementByClassName(locValue);
			case "xpath": return driver.findElementByXPath(locValue);	
			case "linkText": return driver.findElement(By.linkText(locValue));
			}
		} catch (NoSuchElementException e) {
			System.err.println("NoSuchElementException");
			
			//e.printStackTrace();
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		try {
			return driver.findElementById(locValue);
		} catch (NoSuchElementException e) {
			System.out.println("locValue not found");
			//e.printStackTrace();
		}
		return null;
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			System.out.println("The Data "+data+" is Entered Successfully");
		}catch(Exception e){
			e.printStackTrace();
		} finally{
				takeSnap();
		}
	}

	public void click(WebElement ele) {
	try {
		ele.click();
		System.out.println("The Element "+ele+" is clicked Successfully");
	} catch (WebDriverException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
	takeSnap();	
	}
	}

	public String getText(WebElement ele) {
		try {
			ele.getText();
		} catch (NoSuchElementException e) {
			System.err.println("NoSuchElementException:The text is not present.");
		}
		return null;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select dd=new Select(ele);
			dd.selectByVisibleText(value);
			System.out.println("selected ByVisibleText");
		} catch (NoSuchElementException e) {
			System.err.println("NoSuchElementException");
			//e.printStackTrace();
		}
		
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select dd=new Select(ele);
			dd.selectByIndex(index);
			System.out.println("selected Index");
		} catch (NoSuchElementException e) {
			System.err.println("NoSuchElementException found :The select element not found!");
			//e.printStackTrace();
		}
		
	}

	public boolean verifyTitle(String expectedTitle) {
		try {
			actualTitle = driver.getTitle();
			if(actualTitle.equalsIgnoreCase(expectedTitle))
				 System.out.println("Title Matched");
				 else
				 System.out.println("Title didn't match");
		} catch (WebDriverException e) {
			System.err.println("WebDriverException:The title is not found!");
			//e.printStackTrace();
		}
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			String actualtext=ele.getText();
			if(actualtext.equals(expectedText)) {
				System.out.println("The text: "+actualtext+" is compared and verified both are same");
			}
			else {System.out.println("The text: "+actualtext+" is not matching with expected text");}
		} catch (NoSuchElementException e) {
			System.err.println("NoSuchElementException:The expected reult not matching");
			//e.printStackTrace();
		}finally{
		takeSnap();}
//		contains = driver.getPageSource().contains("expectedText");
		
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			String attributeval = ele.getAttribute(attribute);
			if(attributeval.equals(value))
			{
				System.out.println("The Attribute is " + attributeval + " and matched Successfully");
			}
			else
			{
				System.out.println("The Attribute is " + attributeval + " and not matched");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The text field is not available.");
		}
		
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
	
	try {
		String attributeval = ele.getAttribute(attribute);
			if(attributeval.contains(value))
			{
				System.out.println("The Attribute is " + attributeval + " and partially matched");
			}
			else
			{
				System.out.println("The Attribute is " + attributeval + " and doesn't match partially");
			}
	} catch (NoSuchElementException e) {
		System.err.println("The text is not present on  window");
	}
	    
		
	}

	public void verifySelected(WebElement ele) {
		try {
			boolean selected = ele.isSelected();
			if(selected == true)
			{
				System.out.println("The Checkbox is already Checked");
				ele.click();
				System.out.println("The Checkbox is unchecked Successfully");
			}
			else
			{
				System.out.println("The Checkbox is not selected");
				ele.click();
				System.out.println("The Checkbox is checked Successfully");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The selected field is not available.");
		}
		
	}

	public void verifyDisplayed(WebElement ele) {
		try {
			boolean displayed = ele.isDisplayed();
			if(displayed == true)
			{
				System.out.println("The Webelement is Present in the page ");
			}
			else
			{
				System.out.println("The Webelement is not Present in the page");
				
			}
		} catch (NoSuchElementException e) {
			System.err.println("NoSuchElementException:Element not present.");
		}
		
	}

	public void switchToWindow(int index) {
		try {
			Set<String> windows = driver.getWindowHandles();
			List<String> allwindows = new ArrayList<String>();
			allwindows.addAll(windows);
			driver.switchTo().window(allwindows.get(index));
		} catch (NoSuchWindowException e) {
			System.err.println("NoSuchWindowException:The window is not exists");
			//e.printStackTrace();
		}
		
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame("iframeResult");
		} catch (NoSuchFrameException e) {
			System.err.println("NoSuchFrameException: The frame is not available");
			//e.printStackTrace();
		}
		
	}

	public void acceptAlert() {
		try {
			Alert myalert =driver.switchTo().alert();
			myalert.accept();
		} catch (NoAlertPresentException e) {
			System.err.println("NoAlertPresentException: The alert popup is not present.");
			//e.printStackTrace();
		}
//		driver.switchTo().alert().accept();
		
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			System.err.println("NoAlertPresentException:The popup is not present.");
			//e.printStackTrace();
		}
		
	}

	public String getAlertText() {
		try {
			driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			System.out.println("NoAlertPresentException:The alert is not present");
			//e.printStackTrace();
		}
		return null;
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img"+i+".png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}

	public void closeBrowser() {
		try {
			driver.close();
		} catch (WebDriverException e) {
			System.err.println("WebDriverException:The WebDriver not present");
		}
		
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
		} catch (WebDriverException e) {
			System.err.println("WebDriverException:The WebDriver not present");
		}
		
		
	}

}
