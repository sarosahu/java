package com.algo.lc.arraysandstrings.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. Subarray Sums Divisible by K
 *
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,0,-2,-3,1], k = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * Example 2:
 *
 * Input: nums = [5], k = 9
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * 2 <= k <= 10^4
 */
public class SubarrayDivByK {
    public static int subarrayDivByK(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> modCounts = new HashMap<>();
        modCounts.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int prefixMod = sum % k;
            //System.out.println("prefixMod: " + prefixMod);
            prefixMod = prefixMod < 0 ? prefixMod + k : prefixMod;
            if (modCounts.containsKey(prefixMod)) {
                result += modCounts.get(prefixMod);
            }
            modCounts.put(prefixMod, modCounts.getOrDefault(prefixMod, 0) + 1);
        }
        return result;
    }

    public static int subarraysDivByK2(int[] nums, int k) {
        int result = 0;

        int[] modGroups = new int[k];
        int sum = 0;
        modGroups[0] = 1;
        for (int num : nums) {
            sum += num;
            int prefixMod = sum % k;
            prefixMod = prefixMod < 0 ? prefixMod + k : prefixMod;
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] nums = {-1, 2, 9};
        //int k = 2;
        //int[] nums = {-2, -3, 1, 4};
        //int k = 5;
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarrayDivByK(nums, k));
        System.out.println(subarraysDivByK2(nums, k));
    }

}
