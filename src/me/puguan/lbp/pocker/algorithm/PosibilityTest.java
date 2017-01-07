/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.algorithm;

import me.puguan.lbp.pocker.model.Card;
import me.puguan.lbp.pocker.model.Deck;

/**
 *
 * @author pguan
 */
public class PosibilityTest {
    public static void main(String[] args) {
        testPair();
    }
    public static void testPair() {
        int total = 1_000_000;
        int count = 0;
        int i = 0;
        while(i++ < total) {
            Deck deck = new Deck();
            Card card1 = deck.next();
            Card card2 = deck.next();
            if(card1.getNumber().equals(card2.getNumber())) {
                count++;
            }
        }
        System.out.println((1.0 * count)/total);
    }
}
