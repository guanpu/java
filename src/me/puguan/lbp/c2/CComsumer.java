/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c2;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguan
 */
public class CComsumer implements Runnable{

    public CComsumer(CBuffer buffer) {
        this.buffer = buffer;
    }
    
    
    private CBuffer buffer;

    /**
     * Get the value of buffer
     *
     * @return the value of buffer
     */
    public CBuffer getBuffer() {
        return buffer;
    }

    /**
     * Set the value of buffer
     *
     * @param buffer new value of buffer
     */
    public void setBuffer(CBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Date dt;
            try {
                dt = buffer.get();
//                System.err.println(dt);
            } catch (InterruptedException ex) {
                Logger.getLogger(CComsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
