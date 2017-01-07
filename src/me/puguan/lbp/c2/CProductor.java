/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguan
 */
public class CProductor implements Runnable{
    private CBuffer buffer;
    public CProductor(CBuffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {            
                buffer.set();
            } catch (InterruptedException ex) {
                Logger.getLogger(CProductor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
