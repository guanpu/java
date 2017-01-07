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
public class AFirstMain {
    public static void main(String[] args) throws InterruptedException {
        AAccount account = new AAccount();
        account.setBalance(1000);
        Thread bankThread = new Thread(new ABank(account));
        Thread comThread = new Thread(new ACompany(account));
        comThread.start();
        bankThread.start();
        bankThread.join();
        comThread.join();
        System.out.println(account.getBalance());
        
    }
    
}
