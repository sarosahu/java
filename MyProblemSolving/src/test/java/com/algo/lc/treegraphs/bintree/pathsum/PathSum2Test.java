package com.algo.lc.treegraphs.bintree.pathsum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathSum2Test {

    TreeNode root;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void pathSum() {
        Integer[] nums = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        root = createBinTree(nums);
        List<List<Integer>> res  = new PathSum2().pathSum(root, 22);
        assertEquals(2, res.size());
        Integer[] actual1 = new Integer[]{5, 4, 11, 2};
        assertArrayEquals(res.get(0).toArray(new Integer[0]), actual1);
        Integer[] actual2 = new Integer[]{5, 8, 4, 5};
        assertArrayEquals(res.get(1).toArray(new Integer[0]), actual2);
    }

    private TreeNode createBinTree(Integer[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode[]  nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = nums[i] == null ? null : new TreeNode(nums[i]);
        }
        int nullCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nodes[i] == null) {
                nullCount++;
                continue;
            }
            int leftChildIdx = 2 * i + 1 - (nullCount * 2);
            if (leftChildIdx < nums.length) {
                nodes[i].left = nodes[leftChildIdx];
            }
            int rightChildIdx = 2 * i + 2 - (nullCount * 2);
            if (rightChildIdx < nums.length) {
                nodes[i].right = nodes[rightChildIdx];
            }
        }
        return nodes[0];
    }
}