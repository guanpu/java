/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 *
 * @author pguan
 */
public class HConsumer implements Runnable{
    private Exchanger<List<String>> exchanger;
    private List<String> list;

    public HConsumer(Exchanger<List<String>> exchanger) {
        this.exchanger = exchanger;
        this.list = new ArrayList<String>();
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("Consumer Circle %d \n", i);
            try {
                list = exchanger.exchange(list);
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int j = 0; j < 10; j++) {
                System.out.println(list.get(0));
                list.remove(0);
            }
        }
    }
    
    
}
