/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author pguan
 */
public class APrintQueue {
    public APrintQueue() {
        semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
        printerLock = new ReentrantLock();
    }
    /**
     * Used to record the available status of each printer.
     */
    private boolean[] freePrinters;
    /**
     * Used to lock the modification of freePrinters.
     */
    private Lock printerLock;
    /**
     * Used to control the accessibility of printJob.
     */
    private Semaphore semaphore;
    
    public void printJob(Object obj) {
        try {
            semaphore.acquire();
            long duration = (long) (Math.random()*1000);
            int assignedPrinter = getPrinter();
            System.out.printf("%s is using the print of %d \n", Thread.currentThread().getName(), assignedPrinter);
            Thread.sleep(duration);
            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();            
        } finally {
            semaphore.release();
        }
    }
    private int getPrinter() {
        int result = -1;
        try {
            printerLock.lock();
            for (int i = 0; i < 3; i++) {
                if(freePrinters[i]) {
                    result = i;
                    freePrinters[i] = false;
                    break;
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printerLock.unlock();
        }
        return result;
    }
}
