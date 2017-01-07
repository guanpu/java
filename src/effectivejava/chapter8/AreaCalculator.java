/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.chapter8;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pguan
 */
public class AreaCalculator {
    public static void main(String[] args){

        loop: while(true){
            Random rdm = new Random();
            int[] array = new int[10000];
            for(int i=0;i<10000;i++){
                array[i] = rdm.nextInt(10000);
            }
            System.out.println("Choose the strategy to calculate");
            System.out.println("******************************");
            System.out.println("1) Exchange Sort");
            System.out.println("2) Bubble Sort");
            System.out.println("3) fast Sort");
            System.out.println("5) quit");
            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder("The answer is ");
            long start;
            long end;
            switch (sc.nextInt()) {
                case 1:
                    start = System.nanoTime();
                    sb.append(Arrays.toString(exchange(array)));
                    end = System.nanoTime();
                    sb.append("\n");
                    sb.append("time used:" + (end-start));
                    break;
                case 2:
                    start = System.nanoTime();
                    sb.append(Arrays.toString(bubble(array)));
                    end = System.nanoTime();
                    sb.append("\n");
                    sb.append("time used:" + (end - start));
                    break;
                case 3:
                    start = System.nanoTime();
                    fast(array,0,array.length-1);
                    sb.append(Arrays.toString(array));
                    end = System.nanoTime();
                    sb.append("\n");
                    sb.append("time used:" + (end - start));
                    break;
                default:
                    break loop;
            }
            System.out.println(sb.toString());
        }
        
    }
    
    private static int[] exchange(int[] array) {
        for(int i =0,z=array.length;i<z-1;i++){
            for(int j=i+1;j<z;j++){
                if(array[j]>array[i]) {
                    int swap = array[j];
                    array[j]=array[i];
                    array[i]=swap;
                }
            }
        }
        return array;
    }
    private static int[] bubble(int[] a) {
        int temp = 0;
        for (int i = a.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (a[j + 1] > a[j]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }
    private static void fast(int[] a, int low, int high) {
        if(low>=high) return;
        int swap = a[low];
        int i = low;
        int j = high;
        while(i<j) {
            while(i<j && swap<=a[j]) {
                j--;
            }
            a[i] = a[j];
            while(i<j && swap>=a[i]) {
                i++;
            }
            a[j]=a[i];
        }
        a[i] = swap;
        fast(a, low,i-1);
        fast(a, i+1, high);
    }
}
