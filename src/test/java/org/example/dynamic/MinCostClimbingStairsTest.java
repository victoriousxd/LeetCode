package org.example.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinCostClimbingStairsTest {

    @Test
    public void MinCostClimbingStairsTest(){
        int[] steps =new int[]{1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        Assertions.assertEquals(
                6,
                minCostClimbingStairs.naiveMinCostClimbingStairs(steps));
    }

    @Test
    public void MinCostClimbingStairsTest2(){
        int[] steps =new int[]{10,15,20};
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        Assertions.assertEquals(
                15,
                minCostClimbingStairs.naiveMinCostClimbingStairs(steps));
    }

    @Test
    public void MinCostClimbingStairsTest3(){
        int[] steps =new int[]{2,1};
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        Assertions.assertEquals(
                1,
                minCostClimbingStairs.naiveMinCostClimbingStairs(steps));
    }


}
