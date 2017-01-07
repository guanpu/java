/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.chapter9;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.*;

/**
 *
 * @author pguan
 */
public class ConcurrentUtilTester {
    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger j = new AtomicInteger(0);
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(0);
        ScheduledFuture future = ses.scheduleAtFixedRate(()-> j.getAndIncrement(), 10, 1, TimeUnit.SECONDS);
        while(true) {
            if(j.get()>5) {
                future.cancel(true);
                Thread.sleep(1000);
                if(future.isCancelled() || future.isDone()) {
                    System.out.println(future.isCancelled());
                    System.out.println(future.isDone());
                }
                System.exit(0);
            }
            Thread.sleep(800);
        }
    }
}
