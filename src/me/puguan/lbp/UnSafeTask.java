/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguan
 */
public class UnSafeTask implements Runnable{
    private Random random = new Random();
    
    private Date startDate;

    /**
     * Get the value of startDate
     *
     * @return the value of startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Set the value of startDate
     *
     * @param startDate new value of startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread : %s : %s\n", Thread.currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        } catch (InterruptedException ex) {
            Logger.getLogger(UnSafeTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("Thread Finished : %s : %s\n", Thread.currentThread().getId(), startDate);
    }
    
    public static void main(String[] args) {
        SafeTask task = new SafeTask(11);
        Thread thread = new Thread(task);
        thread.start();
                
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(task);
//            thread.start();
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            
//        }
    }
    
}
