/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.model;

import java.io.Serializable;

/**
 * The Card Object.
 * @author pguan
 */
public class Card implements Serializable, Comparable<Card>{
    /**
     * An Enum indicating the Shape of the card.
     */
    private final Shape shape;
    
    /**
     * An Number enum indicating the Number of the card.
     */
    private final Number number;
    
    /**
     * a integer ranged from 1-52 as the card's identity.
     */
    private final int id;

    public Card(Shape shape, Number number) {
        this.shape = shape;
        this.number = number;
        this.id = number.getValue() + 13 * shape.ordinal();
    }
    
    

    /**
     * Get the value of number
     *
     * @return the value of number
     */
    public Number getNumber() {
        return number;
    }

    /**
     * Get the value of shape
     *
     * @return the value of shape
     */
    public Shape getShape() {
        return shape;
    }

    @Override
    public int compareTo(Card o) {
        return this.number.compareTo(o.number);
    }
    
    public String toString() {
        return this.number.toString() + this.shape.toString();
    }
    
    public int getId() {
        return id;
    }
}
