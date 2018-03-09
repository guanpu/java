package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: Find the longest substring without repeating char.
 * Node: 
 * 1. we only need to return the length instead of the substring.
 * 2. How to determine repeat is error/bug generating.
 * 
 * @author pguan
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        char[] total = s.toCharArray();
        int size = s.length();
//        Set<Character> set = new HashSet(Arrays.asList(s.toCharArray()));
//        int posible_max = set.size();
        int local_max = 1;
        /**
         * Invariance: local_max is no less than max length of non-repeating-substring starting at i.
         */
        for (int i = 0; i < total.length; i++) {
            char[] chars = Arrays.copyOfRange(total, i, i+local_max);
            Set<Character> set = new HashSet();
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                set.add(aChar);
            }
            if(set.size()<local_max) {
                continue;
            }
            int j = i+local_max;
            //Invariance: set is increasing
            while(j<size) {
                set.add(total[j]);
                if(local_max==set.size()) {
                    break;
                } else {
                    j++;
                    local_max = set.size();
                }
            }
            
        }
        return local_max;
    }
    
    public static void main(String[] args) {
        LongestSubstring lss = new LongestSubstring();
        System.out.println(lss.lengthOfLongestSubstring("aab"));
    }    
}
