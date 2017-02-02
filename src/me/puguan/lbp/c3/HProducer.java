/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguan
 */
public class HProducer implements Runnable{

    public HProducer(Exchanger<List<String>> exchanger) {
        this.buffer = new ArrayList<String>();
        this.exchanger = exchanger;
    }
    
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("Producer Circle %d \n", i);
            for (int j = 0; j < 10; j++) {
                String temp = "Message " + (i*10 + j);
                buffer.add(temp);
            }
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException ex) {
                Logger.getLogger(HProducer.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.printf("Buffer Size %d \n",buffer.size());
        }
    }
    
}
