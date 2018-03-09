package leetcode;

/**
 *
 * @author pguan
 */
public class DivideTwoInt {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        boolean isNegative = dividend < 0 ^ divisor < 0;

        long result = td(Math.abs((long)dividend), Math.abs((long)divisor))[0];
        
        long toReturn = isNegative ? -result : result;
        if(toReturn>Integer.MAX_VALUE||toReturn<Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return ((Long)toReturn).intValue();
        }
    }

    private long[] td(long x, long y) {
        long[] result = new long[2];
        if (x == 0) {
            return result;
        }
        result = td(x >>> 1, y);
        result[0] = result[0] << 1;
        result[1] = result[1] << 1;
        if ((x & 1) == 1) {
            result[1] += 1;
        }
        if (result[1] >= y) {
            result[1] -= y;
            result[0] += 1;
        }
        return result;
    }    
    public static void main(String[] args) {
        DivideTwoInt dti = new DivideTwoInt();
        System.out.println(dti.divide(1,Integer.MIN_VALUE));
    }
}
