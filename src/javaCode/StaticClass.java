package javaCode;

public class StaticClass {
    int h = 78;
    static int p = 90;

    {
        int b = 30;
        System.out.println("Instance");
        h = 90;
    }

    static {
        int a = 10;
        System.out.println("static");
        //h = 90;
    }

    StaticClass() {
        System.out.println("Cons");
    }

    static class inner {
        void get() {
            System.out.println(p);
            //System.out.println(h);
        }

        static void get1() {
            System.out.println(p);
            //System.out.println(h);
        }
    }

    public static void main(String[] args) {
        StaticClass staticClass = new StaticClass();
    }
}
