/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.chapter8;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pguan
 */
public class NumberGuesser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loop: while(true){
            Random rdm = new Random();
            int v = (rdm.nextInt()) % 100;
            System.out.println("I thinked out a number,try guess it");
            int guessed = sc.nextInt();
                for(int i=0;i<3;i++){
                    if(guessed>100){
                        break loop;
                    }
                    if (guessed > v) {
                        high();
                        guessed = sc.nextInt();
                        continue;
                    }
                    if (guessed < v) {
                        low();
                        guessed = sc.nextInt();
                        continue;
                    }
                    if(guessed==v){
                        System.out.println("Bingo");
                        break loop;
                    }
                }
                continue;
            }
    }
    
    public static void high() {
        System.out.println("It's high");
    }
    
    public static void low() {
        System.out.println("It's low");
    }

    
}
