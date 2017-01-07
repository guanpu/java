/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.chapter8;

/**
 *
 * @author pguan
 */
public class Item45 {
    private String s3;
    Item45(){
        this.s3 = "java";//So we have a str-literal pool
    }
    
    public static void main(String[] args){
        Item45 item = new Item45();
        item.test();
    }
    private void test(){
        String s1 = new String("jdk"); //a common str variable
        System.out.println(s1.intern());
        String s2 = s1.intern();// find a variable with value equal to s1 and reference exists in pool;
        if(s3 == s2){
            System.out.println("3 and 2 share");
        }
        if(s3 == s1){
            System.out.println("1 and 3 share");
        }
        if (s1 == s2) {
            System.out.println("1 and 2 share");
        }
    }
}
