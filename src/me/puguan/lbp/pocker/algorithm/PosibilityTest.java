/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.algorithm;

import me.puguan.lbp.pocker.model.Card;
import me.puguan.lbp.pocker.model.Deck;

/**
 * Test interested combination of pre-flop hand.
 *
 * @author pguan
 */
public class PosibilityTest implements Runnable{

    public PosibilityTest(String interested) {
        this.interested = interested;
    }

    /**
     * Sample size: the size of total possible combination.
     */
    private int total = 2_598_960;
    
    private String interested;

    public static void main(String[] args) {
        PosibilityTest pt = new PosibilityTest("pair");
        Thread thread1 = new Thread(pt);
        Thread thread2 = new Thread(new PosibilityTest("double10plus"));
        Thread thread3 = new Thread(new PosibilityTest("nonsense"));
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void testPair() {
        int count = 0;
        int i = 0;
        Deck deck = new Deck();
        while (i++ < total) {
            Card card1 = deck.next();
            Card card2 = deck.next();
            if (card1.getNumber().equals(card2.getNumber())) {
                count++;
            }
            deck.shuffle();
        }
        System.out.printf("The possibility of getting pair is %f \n",(1.0 * count) / total);
    }

    public void testAPlus() {
        int count = 0;
        int i = 0;
        Deck deck = new Deck();
        while (i++ < total) {
            Card card1 = deck.next();
            Card card2 = deck.next();
            if (card1.getNumber().getValue() == 13 || card2.getNumber().getValue() == 13) {
                count++;
            }
            deck.shuffle();
        }
        System.out.printf("The possibility of getting at least on Ace is %f \n", (1.0 * count) / total);
    }
    
    public void testDoubleTPlus() {
        int count = 0;
        int i = 0;
        Deck deck = new Deck();
        while (i++ < total) {
            Card card1 = deck.next();
            Card card2 = deck.next();
            if (card1.getNumber().getValue() >= 9 && card2.getNumber().getValue() >= 9) {
                count++;
            }
            deck.shuffle();
        }
        System.out.printf("The possibility of getting double 10 plus is %f \n", (1.0 * count) / total);        
    }

    @Override
    public void run() {
        switch(interested) {
            case "pair":
                testPair();
                break;
            case "double10plus":
                testDoubleTPlus();
                break;
            default:
                testAPlus();
        }
        
    }
}
