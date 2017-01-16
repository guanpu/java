/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguan
 */
public class BConference implements Runnable{
    private CountDownLatch latch;

    public BConference(int i) {
        latch = new CountDownLatch(i);
    }
    
    public void attend(String name) {
        System.out.printf("%s arrives \n", name);
        latch.countDown();
        System.out.printf("Still need to wait %d attendees \n", latch.getCount());
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(BConference.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Let's begin");
    }
}
