package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by billy on 17-12-4.
 */
@Component
@Scope("prototype")
public class MyWebElement {

    private WebElement webElement;

    public MyWebElement(WebDriver webDriver, By by) {
        webElement = webDriver.findElement(by);
    }

    public void setText(String text) {
        webElement.sendKeys(text);
    }

}
