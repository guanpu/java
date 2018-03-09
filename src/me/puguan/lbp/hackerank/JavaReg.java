package me.puguan.lbp.hackerank;

import java.util.Scanner;

/**
 *
 * @author pguan
 */
public class JavaReg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            //Java Formatter:  %[argument_index$][flags][width][.precision]conversion
            System.out.printf("%1$-15.15s%2$03d\n", s1, x);
        }
        System.out.println("================================");
    }
}
class MyRegex {
    protected String pattern = "^(([0-1]\\d{2}|2[0-4]\\d|25[0-5]|\\d{1,2})\\.){3}([0-1]\\d{2}|2[0-4]\\d|25[0-5]|\\d{1,2})$";
//    protected String pattern = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}"; 
}