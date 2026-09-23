/*
 * Symmetric Tree
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Medium
 * Time complexity: O(N)
 * Space complexity: O(N)
 * Solved: 2026-09-23
 * URL: https://leetcode.com/problems/symmetric-tree/submissions/2151388962/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * break this problem into same tree and it is simple
just check if either of them is null then both have to be null else return false
and rest code is self explanatory and remember to use both left and right for the answer
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left ,root.right);
    }
    public boolean check(TreeNode p, TreeNode q){
        if(p==null || q==null){
            return p==q;
        }
        if(p.val!=q.val) return false;

        boolean left = check(p.left,q.right);
        boolean right = check(p.right,q.left); 
        return left&&right;
    }
}
