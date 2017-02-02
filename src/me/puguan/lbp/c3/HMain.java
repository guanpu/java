/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 *
 * @author pguan
 */
public class HMain {
    public static void main(String[] args) {
        Exchanger<List<String>> exchanger = new Exchanger();
        HProducer producer = new HProducer(exchanger);
        HConsumer consumer = new HConsumer(exchanger);
        Thread thread1  =new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}
