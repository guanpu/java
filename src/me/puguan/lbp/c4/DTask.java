/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c4;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * A simple task to be cancel
 * @author pguan
 */
public class DTask implements Callable<String>{

    @Override
    public String call() {
        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted by main");
        }
        return "FInished";
    }
    
}
