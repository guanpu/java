package leetcode;

import java.util.HashMap;

/**
 * Find the indexes, if exist, of the two numbers in an given array whose sum equals to the target.
 * @author pguan
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>  hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (hashMap.containsKey(num)) {
                return new int[]{hashMap.get(num), i};
            }
            hashMap.put(nums[i],i);            
        }
        return null;
    }
    
}
