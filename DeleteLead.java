package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		WebElement leadID = driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[2]//a"));
		String leadIDtext = leadID.getText();
		leadID.click();

		String findLeadURL = driver.getCurrentUrl();
		System.out.println("landed in view lead page" + findLeadURL);
		
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("priya");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		
			String leadIDAfterDeletionText = driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[2]//a")).getText();
		
		if(!leadIDtext.equals(leadIDAfterDeletionText)) {
			System.out.println("lead Id not exist");
		}
		driver.close();
		/*http://leaftaps.com/opentaps/control/main
		 
		Delete Lead:
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Phone
		9	Enter phone number
		10	Click find leads button
		11	Capture lead ID of First Resulting lead
		12	Click First Resulting lead
		13	Click Delete
		14	Click Find leads
		15	Enter captured lead ID
		16	Click find leads button
		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		18	Close the browser (Do not log out)
*/

	}

}
