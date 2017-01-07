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
public class ACompany implements Runnable{
    public AAccount account;

    public ACompany(AAccount account) {
        this.account = account;
    }
    

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.substractAmount(1000);            
        }
    }
    
}
