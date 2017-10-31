package me.puguan.lbp.hackerank;
import java.util.*;
import java.util.regex.*;
/**
 *
 * @author pguan
 */
public class Main {
    /*
 * Complete the function below.
    0 a t l s i n
     */

    static String convert(String input) {        
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, 0);
        }
        String[] s = input.split("L+");
        for (int i = 0; i < s.length; i++) {
            String string = s[i];
            Pattern pattern = Pattern.compile("M");
            Matcher matcher = pattern.matcher(string);
            int count = 0;
            while (matcher.find()) {
                count++;
            }
            map.put(count, map.get(count) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            sb.append(value);
        }
        return sb.toString();       
    }
    public static void main(String[] args) {
        int[] list = new int[5];
        list = new int[6];
        System.out.printf("%3.1f", 1234.56);
//        String s = convert("PMLPMMMLPMMMLLLPMLPLPLPL");
//        System.out.println(s);
    }
    
}
