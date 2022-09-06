package org.example.dynamic;

import org.example.utility.Utility;

/**
 * Problem: <a href="https://leetcode.com/problems/house-robber/">...</a>
 */

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        sums[1] = nums[1];
        sums[2] = nums[0] + nums[2];
        int i;
        for (i = 3; i < nums.length; i++) {
            sums[i] = Math.max(nums[i] + sums[i - 2], nums[i] + sums[i - 3]);
            Utility.printList(sums);
        }
        return Math.max(sums[nums.length - 1], sums[nums.length - 2]);
    }
}
