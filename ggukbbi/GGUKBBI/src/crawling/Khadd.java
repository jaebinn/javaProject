package crawling;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Khadd {
	private WebDriver driver;

	public Khadd() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");// 코드 실행시 브라우저 창이 표시되지않고 콘솔창에서만 띄우게 하는 코드

		// Selenium 로깅 레밸 설정해주는 코드
		System.setProperty("java.util.logging.ConsoleHandler.level", "SEVERE");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE); // 콘솔창에 뜨는 빨간줄 오류를 없애는 코드
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver(options);
	}

	/**
	 * KH정보교육원소개 코드
	 */
	public void executeKhInfo() {
		// 웹 페이지 이동
		String url = "https://khedu.co.kr/intro/intro.kh";
		driver.get(url);

		// 웹 페이지의 정보를 추출하는 코드
		WebElement contentSectionElement = driver.findElement(By.cssSelector(".content_section"));
		String sectionTitleText = contentSectionElement.findElement(By.cssSelector(".section_title")).getText();
		String sectionSubtitleText = contentSectionElement.findElement(By.cssSelector(".section_subtitle")).getText();
		String subtitleTopText = contentSectionElement.findElement(By.cssSelector(".subtitle_top")).getText();
		String subtitleTextTopText = contentSectionElement.findElement(By.cssSelector(".subtitle_text_top")).getText();

		System.out.println("★☆★☆ ▶Kh정보교육원  소개◀★☆★☆ ");
		System.out.println("   " + sectionTitleText);
		System.out.println(sectionSubtitleText);
		System.out.println("     " + subtitleTopText);
		System.out.println(subtitleTextTopText.replace("\n", " "));
	}

	/**
	 * KH정보교육원 오시는길 코드
	 */
	public void executeKhAddressWalk() {
		// 웹페이지 이동
		String url = "https://khedu.co.kr/intro/contact.kh";
		driver.get(url);
		System.out.println("\n============※KH정보교육원 오시는길※============");

		// 웹페이지에서 오시는길 정보를 추춤 및 출력 하는코드
		WebElement table = driver.findElement(By.cssSelector("table"));
		System.out.println("                    오시는 길&버스,지하철");
		System.out.println("                    ↓");
		// 테이블의 각 행과 열에 있는 텍스트를 출력하는 코드
		for (WebElement row : table.findElements(By.cssSelector("tbody tr"))) {
			for (WebElement cell : row.findElements(By.cssSelector("td"))) {
				String cellText = cell.getText().trim();
				if (!cellText.equals("50m")) {
					System.out.print(cellText);
				}
			}
			System.out.println();
		}
	}

	// Selenium WebDriver 종료하는 코드
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}