package me.puguan.lbp.c4;

import java.util.Date;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author pguan
 */
public class FMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        /**
         * The completionservice is actually adding a completion queue feature above executor.
         * it provides another constructor which one can specify the queue by himself.
         */
        CompletionService cs = new ExecutorCompletionService(es);
        FReportRequest faceReq = new FReportRequest("Face", cs);
        FReportRequest onlineReq = new FReportRequest("online", cs);
        FReportProcessor processor = new FReportProcessor(cs);
        Thread th1 = new Thread(faceReq);
        Thread th2 = new Thread(onlineReq);
        Thread th3 = new Thread(processor);
        System.out.printf("Main: Starting at %d", new Date().getTime());
        th1.start();
        th2.start();
        th3.start();
        try {
            th1.join();
            th2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Main: others to end");
        es.shutdown();

        try {
            es.awaitTermination(1, TimeUnit.DAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        processor.setEnd(true);
        System.out.println("Main: ends");
        
    }
    
}
