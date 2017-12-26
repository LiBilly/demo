package com.example.demo.core;

import org.openqa.selenium.remote.RemoteWebElement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by billy on 17-12-26.
 */
@Configuration
public class BeanConfig {

    @Bean
    @Scope("prototype")
    public RemoteWebElement makeWebElement() {
        return new RemoteWebElement();
    }
}
