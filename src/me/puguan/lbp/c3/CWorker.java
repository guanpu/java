/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguan
 */
public class CWorker implements Runnable{
    private CyclicBarrier barrier;
    private int [] toBeCalculated;
    private AtomicInteger result;

    public CWorker(CyclicBarrier barrier,int [] toBeCalculated, AtomicInteger result) {
        this.barrier = barrier;
        this.toBeCalculated = toBeCalculated;
        this.result = result;
    }

    @Override
    public void run() {
        int temp = 0;
        try {
            long l = (new Random()).nextInt(2000);
            Thread.sleep(l);

            for (int i = 0; i < 10; i++) {
                temp += toBeCalculated[i];
            }
            result.getAndAdd(temp);
            System.out.printf("%s has arrives\n", Thread.currentThread().getName());
            barrier.await();

            Thread.sleep(1000L);
            System.out.printf("%s has finished\n", Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            Logger.getLogger(CWorker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(CWorker.class.getName()).log(Level.SEVERE, null, ex);
        }        
    } 
}
