package me.puguan.lbp.hackerank;

import java.util.Scanner;
import java.util.*;

/**
 *
 * @author pguan
 */
public class GridLand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();
        long k = sc.nextInt();
        Map<Long, Ranges> map = new HashMap<>();
        for (long i = 0; i < k; i++) {
            sc.nextLine();
            long line = sc.nextInt();
            long start = sc.nextInt();
            long end = sc.nextInt();
            if(map.containsKey(line)) {
                Ranges current = map.get(line);
                if(!current.hasMulti){
                    //left intersection or contain
                    if(start<current.x && end>current.x) {
                        current.x = start;
                        current.length = current.x - 1 + m - current.y;
                        if(current.length<=0) current.length = 0;
                    }
                    //right intersection or contain
                    if(end>current.y && start<current.y) {
                        current.y = end;
                        current.length = current.x - 1 + m - current.y;
                        if (current.length <= 0) {
                            current.length = 0;
                        }

                    }
                    //not intersection
                    if(start > current.y || end<current.x) {
                        current.length = m-1 - (current.y-current.x) - (end-start+1);
                    }
                }
            } else {
                map.put(line, new Ranges(start, end));
            }
        }
        long lines = map.size();
        long total = (n-lines)*m;
        long temp = 0;
        for (Map.Entry<Long, Ranges> entry : map.entrySet()) {
            Ranges value = entry.getValue();
            temp += value.length;            
        }
        total = total + temp;
        System.out.println(total);
    }
    static class Ranges {
        public long x;
        public long y;
        public boolean hasMulti = false;
        public long length;

        public Ranges(long x, long y) {
            this.x = x;
            this.y = y;
        }
        public Ranges() {
            
        }
    }
    
}
