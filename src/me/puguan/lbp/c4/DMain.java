/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c4;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Play with Future.cancel().
 * @author pguan
 */
public class DMain {
    public static void main(String[] args) {
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        DTask task = new DTask();
        Future<String> future = tpe.submit(task);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(future.cancel(true)) {
            System.out.println("successfully canceled");
        }else {
            System.out.println("Not cancelled because of some reason");
        }
        tpe.shutdown();
    }
    
}
