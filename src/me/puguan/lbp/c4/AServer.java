/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c4;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author pguan
 */
public class AServer {
    private ThreadPoolExecutor executor;

    public AServer() {
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);
    }
    
    public void executeTask(ATask task) {
        System.out.printf("Adding a new Task %s at %s \n", task.getName(), new Date().toString());
        executor.execute(task);
        System.out.printf("Pool size %d \n", executor.getPoolSize());
        System.out.printf("Actually running size %d \n", executor.getActiveCount());
    }
    public void shutdown() {
        executor.shutdown();
    }
    public static void main(String[] args) {
        AServer server = new AServer();
        for (int i = 0; i < 100; i++) {
            ATask task = new ATask("name" + i);
            server.executeTask(task);            
        }
        server.shutdown();        
    }   
}
