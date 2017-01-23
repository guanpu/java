/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author pguan
 */
public class FileSearcherWorker implements Runnable{
    private static final String SUFFIX = "log";

    public FileSearcherWorker(String initPath, Phaser phaser) {
        this.initPath = initPath;
        this.phaser = phaser;
        this.finalResults = new ArrayList<>();
        this.results = new ArrayList<>();
    }
    
    private String initPath;

    /**
     * Get the value of initPath
     *
     * @return the value of initPath
     */
    public String getInitPath() {
        return initPath;
    }

    /**
     * Set the value of initPath
     *
     * @param initPath new value of initPath
     */
    public void setInitPath(String initPath) {
        this.initPath = initPath;
    }
    
    private List<File> finalResults;

    /**
     * Get the value of finalResults
     *
     * @return the value of finalResults
     */
    public List<File> getFinalResults() {
        return finalResults;
    }

    /**
     * Set the value of finalResults
     *
     * @param finalResults new value of finalResults
     */
    public void setFinalResults(List<File> finalResults) {
        this.finalResults = finalResults;
    }

    
    private List<String> results;

    /**
     * Get the value of results
     *
     * @return the value of results
     */
    public List<String> getResults() {
        return results;
    }

    /**
     * Set the value of results
     *
     * @param results new value of results
     */
    public void setResults(List<String> results) {
        this.results = results;
    }

    
    private Phaser phaser;

    /**
     * Set the value of phaser
     *
     * @param phaser new value of phaser
     */
    public void setPhaser(Phaser phaser) {
        this.phaser = phaser;
    }
    
    private void processDirectory(File file) {
        File[] files = file.listFiles();
        if(files==null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            File file1 = files[i];
            if (file1.isDirectory()) {
                processDirectory(file1);
            } else {
                processFile(file1);
            }
        }
    }
    
    private void processFile(File file) {
        if(file.getName().endsWith(SUFFIX)) {
            results.add(file.getAbsolutePath());
        }
    }
    private void filterResult() {
        long currentMili = new Date().getTime();
        for (Iterator<String> iterator = results.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            File file = new File(next);
            long modifyDate = file.lastModified();
            if(currentMili-modifyDate<TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)){
                finalResults.add(file);
            }            
        }
    }
    
    private void showInfo() {
        for (Iterator<File> iterator = finalResults.iterator(); iterator.hasNext();) {
            File next = iterator.next();
            System.out.println(next.getAbsolutePath());            
        }
        System.out.printf("%s ends \n", Thread.currentThread().getName());
        phaser.arrive();
    }
    
    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();
        File file = new File(initPath);
        if(file.isDirectory()) {
            processDirectory(file);
        }
        if(results.isEmpty()) {
            phaser.arriveAndDeregister();
            System.out.printf("%s terminated in step %d", Thread.currentThread().getName(), phaser.getPhase());
            return;
        } else {
            phaser.arriveAndAwaitAdvance();  
        }
        filterResult();
        if(finalResults.isEmpty()) {
            phaser.arriveAndDeregister();
            System.out.printf("%s terminated in step %d", Thread.currentThread().getName(), phaser.getPhase());
            return;
        }else {
            phaser.arriveAndAwaitAdvance();
        }
        showInfo();       
    }
    
}
