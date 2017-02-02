/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

import java.util.Random;

/**
 *
 * @author pguan
 */
public class GStudent implements Runnable{
    private Random random;
    
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


    public GStudent(GMyPhaser phaser, String name) {
        this.phaser = phaser;
        random = new Random();
        this.name = name;
    }

    private GMyPhaser phaser;

    /**
     * Get the value of phaser
     *
     * @return the value of phaser
     */
    public GMyPhaser getPhaser() {
        return phaser;
    }

    /**
     * Set the value of phaser
     *
     * @param phaser new value of phaser
     */
    public void setPhaser(GMyPhaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        arrive();
        phaser.arriveAndAwaitAdvance();
        test1();
        phaser.arriveAndAwaitAdvance();
        test2();
        phaser.arriveAndAwaitAdvance();
        finish();
        phaser.arriveAndAwaitAdvance();
        
    }
    
    private void arrive() {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (Exception e) {
        }
        System.out.printf("%s Arrives \n", getName());
    }
    
    private void test1() {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (Exception e) {
        }
        System.out.printf("Finished test1 %s \n", getName());
        
    }
    private void test2() {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (Exception e) {
        }
        System.out.printf("Finished test2 %s \n", getName());
    }
    private void finish() {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (Exception e) {
        }
        System.out.printf("Finished all %s \n", getName());
    }
    
    
}
