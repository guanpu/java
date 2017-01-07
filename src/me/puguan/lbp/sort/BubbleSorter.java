/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.sort;

/**
 *
 * @author pguan
 */
public class BubbleSorter implements Sorter {

    @Override
    public int[] sort(int[] array) {
        int swp;
        int z = array.length;
        while (z-- > 0) {
            for (int i = 0; i < z; i++) {
                if (array[i] > array[i + 1]) {
                    swp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swp;
                }
            }
        }
        return array;
    }
}
