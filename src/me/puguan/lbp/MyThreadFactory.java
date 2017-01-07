/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 *
 * @author pguan
 */
public class MyThreadFactory implements ThreadFactory {

    public MyThreadFactory(String basename) {
        this.basename = basename;
        this.counter = 0;
        this.stats = new ArrayList<>();
    }

    private String basename;

    /**
     * Get the value of basename
     *
     * @return the value of basename
     */
    public String getBasename() {
        return basename;
    }

    /**
     * Set the value of basename
     *
     * @param basename new value of basename
     */
    public void setBasename(String basename) {
        this.basename = basename;
    }

    private List<String> stats;

    public String getStats() {
        StringBuilder builder = new StringBuilder();
        Iterator<String> it =  stats.iterator();
        while(it.hasNext()) {
            builder.append(it.next());
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, basename+"-Thread_"+counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s \n", t.getId(), t.getName(), new Date()));
        return t;
    }

    private int counter;

    /**
     * Get the value of counter
     *
     * @return the value of counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Set the value of counter
     *
     * @param counter new value of counter
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("pguan");
        ProductTask task = new ProductTask();
        Thread thread;
        System.out.println("Strating threads");
        for(int i =0 ; i<10; i++){
            thread = factory.newThread(task);
            thread.start();
        }
        System.out.printf("Factory stats: \n");
        System.out.printf("%s \n ", factory.getStats());
    }

}
