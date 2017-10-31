package me.puguan.lbp.hackerank;

/**
 *
 * @author pguan
 */
interface PerformOperation {

    boolean check(int a);
}
public class NewClass{

public PerformOperation is_odd() {
     return (int n) -> n%2 == 1;
 }
public PerformOperation is_prime() {
    return (int n) -> {
        boolean result  = true;
        if( n<= 1) return false;
        if(n==2) return true;
        int mid = (int)Math.ceil(Math.sqrt(n*1.0));
        for(int i=2;i<mid;i++){
            result = result && n%i!=0;
            if (result==false) break;
        }
        return result;
    };
}
public PerformOperation is_palindrome() {
    return (int n) -> {
        String s = ((Integer) n).toString();
        boolean result = true;
        int k = s.length();
        for(int i=0;i<=k/2; i++){
            result = result && s.charAt(i)==s.charAt(k-1-i);
            if (result==false) break;
        }
        return result;
    };
}
}
