package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Re-arrange string as a saw like, and print it.
 * Solution: Just loop through original string and construct a list of horizontal string.
 * @author pguan
 */
public class ZigZagPattern {
    public String convert(String s, int numRows) {
        List<StringBuilder> list =  new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());            
        }
        int j = 2 * (numRows - 1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int whichOne = Math.min(j - i % j, i % j);
            list.get(whichOne).append(c);            
        }
        StringBuilder total = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            total.append(list.get(i).toString());
        }
        return total.toString();        
    }
}
