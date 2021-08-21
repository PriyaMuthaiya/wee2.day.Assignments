package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("priya");
		driver.findElement(By.id("lastNameField")).sendKeys("muthaiya");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("ddds");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("test");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createContactForm_description")).sendKeys("i am learning selenium");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("mrpriya1994@gmail.com");
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select stateDD = new Select(state);
		stateDD.selectByIndex(10);

		driver.findElement(By.name("submitButton")).click();

		Thread.sleep(2000);

		driver.findElement(By.linkText("Edit")).click();

		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("updated");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		driver.close();

		
	}

}
