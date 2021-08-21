package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");

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
		driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[2]//a")).click();

		String findLeadURL = driver.getCurrentUrl();
		System.out.println("landed in view lead page" + findLeadURL);

		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(2000);

		String editLeadURL = driver.getCurrentUrl();
		System.out.println("landed in view lead page" + editLeadURL);
		WebElement companyname = driver.findElement(By.id("updateLeadForm_companyName"));
		companyname.clear(); // clear existing name of company
		companyname.sendKeys("new company");
		String newCompany = companyname.getAttribute("value");

		String newCompany1 = newCompany.replaceAll("\\d", "");
		driver.findElement(By.className("smallSubmit")).click();

		WebElement editedCompany = driver.findElement(By.id("viewLead_companyName_sp"));

		String companyText = editedCompany.getText();
		/*
		 * String textOnly = companyText.replaceAll("\\d", "");
		 * System.out.println(textOnly); System.out.println(newCompany1);
		 * if(newCompany1.contains(textOnly)) {
		 * System.out.println("Edited company name is matched"); } else {
		 * System.out.println("not same"); }
		 */

		if (editedCompany.isDisplayed()) {
			System.out.println("Company name displayed");
		}
		driver.close();

	}

}
