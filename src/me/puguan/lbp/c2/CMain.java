/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c2;

/**
 *
 * @author pguan
 */
public class CMain {
    public static void main(String[] args) {
        CBuffer buffer = new CBuffer();
        CProductor productor = new CProductor(buffer);
        CComsumer comsumer = new CComsumer(buffer);
        Thread thread1 = new Thread(productor);
        Thread thread2  = new Thread(comsumer);
        thread1.start();
        thread2.start();
    }
}
