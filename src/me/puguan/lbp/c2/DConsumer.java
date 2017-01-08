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
public class DConsumer implements Runnable{

    private DBuffer buffer;

    /**
     * Get the value of buffer
     *
     * @return the value of buffer
     */
    public DBuffer getBuffer() {
        return buffer;
    }

    /**
     * Set the value of buffer
     *
     * @param buffer new value of buffer
     */
    public void setBuffer(DBuffer buffer) {
        this.buffer = buffer;
    }

    public DConsumer(DBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(buffer.get());
        }
    }
    
}
