/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import me.puguan.lbp.pocker.model.Card;
import me.puguan.lbp.pocker.model.Deck;
import me.puguan.lbp.pocker.model.Handful;

/**
 *
 * @author pguan
 */
public class Play {
    public Handful play() {
        List<Handful> players= new ArrayList<>();
        Deck deck = new Deck();
        Card[] cards = new Card[5];
        cards[0] = deck.next();
        cards[1] = deck.next();
        cards[2] = deck.next();
        cards[3] = deck.next();
        cards[4] = deck.next();

        //Arrays.asList(cards).stream().forEach(card -> System.out.print(card.toString() + ","));
        //System.out.println();

        int i = 0;
        Card[][] privateCards = new Card[6][2];
        while(i<6) {
            privateCards[i] = new Card[2];
            for (int j = 0; j < 2; j++) {
                privateCards[i][j] = deck.next();
                //System.out.print(privateCards[i][j].toString()+",");
            }
            //System.out.println();
            Handful myHandful = pickHandful(joinCards(cards, privateCards[i]));
            //Arrays.asList(myHandful.getCards()).stream().forEach(card -> System.out.print(card.toString() + ","));
            //System.out.println();
            players.add(myHandful);
            i++;
        }
        Handful max = players.stream().max(Handful::compareTo).get();
        return max;
    }
    
    private Card[] joinCards(Card[] pub, Card[] pri) {
        Card[] cards = new Card[7];
        for (int i = 0; i < 7; i++) {
            if(i<5) {
                cards[i] = pub[i];
            } else {
                cards[i] = pri[i-5];
            }
            
        }
        return cards;
    }
    /**
     * Choose the best five from seven cards.
     *
     * @param cards
     * @return
     */
    private Handful pickHandful(Card[] cards) {
        List<Handful> list = new ArrayList<>();
        int i = 0;
        while (i < 7) {
            int j = 0;
            while (j < i) {
                List<Card> templist = new ArrayList<>();
                for (int index = 0; index < 7; index++) {
                    if (index == i || index == j) {
                        continue;
                    }
                    templist.add(cards[index]);
                }
                list.add(new Handful(templist.toArray(new Card[5])));
                j++;
            }
            i++;
        }
        return Collections.max(list);
    } 
    
}














