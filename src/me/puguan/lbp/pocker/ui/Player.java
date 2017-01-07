/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.puguan.lbp.pocker.algorithm.Strategy;

/**
 * The player class.
 *
 * @author pguan
 */
public class Player extends Thread {

    private int bank = 100;
    public int rebuy_count = 1;
    private Strategy strategy;

    public Player() {
        System.out.println("new player created");
    }

    public int onNextCall() {
        return 0;
    }

    @Override
    public void run() {
        while (DILA.largest_bet.get() < 5) {
            synchronized (DILA.pot) {
                System.out.println(String.valueOf(Thread.currentThread().getId()) + "was running once");
                try {
                    DILA.pot.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
