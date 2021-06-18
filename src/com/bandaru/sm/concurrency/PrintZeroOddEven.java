package com.bandaru.sm.concurrency;

/**
 * Suppose you are given the following code:
 * <p>
 * class ZeroEvenOdd {
 * public ZeroEvenOdd(int n) { ... }      // constructor
 * public void zero(printNumber) { ... }  // only output 0's
 * public void even(printNumber) { ... }  // only output even numbers
 * public void odd(printNumber) { ... }   // only output odd numbers
 * }
 * <p>
 * The same instance of ZeroEvenOdd will be passed to three different threads:
 * <p>
 * Thread A will call zero() which should only output 0's.
 * Thread B will call even() which should only ouput even numbers.
 * Thread C will call odd() which should only output odd numbers.
 * <p>
 * Each of the threads is given a printNumber method to output an integer. Modify the given program to output the series 010203040506... where the length of the series must be 2n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: "0102"
 * Explanation: There are three threads being fired asynchronously. One of them calls zero(), the other calls even(), and the last one calls odd(). "0102" is the correct output.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: "0102030405"
 */
public class PrintZeroOddEven {

    private int n;

    static boolean not0;
    static int i;

    public PrintZeroOddEven(int n) {
        this.n = n;
        i = 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (i < n) {
                while (not0) {
                    wait();
                }
                printNumber.accept(0);
                not0 = true;
                if (i == 0)
                    i = 1;
                notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {

            while (i < n) {
                while (i == 0 || i % 2 != 0 || !not0) {
                    wait();
                }
                printNumber.accept(i);
                i++;
                not0 = false;
                notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (i == 1 || i < n) {
                while (i % 2 == 0 || !not0) {
                    wait();
                }
                printNumber.accept(i);
                i++;
                not0 = false;
                notifyAll();

            }
        }
    }
}
