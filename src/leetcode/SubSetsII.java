package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author pguan
 */
public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Set<Set<Integer>>> map = new HashMap<>();
        //Loop through the element size of each set
        map.put(0, new HashSet<Set<Integer>>());
        for (int i = 1; i < nums.length; i++) {
            Set<Set<Integer>> numberedSet = new HashSet<>();
            //loop through element which can be added 

                Set<Set<Integer>> lastSet = map.get(i - 1);
                if(null!=lastSet && !lastSet.isEmpty()){
                    for (Iterator<Set<Integer>> iterator = lastSet.iterator(); iterator.hasNext();) {
                        for (int j = 0; j < nums.length; j++) {
                            //loop through i-1 sets
                            Set<Integer> list = new TreeSet<Integer>();
                            Integer newAdded = j;
                            Set<Integer> next = (Set<Integer>) iterator.next();
                            list.addAll(next);
                            list.add(newAdded);
                            numberedSet.add(list);
                        }
                    }             
                }

            map.put(i, numberedSet);
        }
        List<List<Integer>> finaList = new ArrayList<>();
        for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {
            Set<Set<Integer>> next = (Set<Set<Integer>>) iterator.next();
            for (Iterator<Set<Integer>> iterator1 = next.iterator(); iterator1.hasNext();) {
                Set<Integer> next1 = iterator1.next();
                List<Integer> list = new ArrayList<>();
                for (Iterator<Integer> iterator2 = next1.iterator(); iterator2.hasNext();) {
                    Integer next2 = iterator2.next();
                    list.add(nums[next2]);
                }
                finaList.add(list);
            }
        }
        return finaList;
    }    
    public static void main(String[] args) {
        SubSetsII ssii = new SubSetsII();
        List<List<Integer>>  list = ssii.subsetsWithDup(new int[]{1,2,2});
        System.out.println(list.size());
    }
}
