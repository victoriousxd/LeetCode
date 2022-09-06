package org.example.lists;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.lists.SearchInsert.sanityCheck;
import static org.example.lists.SearchInsert.searchInsert;

public class SearchInsertTest {


    @Test
    public void testEmptyList() {
        testSuite(new int[]{}, List.of(7));

    }

    @Test
    public void testListWith4Elements() {
        int[] nums = new int[]{1, 3, 5, 6};
        List<Integer> targets = IntStream.rangeClosed(0, 7).boxed().collect(Collectors.toList());
        testSuite(nums, targets);

    }

    @Test
    public void testListWithOneElement() {
        int[] nums = new int[]{1};
        List<Integer> targets = IntStream.rangeClosed(0, 2).boxed().collect(Collectors.toList());
        testSuite(nums, targets);
    }


    @Test
    public void testListWithTwoElements() {
        List<Integer> targets = IntStream.rangeClosed(0, 3).boxed().collect(Collectors.toList());

        testSuite(new int[]{1, 2}, targets);
        testSuite(new int[]{1, 3}, targets);
        testSuite(new int[]{2, 3}, targets);

    }

    private void testSuite(int[] nums, List<Integer> targets) {
        boolean passed = true;
        int pass = 0;
        int fail = 0;
        for (int i : targets) {

            int answer = sanityCheck(nums, i);
            int actual = searchInsert(nums, i, true);

            if (answer != actual) {
                StringBuilder numsString = new StringBuilder().append("[");
                Arrays.stream(nums).boxed().forEach(n -> numsString.append(n).append(", "));
                numsString.delete(numsString.length() - 2, numsString.length() - 1);
                numsString.append("]");
                String message = String.format("%s - failed target %d, expected %d, actual %d", numsString, i, actual, answer);
                searchInsert(nums, i, true);
                System.out.println(message);
                passed = false;
                fail++;
            } else {
                pass++;
            }
        }
        System.out.println("Pass: " + pass + " Fail: " + fail);
        Assertions.assertTrue(passed);
    }

}