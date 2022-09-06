package org.example.lists;

import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">...</a>
 */

public class SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        int index = 0;
        Stack<Integer> negatives = new Stack<>();

        while (index < nums.length && nums[index] < 0) {
            negatives.add(nums[index++] * -1);
        }


        for (int i = 0; i < nums.length; i++) {
            // compare to stack to see what should come first
            int newValue;

            if (index == nums.length || (!negatives.isEmpty() && negatives.peek() < nums[index])) {
                newValue = negatives.pop();
            } else {
                newValue = nums[index++];
            }
            nums[i] = newValue * newValue;
        }

        return nums;
    }


    public static int[] leetCodeSolution(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
}
