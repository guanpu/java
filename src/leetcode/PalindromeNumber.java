package leetcode;

/**
 * Note: Just check half digits is OK.
 * @author pguan
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        /**
         * Kick off several special case to start sanity case.
         * 1. negatives are not palindrome.
         * 2. Single digit numbers belong to palindrome.
         * 3. Those who ends with 0s can not be palindrome.
         */
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int result = 0;
        while (x >= 10 && result <= x) {
            if (result == x) {
                return true;
            }
            result = x % 10 + result * 10;
            if (result == x) {
                return true;
            }
            x = x / 10;
        }
        return result == x;
    }    
}
