package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {


	@Test(priority=5)
	public void negativeLogin() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		
	driver.findElement(By.xpath("//*[@id=\"gnav_565\"]/span/span/span/span")).click();
	driver.findElement(By.id("email")).sendKeys("SvetaJadhva@live.com");
	driver.findElement(By.id("pass")).sendKeys("Welcome");
	driver.findElement(By.id("send2")).click();
	Thread.sleep(3000);
	String error = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
	System.out.println(error);
	Assert.assertEquals(error, "Invalid login or password.");
	driver.quit();	
	}
	
	@Test(priority=10, enabled=false)
	
	public void positiveLogin() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		
	driver.findElement(By.xpath("//*[@id=\"gnav_565\"]/span/span/span/span")).click();
	driver.findElement(By.id("email")).sendKeys("SvetaJadhva@live.com");
	driver.findElement(By.id("pass")).sendKeys("Welcome123");
	driver.findElement(By.id("send2")).click();
	Thread.sleep(3000);
	
	driver.quit();	
	}

}
