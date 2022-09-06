package org.example.dynamic;

/**
 * Problem: <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">...</a>
 */

public class MinCostClimbingStairs {

    int[] count;

    public int naiveMinCostClimbingStairs(int[] cost) {
        count = new int[cost.length];
        return dynamicMinCostClimbingStairs(cost);

    }

    public int dynamicMinCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] opt = new int[cost.length];
        opt[0] = cost[0];
        opt[1] = cost[1];
        int i = 1;
        while (++i < cost.length) {
            if (opt[i - 1] < opt[i - 2]) {
                opt[i] = opt[i - 1] + cost[i];
            } else {
                opt[i] = opt[i - 2] + cost[i];
            }
        }
        return Math.min(opt[cost.length - 1], opt[cost.length - 2]);
    }

    public int naiveMinCostClimbingStairs(int[] cost, int index, int currentCost) {
        count[index]++;
        if (index == cost.length - 1) {
            return currentCost;
        } else if (index >= cost.length) {
            return Integer.MAX_VALUE;
        } else {
            System.out.println(index + " : " + currentCost);
            return Math.min(naiveMinCostClimbingStairs(cost, index + 1, currentCost + cost[index]),
                    naiveMinCostClimbingStairs(cost, index + 2, currentCost + cost[index]));
        }
    }
}