package test;

public class Hello {
    public String toString(){
        String info = null;

        for (int i = 0; i < 5; i++) {
            info = "Hello";
        }

        return info;
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        System.out.println(hello.toString());
    }
}
