package me.puguan.lbp.c4;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * A test implementation of RejectedExecutionHandler.
 * @author pguan
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("%s is rejected by %s \n", r.toString(), executor.toString());
    }
    
}
