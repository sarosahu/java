package com.algo.lc.treegraphs.bintree.pathsum;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II (https://leetcode.com/problems/path-sum-ii/description/)
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 *
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 */
public class PathSum2 {
    private int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathList = new ArrayList<>();
        if (root == null) {
            return pathList;
        }
        this.targetSum = targetSum;
        List<Integer> pathNodes = new ArrayList<>();
        pathNodes.add(root.val);
        pathSumHelper(root, root.val, pathNodes, pathList);
        return pathList;
    }

    private void pathSumHelper(TreeNode currNode,
                               int runningSum,
                               List<Integer> pathNodes,
                               List<List<Integer>> pathList) {
        if (currNode == null) {
            return;
        }
        if (currNode.left == null && currNode.right == null) {
            if (runningSum == targetSum) {
                pathList.add(new ArrayList<>(pathNodes));
            }
        } else {
            if (currNode.left != null) {
                pathNodes.add(currNode.left.val);
                pathSumHelper(currNode.left, runningSum + currNode.left.val, pathNodes, pathList);
            }
            if (currNode.right != null) {
                pathNodes.add(currNode.right.val);
                pathSumHelper(currNode.right, runningSum + currNode.right.val, pathNodes, pathList);
            }
        }
        // Done with left and right child of root
        pathNodes.removeLast();
    }
}
