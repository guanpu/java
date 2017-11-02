package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Note: The Rome2Int Rule: I * V * X * L * C * D * M * Arabic numerals 1 5
 * 10 50 100 500 1000 See
 * http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm
 *
 * @author pguan
 */
public class Int2Rome {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(1, "I");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(10, "X");
        map.put(400, "CD");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(100, "C");
        map.put(1000, "M");
        int[] digits = getDigits(num);
        int cursor = 100;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<digits[0];i++) {
            sb.append("M");
        }
        
        for(int i =1;i<4;i++) {
            if(digits[i]==1 || digits[i] == 9 ||digits[i] == 4 ||digits[i] == 5 ) {
                sb.append(map.get(digits[i]*cursor));
            } else if(digits[i]>1 && digits[i] <4){
                for (int k = 0; k < digits[i]; k++) {
                    sb.append(map.get(cursor));
                }
            } else if(digits[i]>5 && digits[i]<9) {
                sb.append(map.get(5*cursor));
                for (int k = 0; k < digits[i]-5; k++) {
                    sb.append(map.get(cursor));
                }
            }
            cursor = cursor/10;
        }
        return sb.toString();
    }
    
    private int [] getDigits(int num) {
        if(num>9999) return null;
        int i = 4;
        int[] j = new int[i];
        j[--i] = num % 10;
        while(num/10 != 0) {
            num = num/10;
            j[--i] = num % 10;
        }
        return j;
    }
    public static void main(String[] args) {
        int sss = 1;
//        Matcher matcher = Pattern.compile("I+(?<!X|V)").matcher(sss);
//        matcher.find();
//        System.out.println(matcher.group());
        Int2Rome r2i = new Int2Rome();
        System.out.println(r2i.intToRoman(sss));
    }
}
