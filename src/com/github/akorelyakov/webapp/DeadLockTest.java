package com.github.akorelyakov.webapp;

public class DeadLockTest {
    private final static String STRING1 = "STRING1";
    private final static String STRING2 = "STRING2";

    public static void main(String[] args) {

        Thread thread1 = new Thread() {
            public void run() {
                printStringsFromThreads(STRING1, STRING2);
            }
        };

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printStringsFromThreads(STRING2, STRING1);
            }
        });

        thread1.start();
        thread2.start();
    }

    private static void printStringsFromThreads(String string1, String string2) {
        synchronized (string1) {
            System.out.println("Output " + string1 + " from " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (string2) {
                System.out.println("Now output " + string2 + " from " + Thread.currentThread().getName());
            }
        }
    }
}