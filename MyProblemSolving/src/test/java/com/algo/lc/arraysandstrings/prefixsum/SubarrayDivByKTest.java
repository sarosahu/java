package com.algo.lc.arraysandstrings.prefixsum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarrayDivByKTest {
    private final int [] nums = {4, 5, 0, -2, -3, 1};
    private final int k = 5;

    private final int[] nums2 = {-1, 2, 9};
    private final int k2 = 2;

    @Test
    void subarrayDivByK() {
        int count = SubarrayDivByK.subarrayDivByK(nums, k);
        assertEquals(7, count);

        count = SubarrayDivByK.subarrayDivByK(nums2, k2);
        assertEquals(2, count);
    }

    @Test
    void subarraysDivByK2() {
        int count = SubarrayDivByK.subarraysDivByK2(nums, k);
        assertEquals(7, count);

        count = SubarrayDivByK.subarraysDivByK2(nums2, k2);
        assertEquals(2, count);
    }
}