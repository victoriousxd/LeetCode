package org.example.lists;

import org.example.utility.Utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTest {
    @Test
    public void testTwoSumTest(){
        int[] steps = new int[]{-100,105};
        int[] answer = new int[]{0,1};
        TwoSum twoSum = new TwoSum();

        int[] result = twoSum.twoSum(steps,5);
        Utility.printList(result);

    }
}