package com.example;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class MyApplication extends Application {
    HashSet<Object> singletons = new HashSet<Object>();

    public MyApplication() {
        singletons.add(new Greeting());
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();
        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
