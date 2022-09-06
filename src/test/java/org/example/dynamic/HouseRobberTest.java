package org.example.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HouseRobberTest {

    @Test
    public void robTest1() {
        int[] nums = new int[]{1, 2, 3, 1};
        HouseRobber houseRobber = new HouseRobber();
        Assertions.assertEquals(4, houseRobber.rob(nums));
    }

    @Test
    public void robTest2() {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        HouseRobber houseRobber = new HouseRobber();
        Assertions.assertEquals(12, houseRobber.rob(nums));
    }
}
