package com.algo.lc.arraysandstrings.prefixsum;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 * >>>>>>>>>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 * Example 2:
 * >>>>>>>>>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 *  1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 */
public class SubarraySumEqualsK {

    // { Brute force approach - Time : O(N^3)
    public static int subarraySumBFON3(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j =  i + 1; j <= nums.length; j++) {
                int sum = 0;
                for (int s = i; s < j; ++s) {
                    sum += nums[s];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static List<int[]> subarrayListSumBFON3(int[] nums, int k) {
        //int count = 0;
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j =  i + 1; j <= nums.length; j++) {
                int sum = 0;
                for (int s = i; s < j; ++s) {
                    sum += nums[s];
                }
                if (sum == k) {
                    //result.add(new int[]{i, j});
                    result.add(Arrays.copyOfRange(nums, i, j));
                }
            }
        }
        return result;
    }
    // }

    // { Using cumulative sum -- Time O(N^2) -- Space O(N)
    public static int subarraySumBFON2(int[] nums, int k) {
        int count = 0;
        int [] sum =  new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // Using cumulative sum -- Time O(N^2) , Space O(N)
    public static List<int[]> subarrayListSumBFON2(int[] nums, int k) {
        List<int[]> result = new ArrayList<>();
        int [] sum =  new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[j] - sum[i] == k) {
                    result.add(Arrays.copyOfRange(nums, i, j));
                }
            }
        }
        return result;
    }
    // }

    // { Using cumulative sum -- Time O(N^2) -- Space O(1)
    public static int subarraySumON2(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // Using cumulative sum -- Time O(N^2), space O(1)
    public static List<int[]> subarrayListSumON2(int[] nums, int k) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result.add(Arrays.copyOfRange(nums, i, j + 1));
                }
            }
        }
        return result;
    }
    // }

    // { Using cumulative sum -- Time O(N) -- Space O(N)
    public static int subarraySumON(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> prefSumToCount = new HashMap<>();
        prefSumToCount.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefSumToCount.containsKey(sum - k)) {
                count += prefSumToCount.get(sum - k);
            }
            prefSumToCount.put(sum, prefSumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // Using cumulative sum -- Time O(N), space O(N)
    public static List<int[]> subarrayListSumON(int[] nums, int k) {
        List<int[]> result = new ArrayList<>();
        int sum = 0;
        Map<Integer, List<Integer>> prefSumToCount = new HashMap<>();
        List<Integer> initial = new ArrayList<>();
        initial.add(-1);
        prefSumToCount.put(0, initial);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefSumToCount.containsKey(sum - k)) {
                int endIdx = i;
                prefSumToCount.get(sum - k).forEach(startIdx -> {
                    result.add(Arrays.copyOfRange(nums, startIdx+1, endIdx + 1));
                });
            }
            if (!prefSumToCount.containsKey(sum)) {
                prefSumToCount.put(sum, new ArrayList<>());
            }
            prefSumToCount.get(sum).add(i);
        }
        return result;
    }
    // }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 4, 7, 2, -3, 1, 4, 2, 1};
        System.out.println("Original array : " + Arrays.toString(nums));
        int k = 7;
        System.out.println("subarraySumBFON3() and subarrayListSumBFON3() ---->");
        System.out.println("Total count : " + subarraySumBFON3(nums, k));
        System.out.println("Total count : " + subarrayListSumBFON3(nums, k).size());
        for (var subarray : subarrayListSumBFON3(nums, k)) {
            System.out.println(Arrays.toString(subarray));
        }
        System.out.println("subarraySumBFON3() and subarrayListSumBFON3() ----> DONE.");

        System.out.println("subarraySumBFON2() and subarrayListSumBFON2() ---->");
        System.out.println("Total count : " + subarraySumBFON2(nums, k));
        for (var subarray : subarrayListSumBFON2(nums, k)) {
            System.out.println(Arrays.toString(subarray));
        }
        System.out.println("subarraySumBFON2() and subarrayListSumBFON2() ----> DONE.");

        for (var subarray : subarrayListSumON2(nums, k)) {
            System.out.println(Arrays.toString(subarray));
        }

        System.out.println("subarraySumON() and subarrayListSumON() ---->");
        System.out.println("Total count : " + subarraySumON(nums, k));
        System.out.println("Total count : " + subarrayListSumON(nums, k).size());
        for (var subarray : subarrayListSumON(nums, k)) {
            System.out.println(Arrays.toString(subarray));
        }
        System.out.println("subarraySumON() and subarrayListSumON() ----> DONE.");
    }
}
