package me.puguan.lbp.c4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Playing with FutureTask, it showed that FutureTask should be regards as a Task with integrated
 * FutureHandler, instead of being a Future that can execute additional tasks.
 * so the FutureTask is controlling the task of it self via its future interface. No need to being specified in the submit's return value.
 * @author pguan
 */
public class EMain {
    
    private ThreadPoolExecutor executor;

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    public void testAsRunnable() throws InterruptedException, ExecutionException {
        MyFutureTask[] tasks  =new MyFutureTask[5];
        for (int i = 0; i < 5; i++) {
            Task exTask = new Task("Task "+i);
            tasks[i] = new MyFutureTask(exTask);
            executor.submit(tasks[i]);
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
        }
        for (int i = 0; i < tasks.length; i++) {
            tasks[i].cancel(true);            
        }
        for (int i = 0; i < tasks.length; i++) {
            if(!tasks[i].isCancelled()){
                System.out.println(tasks[i].get());
            }
        }
        executor.shutdown();      
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        EMain main = new EMain();
        main.setExecutor((ThreadPoolExecutor) Executors.newCachedThreadPool());
        main.testAsRunnable();
    }
    
    class MyFutureTask extends FutureTask<String> {
        
        private String name;

        /**
         * Get the value of name
         *
         * @return the value of name
         */
        public String getName() {
            return name;
        }

        /**
         * Set the value of name
         *
         * @param name new value of name
         */
        public void setName(String name) {
            this.name = name;
        }

        public MyFutureTask(Callable<String> callable) {
            super(callable);
            this.name = ((Task)callable).getName();
        }

        @Override
        protected void done() {
            if(isCancelled()) {
                System.out.println("Is running canceled" + name);
            } else {
                System.out.println("Is running done" + name);
            }
        }

        /**
         * Fail to call super.set would regard the callable being canceled
         * @param v 
         */
        @Override
        protected void set(String v) {
            super.set(v);
            System.out.println("************setting ********" + v);
        }
        
    }
    
    class Task implements Callable<String> {
        
        private String name;

        /**
         * Get the value of name
         *
         * @return the value of name
         */
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Task(String name) {
            this.name = name;
        }
        

        @Override
        public String call() throws Exception {
            Long l = (long) Math.ceil(Math.random() * 10L);
            try {
                TimeUnit.SECONDS.sleep(l);
            } catch (InterruptedException ex) {
            }
            return "Hello World, I'm "+name;
        }        
    }
}
