/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c2;

import java.util.Random;

/**
 *
 * @author pguan
 */
public class BTicketOffice implements Runnable{

    public BTicketOffice(BCinema cinema) {
        this.cinema = cinema;
    }
    
    private BCinema cinema;

    /**
     * Get the value of cinema
     *
     * @return the value of cinema
     */
    public BCinema getCinema() {
        return cinema;
    }

    /**
     * Set the value of cinema
     *
     * @param cinema new value of cinema
     */
    public void setCinema(BCinema cinema) {
        this.cinema = cinema;
    }


    @Override
    public void run() {
        int i = 0;
        int j = 0;
        Random random = new Random();
        while(i<10 || j<10) {
            if(random.nextBoolean()) {
                if(i>=10) continue;
                if(cinema.sellScreen1(1)) i++;
            } else {
                if (j>=10) {
                    continue;                       
                }
                if(cinema.sellScreen2(1)) j++;
            }
        }
    }
    
}
