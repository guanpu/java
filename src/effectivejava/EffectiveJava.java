/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava;

import effectivejava.chapter10.SingleThreadCounter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguan
 */
public class EffectiveJava {
    public static void main(String[] args){
        List<Callable<Long>> cablist = new ArrayList<>();
        for(int i = 0;i<10;i++){
            cablist.add(new MyCallable(i));
        }
        ExecutorService svc = Executors.newFixedThreadPool(10);
        try {
            List<Future<Long>> futures = svc.invokeAll(cablist);
            Long total = futures.stream().mapToLong(f->{
                Long l = 0l;
                try {
                    l = f.get();
                } catch (InterruptedException ex) {
                    Logger.getLogger(EffectiveJava.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    Logger.getLogger(EffectiveJava.class.getName()).log(Level.SEVERE, null, ex);
                }
                return l;
            }).sum();
            System.out.println(total);
            svc.shutdown();
        } catch (InterruptedException ex) {
            Logger.getLogger(EffectiveJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
class MyCallable implements Callable<Long> {
    private final Long from;
    private final Long to;
    private final SingleThreadCounter stc;
    MyCallable(final long i) {
        this.from = i* 1000 + 1;
        this.to = (i+1)*1000;
        this.stc = new SingleThreadCounter();
    }
    @Override
    public Long call() {
        return stc.count(from, to);
    }
;
}
