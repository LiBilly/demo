package com.example.demo;

import com.example.demo.core.FindBy;
import org.openqa.selenium.WebDriver;

/**
 * Created by billy on 17-12-4.
 */
public class BaiduHomePage {

    @FindBy("test")
    private MyWebElement keywordInput;

    private WebDriver webDriver;

    public BaiduHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void inputSearchKeyword(String keyword) {
        keywordInput.setText(keyword);
    }

}
