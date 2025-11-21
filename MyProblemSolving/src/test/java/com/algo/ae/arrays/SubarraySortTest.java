package com.algo.ae.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarraySortTest {
    int [] arr1 = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
    int [] arr2 = {1, 2, 4, 6, 7, 7, 7, 10, 11, 12, 16, 18, 19};
    int [] arr3 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    @Test
    void subarraySort() {
        int[] output = SubarraySort.subarraySort(arr1);
        assertEquals(2, output.length);
        assertEquals(3, output[0]);
        assertEquals(9, output[1]);

        output = SubarraySort.subarraySort(arr2);
        assertEquals(2, output.length);
        assertEquals(-1, output[0]);
        assertEquals(-1, output[1]);

        output = SubarraySort.subarraySort(arr3);
        assertEquals(2, output.length);
        assertEquals(0, output[0]);
        assertEquals(9, output[1]);
    }

    @Test
    void subarraySortE() {
        int[] output = SubarraySort.subarraySortE(arr1);
        assertEquals(2, output.length);
        assertEquals(3, output[0]);
        assertEquals(9, output[1]);

        output = SubarraySort.subarraySortE(arr2);
        assertEquals(2, output.length);
        assertEquals(-1, output[0]);
        assertEquals(-1, output[1]);

        output = SubarraySort.subarraySortE(arr3);
        assertEquals(2, output.length);
        assertEquals(0, output[0]);
        assertEquals(9, output[1]);
    }
}