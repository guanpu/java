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
public class BParticipant implements Runnable{
    private BConference bf;
    private String name;

    public BParticipant(BConference bf, String name) {
        this.bf = bf;
        this.name = name;
    }    

    @Override
    public void run() {
        try {
            long milis = (long)(Math.random() * 1000 + 1000);
            Thread.sleep(milis);
            bf.attend(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
