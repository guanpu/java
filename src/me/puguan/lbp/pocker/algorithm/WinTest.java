/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import me.puguan.lbp.pocker.model.Combination;
import me.puguan.lbp.pocker.model.Handful;
import me.puguan.lbp.pocker.ui.Play;

/**
 *
 * @author XiaoPu
 */
public class WinTest {
    public static void main(String[] args) {
        int sampleSize = 1_000_000;
        Map<Combination, Long> map = new HashMap<>();
        List<Handful> winners = new ArrayList<>();
        
        for (int i = 0; i < sampleSize; i++) {
            Play play = new Play();
            winners.add(play.play());
        }
        map = winners.stream().collect(Collectors.groupingBy(Handful::getTitle, Collectors.counting()));
        for(Entry<Combination,Long> e: map.entrySet()) {
            System.out.printf("The number of Winner of type %s is %d, with ratio %f \n", e.getKey().toString(), e.getValue(), (e.getValue()*1.0)/sampleSize);
        }
    }
    
}
/**
 * Some useful results:
 * The number of Winner of type flush is 104992, with ratio 0.104992 
 * The number of Winner of type three is 87026, with ratio 0.087026 
 * The number of Winner of type straight_flush is 5384, with ratio 0.005384
 * The number of Winner of type two_pair is 284812, with ratio 0.284812 
 * The number of Winner of type four is 8831, with ratio 0.008831
 * The number of Winner of type pair is 119636, with ratio 0.119636 
 * The number of Winner of type straight is 280178, with ratio 0.280178 
 * The number of Winner of type fullhouse is 108778, with ratio 0.108778
 * The number of Winner of type other is 363, with ratio 0.000363
 */
