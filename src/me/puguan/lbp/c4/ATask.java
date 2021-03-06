/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c4;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguan
 */
public class ATask implements Runnable{

    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    public ATask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("Thread %d started at %d \n", Thread.currentThread().getId(), new Date().getTime());
        long interval = 2000L;
        try {
            TimeUnit.MILLISECONDS.sleep(interval);
        } catch (InterruptedException ex) {
            Logger.getLogger(ATask.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("Thread %d ends at %d \n", Thread.currentThread().getId(), new Date().getTime());
        
    }
    
}
