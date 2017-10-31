package leetcode;

/**
 * Problem: Reverse digits of an integer.
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * Note: the key point is to consider 0.
 * @author pguan
 */
public class ReverseInteger {
    public int reverse(int x) {
        long result = 0;
        while (x >= 10 || x <= -10) {
            result = result * 10 + (x % 10);
            x = x / 10;
        }
        result = result * 10 + x;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        } else {
            return new Long(result).intValue();
        }
    }
}
