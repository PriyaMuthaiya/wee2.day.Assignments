package week2.day2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * 1.Go to https://www.redbus.in/ in chrome 2.Type Chennai in From textBox and
		 * ENTER 3.Type Bengaluru in Destination textBox and ENTER 4.Choose any date in
		 * JULY 5.Click Search Buses 6.Close the popup using the X button at the right
		 * corner 7.Print the number of search results 8.Choose only Sleeper Bus 9.Print
		 * the number of search results 10.Deselect the sleeper Bus and select the AC
		 * bus alone 11.Print the number of search results 12.Choose also Non AC buses
		 * 13.Print the number of search results
		 * 
		 * 
		 * //
		 */
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.redbus.in/");

		driver.manage().window().maximize();
		WebElement From = driver.findElement(By.xpath("//input[contains(@data-message,'source')]"));
		From.click();
		From.sendKeys("Chennai");
		From.sendKeys(Keys.ENTER);
		WebElement To = driver.findElement(By.xpath("//input[contains(@data-message,'destination')]"));
		To.click();
		To.sendKeys("Bangalore");
		To.sendKeys(Keys.ENTER);

		driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.xpath("//td[@class='current day']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		Thread.sleep(5000);
		WebElement close = driver.findElement(By.xpath("//i[@class='icon icon-close c-fs']"));
		if (close.isDisplayed()) {
			close.click();
		}
		WebElement sleeper = driver.findElement(By.xpath("(//label[@for='bt_SLEEPER'])[1]"));
		sleeper.click();
		List<WebElement> allBus = driver.findElements(By.xpath("//div[@class='clearfix bus-item-details']/.."));
		int size = allBus.size();
		int sumBus = 0;
		for (int i = 0; i < size; i++) {
			sumBus += i;

		}
		System.out.println(sumBus);

		driver.findElement(By.xpath("(//label[@for='bt_AC'])[1]")).click();

		int size1 = allBus.size();
		int sumBus1 = 0;
		for (int i = 0; i < size1; i++) {
			sumBus1 += i;

		}

		System.out.println(sumBus1);

		sleeper.clear();

		int size2 = allBus.size();
		int sumBus2 = 0;
		for (int i = 0; i < size2; i++) {
			sumBus2 += i;

		}

		System.out.println(sumBus2);
	}

}
