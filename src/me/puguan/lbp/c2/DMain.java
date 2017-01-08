/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c2;

/**
 *
 * @author XiaoPu
 */
public class DMain {
    public static void main(String[] args) {
        DBuffer buffer = new DBuffer();
        Thread p = new Thread(new DProducer(buffer));
        for (int i = 0; i < 3; i++) {
            Thread c = new Thread(new DConsumer(buffer));
            c.start();
        }
        p.start();
    }
    
}
