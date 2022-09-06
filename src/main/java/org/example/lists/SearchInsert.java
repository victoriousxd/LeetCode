package org.example.lists;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: <a href="https://leetcode.com/problems/search-insert-position/">...</a>
 */

public class SearchInsert {

    public static int searchInsert(int[] nums, int target, boolean verbose) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (verbose) {
                printWindow(left, right, left + (right - left) / 2, nums);
            }
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public static int sanityCheck(int[] nums, int target) {

        List<Integer> toList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        toList.add(target);
        List<Integer> why = toList.stream().distinct().sorted().toList();
        return why.indexOf(target);
    }

    public static void printWindow(int left, int right, int mid, int[] nums) {
        StringBuilder window = new StringBuilder();
        StringBuilder display = new StringBuilder();
        StringBuilder header = new StringBuilder();

        window.append("|");
        display.append("|");
        header.append("|");

        int i = 0;
        while (i < nums.length) {

            int counter = 0;
            if (i == left) {
                display.append(" L ");
                counter += 3;
            }
            if (i == right) {
                display.append(" R ");
                counter += 3;
            }
            if (i == mid) {
                display.append(" M ");
                counter += 3;
            }
            if (counter == 0) {
                display.append("   ");
                counter += 3;
            }

            display.append("|");
            counter -= 1;
            header.append(String.format("%1$" + counter + "s |", i));
            window.append(String.format("%1$" + counter + "s |", nums[i]));

            i++;
        }

        System.out.println(header);
        System.out.println(display);
        System.out.println(window);
        System.out.println();
    }
}