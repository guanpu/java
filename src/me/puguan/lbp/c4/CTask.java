/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c4;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author pguan
 */
public class CTask implements Callable<String>{
    
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

    public CTask(String name) {
        this.name = name;
    }


    @Override
    public String call() throws Exception {
        System.out.printf("%d is running \n", Thread.currentThread().getId());
        TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 5000 + 2000L));
        return name;
    }
    
    
}
