package com.learnjava;

public class DeadLock {
   public static void main(String[] args) {

        final String resource1 = "Chicken";
        final String resource2 = "Egg";

        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked " + resource1 );

                try { Thread.sleep(100);} catch (Exception ignored) {}

                synchronized (resource2) {
                    System.out.println("Thread 1: locked" + resource1);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: locked " + resource2);

                try { Thread.sleep(100);} catch (Exception ignored) {}

                synchronized (resource1) {
                    System.out.println("Thread 2: locked " + resource2);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
