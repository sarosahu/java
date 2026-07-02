package com.algo.lc.treegraphs.bintree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2583. Kth Largest Sum in a Binary Tree (https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/)
 *
 *  You are given the root of a binary tree and a positive integer k.
 *
 * The level sum in the tree is the sum of the values of the nodes that are on the same level.
 *
 * Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.
 *
 * Note that two nodes are on the same level if they have the same distance from the root.
 *
 * Example 1:
 * Input: root = [5,8,9,2,1,3,7,4,6], k = 2
 * Output: 13
 * Explanation: The level sums are the following:
 * - Level 1: 5.
 * - Level 2: 8 + 9 = 17.
 * - Level 3: 2 + 1 + 3 + 7 = 13.
 * - Level 4: 4 + 6 = 10.
 * The 2nd largest level sum is 13.
 *
 * Example 2:
 * Input: root = [1,2,null,3], k = 1
 * Output: 3
 * Explanation: The largest level sum is 3.
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 2 <= n <= 10^5
 * 1 <= Node.val <= 10^6
 * 1 <= k <= n
 */
public class KthLargestSum {
    // Max Heap approach, time: O((N+K).logN)
    public long kthLargestLevelSumMaxHeap(TreeNode root, int k) {
        // max-heap
        Queue<Long> pq = new PriorityQueue<>(
                Collections.reverseOrder()
        );

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            // Level order traversal
            int sz = bfsQueue.size();
            long sum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode curr = bfsQueue.remove();
                sum += curr.val;
                if (curr.left != null) {
                    bfsQueue.add(curr.left);
                }
                if (curr.right != null) {
                    bfsQueue.add(curr.right);
                }
            }
            pq.add(sum);
        }
        if (pq.size() < k) {
            return -1;
        }
        for (int i = 0; i < k - 1; i++) {
            pq.remove();
        }
        return pq.peek();
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        return kthLargestLevelSumMinHeap(root, k);
    }

    // Min Heap approach, time: O(N.logK)
    public long kthLargestLevelSumMinHeap(TreeNode root, int k) {
        // min-heap
        Queue<Long> pq = new PriorityQueue<>();

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            // Level order traversal
            int sz = bfsQueue.size();
            long sum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode curr = bfsQueue.remove();
                sum += curr.val;
                if (curr.left != null) {
                    bfsQueue.add(curr.left);
                }
                if (curr.right != null) {
                    bfsQueue.add(curr.right);
                }
            }
            pq.add(sum);
            if (pq.size() > k) {
                // Evict top element
                pq.remove();
            }
        }
        if (pq.size() < k) {
            return -1;
        }
        return pq.peek();
    }
}
