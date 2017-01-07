/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.algorithm;

import me.puguan.lbp.pocker.model.Handful;

/**
 *
 * @author pguan
 */
public interface Strategy {
    public abstract int actPreFlop(Handful handful);
    public abstract int actFlop(Handful handful);
    public abstract int actTurn(Handful handful);
    public abstract int actRiver(Handful handful);    
}
