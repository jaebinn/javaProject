package controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstallController {
	static {
		Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
	}

	/**
	 * 이클립스 설치사이트 불러오기
	 */
	public void installEclipse() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			String url = "https://www.eclipse.org/downloads/";
			driver.get(url);
			System.out.println("Elclips 설치  : " + url);
		} finally {

		}
	}

	/**
	 * visualstudioCode설치 사이트 연결
	 */
	public void installHTML() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			String url = "https://code.visualstudio.com/docs/languages/html";
			driver.get(url);
			System.out.println("HTML 설치  : " + url);
		} finally {

		}
	}

	/**
	 * mysql설치사이트 불러오기
	 */
	public void installMySQL() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			String url = "https://www.mysql.com/downloads/";
			driver.get(url);
			System.out.println("MYSQL 설치  : " + url);
		} finally {

		}
	}

	public static void main(String[] args) {
		InstallController installController = new InstallController();

		installController.installEclipse();

		installController.installMySQL();

		installController.installHTML();
	}
}
