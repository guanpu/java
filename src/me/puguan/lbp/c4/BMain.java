/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Play with ThreadPoolExecutor.
 * @author pguan
 */
public class BMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<Integer>> list = new ArrayList<>();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            BCalculator bc = new BCalculator(random.nextInt(10));
            System.out.printf("value is %d \n", bc.getNumber());
            Future result = executor.submit(bc);
            list.add(result);
        }
        while (executor.getCompletedTaskCount() < 10) {
            for (Iterator<Future<Integer>> iterator = list.iterator(); iterator.hasNext();) {
                Future<Integer> next = iterator.next();
                if (next.isDone()) {
                    System.out.printf("result is %d \n", next.get());
                    iterator.remove();
                }
            }
        }
        executor.shutdown();
    }

}
