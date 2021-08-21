package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Images {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following-sibling::img")).click();
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("landed in home page"+currentUrl);
		
		driver.navigate().back();
		
		WebElement brokenIMg = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']"));
		String src = brokenIMg.getAttribute("src");
		driver.navigate().to(src);
		
		if(driver.getTitle().contains("404")) {
			System.out.println("img is brocken");
		}
		driver.navigate().back();
		
		driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img")).click();
		
		driver.close();
		
		

	}

}
