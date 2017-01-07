/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c2;

/**
 *
 * @author pguan
 */
public class BCinema {

    public BCinema() {
        lock1 = new Object();
        lock2 = new Object();
        vacancy1 = 20L;
        vacancy2 = 20L;
    }

    public boolean sellScreen1(int num) {

        synchronized (lock1) {
            if (vacancy1 < num) {
                return false;
            }
            vacancy1 -= num;
            return true;
        }
    }

    public boolean sellScreen2(int num) {
        synchronized (lock2) {
            if (vacancy2 < num) {
                return false;
            }
            vacancy2 -= num;
            return true;
        }
    }

    private final Object lock1;

    private final Object lock2;

    private long vacancy1;

    /**
     * Get the value of vacancy1
     *
     * @return the value of vacancy1
     */
    public long getVacancy1() {
        return vacancy1;
    }

    /**
     * Set the value of vacancy1
     *
     * @param vacancy1 new value of vacancy1
     */
    public void setVacancy1(long vacancy1) {
        this.vacancy1 = vacancy1;
    }

    private long vacancy2;

    /**
     * Get the value of vacancy2
     *
     * @return the value of vacancy2
     */
    public long getVacancy2() {
        return vacancy2;
    }

    /**
     * Set the value of vacancy2
     *
     * @param vacancy2 new value of vacancy2
     */
    public void setVacancy2(long vacancy2) {
        this.vacancy2 = vacancy2;
    }

}
