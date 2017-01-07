/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.sort;

import java.util.Arrays;

/**
 * This class implements the Sorter interface with a sort scheme of 'merge
 * sort'.
 *
 * @author pguan
 */
public class MergeSorter implements Sorter {

    @Override
    public int[] sort(int[] array) {
        return mergesort(array);
    }

    private int[] merge(int[] input1, int[] input2) {
        if(input1.length==0) return input2;
        if(input2.length==0) return input1;
        int[] tmpArray = new int[input1.length+input2.length];
        if(input1[0]<=input2[0]) {
            int[] tmp = merge(Arrays.copyOfRange(input1, 1, input1.length), input2);
            System.arraycopy(tmp, 0, tmpArray, 1, tmp.length);
            tmpArray[0] = input1[0];
        }else {
            int[] tmp = merge(Arrays.copyOfRange(input2, 1, input2.length), input1);
            System.arraycopy(tmp, 0, tmpArray, 1, tmp.length); 
            tmpArray[0] = input2[0];
        }
        return tmpArray;
    }

    private int[] mergesort(int[] input) {
        int middle = input.length / 2;
        if(middle == 0) {
            return input;
        }else {
            return merge(mergesort(Arrays.copyOfRange(input, 0, middle)), mergesort(Arrays.copyOfRange(input, middle, input.length)));
        }
    }

}
