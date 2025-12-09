package com.algo.lc.dynamicprogramming;

import com.algo.lc.dynamicprogramming.painthouse.PaintHouseProblem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaintHouseProblemTest {
    private int[][] costs = {
            {17, 2, 17},
            {8, 4, 10},
            {6, 3, 19},
            {4, 8, 12},
    };

    @Test
    void minCost() {
        PaintHouseProblem p = new PaintHouseProblem();
        int result = p.minCost(costs);
        assertEquals(17, result);
    }

    @Test
    void minCostE() {
        PaintHouseProblem p = new PaintHouseProblem();
        int result = p.minCostE(costs);
        assertEquals(17, result);
    }

    @Test
    void minCostDP() {
        PaintHouseProblem p = new PaintHouseProblem();
        int result = p.minCostDP(costs);
        assertEquals(17, result);
    }

    @Test
    void minCostDP2() {
        PaintHouseProblem p = new PaintHouseProblem();
        int result = p.minCostDP2(costs);
        assertEquals(17, result);
    }
}