package javaCode;

interface A {
    default void display() {
        System.out.println("A");
    }
}

interface B {
    default void display() {
        System.out.println("B");
    }
}

public class Diamond implements A, B {

    public void display() {
        System.out.println("Diamond");
        A.super.display();
        B.super.display();
    }

    public static void main(String[] args) {
        Diamond diamond = new Diamond();
        diamond.display();
    }
}
