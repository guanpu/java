/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * A deck of poker.
 *
 * @author pguan
 */
public final class Deck implements Iterator<Card> {

    private List<Card> cards = new ArrayList<Card>();

    private Iterator<Card> it;

    /**
     * In the beginning the poker is shuffled.
     */
    public Deck() {
        for (Shape s : Shape.values()) {
            for (Number n : Number.values()) {
                cards.add(new Card(s, n));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
        this.it = cards.iterator();
    }

    public static void main(String[] args) {
//
        Deck deck = new Deck();
        while (deck.hasNext()) {
            System.out.print(deck.next().getId() + ",");
        }
        deck.shuffle();
        System.out.println("shuffled");
        while (deck.hasNext()) {
            System.out.print(deck.next().getId() + ",");
        }
//        int i = 1;
//        int k = i<<33;
//        System.out.println(k);
//        
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Card next() {
        return it.next();
    }

}
