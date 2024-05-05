package controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class VideoController {
	static {
		Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
	}

	/**
	 * 자바강의 유튜브 불러오기
	 */
	public void videoJavaController() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			String url = "https://www.youtube.com/watch?v=jdTsJzXmgU0&list=PLuHgQVnccGMCeAy-2-llhw3nWoQKUvQck";
			driver.get(url);
			System.out.println("자바  : " + url);
		} finally {

		}
	}

	/**
	 * html강의 불러오기
	 */
	public void videoHtmlController() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			String url = "https://www.youtube.com/watch?v=iATpw-BmTK4&list=PLFeNz2ojQZjtQc7mt8E9fNzIh9or34A61&index=7";
			driver.get(url);
			System.out.println("HTML : " + url);
		} finally {

		}
	}

	/**
	 * sql강의 불러오기
	 */
	public void videoSqlController() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			String url = "https://www.youtube.com/watch?v=xKYeJxBTt2E&list=PLVsNizTWUw7Hox7NMhenT-bulldCp9HP9";
			driver.get(url);
			System.out.println("MYSQL : " + url);
		} finally {

		}
	}

	public static void main(String[] args) {
		VideoController videoController = new VideoController();

		videoController.videoJavaController();

		videoController.videoHtmlController();

		videoController.videoSqlController();
	}
}
