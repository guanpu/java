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
public class SafeTask implements Runnable {
    private int i;

    public SafeTask(int i) {
        this.i = i;
    }
    
    private Random random = new Random();

    private InheritableThreadLocal<Date> startDate = new InheritableThreadLocal<Date>(){
        @Override
        protected Date childValue(Date pv) {
            return new Date(pv.getTime()-3600000L);
            
        }
    };
    
    @Override
    public void run() {
        System.out.printf("Starting Thread : %s : %s\n", Thread.currentThread().getId(), startDate.get());
        startDate.set(new Date());
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        } catch (InterruptedException ex) {
            Logger.getLogger(UnSafeTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("Thread Finished : %s : %s\n", Thread.currentThread().getId(), startDate.get());
        TaskRunner tr = new TaskRunner(startDate);
        System.out.println(tr.getValue().toString());
        Thread thread = new Thread(tr);
        thread.start();
        System.out.println(tr.getValue().toString());
    }

}
