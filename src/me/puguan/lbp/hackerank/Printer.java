package me.puguan.lbp.hackerank;

import java.util.Scanner;

/**
 *
 * @author pguan
 */
public class Printer {
    public void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int j = scanner.nextInt();
            System.out.println(j);
        }
        String jj = scanner.nextLine();
        System.out.println(jj);
        String kk = scanner.nextLine();
        System.out.println(kk);
    }
}
