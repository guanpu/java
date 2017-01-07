/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author pguan
 */
public class SortSchemeTester {

    private Sorter sorter;
    private MergeSorter mergeSorter;
    private QuickSorter quickSorter;
    private BubbleSorter bubbleSorter;
            
    public SortSchemeTester() {
        this.mergeSorter = new MergeSorter();
        this.quickSorter = new QuickSorter();
        this.bubbleSorter = new BubbleSorter();
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }
    
    public void setSorterViaName (String name) {
        switch(name) {
            case "bubble":
                setSorter(this.bubbleSorter);
                break;
            case "quick":
                setSorter(this.quickSorter);
                break;
            case "merge":
                setSorter(this.mergeSorter);
                break;
            default:
                setSorter(this.bubbleSorter);
        }
    }

    public void action(int[] array) {
        int result[] = this.sorter.sort(array);
        System.out.println("Resultsn");
        System.out.println(Arrays.toString(result));
        System.out.println("end");
    }

    public static void main(String[] args) {
//        test();
        SortSchemeTester tester = new SortSchemeTester();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int[] array = new int[10];
        System.out.println("Enter:");
        while (i < 10) {
           array[i] = sc.nextInt();
           i++;
        }
        System.out.println("choose scheme:");
        String scheme = sc.next();
        tester.setSorterViaName(scheme);
        tester.action(array);
    }
    public static void test() {
        int[] arr = new int[] {9,1,2,11,10};
        Arrays.binarySearch(arr, 0);
        int[] target = new int[5];
        System.arraycopy(arr, 1, target, 0, 2);
        System.arraycopy(arr, 3, target, 3, 2);
        target[2] = arr[0];
        System.out.println(Arrays.toString(target));
    }
}
