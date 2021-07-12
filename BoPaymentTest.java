import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.support.ui.ExpectedCondition;
public class BoPaymentTest {
	
	ExtentReports extent;
	ExtentSparkReporter spark;
	
	WebDriver driver = null;
	
	@BeforeTest
	public void SetUpTest() {
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/Spark/Spark.html");
		extent.attachReporter(spark);
		
		String ProjectPath = System.getProperty("user.dir");
		System.out.println("ProjectPath" + ProjectPath);
		//For Chrome
		System.setProperty("webdriver.chrome.driver", ProjectPath + "\\Drivers\\ChromeDriver\\chromedriver.exe");
	   driver = new ChromeDriver();
		}
	
	@Test(priority = 1)
		public void OpenBrowser () throws InterruptedException
		{
		ExtentTest test2 = extent.createTest("Open Browser", "This test is to open BoPayment web app");
		test2.log(Status.INFO, "Starting 1st test case to open browser");
		
			 driver.get("https://bopayments-frontend.azurewebsites.net/");
			 Thread.sleep(3000);
			 
			 test2.pass("Navigated to BoPayment Web App");
			 
			 driver.manage().window().maximize();
		}
	
		@Test(priority = 2)	
		public void Login() throws InterruptedException
		{
			ExtentTest test2 = extent.createTest("Login to BoPayment", "This test is to Login on BoPayment web app");
			test2.log(Status.INFO, "Starting 2nd test case to login");
			
			
	   //email
	   driver.findElement(By.name("email")).sendKeys("saadriaz@troontechnologies.com");
	    Thread.sleep(2000);
      //password
      driver.findElement(By.name("password")).sendKeys("Troon@123");
      Thread.sleep(2000);
     //show 
      driver.findElement(By.xpath("//*[@id=\"PassFrmgrp_lgn\"]/div/span[2]")).click();
      Thread.sleep(2000);
     //hide
      driver.findElement(By.xpath("//*[@id=\"PassFrmgrp_lgn\"]/div/span[2]")).click();
      Thread.sleep(2000);
     //login button
      driver.findElement(By.id("login")).click();
      Thread.sleep(6000);
      
      test2.pass("Login successfully on BoPayment web app");
		}
		// to generate random email every time
		private static String randomEmailCard() {
	        return "hajira+" + UUID.randomUUID().toString() + "@troontechnologies.com";
	    }
		
