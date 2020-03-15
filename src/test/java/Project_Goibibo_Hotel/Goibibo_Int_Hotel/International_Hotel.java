package Project_Goibibo_Hotel.Goibibo_Int_Hotel;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class International_Hotel {
	
	



	WebDriver driver;
	
	
	
	String hotel_icon = "//i[@class='icon-hotels db blue ico28 lh1-2 padT2 padB3']";
	
	String enter_location = "//input[@id='downshift-1-input']";
	
	String search_button = "//button[@class='SearchBlockUIstyles__SearchButtonAutoSuggest-fity7j-12 kGmYkx']";
	
	String View_Rooms_Detailspage = "//div[@class='TextFieldExpt__Tag-sc-7a7pro-0 gyhFEy']";
	
	String book_now_button = "//section[1]//div[1]//div[2]//div[2]//div[3]//button[1]";
	
	String book_now_details = "//*[@id=\"rooms\"]/div[2]/div/div[2]/div[1]/div[3]/button";
	
	String select_adult_type = "//select[@class='PersonalProfile__NameEnterSelect-sc-1r9ak8b-9 bOfOHT']//option[1]";
	
	String name_coulum = "//input[@placeholder='Enter First Name']";
	
	String lastname_coulum = "//input[@placeholder='Enter Last Name']";
	
	String mail_coulum = "//input[@placeholder='Enter Email Address']";
	
	String mobileno_coulum = "//input[@placeholder='Enter Phone Number']";
	
	String payment_button = "//div[@class='GuestDetailBlock__PayBtnWrapDiv-sc-6dnm3n-10 jFbsRm']";
	
	String select_nb = "//div[@id='tab_nb']";
	
	String bank_selection = "//div[@id='banksRadio']//div[1]//div[1]";
	
	String make_payment = "//*[@id=\"nbPayNow\"]/div/button";
	
	  @Test (priority=0 ,groups = {"Click on Icon"})
	  public void Icon() {
		  
			
			driver.findElement(By.xpath(hotel_icon)).click();
	  }

			
	  @Test (priority=1 ,groups = {"Enter the Location"})
	  
	  public void location() {
		  
			driver.findElement(By.xpath(enter_location)).sendKeys("Singapore");
			
			driver.findElement(By.id("downshift-1-item-0")).click();
			
	  }
	  
	  @Test (priority=2 ,groups = {"Click on search button"})

		
	  public void search_button1() {
		  
		  driver.findElement(By.xpath(search_button)).click();
	  }
			
	  
	  
  @Test (priority=3 ,groups = {"Click on first hotel from SRP page"})
	  
	  public void Hotel_selction() {
	  
		  
		  driver.findElement(By.xpath("//*[@id=\"root\"]/span/div/section[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/div/div[3]/button")).click();
		  
		
	  }
	  
//	  @Test (priority=3 ,groups = {"Click on first hotel from SRP page"})
//	  
//	  public void Book_from_detailspage() {
//		  
//		 
//		  
//		  driver.findElement(By.xpath(book_now_details)).click();
//		  
//		
//	  }
	  
	  @Test (priority=4 ,groups = {"Tab swicth to new window"})
	  
	  public void tab_switcher() {
		  
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		  
		  driver.switchTo().window(tabs.get(1));
		  
	  }

	  @Test (priority=5 ,groups = {"Book hotels"})
	  
	  public void Book_now_detailspage() throws InterruptedException {
		  
		  Thread.sleep(3000);
		  
//		  driver.findElement(By.xpath("View_Rooms_Detailspage")).click();
		  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,300)", "");
		  
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath(book_now_details)).click();
		  
	  }
	
	  
	    @Test (priority=6 ,groups = {"Enter customer Details"})

	    public void customer_details() {
	    	
	    	driver.findElement(By.xpath(select_adult_type)).click();

	    	driver.findElement(By.xpath(name_coulum)).sendKeys("Test");
	    	
	    	driver.findElement(By.xpath(lastname_coulum)).sendKeys("Hotel");
	    	
	    	driver.findElement(By.xpath(mail_coulum)).sendKeys("testnoc009@gmail.com");
	    	
	    	driver.findElement(By.xpath(mobileno_coulum)).sendKeys("9999999999");
	    	
	    }
		
	    
	    @Test (priority=7 ,groups = {"Proceed to payment page"})

	    public void Proceed_to_payment() throws InterruptedException {
	  
	    	driver.findElement(By.xpath(payment_button)).click();
	    	
	    	Thread.sleep(7000);
	    	    	
	    	driver.findElement(By.xpath(select_nb)).click();
	    	
	    	

	    	driver.findElement(By.xpath(bank_selection)).click();
	    	
	    	driver.findElement(By.xpath(make_payment)).click();
	    	
	    	Thread.sleep(3000);
	    }
	    

  
  @BeforeClass
  public void beforeClass()  {
	  
	  System.setProperty("webdriver.chrome.driver", "D:\\Eclips backup\\Jar Files for use in selenium\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	


	
	  driver.navigate().to("http://www.goibibo.com");
	  
	  driver.manage().window().maximize();
  
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}

  

