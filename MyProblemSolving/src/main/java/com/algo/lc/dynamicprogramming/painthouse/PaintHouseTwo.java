package com.algo.lc.dynamicprogramming.painthouse;

import java.util.HashMap;
import java.util.Map;

/**
 * 265. Paint House II
 *
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different. You have to paint
 * all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by an n x k cost matrix costs.
 *
 * For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of
 * painting house 1 with color 2, and so on...
 *
 * Return the minimum cost to paint all houses.
 *
 *
 *
 * Example 1:
 *
 * Input: costs = [[1,5,3],[2,9,4]]
 * Output: 5
 * Explanation:
 * Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 * Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 *
 *
 * Example 2:
 *
 * Input: costs = [[1,3],[2,4]]
 * Output: 5
 */
public class PaintHouseTwo {
    private int n;
    private int k;
    private int[][] costs;
    private Map<String, Integer> memo;
    // { Recursive approach - Time: O(n.k.k), space : O(n.k)
    public int minCostIIR(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        this.k = costs[0].length;
        this.n = costs.length;
        this.costs = costs;
        this.memo = new HashMap<>();
        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < k; ++color) {
            minCost = Math.min(minCost, memoSolve(0, color));
        }
        return minCost;
    }

    private int memoSolve(int houseNum, int color) {
        // Base case
        if (houseNum == n - 1) {
            return costs[houseNum][color];
        }

        // Memoization lookup case:
        if (memo.containsKey(getKey(houseNum, color))) {
            return memo.get(getKey(houseNum, color));
        }

        // Recursive case:
        int minRemainingCost = Integer.MAX_VALUE;
        for (int nextColor = 0; nextColor < k; ++nextColor) {
            if (color == nextColor) {
                continue;
            }
            int currRemainingCost = memoSolve(houseNum + 1, nextColor);
            minRemainingCost = Math.min(minRemainingCost, currRemainingCost);
        }
        int totalCost = costs[houseNum][color] + minRemainingCost;
        memo.put(getKey(houseNum, color), totalCost);

        return totalCost;
    }

    private String getKey(int n, int color) {
        return String.valueOf(n) + " " + String.valueOf(color);
    }
    // } Recursive approach

    // DP approach - time: O(n.k.k), space: O(k)
    public int minCost2DP1(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int k = costs[0].length;
        int n = costs.length;

        int[] prev = costs[0];

        for (int h = 1; h < n; ++h) {
            int[] curr = new int[k];
            for (int c = 0; c < k; ++c) {
                int min = Integer.MAX_VALUE;
                for (int prevColor = 0; prevColor < k; ++prevColor) {
                    if (c == prevColor) {
                        continue;
                    }
                    min = Math.min(min, prev[prevColor]);
                }
                curr[c] += min + costs[h][c];
            }
            prev = curr;
        }
        // Find teh min in the last row.
        int min = Integer.MAX_VALUE;
        for (int c : prev) {
            min = Math.min(min, c);
        }
        return min;
    }

    // DP approach - time: O(n.k), space: O(k)
    public int minCost2DPO1(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int k = costs[0].length;
        int n = costs.length;

        int [] prev = costs[0].clone();

        for (int h = 1; h < n; ++h) {
            // Find the min & second min color in the prev. row
            int minColorIdx = -1, secondMinColorIdx = -1;
            for (int c = 0; c < k; ++c) {
                int cost = prev[c];
                if (minColorIdx == -1 || cost < prev[minColorIdx]) {
                    secondMinColorIdx = minColorIdx;
                    minColorIdx = c;
                } else if (secondMinColorIdx == -1 || cost < prev[secondMinColorIdx]) {
                    secondMinColorIdx = c;
                }
            }

            int[] curr = new int[k];
            // And now calculate the new costs for the current row
            for (int c = 0; c < k; ++c) {
                curr[c] = costs[h][c];
                int prevMinIdx = c == minColorIdx ? secondMinColorIdx : minColorIdx;
                curr[c] += prev[prevMinIdx];
            }
            prev = curr;
        }

        // Find the min in the last row.
        int min = Integer.MAX_VALUE;
        for (int c : prev) {
            min = Math.min(min, c);
        }
        return min;
    }

    // DP approach - time: O(n.k), space: O(1)
    public int minCost2DPO2(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int k = costs[0].length;
        int n = costs.length;

        // First we need to determine the 2 lowest costs of first row
        // also remember the color of the lowest
        int prevMin = -1, prevSecondMin = -1, prevMinColor = -1;
        for (int color = 0; color < k; ++color) {
            int cost = costs[0][color];
            if (prevMin == -1 || cost < prevMin) {
                prevSecondMin = prevMin;
                prevMin = cost;
                prevMinColor = color;
            } else if (prevSecondMin == -1 || cost < prevSecondMin) {
                prevSecondMin = cost;
            }
        }

        // And now, we need to work our way down, keeping track of the minimum
        for (int h = 1; h < n; ++h) {
            // Find the min & second min color in the prev. row
            int min = -1, secondMin = -1, minColor = -1;
            for (int c = 0; c < k; ++c) {
                int cost = costs[h][c];
                if (c == prevMinColor) {
                    cost += prevSecondMin;
                } else {
                    cost += prevMin;
                }

                if (min == -1 || cost < min) {
                    secondMin = min;
                    min = cost;
                    minColor = c;
                } else if (secondMin == -1 || cost < secondMin) {
                    secondMin = cost;
                }
            }

            // Transfer the current mins to the prev mins
            prevMin = min;
            prevSecondMin = secondMin;
            prevMinColor = minColor;
        }
        return prevMin;
    }

    public static void main(String[] args) {
        PaintHouseTwo p = new PaintHouseTwo();
        int[][] costs = new int[][]{
                {10, 6, 16, 25, 7, 28},
                {7, 16, 18, 30, 16, 25},
                {8, 26, 6, 22, 26, 19},
                {10, 23, 14, 17, 23, 9},
                {12, 14, 27, 7, 8, 9}
        };
        System.out.println(p.minCostIIR(costs));
        System.out.println(p.minCost2DP1(costs));
        System.out.println(p.minCost2DPO1(costs));
        System.out.println(p.minCost2DPO2(costs));
    }
}
