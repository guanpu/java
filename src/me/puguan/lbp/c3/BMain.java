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
public class BMain {
    public static void main(String[] args) {
        BConference bConference = new BConference(10);
        BParticipant[] bps = new BParticipant[10];
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            bps[i] = new BParticipant(bConference, "User"+i);            
            threads[i] = new Thread(bps[i]);
            threads[i].start();
        }
        Thread thread = new Thread(bConference);
        thread.start();        
    }    
}
