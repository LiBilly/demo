package com.example.demo.webuitest.pages;

import com.example.demo.webuitest.pagefacory.MyPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by billy on 17-12-28.
 */
public class BaiduHomePage {

    private WebDriver webDriver;

    @FindBy(id = "kw")
    private WebElement keywordInput;

    @FindBy(id = "su")
    private WebElement searchBtn;

    public BaiduHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        MyPageFactory.initElements(webDriver, this);
    }

    public void doSearch(String searchKeyword) {
        keywordInput.sendKeys(searchKeyword);
        searchBtn.click();
    }

}
