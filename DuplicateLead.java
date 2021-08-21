package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("priya");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.xpath("(//td[contains(@class,'firstName')])[2]//a"));
		String firstnameText = firstName.getText();
		firstName.click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Duplicate Lead")).click();

		String title = driver.getTitle();
		System.out.println("title of current page is " + title);
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

		WebElement firstnamesp = driver.findElement(By.id("viewLead_firstName_sp"));
		String firstnamesp1 = firstnamesp.getText();

		if (firstnamesp1.equals(firstnameText)) {
			System.out.println("firstname matched ");
		} else {
			System.out.println("not matched ");
		}
		driver.close();

	}

}
