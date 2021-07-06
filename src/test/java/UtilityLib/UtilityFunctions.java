package UtilityLib;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.WebElementHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

import io.cucumber.datatable.internal.difflib.myers.MyersDiff;
import junit.framework.Assert;

public class UtilityFunctions {

	WebDriver driver;
	String A=null;

	String C=A;

	@FindBy(xpath="(//*[contains(@class,'state-availability')]/a)[1]") public WebElement Todaydate;
	@FindBy(id="customerName") public WebElement FullName;
	@FindBy(id="customerEmail") public WebElement Email;
	@FindBy(id="phone") public WebElement Phone;
	@FindBy(xpath="//button[contains(@class,'action-submit')]") public WebElement Continue;
	@FindBy(xpath="(//*[@name='arrivalTime'])[1]") public WebElement Timefield;
	@FindBy(id="loginButton") public WebElement loginButton;
	@FindBy(name="expiryMonth") public WebElement ExpirymonthMenu;
	@FindBy(name="expiryYear") public WebElement ExpiryearMenu;
	@FindBy(xpath="//button[contains(@class,'action-pay')]") public WebElement Paybtn;
	@FindBy(xpath="//*[contains(text(),'Your booking has been placed')]") public WebElement SucsessMsg;
	@FindBy(xpath   ="//*[text()='Checkout']") public WebElement Checkoutpage;
	@FindBy(id="cc-number") public WebElement CardNum;
	@FindBy(name="cvv") public WebElement Code;
	@FindBy(name="billingPostcode") public WebElement Zipcode;
	@FindBy(xpath="//*[contains(text(),'Card number is invalid')]") public WebElement InvalidCardMsg;
	WebDriverWait wait=null;

	 
	 
	public UtilityFunctions() {
		System.setProperty("webdriver.chrome.driver",".\\Jars\\chromedriver.exe");
		driver=new ChromeDriver();
		PageFactory.initElements(driver, UtilityFunctions.this);
		 wait=new WebDriverWait(driver,100);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	
	public void launchurl(String AppName) {
		switch(AppName){
		case "Booking page on BCT application":
			driver.get("https://sandbox-checkout.xola.com/index.html#seller/58e235b107876cdd1f8b45e2/experiences/58e2371107876cdd1f8b45e5");
			break;
		case "xyz":
			driver.get("https://xyz.com");
			break;
			default:
				System.out.println("Application name is not found");		
	}
		
		driver.manage().window().maximize();
	}
	
	public WebElement Waitforelement(WebElement Loc) {
		
		try {
			
			if(Loc==null) {
				System.out.println("Locator not present");
		}
		else if(Loc!=null){
			
			wait.until(ExpectedConditions.visibilityOf(Loc));
			
			Thread.sleep(1000);
		}
		else {
		System.out.println("element not visible");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Loc;
	}
	
	
	public void Datepicker() {
		Waitforelement(Todaydate).click();
		Waitforelement(Timefield).click();
	
	}
	
	public void EnterText(String ObjName,String txt) {	

		switch(ObjName){
		case "FullName":
			Waitforelement(FullName).sendKeys(txt);break;
		case "Email":
			Waitforelement(Email).sendKeys(txt);break;
		case "Phone":
			Waitforelement(Phone).sendKeys(txt);break;
		case "Cardnumber":
			Waitforelement(CardNum).sendKeys(txt);break;
		case "Code":
			Waitforelement(Code).sendKeys(txt);break;
		case "ZipCode":
			Waitforelement(Zipcode).sendKeys(txt);break;
			default:
				System.out.println("Object name is not found");		
	}
	}
	
	
public void SelectOption(String option ,String Dropdown) {
		
		switch(Dropdown){
		case "Expirymonth":
			Waitforelement(ExpirymonthMenu).click();
			Waitforelement(driver.findElement(By.xpath("//*[@name='expiryMonth']/option[contains(text(),'"+option+"')]"))).click();
			break;
		case "Expiryear":
			Waitforelement(ExpiryearMenu).click();
			Waitforelement(driver.findElement(By.xpath("//*[@name='expiryYear']/option[contains(text(),'"+option+"')]"))).click();
			break;
		
			default:
				System.out.println("Dropdown is not found");		
	}			
	}

	public void ClickOnElement(String ObjName) {
		switch(ObjName){
		case "Continue":
			Waitforelement(Continue).click();break;
		
		case "PAY":
			Waitforelement(Paybtn).click();break;
			
			default:
				System.out.println("Object name is not found");		
	}
	}
	
	
	
	public void VerifyPage() {
		Waitforelement(Checkoutpage).isDisplayed();
		
	}
	
	public void VerifyMessage(String msg,String page) {
		String message=null;
		switch(page){
		case "Orders":
			 message=Waitforelement(SucsessMsg).getText().trim();
		break;
		case "CardDetails":
			 message=Waitforelement(InvalidCardMsg).getText().trim();
			break;
			default:
				System.out.println("Message not found");		
	}
		
		Assert.assertEquals(msg, message);
	
	}
	
	public void closebrowser() {
		driver.close();
	}

	public void actionClick() {
		Waitforelement(loginButton).click();
		
	}


	
	
	
}
