package leetcode;

/**
 * Reverse words in given String.
 * @author pguan
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String input = s.trim();
        StringBuilder sb = new StringBuilder();
        String[] components = input.split("\\s+");
        for (int i = components.length-1; i >= 0 ; i--) {
            String component = components[i];
            sb.append(component);
            sb.append(" ");
        }
        return sb.toString().trim();
    }    
}
