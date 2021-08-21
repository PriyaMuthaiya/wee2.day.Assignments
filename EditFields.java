package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Edit.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("mrpriya1994@gmail.com");
		WebElement append = driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following-sibling::input"));
		append.click();
		append.sendKeys("text");
		
		String defaultText = driver.findElement(By.xpath("//label[text()='Get default text entered']/following-sibling::input")).getAttribute("value");
		System.out.println("default text is "+defaultText);
		
		driver.findElement(By.xpath("//label[text()='Clear the text']/following-sibling::input")).clear();
		boolean idDisplayed=driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input")).isDisplayed();
		
		if(idDisplayed=true) {
			System.out.println("field is enable");
		}
		else {
			System.out.println("field is disable");
		}
		
		
		
	}

}
