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
    public static void main(String[] args) {
        Deck deck = new Deck();
        Card[] cards = new Card[7];
//        cards[0] = new Card(Shape.HEARTS, Number.Two);
//        cards[1] = new Card(Shape.SPADES, Number.Eight);
//        cards[2] = new Card(Shape.CLUBS, Number.Seven);
//        cards[3] = new Card(Shape.HEARTS, Number.Five);
//        cards[4] = new Card(Shape.SPADES, Number.King);
//        cards[5] = new Card(Shape.DIAMANDS, Number.Six);
//        cards[6] = new Card(Shape.DIAMANDS, Number.King);
        int i = 0;
        while(i<7) {
            cards[i]= deck.next();
            i++;
        }
        
        Handful myHandful = pickHandful(cards);
        System.out.println(myHandful.getMark());
        Arrays.asList(cards).stream().forEach(card->System.out.print(card.toString()+","));
        System.out.println();
        Arrays.asList(myHandful.getCards()).stream().forEach(card -> System.out.print(card.toString() + ","));
    }
    
    /**
     * Choose the best five from seven cards.
     * @param cards
     * @return 
     */
    public static Handful pickHandful(Card[] cards) {
        List<Handful> list = new ArrayList<>();
        int i = 0;
        while(i<7) {
            int j = 0;
            while(j<i){
                List<Card> templist = new ArrayList<>();
                for(int index=0;index<7;index++) {
                    if(index==i || index==j) {
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














