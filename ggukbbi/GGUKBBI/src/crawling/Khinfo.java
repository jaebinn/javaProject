package crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Khinfo {
	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);

		String url = "https://khedu.co.kr/intro/intro.kh";

		try {
			driver.get(url);

			WebElement contentSectionElement = driver.findElement(By.cssSelector(".content_section"));

			String sectionTitleText = contentSectionElement.findElement(By.cssSelector(".section_title")).getText();
			String sectionSubtitleText = contentSectionElement.findElement(By.cssSelector(".section_subtitle"))
					.getText();
			String subtitleTopText = contentSectionElement.findElement(By.cssSelector(".subtitle_top")).getText();
			String subtitleTextTopText = contentSectionElement.findElement(By.cssSelector(".subtitle_text_top"))
					.getText();

			System.out.println("★☆★☆About Kh정보교육원 ★☆★☆ ");
			System.out.println("            " + sectionTitleText);
			System.out.println("       " + sectionSubtitleText);
			System.out.println("            " + subtitleTopText);
			System.out.println("   " + subtitleTextTopText.replace("\n", " "));

		} finally {
			driver.quit();
		}
	}
}