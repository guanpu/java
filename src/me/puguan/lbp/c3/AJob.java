/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

/**
 *
 * @author pguan
 */
public class AJob implements Runnable{

    public AJob(APrintQueue ap) {
        this.ap = ap;
    }
    
    private APrintQueue ap;
    @Override
    public void run() {
        System.out.printf("%s Gonna print a object \n", Thread.currentThread().getName());
        ap.printJob(new Object());
        System.out.printf("%s Finished print \n", Thread.currentThread().getName());
    }
    
}
