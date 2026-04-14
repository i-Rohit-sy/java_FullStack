package com.learning;


public class Dev {

    public Dev() {
        System.out.println("DEV CONSTRUCTOR");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dev(int age) {
        this.age = age;
    }


    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    private Computer comp;
    private int age;
    public void build(){
        System.out.println("Working for Awesome Project");
        comp.compile();
    }
}
