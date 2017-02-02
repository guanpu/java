/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c3;

import java.util.concurrent.Phaser;

/**
 * Customized Phaser.
 */
public class GMyPhaser extends Phaser{

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                System.out.printf("%d has finished \n", phase);
                System.out.printf("There's %d parties left \n", registeredParties);
                return false;
            case 1:
                System.out.printf("%d has finished \n", phase);
                System.out.printf("There's %d parties left \n", registeredParties);
                return false;
            case 2:
                System.out.printf("%d has finished \n", phase);
                System.out.printf("There's %d parties left \n", registeredParties);
                return false;
            default:
                return true;
        }
    }
    
    
}
