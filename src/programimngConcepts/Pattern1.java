package programimngConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Pattern1 {

	static WebDriver dr;
	public static void main(String[] args) {
		
		launchBrower();
	    goToLeads();
	    createLeads();
	   }
	
	  public static void launchBrower() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\prankaj\\programimngConcepts\\chromedriver.exe");
		dr= new ChromeDriver();
		
		dr.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		
		
		dr.get("http:/localhost:8888/");
		dr.manage().window().maximize();
		
		WebElement userName=dr.findElement(By.xpath("//input[@name='user_name']"));
		userName.sendKeys("admin");
		WebElement userId=dr.findElement(By.xpath("//input[@name='user_password']"));
		userId.sendKeys("admin");
		
		WebElement userlogin=dr.findElement(By.xpath("//input[@name='Login']"));
		userlogin.click();
	    String homepageTitle=dr.getTitle();
	    System.out.println(homepageTitle);
	   
	   // dr.close();
		}
	  
	  public static void goToLeads() {
		  Actions ac= new Actions(dr); 
		  WebElement we=dr.findElement(By.xpath("//a[text()='Marketing']"));
		  ac.moveToElement(we).build().perform();
		  
		  dr.findElement(By.xpath("//div[@id='Marketing_sub']//a[text()='Leads']")).click();
		  dr.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		  
	  }
	  public static void createLeads() {
		  WebElement we=dr.findElement(By.xpath("//select[@name='salutationtype']"));
		  Select sl= new Select(we);
		  sl.selectByValue("Mr.");
		  dr.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Pankaj");
		  dr.findElement(By.xpath("//input[@name='lastname']")).sendKeys("yadav");
		  dr.findElement(By.xpath("//input[@name='company']")).sendKeys("Espire infolab");

		 
		  //sendKeys("Pankaj");
		  
		  
		  
		  
	  }
	  
	}
		
		
		
		
	
	



