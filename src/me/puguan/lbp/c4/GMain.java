package me.puguan.lbp.c4;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Main class of RejectedExecutionHandler experiment.
 * @author pguan
 */
public class GMain {
    
    public static void main(String[] args) {
        MyRejectedExecutionHandler handler = new MyRejectedExecutionHandler();
        ThreadPoolExecutor ee = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        ee.setRejectedExecutionHandler(handler);
        for(int i=0;i<3;i++) {
            ATask at = new ATask("name "+i);
            ee.submit(at);
        }
        ee.shutdown();
        ee.submit(new ATask("TObe rejected"));
        System.out.println("Main: End");
    }   
    
}
