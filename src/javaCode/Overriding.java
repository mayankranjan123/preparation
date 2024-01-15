package javaCode;

class Parent {
    void display() {
        System.out.println("Parent");
    }
}

class A1 extends Parent {
    void display() {
        System.out.println("A1");
    }
}

class B1 extends Parent {
    void display() {
        System.out.println("B1");
    }
}
public class Overriding {
    public static void main(String[] args) {
        Parent p;
        p = new A1();
        p.display();


        p = new Parent();
        p.display();

        p = new B1();
        p.display();
    }
}
