package com.example.demo.webuitest;

import com.example.demo.webuitest.pagefacory.MyPageFactory;
import com.example.demo.webuitest.pages.BaiduHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.net.URL;

/**
 * Created by billy on 17-12-28.
 */
public class Test1 {

    private WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        URL url = this.getClass().getClassLoader().getResource("chromedriver.linux");
        File chromeDriverExecutionFile = new File(url.getFile());
        webDriver = new ChromeDriver(
                new ChromeDriverService.Builder()
                    .usingDriverExecutable(chromeDriverExecutionFile)
                    .usingAnyFreePort()
                .build()
        );
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }

    @BeforeMethod
    public void before() {

    }

    @AfterMethod
    public void after() {

    }

    @Test(description = "a test")
    public void doSearchTest() {
        webDriver.get("https://www.baidu.com");
        BaiduHomePage baiduHomePage = new BaiduHomePage(webDriver);
        baiduHomePage.doSearch("i do a test");
        String pageTitle = webDriver.getTitle();
        Assert.assertEquals(pageTitle, "i do a test_百度搜索");
    }

}
