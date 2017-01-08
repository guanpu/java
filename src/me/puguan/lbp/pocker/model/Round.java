/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.model;

/**
 * Enum indicating the phase of a round.
 * @author pguan
 */
public enum Round {
    PREFLOOP(0),
    FLOP(1),
    TURN(2),
    RIVER(3);
    
    private Round(int i) {
       this.type = i;
    }
    
    private int type;

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public int getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(int type) {
        this.type = type;
    }

}
