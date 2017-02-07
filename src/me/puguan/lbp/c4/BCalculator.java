/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c4;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author pguan
 */
public class BCalculator implements Callable<Integer> {

    private Integer number;

    public BCalculator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if (number == 0 || number == 1) {
            return result;
        } else {
            for (int i = 1; i < number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
            return result;
        }
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
