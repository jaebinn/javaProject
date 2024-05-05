package crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KhAddressWalk {
	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://khedu.co.kr/intro/contact.kh");

		try {
			WebElement table = driver.findElement(By.cssSelector("table"));

			for (WebElement row : table.findElements(By.cssSelector("tbody tr"))) {
				for (WebElement cell : row.findElements(By.cssSelector("td"))) {
					String cellText = cell.getText().trim();

					if (!cellText.equals("50m")) {
						System.out.print(cellText);
					}
				}
				System.out.println();
			}
		} finally {
			driver.quit();
		}
	}
}
