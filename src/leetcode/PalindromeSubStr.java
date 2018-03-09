package leetcode;

/**
 * Longest Palindromic Substring.
 *
 * @author pguan
 */
public class PalindromeSubStr {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String subString = "";
        int globalSize = 0;
        /**
         * Invariance: substring is among the longest palindrome substrings centered at or before index i.
         * when it's 'aba' type, i.e. odd palindrome substrings, center is obvious, hereby type1, single char is not in this scope.
         * When it's 'abba' type, i.e. even palindrome substring, center means the start at the first b, hereby type2
         */
        for (int i = 0; i < s.length(); i++) {
            //loop throught all type2.
            int high = i + 1;
            int low = i;
            while (high < s.length() && low >= 0 && s.charAt(high) == s.charAt(low)) {
                high++;
                low--;
            }
            if (high - low - 1 > globalSize) {
                globalSize = high - low - 1;
                subString = s.substring(++low, high);
            }
            
            //loop throught all type1, obviously type1 is at least 3 char long.
            if (i >= 1 && i < s.length() - 1) {
                int high1 = i + 1;
                int low1 = i - 1;
                while (high1 < s.length() && low1 >= 0 && s.charAt(high1) == s.charAt(low1)) {
                    high1++;
                    low1--;
                }
                if (high1 - low1 - 1 > globalSize) {
                    globalSize = high1 - low1 - 1;
                    subString = s.substring(++low1, high1);
                }
            }
            
            //check for early break.
            if (subString.equals(s)) {
                return s;
            }
        }
        return subString;
    }
    
    public static void main(String[] args) {
        PalindromeSubStr pss = new PalindromeSubStr();
        System.out.println(pss.longestPalindrome("aaaaaaaa"));
    }
    
}
