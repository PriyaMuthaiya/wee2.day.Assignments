package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");

		driver.manage().window().maximize();
		WebElement Homepage = driver.findElement(By.linkText("Go to Home Page"));

		String firstlink = Homepage.getAttribute("href");
		Homepage.click();

		driver.navigate().back();

		String withoutClick = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"))
				.getAttribute("href");

		System.out.println("Find where am supposed to go without clicking me " + withoutClick);

		driver.findElement(By.linkText("Verify am I broken?")).click();

		String title = driver.getTitle();
		if (title.contains("404 – Not Found")) {
			System.out.println("broken link");

		} else {
			System.out.println(title);
		}

		driver.navigate().back();

		String fourthLink = driver.findElement(By.linkText("Go to Home Page")).getAttribute("href");

		if (firstlink.equals(fourthLink)) {
			Homepage.click(); // doubt
		}

		driver.navigate().back();

		driver.findElement(By.id("How many links are available in this page?")).click();

		int size = driver.findElements(By.tagName("a")).size();

		System.out.println("There are " + size + " in web page");
		driver.close();

	}

}
