package org.example.lists;

import org.example.utility.Utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SortedSquaresTest {

    public static List<Integer> generateList(int size) {
        Random rand = new Random(); //instance of random class
        int lowerbound = -25;
        int upperbound = 25;
        //generate random values from 0-24
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {

            list.add(rand.nextInt(lowerbound, upperbound) * (rand.nextBoolean() ? 1 : -1));

        }
        if (rand.nextBoolean()) list.add(0);
        return list.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> sanityCheck(List<Integer> original) {
        return original.stream().map(x -> x * x).sorted().collect(Collectors.toList());
    }


    @Test
    public void testSuite() {
        boolean passed = true;
        int pass = 0;
        int fail = 0;

        for (int i = 0; i < 10; i++) {
            List<Integer> list = generateList(i);

            int[] answer = Utility.integerListToArray(sanityCheck(list));
            int[] actual = SortedSquares.sortedSquares(Utility.integerListToArray(list));
            int[] leetcode = SortedSquares.leetCodeSolution(Utility.integerListToArray(list));
            System.out.println("Original" + list + "\tAnswer: " + Utility.intArrayToString(answer)
                    + "\n\tActual: " + Utility.intArrayToString(actual)
                    + "\n\t LeetCode: " + Utility.intArrayToString(leetcode));

            if (Arrays.equals(answer, actual)) {
                pass++;
            } else {

                System.out.println();
                passed = false;
                fail++;
            }
        }

        System.out.println("Pass: " + pass + " Fail: " + fail);
        Assertions.assertTrue(passed);

    }

    @Test
    public void testSuiteLeetCode() {

        int[] actual = SortedSquares.leetCodeSolution(new int[]{-8, -6, 0, 5, 6, 12, 18, 22});
        System.out.println(Utility.intArrayToString(actual));

    }
}
