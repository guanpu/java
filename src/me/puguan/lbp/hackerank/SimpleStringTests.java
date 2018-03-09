package me.puguan.lbp.hackerank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pguan
 */
public class SimpleStringTests {
    public static void main(String[] args) {
        String b = "abc";
        String[] lst = " ".split(" ");
        if(lst==null){
            System.out.println("yes");
        }
        //empty str won't match so return the empty str itself, all str match instead return zero length array.
        System.out.println(lst.length);
        for (int i = 0; i < lst.length; i++) {
            String get = lst[i];
            System.out.println(get);
        }
//        String b = "Abc";
//        char k = 'B';
//        System.err.println(b.codePointAt(0)+b.codePointAt(1));
        
    }
}
