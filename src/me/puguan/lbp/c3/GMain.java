/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

/**
 *
 * @author pguan
 */
public class GMain {
    public static void main(String[] args) {
        GMyPhaser myPhaser = new GMyPhaser();
        GStudent[] students = new GStudent[5];
        for (int i = 0; i < 5; i++) {
            students[i] = new GStudent(myPhaser, "Student " + i);
            myPhaser.register();            
        }
        Thread[] threads = new Thread[5];
        for (int i=0;i<5;i++){
            threads[i]=new Thread(students[i], students[i].getName());
            threads[i].start();
        }
    }
    
}
