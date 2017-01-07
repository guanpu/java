/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguan
 */
public class ProductTask implements Runnable{
    

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProductTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
