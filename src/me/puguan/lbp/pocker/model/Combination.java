/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.model;

/**
 * The combination of a handful.
 *
 * @author XiaoPu
 */
public enum Combination {
    PAIR("pair"),
    THREE("three"),
    Four("four"),
    FULLHOUSE("fullhouse"),
    STRIGHT("straight"),
    FLUSH("flush"),
    SF("straight_flush"),
    TWOPAIR("two_pair"),
    OTHER("other");
    private String name;

    private Combination(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
