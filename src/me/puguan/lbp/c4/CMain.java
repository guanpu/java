/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Play with ShceduledThreadPoolExecutor.
 * @author pguan
 */
public class CMain {

    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);
        Runnable task = new ATask("my love");
        executor.scheduleWithFixedDelay(task, 0, 500L, TimeUnit.MILLISECONDS);
        executor.setContinueExistingPeriodicTasksAfterShutdownPolicy(true);
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
