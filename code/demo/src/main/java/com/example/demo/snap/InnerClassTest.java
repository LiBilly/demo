package com.example.demo.snap;

/**
 * Created by billy on 18-1-5.
 */
public class InnerClassTest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    class InnerClassA {
        private String innerName;

        public String getInnerName() {
            return innerName;
        }

        public void setInnerName(String innerName) {
            this.innerName = innerName;
        }
    }
}
