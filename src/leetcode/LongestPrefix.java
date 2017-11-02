package leetcode;

/**
 *
 * @author pguan
 */
public class LongestPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int minLen = strs[0].length();
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (str.length() < minLen) {
                index = i;
                minLen = str.length();
            }
        }

        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (j < minLen) {
            char p = strs[index].charAt(j);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].charAt(j) != p) return sb.toString();
            }
            sb.append(p);
            j++;
        }
        return sb.toString();
    }
}