		@Test(priority = 3 )
		public void Cards() throws InterruptedException
		{ 
			ExtentTest test2 = extent.createTest("Add card", "This test is to add card on BoPayment web app");
			test2.log(Status.INFO, "Starting 3rd test case to add card");
			
      //cards
      driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/i[1]")).click();
      Thread.sleep(2000);
      //issue card
      driver.findElement(By.xpath("//*[@id=\"onboarding\"]/div/div/div[2]/div[2]/div[3]/div/div/a")).click();
      Thread.sleep(2000);
      //issue card button
      driver.findElement(By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[2]/div/div/div/div/form/div/div[2]/div/button[2]")).click();
      Thread.sleep(2000);
      //drop down menu to select client
      
      Select Client = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/select[1]")));
		Client.selectByIndex(1);

       //name
      driver.findElement(By.xpath("//*[@id=\"name-frmgrp\"]/div/div/input")).sendKeys("Maryam");
      Thread.sleep(2000);
	
    
    final String randomEmailCard = randomEmailCard(); 
      //email
	WebElement CardEmail =  driver.findElement(By.xpath("//*[@id=\"Email-frmgrp\"]/div/div/input"));
	CardEmail.sendKeys(randomEmailCard);
	
    Thread.sleep(2000);
    
	 //.sendKeys("Hajira+y29@troontechnologies.com"); 
	
		 
       //click on country drop down button
      driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div"
      		+ "[1]/div[2]/div[1]/div[1]"
      		+ "/form[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
      Thread.sleep(2000);
      //click on specific country
      driver.findElement(By.xpath("//span[contains(text(),'Belgium')]")).click();
      Thread.sleep(2000);
    //enter phone number
      driver.findElement(By.xpath("//*[@id=\"phone-frmgrp\"]/div/div/input")).sendKeys("123456");
      Thread.sleep(2000);
    //Pick Date field
      driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div"
      		+ "[2]/div[1]/div[1]/form[1]/div[1]/div[6]")).click();
     //Select DOB
      driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]"
      		+ "/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]")).click();
    //enter address
     driver.findElement(By.xpath("//*[@id=\"cardHolder\"]/div/form/div/div[7]/div/div/div/input")).sendKeys("Rawalpindi");
     Thread.sleep(2000);
    //Click on issue card button
    driver.findElement(By.xpath(" //*[@id=\"cardHolder\"]/div/form/div/div[8]/div/button[2]")).click();
    Thread.sleep(2000);
    //click on done button
    driver.findElement(By.xpath("//*[@id=\"cardDetails\"]/div/div[2]/div/button")).click();
    Thread.sleep(6000);
    
    //Click on OK button
    driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/button[1]")).click();
    Thread.sleep(2000);
    
    
    test2.pass("Card has been added successfully on BoPayment web app");
		}
    
		@Test(priority = 4)
		
		public void Transactions()  throws InterruptedException
		{
    
			
			ExtentTest test2 = extent.createTest("Open Transactions", "This test is to open and view transactions on BoPayment web app");
			test2.log(Status.INFO, "Starting 4rth test case to view transactions");
			
    //click on transactions
    driver.findElement(By.xpath("//*[@id=\"transactionNavLink\"]")).click();
    Thread.sleep(2000);
    
    test2.pass("Transactions Viewed");
		}
		
		//to generate random email
		private static String randomEmailClient() {
	        return "hajira+C" + UUID.randomUUID().toString() + "@troontechnologies.com";
	    } 
		@Test(priority = 5)
	
		public void Client() throws InterruptedException
		{
			ExtentTest test2 = extent.createTest("Add Client", "This test is to add client on BoPayment web app");
			test2.log(Status.INFO, "Starting 5th test case to add client");
    //click on Clients
    driver.findElement(By.linkText("Clients")).click();
    Thread.sleep(2000);
    
    //click on add clients
    driver.findElement(By.linkText("Add Client")).click();
    Thread.sleep(2000);
    
    //company name
    driver.findElement(By.xpath(" /html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div"
    		+ "[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]\r\n")).sendKeys("Troon Tech");
    Thread.sleep(2000);
    
    //Email
    final String randomEmailClient = randomEmailClient(); 
    WebElement ClientEmail =  driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"));
	ClientEmail.sendKeys(randomEmailClient);
	
    Thread.sleep(2000);

     
     //click on country drop down button
     driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]"
     		+ "/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
     Thread.sleep(2000);
     
     //click on specific country
     driver.findElement(By.xpath("//span[contains(text(),'Cyprus')]")).click();
     Thread.sleep(2000);
     
     //enter phone number
     driver.findElement(By.xpath("//*[@id=\"id_phonenumber\"]/div/div/div/input")).sendKeys("0000000");
     Thread.sleep(2000);
     
     //point of contract
     driver.findElement(By.xpath("  //*[@id=\"body\"]/div[5]/div/div/div[2]/div/div/div[2]/div/form/div/div[4]/div/div/div/input")).sendKeys("Testing");
     Thread.sleep(2000);
 
     //Prefund amount
     driver.findElement(By.xpath("//*[@id=\"id_prefundamount\"]/div/div/div/input")).sendKeys("5000");
     Thread.sleep(2000);
     
     //select Status
      Select status = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]"
      		+ "/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/select[1]")));
      Thread.sleep(2000);
		status.selectByIndex(0);
		
     //Address
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div"
				+ "[2]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Rawalpindi");
		Thread.sleep(2000);
		
		//select role
		Select role = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[9]/div[1]/div[1]/select[1]")));
			role.selectByIndex(1);
			Thread.sleep(2000);
			
			
		//checkboxes to select roles
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[11]/ul[1]/li[2]/div[1]/label[1]")).click();
		Thread.sleep(1000);
		
		//another checkbox	
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[11]/ul[1]/li[4]/div[1]/label[1]")).click();
		Thread.sleep(2000);

		//Click on add client button
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[12]/div[1]/a[2]")).click();
		Thread.sleep(3000);
		
		test2.pass("Client has been added successfully");
		
		// new clients tab
		driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[2]/div[3]/ul[1]/li[2]/button[1]")).click();
		Thread.sleep(5000); 
		//all clients tab
		driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[2]/div[3]/ul[1]/li[1]/button[1]")).click();
		Thread.sleep(3000);
		
}
		@Test(priority = 6)
		
		public void Deposit() throws InterruptedException
		{
			ExtentTest test2 = extent.createTest("Open Deposit", "Now, This test is to open and view deposit details on BoPayment web app");
			test2.log(Status.INFO, "Starting 6th test case to view deposit");
			//deposit
			driver.findElement(By.linkText("Deposit")).click();
			Thread.sleep(6000);
			//deposit view details
			driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/span[1]")).click();
			Thread.sleep(2000);
			//accept button
			driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/button[2]")).click();
			Thread.sleep(2000);
			//accept confirmation
			driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/button[2]")).click();
			Thread.sleep(5000);
			
			test2.pass("Deposit details viewed successfully");
			//go to dashboard
			driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/button[1]")).click();
			Thread.sleep(2000);
			
		}
		
		
        @Test(priority = 7)
		
		public void Settings() throws InterruptedException
		{
        	
        	ExtentTest test2 = extent.createTest("Open Settings", "This test is to open settings on BoPayment web app");
			test2.log(Status.INFO, "Starting 7th test case to access settings page");
	    //setting
		driver.findElement(By.linkText("Settings")).click();
		Thread.sleep(2000);
		test2.pass("Viewed Setting page");
		}

          @Test(priority = 8)
         public void Help () throws InterruptedException
              {
        	  
        	   	ExtentTest test2 = extent.createTest("Open Help", "This test is to go to help page on BoPayment web app");
    			test2.log(Status.INFO, "Starting 8th test case to access help page");
	          //help
             driver.findElement(By.linkText("Help")).click();
          Thread.sleep(3000);
          test2.pass("Viewd Help page");
            }

    @AfterTest()
	public void CloseTest() 
	{
    	//logout
    	driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[8]/a[1]")).click();
		System.out.println("Logout Successfully");
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		extent.flush();
	}
}