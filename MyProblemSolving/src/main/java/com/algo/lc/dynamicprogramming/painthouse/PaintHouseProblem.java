package com.algo.lc.dynamicprogramming.painthouse;

/**
 * 256. Paint House
 *
 * There is a row of n houses, where each house can be painted one of three colors:
 * red, blue, or green. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
 *
 * For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the
 * cost of painting house 1 with color green, and so on...
 * Return the minimum cost to paint all houses.
 *
 *
 * Example 1:
 *
 * Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 * Minimum cost: 2 + 5 + 3 = 10.
 *
 * Example 2:
 *
 * Input: costs = [[7,6,2]]
 * Output: 2
 *
 *
 * Constraints:
 *
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 */
public class PaintHouseProblem {
    private int[][] costs;

    // { Time O(2 ^ N), space : O(N)
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        this.costs = costs;
        return Math.min(
                paintCost(0, 0),
                Math.min(paintCost(0, 1), paintCost(0, 2))
        );
    }

    private int paintCost(int n, int color) {
        int totalCost = costs[n][color];
        if (n == costs.length - 1) {
            return totalCost;
        }
        if (color == 0) { // Red
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
        } else if (color == 1) { // Green
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
        } else { // Blue
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
        }
        return totalCost;
    }
    // }

    // { Time O(N), space : O(N)
    public int minCostE(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        this.costs = costs;
        int[][] memo = new int[costs.length][costs[0].length];
        return Math.min(
                paintCost(0, 0, memo),
                Math.min(paintCost(0, 1, memo), paintCost(0, 2, memo))
        );
    }

    private int paintCost(int n, int color, int[][] memo) {
        if (memo[n][color] > 0) {
            return memo[n][color];
        }
        int totalCost = costs[n][color];
        if (n == costs.length - 1) {
            return totalCost;
        }
        if (color == 0) { // Red
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
        } else if (color == 1) { // Green
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
        } else { // Blue
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
        }
        return memo[n][color] = totalCost;
    }
    // }

    // {
    public int minCostDP(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][costs[0].length];
        System.arraycopy(costs[0], 0, dp[0], 0, 3);
        for (int i = 1; i < n; ++i) {
            for (int color = 0; color < 3; ++color) {
                if (color == 0) {
                    dp[i][color] = costs[i][color] + Math.min(dp[i-1][color + 1], dp[i-1][color + 2]);
                } else if (color == 1) {
                    dp[i][color] = costs[i][color] + Math.min(dp[i-1][color - 1], dp[i-1][color + 1]);
                } else {
                    dp[i][color] = costs[i][color] + Math.min(dp[i-1][color - 1], dp[i-1][color - 2]);
                }
            }
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
    // }

    public int minCostDP2(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        int[] prev = costs[0];
        for (int i = 1; i < costs.length; ++i) {
            int[] curr = costs[i].clone();
            curr[0] += Math.min(prev[1], prev[2]);
            curr[1] += Math.min(prev[0], prev[2]);
            curr[2] += Math.min(prev[0], prev[1]);
            prev = curr;
        }

        return Math.min(prev[0], Math.min(prev[1], prev[2]));
    }
}
