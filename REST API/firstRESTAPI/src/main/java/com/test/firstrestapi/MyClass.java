package com.test.firstrestapi;

import jakarta.xml.bind.annotation.XmlRootElement;

public class MyClass {



    private String name;
    private int points;

    public MyClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
