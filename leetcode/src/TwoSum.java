/**
 * Created by zhouti8 on 2/3/17.
 */

import java.util.*;
public class TwoSum {
    public static ArrayList twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap1 = new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++){
            hashmap1.put(nums[i],i);
        }
        ArrayList<Integer> results = new ArrayList();
        for (int i=0;i<nums.length;i++){
            int x=nums[i];
            int res = target-x;
            if(hashmap1.containsKey(res) && x!=res){
                // add to result list
                results.add(i);
                results.add(hashmap1.get(res));
                hashmap1.remove(x);
            }
        }
        return results;
    }
}
