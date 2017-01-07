/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp;

import java.util.Date;

/**
 *
 * @author pguan
 */
public class TaskRunner implements Runnable{

    public TaskRunner(InheritableThreadLocal startDate) {
        this.startDate = startDate;
    }
    
    private InheritableThreadLocal<Date> startDate;
    
    public Date getValue() {
        return startDate.get();
    }

    @Override
    public void run() {
        System.out.printf("Starting Thread : %s : %s\n", Thread.currentThread().getId(), startDate.get());
    }    
}
