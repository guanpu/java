package me.puguan.lbp.hackerank;

import java.util.*;
/**
 *
 * @author pguan
 */
public class Practice1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int maxCount = 0;
        int currentMax = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (!deque.contains(num)) {
                maxCount++;
            }
            deque.addLast(num);
            if (i >= m) {
                int num2 =(int) deque.removeFirst();
                if (!deque.contains(num2)) {
                    maxCount--;
                }
            }
            if (maxCount > currentMax) {
                currentMax = maxCount;
                if (currentMax == m) {
                    break;
                }
            }
        }
        System.out.println(currentMax);
    }
}
