package com.example.demo.webuitest.pagefacory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

/**
 * Created by billy on 17-12-27.
 * implement follow {@link org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory}
 */
public class MyElementLocatorFactory implements ElementLocatorFactory {
    private final SearchContext searchContext;

    public MyElementLocatorFactory(SearchContext searchContext) {
        this.searchContext = searchContext;
    }

    @Override
    public ElementLocator createLocator(Field field) {
        return new MyElementLocator(searchContext, field);
    }

}
