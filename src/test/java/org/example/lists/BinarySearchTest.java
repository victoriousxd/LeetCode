package org.example.lists;

import org.example.utility.Utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    public void test1() {
        int[] testcase1 = new int[]{-1, 0, 3, 5, 9, 12};
        handleTestCase(testcase1, 9, 4);
    }

    @Test
    public void test2() {
        int[] testcase1 = new int[]{-1, 0, 3, 5, 9, 12};
        handleTestCase(testcase1, 11, -1);
    }

    @Test
    public void test3() {
        int[] testcase1 = new int[]{-1, 0, 3, 5, 9, 12, 13, 15, 16, 19, 24};
        handleTestCase(testcase1, 24, 10);
    }

    @Test
    public void test4() {
        int[] testcase1 = new int[]{-1, 0, 5};
        handleTestCase(testcase1, -1, 0);
    }

    private void handleTestCase(int[] searchMe, int target, int answer) {
        int result = BinarySearch.search(searchMe, target);

        System.out.println(Utility.intArrayToString(searchMe) + " -> " + result);
        Assertions.assertEquals(answer, result);
    }

}
