/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.chapter9;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguan
 */
public class MultiThreadTester {
    public static void main(String[] args) {
        for(int k = 0; k<1000; k++) {
            new Thread(()->{
                Counter.inc();
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MultiThreadTester.class.getName()).log(Level.SEVERE, null, ex);
        }

        //System.out.println(Counter.i.intValue());
        System.out.println(Counter.i);
        
    }
}
class Counter {

    //static AtomicInteger i = new AtomicInteger(0);
    static int i = 0;

    public static void inc() {
        try {
            //i.getAndIncrement();
            i++;
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
