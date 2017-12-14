package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder();
        applicationBuilder.bannerMode(Banner.Mode.OFF);
        applicationBuilder.sources(DemoApplication.class);
        ConfigurableApplicationContext context = applicationBuilder.run();

        System.setProperty("webdriver.chrome.driver", "/home/billy/work/automation/test/test-data/bin/chromedriver.linux");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.baidu.com/");

        BaiduHomePage baiduHomePage = new BaiduHomePage(driver);

        baiduHomePage.inputSearchKeyword("testing");

        driver.quit();
	}
}
