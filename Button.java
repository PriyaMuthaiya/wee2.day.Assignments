package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("home")).click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Landed in Home Page " + currentUrl);

		driver.navigate().back();

		// get position

		WebElement position = driver.findElement(By.id("position"));
		Point location = position.getLocation();
		int x = location.getX();
		int y = location.getY();

		System.out.println("location of button is" + x + "&" + y);

		// find color

		String buttonColor = driver.findElement(By.id("color")).getCssValue("background-color");

		System.out.println("button color is " + buttonColor);
		//find size
		Dimension size = driver.findElement(By.id("size")).getSize();
		System.out.println("size of button is "+size);
		
		

	}

}
