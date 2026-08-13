// RunnableMethod.java
// Multithreading using Runnable interface implementation

class GoodMorning implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Good Morning");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // Thread interrupted safely
        }
    }
}

class Hello implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Hello");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            // Thread interrupted safely
        }
    }
}

class Welcome implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Welcome");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            // Thread interrupted safely
        }
    }
}

public class RunnableMethod {
    public static void main(String[] args) {
        GoodMorning goodMorning = new GoodMorning();
        Hello hello = new Hello();
        Welcome welcome = new Welcome();

        Thread t1 = new Thread(goodMorning);
        Thread t2 = new Thread(hello);
        Thread t3 = new Thread(welcome);

        t1.start();
        t2.start();
        t3.start();
    }
}
