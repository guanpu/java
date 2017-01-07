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
public class BMain {
    public static void main(String[] args) throws InterruptedException {
        BCinema cinema = new BCinema();
        BTicketOffice office1 = new BTicketOffice(cinema);
        BTicketOffice office2 = new BTicketOffice(cinema);
        Thread t1 = new Thread(office1);
        Thread t2 = new Thread(office2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.printf("Screem1 has left %d tickets \n", cinema.getVacancy1());
        System.out.printf("Screem2 has left %d tickets", cinema.getVacancy2());
    }
}
