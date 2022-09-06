package org.example.lists;

/**
 * Problem: https://leetcode.com/problems/binary-search/
 */

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        int window = (end - begin) + 1;
        int mid = -1;
        while (window > 0) {
            mid = end - (window / 2);

            int found = nums[mid];

            if (found == target) {
                return mid;
            } else if (found < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }

            window = end - begin;
        }
        return nums[mid - 1] == target ? mid - 1 : -1;
    }
}