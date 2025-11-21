package com.algo.lc.arraysandstrings.prefixsum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SubarraySumEqualsKTest {
    int[] nums = new int[] {3, 4, 7, 2, -3, 1, 4, 2, 1};
    int k = 7;
    List<int[]> expected = List.of(
            //new int[] {7},
            new int[] {3, 4},
            new int[] {7},
            new int[] {7, 2, -3, 1},
            new int[] {2, -3, 1, 4, 2, 1},
            new int[] {1, 4, 2},
            new int[] {4, 2, 1}
    );

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void subarraySumBFON3() {
        int count = SubarraySumEqualsK.subarraySumBFON3(nums, k);
        assertEquals(6, count);
    }

    @Test
    void subarrayListSumBFON3() {
        List<int[]> result = SubarraySumEqualsK.subarrayListSumBFON3(nums, k);
        assertNotNull(result);
        assertEquals(6, result.size());
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    void subarraySumBFON2() {
        int count = SubarraySumEqualsK.subarraySumBFON2(nums, k);
        assertEquals(6, count);
    }

    @Test
    void subarrayListSumBFON2() {
        List<int[]> result = SubarraySumEqualsK.subarrayListSumBFON2(nums, k);
        assertNotNull(result);
        assertEquals(6, result.size());
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    void subarraySumON2() {
        int count = SubarraySumEqualsK.subarraySumON2(nums, k);
        assertEquals(6, count);
    }

    @Test
    void subarrayListSumON2() {
        List<int[]> result = SubarraySumEqualsK.subarrayListSumON2(nums, k);
        assertNotNull(result);
        assertEquals(6, result.size());
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    void subarraySumON() {
        int count = SubarraySumEqualsK.subarraySumON(nums, k);
        assertEquals(6, count);
    }

    @Test
    void subarrayListSumON() {
        List<int[]> result = SubarraySumEqualsK.subarrayListSumON(nums, k);
        assertNotNull(result);
        assertEquals(6, result.size());
        result.forEach(resultArray -> {
            assertTrue(containsArrayByContent(expected, resultArray));
        });
    }

    private static boolean containsArrayByContent(List<int[]> list, int[] target) {
        for (int[] listItem : list) {
            // Use Arrays.equals to compare the contents of the arrays
            if (Arrays.equals(listItem, target)) {
                return true;
            }
        }
        return false;
    }
}