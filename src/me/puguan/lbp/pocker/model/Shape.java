/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.model;

/**
 *
 * @author pguan
 */
public enum Shape {
    HEARTS("hearts"),
    SPADES("spades"),
    CLUBS("clubs"),
    DIAMANDS("diamands");
    private Shape(String name) {
        this.name = name;
    }
    
    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }    
    
    @Override
    public String toString() {
        return String.valueOf(name.charAt(0));
    }
}
