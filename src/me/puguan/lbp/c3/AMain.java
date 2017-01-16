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
public class AMain {
    public static void main(String[] args) {
        APrintQueue ap = new APrintQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            AJob aj = new AJob(ap);
            threads[i] = new Thread(aj);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();            
        }
    }    
}
