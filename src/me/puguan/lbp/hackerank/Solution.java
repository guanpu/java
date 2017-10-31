package me.puguan.lbp.hackerank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import static java.lang.System.in;
import java.util.regex.*;

/**
 * 5
 * 12 0 1 78 12 
 * 2 
 * Insert
 * 5 23 
 * Delete
 * 0
 * @author pguan
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = Integer.parseInt(sc.nextLine());
//        StringBuffer resultBuffer = new StringBuffer();
        for (int i = 0; i < total; i++) {
            int test = Integer.parseInt(sc.nextLine());
            if (test % 7 <=1) {
                System.out.println("Second");
            } else {
                System.out.println("First");
            }
            
        }
//        System.out.println(resultBuffer.toString().trim());
    }
}
