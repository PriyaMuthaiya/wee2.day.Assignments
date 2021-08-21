package week2.day2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListBox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Dropdown.html");

		driver.manage().window().maximize();

		WebElement index = driver.findElement(By.id("dropdown1"));

		Select indexDD = new Select(index);

		indexDD.selectByIndex(2);

		WebElement text = driver.findElement(By.name("dropdown2"));
		Select textDD = new Select(text);
		textDD.selectByVisibleText("Selenium");

		WebElement val = driver.findElement(By.id("dropdown3"));
		Select valDD = new Select(val);
		valDD.selectByValue("3");
		// select last but one dropdown
		WebElement option = driver.findElement(By.className("dropdown"));
		Select optionDD = new Select(option);
		List<WebElement> optionsList = optionDD.getOptions();
		System.out.println(optionsList.size());
		int ddsize = optionsList.size();
		int lastSize = ddsize - 2;
		optionDD.selectByIndex(lastSize);

		WebElement select = driver.findElement(By.xpath("(//div[@class='example']/select)[6]"));
		Select selDD = new Select(select);
		boolean multi = selDD.isMultiple();
		if (multi == true) {
			selDD.selectByIndex(2);
			selDD.selectByIndex(3);
			List<WebElement> allSelectedOptions = selDD.getAllSelectedOptions();
			for (WebElement ele : allSelectedOptions) {
				String text2 = ele.getText();
				System.out.println(text2);

			}

			driver.close();

		}

	}

}
