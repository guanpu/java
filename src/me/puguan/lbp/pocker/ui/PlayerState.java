/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.ui;

/**
 *
 * @author pguan
 */
public enum PlayerState {
    PENDING(0),//Watching but no power to join
    READY(1), //Ready to next round
    INGAME(2), // In Game, resbonsible for next bet or handout
    CHECK(3), // In Game
    ALLIN(4), // In Game, resbonsible for next handout
    RERAISE(5),// The currently highest.
    END(6); // Left the table
    private int state;
    private PlayerState(int i) {
        this.state = i;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
    
}
