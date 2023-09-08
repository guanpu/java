/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.chapter10;

/**
 * Prime number counter
 * @author pguan
 */
public class SingleThreadCounter {
    public long count(long from, long to){
        long toReturn = 0;
        from--;
        while(from<to){
            next: {
                from++;
                long threshold = (long) Math.round(from/2.0f);
                for(;threshold>1;threshold--) {
                    if(from%threshold==0) break next;
                }
                toReturn++;
            }
        }
        return toReturn;
    }
    public static void main(String[] args) {
        SingleThreadCounter s = new SingleThreadCounter();
        System.out.println(s.count(1,10000));
    }
}
