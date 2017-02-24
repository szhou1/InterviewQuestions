package design_patterns;

public class Threads {

    public static void main(String [] args) {
        Thread t = new Thread(() -> {System.out.println("hihsidf"); });
        t.start();
    }
}
