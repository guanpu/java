/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.model;

/**
 * Enum the number of a card.
 * @author pguan
 */
public enum Number implements Comparable<Number>{
    Two(0x1),
    Three(0x2),
    Four(0x3),
    Five(0x4),
    Six(0x5),
    Seven(0x6),
    Eight(0x7),
    Nine(0x8),
    Ten(0x9),
    Jack(0xa),
    Queen(0xb),
    King(0xc),
    ACE(0xd);

    private Number(int value) {
        this.value = value;
    }
    /**
     * The value of this number, ranging from 1-13.
     */
    private int value;

    /**
     * Get the value of value
     *
     * @return the value of value
     */
    public int getValue() {
        return value;
    }

    /**
     * Set the value of value
     *
     * @param value new value of value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * The 'name' of the card.
     * @return 
     */
    @Override
    public String toString() {
        if(value<9){
            return String.valueOf(value + 1);
        } else if(value == 10) {
            return "T";
        } else if(value == 11) {
            return "J";
        } else if(value == 12) {
            return "Q";
        } else if(value == 13) {
            return "K";
        } else {
            return "A";
        }
    }
    
}
