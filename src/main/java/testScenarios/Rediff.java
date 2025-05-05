package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Rediff {
	WebDriver driver;
	@Test(description="Launch Rediff",priority=1)
	public void openBrowser()
	{
		System.out.println("Open Rediff");
		driver = new EdgeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();


	}
	@Test(description="Login Rediff-Hard Asser",priority=2,enabled=false)
	public void loginRediff1() throws InterruptedException
	{
		System.out.println("Login Rediff");
		String title=driver.getTitle();
		System.out.println("title="+title);
		Assert.assertEquals(title, "rediffmail - Free Email for Login with Secure Access");
		System.out.println("Assert Executed...");
		driver.findElement(By.id("login1")).sendKeys("jack");
		driver.findElement(By.id("password")).sendKeys("jack123");
		String chkRemStatus=driver.findElement(By.id("")).getAttribute("checked");
		if(chkRemStatus.equals("checked"))
		{
			driver.findElement(By.id("remember")).click();
		}
	}
	@Test(description="Login Rediff-Soft Assert",priority=2)
	public void loginRediff() throws InterruptedException
	{
		SoftAssert assertion = new SoftAssert();
		System.out.println("Login Rediff");
		String title=driver.getTitle();
		System.out.println("title="+title);
		assertion.assertEquals(title, "Rediffmail - Free Email for Login with Secure Access");
		System.out.println("Assert Executed...");
		driver.findElement(By.id("login1")).sendKeys("jack");
		driver.findElement(By.id("password")).sendKeys("jack123");
		String chkRemStatus=driver.findElement(By.id("remember")).getAttribute("checked");
		if(chkRemStatus.equals("checked"))
		{
			driver.findElement(By.id("remember")).click();
		}
		assertion.assertAll();
	}
	@Test(description="Close Rediff",priority=3)
	public void closeBrowser()
	{
		System.out.println("Close Rediff");
		driver.quit();
	}

}
