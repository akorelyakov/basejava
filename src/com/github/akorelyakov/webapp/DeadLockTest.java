package com.github.akorelyakov.webapp;

public class DeadLockTest {
    private final static String STRING1 = "STRING1";
    private final static String STRING2 = "STRING2";

    public static void main(String[] args) {

        Thread thread1 = new Thread() {
            public void run() {
                synchronized (STRING1) {
                    System.out.println("Output " + STRING1 + " from " + Thread.currentThread().getName() + " waiting " +
                            "for STRING2...");
                    Thread.yield();
                    synchronized (STRING2) {
                        System.out.println(STRING2 + " from " + Thread.currentThread().getName());
                    }
                }

            }
        };

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println();
                synchronized (STRING2) {
                    System.out.println("Output " + STRING2 + " from " + Thread.currentThread().getName() + " waiting " +
                            "for STRING1...");
                    Thread.yield();
                    synchronized (STRING1) {
                        System.out.println(STRING1 + " from " + Thread.currentThread().getName());
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}