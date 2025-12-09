package com.algo.lc.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * E.g. 1
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 */
public class TrappingRainWater {
    public static int trapBF(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            // Find the left max i.e. from index i till left end
            int leftMax = 0;
            for (int j = i; j >= 0; --j) {
                leftMax = Math.max(leftMax, height[j]);
            }
            // Find the right max i.e. from index i till right end
            int rightMax = 0;
            for (int j = i; j < height.length; ++j) {
                rightMax = Math.max(rightMax, height[j]);
            }
            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }

    // DP approach -- we can create 2 new arrays leftMax[] and rightMax[]
    // leftMax[i] --> stores the maximum value present left to the index i
    // rightMax[i] --> stores the maximum value present right to the index i
    public static int trapDP(int[] height) {
        int area = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 1; i < height.length; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length; ++i) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (height[i] < minHeight) {
                area += minHeight - height[i];
            }
        }
        return area;
    }

    // Using stack approach
    public static int trapStk(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        int idx = 0;
        while (idx < height.length) {
            // Monotonic decreasing stack
            while (!stack.isEmpty() && height[stack.peek()] < height[idx]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    continue;
                }
                int dist = idx - stack.peek() - 1;
                int boundedHeight = Math.min(height[idx], height[stack.peek()]) - height[top];
                ans += dist * boundedHeight;
            }
            stack.push(idx++);
        }
        return ans;
    }

    // Using 2 pointer approach
    public static int trap2P(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int area = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Brute force approach : " + trapBF(height));
        System.out.println("Brute force approach : " + trapDP(height));
        System.out.println("Brute force approach : " + trapStk(height));
        System.out.println("Brute force approach : " + trap2P(height));
    }
}
