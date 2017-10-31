package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Note: The Rome2Int Rule: I * V * X * L * C * D * M * Arabic numerals 1 5 10 50 100 500 1000
 * See http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm
 * @author pguan
 */
public class Rome2Int {
    public int romanToInt(String s) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(5, "(?!I)V");
        map.put(1, "I+(?<!X|V)");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(50, "(?!X)L");
        map.put(10, "(?!I)X+(?<!L|C)");
        map.put(400, "CD");
        map.put(900, "CM");
        map.put(500, "(?!C)D");
        map.put(100, "(?!X)C+(?<!M|D)");
        map.put(1000, "(?!C)M+");

        int result = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            Matcher matcher = Pattern.compile(value).matcher(s);
            if (matcher.find()) {
                if (key == 1 || key == 10 || key == 100 || key == 1000) {
                    result += matcher.group().length() * key;
                } else {
                    result += key;
                }
                s = s.replaceFirst(matcher.group(), "");
            }
            if (s.isEmpty()) {
                break;
            }
        }

        return result;
    }   
    public static void main(String[] args) {
        String sss = "LXXV";
//        Matcher matcher = Pattern.compile("I+(?<!X|V)").matcher(sss);
//        matcher.find();
//        System.out.println(matcher.group());
        Rome2Int r2i = new Rome2Int();
        System.out.println(r2i.romanToInt(sss));
    }
}
