/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguan
 */
public class CMain {

    private CyclicBarrier barrier;
    
    private static class Merger implements Runnable {
        private AtomicInteger[] ints;

        public Merger(AtomicInteger ints[]) {
            this.ints = ints;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException ex) {
                Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(Thread.currentThread().getName()+ " merge running");
            int result = 0;
            for (int i = 0; i < 3; i++) {
                result += ints[i].get();                
            }
            System.out.println(result);
        }
    }
    public static void main(String[] args) {
        AtomicInteger[] ints = new AtomicInteger[3];
        int[][] data =  new int[3][10];
        for (int i = 0; i < 3; i++) {
            ints[i] = new AtomicInteger(0);
            for (int j = 0; j < 10; j++) {
                data[i][j] = j;                
            }
        }
        CyclicBarrier barrier = new CyclicBarrier(3, new Merger(ints));
        String[] names = new String[]{"Vincy", "Michel", "David"};
        for (int i = 0; i < 3; i++) {
            CWorker worker = new CWorker(barrier, data[i], ints[i]);
            Thread t = new Thread(worker,names[i]);
            t.start();
        }
    }
}
