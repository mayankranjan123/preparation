package javaCode;

import java.util.ArrayList;
import java.util.List;

public class FinalClass extends ChildClass{
    static final int y;

    static {
        y = 344;
    }

    public FinalClass() {
        System.out.println("Final Class default");
    }

    public FinalClass(int x) {
        System.out.println("Parameter" + x);
    }

    public static void main(String[] args) {
        final int x = 3;
        System.out.println("Hello");
        FinalClass finalClass = new FinalClass(3);
        finalClass = new FinalClass();
    }
}

class ChildClass {
    public ChildClass(int x) {

        System.out.println("Child" + x);
    }

    public ChildClass() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list);
        System.out.println("Child Default");
    }
}
