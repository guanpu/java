/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

import java.util.concurrent.Phaser;

/**
 *
 * @author pguan
 */
public class FMain {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(3);
        Thread searchSystem = new Thread(new FileSearcherWorker("C:\\Windows", phaser),"system");
        Thread searchApp = new Thread(new FileSearcherWorker("C:\\Programe Files", phaser),"app");
        Thread searchPersonal = new Thread(new FileSearcherWorker("C:\\Document and Settings", phaser),"personal");
        searchApp.start();
        searchSystem.start();
        searchPersonal.start();
        searchApp.join();
        searchPersonal.join();
        searchSystem.join();
        if(phaser.isTerminated()) {
            System.out.println("Terminated");
        }
    }
    
}
