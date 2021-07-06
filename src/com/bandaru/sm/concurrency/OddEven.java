package com.bandaru.sm.concurrency;

public class OddEven {
    private boolean isEven;
    private int counter;
    private int n;

    public OddEven(int n) {
        this.n = n;
        counter = 1;
    }

    private synchronized void printOdd() {
        while (counter < n) {
            while (isEven) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + counter++);
            isEven = true;
            notify();
        }
    }

    private synchronized void printEven() {
        while (counter < n) {
            while (!isEven) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + counter++);
            isEven = false;
            notify();
        }
    }

    public static void main(String[] args) {
        OddEven mt = new OddEven(100);
        Thread t3 = new Thread(mt::printOdd, "Odd");
        Thread t5 = new Thread(mt::printEven, "Even");
        t3.start();
        t5.start();
    }
}


