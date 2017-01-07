/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.sort;

import me.puguan.lbp.sort.Sorter;

/**
 * A simple quick sorter.
 *
 * @author pguan
 */
public class QuickSorter implements Sorter {

    private int[] arr;

    @Override
    public int[] sort(int[] array) {
        quicksort(array, 0, array.length-1);
        return array;
    }

    private void quicksort(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        int swap;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap = arr[j];
                arr[j] = arr[i];
                arr[i] = swap;
                i++;
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap = arr[j];
                arr[j] = arr[i];
                arr[i] = swap;
                j--;
            }
        }
        if (i > low) {
            quicksort(arr, low, i - 1);
        }
        if (j < high) {
            quicksort(arr, j + 1, high);
        }

    }
}
