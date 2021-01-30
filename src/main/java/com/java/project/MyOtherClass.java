package com.java.project;

public class MyOtherClass {

    private final MyClass myClass;

    public MyOtherClass(MyClass myClass) {
        this.myClass = myClass;
    }

    public int execute() {
        return 1 + myClass.sum();
    }
}
