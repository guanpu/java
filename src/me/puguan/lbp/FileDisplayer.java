/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import javax.swing.JFileChooser;

/**
 *
 * @author pguan
 */
public class FileDisplayer {

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        JFileChooser jfc = new JFileChooser();
//        jfc.setCurrentDirectory(new File("."));
//        int returnVal = jfc.showOpenDialog(null);
//        String filename = null;
//        if(returnVal==JFileChooser.APPROVE_OPTION) {
//            filename = jfc.getSelectedFile().getPath();
//        }
//        FileReader fr = new FileReader(filename);
//        char[] cbuf = new char[3];
//        while (fr.read(cbuf)== 3) {
//            System.out.print(cbuf[2]);
//        }
////        fizzbuzz();
        int ary = howManyAgentsToAdd(1, new int[][]{{3, 11},{585858,33},{987,11}});
//        for (int i = 0; i < ary.length; i++) {
//            int j = ary[i];
//            System.out.println(j);
//            
//        }
    }
    public static void fizzbuzz() {
        for(int i=1;i<100;i++) {
            boolean oridinary = true;
            if(i%3==0) {
                System.out.print("Fizz");
                oridinary = false;
            }
            if(i%5==0) {
                System.out.print("Buzz");
                oridinary = false;
            }
            if(oridinary) {
                System.out.print(i);
            }
            System.out.println();           
        }
    }
    static int[] oddNumbers(int l, int r) {
        int len = 1+ (r - l) >> 1;
        if (l % 2 == 1 && r % 2 == 1) {
            len++;
        }
        System.out.printf("Lenth is: %d", len);
        int[] result = new int[len];
        Arrays.setAll(result, i -> { return l%2==1? l+2*i: l+1+2*i;});
        return result;
    }
    static int[] delta_encode(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int newlen = array.length<<1;
        int[] result = new int[newlen];
        int j = 0;
        result[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            int del = array[i] - array[i-1];
            if(del<-127||del>127){
                j++;
                result[j] =  -128;
            }
                j++;
                result[j] = del;
            
        }
        return Arrays.copyOf(result, j+1);
    }
    
    /*
     * Complete the function below.
     */
    static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
        int max = 0;
        int localMax = 0;
        Arrays.sort(callsTimes, (int[] item1, int[] item2) ->{return item1[0]-item2[0];});
        for (int cursor = 0; cursor < callsTimes.length; cursor++) {
            int[] callsTime = callsTimes[cursor];
            int lasttime = callsTime[1];
            for (int i = cursor+1; i < callsTimes.length; i++) {
                if(callsTimes[i][0]>lasttime){
                    break;
                }else{
                    localMax++;
                }
            }    
            if (localMax >= max) {
                max = localMax;
            }
        }
        
        return max-noOfCurrentAgents >=0 ? max-noOfCurrentAgents: 0;
        
    }
}
