package com.test.firstrestapi;

import java.util.ArrayList;
import java.util.List;

public class MyClassRepo {
    List<MyClass> my;

    public MyClassRepo(){
        my = new ArrayList<>();
        MyClass myClass1 = new MyClass();
        myClass1.setName("Rohit");
        myClass1.setPoints(20);

        MyClass myClass2 = new MyClass();
        myClass2.setName("Ram");
        myClass2.setPoints(29);

        my.add(myClass1);
        my.add(myClass2);
    }

    public List<MyClass> getMyClass(){
        return my;
    }
    public MyClass getmy(int id){
        MyClass mc = null;
        for(MyClass a: my){
            if(a.getPoints()==id) return a;
        }
        return null;
    }

    public void create(MyClass m1) {
        my.add(m1);
    }
}
