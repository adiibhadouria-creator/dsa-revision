/*
 * Search in a Binary Search Tree
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: BST > Basics
 * Time complexity: O(logN)
 * Space complexity: O(h)
 * Solved: 2026-10-03
 * URL: https://leetcode.com/problems/search-in-a-binary-search-tree/submissions/2160609746/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root ==null) return null;
        if(root.val==val) return root;
        else if(val>root.val){
            return searchBST(root.right,val);
        }
        else{
           return searchBST(root.left,val);
        } 
    }
}
