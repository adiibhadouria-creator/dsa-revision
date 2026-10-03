/*
 * Insert into a Binary Search Tree
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: BST > Medium
 * Time complexity: O(logN)
 * Space complexity: O(1)
 * Solved: 2026-10-03
 * URL: https://leetcode.com/problems/insert-into-a-binary-search-tree/submissions/2160628394/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null) return node;
            TreeNode curr = root;
            while(curr!=null){
                if(val<curr.val){
                    if(curr.left==null) {
                        curr.left = node;
                        break;
                    }
                    curr = curr.left;
                    
                } 
                else{
                    if(curr.right==null) {
                        curr.right = node;
                        break;
                    }

                    curr = curr.right;
                }
            }
           
        return root;
    }
}
