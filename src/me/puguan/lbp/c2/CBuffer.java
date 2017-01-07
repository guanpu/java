/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c2;

import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author pguan
 */
public class CBuffer {

    private LinkedList<Date> buffer = new LinkedList<>();
    private long base = System.currentTimeMillis();
    /**
     * Get the value of buffer
     *
     * @return the value of buffer
     */
    public LinkedList getBuffer() {
        return buffer;
    }

    /**
     * Set the value of buffer
     *
     * @param buffer new value of buffer
     */
    public void setBuffer(LinkedList buffer) {
        this.buffer = buffer;
    }

    private int maxSize = 5;

    /**
     * Get the value of maxSize
     *
     * @return the value of maxSize
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Set the value of maxSize
     *
     * @param maxSize new value of maxSize
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public Date get() throws InterruptedException {
        System.out.printf("\nGET: start method %d", System.currentTimeMillis() - base);
        Date date;
        synchronized (this) {
            System.out.printf("\nGET: start sync block %d", System.currentTimeMillis() - base);
            while (buffer.isEmpty()) {
                wait();
                System.out.printf("\nGET: finish wait %d", System.currentTimeMillis() - base);
            }
            date = buffer.poll();
            notify();
            System.out.printf("\nGET: finish notify %d", System.currentTimeMillis() - base);
            Random random = new Random();
            for (int i = 0; i < 9000000; i++) {
                if (random.nextBoolean()) {
                    i--;
                }
            }
            System.out.printf("\nGET: out from sync %d", System.currentTimeMillis() - base);
        }
        return date;
    }

    public void set() throws InterruptedException {
        System.out.printf("\nSET: start method %d", System.currentTimeMillis()-base);
        synchronized (this) {
            System.out.printf("\nSET: start sync block %d", System.currentTimeMillis()-base);
            while (buffer.size() == maxSize) {
                wait();
                System.out.printf("\nSET: finish wait %d", System.currentTimeMillis() - base);
            }
            buffer.offer(new Date());
            notify();
            System.out.printf("\nSET: finish notify %d", System.currentTimeMillis() - base);

        }

    }

}
