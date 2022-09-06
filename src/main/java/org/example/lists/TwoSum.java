package org.example.lists;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> matches = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            if (matches.containsKey(nums[i])){
                return new int[]{matches.get(nums[i]),i};
            }
            int pair = target - nums[i];
            matches.put(pair, i);
        }
        return new int[]{};
    }
}
