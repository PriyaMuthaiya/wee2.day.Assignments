package week2.day2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following-sibling::div[1]//input")).click();
		
		boolean selected = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following-sibling::div[1]//input")).isSelected();
		if(selected) {
			System.out.println("Selenium is selected");
		}
		
		//findElements = driver.findElements(By.xpath("//label[text()='DeSelect only checked']/following-sibling::div"));
		List<WebElement>  chkbox = driver.findElements(By.xpath("//label[text()='DeSelect only checked']/following-sibling::div//input"));
		for (WebElement ele : chkbox) {
			
			if(ele.isSelected()==true)
			{
				ele.click();
				
			}
			
		}
		
		List<WebElement> all_chkbox = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following-sibling::div//input"));
		int size=all_chkbox.size();
		for (int i = 0; i < size; i++) {
			all_chkbox.get(i).click();
		}
	
	
	}

}
