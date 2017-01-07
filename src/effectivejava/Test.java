/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author pguan
 */
public class Test {
    
    class NamedObject {
        public String name;
        NamedObject(int i) {
            this.name = "Name is"+i;
        }
    }
    public NamedObject ref;
    public void run() {
        List<NamedObject> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.ref = new NamedObject(i);
            list.add(ref);
        }
        System.out.println(listToString(list,','));
    }
    public static void main(String[] args) {
        Test test=  new Test();
        test.run();
    }
    public String listToString(List<NamedObject> list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).name).append(separator);
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
