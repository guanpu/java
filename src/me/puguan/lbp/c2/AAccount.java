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
public class AAccount {

    private double balance;

    /**
     * Get the value of balance
     *
     * @return the value of balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Set the value of balance
     *
     * @param balance new value of balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void addAmount(double amount) {
        double tmp = balance;
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tmp += amount;
        balance = tmp;
    }

    public synchronized void substractAmount(double amount) {
        double tmp = balance;
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tmp -= amount;
        balance = tmp;
    }
}
