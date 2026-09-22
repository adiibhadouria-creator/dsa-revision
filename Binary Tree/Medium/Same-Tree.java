/*
 * Same Tree
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Medium
 * Time complexity: O(N)
 * Space complexity: O(H)
 * Solved: 2026-09-22
 * URL: https://leetcode.com/problems/same-tree/submissions/2149783808/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p!=null && q==null || p==null && q!=null || p.val!=q.val) return false;
        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);
        return  left&&right;
    }
}
