/*
 * Kth Smallest Element in a BST
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: BST > Medium
 * Time complexity: O(n)
 * Space complexity: O(h)
 * Solved: 2026-10-03
 * URL: https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/2160685985/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    int count =0;
    int ans =0;
    void inorder(TreeNode root,int k){
        if(root==null) return;

        inorder(root.left,k);
        count++;
         if(count==k) {
            ans = root.val;
            return;
        }
        inorder(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;

    }
}
