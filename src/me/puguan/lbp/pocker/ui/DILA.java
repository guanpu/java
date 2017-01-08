/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.ui;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import me.puguan.lbp.pocker.model.Deck;
import me.puguan.lbp.pocker.model.Round;

/**
 *
 * @author pguan
 */
public class DILA extends Thread {

    private Deck deck = new Deck();
    private List<Player> players = new LinkedList<>();
    public static AtomicInteger largest_bet = new AtomicInteger(2);
    public static Integer pot;

    public DILA(Player... ps) {
        this.pot = 1;
        Collections.addAll(players, ps);
    }

    public static void main(String[] args) {
        DILA dila = new DILA(new Player(), new Player());
        dila.start();
    }

    @Override
    public void run() {
        // waiting for all players join in.
        for (int i = 0, size = players.size(); i < size; i++) {
            players.get(i).start();
        }
        //Start the game.

        handoutPreflop();
        NotifiyPlayers(Round.PREFLOOP);
        handoutFlop();
        NotifiyPlayers(Round.FLOP);
        handoutTurn();
        NotifiyPlayers(Round.TURN);
        handoutRiver();
        NotifiyPlayers(Round.RIVER);
        endRound();

        System.out.println("Main thread is gone");

    }

    private void handoutPreflop() {

    }

    private void NotifiyPlayers(Round round) {
        synchronized (pot) {
            pot.notifyAll();
//            pot.notifyAll();
//            pot.notify();
        }
    }

    private void handoutFlop() {
        largest_bet.getAndIncrement();
    }

    private void handoutTurn() {
        largest_bet.getAndIncrement();
    }

    private void handoutRiver() {
        largest_bet.getAndIncrement();
    }

    private void endRound() {
        largest_bet.getAndIncrement();
    }
}
