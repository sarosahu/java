package com.algo.lc.arraysandstrings.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
    public static int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;
        int longestSubarrayLen = 0;
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];

            // Check if all the numbers seen so far sum to k.
            if (prefixSum == k) {
                longestSubarrayLen = i + 1;
            }

            // If any subarray seen so far sums to k, then
            // update the length of the longest subarray
            if (indices.containsKey(prefixSum - k)) {
                longestSubarrayLen = Math.max(longestSubarrayLen, i - indices.get(prefixSum - k));
            }

            // Only add the {current prefix_sum, index} pair to the
            // map if the prefix_sum is not already in the map.
            if (!indices.containsKey(prefixSum)) {
                indices.put(prefixSum, i);
            }
        }

        return longestSubarrayLen;
    }

    public static void main(String[] args) {
        int [] nums = {1,-1,5,-2,3};
        int k = 3;
        int maxSubArrayLen = maxSubArrayLen(nums, k);
        System.out.println("maxSubArrayLen : " + maxSubArrayLen);
    }
}
