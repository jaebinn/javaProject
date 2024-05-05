package controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleController {
	static {
		Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
	}

	/**
	 * 자바문제 사이트 불러오기
	 */
	public static void exampleJava() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			String url = "https://school.programmers.co.kr/learn/challenges?order=recent&page=1&languages=java";
			driver.get(url);
			System.out.println("JAVA 문제  : " + url);
		} finally {

		}
	}

	/**
	 * sql문제 사이트 불러오기
	 */
	public static void exampleMySQL() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			String url = "https://school.programmers.co.kr/learn/challenges?order=recent&page=1&languages=mysql";
			driver.get(url);
			System.out.println("MySQL 문제  : " + url);
		} finally {

		}
	}
}
